package model;

public class TipoConversion {

    private String tipo;
    public TipoConversion() {
    }

    public TipoConversion( String tipo) {

        this.tipo = tipo;
    }



    public String getTipo() {
        return tipo;
    }


    @Override
    public String toString(){

        return getTipo();
    }
}


