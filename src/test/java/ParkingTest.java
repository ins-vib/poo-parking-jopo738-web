
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import org.yourcompany.parking.PlacesParking;
import org.yourcompany.parking.places.Coordenada;
import org.yourcompany.parking.places.PlacaAparcament;
import org.yourcompany.parking.places.PlacaCompacta;
import org.yourcompany.parking.places.PlacaGran;
import org.yourcompany.parking.places.PlacaRegular;
import org.yourcompany.parking.tickets.Ticket;
import org.yourcompany.parking.vehicles.Camio;
import org.yourcompany.parking.vehicles.Cotxe;
import org.yourcompany.parking.vehicles.Motocicleta;
import org.yourcompany.parking.vehicles.Vehicle;

public class ParkingTest {
    @Test 
    void T1(){
        Coordenada[] coordenades= {new Coordenada(0, 0), new Coordenada(2, 0)};
        ArrayList<PlacaAparcament>Llistaplaces=new ArrayList<>();

        PlacaRegular placatransport1= new PlacaRegular(1, coordenades);
        Llistaplaces.add(placatransport1);

        PlacesParking places = new PlacesParking(Llistaplaces);
        Cotxe cotxetest = new Cotxe("1111AAA");

        Ticket resultatticket= places.aparcar(cotxetest);

        assertNotNull(resultatticket);
        assertEquals("1111AAA", resultatticket.getVehicle().getMatricula());
        assertTrue(placatransport1.isOcupada());
        assertEquals(cotxetest, placatransport1.getVehicleAparcat());
    }


    @Test 
    void T2(){
        Vehicle v= null;
        PlacaAparcament plaça= new PlacaRegular(1, null);
            
        try {
            plaça.aparcar(v);
            fail("Hauria de fallar l'aparcament");
            
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
            
        };


    @Test 
    void T3(){
        Coordenada[] coordenades= {new Coordenada(0, 0), new Coordenada(2, 0)};
        ArrayList<PlacaAparcament>Llistaplaces=new ArrayList<>();

        PlacaCompacta placatransport1= new PlacaCompacta(1, coordenades);
        Llistaplaces.add(placatransport1);

        PlacesParking places = new PlacesParking(Llistaplaces);
        Camio camiotest = new Camio("2222BBB");

        Ticket resultatticket= places.aparcar(camiotest);
        try {
            placatransport1.aparcar(camiotest);
            fail("Hauria de fallar l'aparcament");
            
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
            
        };

        @Test 
    void T4testnocompatible(){
        Coordenada[] coordenades= {new Coordenada(0, 0), new Coordenada(2, 0)};
        ArrayList<PlacaAparcament>Llistaplaces=new ArrayList<>();

        PlacaRegular placatransport1= new PlacaRegular(1, coordenades);
        Llistaplaces.add(placatransport1);

        PlacesParking places = new PlacesParking(Llistaplaces);
        Cotxe cotxetest = new Cotxe("1111AAA");
        Cotxe cotxe2test = new Cotxe("2222BBB");
        placatransport1.aparcar(cotxetest);

        
        try {
            
            placatransport1.aparcar(cotxe2test);
            fail("La plaça ja està ocupada");
            
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
            
        };

        @Test 
    void T5(){
        Coordenada[] coordenades= {new Coordenada(0, 0), new Coordenada(2, 0)};
        ArrayList<PlacaAparcament>Llistaplaces=new ArrayList<>();

        PlacaRegular placatransport1= new PlacaRegular(1, coordenades);
        Llistaplaces.add(placatransport1);

        PlacesParking places = new PlacesParking(Llistaplaces);
        Cotxe cotxetest = new Cotxe("1111AAA");
        Cotxe cotxe2test = new Cotxe("2222BBB");
        placatransport1.aparcar(cotxetest);
        assertTrue(placatransport1.isOcupada());
        placatransport1.desaparcar();
        assertFalse(placatransport1.isOcupada());
        placatransport1.aparcar(cotxe2test);
        assertTrue(placatransport1.isOcupada());
        assertEquals(cotxe2test, placatransport1.getVehicleAparcat());

        
        

    }


    @Test 
    void T6(){
        Coordenada[] coordenades= {new Coordenada(0, 0), new Coordenada(2, 0)};
        ArrayList<PlacaAparcament>Llistaplaces=new ArrayList<>();

        PlacaRegular placatransport1= new PlacaRegular(1, coordenades);
        Llistaplaces.add(placatransport1);

        PlacesParking places = new PlacesParking(Llistaplaces);
        Cotxe cotxetest = new Cotxe("1111AAA");
        
        placatransport1.aparcar(cotxetest);

        
        try {
            
            placatransport1.aparcar(cotxetest);
            fail("La plaça ja està ocupada");
            
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }


    @Test 
    void T7(){
        Coordenada[] coordenades= {new Coordenada(0, 0), new Coordenada(5, 0)};
        ArrayList<PlacaAparcament>Llistaplaces=new ArrayList<>();

        PlacaRegular placatransport1= new PlacaRegular(7, coordenades);
        Llistaplaces.add(placatransport1);

        PlacesParking places = new PlacesParking(Llistaplaces);
        Cotxe cotxepetit = new Cotxe("1111AAA");

       

       assertTrue(placatransport1.compatible(cotxepetit));
       placatransport1.aparcar(cotxepetit);
       assertTrue(placatransport1.isOcupada());

      
    }

    @Test 
    void T8(){
        Coordenada[] coordenades= {new Coordenada(0, 0), new Coordenada(5, 0)};
        ArrayList<PlacaAparcament>Llistaplaces=new ArrayList<>();

        PlacaCompacta placatransport1= new PlacaCompacta(7, coordenades);
        Llistaplaces.add(placatransport1);

        PlacesParking places = new PlacesParking(Llistaplaces);
        Motocicleta cotxepetit = new Motocicleta("1111AAA");
       

       assertTrue(placatransport1.compatible(cotxepetit));
       placatransport1.aparcar(cotxepetit);
       assertTrue(placatransport1.isOcupada());

      
    }

    @Test 
    void T9(){
        Coordenada[] coordenades= {new Coordenada(0, 0), new Coordenada(2, 0)};
        
        ArrayList<PlacaAparcament>Llistaplaces=new ArrayList<>();

        PlacaCompacta placatransport1= new PlacaCompacta(7, coordenades);
        Llistaplaces.add(placatransport1);
        PlacaGran placatransport2= new PlacaGran(7, coordenades);
        Llistaplaces.add(placatransport1);
        PlacaRegular placatransport3= new PlacaRegular(7, coordenades);
        Llistaplaces.add(placatransport1);

        PlacesParking places = new PlacesParking(Llistaplaces);
        Camio cotxegran = new Camio("1111AAA");
       

       assertTrue(placatransport2.compatible(cotxegran));
       placatransport2.aparcar(cotxegran);
       assertTrue(placatransport2.isOcupada());
       assertFalse(placatransport1.compatible(cotxegran));
       assertFalse(placatransport3.compatible(cotxegran));


      
    }

    @Test 
    void T10(){
        Coordenada[] coordenades= {new Coordenada(0, 0), new Coordenada(2, 0)};
        ArrayList<PlacaAparcament>Llistaplaces=new ArrayList<>();

        PlacaCompacta placatransport1= new PlacaCompacta(1, coordenades);
        Llistaplaces.add(placatransport1);

        PlacesParking places = new PlacesParking(Llistaplaces);
        Camio camiotest = new Camio("1111AAA");
        
        

        
        try {
            
            placatransport1.aparcar(camiotest);
            fail("La plaça no és compatible");
            
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }



}

