package application;
	
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class Main extends Application 
{
    public static Stage primaryStage;

    private static Parent apptControllerRoot;
    public static ApptController apptController;
    
    private static Parent apptController2Root;
    private ApptController2 apptController2;
    
    private static Scene scene;
    private List<Appointments> appts = new ArrayList<>();
	private FileHandler handler = new FileHandler();
    
    
    
	@Override
	public void start(Stage stage) 
	{
		try 
		{
			primaryStage = stage;
			
			primaryStage.setResizable(false);
			
	        primaryStage.setTitle("AetherCore Appointment Scheduler");
	        
	        primaryStage.getIcons().add(new Image("file:Resources/TASKBAR AND WINDOW ICON AETHERCORE LOGO.png"));
	        
	        
	        FXMLLoader apptControllerLoader1 = new FXMLLoader(getClass().getResource("FrontPage.fxml"));
	        apptControllerRoot = apptControllerLoader1.load();
	        apptController = apptControllerLoader1.getController();
	        apptController.setMainApp(this, handler, appts);
	        
	        FXMLLoader apptControllerLoader2 = new FXMLLoader(getClass().getResource("ApptSchedule.fxml"));
	        apptController2Root = apptControllerLoader2.load();
	        apptController2 = apptControllerLoader2.getController();
	        apptController2.setMainApp(this);
	        
	        
	        			
			scene = new Scene(apptControllerRoot);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setOnCloseRequest((WindowEvent event) -> 
			{
	            System.out.println("Exiting Program...\nSaving Appointment Data...");
	            apptController.saveData();
	            
	            
	        });
			apptController.loadData();
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		} catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void switchToTheApptSche() throws Exception 
	{
		try 
		{
			 scene.setRoot(apptController2Root);
			 primaryStage.setScene(scene);
			 
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
    }
	
	public static void switchToFrontPage()
	{
		try 
		{
			scene.setRoot(apptControllerRoot);
			primaryStage.setScene(scene);
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
