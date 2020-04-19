package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.InputMismatchException;

@SuppressWarnings("Duplicates")
public class Collection {
    ///////////////////////
    Stage searchWindow;
    private  ArrayList<Coach> allCoaches;
    private ArrayList<Player> allPlayers;
    private ArrayList<ParentHelper> allParentHelpers;
    private ArrayList<TrainingRecord> allTrainingRecords;
    private ArrayList<GameRecord> allGameRecords;
    private ArrayList<PlayerProfile> allPlayerProfiles;
    private InputOutput data;


    //Constructor
    public Collection() throws IOException {
        allCoaches = new ArrayList<>();
        allPlayers = new ArrayList<>();
        allParentHelpers=new ArrayList<>();
        allTrainingRecords= new ArrayList<>();
        allGameRecords= new ArrayList<>();
        allPlayerProfiles= new ArrayList<>();
        data = new InputOutput();
        readData();
    }

    /*
     * Save Data method
     * Passes each ArrayList to their respective
     * write details method in nputOutput class
     */
    public void saveData() {
        data.writeCoachDetails(allCoaches);
        data.writePlayerDetails(allPlayers);
        data.writeParentHelperDetails(allParentHelpers);
        data.writeTrainingRecordDetails(allTrainingRecords);
        data.writeGameRecordDetails(allGameRecords);
        data.writePlayerProfileDetails(allPlayerProfiles);

    }

    /*
     * Read Data method
     * Passes each ArrayList to their respective
     * read data method in InputOutput class
     */
    public void readData() throws IOException {
        data.readCoachData(allCoaches);
        data.readPlayerData(allPlayers);
        data.readParentHelperData(allParentHelpers);
        data.readTrainingRecordData(allTrainingRecords);
        data.readGameRecordData(allGameRecords);
        data.readPlayerProfileData(allPlayerProfiles);
    }


    //Method that takes username and password to check the a coach exist with these details  and return true if it exist
    public boolean authenticateCoachLogin(String username, String password){
        boolean result=false;
        for(Coach i : allCoaches ){
            if(i.getSRUNumber().equalsIgnoreCase(username) && i.getPassword().equals(password)){
                result =true;
            }
        }
        return result;
    }

    //Method to retrieve the coach' name by using the sru number to be
    // able to display the coach's  name when logged in
    public String retrieveName(String username){
        String name="";
        for(Coach i : allCoaches ){
            if(i.getSRUNumber().equalsIgnoreCase(username)){
                name=i.getName();
            }
        }
        return name;
    }


    ////////////////////////////////////////////////////////////////

    //Add new player by displaying a form to take all the attributes of a Player

    public void newPlayer(){

        Stage addWindow = new Stage();
        addWindow.setTitle("Add Player");
        addWindow.initModality(Modality.APPLICATION_MODAL);
        GridPane newPlayerGrid = new GridPane();
        newPlayerGrid.setStyle("-fx-background-image: url('https://www.enca.com/sites/default/files/15365215W.jpg');-fx-font-size: 15 ");
        newPlayerGrid.setPadding(new Insets(25, 25, 25, 25));
        newPlayerGrid.setVgap(15);
        newPlayerGrid.setHgap(20);

        Label headerLabel = new Label("New Player");
        GridPane.setConstraints(headerLabel, 1, 0);
        //Name Label - constrains use (child, column, row)
        Label nameLabel = new Label("Name:");
        GridPane.setConstraints(nameLabel, 0, 2);

        //Name Input
        TextField nameInput = new TextField();
        nameInput.setPromptText("name");
        GridPane.setConstraints(nameInput, 1, 2);

        //SRU Label
        Label SRULabel = new Label("SRUNumber:");
        GridPane.setConstraints(SRULabel, 0, 3);

        //SRU Input
        TextField SRUInput = new TextField();
        SRUInput.setPromptText("SRU Number");
        GridPane.setConstraints(SRUInput, 1, 3);

        //DOB Label
        Label DOBLabel = new Label("DOB:");
        GridPane.setConstraints(DOBLabel, 0, 4);

        //SRU Input
        TextField DOBInput = new TextField();
        DOBInput.setPromptText("DOB");
        GridPane.setConstraints(DOBInput, 1, 4);

        //Age Label
        Label ageLabel = new Label("Age:");
        GridPane.setConstraints(ageLabel, 0, 5);

        //Age Input
        TextField ageInput = new TextField();
        ageInput.setPromptText("Age");
        GridPane.setConstraints(ageInput, 1, 5);

        //address Label
        Label addressLabel = new Label("Address:");
        GridPane.setConstraints(addressLabel, 0, 6);

        //address Input
        TextField addressInput = new TextField();
        addressInput.setPromptText("Address");
        GridPane.setConstraints(addressInput, 1, 6);

        //mobileNum Label
        Label mobileNumLabel = new Label("MobileNum:");
        GridPane.setConstraints(mobileNumLabel, 0, 7);

        //MobileNum Input
        TextField mobileNumInput = new TextField();
        mobileNumInput.setPromptText("MobileNum");
        GridPane.setConstraints(mobileNumInput, 1, 7);

        //Email Label
        Label emailLabel = new Label("Email:");
        GridPane.setConstraints(emailLabel, 0, 8);

        //Email Input
        TextField emailInput = new TextField();
        emailInput.setPromptText("Email");
        GridPane.setConstraints(emailInput, 1, 8);

        //Postcode Label
        Label postcodeLabel = new Label("Postcode:");
        GridPane.setConstraints(postcodeLabel, 0, 9);

        //Postcode Input
        TextField postcodeInput = new TextField();
        postcodeInput.setPromptText("Postcode");
        GridPane.setConstraints(postcodeInput, 1, 9);

        //Emergency contact Label
        Label emergencyContactLabel = new Label("Emergency Contact:");
        GridPane.setConstraints(emergencyContactLabel, 0, 10);

        //emergency contact Input
        TextField emergencyContactInput = new TextField();
        emergencyContactInput.setPromptText("Emergency contact name");
        GridPane.setConstraints(emergencyContactInput, 1, 10);

        //Emergency contact tel Label
        Label emergencyContactTelLabel = new Label("Emergency Contact Tel:");
        GridPane.setConstraints(emergencyContactTelLabel, 0, 11);

        //emergency contact Tel Input
        TextField emergencyContactTelInput = new TextField();
        emergencyContactTelInput.setPromptText("Emergency contact Tel");
        GridPane.setConstraints(emergencyContactTelInput, 1, 11);

        //Doctor Label
        Label doctorLabel = new Label("Doctor name:");
        GridPane.setConstraints(doctorLabel, 0, 12);

        //Doctor Input
        TextField doctorInput = new TextField();
        doctorInput.setPromptText("Doctor name");
        GridPane.setConstraints(doctorInput, 1, 12);


        //Doctor Tel Label
        Label doctorTelLabel = new Label("Doctor Tel:");
        GridPane.setConstraints(doctorTelLabel, 0, 13);

        //Doctor Tel Input
        TextField doctorTelInput = new TextField();
        doctorTelInput.setPromptText("Doctor Tel");
        GridPane.setConstraints(doctorTelInput, 1, 13);

        //Health issue Label
        Label healthIssueLabel = new Label("Health Issue:");
        GridPane.setConstraints(healthIssueLabel, 0, 14);

        //Health issue Input
        TextField healthIssueInput = new TextField();
        healthIssueInput.setPromptText("health issue");
        GridPane.setConstraints(healthIssueInput, 1, 14);

        //Playing Pos Label
        Label playingPosLable = new Label("Playing Position:");
        GridPane.setConstraints(playingPosLable, 0, 15);

        //playing Pos Input
        TextField playingPosInput = new TextField();
        playingPosInput.setPromptText("playing position");
        GridPane.setConstraints(playingPosInput, 1, 15);

        //Add
        Button addButton = new Button("Add");
        GridPane.setConstraints(addButton, 2, 16);

        //Add everything to grid
        newPlayerGrid.getChildren().addAll(headerLabel,nameLabel, nameInput,SRULabel, SRUInput, DOBLabel,DOBInput,ageLabel,ageInput,doctorTelLabel,doctorTelInput,
                emergencyContactLabel,emergencyContactInput,doctorLabel,doctorInput,healthIssueInput,healthIssueLabel,playingPosLable,playingPosInput,emergencyContactTelLabel,emergencyContactTelInput,
                addressLabel, addressInput, mobileNumLabel, mobileNumInput, emailLabel, emailInput, postcodeLabel, postcodeInput,addButton);
        Scene newPlayerScene = new Scene(newPlayerGrid, 600,800);
        addWindow.setScene(newPlayerScene);

        addButton.setOnAction(e->{
                    int age = Validator.validateInteger(ageInput.getText().trim());
                    if (age <= 1) {
                        Validator.displayAlert("Error", "Please enter age as a number");
                    } else {
                        Player player = new Player();
                        player.setName(nameInput.getText());
                        player.setSRUNumber(SRUInput.getText());
                        player.setDOB(DOBInput.getText());
                        player.setAddress(addressInput.getText());
                        player.setEmail(emailInput.getText());
                        player.setPostcode(postcodeInput.getText());
                        player.setEmergencyContact(emergencyContactInput.getText());
                        player.setDoctor(doctorInput.getText());
                        player.setHealthIssue(healthIssueInput.getText());
                        player.setPlayingPos(playingPosInput.getText());
                        player.setMobileNum((mobileNumInput.getText()));
                        player.setEmergencyContTel(emergencyContactTelInput.getText());
                        player.setDoctorTel(doctorTelInput.getText());
                        player.setAge(Validator.validateInteger(ageInput.getText()));
                        player.setSquadID("None");

                        if(nameInput.getText().equals("")|| emergencyContactInput.getText().equals("")|| doctorInput.getText().equals("")||SRUInput.getText().equals("")
                        || healthIssueInput.getText().equals("") || ageInput.getText().equals("")|| mobileNumInput.getText().equals("") ||emergencyContactTelInput.getText().equals("")
                        || emailInput.getText().equals("") || playingPosInput.getText().equals("") || DOBInput.getText().equals("") || addressInput.getText().equals("")
                                || doctorTelInput.getText().equals("") || postcodeInput.getText().equals("")){
                            Validator.displayAlert("Missing Values","Please enter a value for all fields");

                        }
                        else {


                            allPlayers.add(player);
                            Validator.displayAlert("Alert", "Player has been added!!");
                            nameInput.setText("");
                            emergencyContactInput.setText("");
                            doctorInput.setText("");
                            SRUInput.setText("");

                            healthIssueInput.setText("");
                            ageInput.setText("");
                            mobileNumInput.setText("");
                            emergencyContactTelInput.setText("");
                            emailInput.setText("");
                            playingPosInput.setText("");
                            DOBInput.setText("");
                            addressInput.setText("");
                            doctorTelInput.setText("");
                            postcodeInput.setText("");
                        }
                    }

        });
        addWindow.showAndWait();

    }

