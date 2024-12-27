package com.design.parkinglot;

import java.util.*;

public class ParkingLot {

    private Map<String,ParkingSlot> vehicleToSlotMap = new HashMap<>();
    private List<Terminal> entryTerminal;
    private List<Terminal> exitTerminals;

    private Map<Integer,List<ParkingSlot>> terminalToSlotMapping;
    private PaymentPolicy currentPricePolicy;

    private Map<Integer, PriorityQueue<ParkingSlot>> availableSpots = new HashMap<>();


    public void exit(Ticket ticket){
        ParkingSlot parkingSlot =vehicleToSlotMap.get(ticket.getVehicleNo());
        if( parkingSlot ==null){
            throw new RuntimeException("No vehicle parked with this number ");
        }

        PriorityQueue<ParkingSlot> parkingPriorityQueue =  availableSpots.get(parkingSlot.getTerminalId());
        parkingPriorityQueue.add(parkingSlot);
    }

    public void addSlot(Terminal terminal, ParkingSlot  parkingSlot) {

        availableSpots.putIfAbsent(terminal.getTerminalId(), new PriorityQueue<>(Comparator.comparingInt(ParkingSlot::getPriority)));

    }


    public ParkingSlot getParkingSlot(Terminal terminal,String vehicleNo) {
        ParkingSlot parkingSlot =null;
        Integer terminalId = terminal.getTerminalId();
        PriorityQueue<ParkingSlot> parkingPriorityQueue = availableSpots.get(terminalId);

        if (availableSpots.containsKey(terminalId) && !availableSpots.get(terminalId).isEmpty()) {
            parkingSlot = availableSpots.get(terminalId).poll(); // Remove and return the slot with the highest priority
        }
        if(parkingSlot != null ) {
            vehicleToSlotMap.put(vehicleNo, parkingSlot);
            return parkingSlot;
        }
        throw new RuntimeException("Taking lot is full ");
    }

}
