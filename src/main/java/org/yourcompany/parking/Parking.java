/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.yourcompany.parking;

import java.util.ArrayList;

import org.yourcompany.parking.places.Coordenada;
import org.yourcompany.parking.places.PlacaAparcament;
import org.yourcompany.parking.places.PlacaCompacta;
import org.yourcompany.parking.places.PlacaRegular;
import org.yourcompany.parking.tickets.Ticket;
import org.yourcompany.parking.vehicles.Camio;
import org.yourcompany.parking.vehicles.Cotxe;
import org.yourcompany.parking.vehicles.Motocicleta;

/**
 *
 * @author jpome
 */
public class Parking {

   public static void main(String[] args) throws InterruptedException {
        // Vehicle v = new Vehicle();
        Motocicleta m = new Motocicleta("1111-AAA");
        System.out.println(m.getTipus());
        Cotxe c = new Cotxe("2222-BBB");
        System.out.println(c.getTipus());
        Camio ca = new Camio("3333-CCC");
        System.out.println(ca.getTipus());
    
        System.out.println("-------------------------------------------------------------------------------------------------------------");

    Coordenada[] coordenades = {
    new Coordenada(0, 0),
    new Coordenada(2, 0),
    new Coordenada(2, 1),
    new Coordenada(0, 1)
};

    PlacaAparcament placa = new PlacaRegular(1, coordenades);

    

    placa.aparcar(c);
    System.out.println(placa);
    // placa.;

    

    ArrayList<PlacaAparcament> places = new ArrayList<>();

    places.add(new PlacaRegular(1, coordenades));
    places.add(new PlacaRegular(2, coordenades));
    places.add(new PlacaRegular(3, coordenades));
    places.add(new PlacaRegular(4, coordenades));
    places.add(new PlacaRegular(5, coordenades));
    places.add(new PlacaCompacta(6, coordenades));
    places.add(new PlacaCompacta(7, coordenades));
    places.add(new PlacaCompacta(8, coordenades));
    places.add(new PlacaCompacta(9, coordenades));
    places.add(new PlacaCompacta(10, coordenades));

    System.out.println("-------------------------------------------------------------------------------------------------------------");

    PlacesParking placesParking = new PlacesParking(places);
    
    placesParking.MostrarEstat();
    Ticket ticket1=placesParking.aparcar(ca);   //return null
    Ticket ticket2=placesParking.aparcar(m);
    Ticket ticket3=placesParking.aparcar(c);
    placesParking.MostrarEstat();

    System.out.println(ticket2);


    Thread.sleep(3000);   // serveix per aturar el prgrama


    System.out.println("-------------------------------------------------------------------------------------------------------------");

    //Motocicleta m2 = new Motocicleta("kewlfjwelfjc");  // mai la trobara
    //Motocicleta m2 = new Motocicleta("1111-AAA");  // si que la trobarà perqué té la mateixa matricula gracies al equals de (PlacesParking)
    // placesParking.desaparcar(m);
    // placesParking.MostrarEstat();
   double preu=placesParking.desaparcar(ticket2);
   System.out.println("has de pagar: "+preu);
    placesParking.MostrarEstat();


}
}
