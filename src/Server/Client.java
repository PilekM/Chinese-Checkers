package Server;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Client extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		//StackPanes declarations
		StackPane loginRoot = new StackPane();
		StackPane menuRoot = new StackPane();
		StackPane serverlistRoot = new StackPane();	
		StackPane lobbyRoot = new StackPane();
		StackPane gameRoot = new StackPane();
		
		
		//Controls declarations and such
		Label nameLabel = new Label("Type your nickname below");
		TextField nameField = new TextField();
		Button loginButton = new Button();
		loginRoot.getChildren().add(nameLabel);
		loginRoot.getChildren().add(nameField);
		loginRoot.getChildren().add(loginButton);
		
		Button hostButton = new Button();
		Button joinButton = new Button();		
		menuRoot.getChildren().add(hostButton);
		menuRoot.getChildren().add(joinButton);
		
			
		//Scenes declarations	
		Scene loginScene = new Scene(loginRoot, 960, 720);
		Scene menuScene = new Scene(menuRoot, 960, 720);
		Scene serverlistScene = new Scene(serverlistRoot, 960, 720);
		Scene lobbyScene = new Scene(lobbyRoot, 960, 720);
		Scene gameScene = new Scene(gameRoot, 960, 720);
		
		
		//EventHandlers
		loginButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				if(nameField.getText() != null && !nameField.getText().isEmpty())
				{
					primaryStage.setScene(menuScene);
				}

			}
		});
		
		hostButton.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent event)
			{
				primaryStage.setScene(lobbyScene);
				//utworzenie lobby
			}
		});
		
		joinButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				primaryStage.setScene(serverlistScene);
			}
		});
			
		
		//Stage stuff
		primaryStage.setTitle("HALMA");
		primaryStage.setScene(loginScene);
		primaryStage.show();
		
		
	}	
}