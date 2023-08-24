package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.ParMonedas;
import model.TipoMoneda;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class VentanaDivisasController implements Initializable {

    private Map<ParMonedas, Double> tasasConversion;

    @FXML
    private ComboBox<TipoMoneda> comboboxTipoMoneda;

    @FXML
    private ComboBox<TipoMoneda> comboboxTipoMoneda2;

    @FXML
    private TextField valorConversion;


    @FXML
    private Label labelResultado;

    @FXML
    private void eventButton(ActionEvent event){
        TipoMoneda monedaOrigen = comboboxTipoMoneda.getValue();
        TipoMoneda monedaDestino = comboboxTipoMoneda2.getValue();
        String valorConvertir = valorConversion.getText();

        if (monedaOrigen!= null && monedaDestino!=null && !valorConvertir.isEmpty()) {

            try {
                double cantidad = Double.parseDouble(valorConvertir);

                // Construye la clave ParMonedas para buscar la tasa de conversión en el mapa
                ParMonedas parMonedas = new ParMonedas(monedaOrigen.getTipo(), monedaDestino.getTipo());

                // Busca la tasa de conversión en el mapa
                Double tasaConversion = tasasConversion.get(parMonedas);

                if (tasaConversion != null) {
                    // Realiza la conversión de divisas utilizando la tasa de conversión
                    double cantidadConvertida = cantidad * tasaConversion;
                    labelResultado.setText("Resultado: "+cantidadConvertida);

                }
            }catch (NumberFormatException ex){
                ex.getMessage();
            }
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        comboboxTipoMoneda.getItems().addAll(createCollection());
        comboboxTipoMoneda2.getItems().addAll(createCollection2());

        tasasConversion = new HashMap<>();

        tasasConversion.put(new ParMonedas("Peso colombiano","Peso Argentino"),0.0689);
        tasasConversion.put(new ParMonedas("Peso colombiano","Dólar"),0.00025);
        tasasConversion.put(new ParMonedas("Peso colombiano","Euro"),0.00023);
        tasasConversion.put(new ParMonedas("Peso colombiano","Yen"),0.036);
        tasasConversion.put(new ParMonedas("Peso colombiano","Libra Esterlina"),0.00020);

        tasasConversion.put(new ParMonedas("Peso Argentino","Peso colombiano"),14.58);
        tasasConversion.put(new ParMonedas("Peso Argentino","Dólar"),0.036);
        tasasConversion.put(new ParMonedas("Peso Argentino","Euro"),0.033);
        tasasConversion.put(new ParMonedas("Peso Argentino","Yen"),0.52);
        tasasConversion.put(new ParMonedas("Peso Argentino","Libra Esterlina"),0.0028);

        tasasConversion.put(new ParMonedas("Dólar","Peso colombiano"),4117.31);
        tasasConversion.put(new ParMonedas("Dólar","Peso Argentino"),278.02);
        tasasConversion.put(new ParMonedas("Dólar","Euro"),0.91);
        tasasConversion.put(new ParMonedas("Dólar","Yen"),142.71);
        tasasConversion.put(new ParMonedas("Dólar","Libra Esterlina"),0.79);

        tasasConversion.put(new ParMonedas("Euro","Peso colombiano"),4525.75);
        tasasConversion.put(new ParMonedas("Dólar","Peso Argentino"),307.51);
        tasasConversion.put(new ParMonedas("Dólar","Dólar"),1.10);
        tasasConversion.put(new ParMonedas("Dólar","Yen"),156.31);
        tasasConversion.put(new ParMonedas("Dólar","Libra Esterlina"),0.87);

        tasasConversion.put(new ParMonedas("Yen","Peso colombiano"),28.95);
        tasasConversion.put(new ParMonedas("Yen","Peso Argentino"),1.97);
        tasasConversion.put(new ParMonedas("Yen","Dólar"),0.0071);
        tasasConversion.put(new ParMonedas("Yen","Euro"),0.0064);
        tasasConversion.put(new ParMonedas("Yen","Libra Esterlina"),0.0055);

        tasasConversion.put(new ParMonedas("Libra Esterlina","Peso colombiano"),5232.38);
        tasasConversion.put(new ParMonedas("Libra Esterlina","Peso Argentino"),355.51);
        tasasConversion.put(new ParMonedas("Libra Esterlina","Dólar"),1.27);
        tasasConversion.put(new ParMonedas("Libra Esterlina","Euro"),1.16);
        tasasConversion.put(new ParMonedas("Libra Esterlina","Yen"),180.80);

    }
    //coleccion para las monedas de origen, en el primer combobox
    private ArrayList<TipoMoneda> createCollection(){

        ArrayList<TipoMoneda> tipo = new ArrayList<>();
        tipo.add(new TipoMoneda("Peso colombiano"));
        tipo.add(new TipoMoneda("Peso Argentino"));
        tipo.add(new TipoMoneda("Dólar"));
        tipo.add(new TipoMoneda("Euro"));
        tipo.add(new TipoMoneda("Yen"));
        tipo.add(new TipoMoneda("Libra Esterlina"));


        return tipo;
    }


    //coleccion para las monedas de destino, en el segundo combobox
    private ArrayList<TipoMoneda> createCollection2(){

        ArrayList<TipoMoneda> tipo = new ArrayList<>();
        tipo.add(new TipoMoneda("Peso colombiano"));
        tipo.add(new TipoMoneda("Peso Argentino"));
        tipo.add(new TipoMoneda("Dólar"));
        tipo.add(new TipoMoneda("Euro"));
        tipo.add(new TipoMoneda("Yen"));
        tipo.add(new TipoMoneda("Libra Esterlina"));


        return tipo;
    }


}
