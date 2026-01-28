package org.yourcompany.parking.vehicles;

import java.util.Objects;

public class Vehicle {
    protected String matricula;
    protected TipusVehicle tipus;
    
    public String getMatricula() {
        return matricula;
    }
    
    public TipusVehicle getTipus() {
        return tipus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vehicle{");
        sb.append("matricula=").append(matricula);
        sb.append(", tipus=").append(tipus);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.matricula);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehicle other = (Vehicle) obj;
        return Objects.equals(this.matricula, other.matricula);
    }
}
