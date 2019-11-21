package com.thanhtran.thanh_tran_a1.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Thanh Tran
 */
public class PizzaOrder {

    private String[] toppings;
    private String size;
    private boolean delivery;

    public PizzaOrder() {
    }

    //get the price of the pizza
    public double getPrice() {

        double price = 0;
        //price = 0/2 + 5/7/9 + 1/2/3/4 
        if (this.delivery == true) {
            price += 2.00;
        }

        //if statements for this.size small = 5, medium =7 , large =9
        switch (size) {
            case "Small":
                price += 5.00;
                break;
            case "Medium":
                price += 7.00;
                break;
            case "Large":
                price += 9.00;
                break;
            default:
                System.out.println("no size was selected");
        }
        //null handler just in case no toppings were selected.
        //otherwise, just skip the loop
        if (this.toppings != null) {
            for (int i = 0; i < this.toppings.length; i++) {
                price += 1.00;
            }
        }

        // price for # of toppings selected
        return price;
    }

    public String[] getToppings() {
        return toppings;
    }

    public String getSize() {
        return size;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setToppings(String[] toppings) {
        this.toppings = toppings;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

}