   //update Player method allows you to change player details
    public void updatePlayer(){
        searchWindow = new Stage();
        searchWindow.setTitle("Update Player");
        searchWindow.initModality(Modality.APPLICATION_MODAL);

        Label sruLabel = new Label("Enter Player SRU Number: ");
        GridPane.setConstraints(sruLabel,0,1);
        TextField sruField = new TextField();
        GridPane.setConstraints(sruField,1,1);
        Button findPlayerBtn = new Button("Find");
        GridPane.setConstraints(findPlayerBtn,1,2);

        GridPane myGrid = new GridPane();
        myGrid.setStyle("-fx-background-image: url('https://www.enca.com/sites/default/files/15365215W.jpg');-fx-font-size: 15 ");
        myGrid.setPadding(new Insets(30, 30, 30, 30));
        myGrid.setVgap(20);
        myGrid.setHgap(25);
        myGrid.getChildren().addAll(sruLabel,sruField,findPlayerBtn);
        Scene findScene = new Scene(myGrid,500,200);
        searchWindow.setScene(findScene);

        //another scene
        Player player = new Player();
        Stage addWindow = new Stage();
        addWindow.initModality(Modality.APPLICATION_MODAL);
        GridPane newPlayerGrid = new GridPane();
        newPlayerGrid.setStyle("-fx-background-image: url('https://www.enca.com/sites/default/files/15365215W.jpg');-fx-font-size: 15 ");
        newPlayerGrid.setPadding(new Insets(30, 30, 30, 30));
        newPlayerGrid.setVgap(17);
        newPlayerGrid.setHgap(22);

        Label headerLabel = new Label("Update Player");
        GridPane.setConstraints(headerLabel, 1, 0);

        //Name Label - constrains use (child, column, row)
        Label nameLabel = new Label("Name:");
        GridPane.setConstraints(nameLabel, 0, 2);

        //Name Input
        TextField nameInput = new TextField();
        GridPane.setConstraints(nameInput, 1, 2);

        //SRU Label
        Label SRULabel = new Label("SRUNumber:");
        GridPane.setConstraints(SRULabel, 0, 3);

        //SRU Input
        TextField SRUInput = new TextField();
        GridPane.setConstraints(SRUInput, 1, 3);

        //DOB Label
        Label DOBLabel = new Label("DOB:");
        GridPane.setConstraints(DOBLabel, 0, 4);

        //SRU Input
        TextField DOBInput = new TextField();
        GridPane.setConstraints(DOBInput, 1, 4);

        //address Label
        Label addressLabel = new Label("Address:");
        GridPane.setConstraints(addressLabel, 0, 5);

        //address Input
        TextField addressInput = new TextField();
        GridPane.setConstraints(addressInput, 1, 5);

        //mobileNum Label
        Label mobileNumLabel = new Label("MobileNum:");
        GridPane.setConstraints(mobileNumLabel, 0, 6);

        //MobileNum Input
        TextField mobileNumInput = new TextField();
        GridPane.setConstraints(mobileNumInput, 1, 6);

        //Email Label
        Label emailLabel = new Label("Email:");
        GridPane.setConstraints(emailLabel, 0, 7);

        //Email Input
        TextField emailInput = new TextField();
        GridPane.setConstraints(emailInput, 1, 7);

        //Age Label
        Label ageLabel = new Label("Age:");
        GridPane.setConstraints(ageLabel, 0, 8);

        //Age Input
        TextField ageInput = new TextField();
        ageInput.setPromptText("Age");
        GridPane.setConstraints(ageInput, 1, 8);


        //Postcode Label
        Label postcodeLabel = new Label("Postcode:");
        GridPane.setConstraints(postcodeLabel, 0, 9);

        //Postcode Input
        TextField postcodeInput = new TextField();
        postcodeInput.setPromptText("Postcode");
        GridPane.setConstraints(postcodeInput, 1, 9);

        //Emergency contact Label
        Label emergencyContactLabel = new Label("Emergency Contact:");
        GridPane.setConstraints(emergencyContactLabel, 0, 10);

        //emergency contact Input
        TextField emergencyContactInput = new TextField();
        emergencyContactInput.setPromptText("Emergency contact name");
        GridPane.setConstraints(emergencyContactInput, 1, 10);

        //Emergency contact tel Label
        Label emergencyContactTelLabel = new Label("Emergency Contact Tel:");
        GridPane.setConstraints(emergencyContactTelLabel, 0, 11);

        //emergency contact Tel Input
        TextField emergencyContactTelInput = new TextField();
        emergencyContactTelInput.setPromptText("Emergency contact Tel");
        GridPane.setConstraints(emergencyContactTelInput, 1, 11);

        //Doctor Label
        Label doctorLabel = new Label("Doctor name:");
        GridPane.setConstraints(doctorLabel, 0, 12);

        //Doctor Input
        TextField doctorInput = new TextField();
        doctorInput.setPromptText("Doctor name");
        GridPane.setConstraints(doctorInput, 1, 12);


        //Doctor Tel Label
        Label doctorTelLabel = new Label("Doctor Tel:");
        GridPane.setConstraints(doctorTelLabel, 0, 13);

        //Doctor Tel Input
        TextField doctorTelInput = new TextField();
        doctorTelInput.setPromptText("Doctor Tel");
        GridPane.setConstraints(doctorTelInput, 1, 13);

        //Health issue Label
        Label healthIssueLabel = new Label("Health Issue:");
        GridPane.setConstraints(healthIssueLabel, 0, 14);

        //Health issue Input
        TextField healthIssueInput = new TextField();
        healthIssueInput.setPromptText("health issue");
        GridPane.setConstraints(healthIssueInput, 1, 14);

        //Playing Pos Label
        Label playingPosLable = new Label("Playing Position:");
        GridPane.setConstraints(playingPosLable, 0, 15);

        //playing Pos Input
        TextField playingPosInput = new TextField();
        playingPosInput.setPromptText("playing position");
        GridPane.setConstraints(playingPosInput, 1, 15);

        //Update
        Button updateButton = new Button("Update");
        GridPane.setConstraints(updateButton, 2, 16);

        //Add everything to grid
        newPlayerGrid.getChildren().addAll(headerLabel,nameLabel, nameInput,SRULabel, SRUInput, DOBLabel,DOBInput,ageLabel,ageInput,doctorTelLabel,doctorTelInput,
                emergencyContactLabel,emergencyContactInput,doctorLabel,doctorInput,healthIssueInput,healthIssueLabel,playingPosLable,playingPosInput,emergencyContactTelLabel,emergencyContactTelInput,
                addressLabel, addressInput, mobileNumLabel, mobileNumInput, emailLabel, emailInput, postcodeLabel, postcodeInput,updateButton);
        Scene newPlayerScene = new Scene(newPlayerGrid, 600,800);
        findPlayerBtn.setOnAction(event -> {
            searchWindow.setScene(newPlayerScene);
            Player playerFound = new Player();
            boolean playerExist = false;
            for (Player i : allPlayers) {
                if (sruField.getText().equals(i.getSRUNumber())) {
                    playerFound = i;
                    playerExist = true;
                }
            }

            if (playerExist) {
                nameInput.setText(playerFound.getName());
                SRUInput.setText(playerFound.getSRUNumber());
                DOBInput.setText(playerFound.getDOB());
                addressInput.setText(playerFound.getAddress());
                mobileNumInput.setText(playerFound.getMobileNum());
                emailInput.setText(playerFound.getEmail());
                postcodeInput.setText(playerFound.getPostcode());
                ageInput.setText(String.valueOf(playerFound.getAge()));
                emergencyContactInput.setText((playerFound.getEmergencyContact()));
                emergencyContactTelInput.setText(playerFound.getEmergencyContTel());
                doctorInput.setText(playerFound.getDoctor());
                doctorTelInput.setText(playerFound.getDoctorTel());
                healthIssueInput.setText(playerFound.getHealthIssue());
                playingPosInput.setText(playerFound.getPlayingPos());

                Player finalPlayerFound = playerFound;
                updateButton.setOnAction(e -> {
                    finalPlayerFound.setName(nameInput.getText());
                    finalPlayerFound.setSRUNumber(SRUInput.getText());
                    finalPlayerFound.setDOB(DOBInput.getText());
                    finalPlayerFound.setAddress(addressInput.getText());
                    finalPlayerFound.setMobileNum(mobileNumInput.getText());
                    finalPlayerFound.setEmail(emailInput.getText());
                    finalPlayerFound.setPostcode(postcodeInput.getText());
                    finalPlayerFound.setAge(Validator.validateInteger(ageInput.getText()));
                    finalPlayerFound.setEmergencyContact(emergencyContactInput.getText());
                    finalPlayerFound.setEmergencyContTel(emergencyContactTelInput.getText());
                    finalPlayerFound.setDoctor((doctorInput.getText()));
                    finalPlayerFound.setDoctorTel(doctorTelInput.getText());
                    finalPlayerFound.setHealthIssue(healthIssueInput.getText());
                    finalPlayerFound.setPlayingPos(playingPosInput.getText());

                    Validator.displayAlert("Notification", "Player details has been updated");

                });
            }
            else {
                Validator.displayAlert("Invalid Input", "Player doesn't exist with that SRU number");
            }


                }
        );
        searchWindow.showAndWait();


    }

    //Delete Player is method that deletes a player by taking a SRU number
    public void deletePlayer(){
        searchWindow = new Stage();
        searchWindow.setTitle("Delete Player");
        searchWindow.initModality(Modality.APPLICATION_MODAL);

        Label sruLabel = new Label("Enter Player SRU Number: ");
        GridPane.setConstraints(sruLabel,0,1);
        TextField sruField = new TextField();
        GridPane.setConstraints(sruField,1,1);
        Button deletePlayerBtn = new Button("Delete");
        GridPane.setConstraints(deletePlayerBtn,1,2);

        GridPane myGrid = new GridPane();
        myGrid.setStyle("-fx-background-image: url('https://www.enca.com/sites/default/files/15365215W.jpg');-fx-font-size: 15 ");
        myGrid.setPadding(new Insets(30, 30, 30, 30));
        myGrid.setVgap(20);
        myGrid.setHgap(25);
        myGrid.getChildren().addAll(sruLabel,sruField,deletePlayerBtn);
        Scene deleteScene = new Scene(myGrid,500,200);
        searchWindow.setScene(deleteScene);

        deletePlayerBtn.setOnAction(event -> {
                    Player player = new Player();
                    boolean playerExist=false;
                    for(Player i : allPlayers) {
                        if(sruField.getText().equals(i.getSRUNumber())) {
                            player = i;
                            playerExist=true;
                        }

                    }

                    if(playerExist) {
                        allPlayers.remove(player);

                        Validator.displayAlert("Alert", "Player deleted");
                        sruField.setText("");
                    }
                    else{
                        Validator.displayAlert("Invalid Input","Player doesn't exist with that SRU number");
                    }

                }
        );
        searchWindow.showAndWait();
    }


