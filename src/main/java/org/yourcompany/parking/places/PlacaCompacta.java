package org.yourcompany.parking.places;

import org.yourcompany.parking.vehicles.TipusVehicle;
import org.yourcompany.parking.vehicles.Vehicle;

public class PlacaCompacta extends PlacaAparcament {

    public PlacaCompacta(int numero, Coordenada[] coordenades) {
        super(numero, coordenades);
    }

    @Override
    public boolean compatible(Vehicle vehicle) {

        if(vehicle.getTipus() == TipusVehicle.PETIT){
            return true;
        }
        return false;

    }
    
    @Override
    public String toString() {
        return "Placa compacta " + super.toString();
    }
    
    
}

