package org.yourcompany.parking.places;

import java.util.Arrays;

import org.yourcompany.parking.vehicles.Vehicle;

public abstract class PlacaAparcament {

    protected int numero;
    // protected boolean estat;
    protected Vehicle vehicleAparcat;
    protected Coordenada[]  coordenades;

    public abstract boolean compatible (Vehicle vehicle);

    public void aparcar(Vehicle vehicle){

        //Vehicle no pot ser null
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle Incorrecte");
        }

        //No puc aparcar si no es compatible
        if(!this.compatible(vehicle)){
            throw new IllegalArgumentException("La placa no es compatible");
        }

        //No puc aparcar si hi ha un vehicle aparcat dins de la placa
        if(this.isOcupada()){
            throw new IllegalArgumentException("La placa ja esta ocupada");
        }



        this.vehicleAparcat = vehicle;
    }

    public PlacaAparcament(int numero, Coordenada[] coordenades) {

        this.numero = numero;
        this.coordenades = coordenades;
        // this.estat = false;
        this.vehicleAparcat = null;
    }

    public int getNumero() {
        return numero;
    }
    public boolean isOcupada() {
        return this.vehicleAparcat!=null;
    }
    public Vehicle getVehicleAparcat() {
        return vehicleAparcat;
    }
    public Coordenada[] getCoordenades() {
        return coordenades;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        // sb.append("PlacaAparcament{");
        sb.append("numero=").append(numero);
        if(!this.isOcupada()){
            sb.append(" Lliure ");
        } else {
            sb.append(" Ocupada ").append(this.vehicleAparcat.getMatricula());
        }
        sb.append(", coordenades=").append(Arrays.toString(coordenades));
        sb.append('}');
        return sb.toString();
    }

    public void desaparcar(){
        this.vehicleAparcat = null;
    }

    

}

