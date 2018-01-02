package Client;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.*;

import java.io.IOException;


public class Client extends Application {

    static MyServer server = new MyServer();
    static Game game;

     StackPane initGamePane(int base){
        StackPane gameRoot = new StackPane();
        VBox gameVBox = new VBox(6);
        gameVBox.setPadding(new Insets(0));
        HBox[] gameHBox = new HBox[8*base+1];
        Field field[][] = game.getBoard().getFields();

        ToggleButton[][] fieldButton = new ToggleButton[6*base+1][8*base+1];
        ImageView[][] toggleImage = new ImageView[6*base+1][8*base+1];
        for(int i=0; i<8*base+1; i++)
        {
            gameHBox[i]= new HBox(12);
            gameHBox[i].setPadding(new Insets(0));
            for(int j=0; j<6*base+1;j++)
            {
                fieldButton[j][i] = new ToggleButton();
                if(field[j][i].getIsField() == true)
                {
                    gameHBox[i].getChildren().add(fieldButton[j][i]);
                    toggleImage[j][i] = new ImageView();
                    if(field[j][i].getBase()>0)
                    {
                        if(field[j][i].getBase()==1) toggleImage[j][i].setImage(new Image("Client/base1.png"));
                        else if(field[j][i].getBase()==2) toggleImage[j][i].setImage(new Image("Client/base2.png"));
                        else if(field[j][i].getBase()==3) toggleImage[j][i].setImage(new Image("Client/base3.png"));
                        else if(field[j][i].getBase()==4) toggleImage[j][i].setImage(new Image("Client/base4.png"));
                        else if(field[j][i].getBase()==5) toggleImage[j][i].setImage(new Image("Client/base5.png"));
                        else if(field[j][i].getBase()==6) toggleImage[j][i].setImage(new Image("Client/base6.png"));

                    }
                    else{
                         toggleImage[j][i].setImage(new Image("Client/base0.png"));
                    }
                    /*else if(field[j][i].getChecker()>0)
                    {
                        if(field[j][i].getChecker()==1) toggleImage.setImage(new Image("Client/player1.png"));
                        else if(field[j][i].getChecker()==2) toggleImage.setImage(new Image("Client/player2.png"));
                        else if(field[j][i].getChecker()==3) toggleImage.setImage(new Image("Client/player3.png"));
                        else if(field[j][i].getChecker()==4) toggleImage.setImage(new Image("Client/player4.png"));
                        else if(field[j][i].getChecker()==5) toggleImage.setImage(new Image("Client/player5.png"));
                        else if(field[j][i].getChecker()==6) toggleImage.setImage(new Image("Client/player6.png"));
                    }*/
                    //if(field[j][i].getCanMove)//czy da sie tam wskoczyć?
                    //{
                    //	toggleImage.setImage(new Image("canmove.png"));
                    //}
                    fieldButton[j][i].setGraphic(toggleImage[j][i]);
                }
                gameHBox[i].setAlignment(Pos.CENTER);
            }
            gameVBox.getChildren().add(gameHBox[i]);
        }
        ImageView gameBackground = new ImageView();
        gameBackground.setImage(new Image("Client/background.png"));
        gameRoot.getChildren().add(gameBackground);
        gameRoot.getChildren().add(gameVBox);

        return gameRoot;
    }
    void startListening() throws IOException{
        String input = null;
        while( (input=server.in.readLine()) != null){
                System.out.println(input);
                String commandParts[] = input.split("~");

                switch (commandParts[0]) {
                    case ("REPAINT"):
                        break;
                    case ("STARTGAME"):
                        break;
                }
            }
        }

