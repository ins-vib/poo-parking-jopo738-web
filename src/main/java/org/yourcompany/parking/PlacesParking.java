package org.yourcompany.parking;

import java.util.ArrayList;

import org.yourcompany.parking.places.PlacaAparcament;
import org.yourcompany.parking.tickets.Ticket;
import org.yourcompany.parking.vehicles.Vehicle;

public class PlacesParking {
    private ArrayList<PlacaAparcament> places;
    private ArrayList<Ticket>tickets;

    public PlacesParking(ArrayList<PlacaAparcament> places) {
        this.places = places;
    }

    public void MostrarEstat(){
        for (PlacaAparcament p : places) {
            System.out.println(p);
        }
    }


    public boolean aparcar(Vehicle vehicle){
        for(PlacaAparcament plaça: places){
            if(plaça.compatible(vehicle)&& !plaça.isOcupada()){
                plaça.aparcar(vehicle);
                tickets.add(new Ticket(vehicle, plaça));
                return true;
            }  
        }
        return false;
    }

    public boolean desaparcar(Vehicle vehicle){
        for(PlacaAparcament plaça: places){
        if(plaça.isOcupada()&&plaça.getVehicleAparcat().getMatricula().equals(vehicle.getMatricula())){  // tambe podem posar després del && plaça.getVehicleAparcat().equals(vehicle)
            plaça.desaparcar();
            return true;
        }
        }
        return false;
    }
}
