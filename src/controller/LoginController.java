package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class LoginController {

    @FXML
    private Button connectButton;

    @FXML
    private PasswordField passTxtf;

    @FXML
    private TextField userTxtf;

    @FXML
    void checkLogin(ActionEvent event) {
    	DBManagerAeropuertos gestor = new DBManagerAeropuertos();
    	if (gestor.isLoginCorrect(userTxtf.getText(), passTxtf.getText())) {
    		connectButton.getScene().getWindow().getProperties().put("goodLogin", true);
    		Stage stage = (Stage)connectButton.getScene().getWindow();
    		stage.fireEvent(new WindowEvent(stage,WindowEvent.WINDOW_CLOSE_REQUEST));
    	}
    }
    @FXML
    void cancelLogin(ActionEvent event) {
    	Platform.exit();
    }
}
