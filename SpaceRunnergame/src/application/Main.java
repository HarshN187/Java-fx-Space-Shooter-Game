package application;  
	
import javafx.application.Application;
import javafx.stage.Stage;
import view.ViewManager;
import javafx.scene.image.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
	try {
			ViewManager manager=new ViewManager();
			primaryStage = manager.getMainStage();
			primaryStage.setTitle("SpaceRunnerGame");
			primaryStage.resizableProperty().setValue(false);
			//primaryStage.initStyle(StageStyle.UTILITY);
			Image icon=new Image("file:///C:/Users/91915/eclipse-workspace/SpaceRunnergame/src/resources/green_ship.png");
			primaryStage.getIcons().add(icon);
			
			String musicFile = "C:\\Users\\91915\\eclipse-workspace\\SpaceRunnergame\\src\\resources\\alexander-nakarada-space-ambience.mp3";
	        Media sound = new Media(new File(musicFile).toURI().toString());
	        MediaPlayer mediaPlayer = new MediaPlayer(sound);

	        // Play the audio
	        mediaPlayer.play();
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace(); 
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}


