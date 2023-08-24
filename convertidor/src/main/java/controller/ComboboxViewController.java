package controller;

import com.convertidor.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.TipoConversion;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ComboboxViewController implements Initializable {



    @FXML
    private ComboBox<TipoConversion> comboboxEscoger;
    @FXML
    private Pane paneDivisas;
    @FXML
    private void comboboxEvent(ActionEvent e) throws IOException {
        //obtener el elemento a través de una instancia del arraylist
        TipoConversion selectedConversion = comboboxEscoger.getValue();

        if (selectedConversion != null) {
            String conversionName = selectedConversion.getTipo();
            System.out.println("Seleccionaste: " + conversionName);
            if (conversionName.equals("1. Convertidor de divisas")) {
                try {
                    //fxml loader carga una vista
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/convertidor/ventanaDivisas.fxml"));
                    //referencia al padre
                    Parent root = loader.load();
                    //carga el controlador de esa vista
                    VentanaDivisasController controlador = loader.getController();
                    //asociado al padre
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.showAndWait(); // espera hasta que cierre el escenario interno para continuar

                } catch (IOException ex) {
                    // Manejo de la excepción (error de carga del archivo FXML)
                    System.Logger logger = System.getLogger("com.convertidor");
                    logger.log(System.Logger.Level.ERROR,"Error al cargar archivo FXML",ex);

                } catch (Exception ex){
                    //excepciones no esperadas
                    System.Logger logger = System.getLogger("com.convertidor");
                    logger.log(System.Logger.Level.ERROR,"error inesperado",ex);
                }
            }

        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        comboboxEscoger.getItems().addAll(createCollection());

    }

    private ArrayList<TipoConversion> createCollection(){

        ArrayList<TipoConversion> tipo = new ArrayList<>();
        tipo.add(new TipoConversion("1. Convertidor de divisas"));
        tipo.add(new TipoConversion("2. Convertidor de temperatura"));


        return tipo;
    }
}
