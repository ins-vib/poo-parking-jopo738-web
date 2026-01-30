/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.yourcompany.parking;

import java.util.ArrayList;
import java.util.Scanner;

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
        // Motocicleta m = new Motocicleta("1111-AAA");
        // System.out.println(m.getTipus());
        // Cotxe c = new Cotxe("2222-BBB");
        // System.out.println(c.getTipus());
        // Camio ca = new Camio("3333-CCC");
        // System.out.println(ca.getTipus());
    
        System.out.println("-------------------------------------------------------------------------------------------------------------");

    Coordenada[] coordenades = {
    new Coordenada(0, 0),
    new Coordenada(2, 0),
    new Coordenada(2, 1),
    new Coordenada(0, 1)
};

   // PlacaAparcament placa = new PlacaRegular(1, coordenades);

    

    // placa.aparcar(c);
    // System.out.println(placa);
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
    
    // placesParking.MostrarEstat();
    // Ticket ticket1=placesParking.aparcar(ca);   //return null
    // Ticket ticket2=placesParking.aparcar(m);
    // Ticket ticket3=placesParking.aparcar(c);
    // placesParking.MostrarEstat();

    // System.out.println(ticket2);


    // Thread.sleep(3000);   // serveix per aturar el prgrama


    System.out.println("-------------------------------------------------------------------------------------------------------------");

    //Motocicleta m2 = new Motocicleta("kewlfjwelfjc");  // mai la trobara
    //Motocicleta m2 = new Motocicleta("1111-AAA");  // si que la trobarà perqué té la mateixa matricula gracies al equals de (PlacesParking)
    // placesParking.desaparcar(m);
    // placesParking.MostrarEstat();
//    double preu=placesParking.desaparcar(ticket2);
//    System.out.println("has de pagar: "+preu);
//     placesParking.MostrarEstat();

    Scanner teclat=new Scanner (System.in);

   while (true) { 
       int opcio;
       System.out.println("que vols fer?");
       System.out.println("1-aparcar 2-desaparcar 3-mostrar");
       opcio=teclat.nextInt();

       switch (opcio) {
           case 1:

           int opcio2;
       System.out.println("tipus de vehicle");
       System.out.println("1-moto 2-cotxe 3-camió");
       opcio2=teclat.nextInt();
       switch (opcio2) {
           case 1:
            System.out.println("entra la matrícula: ");
            String matriculamoto=teclat.next();
            Motocicleta m2=new Motocicleta(matriculamoto);
            placesParking.aparcar(m2);
            Ticket ticket4=placesParking.aparcar(m2);
            System.out.println("el teu numero de ticket es: "+(ticket4.getNumero()));
               
               break;
            case 2:
                System.out.println("entra la matrícula: ");
            String matriculacotxe=teclat.next();
            Cotxe c2=new Cotxe(matriculacotxe);
            //placesParking.aparcar(c2);
            Ticket ticket5=placesParking.aparcar(c2);
            System.out.println("el teu numero de ticket es: "+(ticket5.getNumero()));

            break;

            case 3:
                System.out.println("entra la matrícula: ");
            String matriculacamio=teclat.next();
            Camio cam2=new Camio(matriculacamio);
            placesParking.aparcar(cam2);
            Ticket ticket6=placesParking.aparcar(cam2);
            System.out.println("el teu numero de ticket es: "+(ticket6.getNumero()-1));
            break;

            
           default:
               System.out.println("opció incorrecta");
       }



               
               break;
        case 2:
            
            System.out.println("entra numero ticket:");
            int numticket=teclat.nextInt();
            try{
                Ticket ticketdesaparcar = placesParking.getTicket(numticket);
                double preu=placesParking.desaparcar(ticketdesaparcar);
                System.out.println("preu a pagar: "+ preu);
            } catch (IllegalArgumentException e){

              System.out.println(e.getMessage());

            }  
               break;
            case 3:

            placesParking.MostrarEstat();

            
            
               
               break;
               default:
                System.out.println("opció incorrecta");
           
       }
   }}
    
}

