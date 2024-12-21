package com.design.strategy;

public class Order {

    private int amount;

    private PaymentStrategy paymentStrategy;

    public Order(int amount) {
        this.amount = amount;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void pay(){
        paymentStrategy.pay(amount);
    }


}
