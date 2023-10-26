package view;

import java.util.*;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;//one of the layout helps to content created us!
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.HBox;
import model.SpaceRunnerButton;
import model.SpaceRunnerSubscene;
import model.ShipPicker;
import model.infoLabel;
import model.SHIP;
public class ViewManager {

	private static final int HEIGHT=768;
	private static final int WIDTH=1024;
	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage;
	
	private final static int MENU_BUTTON_START_X = 100;
	private final static int MENU_BUTTON_START_Y = 300;
	
	private SpaceRunnerSubscene credistsSubscene;
	private SpaceRunnerSubscene scoreSubscene;
	private SpaceRunnerSubscene shipChooserscene;
	
	//a field which stores the current Subscene
	private SpaceRunnerSubscene sceneToHide; 
	
	List<SpaceRunnerButton> menuButtons;//define the list where we store the buttons
	List<ShipPicker> shipsList;
	private SHIP choosenShip;
	
	

	public ViewManager() {
		menuButtons=new ArrayList<>();
		mainPane=new AnchorPane();
		mainScene=new Scene(mainPane,WIDTH,HEIGHT);
		mainStage=new Stage();
		mainStage.setScene(mainScene);
		createSubscenes();
		createButtons();
		createBackground();
		createLogo();
		
//		SpaceRunnerSubscene subScene=new SpaceRunnerSubscene();
//		subScene.setLayoutX(200);
//		subScene.setLayoutY(200);
//		mainPane.getChildren().add(subScene);		
	}	
	
	private void showSubscene(SpaceRunnerSubscene subScene)
	{
		if (sceneToHide != null) {
			sceneToHide.moveSubscene();
		}
		
		subScene.moveSubscene();
		sceneToHide = subScene;
		
	}
		
	private void createSubscenes()
	{
		credistsSubscene=new SpaceRunnerSubscene();
		mainPane.getChildren().add(credistsSubscene);
		
		scoreSubscene=new SpaceRunnerSubscene();
		mainPane.getChildren().add(scoreSubscene);	
		
		shipChooserscene=new SpaceRunnerSubscene();
		mainPane.getChildren().add(shipChooserscene);
		
		createShipChooserSubScene();
	}
	
	private HBox createShipsTOChoose() {
		HBox box = new HBox();
		box.setSpacing(60);
		shipsList = new ArrayList<>();
		
		for (SHIP ship : SHIP.values()) {
			ShipPicker shipToPick = new ShipPicker(ship);
			shipsList.add(shipToPick);
			box.getChildren().add(shipToPick);
			shipToPick.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					for (ShipPicker ship : shipsList) {
						ship.setIsCircleChoosen(false);
					}
					shipToPick.setIsCircleChoosen(true);
					choosenShip = shipToPick.getShip();		
				}
			});
		}
		box.setLayoutX(300 - (118*2));
		box.setLayoutY(100);
		return box;
	}
	
	private SpaceRunnerButton createButtonToStart() {
		SpaceRunnerButton startButton = new SpaceRunnerButton("START");
		startButton.setLayoutX(350);
		startButton.setLayoutY(300);
		
		
		startButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (choosenShip != null) {
//					soundClip1.play();
					GameViewManager gameManager = new GameViewManager();
					gameManager.createNewGame(mainStage, choosenShip);;
					
				}
			}
		});
		
		return startButton;
	}
	
	
	private void createShipChooserSubScene() {
		shipChooserscene=new SpaceRunnerSubscene();
		mainPane.getChildren().add(shipChooserscene);
		
		infoLabel chooseShipLabel=new infoLabel("CHOOSE YOUR SHIP");
		chooseShipLabel.setLayoutX(110);
		chooseShipLabel.setLayoutY(25);
		shipChooserscene.getPane().getChildren().add(chooseShipLabel);
	shipChooserscene.getPane().getChildren().add(createShipsTOChoose());
	shipChooserscene.getPane().getChildren().add(createButtonToStart());
	
	}
		
	
		private void AddMenuButtons(SpaceRunnerButton button) {
			button.setLayoutX(MENU_BUTTON_START_X);
			button.setLayoutY(MENU_BUTTON_START_Y + menuButtons.size() * 120);

			menuButtons.add(button);
			mainPane.getChildren().add(button);
		}
	
	public Stage getMainStage() {
		return mainStage;
	}
	
//	private void createButtons() {
//		SpaceRunnerButton button=new SpaceRunnerButton("click !");
//		mainPane.getChildren().add(button);
//		button.setLayoutX(200);
//		button.setLayoutY(200);
//		
//	}
	
	private void createButtons() {
		createStartButton();
		createExitButton();
	}

	private void createStartButton() {
		SpaceRunnerButton startButton = new SpaceRunnerButton("PLAY");
		AddMenuButtons(startButton);
		
		startButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
//				soundClip1.play();
				showSubscene(shipChooserscene);	
			}
		});
	}
	

	private void createExitButton() {
		SpaceRunnerButton exitButton = new SpaceRunnerButton("EXIT");
		AddMenuButtons(exitButton);
		
		exitButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
//				soundClip1.play();
				mainStage.close();
			}
		});
		} 
			
	 
	private void createBackground() {
		Image backgroundImage = new Image("file:///C:/Users/91915/eclipse-workspace/SpaceRunnergame/src/resources/deep_blue.png",256,256,false,true);
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
		mainPane.setBackground(new Background(background));
	}
	
	private void createLogo() {
		ImageView logo = new ImageView("file:///C:/Users/91915/eclipse-workspace/SpaceRunnergame/src/resources/space_runner.png");
		logo.setLayoutX(400);
		logo.setLayoutY(50);
		
//		logo.setOnMouseEntered(new EventHandler<MouseEvent>() {
//
//			@Override
//			public void handle(MouseEvent event) {
//				logo.setEffect(new DropShadow());
//			}
//			});
//		
//		logo.setOnMouseExited(new EventHandler<MouseEvent>() {
//			
//			public void handle(MouseEvent event) {
//				 logo.setEffect(null);
//			}
//		});
		
		mainPane.getChildren().add(logo);
	
	}
	
}



