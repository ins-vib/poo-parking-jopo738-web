package org.yourcompany.parking;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.yourcompany.parking.places.PlacaAparcament;
import org.yourcompany.parking.tickets.Ticket;
import org.yourcompany.parking.vehicles.Vehicle;

public class PlacesParking {
    private ArrayList<PlacaAparcament> places;
    private ArrayList<Ticket>tickets;
    

    final  static public double PREU_MINUT= 2.0;     // static= perque sigui compartida      final= perque no es pugui canviar la variable

    public PlacesParking(ArrayList<PlacaAparcament> places) {
        this.places = places;
        this.tickets=new ArrayList<>();
    }

    public void MostrarEstat(){
        for (PlacaAparcament p : places) {
            System.out.println(p);
        }
    }


    public Ticket aparcar(Vehicle vehicle){     // posem public Ticket perque el que volem retorna és el ticket
        for(PlacaAparcament plaça: places){
            if(plaça.compatible(vehicle) && !plaça.isOcupada()){
                plaça.aparcar(vehicle);
                Ticket ticket = new Ticket(vehicle, plaça);
                tickets.add(ticket);
                //tickets.add(new Ticket(vehicle, plaça));    és el mateix que el que hi ha a les dos linies de adalt
                return ticket;
            }  
        }
        return null;
    }

    public double desaparcar(Ticket ticket){

         if(!tickets.remove(ticket)){     // si el ticket està malament fem el exception 
            throw new IllegalArgumentException("Ticket incorrecte");
        }

        ticket.getPlaça().desaparcar();   // agafem la plaça del ticket

        ticket.setSortida(LocalDateTime.now());  // per calcular quan ha sortit i mirar la hora en que ha sortit
        
        tickets.remove(ticket);  // aixo posem per borrar el ticket de l'arraylist

        double preu=ticket.minuts()*PREU_MINUT;   // moltipliquem els minuts per el preu que té el parking per minut

        return preu;
 
    }

     public Ticket getTicket(int numero){

        for(Ticket t: tickets){
            if(t.getNumero()==numero)return t;
        }
        return null;
        
     }

    // public boolean desaparcar(Vehicle vehicle){
        
    //     // for(PlacaAparcament plaça: places){
    //     // if(plaça.isOcupada()&&plaça.getVehicleAparcat().getMatricula().equals(vehicle.getMatricula())){  // tambe podem posar després del && plaça.getVehicleAparcat().equals(vehicle)
    //     //     plaça.desaparcar();
    //     //     return true;
    //     // }
    //     // }
    //     return false;
    // }
}
