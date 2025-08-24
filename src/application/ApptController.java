package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextFlow;


public class ApptController 
{
	private Main mainApp;
	
	@FXML
	private VBox apptMainVBOX;
	
	public void setMainApp(Main mainApp) 
	{
	        this.mainApp = mainApp;
	}
	
	public void switchToTheApptSche(ActionEvent event) throws Exception 
	{
		Main.switchToTheApptSche();
	}
	
	public void receiveAndDisplayAppt(String apptName, String date, String start, String end, String duration) throws Exception
	{
		System.out.println("Adding now...");
		
		apptMainVBOX.setSpacing(10);
		
		VBox apptInnerVBOX  = new VBox(10);
		
		Label apptNameLabel = new Label(apptName);
		apptNameLabel.setFont(Font.font("Segoe UI Semibold", 14));
		apptNameLabel.setWrapText(true); 
		apptNameLabel.setMaxWidth(400);

		Label dateLabel = new Label(date); 
		dateLabel.setFont(Font.font("Segoe UI Semibold", 14));
		dateLabel.setWrapText(true); 
		dateLabel.setMaxWidth(400);

		Label startLabel = new Label(start);
		startLabel.setFont(Font.font("Segoe UI Semibold", 14));
		startLabel.setWrapText(true); 
		startLabel.setMaxWidth(400);

		Label endLabel = new Label(end);
		endLabel.setFont(Font.font("Segoe UI Semibold", 14));
		endLabel.setWrapText(true); 
		endLabel.setMaxWidth(400);

		Label durationLabel = new Label(duration);
		durationLabel.setFont(Font.font("Segoe UI Semibold", 14));
		durationLabel.setWrapText(true); 
		durationLabel.setMaxWidth(400);

		
		Label apptIntroTitle = new Label("Appointment Name: ");
		apptIntroTitle.setFont(Font.font("Segoe UI Black", 14));
		apptIntroTitle.setStyle("-fx-text-fill: #374a69");
		
		Label dateIntroTitle = new Label("Date: ");
		dateIntroTitle.setStyle("-fx-font-weight: bold;");
		dateIntroTitle.setFont(Font.font("Segoe UI Black", 14));
		dateIntroTitle.setStyle("-fx-text-fill: #374a69");
		
		Label startIntroTitle = new Label("Start Time: ");
		startIntroTitle.setFont(Font.font("Segoe UI Black", 14));
		startIntroTitle.setStyle("-fx-text-fill: #374a69");
		
		Label endIntroTitle = new Label("End Time: ");
		endIntroTitle.setFont(Font.font("Segoe UI Black", 14));
		endIntroTitle.setStyle("-fx-text-fill: #374a69");
		
		Label durationIntroTitle = new Label("Duration: ");
		durationIntroTitle.setFont(Font.font("Segoe UI Black", 14));
		durationIntroTitle.setStyle("-fx-text-fill: #374a69");
		
		Separator separator = new Separator();

		
		TextFlow apptNameFlow = new TextFlow(apptIntroTitle, apptNameLabel);
		TextFlow dateFlow = new TextFlow(dateIntroTitle, dateLabel);
		TextFlow startFlow = new TextFlow(startIntroTitle, startLabel);
		TextFlow endFlow = new TextFlow(endIntroTitle, endLabel);
		TextFlow durationFlow = new TextFlow(durationIntroTitle, durationLabel, separator);
		
		
		
		apptInnerVBOX.getChildren().addAll(apptNameFlow, dateFlow, startFlow, endFlow, durationFlow);
		
		apptMainVBOX.getChildren().addAll(apptInnerVBOX, separator);
	}
	
	public void deleteAppt(ActionEvent event) throws IOException
	{
		apptMainVBOX.getChildren().remove(1);
	}
	
	
	
}
