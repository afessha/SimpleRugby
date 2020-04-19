package sample;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class Main extends Application {

    Stage window;
    Scene secretaryScene, coachScene;
    Collection col = new Collection();

    public Main() throws IOException {
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Simply Rugby");

        //GridPane with 10px padding around edge
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(30, 30, 30, 30));
        grid.setVgap(16);
        grid.setHgap(20);

        Label titleLabel = new Label("Welcome to Simple Rugby");
        GridPane.setConstraints(titleLabel, 3, 2);
        titleLabel.setTextFill(Paint.valueOf("blue"));
        titleLabel.setFont(Font.font("Comic Sans MS",22));
        Label headerLabel = new Label("Login");
        GridPane.setConstraints(headerLabel, 2, 4);
        headerLabel.setTextFill(Paint.valueOf("blue"));
        headerLabel.setFont(Font.font("Comic Sans MS",18));
        //Name Label - constrains use (child, column, row)
        Label nameLabel = new Label("Username:");
        GridPane.setConstraints(nameLabel, 2, 5);

        //Name Input
        TextField userNameInput = new TextField();
        userNameInput.setPromptText("SRU Number");
        GridPane.setConstraints(userNameInput, 3, 5);

        //Password Label
        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel, 2, 6);

        //Password Input
        PasswordField passInput = new PasswordField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput, 3, 6);

        //Login
        Button loginButton = new Button("Log In");
        GridPane.setConstraints(loginButton, 3, 7);


        //Add everything to grid
        grid.getChildren().addAll(titleLabel,headerLabel,nameLabel, userNameInput, passLabel, passInput, loginButton);

        grid.setStyle("-fx-background-image: url('https://www.enca.com/sites/default/files/15365215W.jpg');-fx-font-size: 15 ");
        Scene loginScene = new Scene(grid, 500, 350);
        window.setScene(loginScene);
        window.show();
        loginButton.setOnAction(e->{
            // Logout and info
            Label secName = new Label();
            GridPane.setConstraints(secName, 8,0);

            Label secSRU = new Label();
            GridPane.setConstraints(secSRU, 8,1);

            Button logoutBtn = new Button("Logout");
            GridPane.setConstraints(logoutBtn, 8,2);

            if(userNameInput.getText().equalsIgnoreCase("SR200019") && passInput.getText().equals("password")){
                userNameInput.setText("");
                passInput.setText("");

                GridPane secGrid = new GridPane();
                secretaryScene = new Scene(secGrid,850,500);
                //noinspection Duplicates
                secGrid.setPadding(new Insets(30, 30, 30, 30));
                secGrid.setVgap(16);
                secGrid.setHgap(20);
                secGrid.setStyle("-fx-background-image: url('https://www.worcesternews.co.uk/resources/images/4305855/'); -fx-font-size: 15");

                //Setting login info
                secName.setText("Sarah John");
                secName.setFont(Font.font("Roboto",18));
                secName.setTextFill(Paint.valueOf("#ffffff"));
                secSRU.setText("SR200019");
                secSRU.setFont(Font.font("Roboto",18));
                secSRU.setTextFill(Paint.valueOf("#ffffff"));


                //Coach related options

                //Add coach
                Button addCoachBtn = new Button("Add coach");
                GridPane.setConstraints(addCoachBtn, 0,4);

                //Update coach
                Button updateCoachBtn = new Button("Update coach");
                GridPane.setConstraints(updateCoachBtn, 0,5);

                //Delete coach
                Button deleteCoachBtn = new Button("Delete coach");
                GridPane.setConstraints(deleteCoachBtn, 0,6);
                //Display all coaches
                Button displayCoachesBtn = new Button("Display coaches");
                GridPane.setConstraints(displayCoachesBtn, 0,7);

                //Player related options
                //Add player
                Button addPlayerBtn = new Button("Add Player");
                GridPane.setConstraints(addPlayerBtn, 1,4);

                //Update player
                Button updatePlayerBtn = new Button("Update Player");
                GridPane.setConstraints(updatePlayerBtn, 1,5);

                //Delete Player
                Button deletePlayerBtn = new Button("Delete Player");
                GridPane.setConstraints(deletePlayerBtn, 1,6);
                //Display all coaches
                Button displayPlayersBtn = new Button("Display Players");
                GridPane.setConstraints(displayPlayersBtn, 1,7);

                //ParentHelper related options
                //Add player
                Button addPHBtn = new Button("Add ParentHelper");
                GridPane.setConstraints(addPHBtn, 2,4);

                //Update player
                Button updatePHBtn = new Button("Update ParentHelper");
                GridPane.setConstraints(updatePHBtn, 2,5);

                //Delete Player
                Button deletePHBtn = new Button("Delete ParentHelper");
                GridPane.setConstraints(deletePHBtn, 2,6);
                //Display all coaches
                Button displayPHBtn = new Button("Display ParentHelpers");
                GridPane.setConstraints(displayPHBtn, 2,7);


                //Assign Coach
                Button assignCoachBtn = new Button("Assign Coach");
                GridPane.setConstraints(assignCoachBtn, 3,4);


                //Assign Player
                Button assignPlayerBtn = new Button("Assign Player");
                GridPane.setConstraints(assignPlayerBtn, 3,5);


                secGrid.getChildren().addAll(secName, secSRU, logoutBtn, addCoachBtn, updateCoachBtn,deleteCoachBtn,displayCoachesBtn,addPlayerBtn,
                        updatePlayerBtn,deletePlayerBtn,displayPlayersBtn, addPHBtn,updatePHBtn,deletePHBtn,displayPHBtn,assignCoachBtn,assignPlayerBtn);
                window.setScene(secretaryScene);
                window.setOnCloseRequest(event-> {
                    boolean answer= Validator.displayConfirm("Confirm box","Are you sure you want to close this window?");
                    event.consume();
                    if(answer){
                        window.close();
                        col.saveData();
                    }
                });
                window.show();
                logoutBtn.setOnAction(g->{
                    window.setScene(loginScene);
                    col.saveData();
                });


                //PLAYER

                //Add
                addPlayerBtn.setOnAction(i->col.newPlayer());

                //Update Player
                updatePlayerBtn.setOnAction(k->col.updatePlayer());

                //Delete Player
                deletePlayerBtn.setOnAction(l->col.deletePlayer());

                //Display
                displayPlayersBtn.setOnAction(m->col.displayAllPlayers());


                //COACH

                //Add
                addCoachBtn.setOnAction(f-> col.newCoach());

                //Update
                updateCoachBtn.setOnAction(g->col.updateCoach());

                //Delete
                deleteCoachBtn.setOnAction(h-> col.deleteCoach());

                //Display
                displayCoachesBtn.setOnAction(j->col.displayAllCoaches());

                //PARENT HELPER

                //Add
                addPHBtn.setOnAction(m->col.newParentHelper());

                //Update
                updatePHBtn.setOnAction(n->col.updateParentHelper());

                //Delete
                deletePHBtn.setOnAction(o->col.deleteParentHelper());

                //Display
                displayPHBtn.setOnAction(p->col.displayAllParentHelpers());


                //Assign Player
                assignPlayerBtn.setOnAction(q->col.assignPlayersToSquad());

                //Assign Coach
                assignCoachBtn.setOnAction(r->col.assignCoachToSquad());



            }
            else{
                if(col.authenticateCoachLogin(userNameInput.getText(),passInput.getText())) //noinspection Duplicates
                {


                    // Logout and info
                    secName.setText(col.retrieveName(userNameInput.getText()));
                    secName.setFont(Font.font("Roboto", 20));
                    secName.setTextFill(Paint.valueOf("yellow"));
                    secSRU.setText(userNameInput.getText());
                    secSRU.setFont(Font.font("Roboto", 20));
                    secSRU.setTextFill(Paint.valueOf("yellow"));

                    userNameInput.setText("");
                    passInput.setText("");

                    GridPane coachGrid = new GridPane();
                    coachScene = new Scene(coachGrid, 830, 400);
                    coachGrid.setPadding(new Insets(30, 30, 30, 30));
                    //noinspection Duplicates
                    coachGrid.setVgap(16);
                    coachGrid.setHgap(20);
                    coachGrid.setStyle("-fx-background-image: url('https://i2-prod.dailyrecord.co.uk/incoming/article11487645.ece/ALTERNATES/s615/JS74190367.jpg');-fx-font-size: 15 ");
                   // coachGrid.setStyle("-fx-font-size: 15");


                    //Add Training record
                    Button addTRBtn = new Button("Add Training Record");
                    GridPane.setConstraints(addTRBtn, 0, 4);

                    //Display all training records
                    Button displayTRBtn = new Button("Display Training Records");
                    GridPane.setConstraints(displayTRBtn, 0, 5);

                    //Add Game Record
                    Button addGRBtn = new Button("Add Game Record");
                    GridPane.setConstraints(addGRBtn, 1, 4);
                    //Display Game Records
                    Button displayGRBtn = new Button("Display Game Records");
                    GridPane.setConstraints(displayGRBtn, 1, 5);

                    //Display Game Records
                    Button addPlayerProfileBtn = new Button("Add Player Profile");
                    GridPane.setConstraints(addPlayerProfileBtn, 2, 4);

                    //Display Game Records
                    Button displayPlayerProfileBtn = new Button("Show Player Profile");
                    GridPane.setConstraints(displayPlayerProfileBtn, 2, 5);

                    coachGrid.getChildren().addAll(secName, secSRU, logoutBtn, addTRBtn, displayTRBtn, addGRBtn, displayGRBtn, addPlayerProfileBtn,displayPlayerProfileBtn);
                    window.setScene(coachScene);
                    window.setOnCloseRequest(event -> {
                        boolean answer = Validator.displayConfirm("Confirm box", "Are you sure you want to close this window?");
                        event.consume();
                        if (answer) {
                            col.saveData();
                            window.close();

                        }
                    });
                    window.show();
                    logoutBtn.setOnAction(g -> {
                        window.setScene(loginScene);
                        col.saveData();
                    });

                    //Add training record
                    addTRBtn.setOnAction(event->col.newTrainingRecord());

                    //Display training records
                    displayTRBtn.setOnAction(g->col.displayAllTrainingRecords());

                    //Add game record
                    addGRBtn.setOnAction(f->col.newGameRecord());

                    //Display game records
                    displayGRBtn.setOnAction(h->col.displayAllGameRecords());

                    //Add Player Profile
                    addPlayerProfileBtn.setOnAction(i->col.newPlayerProfile());

                    //Display Player profile
                    displayPlayerProfileBtn.setOnAction(j->col.displayPlayerProfile());


                }

                else{
                    Validator.displayAlert("Incorrect username or password","Please check your username or password and try again!");
                }




                }

        });

    }


}

