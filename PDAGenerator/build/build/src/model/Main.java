package model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		Parent parent = (Parent) FXMLLoader.load(getClass().getResource(
                "/view/PDA Generator.fxml"));
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("PDA Generator");
        stage.show();
	}

}
