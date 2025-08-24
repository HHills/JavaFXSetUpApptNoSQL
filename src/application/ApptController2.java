package application;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.DateCell;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;


public class ApptController2 implements Initializable
{
	private Main mainApp;
	 
	@FXML
	private DatePicker datePicker;
	
	@FXML
	private TextField apptNameTxtField;
	
	@FXML
	private Label calculatedDuration;
	
	@FXML
	private ChoiceBox<String> startTime;
	
	@FXML
	private ChoiceBox<String> endTime;
	
	
	@FXML
	private ImageView apptErrorImg;
	
	@FXML
	private ImageView dateErrorImg;
	
	@FXML
	private ImageView startTimeErrorImg;
	
	@FXML
	private ImageView endTimeErrorImg;
	
	@FXML
	private Label apptErrorLabel;
	
	@FXML
	private Label dateErrorLabel;
	
	@FXML
	private Label startTimeErrorLabel;
	
	@FXML
	private Label endTimeErrorLabel;
	
	private String formattedDate;
	
	private String finalDuration;
	
	private String[] meetingTimes = {"12:00 AM","12:15 AM","12:30 AM","12:45 AM","1:00 AM","1:15 AM","1:30 AM","1:45 AM","2:00 AM","2:15 AM","2:30 AM","2:45 AM","3:00 AM","3:15 AM","3:30 AM","3:45 AM","4:00 AM","4:15 AM","4:30 AM","4:45 AM","5:00 AM","5:15 AM","5:30 AM","5:45 AM","6:00 AM","6:15 AM","6:30 AM","6:45 AM","7:00 AM","7:15 AM","7:30 AM","7:45 AM","8:00 AM","8:15 AM","8:30 AM","8:45 AM","9:00 AM","9:15 AM","9:30 AM","9:45 AM","10:00 AM","10:15 AM","10:30 AM","10:45 AM","11:00 AM","11:15 AM","11:30 AM","11:45 AM","12:00 PM","12:15 PM","12:30 PM","12:45 PM","1:00 PM","1:15 PM","1:30 PM","1:45 PM","2:00 PM","2:15 PM","2:30 PM","2:45 PM","3:00 PM","3:15 PM","3:30 PM","3:45 PM","4:00 PM","4:15 PM","4:30 PM","4:45 PM","5:00 PM","5:15 PM","5:30 PM","5:45 PM","6:00 PM","6:15 PM","6:30 PM","6:45 PM","7:00 PM","7:15 PM","7:30 PM","7:45 PM","8:00 PM","8:15 PM","8:30 PM","8:45 PM","9:00 PM","9:15 PM","9:30 PM","9:45 PM","10:00 PM","10:15 PM","10:30 PM","10:45 PM","11:00 PM","11:15 PM","11:30 PM","11:45 PM"};


	
	public void setMainApp(Main mainApp) 
	{
	        this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{	
		endTime.getItems().addAll(meetingTimes);
		startTime.getItems().addAll(meetingTimes);

		// Disables picking a date before current date
		datePicker.setDayCellFactory(picker -> new DateCell() {
			 public void updateItem(LocalDate date, boolean empty) 
			 {
		            super.updateItem(date, empty);
		            LocalDate today = LocalDate.now();

		            setDisable(empty || date.compareTo(today) < 0 );
		     }
		});
		
		
		startTime.getSelectionModel().selectedItemProperty().addListener((observe, oldVal, newVal) -> {
			if(newVal != null)
			{
				System.out.println("Start time selected: " + newVal);
				checkBothSelected();
			}
        });
		
		endTime.getSelectionModel().selectedItemProperty().addListener((observe, oldVal, newVal) -> {
            if(newVal != null)
            {
            	System.out.println("End time selected: " + newVal);
            	checkBothSelected();
            }
        });
		
		apptErrorLabel.setVisible(false);
        apptErrorImg.setVisible(false);
        dateErrorLabel.setVisible(false);
        dateErrorImg.setVisible(false);
        startTimeErrorLabel.setVisible(false);
        startTimeErrorImg.setVisible(false);
        endTimeErrorLabel.setVisible(false);
        endTimeErrorImg.setVisible(false);

	}

	public void switchToFrontPage(ActionEvent event) throws Exception 
	{
		Main.switchToFrontPage();
	}

	public void getDate(ActionEvent event) throws IOException
	{
		if(datePicker.getValue() != null)
		{
			LocalDate myDate = datePicker.getValue();
			formattedDate = myDate.format(DateTimeFormatter.ofPattern("M/d/yyyy"));
			System.out.println(formattedDate);
		}
	}
	
	public void addAppt(ActionEvent event) throws Exception
	{
		int numOfErrors = inputValidation();
		
		
		if(numOfErrors == 0)
		{
			System.out.println("Approved!");
			System.out.println("Appt Name: " + apptNameTxtField.getText());
			System.out.println("Date: " + formattedDate);
			System.out.println("Start Time: " + startTime.getValue());
			System.out.println("End Time: " + endTime.getValue());
			System.out.println("Duration: " + finalDuration);
			
			
			//FXMLLoader loader = new FXMLLoader(getClass().getResource("FrontPage.fxml"));
			//Parent root = loader.load();
			//ApptController apptController = (ApptController) loader.getController();
			
			try 
			{
				Main.apptController.receiveAndDisplayAppt(apptNameTxtField.getText(), formattedDate, startTime.getValue(), endTime.getValue(), finalDuration);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			
			clear();
			Main.switchToFrontPage();
		}
		
		
	}
	
	public int inputValidation()
	{
		int inputFailures = 0;
		
		if(apptNameTxtField.getText().isBlank())
		{
			apptErrorLabel.setVisible(true);
	        apptErrorImg.setVisible(true);
			
	        inputFailures += 1;
		}
		else
		{
			apptErrorLabel.setVisible(false);
	        apptErrorImg.setVisible(false);
		}
		
		
		if(startTime.getValue() == null)
		{
			startTimeErrorLabel.setVisible(true);
	        startTimeErrorImg.setVisible(true);
	        
	        inputFailures += 1;
		}
		else
		{
			startTimeErrorLabel.setVisible(false);
	        startTimeErrorImg.setVisible(false);
		}
		

		if(endTime.getValue() == null)
		{
			endTimeErrorLabel.setVisible(true);
	        endTimeErrorImg.setVisible(true);
	       
	        inputFailures += 1;
		}
		else
		{
			endTimeErrorLabel.setVisible(false);
	        endTimeErrorImg.setVisible(false);
		}
		
		if(formattedDate == null)
		{
			dateErrorLabel.setVisible(true);
	        dateErrorImg.setVisible(true);
	        
	        inputFailures += 1;
		}
		else
		{
			dateErrorLabel.setVisible(false);
	        dateErrorImg.setVisible(false);
		}
		
		return inputFailures;
	}
	
	public void checkBothSelected() 
	{
		String startTimeValue = startTime.getValue();
		String endTimeValue = endTime.getValue();
		
		if (startTimeValue != null && endTimeValue != null)
		{
			System.out.println("Calculations starting now..." + startTimeValue + " and " + endTimeValue);
			
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
	        
	        LocalTime formattedStartTime = LocalTime.parse(startTimeValue, formatter);
	        LocalTime formattedEndTime = LocalTime.parse(endTimeValue, formatter);
	        
	        
	        // Use a dummy date to ensure that the time calculation is correct and does not generate negative nums
	        LocalDateTime dateStart = LocalDateTime.of(2000, 1, 1, formattedStartTime.getHour(), formattedStartTime.getMinute());
	        LocalDateTime dateEnd = LocalDateTime.of(2000, 1, 1, formattedEndTime.getHour(), formattedEndTime.getMinute());


	        // Calculates the hours more correctly as a day has passed
	        if(dateEnd.isBefore(dateStart))
	        {
	        	dateEnd = dateEnd.plusDays(1);
	        }
	       
	        Duration duration =  Duration.between(dateStart, dateEnd);

	        
	        
	        long hours = duration.toHours();
	        long minutes = duration.toMinutes() % 60;
	        
	        // Getting the absolute value in case the time period crosses over to the next day
	        
	        finalDuration = hours + " hrs " + minutes + " mins";
	        calculatedDuration.setText(hours + " hrs " + minutes + " mins");

		}
	}
	
	public void clear()
	{
        apptNameTxtField.setText("");
        formattedDate = null;
        datePicker.setValue(null);
        startTime.getSelectionModel().clearSelection();
        endTime.getSelectionModel().clearSelection();
        calculatedDuration.setText("");
	}
		
}
