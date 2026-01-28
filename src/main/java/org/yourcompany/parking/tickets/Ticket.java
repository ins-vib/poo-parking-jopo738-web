package org.yourcompany.parking.tickets;

import java.time.LocalDateTime;

import org.yourcompany.parking.places.PlacaAparcament;
import org.yourcompany.parking.vehicles.Vehicle;

public class Ticket {

    private int numero;
    private Vehicle vehicle;
    private PlacaAparcament plaça;
    private LocalDateTime entrada;
    private LocalDateTime sortida;

    static private int comptador=1;

    public Ticket(Vehicle vehicle,PlacaAparcament plaça) {       // fem aquest constructor per donar un valor al numero
        numero=comptador;
        entrada=LocalDateTime.now();
        comptador++;
        this.plaça=plaça;
        this.vehicle=vehicle;
    }

    


    

    public int getNumero() {       // fem un getter per saber el numero
        return numero;
    }






    public Vehicle getVehicle() {
        return vehicle;
    }

    

    public PlacaAparcament getPlaça() {
        return plaça;
    }

    // public void setPlaça(PlacesParking plaça) {
    //     this.plaça = plaça;
    // }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    

    public LocalDateTime getSortida() {
        return sortida;
    }

    public void setSortida(LocalDateTime sortida) {
        this.sortida = sortida;
    }


    
    
}
