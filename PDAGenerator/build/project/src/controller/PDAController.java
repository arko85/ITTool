package controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.BooleanBinding;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import model.PDA;

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
	private TextField areaTextField;

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

		BooleanBinding bb = new BooleanBinding() {
		    {
		        super.bind(
		        		zm1TextField.textProperty(),
		        		zm2TextField.textProperty(),
		        		zm3TextField.textProperty(),
		        		zm4TextField.textProperty(),
		        		zm5TextField.textProperty(),
		        		zm6TextField.textProperty(),
		        		areaTextField.textProperty()
		                );
		    }

		    @Override
		    protected boolean computeValue() {
		        return (zm1TextField.getText().isEmpty()
		                || zm2TextField.getText().isEmpty()
		                || zm3TextField.getText().isEmpty()
		                ||zm4TextField.getText().isEmpty()
		               || zm5TextField.getText().isEmpty()
		               || zm6TextField.getText().isEmpty()
		               || areaTextField.getText().isEmpty()
		                );
		    }
		};
		generateButton.disableProperty().bind(bb);
		pathTextField.setText("./");

		pathfileButton.setOnAction(x->choosePath());
		generateButton.setOnAction(x->generateData());
		zm1TextField.textProperty().addListener((observable, oldValue, newValue) -> {
		    if(!newValue.matches("[0-9]*")){
		    	zm1TextField.setText(oldValue);
		    }
		});
		zm2TextField.textProperty().addListener((observable, oldValue, newValue) -> {
		    if(!newValue.matches("[0-9]*")){
		    	zm2TextField.setText(oldValue);
		    }
		});

		zm3TextField.textProperty().addListener((observable, oldValue, newValue) -> {
		    if(!newValue.matches("[0-9]*")){
		    	zm3TextField.setText(oldValue);
		    }
		});
		zm4TextField.textProperty().addListener((observable, oldValue, newValue) -> {
		    if(!newValue.matches("[0-9]*")){
		    	zm4TextField.setText(oldValue);
		    }
		});
		zm5TextField.textProperty().addListener((observable, oldValue, newValue) -> {
		    if(!newValue.matches("[0-9]*")){
		    	zm5TextField.setText(oldValue);
		    }
		});
		zm6TextField.textProperty().addListener((observable, oldValue, newValue) -> {
		    if(!newValue.matches("[0-9]*")){
		    	zm6TextField.setText(oldValue);
		    }
		});
		areaTextField.textProperty().addListener((observable, oldValue, newValue) -> {
		    if(!newValue.matches("[0-9]*")){
		    	areaTextField.setText(oldValue);
		    }
		});



		// TODO Auto-generated method stub

	}

	private void choosePath() {
		DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory =
                directoryChooser.showDialog(pathfileButton.getScene().getWindow());

        pathTextField.setText(selectedDirectory.getAbsolutePath());


	}

	private void generateData(){



		int area;

		int zm1=Integer.parseInt(zm1TextField.getText());
		int zm2=Integer.parseInt(zm2TextField.getText());
		int zm3=Integer.parseInt(zm3TextField.getText());
		int zm4=Integer.parseInt(zm4TextField.getText());
		int zm5=Integer.parseInt(zm5TextField.getText());
		int zm6=Integer.parseInt(zm6TextField.getText());
		area=Integer.parseInt(areaTextField.getText());


		PDA pda=new PDA(zm1, zm2, zm3, zm4, zm5, zm6, area);

		averageLabel.setText(Integer.toString(pda.averageM()));




numberPDALabel.setText("PDA = "+Integer.toString(pda.ile_PDA()));
pda.writeTOFile(pathTextField.getText());


}





}
