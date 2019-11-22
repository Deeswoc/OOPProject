package com.Squaa.RestaurantApp.DataLogic;

public interface OrderChangedListener {
    void onQuantityChanged(int subTotal, int newMaxTime);

}
