import acsse.csca2a.GUI.WorldPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author MT LUBISI
 * @version PX
 */
public class Main extends Application {

	public static void main(String[] args) {

		launch(args);
		
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setScene(new Scene(new WorldPane() , 500 , 600));
		primaryStage.show();
		
	}

}
