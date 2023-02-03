package application;

import java.io.IOException;
import java.util.Locale;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class Main extends Application {
	private static Scene mainScene;

	@Override
	public void start(Stage primaryStage) {
		try {
			Locale.setDefault(new Locale("pt","BR"));
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/telas/MainView.fxml"));
			ScrollPane scrollPane = loader.load();
			scrollPane.setFitToHeight(true);
			scrollPane.setFitToWidth(true);
			mainScene = new Scene(scrollPane);
			primaryStage.setScene(mainScene);
			primaryStage.setTitle("LEMALOB: Projeto Gente Jovem");
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Scene getMainScene() {
		return mainScene;
	}

	public static void main(String[] args) {
		Locale.setDefault(new Locale("pt","BR"));
		launch(args);
	}

}