    @Override
    public void start(Stage primaryStage) {

        StackPane gameRoot = new StackPane();

        //Panes and Controls declarations and such
        VBox loginBox = new VBox(10);
        loginBox.setPadding(new Insets(350));

        Label nameLabel = new Label("Type your nickname below");
        TextField nameField = new TextField();

        Button loginButton = new Button("LOGIN");
        loginBox.getChildren().add(nameLabel);
        loginBox.getChildren().add(nameField);
        loginBox.getChildren().add(loginButton);
        loginBox.setAlignment(Pos.CENTER);

        //////////
        StackPane menuRoot = new StackPane();
        VBox menuBox = new VBox(30);
        menuBox.setPadding(new Insets(300, 300, 0, 300));


        ImageView menuBackground = new ImageView();
        menuBackground.setImage(new Image("Client/halmafinal.png"));
        Button hostButton = new Button("HOST");
        Button joinButton = new Button("JOIN");
        menuRoot.getChildren().add(menuBackground);
        menuBox.getChildren().add(hostButton);
        menuBox.getChildren().add(joinButton);
        menuBox.setAlignment(Pos.CENTER);
        menuRoot.getChildren().add(menuBox);
        //////////
        StackPane serverlistRoot = new StackPane();
        ListView<String> lobbyList = new ListView<>();

        //tu jakies dodawanie serweruf ;\
        //////////
        HBox lobbyBox = new HBox(10);
        lobbyBox.setPadding(new Insets(0));
        ListView<String> playerList = new ListView<>();
        final ObservableList<String>[] lobbies = new ObservableList[1];
        lobbyBox.getChildren().add(playerList);
        Button startButton = new Button ("START");
        Button readyButton = new Button("READY");
        Button unreadyButton = new Button("NOT READY");
        Button exitButton = new Button("EXIT");
        Button refreshButton = new Button("REFRESH");
        lobbyBox.getChildren().add(startButton);
        lobbyBox.getChildren().add(readyButton);
        lobbyBox.getChildren().add(unreadyButton);
        lobbyBox.getChildren().add(exitButton);
        lobbyBox.getChildren().add(refreshButton);
        //tu jakies dodawanie ludzikuf ;\
        //////////



        //choosing settings for game panel
        VBox creatingRoot = new VBox(10);
        Button createButton = new Button("CREATE");
        final ComboBox numberOfPlayersBox = new ComboBox();
        final ComboBox numberOfBaseBox = new ComboBox();
        numberOfPlayersBox.getItems().addAll("2","3","4","6");
        numberOfBaseBox.getItems().addAll("2","3","4");
        creatingRoot.getChildren().add(createButton);
        creatingRoot.getChildren().add(numberOfPlayersBox);
        creatingRoot.getChildren().add(numberOfBaseBox);
        creatingRoot.setAlignment(Pos.CENTER);

        //trzeba go dodac do jakiegos boxa XD


        //Scenes declarations
        Scene loginScene = new Scene(loginBox, 960, 720);
        Scene menuScene = new Scene(menuRoot, 960, 720);
        Scene serverlistScene = new Scene(serverlistRoot, 960, 720);
        Scene lobbyScene = new Scene(lobbyBox, 960, 720);
        //Scene gameScene = new Scene(gameRoot, 960, 720);
        Scene creatingScene = new Scene(creatingRoot,960,720);


        //EventHandlers
        lobbyList.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                server.send("JOINGAME");
                primaryStage.setScene(lobbyScene);
               // startListening(playerList);
            }
        });
        loginButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                if(nameField.getText() != null && !nameField.getText().isEmpty())
                {
                    primaryStage.setScene(menuScene);
                    server.send("SETNAME~"+nameField.getText());
                }

            }
        });

        hostButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                primaryStage.setScene(creatingScene);
                //utworzenie lobby
            }
        });

        joinButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                server.send("SHOWGAME~");
                System.out.println("wszedlem");
                String input=null;
                try {
                    input = server.in.readLine();
                    System.out.println(input);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(input.equals("BRAK") || input == null){
                    System.out.println("Nie ma gierki");
                }
                else {
                    String[] commands = input.split("~");

                    if (commands[0].equals(commands[1])) {
                        System.out.println("Nie ma gierki");
                    }
                    else {
                        String gameDescript = "Players: " + commands[1] + "/" + commands[0];
                        ObservableList<String> lobbies = FXCollections.observableArrayList(gameDescript);
                        lobbyList.setItems(lobbies);
                        serverlistRoot.getChildren().add(lobbyList);
                        primaryStage.setScene(serverlistScene);
                    }
                }

            }
        });

        createButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String rows = numberOfBaseBox.getValue().toString();
                String players = numberOfPlayersBox.getValue().toString();
                game = new Game(Integer.valueOf(rows),Integer.valueOf(players));
                String command = "CREATEGAME~"+players+"~"+rows;
                System.out.println(command);
                server.send(command);
                server.send("JOINGAME");
                primaryStage.setScene(lobbyScene);
                //utworzenie lobby


                /* UTWORZENIE GAMESCENE DO SKOPIOWANKA
                StackPane gameRoot2 = initGamePane(Integer.valueOf(rows));
                Scene gameScene = new Scene(gameRoot2, 960, 720);
                primaryStage.setScene(gameScene);
                */
            }
        });

        readyButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                server.send("SETREADY");
                try {
                    startListening();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                server.send("GIVEROWS");
                String input = null;
                try {
                    input = server.in.readLine();
                }
                catch (IOException e)
                {
                    System.out.println(e);
                }
                server.send("STARTGAME");
                StackPane gameRoot2 = initGamePane(Integer.valueOf(input));
                Scene gameScene = new Scene(gameRoot2, 960, 720);
                primaryStage.setScene(gameScene);

            }
        });

        refreshButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                server.send("REFRESH");

                String input = null;

                try {
                    input = server.in.readLine();
                    System.out.println(input);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (input == null) {
                } else {

                    String commandParts[] = input.split("~");
                    switch (commandParts[0]) {
                        case ("REPAINT"):
                            System.out.println("wszezlem");
                            String people[] = new String[6];
                            for (int i = 1; i < commandParts.length; i++) {

                                people[i - 1] = commandParts[i];
                            }
                            lobbies[0] = FXCollections.observableArrayList(people);
                            playerList.setItems(lobbies[0]);


                    }
                }
            }

        });


        //Stage stuff
        primaryStage.setOnCloseRequest(event -> {
            server.send("EXITCLIENT");
        });
        primaryStage.setTitle("HALMA");
        primaryStage.setScene(loginScene);
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
