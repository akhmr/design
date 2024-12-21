package com.design.strategy;

public class DebitCardStratgey implements  PaymentStrategy{
    @Override
    public void pay(int amount) {
        System.out.println("Debit card payment done "+amount);
    }
}
