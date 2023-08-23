package org.kainos.ea.cli;

public class Contractor implements IPayable {
    private String name;

    public Contractor(String name, double dailyRate, int monthlyDaysWorked) {
        this.name = name;
        this.dailyRate = dailyRate;
        this.monthlyDaysWorked = monthlyDaysWorked;
    }

    private double dailyRate;

    public String getName() {
        return name;
    }

    public double calcPay(){
        return getDailyRate() * getMonthlyDaysWorked();
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public int getMonthlyDaysWorked() {
        return monthlyDaysWorked;
    }

    public void setMonthlyDaysWorked(int monthlyDaysWorked) {
        this.monthlyDaysWorked = monthlyDaysWorked;
    }

    private int monthlyDaysWorked;


}
