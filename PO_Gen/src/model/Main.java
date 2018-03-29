package model;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//launch(args);


		System.out.print(new PO_Position("IT", "Monitor", 1, 590, 590, "", "00823", "CI473","0104" ,"", 0,"30030.004","C").toString());
		writeTOFile();
	}
	public static void writeTOFile(){

    	try {
			PrintWriter fw =new PrintWriter(new File("./PO.txt"));
			fw.println(new PO_Position("IT", "Monitor", 1, 590, 590, "", "00823", "CI473","0104" ,"", 0,"30030.004","C").toString());

			fw.flush();
			fw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
	//	Parent parent = (Parent) FXMLLoader.load(getClass().getResource(
      //          "/view/PraserXML.fxml"));
     //   Scene scene = new Scene(parent);
     //   stage.setScene(scene);
     //   stage.setTitle("Praser XML for MarkIT");
      //  stage.show();
	}

}