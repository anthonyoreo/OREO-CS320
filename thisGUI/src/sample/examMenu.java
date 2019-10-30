
package sample;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import java.io.IOException;


public class examMenu extends Scene {


    private ChoiceBox tenChoice, fourChoice;
    private Button next_Bt, last_Bt, backToMenu_Bt;
    private Text text;
    private int questionNumber;


    public examMenu(Parent root, double width, double height) {
        super(root, width, height);
    }
        public Pane assess_Pane(paneController paneController){

            StackPane assess_Pane = new StackPane();
            questions questions = new questions();
            assess_Pane.setStyle("-fx-background-color: white");

            tenChoice = new ChoiceBox();
            tenChoice.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
            assess_Pane.setAlignment(tenChoice, Pos.CENTER);
            tenChoice.setTranslateY(30);

            fourChoice = new ChoiceBox();
            fourChoice.getItems().addAll("None", "Mid", "Moderate", "Max");
            StackPane.setAlignment(fourChoice, Pos.CENTER);
            fourChoice.setTranslateY(30);

            text = new Text();
            text.setText(questions.getQuestion(questionNumber));
            StackPane.setAlignment(text, Pos.CENTER);

            next_Bt = new Button("Next");
            StackPane.setAlignment(next_Bt, Pos.BOTTOM_RIGHT);
            next_Bt.setTranslateY(-15);
            next_Bt.setTranslateX(-15);

            last_Bt = new Button("Last");
            StackPane.setAlignment(last_Bt, Pos.BOTTOM_LEFT);
            last_Bt.setTranslateY(-15);
            last_Bt.setTranslateX(15);


            backToMenu_Bt = new Button("Save and Return to Menu");
            StackPane.setAlignment(backToMenu_Bt, Pos.TOP_LEFT);
            backToMenu_Bt.setTranslateY(15);
            backToMenu_Bt.setTranslateX(15);
            backToMenu_Bt.setOnAction(e -> paneController.enterMainMenu());

            assess_Pane.getChildren().addAll(next_Bt, last_Bt, backToMenu_Bt, text);

            return assess_Pane;
        }
}
