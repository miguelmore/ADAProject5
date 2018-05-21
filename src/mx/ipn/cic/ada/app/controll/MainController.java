/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.cic.ada.app.controll;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import mx.ipn.cic.ada.fourier.FourierTransform;

/**
 * FXML Controller class
 *
 * @author SIA Miguel
 */
public class MainController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    public void actionBtnFFT(ActionEvent event){
        System.out.println("Hola");
        FourierTransform.test();
    }
}
