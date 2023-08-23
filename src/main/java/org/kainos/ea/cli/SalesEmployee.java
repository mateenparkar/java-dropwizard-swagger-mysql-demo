package org.kainos.ea.cli;

public class SalesEmployee extends Employee {
    private int employeeId;
    private String name;
    private double salary;

    public SalesEmployee(int employeeId, String name, double salary, double monthlySales, float commisionRate) {
        super(employeeId, name, salary);
        this.monthlySales = monthlySales;
        this.commisionRate = commisionRate;
    }

    @Override
    public double calcPay(){
        return getSalary()/12 + (getMonthlySales()*getCommisionRate());
    }

    private double monthlySales;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getMonthlySales() {
        return monthlySales;
    }

    public void setMonthlySales(double monthlySales) {
        this.monthlySales = monthlySales;
    }

    public float getCommisionRate() {
        return commisionRate;
    }

    public void setCommisionRate(float commisionRate) {
        this.commisionRate = commisionRate;
    }

    private float commisionRate;
}
