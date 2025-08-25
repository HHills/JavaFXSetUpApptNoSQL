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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
		int numOfErrors;
		
		//apptMainVBOX.getChildren().remove(0);
		Stage deletePopUpStg = new Stage();
		deletePopUpStg.initModality(Modality.APPLICATION_MODAL);
		deletePopUpStg.setTitle("Delete an Appointment");
		deletePopUpStg.getIcons().add(new Image("file:Resources/TASKBAR AND WINDOW ICON AETHERCORE LOGO DELETE VERSION.png"));
		
		Label apptNameLabel = new Label("Please enter the name of the appointment you want deleted:");
		apptNameLabel.setFont(Font.font("System", FontWeight.BOLD,  14));
		apptNameLabel.setStyle("-fx-text-fill: #374a69");
		
		TextField apptNameTxtField = new TextField();
		apptNameTxtField.setPrefWidth(200); 
		apptNameTxtField.setMinWidth(100); 
		apptNameTxtField.setMaxWidth(600);
		
		Label dateLabel = new Label("Please enter the date of the appointment you want deleted:");
		dateLabel.setFont(Font.font("System", FontWeight.BOLD, 14));
		dateLabel.setStyle("-fx-text-fill: #374a69");
		
		TextField dateTxtField = new TextField();
		dateTxtField.setPromptText("M/d/yyyy (EX: 8/8/2025, 8/31/2025)");
		dateTxtField.setPrefWidth(200); 
		dateTxtField.setMinWidth(100); 
		dateTxtField.setMaxWidth(600);
		
		Label startTimeLabel = new Label("Please enter the starting time of the appointment you want deleted:");
		startTimeLabel.setFont(Font.font("System", FontWeight.BOLD, 14));
		startTimeLabel.setStyle("-fx-text-fill: #374a69");
		
		TextField startTimeTxtField = new TextField();
		startTimeTxtField.setPrefWidth(200); 
		startTimeTxtField.setMinWidth(100); 
		startTimeTxtField.setMaxWidth(600);
		startTimeTxtField.setPromptText("0:00 AM/PM (EX: 8:00 PM, 12:00 AM)");


		
		 
		Button deleteOptionChosenBtn = new Button("Delete");
		deleteOptionChosenBtn.setStyle("-fx-background-radius: 20; " + "-fx-background-color: #eb8888; " + "-fx-font-weight: bold;");
		deleteOptionChosenBtn.setPrefWidth(100);
		
		
	    Image textErrorImg = new Image("file:Resources/exclamation.png");
		ImageView apptErrorImg = new ImageView(textErrorImg);
		apptErrorImg.setFitWidth(24);
		apptErrorImg.setFitHeight(26);
		apptErrorImg.setPreserveRatio(true);
		 
		HBox apptContainer = new HBox(5, apptNameLabel, apptErrorImg);
		apptContainer.setAlignment(Pos.CENTER);
		
		ImageView dateErrorImg = new ImageView(textErrorImg);
		dateErrorImg.setFitWidth(24);
		dateErrorImg.setFitHeight(26);
		dateErrorImg.setPreserveRatio(true);
		 
		HBox dateContainer = new HBox(5, dateLabel, dateErrorImg);
		dateContainer.setAlignment(Pos.CENTER);
		
		ImageView startTimeErrorImg = new ImageView(textErrorImg);
		startTimeErrorImg.setFitWidth(24);
		startTimeErrorImg.setFitHeight(26);
		startTimeErrorImg.setPreserveRatio(true);
		
		 
		HBox startContainer = new HBox(5, startTimeLabel, startTimeErrorImg);
		startContainer.setAlignment(Pos.CENTER);
		
		
		Label apptWarningMsg = new Label("Please enter the name of the appointment");
		apptWarningMsg.setWrapText(true); 
		apptWarningMsg.setMaxWidth(600);
		apptWarningMsg.setFont(Font.font("System", FontWeight.BOLD,  12));
		apptWarningMsg.setStyle("-fx-text-fill: #ff0000; " + "-fx-alignment: center;");

		
		Label dateWarningMsg = new Label("Error: Either no date was entered or date isn't in M/d/yyyy (EX: 8/8/2025, 8/31/2025)");
		dateWarningMsg.setWrapText(true); 
		dateWarningMsg.setMaxWidth(600);
		dateWarningMsg.setFont(Font.font("System", FontWeight.BOLD,  12));
		dateWarningMsg.setStyle("-fx-text-fill: #ff0000; " + "-fx-alignment: center;");
		
		Label startWarningMsg = new Label("Error: either no starting time was entered or time isn't in 0:00 AM/PM (EX: 8:00 PM, 12:00 AM)");
		startWarningMsg.setWrapText(true); 
		startWarningMsg.setMaxWidth(600);
		startWarningMsg.setFont(Font.font("System", FontWeight.BOLD,  12));
		startWarningMsg.setStyle("-fx-text-fill: #ff0000; " + "-fx-alignment: center;");
		
		Label searchFailureMsg = new Label ("Could not find the appointment: ");
		searchFailureMsg.setWrapText(true); 
		searchFailureMsg.setMaxWidth(600);
		searchFailureMsg.setFont(Font.font("System", FontWeight.BOLD,  12));
		searchFailureMsg.setStyle("-fx-text-fill: #ff0000; " + "-fx-alignment: center;");
		
		Region spacer1 = new Region();
		spacer1.setPrefHeight(30);
		
		Region spacer2 = new Region();
		spacer2.setPrefHeight(45);
		 
		VBox deleteVBOX = new VBox(10, apptContainer, apptNameTxtField, dateContainer, dateTxtField, startContainer, startTimeTxtField,
								   spacer1, apptWarningMsg, dateWarningMsg, startWarningMsg, searchFailureMsg, spacer2, deleteOptionChosenBtn);
	    deleteVBOX.setPadding(new Insets(20));
	    deleteVBOX.setAlignment(Pos.CENTER);
	    deleteVBOX.setStyle("-fx-background-color: #e9edf5;");
	     
	    Scene deleteScene = new Scene(deleteVBOX, 700, 550);
	    
		apptErrorImg.setVisible(false);
		dateErrorImg.setVisible(false);
		startTimeErrorImg.setVisible(false);
		
		apptWarningMsg.setVisible(false);
		dateWarningMsg.setVisible(false);
		startWarningMsg.setVisible(false);
		searchFailureMsg.setVisible(false);
	    
	    
	    deleteOptionChosenBtn.setOnAction(e -> {
	    	inputValidation(apptNameTxtField.getText(), dateTxtField.getText(), startTimeTxtField.getText(),
	    					apptErrorImg, dateErrorImg, startTimeErrorImg, apptWarningMsg, dateWarningMsg, startWarningMsg);
            //System.out.println("User entered: " + apptNameTxtField.getText() + ", " + dateTxtField.getText() + ", " + startTimeTxtField.getText());
            //deletePopUpStg.close();
        });
	     
	    deletePopUpStg.setScene(deleteScene);
	    deletePopUpStg.showAndWait();
	     
	     
	}
	
	public int inputValidation(String chosenApptName, String chosenDate, String chosenStartTime, ImageView apptErrorImg, ImageView dateErrorImg, ImageView startTimeErrorImg, Label warningAppt, Label warningDate, Label warningStart)
	{
		int inputFailures = 0;
		
		if(chosenApptName.isBlank())
		{
			inputFailures += 1;
			
			apptErrorImg.setVisible(true);
			warningAppt.setVisible(true);
		}
		else
		{
			apptErrorImg.setVisible(false);
			warningAppt.setVisible(false);
		}
		
		if(!chosenDate.matches("^([1-9]|1[0-2])/([1-9]|[12][0-9]|3[01])/([0-9]{4})$"))
		{
			inputFailures += 1;
			
			dateErrorImg.setVisible(true);
			warningDate.setVisible(true);

		}
		else
		{
			dateErrorImg.setVisible(false);
			warningDate.setVisible(false);
		}
		
		if(!chosenStartTime.matches("^([1-9]|1[0-2]):[0-5][0-9]\\s?(AM|PM)$"))
		{
			inputFailures += 1;
			
			startTimeErrorImg.setVisible(true);
			warningStart.setVisible(true);
		}
		else
		{
			startTimeErrorImg.setVisible(false);
			warningStart.setVisible(false);
		}
		
			return inputFailures;
	}
	
	
	
}
