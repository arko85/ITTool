package controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;

public class PDAController implements Initializable {

	@FXML
	private TextField zm1TextField;

	@FXML
	private TextField zm2TextField;

	@FXML
	private TextField zm3TextField;

	@FXML
	private TextField zm4TextField;

	@FXML
	private TextField zm5TextField;

	@FXML
	private TextField zm6TextField;

	@FXML
	private TextField pathTextField;

	@FXML
	private TextField rozTextField;

	@FXML
	private Label averageLabel;

	@FXML
	private Label numberPDALabel;

	@FXML
	private Button generateButton;

	@FXML
	private Button pathfileButton;



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		pathTextField.setText("./");

		pathfileButton.setOnAction(x->choosePath());
		generateButton.setOnAction(x->generateData());
		// TODO Auto-generated method stub

	}

	private void choosePath() {
		DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory =
                directoryChooser.showDialog(pathfileButton.getScene().getWindow());

        pathTextField.setText(selectedDirectory.getAbsolutePath());


	}

	private void generateData(){

		int pula,zak,pda=0;
		int zm1=Integer.parseInt(zm1TextField.getText());
		int zm2=Integer.parseInt(zm2TextField.getText());
		int zm3=Integer.parseInt(zm3TextField.getText());
		int zm4=Integer.parseInt(zm4TextField.getText());
		int zm5=Integer.parseInt(zm5TextField.getText());
		int zm6=Integer.parseInt(zm6TextField.getText());

		int average =(zm1+zm2+zm3+zm4+zm5+zm6)/6;
		averageLabel.setText(Integer.toString(average));


		if (average<999){pula=1;}
		else
		{if(average<5000){pula=2;}
		else
		{if (average<20000){pula=3;}
		else pula=4;}}

		System.out.print(pula);
		zak=rozmiar(Integer.parseInt(rozTextField.getText()));

		switch(pula){
		case 1:{switch(zak){
							case 1:
								break;
							case 2:
								break;
							case 3:
								break;
								}}
		break;
		case 2:{switch(zak){
							case 1:
								break;
							case 2:
								break;
							case 3:
								break;
			}}
		break;
		case 3:{switch(zak){
							case 1:
								break;
							case 2:
								break;
							case 3:
								break;
			}}
		break;
		case 4:{switch(zak){
							case 1:
								break;
							case 2:
								break;
							
			}}
		break;
		}





}


	private int rozmiar(int roz){
		int zak;
		if (roz<300){zak=1;}
		else
		{if(roz<600){zak=2;}
		else zak=3;}
		return zak;
		}


}
