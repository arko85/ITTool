package controller;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.FileChooser;
import model.JavaDB;
import model.Order;
import model.PraserXML;
import model.Status;
import sun.util.calendar.BaseCalendar.Date;

public class ToolController implements Initializable {
	@FXML
    private Button copyAllButton;

    @FXML
    private Button chPathFileButton;

    @FXML
    private Button genDataButton;

    @FXML
    private TextField xmlPathTextField;

    @FXML
    private TextArea dataTextArea;

    private File pathFile;

    @FXML
    private TableView<Order> tData;

    @FXML
    private TableColumn<Order,Date> cData;

    @FXML
    private TableColumn<Order, String> cTowar;

    @FXML
    private TableColumn<Order, Integer> cZamow;

    @FXML
    private TableColumn<Order, String> cPO;

    @FXML
    private TableColumn<Order, Integer> cOdebr;

    @FXML
    private TableColumn<Order, Integer> cMpk;

    @FXML
    private TableColumn<Order, String> cUwagi;

    @FXML
    private TableColumn<Order, Status> cStatus;

    @FXML
    private DatePicker pData;

    @FXML
    private TextField pTowar;

    @FXML
    private ChoiceBox<?> pStatus;

    @FXML
    private TextField pUwagi;

    @FXML
    private TextField pMpk;

    @FXML
    private TextField pOdebr;

    @FXML
    private TextField pPO;

    @FXML
    private TextField pZamow;

    @FXML
    private Button bSearch;

    @FXML
    private Button bAdd;


	public void initialize(URL location, ResourceBundle resources) {
		xmlPathTextField.setText("./Potwierdzenie.xml");
		genDataButton.setOnAction(x->genDataButton());
		copyAllButton.setOnAction(x->copyAllButton());
		chPathFileButton.setOnAction(x->choosePath());
		JavaDB.stworzTabele(JavaDB.polacz("Orders"), "Orders");
		//Order ord =new Order(3,LocalDate.now(),"pc42",1,"jgf3j",1,12,"vs3fa",Status.COMPLETED);
		//System.out.println(ord.getId());
		//JavaDB.dodajDane(ord, "Orders");
		JavaDB.szukaj("Orders", "id", "3");

		// TODO Auto-generated method stub

	}



	private void choosePath() {
		// TODO Auto-generated method stub
		FileChooser fileChooser = new FileChooser();
		if(pathFile!=null)fileChooser.setInitialDirectory(pathFile.getParentFile());
		fileChooser.setTitle("Open Resource XML File");
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);


		pathFile=fileChooser.showOpenDialog(chPathFileButton.getScene().getWindow());

		if(pathFile!=null)xmlPathTextField.setText(pathFile.getAbsolutePath());


	}



	private void copyAllButton() {
		// TODO Auto-generated method stub
		final Clipboard clipboard = Clipboard.getSystemClipboard();
		final ClipboardContent content = new ClipboardContent();
		content.putString(dataTextArea.getText());
		clipboard.setContent(content);

	}



	private void genDataButton() {
		// TODO Auto-generated method stub
		PraserXML praser =new PraserXML();
		praser.prase(xmlPathTextField.getText());
		dataTextArea.setText(praser.getTextPraser());
	}

}
