package JOUR02;

import java.time.LocalDate;

public class VehicleManagement {
}

abstract class Vehicle {
    private String brand;
    private LocalDate purchaseDate;
    private double purchasePrice;
    private double currentPrice;

    public Vehicle(String brand, LocalDate purchaseDate, double purchasePrice) {
        this.brand = brand;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
    }

    public void printVehicle() {
        System.out.println("Brand : " + this.brand);
        System.out.println("Purchase date : " + this.purchaseDate);
        System.out.println("Purchase price : " + this.purchasePrice);
    }

    public void calculateCurrentPrice(int currentYear) {
        this.currentPrice =
                this.purchasePrice - (this.purchasePrice * (currentYear - this.purchaseDate.getYear()) / 100.0);
    }

    String getBrand() {
        return this.brand;
    }

    LocalDate getPurchaseDate() {
        return this.purchaseDate;
    }

    double getPurchasePrice() {
        return this.purchasePrice;
    }

    double getCurrentPrice() {
        return this.currentPrice;
    }

    void setBrand(String newBrand) {
        this.brand = newBrand;
    }

    void setPurchaseDate(LocalDate newPurchaseDate) {
        this.purchaseDate = newPurchaseDate;
    }

    void setPurchasePrice(double newPurchasePrice) {
        this.purchasePrice = newPurchasePrice;
    }

    void setCurrentPrice(double newCurrentPrice) {
        this.currentPrice = newCurrentPrice;
    }
}

class Car extends Vehicle {
    private int cubicCapacity;
    private int numberOfDoors;
    private int carPower;
    private double mileage;

    public Car(String brand, LocalDate purchaseDate, double purchasePrice, int cubicCapacity, int numberOfDoors, int carPower, double mileage) {
        super(brand, purchaseDate, purchasePrice);
        this.cubicCapacity = cubicCapacity;
        this.numberOfDoors = numberOfDoors;
        this.carPower = carPower;
        this.mileage = mileage;
    }

    public void printCar() {
        super.printVehicle();
        System.out.println("Cubic capacity : " + this.cubicCapacity);
        System.out.println("Number of doors : " + this.numberOfDoors);
        System.out.println("Car power : " + this.carPower);
        System.out.println("Mileage : " + this.mileage);
    }

    public void calculateCurrentPrice(int currentYear) {
        // 2% per years
        double yearsDepreciationPercent = 2 * (currentYear - this.getPurchaseDate().getYear());

        // 5% per 10000km
        double mileageDepreciationPercent = 5 * ((int) Math.round(this.getMileage() / 10000.0));

        // % by brand
        double brandDepreciationPercent;

        if (this.getBrand().equals("Renault") || this.getBrand().equals("Fiat")) {
            brandDepreciationPercent = 10;
        } else if (this.getBrand().equals("Ferrari") || this.getBrand().equals("Porsche")) {
            brandDepreciationPercent = 20;
        } else {
            brandDepreciationPercent = 0;
        }

        double totalDepreciationPercent =
                yearsDepreciationPercent + mileageDepreciationPercent + brandDepreciationPercent;

        double currentPrice = this.getPurchasePrice() * (1 - totalDepreciationPercent / 100.0);

        if (currentPrice < 0) {
            currentPrice = 0;
        }

        this.setCurrentPrice(currentPrice);
    }

    int getCubicCapacity() {
        return this.cubicCapacity;
    }

    int getNumberOfDoors() {
        return this.numberOfDoors;
    }

    int getCarPower() {
        return this.carPower;
    }

    double getMileage() {
        return this.mileage;
    }

    void setCubicCapacity(int newCubicCapacity) {
        this.cubicCapacity = newCubicCapacity;
    }

    void setNumberOfDoors(int newNumberOfDoors) {
        this.numberOfDoors = newNumberOfDoors;
    }

    void setCarPower(int newCarPower) {
        this.carPower = newCarPower;
    }

    void setMileage(int newMileage) {
        this.mileage = newMileage;
    }
}

class Airplane extends Vehicle {
    public enum MotorType {
        PROPELLER,
        JET;
    }
    private MotorType motor;
    private int numberFlightHour;

    public Airplane(String brand, LocalDate purchaseDate, double purchasePrice, MotorType motor, int numberFlightHour) {
        super(brand, purchaseDate, purchasePrice);
        this.motor = motor;
        this.numberFlightHour = numberFlightHour;
    }

    public void printAirplane() {
        super.printVehicle();
        System.out.println("Motor : " + this.motor);
        System.out.println("Number of flight hour : " + this.numberFlightHour);
    }

    @Override
    public void calculateCurrentPrice(int currentYear){
        if (this.motor == MotorType.PROPELLER) {  // compare the memory address
            // number of 100-hour blocks, rounded to the nearest integer
            int blocks = (int) Math.round(numberFlightHour / 100.0);

            // depreciation percentage = 10% per block
            double depreciationPercent = blocks * 10.0;

            // calculate current price after depreciation
            double currentPrice = this.getPurchasePrice() * (1 - depreciationPercent / 100.0);

            // Make sure the current price doesn't go below zero
            if (currentPrice < 0) {
                currentPrice = 0;
            }

            this.setCurrentPrice(currentPrice);
        } else {
            int blocks = (int) Math.round(numberFlightHour / 1000.0);

            double depreciationPercent = blocks * 10.0;

            double currentPrice = this.getPurchasePrice() * (1 - depreciationPercent / 100.0);

            if (currentPrice < 0) {
                currentPrice = 0;
            }

            this.setCurrentPrice(currentPrice);
        }
    }

    MotorType getMotor() {
        return this.motor;
    }

    int getNumberFlightHour() {
        return this.numberFlightHour;
    }

    void setMotor(MotorType newMotor) {
        this.motor = newMotor;
    }

    void setNumberFlightHour(int newNumberFlightHour) {
        this.numberFlightHour = newNumberFlightHour;
    }
}


