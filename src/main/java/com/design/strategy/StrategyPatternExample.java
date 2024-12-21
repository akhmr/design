package com.design.strategy;

public class StrategyPatternExample {
    public static void main(String[] args) {
        Order order1 = new Order(100);
        order1.setPaymentStrategy(new DebitCardStratgey());

        order1.pay();

        Order order2 = new Order(200);
        order2.setPaymentStrategy(new CreditCardStragey());
        order2.pay();;

    }
}
