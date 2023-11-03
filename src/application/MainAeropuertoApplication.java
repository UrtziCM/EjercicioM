package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainAeropuertoApplication extends Application {

	@Override
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(this.getClass().getResource("/fxml/loginAeropuertos.fxml"));
			Scene loginScene = new Scene(root);
			loginScene.getStylesheets().add(this.getClass().getResource("/css/main.css").toExternalForm());
			stage.setTitle("Aviones - Login");
			stage.setScene(loginScene);
			stage.setResizable(false);
			stage.show();
			stage.setOnCloseRequest(e -> {
				e.consume();
				if (stage.getProperties().get("goodLogin") != null) {					
					try {
						
						Parent mainRoot = FXMLLoader.load(this.getClass().getResource("/fxml/listadoAeropuertos.fxml"));
						Scene mainScene = new Scene(mainRoot);
						mainScene.getStylesheets().add(this.getClass().getResource("/css/main.css").toExternalForm());
						Stage mainStage = new Stage();
						
						mainStage.setTitle("Aviones - Aeropuertos");
						mainStage.setScene(mainScene);
						mainStage.setResizable(false);
						mainStage.show();
						stage.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					stage.close();
				}

			});

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
