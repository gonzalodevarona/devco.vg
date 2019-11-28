package gui;
	
import control.AppControl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			AppControl ac = new AppControl();
			
			Parent root = FXMLLoader.load(getClass().getResource("../gui/firstW.fxml"));
	        ac.startApp();
	        
	        primaryStage.setScene(new Scene(root));
	        primaryStage.setTitle("D E V C O . v g");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
