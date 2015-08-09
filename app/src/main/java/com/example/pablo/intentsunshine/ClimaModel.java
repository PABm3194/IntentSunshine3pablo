package com.example.pablo.intentsunshine;

import java.io.Serializable;

public class ClimaModel implements Serializable {
    private String dia;
    private String temperatura;
    private String clima;
    private int imagen;



    public ClimaModel(String dia, String temperatura, String clima, int imagen) {
        this.dia = dia;
        this.temperatura = temperatura;
        this.clima = clima;
        this.imagen = imagen;
    }

    public ClimaModel() {
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int clima) {
        this.imagen = imagen;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }


}
