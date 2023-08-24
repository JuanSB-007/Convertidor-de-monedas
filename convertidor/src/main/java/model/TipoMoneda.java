package model;

public class TipoMoneda {
    private String tipo;

    public TipoMoneda(String tipo) {
        this.tipo = tipo;

    }

    public String getTipo() {
        return tipo;
    }


    @Override
    public String toString() {
        return getTipo();
    }
}
