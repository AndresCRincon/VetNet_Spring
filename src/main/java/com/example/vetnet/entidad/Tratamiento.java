package com.example.vetnet.entidad;
import java.util.Date;

public class Tratamiento {
    private Droga droga;
    private Date fecha;
    private Mascota mascota;

    public Tratamiento(Droga droga, Date fecha, Mascota mascota) {
        this.droga = droga;
        this.fecha = fecha;
        this.mascota = mascota;
    }

    public Droga getDroga() {
        return droga;
    }

    public void setDroga(Droga droga) {
        this.droga = droga;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }  

}
