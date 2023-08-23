package org.kainos.ea.cli;

public class DeliveryEmployee extends Employee{
    public DeliveryEmployee(int employyeeId, String name, double salary){
        super(employyeeId, name, salary);
    }

    @Override
    public double calcPay(){
        return getSalary()/12+1000;
    }
}
