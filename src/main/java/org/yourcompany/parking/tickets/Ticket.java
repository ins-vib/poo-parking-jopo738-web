package org.yourcompany.parking.tickets;

import java.time.Duration;
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


    public long minuts(){    // posem long perqué és un enter molt gran
        Duration duration = Duration.between(entrada,sortida);   // el duration el que fa és la resta entre les dos dates
        return duration.toSeconds(); // /60;  // per calcular el minut hauriem de dividir entre 60
        
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ticket{");
        sb.append("numero=").append(numero);
        sb.append(", vehicle=").append(vehicle);
        sb.append(", pla\u00e7a=").append(plaça);
        sb.append(", entrada=").append(entrada);
        sb.append(", sortida=").append(sortida);
        sb.append('}');
        return sb.toString();
    }

    


    
    
}
