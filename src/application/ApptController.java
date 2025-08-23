package application;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import java.net.URL;
import java.util.ResourceBundle;


public class ApptController 
{
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
	@FXML
	private TextField apptNameTxtField;
	
	@FXML
	private Label frontPgDate;
	

	public void switchToTheApptSche(ActionEvent event) throws Exception 
	{
		 /* root = FXMLLoader.load(getClass().getResource("ApptSchedule.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show(); */
		Main.switchScene("ApptSchedule.fxml");
	}
	
	//public void switchToFrontPage(ActionEvent event) throws Exception 
	//{
		 /* root = FXMLLoader.load(getClass().getResource("FrontPage.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show(); */
		//Main.switchScene("FrontPage.fxml");
	//}
	
	public void addAppt(ActionEvent event) throws IOException
	{
		System.out.println("Adding now...");
	}
	
	
	
}
