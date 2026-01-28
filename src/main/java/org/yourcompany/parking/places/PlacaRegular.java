package org.yourcompany.parking.places;

import org.yourcompany.parking.vehicles.TipusVehicle;
import org.yourcompany.parking.vehicles.Vehicle;



public class PlacaRegular extends PlacaAparcament {

    public PlacaRegular(int numero, Coordenada[] coordenades) {
        super(numero, coordenades);
    }

    @Override
    public boolean compatible(Vehicle vehicle) {
        if(vehicle.getTipus() == TipusVehicle.PETIT || vehicle.getTipus() == TipusVehicle.MITJA){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Placa regular " + super.toString();
    }
    
    

}

