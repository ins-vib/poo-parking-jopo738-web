package org.yourcompany.parking.vehicles;

public class Cotxe extends Vehicle {
    
    public Cotxe(String matricula){
        this.matricula= matricula;
        this.tipus= TipusVehicle.MITJA;
    }

    @Override
    public String toString(){
        return "Cotxe"+super.toString();
    }
}
