package com.design.strategy;

public class CreditCardStragey implements  PaymentStrategy{
    @Override
    public void pay(int amount) {
        System.out.println("Credit card payment done "+amount);
    }
}

