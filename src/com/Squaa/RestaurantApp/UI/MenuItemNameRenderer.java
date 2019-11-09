package com.Squaa.RestaurantApp.UI;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class MenuItemNameRenderer extends DefaultTableCellRenderer {
    Font font = new Font("Freestyle Script", Font.BOLD, 26);

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        setFont(font);
        return this;
    }
}
