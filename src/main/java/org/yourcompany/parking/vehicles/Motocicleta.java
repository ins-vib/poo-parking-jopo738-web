package org.yourcompany.parking.vehicles;

public class Motocicleta extends Vehicle {

    public Motocicleta(String matricula) {
        this.matricula=matricula;
        this.tipus= TipusVehicle.PETIT;
    }

    @Override
    public String toString() {
        
        return "Motocicleta"+super.toString();
    }


    
}
