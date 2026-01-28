package org.yourcompany.parking.vehicles;

public class Camio extends Vehicle {
   public Camio (String matricula){
    this.matricula=matricula;
    this.tipus= TipusVehicle.GRAN;
   } 

   @Override
   public String toString(){
    return "Camio"+super.toString();
   }
}
