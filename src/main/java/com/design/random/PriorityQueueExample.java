package com.design.random;

import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add elements to the PriorityQueue
        pq.add(10);
        pq.add(5);
        pq.add(20);
        pq.add(15);
        pq.add(11);
        pq.add(18);
        pq.add(25);
        pq.add(45);




        // Display the PriorityQueue
        System.out.println("Priority Queue: " + pq);

        // Retrieve and remove elements based on priority
        System.out.println("Polling elements:");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll()); // Removes and returns the smallest element
        }
    }
}
