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
import javafx.scene.layout.VBox;
import javafx.scene.control.ChoiceBox;
import java.net.URL;
import java.util.ResourceBundle;


public class ApptController 
{
	
	@FXML
	private VBox apptMainVBOX;
	

	public void switchToTheApptSche(ActionEvent event) throws Exception 
	{
		Main.switchScene("ApptSchedule.fxml");
	}
	
	public void receiveAndDisplayAppt(String apptName, String date, String start, String end, String duration) throws Exception
	{
		System.out.println("Adding now...");
		
		VBox apptInnerVBOX  = new VBox(10);
		
		Label apptNameLabel = new Label();
		Label dateLabel = new Label(); 
		Label startLabel = new Label();
		Label endLabel = new Label();
		Label durationLabel = new Label();
		
		apptNameLabel.setText("Appointment Name: " + apptName);
		dateLabel.setText("Date: " + date);
		startLabel.setText("Start Time: " + start);
		endLabel.setText("End Time: " + end);
		durationLabel.setText("Duration: " + duration);
		
		apptInnerVBOX.getChildren().addAll(apptNameLabel, dateLabel, startLabel, endLabel, durationLabel);
		
		apptMainVBOX.getChildren().add(apptInnerVBOX);
	}
	
	
	
}
