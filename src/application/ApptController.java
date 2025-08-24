package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;


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
		TextFlow durationFlow = new TextFlow(durationIntroTitle, durationLabel);
		
		
		
		apptInnerVBOX.getChildren().addAll(apptNameFlow, dateFlow, startFlow, endFlow, durationFlow, separator);
		
		apptMainVBOX.getChildren().addAll(apptInnerVBOX);
	}
	
	public void deleteAppt(ActionEvent event) throws IOException
	{
		//apptMainVBOX.getChildren().remove(0);
		Stage deletePopUpStg = new Stage();
		deletePopUpStg.initModality(Modality.APPLICATION_MODAL);
		deletePopUpStg.setTitle("Delete an Appointment");
		
		Label apptNameLabel = new Label("Please enter the name of the appointment you want deleted:");
		TextField apptNameTxtField = new TextField();
		
		Label dateLabel = new Label("Please enter the date of the appointment you want deleted:");
		TextField dateTxtField = new TextField();
		
		Label startTimeLabel = new Label("Please enter the starting time of the appointment you want deleted:");
		TextField startTimeTxtField = new TextField();

		
		 
		Button deleteOptionChosenBtn = new Button("Delete");
		
		deleteOptionChosenBtn.setOnAction(e -> {
            System.out.println("User entered: " + apptNameTxtField.getText() + ", " + dateTxtField.getText() + ", " + startTimeTxtField.getText());
            deletePopUpStg.close();
        });
		
		
		 VBox deleteVBOX = new VBox(10, apptNameLabel, apptNameTxtField, dateLabel, dateTxtField, startTimeLabel, startTimeTxtField, deleteOptionChosenBtn);
	     deleteVBOX.setPadding(new Insets(15));
	     deleteVBOX.setAlignment(Pos.CENTER);
	     
	     Scene deleteScene = new Scene(deleteVBOX, 550, 350);
	     
	     deletePopUpStg.setScene(deleteScene);
	     deletePopUpStg.showAndWait();
	}
	
	
	
}