    //Display all players in a table format
    public void displayAllPlayers(){
        TableView<Player> table;
        ObservableList<Player> players = FXCollections.observableArrayList();
        for(Player i : allPlayers){
            players.add(i);
        }
        Stage window = new Stage();
        window.setTitle("All Players");

        //Name column
        TableColumn<Player, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(100);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //SRU column
        TableColumn<Player, String> SRUColoumn = new TableColumn<>("SRU Number");
        SRUColoumn.setMinWidth(50);
        SRUColoumn.setCellValueFactory(new PropertyValueFactory<>("SRUNumber"));

        //Address column
        TableColumn<Player, String> addressColumn = new TableColumn<>("Address");
        addressColumn.setMinWidth(100);
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));

        //DOB column
        TableColumn<Player, String> DOBColumn = new TableColumn<>("Date of birth");
        DOBColumn.setMinWidth(50);
        DOBColumn.setCellValueFactory(new PropertyValueFactory<>("DOB"));

        //Email column
        TableColumn<Player, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setMinWidth(100);
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        //Postcode column
        TableColumn<Player, String> postcodeColumn = new TableColumn<>("Postcode");
        postcodeColumn.setMinWidth(50);
        postcodeColumn.setCellValueFactory(new PropertyValueFactory<>("postcode"));

        //mobileNum column
        TableColumn<Player, String> mobileNumColoumn = new TableColumn<>("Mobile Number");
        mobileNumColoumn.setMinWidth(50);
        mobileNumColoumn.setCellValueFactory(new PropertyValueFactory<>("mobileNum"));

        //Emergency contact column
        TableColumn<Player, String> emergencyContactColoumn = new TableColumn<>("Emergency Contact");
        emergencyContactColoumn.setMinWidth(100);
        emergencyContactColoumn.setCellValueFactory(new PropertyValueFactory<>("emergencyContact"));

        //Emergency contact Tel column
        TableColumn<Player, String> emergencyContactTelColoumn = new TableColumn<>("Emergency Contact Tel");
        emergencyContactTelColoumn.setMinWidth(100);
        emergencyContactTelColoumn.setCellValueFactory(new PropertyValueFactory<>("emergencyContTel"));

        //Doctor column
        TableColumn<Player, String> doctorColoumn = new TableColumn<>("Doctor");
        doctorColoumn.setMinWidth(100);
        doctorColoumn.setCellValueFactory(new PropertyValueFactory<>("doctor"));

        //Doctor Tel column
        TableColumn<Player, String> doctorTelColoumn = new TableColumn<>("Emergency Contact Tel");
        doctorTelColoumn.setMinWidth(100);
        doctorTelColoumn.setCellValueFactory(new PropertyValueFactory<>("doctorTel"));

        //Health issue column
        TableColumn<Player, String> healthIssueColoumn = new TableColumn<>("Health Isuue");
        healthIssueColoumn.setMinWidth(100);
        healthIssueColoumn.setCellValueFactory(new PropertyValueFactory<>("healthIssue"));

        //Playing Position column
        TableColumn<Player, String> playingPosColoumn = new TableColumn<>("Playing Position");
        playingPosColoumn.setMinWidth(100);
        playingPosColoumn.setCellValueFactory(new PropertyValueFactory<>("playingPos"));

        //Age column
        TableColumn<Player, Integer> ageColoumn = new TableColumn<>("Age");
        ageColoumn.setMinWidth(50);
        ageColoumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        table = new TableView<>();
        table.setItems(players);
        table.getColumns().addAll(nameColumn, SRUColoumn,addressColumn,DOBColumn, ageColoumn,mobileNumColoumn,emailColumn,postcodeColumn,emergencyContactColoumn,emergencyContactTelColoumn,
                doctorColoumn,doctorTelColoumn,healthIssueColoumn,playingPosColoumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    //Method to assign player to a squad by taking sru number and squadID

    public void assignPlayersToSquad(){
        Stage window = new Stage();
        window.setTitle("Assign Player");


        Label squadIDLabel = new Label("Pleas select Squad ID: ");
        GridPane.setConstraints(squadIDLabel,0,1);
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        GridPane.setConstraints(choiceBox,1,1);
        //getItems returns the ObservableList object which you can add items to
        choiceBox.getItems().add("SQ1111");
        choiceBox.getItems().add("SQ2222");
        choiceBox.getItems().addAll("SQ3333", "SQ4444", "SQ5555");

        //Set a default value
        choiceBox.setValue("SQ1111");

        Label playerSruNumLabel = new Label("Enter Player SRU Number: ");
        GridPane.setConstraints(playerSruNumLabel,0,2);
        TextField playerSruNumField = new TextField();
        GridPane.setConstraints(playerSruNumField,1,2);
        Button assignPlayerBtn = new Button("Assign");
        GridPane.setConstraints(assignPlayerBtn,1,3);

        GridPane myGrid = new GridPane();
        myGrid.setStyle("-fx-background-image: url('https://www.enca.com/sites/default/files/15365215W.jpg');-fx-font-size: 15 ");
        myGrid.setPadding(new Insets(30, 30, 30, 30));
        myGrid.setVgap(20);
        myGrid.setHgap(25);

        myGrid.getChildren().addAll(squadIDLabel,choiceBox,playerSruNumLabel,playerSruNumField,assignPlayerBtn);
        Scene assignScene = new Scene(myGrid,500,300);
        window.setScene(assignScene);

        assignPlayerBtn.setOnAction(e->{
            boolean playerExist = false;
            Player player= new Player();
            for(Player i:allPlayers){
                if(i.getSRUNumber().equalsIgnoreCase(playerSruNumField.getText())) {
                    playerExist=true;
                    player=i;

                }
            }

            if(playerExist && player.getAge()<18 && (choiceBox.getValue().equals("SQ1111") || choiceBox.getValue().equals("SQ2222") ||choiceBox.getValue().equals("SQ3333"))){
                player.setSquadID(choiceBox.getValue());
                Validator.displayAlert("Alert", "Player has been assigned to chosen squad!");
            }
            else if(playerExist && player.getAge()>18 && (choiceBox.getValue().equals("SQ1111") || choiceBox.getValue().equals("SQ2222") ||choiceBox.getValue().equals("SQ3333"))){
                Validator.displayAlert("Incorrect Input", "You can't assign an adult player to a Junior squad!");
            }
            else if(playerExist&& player.getAge()>18 && (choiceBox.getValue().equals("SQ4444") || choiceBox.getValue().equals("SQ5555"))){
                player.setSquadID(choiceBox.getValue());
                Validator.displayAlert("Alert", "Player has been assigned to chosen squad!");
            }
            else if(playerExist&& player.getAge()<18 && (choiceBox.getValue().equals("SQ4444") || choiceBox.getValue().equals("SQ5555"))){
                Validator.displayAlert("Incorrect Input", "You can't assign Junior player to an adult squad!");
            }
            else{
                Validator.displayAlert("Incorrect Input", "Invalid Player SRU Number!");
            }
        });
        window.show();

    }


    ////////////////////////////////////////////////////////////////

    //Method to add a new coach by displaying a form that has all the player attributes
    public void newCoach(){

       Stage  addWindow = new Stage();
        addWindow.setTitle("Add Coach");
        addWindow.initModality(Modality.APPLICATION_MODAL);
        GridPane newCoachGrid = new GridPane();
        newCoachGrid.setStyle("-fx-background-image: url('https://www.enca.com/sites/default/files/15365215W.jpg');-fx-font-size: 15 ");
        newCoachGrid.setPadding(new Insets(30, 30, 30, 30));
        newCoachGrid.setVgap(20);
        newCoachGrid.setHgap(25);

        Label headerLabel = new Label("New Coach");
        GridPane.setConstraints(headerLabel, 1, 0);
        //Name Label - constrains use (child, column, row)
        Label nameLabel = new Label("Name:");
        GridPane.setConstraints(nameLabel, 0, 2);

        //Name Input
        TextField nameInput = new TextField();
        nameInput.setPromptText("name");
        GridPane.setConstraints(nameInput, 1, 2);

        //SRU Label
        Label SRULabel = new Label("SRUNumber:");
        GridPane.setConstraints(SRULabel, 0, 3);

        //SRU Input
        TextField SRUInput = new TextField();
        SRUInput.setPromptText("SRU Number");
        GridPane.setConstraints(SRUInput, 1, 3);

        //DOB Label
        Label DOBLabel = new Label("DOB:");
        GridPane.setConstraints(DOBLabel, 0, 4);

        //SRU Input
        TextField DOBInput = new TextField();
        DOBInput.setPromptText("DOB");
        GridPane.setConstraints(DOBInput, 1, 4);

        //address Label
        Label addressLabel = new Label("Address:");
        GridPane.setConstraints(addressLabel, 0, 5);

        //address Input
        TextField addressInput = new TextField();
        addressInput.setPromptText("Address");
        GridPane.setConstraints(addressInput, 1, 5);

        //mobileNum Label
        Label mobileNumLabel = new Label("MobileNum:");
        GridPane.setConstraints(mobileNumLabel, 0, 6);

        //MobileNum Input
        TextField mobileNumInput = new TextField();
        mobileNumInput.setPromptText("MobileNum");
        GridPane.setConstraints(mobileNumInput, 1, 6);

        //Email Label
        Label emailLabel = new Label("Email:");
        GridPane.setConstraints(emailLabel, 0, 7);

        //Email Input
        TextField emailInput = new TextField();
        emailInput.setPromptText("Email");
        GridPane.setConstraints(emailInput, 1, 7);

        //Postcode Label
        Label postcodeLabel = new Label("Postcode:");
        GridPane.setConstraints(postcodeLabel, 0, 8);

        //Postcode Input
        TextField postcodeInput = new TextField();
        postcodeInput.setPromptText("Postcode");
        GridPane.setConstraints(postcodeInput, 1, 8);

        //Add
        Button addButton = new Button("Add");
        GridPane.setConstraints(addButton, 1, 9);

        //Add everything to grid
        newCoachGrid.getChildren().addAll(headerLabel,nameLabel, nameInput,SRULabel, SRUInput, DOBLabel,DOBInput, addressLabel, addressInput, mobileNumLabel, mobileNumInput, emailLabel, emailInput, postcodeLabel, postcodeInput,addButton);
        Scene newCoachScene = new Scene(newCoachGrid, 600,600);
        addWindow.setScene(newCoachScene);
        Validator.closeWindowRequest(addWindow);

        addButton.setOnAction(e->{
            Coach coach = new Coach();
            coach.setName(nameInput.getText());
            coach.setSRUNumber(SRUInput.getText());
            coach.setDOB(DOBInput.getText());
            coach.setAddress(addressInput.getText());
            coach.setMobileNum(mobileNumInput.getText());
            coach.setEmail(emailInput.getText());
            coach.setPostcode(postcodeInput.getText());
            coach.setPassword(Validator.passwordGenerator(coach.getName().trim()));
            coach.setSquadName("None");

            if(nameInput.getText().equals("") || SRUInput.getText().equals("") || DOBInput.getText().equals("") || addressInput.getText().equals("") ||
            mobileNumInput.getText().equals("") || emailInput.getText().equals("") || postcodeInput.getText().equals("")){
                Validator.displayAlert("Missing Value", "Please enter a value for all fields.");

            }
            else {

                allCoaches.add(coach);
                Validator.displayAlert("Alert", "Coach has been added!!");
                nameInput.setText("");
                SRUInput.setText("");
                DOBInput.setText("");
                addressInput.setText("");
                mobileNumInput.setText("");
                emailInput.setText("");
                postcodeInput.setText("");
            }
        });
        addWindow.showAndWait();

    }

    //Method to delete coach by taking coach sru number
    public void deleteCoach(){
        searchWindow = new Stage();
        searchWindow.setTitle("Delete Coach");
        searchWindow.initModality(Modality.APPLICATION_MODAL);

        Label sruLabel = new Label("Enter Coach SRU Number: ");
        GridPane.setConstraints(sruLabel,0,1);
        TextField sruField = new TextField();
        GridPane.setConstraints(sruField,1,1);
        Button deleteCoachBtn = new Button("Delete");
        GridPane.setConstraints(deleteCoachBtn,1,2);

        GridPane myGrid = new GridPane();
        myGrid.setStyle("-fx-background-image: url('https://www.enca.com/sites/default/files/15365215W.jpg');-fx-font-size: 15 ");
        myGrid.setPadding(new Insets(30, 30, 30, 30));
        myGrid.setVgap(20);
        myGrid.setHgap(25);
        myGrid.getChildren().addAll(sruLabel,sruField,deleteCoachBtn);
        Scene deleteScene = new Scene(myGrid,400,200);
        searchWindow.setScene(deleteScene);

        deleteCoachBtn.setOnAction(event -> {
            Coach coach = new Coach();
            boolean coachExist = false;
                for(Coach i : allCoaches) {
                    if(sruField.getText().equals(i.getSRUNumber())) {
                        coach = i;
                        coachExist=true;
                    }

                }

                if(coachExist) {
                    allCoaches.remove(coach);

                    Validator.displayAlert("Alert", "Coach deleted");
                    sruField.setText("");
                }
                else{
                    Validator.displayAlert("Invalid Input","Coach doesn't exist with that SRU number");
                }

        }
        );
        searchWindow.showAndWait();
}

//Method to update coach details
public void updateCoach(){
    searchWindow = new Stage();
    searchWindow.setTitle("Update Coach");
    searchWindow.initModality(Modality.APPLICATION_MODAL);

    Label sruLabel = new Label("Enter Coach SRU Number: ");
    GridPane.setConstraints(sruLabel,0,1);
    TextField sruField = new TextField();
    GridPane.setConstraints(sruField,1,1);
    Button findCoachBtn = new Button("Find");
    GridPane.setConstraints(findCoachBtn,1,2);

    GridPane myGrid = new GridPane();
    myGrid.setStyle("-fx-background-image: url('https://www.enca.com/sites/default/files/15365215W.jpg');-fx-font-size: 15 ");
    myGrid.setPadding(new Insets(30, 30, 30, 30));
    myGrid.setVgap(20);
    myGrid.setHgap(25);
    myGrid.getChildren().addAll(sruLabel,sruField,findCoachBtn);
    Scene findScene = new Scene(myGrid,500,200);
    searchWindow.setScene(findScene);

    //another scene
    Stage addWindow = new Stage();
    addWindow.initModality(Modality.APPLICATION_MODAL);
    GridPane newCoachGrid = new GridPane();
    newCoachGrid.setStyle("-fx-background-image: url('https://www.enca.com/sites/default/files/15365215W.jpg');-fx-font-size: 15 ");
    newCoachGrid.setPadding(new Insets(30, 30, 30, 30));
    newCoachGrid.setVgap(20);
    newCoachGrid.setHgap(25);

    Label headerLabel = new Label("Update Coach");
    GridPane.setConstraints(headerLabel, 1, 0);

    //Name Label - constrains use (child, column, row)
    Label nameLabel = new Label("Name:");
    GridPane.setConstraints(nameLabel, 0, 2);

    //Name Input
    TextField nameInput = new TextField();
    GridPane.setConstraints(nameInput, 1, 2);

    //SRU Label
    Label SRULabel = new Label("SRUNumber:");
    GridPane.setConstraints(SRULabel, 0, 3);

    //SRU Input
    TextField SRUInput = new TextField();
    GridPane.setConstraints(SRUInput, 1, 3);

    //DOB Label
    Label DOBLabel = new Label("DOB:");
    GridPane.setConstraints(DOBLabel, 0, 4);

    //SRU Input
    TextField DOBInput = new TextField();
    GridPane.setConstraints(DOBInput, 1, 4);

    //address Label
    Label addressLabel = new Label("Address:");
    GridPane.setConstraints(addressLabel, 0, 5);

    //address Input
    TextField addressInput = new TextField();
    GridPane.setConstraints(addressInput, 1, 5);

    //mobileNum Label
    Label mobileNumLabel = new Label("MobileNum:");
    GridPane.setConstraints(mobileNumLabel, 0, 6);

    //MobileNum Input
    TextField mobileNumInput = new TextField();
    GridPane.setConstraints(mobileNumInput, 1, 6);

    //Email Label
    Label emailLabel = new Label("Email:");
    GridPane.setConstraints(emailLabel, 0, 7);

    //Email Input
    TextField emailInput = new TextField();
    GridPane.setConstraints(emailInput, 1, 7);

    //Postcode Label
    Label postcodeLabel = new Label("Postcode:");
    GridPane.setConstraints(postcodeLabel, 0, 8);

    //Postcode Input
    TextField postcodeInput = new TextField();
    GridPane.setConstraints(postcodeInput, 1, 8);

    //Password Label
    Label passwordLabel = new Label("Postcode:");
    GridPane.setConstraints(passwordLabel, 0, 8);

    //Password Input
    TextField passwordInput = new TextField();
    GridPane.setConstraints(passwordInput, 1, 8);

    //Add
    Button updateButton = new Button("Update");
    GridPane.setConstraints(updateButton, 1, 9);

    //Add everything to grid
    newCoachGrid.getChildren().addAll(headerLabel,nameLabel, nameInput,SRULabel, SRUInput, DOBLabel,DOBInput, addressLabel, addressInput, mobileNumLabel, mobileNumInput, emailLabel, emailInput, postcodeLabel, postcodeInput,updateButton,passwordLabel,passwordInput);
    Scene newCoachScene = new Scene(newCoachGrid, 600,600);
    findCoachBtn.setOnAction(event -> {

                Coach coachFound = new Coach();
                boolean coachExist =false;
                    for(Coach i : allCoaches) {
                        if (sruField.getText().equals(i.getSRUNumber())) //noinspection Duplicates
                        {
                            coachFound = i;
                            coachExist = true;
                        }
                    }

                    if(coachExist) {
                        nameInput.setText(coachFound.getName());
                        SRUInput.setText(coachFound.getSRUNumber());
                        DOBInput.setText(coachFound.getDOB());
                        addressInput.setText(coachFound.getAddress());
                        mobileNumInput.setText(coachFound.getMobileNum());
                        emailInput.setText(coachFound.getEmail());
                        postcodeInput.setText(coachFound.getPostcode());
                        passwordInput.setText(coachFound.getPassword());

                        Coach finalCoachFound = coachFound;
                        searchWindow.setScene(newCoachScene);
                        updateButton.setOnAction(e -> {
                            finalCoachFound.setName(nameInput.getText());
                            finalCoachFound.setSRUNumber(SRUInput.getText());
                            finalCoachFound.setDOB(DOBInput.getText());
                            finalCoachFound.setAddress(addressInput.getText());
                            finalCoachFound.setMobileNum(mobileNumInput.getText());
                            finalCoachFound.setEmail(emailInput.getText());
                            finalCoachFound.setPostcode(postcodeInput.getText());
                            Validator.displayAlert("Notificationn", "Coach details has been updated.");

                        });
                    }
                    else {

                        Validator.displayAlert("Invalid Input", "Coach doesn't exist with that sru number");
                    }

    }
    );
    Validator.closeWindowRequest(searchWindow);
    searchWindow.showAndWait();


}
    //Method to display all coaches in a table format
    public void displayAllCoaches(){
        TableView<Coach> table;
        ObservableList<Coach> coaches = FXCollections.observableArrayList();
        for(Coach i : allCoaches){
            coaches.add(i);
        }
        Stage window = new Stage();
        window.setTitle("All Coaches");

        //Name column
        TableColumn<Coach, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(100);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //SRU column
        TableColumn<Coach, String> SRUColoumn = new TableColumn<>("SRU Number");
        SRUColoumn.setMinWidth(50);
        SRUColoumn.setCellValueFactory(new PropertyValueFactory<>("SRUNumber"));

        //Address column
        TableColumn<Coach, String> addressColumn = new TableColumn<>("Address");
        addressColumn.setMinWidth(100);
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));

        //DOB column
        TableColumn<Coach, String> DOBColumn = new TableColumn<>("Date of birth");
        DOBColumn.setMinWidth(50);
        DOBColumn.setCellValueFactory(new PropertyValueFactory<>("DOB"));

        //mobileNum column
        TableColumn<Coach, String> mobileNumColoumn = new TableColumn<>("Mobile Number");
        mobileNumColoumn.setMinWidth(100);
        mobileNumColoumn.setCellValueFactory(new PropertyValueFactory<>("mobileNum"));

        //Email column
        TableColumn<Coach, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setMinWidth(100);
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        //Postcode column
        TableColumn<Coach, String> postcodeColumn = new TableColumn<>("Postcode");
        postcodeColumn.setMinWidth(50);
        postcodeColumn.setCellValueFactory(new PropertyValueFactory<>("postcode"));

        table = new TableView<>();
        table.setItems(coaches);
        table.getColumns().addAll(nameColumn, SRUColoumn,addressColumn,DOBColumn,mobileNumColoumn,emailColumn,postcodeColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    //Method to assign coach to a squad by taking sru number and squadName
    public void assignCoachToSquad(){
        Stage window = new Stage();
        window.setTitle("Assign Coach");
        Label squadIDLabel = new Label("Pleas select Squad: ");
        GridPane.setConstraints(squadIDLabel,0,1);
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        GridPane.setConstraints(choiceBox,1,1);

        //getItems returns the ObservableList object which you can add items to
        choiceBox.getItems().add("Young Lions");
        choiceBox.getItems().add("Glasgow United");
        choiceBox.getItems().addAll("Glasgow Boys", "Celtic", "Rangers");

        //Set a default value
        choiceBox.setValue("Young Lions");

        Label coachSruNumLabel = new Label("Enter coach SRU Number: ");
        GridPane.setConstraints(coachSruNumLabel,0,2);
        TextField coachSruNumField = new TextField();
        GridPane.setConstraints(coachSruNumField,1,2);
        Button assignCoachBtn = new Button("Assign");
        GridPane.setConstraints(assignCoachBtn,1,3);


        GridPane myGrid = new GridPane();
        myGrid.setStyle("-fx-background-image: url('https://www.enca.com/sites/default/files/15365215W.jpg');-fx-font-size: 15 ");
        myGrid.setPadding(new Insets(30, 30, 30, 30));
        myGrid.setVgap(20);
        myGrid.setHgap(25);
        myGrid.getChildren().addAll(squadIDLabel,choiceBox,coachSruNumLabel,coachSruNumField,assignCoachBtn);
        Scene assignScene = new Scene(myGrid,500,200);
        window.setScene(assignScene);

        assignCoachBtn.setOnAction(e->{
            boolean coachExist=false;
            Coach coach = new Coach();
            for(Coach i:allCoaches){
                if(i.getSRUNumber().equalsIgnoreCase(coachSruNumField.getText())){
                    coachExist=true;
                    coach=i;

                }

            }
                    if(coachExist) {
                        coach.setSquadName(choiceBox.getValue());
                        Validator.displayAlert("Successful", "Coach has been successfully assigned!");
                    }
                    else {
                        Validator.displayAlert("Incorrect Input", "Invalid Coach SRU Number!");
                    }
        });
        window.show();

    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Method to add new parent helper by displaying a form that takes in all the ParentHelper attributes
    public void newParentHelper(){

        Stage  addWindow = new Stage();
        addWindow.setTitle("Add Parent Helper");
        addWindow.initModality(Modality.APPLICATION_MODAL);
        GridPane newPHGrid = new GridPane();
        newPHGrid.setStyle("-fx-background-image: url('https://www.enca.com/sites/default/files/15365215W.jpg');-fx-font-size: 15 ");
        newPHGrid.setPadding(new Insets(30, 30, 30, 30));
        newPHGrid.setVgap(20);
        newPHGrid.setHgap(25);

        Label headerLabel = new Label("New ParentHelper");
        GridPane.setConstraints(headerLabel, 1, 0);
        //Name Label - constrains use (child, column, row)
        Label nameLabel = new Label("Name:");
        GridPane.setConstraints(nameLabel, 0, 2);

        //Name Input
        TextField nameInput = new TextField();
        nameInput.setPromptText("name");
        GridPane.setConstraints(nameInput, 1, 2);

        //SRU Label
        Label SRULabel = new Label("SRUNumber:");
        GridPane.setConstraints(SRULabel, 0, 3);

        //SRU Input
        TextField SRUInput = new TextField();
        SRUInput.setPromptText("SRU Number");
        GridPane.setConstraints(SRUInput, 1, 3);

        //DOB Label
        Label DOBLabel = new Label("DOB:");
        GridPane.setConstraints(DOBLabel, 0, 4);

        //SRU Input
        TextField DOBInput = new TextField();
        DOBInput.setPromptText("DOB");
        GridPane.setConstraints(DOBInput, 1, 4);

        //address Label
        Label addressLabel = new Label("Address:");
        GridPane.setConstraints(addressLabel, 0, 5);

        //address Input
        TextField addressInput = new TextField();
        addressInput.setPromptText("Address");
        GridPane.setConstraints(addressInput, 1, 5);

        //mobileNum Label
        Label mobileNumLabel = new Label("MobileNum:");
        GridPane.setConstraints(mobileNumLabel, 0, 6);

        //MobileNum Input
        TextField mobileNumInput = new TextField();
        mobileNumInput.setPromptText("MobileNum");
        GridPane.setConstraints(mobileNumInput, 1, 6);

        //Email Label
        Label emailLabel = new Label("Email:");
        GridPane.setConstraints(emailLabel, 0, 7);

        //Email Input
        TextField emailInput = new TextField();
        emailInput.setPromptText("Email");
        GridPane.setConstraints(emailInput, 1, 7);

        //Postcode Label
        Label postcodeLabel = new Label("Postcode:");
        GridPane.setConstraints(postcodeLabel, 0, 8);

        //Postcode Input
        TextField postcodeInput = new TextField();
        postcodeInput.setPromptText("Postcode");
        GridPane.setConstraints(postcodeInput, 1, 8);

        //Add
        Button addButton = new Button("Add");
        GridPane.setConstraints(addButton, 1, 9);

        //Add everything to grid
        newPHGrid.getChildren().addAll(headerLabel,nameLabel, nameInput,SRULabel, SRUInput, DOBLabel,DOBInput, addressLabel, addressInput, mobileNumLabel, mobileNumInput, emailLabel, emailInput, postcodeLabel, postcodeInput,addButton);
        Scene newPHScene = new Scene(newPHGrid, 600,600);
        addWindow.setScene(newPHScene);
        addWindow.setOnCloseRequest(e->{
            boolean answer= Validator.displayConfirm("Confirmation","Are you sure you want to close this window?");
            e.consume();
            if(answer){
                addWindow.close();
            }
        });

        addButton.setOnAction(e->{
            ParentHelper ph = new ParentHelper();
            ph.setName(nameInput.getText());
            ph.setSRUNumber(SRUInput.getText());
            ph.setDOB(DOBInput.getText());
            ph.setAddress(addressInput.getText());
            ph.setMobileNum(mobileNumInput.getText());
            ph.setEmail(emailInput.getText());
            ph.setPostcode(postcodeInput.getText());

            if(nameInput.getText().equals("") || SRUInput.getText().equals("") || DOBInput.getText().equals("") || addressInput.getText().equals("") ||
                    mobileNumInput.getText().equals("") || emailInput.getText().equals("") || postcodeInput.getText().equals("")){
                Validator.displayAlert("Missing Value", "Please enter a value for all fields.");

                    }
            else {

                allParentHelpers.add(ph);
                Validator.displayAlert("Alert", "ParentHelper has been added!!");
                nameInput.setText("");
                SRUInput.setText("");
                DOBInput.setText("");
                addressInput.setText("");
                mobileNumInput.setText("");
                emailInput.setText("");
                postcodeInput.setText("");
            }
        });
        addWindow.showAndWait();

    }

    //Method to update ParentHelper details
    public void updateParentHelper(){
        searchWindow = new Stage();
        searchWindow.setTitle("Update Parent Helper");
        searchWindow.initModality(Modality.APPLICATION_MODAL);

        Label sruLabel = new Label("Enter ParentHelper SRU Number: ");
        GridPane.setConstraints(sruLabel,0,1);
        TextField sruField = new TextField();
        GridPane.setConstraints(sruField,1,1);
        Button findPHBtn = new Button("Find");
        GridPane.setConstraints(findPHBtn,1,2);

        GridPane myGrid = new GridPane();
        myGrid.setStyle("-fx-background-image: url('https://www.enca.com/sites/default/files/15365215W.jpg');-fx-font-size: 15 ");
        myGrid.setPadding(new Insets(30, 30, 30, 30));
        myGrid.setVgap(20);
        myGrid.setHgap(25);
        myGrid.getChildren().addAll(sruLabel,sruField,findPHBtn);
        Scene findScene = new Scene(myGrid,500,200);
        searchWindow.setScene(findScene);


        //another scene
        ParentHelper ph = new ParentHelper();
        Stage addWindow = new Stage();
        addWindow.initModality(Modality.APPLICATION_MODAL);
        GridPane newPHGrid = new GridPane();
        newPHGrid.setStyle("-fx-background-image: url('https://www.enca.com/sites/default/files/15365215W.jpg');-fx-font-size: 15 ");
        newPHGrid.setPadding(new Insets(30, 30, 30, 30));
        newPHGrid.setVgap(20);
        newPHGrid.setHgap(25);

        Label headerLabel = new Label("Update ParentHelper");
        GridPane.setConstraints(headerLabel, 1, 0);

        //Name Label - constrains use (child, column, row)
        Label nameLabel = new Label("Name:");
        GridPane.setConstraints(nameLabel, 0, 2);

        //Name Input
        TextField nameInput = new TextField();
        GridPane.setConstraints(nameInput, 1, 2);

        //SRU Label
        Label SRULabel = new Label("SRUNumber:");
        GridPane.setConstraints(SRULabel, 0, 3);

        //SRU Input
        TextField SRUInput = new TextField();
        GridPane.setConstraints(SRUInput, 1, 3);

        //DOB Label
        Label DOBLabel = new Label("DOB:");
        GridPane.setConstraints(DOBLabel, 0, 4);

        //SRU Input
        TextField DOBInput = new TextField();
        GridPane.setConstraints(DOBInput, 1, 4);

        //address Label
        Label addressLabel = new Label("Address:");
        GridPane.setConstraints(addressLabel, 0, 5);

        //address Input
        TextField addressInput = new TextField();
        GridPane.setConstraints(addressInput, 1, 5);

        //mobileNum Label
        Label mobileNumLabel = new Label("MobileNum:");
        GridPane.setConstraints(mobileNumLabel, 0, 6);

        //MobileNum Input
        TextField mobileNumInput = new TextField();
        GridPane.setConstraints(mobileNumInput, 1, 6);

        //Email Label
        Label emailLabel = new Label("Email:");
        GridPane.setConstraints(emailLabel, 0, 7);

        //Email Input
        TextField emailInput = new TextField();
        GridPane.setConstraints(emailInput, 1, 7);

        //Postcode Label
        Label postcodeLabel = new Label("Postcode:");
        GridPane.setConstraints(postcodeLabel, 0, 8);

        //Postcode Input
        TextField postcodeInput = new TextField();
        GridPane.setConstraints(postcodeInput, 1, 8);
        //Add
        Button updateButton = new Button("Update");
        GridPane.setConstraints(updateButton, 1, 9);

        //Add everything to grid
        newPHGrid.getChildren().addAll(headerLabel,nameLabel, nameInput,SRULabel, SRUInput, DOBLabel,DOBInput, addressLabel, addressInput, mobileNumLabel, mobileNumInput, emailLabel, emailInput, postcodeLabel, postcodeInput,updateButton);
        Scene newPHScene = new Scene(newPHGrid, 600,600);
        findPHBtn.setOnAction(event -> {

                    ParentHelper pHFound = new ParentHelper();
                    boolean phExist = false;
                    for (ParentHelper i : allParentHelpers) {
                        if (sruField.getText().equals(i.getSRUNumber())) {
                            pHFound = i;
                            phExist = true;

                        }
                    }
                    if (phExist) {
                        nameInput.setText(pHFound.getName());
                        SRUInput.setText(pHFound.getSRUNumber());
                        DOBInput.setText(pHFound.getDOB());
                        addressInput.setText(pHFound.getAddress());
                        mobileNumInput.setText(pHFound.getMobileNum());
                        emailInput.setText(pHFound.getEmail());
                        postcodeInput.setText(pHFound.getPostcode());


                        searchWindow.setScene(newPHScene);
                        ParentHelper finalPHFound = pHFound;
                        updateButton.setOnAction(e -> {
                            finalPHFound.setName(nameInput.getText());
                            finalPHFound.setSRUNumber(SRUInput.getText());
                            finalPHFound.setDOB(DOBInput.getText());
                            finalPHFound.setAddress(addressInput.getText());
                            finalPHFound.setMobileNum(mobileNumInput.getText());
                            finalPHFound.setEmail(emailInput.getText());
                            finalPHFound.setPostcode(postcodeInput.getText());
                            Validator.displayAlert("Notification", "Parent Helper details has been updated");

                        });
                    }
                    else {
                        Validator.displayAlert("Inavlid Input", "Parent Helper doesn't exist with that SRU number");
                    }
                }
        );
        searchWindow.showAndWait();


    }

    //Method to delete parentHelper by taking in sru number
    public void deleteParentHelper(){
        searchWindow = new Stage();
        searchWindow.setTitle("Delete Parent Helper");
        searchWindow.initModality(Modality.APPLICATION_MODAL);

        Label sruLabel = new Label("Enter ParentHelper SRU Number: ");
        GridPane.setConstraints(sruLabel,0,1);
        TextField sruField = new TextField();
        GridPane.setConstraints(sruField,1,1);
        Button deletePHBtn = new Button("Delete");
        GridPane.setConstraints(deletePHBtn,1,2);

        GridPane myGrid = new GridPane();
        myGrid.setStyle("-fx-background-image: url('https://www.enca.com/sites/default/files/15365215W.jpg');-fx-font-size: 15 ");
        myGrid.setPadding(new Insets(30, 30, 30, 30));
        myGrid.setVgap(20);
        myGrid.setHgap(25);
        myGrid.getChildren().addAll(sruLabel,sruField,deletePHBtn);
        Scene deleteScene = new Scene(myGrid,500,200);
        searchWindow.setScene(deleteScene);

        deletePHBtn.setOnAction(event -> {
                    ParentHelper ph = new ParentHelper();
                    boolean phExist= false;
                    for(ParentHelper i : allParentHelpers) {
                        if(sruField.getText().equals(i.getSRUNumber())) {
                            ph = i;
                            phExist=true;
                        }
                    }
                    if(phExist) {
                        allParentHelpers.remove(ph);

                        Validator.displayAlert("Alert", "ParentHelper deleted");
                        sruField.setText("");
                    }
                    else{
                        Validator.displayAlert("Invalid Input","Parent Helper doesn't exist with that sru number");
                    }

                }
        );
        searchWindow.showAndWait();
    }

    //Method to display all ParentHelpers in a table format
    public void displayAllParentHelpers(){
        TableView<ParentHelper> table;
        ObservableList<ParentHelper> parentHelpers = FXCollections.observableArrayList();
        for(ParentHelper i : allParentHelpers){
            parentHelpers.add(i);
        }
        Stage window = new Stage();
        window.setTitle("All Parent Helpers");

        //Name column
        TableColumn<ParentHelper, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(100);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //SRU column
        TableColumn<ParentHelper, String> SRUColoumn = new TableColumn<>("SRU Number");
        SRUColoumn.setMinWidth(50);
        SRUColoumn.setCellValueFactory(new PropertyValueFactory<>("SRUNumber"));

        //Address column
        TableColumn<ParentHelper, String> addressColumn = new TableColumn<>("Address");
        addressColumn.setMinWidth(100);
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));

        //DOB column
        TableColumn<ParentHelper, String> DOBColumn = new TableColumn<>("Date of birth");
        DOBColumn.setMinWidth(100);
        DOBColumn.setCellValueFactory(new PropertyValueFactory<>("DOB"));

        //mobileNum column
        TableColumn<ParentHelper, String> mobileNumColoumn = new TableColumn<>("Mobile Number");
        mobileNumColoumn.setMinWidth(100);
        mobileNumColoumn.setCellValueFactory(new PropertyValueFactory<>("mobileNum"));

        //Email column
        TableColumn<ParentHelper, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setMinWidth(100);
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        //Postcode column
        TableColumn<ParentHelper, String> postcodeColumn = new TableColumn<>("Postcode");
        postcodeColumn.setMinWidth(50);
        postcodeColumn.setCellValueFactory(new PropertyValueFactory<>("postcode"));

        table = new TableView<>();
        table.setItems(parentHelpers);
        table.getColumns().addAll(nameColumn, SRUColoumn,addressColumn,DOBColumn,mobileNumColoumn,emailColumn,postcodeColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Method to add TrainingRecord by displaying a form to take in all the TrainingRecord attributes
    public void newTrainingRecord(){

        Stage  addWindow = new Stage();
        addWindow.setTitle("Add Training Record");
        addWindow.initModality(Modality.APPLICATION_MODAL);
        GridPane newTRGrid = new GridPane();
        newTRGrid.setStyle("-fx-background-image: url('https://www.enca.com/sites/default/files/15365215W.jpg');-fx-font-size: 15 ");
        newTRGrid.setPadding(new Insets(25, 25, 25, 25));
        newTRGrid.setVgap(21);
        newTRGrid.setHgap(24);

        Label headerLabel = new Label("New Training Record");
        GridPane.setConstraints(headerLabel, 1, 0);

        //Coach organzing Label - constrains use (child, column, row)
        Label coachOrganzLabel = new Label("Coach Organizing:");
        GridPane.setConstraints(coachOrganzLabel, 0, 2);

        //Coach organizing Input
        TextField coachOrganzInput = new TextField();
        coachOrganzInput.setPromptText("Coach name");
        GridPane.setConstraints(coachOrganzInput, 1, 2);

        //Date Label
        Label dateLabel = new Label("Date:");
        GridPane.setConstraints(dateLabel, 0, 3);

        //Date Input
        TextField dateInput = new TextField();
        dateInput.setPromptText("Date");
        GridPane.setConstraints(dateInput, 1, 3);

        //Location Label
        Label locationLabel = new Label("Location:");
        GridPane.setConstraints(locationLabel, 0, 4);

        //Location Input
        TextField locationInput = new TextField();
        locationInput.setPromptText("Location");
        GridPane.setConstraints(locationInput, 1, 4);

        //Time Label
        Label timeLabel = new Label("Time:");
        GridPane.setConstraints(timeLabel, 0, 5);

        //Time Input
        TextField timeInput = new TextField();
        timeInput.setPromptText("Time");
        GridPane.setConstraints(timeInput, 1, 5);

        //Skills and activities Label
        Label skillActivitiesUnderTLabel = new Label("Skills and Activities:");
        GridPane.setConstraints(skillActivitiesUnderTLabel, 0, 6);

        //Skills and activities Input
        TextField skillActivitiesUnderTInput = new TextField();
        skillActivitiesUnderTInput.setPromptText("Skills and activities ");
        GridPane.setConstraints(skillActivitiesUnderTInput, 1, 6);

        //Players present Label
        Label playersPresentLabel = new Label("Players Present:");
        GridPane.setConstraints(playersPresentLabel, 0, 7);

        //Player present Input
        TextField playerPresentInput = new TextField();
        playerPresentInput.setPromptText("Players present");
        GridPane.setConstraints(playerPresentInput, 1, 7);

        //Injuries Label
        Label injuriesLabel = new Label("Injuries:");
        GridPane.setConstraints(injuriesLabel, 0, 8);

        //Injuries Input
        TextField injuriesInput = new TextField();
        injuriesInput.setPromptText("Injuries");
        GridPane.setConstraints(injuriesInput, 1, 8);

        //Add
        Button addButton = new Button("Add");
        GridPane.setConstraints(addButton, 1, 9);

        //Add everything to grid
        newTRGrid.getChildren().addAll(headerLabel,coachOrganzLabel, coachOrganzInput,dateLabel,dateInput, locationLabel, locationInput,timeLabel,timeInput,
                skillActivitiesUnderTLabel, skillActivitiesUnderTInput,playersPresentLabel,playerPresentInput,injuriesLabel,injuriesInput,addButton);
        Scene newTRScene = new Scene(newTRGrid, 600,500);
        addWindow.setScene(newTRScene);
        addWindow.setOnCloseRequest(e->{
            boolean answer= Validator.displayConfirm("Confirmation","Are you sure you want to close this window?");
            e.consume();
            if(answer){
                addWindow.close();
            }
        });

        addButton.setOnAction(e->{
            TrainingRecord trainingRecord = new TrainingRecord();
            trainingRecord.setCoachOrganizing(coachOrganzInput.getText());
            trainingRecord.setDate(dateInput.getText());
            trainingRecord.setLocation(locationInput.getText());
            trainingRecord.setTime(timeInput.getText());
            trainingRecord.setSkilliesAndActivitiesUnderT(skillActivitiesUnderTInput.getText());
            trainingRecord.setPlayerPresent(playerPresentInput.getText());
            trainingRecord.setInjuries(injuriesInput.getText());

            if(coachOrganzInput.getText().equals("") || dateInput.getText().equals("") || locationInput.getText().equals("") || timeInput.getText().equals("") ||
                    skillActivitiesUnderTInput.getText().equals("") || playerPresentInput.getText().equals("") || injuriesInput.getText().equals("")){
                Validator.displayAlert("Missing Value", "Please enter a value for all fields.");

                    }
            else {

                allTrainingRecords.add(trainingRecord);
                Validator.displayAlert("Alert", "TrainingRecord has been added!!");
                coachOrganzInput.setText("");
                dateInput.setText("");
                locationInput.setText("");
                timeInput.setText("");
                skillActivitiesUnderTInput.setText("");
                playerPresentInput.setText("");
                injuriesInput.setText("");
            }
        });
        addWindow.showAndWait();

    }

    //Method to display all TrainingRecords in a table format
    public void displayAllTrainingRecords(){
        TableView<TrainingRecord> table;
        ObservableList<TrainingRecord> trainingRecords = FXCollections.observableArrayList();
        for(TrainingRecord i : allTrainingRecords){
            trainingRecords.add(i);
        }
        Stage window = new Stage();
        window.setTitle("All Training Records");

        //Coach Organizing column
        TableColumn<TrainingRecord, String> coachOrganzColumn = new TableColumn<>("Coach Organizing");
        coachOrganzColumn.setMinWidth(100);
        coachOrganzColumn.setCellValueFactory(new PropertyValueFactory<>("coachOrganizing"));

        //date column
        TableColumn<TrainingRecord, String> dateColoumn = new TableColumn<>("Date");
        dateColoumn.setMinWidth(50);
        dateColoumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        //Address column
        TableColumn<TrainingRecord, String> locationColumn = new TableColumn<>("Address");
        locationColumn.setMinWidth(50);
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));

        //Time column
        TableColumn<TrainingRecord, String> timeColumn = new TableColumn<>("Time");
        timeColumn.setMinWidth(50);
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));

        //Skills and Activities column
        TableColumn<TrainingRecord, String> skillsAndActiviColoumn = new TableColumn<>("Skills and Activities");
        skillsAndActiviColoumn.setMinWidth(200);
        skillsAndActiviColoumn.setCellValueFactory(new PropertyValueFactory<>("skilliesAndActivitiesUnderT"));

        //Players present column
        TableColumn<TrainingRecord, String> playersPresentColumn = new TableColumn<>("Players Present");
        playersPresentColumn.setMinWidth(200);
        playersPresentColumn.setCellValueFactory(new PropertyValueFactory<>("playerPresent"));

        //Injuries column
        TableColumn<TrainingRecord, String> injuriesColumn = new TableColumn<>("Injuries");
        injuriesColumn.setMinWidth(200);
        injuriesColumn.setCellValueFactory(new PropertyValueFactory<>("injuries"));

        table = new TableView<>();
        table.setItems(trainingRecords);
        table.getColumns().addAll(coachOrganzColumn, dateColoumn,locationColumn,timeColumn,skillsAndActiviColoumn,playersPresentColumn,injuriesColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Method to add new GameRecord by displaying a form to take in all the GameRecord attributes
    public void newGameRecord(){

        Stage  addWindow = new Stage();
        addWindow.setTitle("Add Game Record");
        addWindow.initModality(Modality.APPLICATION_MODAL);
        GridPane newGRGrid = new GridPane();
        newGRGrid.setStyle("-fx-background-image: url('https://www.enca.com/sites/default/files/15365215W.jpg');-fx-font-size: 15 ");
        newGRGrid.setPadding(new Insets(25, 25, 25, 25));
        newGRGrid.setVgap(21);
        newGRGrid.setHgap(24);

        Label headerLabel = new Label("New Game Record");
        GridPane.setConstraints(headerLabel, 1, 0);

        //Opposition name Label - constrains use (child, column, row)
        Label oppoNameLabel = new Label("Opposition Name:");
        GridPane.setConstraints(oppoNameLabel, 0, 2);

        //Opposition name Input
        TextField opposNameInput = new TextField();
        opposNameInput.setPromptText("Opposition Name");
        GridPane.setConstraints(opposNameInput, 1, 2);

        //Date Label
        Label dateLabel = new Label("Date:");
        GridPane.setConstraints(dateLabel, 0, 3);

        //Date Input
        TextField dateInput = new TextField();
        dateInput.setPromptText("Date");
        GridPane.setConstraints(dateInput, 1, 3);

        //Location Label
        Label locationLabel = new Label("Location:");
        GridPane.setConstraints(locationLabel, 0, 4);

        //Location Input
        ChoiceBox<String> locationChoice = new ChoiceBox<>();
        //getItems returns the ObservableList object which you can add items to
        locationChoice.getItems().addAll("Home","Away");
        //Set a default value
        locationChoice.setValue("Home");
        GridPane.setConstraints(locationChoice, 1, 4);

        //Kick off Time Label
        Label kOTimeLabel = new Label("KO Time:");
        GridPane.setConstraints(kOTimeLabel, 0, 5);

        //Kick off Time Input
        TextField kOTimeInput = new TextField();
        kOTimeInput.setPromptText("KO Time");
        GridPane.setConstraints(kOTimeInput, 1, 5);

        //Result Label
        Label resultLabel = new Label("Result:");
        GridPane.setConstraints(resultLabel, 0, 6);

        //Result Input
        ChoiceBox<String> resultChoice = new ChoiceBox<>();
        //getItems returns the ObservableList object which you can add items to
        resultChoice.getItems().addAll("Won","Lost","Drew");
        //Set a default value
        resultChoice.setValue("Won");
        GridPane.setConstraints(resultChoice, 1, 6);


        //Score Label
        Label scoreLabel = new Label("Score:");
        GridPane.setConstraints(scoreLabel, 0, 7);

        //Score Input
        TextField scoreInput = new TextField();
        scoreInput.setPromptText("Score");
        GridPane.setConstraints(scoreInput, 1, 7);

        //First half sore and comments Label
        Label firstHalfScoreCommLabel = new Label("First Half Score and Comments:");
        GridPane.setConstraints(firstHalfScoreCommLabel, 0, 8);

        //First half sore and comments Input
        TextField firstHalfScoreCommInput = new TextField();
        firstHalfScoreCommInput.setPromptText("Score and Comment");
        GridPane.setConstraints(firstHalfScoreCommInput, 1, 8);

        //First half sore and comments Label
        Label secondHalfScoreCommLabel = new Label("Second Half Score and Comments:");
        GridPane.setConstraints(secondHalfScoreCommLabel, 0, 9);

        //Second half sore and comments Input
        TextField secondHalfScoreCommInput = new TextField();
        secondHalfScoreCommInput.setPromptText("Score and Comment");
        GridPane.setConstraints(secondHalfScoreCommInput, 1, 9);

        //Add
        Button addButton = new Button("Add");
        GridPane.setConstraints(addButton, 1, 10);

        //Add everything to grid
        newGRGrid.getChildren().addAll(headerLabel,oppoNameLabel, opposNameInput,dateLabel,dateInput, locationLabel, locationChoice,kOTimeLabel,kOTimeInput,
                resultLabel, resultChoice,scoreLabel,scoreInput,firstHalfScoreCommLabel,firstHalfScoreCommInput,secondHalfScoreCommLabel,secondHalfScoreCommInput,addButton);
        Scene newGRScene = new Scene(newGRGrid, 600,700);
        addWindow.setScene(newGRScene);
        addWindow.setOnCloseRequest(e->{
            boolean answer= Validator.displayConfirm("Confirmation","Are you sure you want to close this window?");
            e.consume();
            if(answer){
                addWindow.close();
            }
        });

        addButton.setOnAction(e->{
            GameRecord gameRecord = new GameRecord();
            gameRecord.setOppositionName(opposNameInput.getText());
            gameRecord.setDate(dateInput.getText());
            gameRecord.setLocation(locationChoice.getValue());
            gameRecord.setKoTime(kOTimeInput.getText());
            gameRecord.setResult(resultChoice.getValue());
            gameRecord.setScore(scoreInput.getText());
            gameRecord.setFirstHalfScoreComments(firstHalfScoreCommInput.getText());
            gameRecord.setSecondHalfScoreComments(secondHalfScoreCommInput.getText());

            if(opposNameInput.getText().equals("") || dateInput.getText().equals("") || kOTimeInput.getText().equals("") || scoreInput.getText().equals("") ||
                    firstHalfScoreCommInput.getText().equals("") || secondHalfScoreCommInput.getText().equals("")){
                Validator.displayAlert("Missing Value", "Please enter a value for all fields.");

                    }
            else {

                allGameRecords.add(gameRecord);
                Validator.displayAlert("Alert", "Game Record has been added!!");
                opposNameInput.setText("");
                dateInput.setText("");
                locationChoice.setValue("Home");
                kOTimeInput.setText("");
                resultChoice.setValue("Won");
                scoreInput.setText("");
                firstHalfScoreCommInput.setText("");
                secondHalfScoreCommInput.setText("");
            }
        });
        addWindow.showAndWait();

    }

    //Method to display all GameRecords in a table format
    public void displayAllGameRecords(){
        TableView<GameRecord> table;
        ObservableList<GameRecord> gameRecords = FXCollections.observableArrayList();
        for(GameRecord i : allGameRecords){
            gameRecords.add(i);
        }
        Stage window = new Stage();
        window.setTitle("All Game Records");

        //Opposition name column
        TableColumn<GameRecord, String> oppNameColumn = new TableColumn<>("Opposition name");
        oppNameColumn.setMinWidth(100);
        oppNameColumn.setCellValueFactory(new PropertyValueFactory<>("oppositionName"));

        //date column
        TableColumn<GameRecord, String> dateColoumn = new TableColumn<>("Date");
        dateColoumn.setMinWidth(50);
        dateColoumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        //Location column
        TableColumn<GameRecord, String> locationColumn = new TableColumn<>("Location");
        locationColumn.setMinWidth(50);
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));

        //KO Time column
        TableColumn<GameRecord, String> kotimeColumn = new TableColumn<>("KO Time");
        kotimeColumn.setMinWidth(50);
        kotimeColumn.setCellValueFactory(new PropertyValueFactory<>("koTime"));

        //Result column
        TableColumn<GameRecord, String> resultColoumn = new TableColumn<>("Result");
        resultColoumn.setMinWidth(50);
        resultColoumn.setCellValueFactory(new PropertyValueFactory<>("result"));

        //Score column
        TableColumn<GameRecord, String> scoreColumn = new TableColumn<>("Score");
        scoreColumn.setMinWidth(50);
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));

        //First Half Score and comments column
        TableColumn<GameRecord, String> firstHalfScoreCommColumn = new TableColumn<>("First Half Score & Comments");
        firstHalfScoreCommColumn.setMinWidth(250);
        firstHalfScoreCommColumn.setCellValueFactory(new PropertyValueFactory<>("firstHalfScoreComments"));

        //Second Half Score and Comments column
        TableColumn<GameRecord, String> secondHalfScoreCommColumn = new TableColumn<>("Second Half Score & Comments");
        secondHalfScoreCommColumn.setMinWidth(250);
        secondHalfScoreCommColumn.setCellValueFactory(new PropertyValueFactory<>("secondHalfScoreComments"));
        table = new TableView<>();
        table.setItems(gameRecords);
        table.getColumns().addAll(oppNameColumn,dateColoumn,locationColumn,kotimeColumn,resultColoumn,scoreColumn,firstHalfScoreCommColumn,secondHalfScoreCommColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    //Method to add new Player profile by taking in all the PlayerProfle attributes
    public void newPlayerProfile(){

        Stage addWindow = new Stage();
        addWindow.setTitle("Add Player Profile");
        addWindow.initModality(Modality.APPLICATION_MODAL);
        GridPane newPlayerProfileGrid = new GridPane();
        newPlayerProfileGrid.setStyle("-fx-background-image: url('https://www.enca.com/sites/default/files/15365215W.jpg');-fx-font-size: 15 ");
        newPlayerProfileGrid.setPadding(new Insets(25, 25, 25, 25));
        newPlayerProfileGrid.setVgap(15);
        newPlayerProfileGrid.setHgap(20);

        Label headerLabel = new Label("New Player Profile");
        GridPane.setConstraints(headerLabel, 1, 0);

        //Player SRU Num Label - constrains use (child, column, row)
        Label playerSRUNumLabel = new Label("Player SRU Number:");
        GridPane.setConstraints(playerSRUNumLabel, 0, 2);

        //Player SRU Number Input
        TextField playerSRUNumInput = new TextField();
        playerSRUNumInput.setPromptText("SRU Number");
        GridPane.setConstraints(playerSRUNumInput, 1, 2);

        //player name
        Label nameLabel = new Label("");
        GridPane.setConstraints(nameLabel, 2, 2);

        //Button
        Button verifyButton = new Button("Verify");
        GridPane.setConstraints(verifyButton, 3, 2);

        //SquadID Label
        Label squadIDLabel = new Label("Squad ID:");
        GridPane.setConstraints(squadIDLabel, 0, 3);

        //SquadID Input
        TextField squadInput = new TextField();
        GridPane.setConstraints(squadInput, 1, 3);

        //passing standard Label
        Label passingStandardLabel = new Label("Passing Standard:");
        GridPane.setConstraints(passingStandardLabel, 0, 4);

        //Passing Standard Input
        ChoiceBox<String> passingStandChoice = new ChoiceBox<>();
        //getItems returns the ObservableList object which you can add items to
        passingStandChoice.getItems().addAll(String.valueOf(1),String.valueOf(2),String.valueOf(3),String.valueOf(4),String.valueOf(5));
        //Set a default value
        passingStandChoice.setValue(String.valueOf(1));
        GridPane.setConstraints(passingStandChoice, 1, 4);

        //Passing Spin Label
        Label passingSpinLabel = new Label("Passing Spin:");
        GridPane.setConstraints(passingSpinLabel, 0, 5);

        //Passing Spin Input
        ChoiceBox<String> passingSpinChoice = new ChoiceBox<>();
        //getItems returns the ObservableList object which you can add items to
        passingSpinChoice.getItems().addAll(String.valueOf(1),String.valueOf(2),String.valueOf(3),String.valueOf(4),String.valueOf(5));
        //Set a default value
        passingSpinChoice.setValue(String.valueOf(1));
        GridPane.setConstraints(passingSpinChoice, 1, 5);

        //Passing Pop Label
        Label passingPopLabel = new Label("Passing pop:");
        GridPane.setConstraints(passingPopLabel, 0, 6);

        //Passing Pop Input
        ChoiceBox<String> passingPopChoice = new ChoiceBox<>();
        //getItems returns the ObservableList object which you can add items to
        passingPopChoice.getItems().addAll(String.valueOf(1),String.valueOf(2),String.valueOf(3),String.valueOf(4),String.valueOf(5));
        //Set a default value
        passingPopChoice.setValue(String.valueOf(1));
        GridPane.setConstraints(passingPopChoice, 1, 6);


        //Tackling Front Label
        Label tacklingFrontLabel = new Label("Tackling Front:");
        GridPane.setConstraints(tacklingFrontLabel, 0, 7);

        //Tackling Front Input
        ChoiceBox<String> tacklingFrontChoice = new ChoiceBox<>();
        //getItems returns the ObservableList object which you can add items to
        tacklingFrontChoice.getItems().addAll(String.valueOf(1),String.valueOf(2),String.valueOf(3),String.valueOf(4),String.valueOf(5));
        //Set a default value
        tacklingFrontChoice.setValue(String.valueOf(1));
        GridPane.setConstraints(tacklingFrontChoice, 1, 7);

        //Tackling Rear Label
        Label tacklingRearLabel = new Label("Tackling Rear:");
        GridPane.setConstraints(tacklingRearLabel, 0, 8);

        //Tackling Rear Input
        ChoiceBox<String> tacklingRearChoice = new ChoiceBox<>();
        //getItems returns the ObservableList object which you can add items to
        tacklingRearChoice.getItems().addAll(String.valueOf(1),String.valueOf(2),String.valueOf(3),String.valueOf(4),String.valueOf(5));
        //Set a default value
        tacklingRearChoice.setValue(String.valueOf(1));
        GridPane.setConstraints(tacklingRearChoice, 1, 8);

        //Tackling Slide Label
        Label tacklingSideLabel = new Label("Tackling Slide:");
        GridPane.setConstraints(tacklingSideLabel, 0, 9);

        //Tackling Side Input
        ChoiceBox<String> tacklingSideChoice = new ChoiceBox<>();
        //getItems returns the ObservableList object which you can add items to
        tacklingSideChoice.getItems().addAll(String.valueOf(1),String.valueOf(2),String.valueOf(3),String.valueOf(4),String.valueOf(5));
        //Set a default value
        tacklingSideChoice.setValue(String.valueOf(1));
        GridPane.setConstraints(tacklingSideChoice, 1, 9);

        //Tackling Scrabble Label
        Label tacklingScrabbleLabel = new Label("Tackling Scrabble:");
        GridPane.setConstraints(tacklingScrabbleLabel, 0, 10);

        //Tackling Scrabble Input
        ChoiceBox<String> tacklingScrabbleChoice = new ChoiceBox<>();
        //getItems returns the ObservableList object which you can add items to
        tacklingScrabbleChoice.getItems().addAll(String.valueOf(1),String.valueOf(2),String.valueOf(3),String.valueOf(4),String.valueOf(5));
        //Set a default value
        tacklingScrabbleChoice.setValue(String.valueOf(1));
        GridPane.setConstraints(tacklingScrabbleChoice, 1, 10);

        //Kicking Drop Label
        Label kickingDropLabel = new Label("Kicking Drop:");
        GridPane.setConstraints(kickingDropLabel, 0, 11);

        //Kicking Drop Input
        ChoiceBox<String> kickingDropChoice = new ChoiceBox<>();
        //getItems returns the ObservableList object which you can add items to
        kickingDropChoice.getItems().addAll(String.valueOf(1),String.valueOf(2),String.valueOf(3),String.valueOf(4),String.valueOf(5));
        //Set a default value
        kickingDropChoice.setValue(String.valueOf(1));
        GridPane.setConstraints(kickingDropChoice, 1, 11);

        //Kicking Punt Label
        Label kickingPuntLabel = new Label("Kicking Punt:");
        GridPane.setConstraints(kickingPuntLabel, 0, 12);

        //Kicking Punt Input
        ChoiceBox<String> kickingPuntChoice = new ChoiceBox<>();
        //getItems returns the ObservableList object which you can add items to
        kickingPuntChoice.getItems().addAll(String.valueOf(1),String.valueOf(2),String.valueOf(3),String.valueOf(4),String.valueOf(5));
        //Set a default value
        kickingPuntChoice.setValue(String.valueOf(1));
        GridPane.setConstraints(kickingPuntChoice, 1, 12);


        //Kicking GrubberLabel
        Label kickingGrubberLabel = new Label("Kicking Grubber:");
        GridPane.setConstraints(kickingGrubberLabel, 0, 13);

        //Kicking Grubber Input
        ChoiceBox<String> kickingGrubberChoice = new ChoiceBox<>();
        //getItems returns the ObservableList object which you can add items to
        kickingGrubberChoice.getItems().addAll(String.valueOf(1),String.valueOf(2),String.valueOf(3),String.valueOf(4),String.valueOf(5));
        //Set a default value
        kickingGrubberChoice.setValue(String.valueOf(1));
        GridPane.setConstraints(kickingGrubberChoice, 1, 13);

        //Kicking Goal Label
        Label kickingGoalLabel = new Label("Kicking Goal:");
        GridPane.setConstraints(kickingGoalLabel, 0, 14);

        //Kicking Goal Input
        ChoiceBox<String> kickingGoalChoice = new ChoiceBox<>();
        //getItems returns the ObservableList object which you can add items to
        kickingGoalChoice.getItems().addAll(String.valueOf(1),String.valueOf(2),String.valueOf(3),String.valueOf(4),String.valueOf(5));
        //Set a default value
        kickingGoalChoice.setValue(String.valueOf(1));
        GridPane.setConstraints(kickingGoalChoice, 1, 14);



        //Add
        Button addButton = new Button("Add");
        GridPane.setConstraints(addButton, 2, 15);

        //Add everything to grid
        newPlayerProfileGrid.getChildren().addAll(headerLabel,playerSRUNumLabel,playerSRUNumInput, nameLabel, verifyButton,squadIDLabel,squadInput,passingStandardLabel,passingStandChoice,passingSpinLabel,passingSpinChoice,
                passingPopLabel,passingPopChoice,tacklingFrontLabel,tacklingFrontChoice,tacklingRearLabel,tacklingRearChoice,tacklingSideLabel,tacklingSideChoice,
                tacklingScrabbleLabel,tacklingScrabbleChoice,kickingDropLabel,kickingDropChoice,kickingPuntLabel,kickingPuntChoice,kickingGrubberLabel,
                kickingGrubberChoice,kickingGoalLabel,kickingGoalChoice,addButton);
        Scene newPlayerProfileScene = new Scene(newPlayerProfileGrid, 600,750);
        addWindow.setScene(newPlayerProfileScene);
        PlayerProfile playerProfile = new PlayerProfile();
        final boolean[] playerFound = {false};
        verifyButton.setOnAction(h->{

            Player player = new Player();
            for(Player i: allPlayers){
                if(playerSRUNumInput.getText().equals(i.getSRUNumber())){
                    player= i;
                    playerFound[0] =true;
                }
            }
            if(playerFound[0]) {
                nameLabel.setText(player.getName());
                squadInput.setText(player.getSquadID());
                playerProfile.setSquadID(player.getSquadID());
            }
            else{
                nameLabel.setText("Invalid SRU Num");
            }


        });
        addButton.setOnAction(e->{

            playerProfile.setPlayerSRUNum(playerSRUNumInput.getText());
            playerProfile.setPassingStandard(Validator.validateInteger(passingStandChoice.getValue()));
            playerProfile.setPassingSpin(Validator.validateInteger(passingSpinChoice.getValue()));
            playerProfile.setPassingPop(Validator.validateInteger(passingPopChoice.getValue()));
            playerProfile.setTacklingFront(Validator.validateInteger(tacklingFrontChoice.getValue()));
            playerProfile.setTacklingRear(Validator.validateInteger(tacklingRearChoice.getValue()));
            playerProfile.setTacklingSide(Validator.validateInteger(tacklingSideChoice.getValue()));
            playerProfile.setTacklingScrabble(Validator.validateInteger(tacklingScrabbleChoice.getValue()));
            playerProfile.setKickingDrop(Validator.validateInteger(kickingDropChoice.getValue()));
            playerProfile.setKickingPunt((Validator.validateInteger(kickingPuntChoice.getValue())));
            playerProfile.setKickingGrubber(Validator.validateInteger(kickingGrubberChoice.getValue()));
            playerProfile.setKickingGoal(Validator.validateInteger(kickingGoalChoice.getValue()));

                if(playerFound[0]) {

                    allPlayerProfiles.add(playerProfile);
                    Validator.displayAlert("Alert", "Player Profile has been added!!");
                    playerSRUNumInput.setText("");
                    squadInput.setText("");
                    nameLabel.setText("");
                    passingStandChoice.setValue(String.valueOf(1));
                    passingSpinChoice.setValue(String.valueOf(1));
                    passingPopChoice.setValue(String.valueOf(1));
                    tacklingFrontChoice.setValue(String.valueOf(1));
                    tacklingRearChoice.setValue(String.valueOf(1));
                    tacklingSideChoice.setValue(String.valueOf(1));
                    tacklingScrabbleChoice.setValue(String.valueOf(1));
                    kickingDropChoice.setValue(String.valueOf(1));
                    kickingPuntChoice.setValue(String.valueOf(1));
                    kickingGrubberChoice.setValue(String.valueOf(1));
                    kickingGoalChoice.setValue(String.valueOf(1));
                }
                else{
                    Validator.displayAlert("Invalid Input","The player doesn't exist in the Squad you chose!");
                }

        });
        addWindow.showAndWait();

    }

    //Method to display PlayerProfile for a specfic player in a PieChart
    public void displayPlayerProfile(){
        searchWindow = new Stage();
        searchWindow.setTitle("Player Profile");
        searchWindow.initModality(Modality.APPLICATION_MODAL);

        Label sruLabel = new Label("Enter Player SRU Number: ");
        GridPane.setConstraints(sruLabel,0,1);
        TextField sruField = new TextField();
        GridPane.setConstraints(sruField,1,1);
        Button showPlayerProfileBtn = new Button("Display");
        GridPane.setConstraints(showPlayerProfileBtn,1,2);

        GridPane myGrid = new GridPane();
        myGrid.setStyle("-fx-background-image: url('https://www.enca.com/sites/default/files/15365215W.jpg');-fx-font-size: 15 ");
        myGrid.setPadding(new Insets(30, 30, 30, 30));
        myGrid.setVgap(20);
        myGrid.setHgap(25);
        myGrid.getChildren().addAll(sruLabel,sruField,showPlayerProfileBtn);
        Scene showPlayerProfScene = new Scene(myGrid,400,200);
        searchWindow.setScene(showPlayerProfScene);
        PieChart piechart = new PieChart();

        showPlayerProfileBtn.setOnAction(event -> {
                    PlayerProfile playerProfile = new PlayerProfile();
                    boolean playerProfileFound =false;
                    for(PlayerProfile i : allPlayerProfiles) {
                        if(sruField.getText().equalsIgnoreCase(i.getPlayerSRUNum())) {

                            playerProfile = i;
                            playerProfileFound=true;
                        }
                    }
                    if(playerProfileFound) {
                        ObservableList<PieChart.Data> list =FXCollections.observableArrayList(
                                new PieChart.Data(("passing Standard "+playerProfile.getPassingStandard()), playerProfile.getPassingStandard()),
                                new PieChart.Data(("passing Spin "+playerProfile.getPassingSpin()), playerProfile.getPassingSpin()),
                                new PieChart.Data(("passing Pop "+playerProfile.getPassingPop()), playerProfile.getPassingPop()),
                                new PieChart.Data(("Tackling Front "+playerProfile.getTacklingFront()), playerProfile.getTacklingFront()),
                                new PieChart.Data(("Tackling Rear " +playerProfile.getTacklingRear()), playerProfile.getTacklingRear()),
                                new PieChart.Data(("Tackling Side "+playerProfile.getTacklingSide()), playerProfile.getTacklingSide()),
                                new PieChart.Data(("Tackling Scrabble "+playerProfile.getTacklingScrabble()), playerProfile.getTacklingScrabble()),
                                new PieChart.Data(("Kicking Drop "+playerProfile.getKickingDrop()), playerProfile.getKickingDrop()),
                                new PieChart.Data(("Kicking Punt "+playerProfile.getKickingPunt()), playerProfile.getKickingPunt()),
                                new PieChart.Data(("Kicking Grubber "+playerProfile.getKickingGrubber()), playerProfile.getKickingGrubber()),
                                new PieChart.Data(("Kicking Goal "+playerProfile.getKickingGoal()), playerProfile.getKickingGoal())

                                );
                        piechart.setData(list);
                        Scene chartScene= new Scene(piechart,800,600);
                        searchWindow.setScene(chartScene);
                    }
                    else{
                        Validator.displayAlert("Incorrect Input","There is no player profile for the player you entered!");
                    }



                }
        );
        searchWindow.showAndWait();
    }
}
