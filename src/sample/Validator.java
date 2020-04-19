package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;

public class Validator {


    /*
     * Validate Integer method
     * Tries to scan nextLine() and parse input to Integer
     * Assigns to variable num
     * Returns num
     * Catches InputMismatchException
     */
    public static int validateInteger(String number) {
        int num = 0;
        try {
            num = Integer.parseInt(number);
            return num;
        } catch (InputMismatchException e) {

        }
        catch(NumberFormatException e){

        }
        return num;
    }


    //Method to display a confirmation box  by taking title and message
    static boolean answer;
    public static boolean displayConfirm(String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        Label label = new Label();
        label.setText(message);

        //Create two buttons
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");

        //Clicking will set answer and close window
        yesButton.setOnAction(e -> {
            answer = true;
            window.close();
        });
        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });

        VBox answerLayout = new VBox(25);
        answerLayout.setStyle("-fx-background-color: #e0e8b7; -fx-font-family: Roboto");

        //Add buttons
        answerLayout.getChildren().addAll(label,yesButton, noButton);
        answerLayout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(answerLayout);
        window.setScene(scene);
        window.showAndWait();

        //Make sure to return answer
        return answer;
    }

    //Method to display alert by taking title and message
    public static void displayAlert(String title, String message) {
        Stage alertWindow = new Stage();

        //Block events to other windows
        alertWindow.initModality(Modality.APPLICATION_MODAL);
        alertWindow.setTitle(title);
        alertWindow.setMinWidth(350);

        Label info = new Label();
        info.setText(message);
        Button closeButton = new Button("Ok");
        closeButton.setOnAction(e -> alertWindow.close());

        VBox layout = new VBox(10);
        layout.setStyle("-fx-background-color: #e0e8b7; -fx-font-family: Roboto");
        layout.getChildren().addAll(info, closeButton);
        layout.setAlignment(Pos.CENTER);

        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(layout);
        alertWindow.setScene(scene);
        alertWindow.show();
    }


    //Method to check file exist in the path identified and use bufferreder to read the content
    public static BufferedReader checkFile(String pathAndFile) {

        BufferedReader in = null;

        try {
            in = new BufferedReader(new FileReader(new File(pathAndFile)));

        } catch (FileNotFoundException var3) {
            displayAlert("Error", "File doesnt't exists");
            System.exit(0);
        }

        return in;
    }

    /*
     * ID Generator method
     * Takes String prefix as parameter
     * Generates a random number between 0 and 1 and multiplies it
     * by 1000 - giving a random number between 0 and 999
     * Sets id to prefix + random number
     * Returns id
     */
    public static String passwordGenerator(String prefix) {
        int random = (int)Math.ceil(Math.random() * 1000);
        String password = prefix + random;
        return password;
    }

    public static void closeWindowRequest(Stage window){
        window.setOnCloseRequest(e->{
            boolean answer= Validator.displayConfirm("Confirmation","Are you sure you want to close this window?");
            e.consume();
            if(answer){
                window.close();
            }
        });
    }


}
