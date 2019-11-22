package com.Squaa.RestaurantApp.UI.CustomerMenuViews;

import com.Squaa.RestaurantApp.Controllers.AbstractOrderController;
import com.Squaa.RestaurantApp.DataLogic.IO.Recept;
import com.Squaa.RestaurantApp.DataLogic.Order;
import com.Squaa.RestaurantApp.DataLogic.TimeLogic.Stopwatch;
import com.Squaa.RestaurantApp.DataLogic.TimeLogic.TimeChangedListener;
import com.Squaa.RestaurantApp.DataLogic.TimeLogic.TimeFormatter;
import com.Squaa.RestaurantApp.DataLogic.TimeLogic.TimerListener;
import com.Squaa.RestaurantApp.UI.OrderTableModel;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrentOrderView extends JPanel {
    AbstractOrderController controller;
    CustomerOrderTable table;
    JButton makeOrder;
    JLabel remainingTime;
    JLabel totalCost;
    GridBagConstraints gc;
    Stopwatch remainingTimeStopwatch;
    CurrentOrderView(AbstractOrderController controller){
        controller.setCurrentOrderView(this);
        remainingTimeStopwatch = new Stopwatch();
        remainingTimeStopwatch.addTimeChangedListener(new TimeChangedListener() {
            @Override
            public void onChange(int sec) {
                setRemainingTime(sec);
            }
        });

        remainingTimeStopwatch.addTimerLister(new TimerListener() {
            @Override
            public void alarm() {
                remainingTime.setText("ORDER READY!!");
                play(100, 44);
            }
        });
        this.controller = controller;
        gc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        Order order = new Order();
        OrderTableModel orderModel  = new OrderTableModel(order);
        controller.addOrderTableModel(orderModel);
        table = new CustomerOrderTable(orderModel);
        remainingTime = new JLabel("00:00:00");
        totalCost = new JLabel("$00.00");
        makeOrder = new JButton("Place Order");
        gc.gridy = 0;
        add(new JScrollPane(table), gc);
        gc.gridy = 1;
        add(remainingTime, gc);
        gc.gridy = 2;
        add(totalCost, gc);
        gc.gridy = 3;
        add(makeOrder, gc);
        makeOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.startOrder(order);

            }
        });
    }

    public void setTotalCost(int totalCost){
        this.totalCost.setText("$"+totalCost);
    }

    public void startTimer(){
        remainingTimeStopwatch.startTimer();
    }

    public void play(int instrument, int note) {
        try {
            Sequencer player = MidiSystem.getSequencer();

            player.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4);

            Track track = seq.createTrack();

            //MidiEvent event = null;

            ShortMessage first = new ShortMessage();
            first.setMessage(192, 1, instrument, 0);
            MidiEvent changeInstrument = new MidiEvent(first, 1);
            track.add(changeInstrument);

            ShortMessage a = new ShortMessage();
            first.setMessage(144, 1, note, 100);
            MidiEvent NoteOn = new MidiEvent(a, 1);
            track.add(NoteOn);

            ShortMessage b= new ShortMessage();
            first.setMessage(128, 1, note, 100);
            MidiEvent NoteOff = new MidiEvent(b, 16);
            track.add(NoteOff);

            player.setSequence(seq);
            player.start();
        }catch(Exception ex){
            ex.getStackTrace();
        }

    }

    public void setRemainingTime(int remainingTime){
        this.remainingTime.setText(TimeFormatter.getHHMMSS(remainingTime));
        this.remainingTimeStopwatch.setTimeRemaining(remainingTime);
    }
}
