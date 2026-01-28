package org.yourcompany.parking.places;

import org.yourcompany.parking.vehicles.Vehicle;

public class PlacaGran extends PlacaAparcament {

    public PlacaGran(int numero, Coordenada[] coordenades) {
        super(numero, coordenades);
    }

    @Override
    public boolean compatible(Vehicle vehicle) {
        return true;
    }
    
    @Override
    public String toString() {
        return "Placa gran " + super.toString();
    }
    
}

