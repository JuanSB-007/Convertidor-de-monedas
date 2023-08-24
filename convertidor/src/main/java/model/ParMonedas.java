package model;

import java.util.Objects;

public class ParMonedas {

    private String monedaOrigen;
    private String monedaDestino;

    public ParMonedas(String monedaOrigen, String monedaDestino) {
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
    }

    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParMonedas that = (ParMonedas) o;
        return Objects.equals(monedaOrigen, that.monedaOrigen) &&
                Objects.equals(monedaDestino, that.monedaDestino);
    }

    @Override
    public int hashCode() {
        return Objects.hash(monedaOrigen, monedaDestino);
    }
}
