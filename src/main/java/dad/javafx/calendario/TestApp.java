package dad.javafx.calendario;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TestApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		MonthComponent root = new MonthComponent();
		root.setMonthProperty(1);
		root.setYearProperty(2020);
		
		Scene scene = new Scene(root,320,200);
		
		primaryStage.setTitle("Custom componetns test app");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
