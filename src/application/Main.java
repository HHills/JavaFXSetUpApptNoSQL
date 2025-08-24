package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class Main extends Application 
{
    public static Stage primaryStage;

	@Override
	public void start(Stage stage) 
	{
		try 
		{
			primaryStage = stage;
			Parent root = FXMLLoader.load(getClass().getResource("FrontPage.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void switchScene(String fxmlFile) throws Exception 
	{
        Parent root = FXMLLoader.load(Main.class.getResource(fxmlFile));
        primaryStage.setScene(new Scene(root));
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
