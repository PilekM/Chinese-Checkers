import javafx.*;

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
		//////////
		Button hostButton = new Button();
		Button joinButton = new Button();		
		menuRoot.getChildren().add(hostButton);
		menuRoot.getChildren().add(joinButton);
		//////////
		ListView<String> lobbyList = new ListView<>();
		ObservableList<String> lobbies = FXCollections.observableArrayList("1/6","2/4","5/6");
		lobbyList.setItems(lobbies);
		serverlistRoot.getChildren().add(lobbyList);
		//tu jakies dodawanie serweruf ;\
		//////////
		ListView<String> playerList = new ListView<>();
		ObservableList<String> players = FXCollections.observableArrayList("Best player", "Senor VAC");
		playerList.setItems(players);
		lobbyRoot.getChildren().add(playerList);
		//tu jakies dodawanie ludzikuf ;\
		//////////
		//tu jusz plansza
		
			
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