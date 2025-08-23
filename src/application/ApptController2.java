package application;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;


public class ApptController2 implements Initializable
{
	@FXML
	private DatePicker datePicker;
	
	
	@FXML
	private ChoiceBox<String> durationLength;
	
	private String[] durationTimes = {"30 mins","1 hr", "1 hr 30 mins", "2 hrs", "2 hrs 30 mins", "3 hrs", "Undefined"};
	


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{	
		durationLength.getItems().addAll(durationTimes);
	}

	public void switchToFrontPage(ActionEvent event) throws Exception 
	{
		 /* root = FXMLLoader.load(getClass().getResource("FrontPage.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show(); */
		Main.switchScene("FrontPage.fxml");
	}

	public void getDate(ActionEvent event) throws IOException
	{
		LocalDate myDate = datePicker.getValue();
		String myFormattedDate = myDate.format(DateTimeFormatter.ofPattern("M/d/yyyy"));
		System.out.println(myFormattedDate);
	}
	
	public void addAppt(ActionEvent event) throws IOException
	{
		System.out.println("Adding appointment now...");
	}
}
