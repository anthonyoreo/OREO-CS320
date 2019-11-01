
package sample;
import javafx.geometry.Pos;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.stream.IntStream;


public class examMenu extends Scene {


    private ChoiceBox tenChoice, fourChoice;
    private Button next_Bt, last_Bt, backToMenu_Bt;
    private Text text, section;
    private int questionNumber = 0;
    private double progress = 0.0;
    private double increment = 0.0238;
    int[] PLOFanswers = new int[19];
    String[] answers = new String[24];
    int[] test = new int[5];
    ProgressBar bar;


    public examMenu(Parent root, double width, double height) {
        super(root, width, height);
    }
   
    public Pane assess_Pane(paneController paneController){
    		
            StackPane assess_Pane = new StackPane();
            questions questions = new questions();
            assess_Pane.setStyle("-fx-background-color: white");

            tenChoice = new ChoiceBox();
            tenChoice.getItems().addAll("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
            assess_Pane.setAlignment(tenChoice, Pos.CENTER);
            tenChoice.setTranslateY(30);
            tenChoice.setVisible(false);
            //tenChoice.setValue("0");

            fourChoice = new ChoiceBox();
            fourChoice.getItems().addAll("None", "Mid", "Moderate", "Max");
            StackPane.setAlignment(fourChoice, Pos.CENTER);
            fourChoice.setTranslateY(30);
            fourChoice.setVisible(false);
            
            bar = new ProgressBar();
            StackPane.setAlignment(bar, Pos.TOP_CENTER);
            bar.setProgress(0);
            bar.setPrefWidth(300);
            bar.setTranslateY(100);

            section = new Text();
            StackPane.setAlignment(section, Pos.CENTER);
            section.setTranslateX(-200);
            section.setTranslateY(-75);
            
            text = new Text();
            text.setText(questions.getQuestion(questionNumber));
            StackPane.setAlignment(text, Pos.CENTER);

            next_Bt = new Button("Next");
            next_Bt.setStyle("-fx-font-size: 15 arial; "
            		+ "-fx-background-color: #1dbfdb; "
            		+ "-fx-text-fill: white;"
            		+ "-fx-background-radius: 25px;");
            StackPane.setAlignment(next_Bt, Pos.BOTTOM_RIGHT);
            next_Bt.setTranslateY(-15);
            next_Bt.setTranslateX(-15);
	        next_Bt.setOnAction(e -> {text.setText(questions.getQuestion(++questionNumber));
	            						if (questionNumber == 1) {
	            							tenChoice.setVisible(true);
	            						} else if (questionNumber == 18) {
	            							fourChoice.setVisible(true);
	            							tenChoice.setVisible(false);
	            						} else if (questionNumber == 42) {
	            							questionNumber = 41;
	            							text.setText("End of Assessment");
	            							next_Bt.setVisible(false);
	            						};
	            						bar.setProgress(progress += increment);
	            						caseSwitch();
	            						if (questionNumber > 18) {
	            							answers[questionNumber - 18] = fourChoice.getValue().toString();
	            						} else if (questionNumber > 1) {
	            							PLOFanswers[questionNumber - 1] = Integer.parseInt(tenChoice.getValue().toString());
	            						}	            					
	            						tenChoice.getSelectionModel().clearSelection();
	            						fourChoice.getSelectionModel().clearSelection();
	        						});
	        
            last_Bt = new Button("Last");
            last_Bt.setStyle("-fx-font-size: 15 arial; "
            		+ "-fx-background-color: #1dbfdb; "
            		+ "-fx-text-fill: white;"
            		+ "-fx-background-radius: 25px;");
            StackPane.setAlignment(last_Bt, Pos.BOTTOM_LEFT);
            last_Bt.setTranslateY(-15);
            last_Bt.setTranslateX(15);
            last_Bt.setOnAction(e -> {if (questionNumber > 0) {
            							text.setText(questions.getQuestion(--questionNumber));
            						} else {
            							;
            						};
            						bar.setProgress(progress -= increment);
            						next_Bt.setVisible(true);
            					});
          

            backToMenu_Bt = new Button("Save and Return to Menu");
            backToMenu_Bt.setStyle("-fx-font-size: 15 arial; "
            		+ "-fx-background-color: #1dbfdb; "
            		+ "-fx-text-fill: white;"
            		+ "-fx-background-radius: 25px;");
            StackPane.setAlignment(backToMenu_Bt, Pos.TOP_LEFT);
            backToMenu_Bt.setTranslateY(15);
            backToMenu_Bt.setTranslateX(15);
            backToMenu_Bt.setOnAction(e -> {paneController.enterMainMenu();
            							System.out.print(sumArray(PLOFanswers));
            							System.out.print(sumStringArray(answers));
							
            });

            assess_Pane.getChildren().addAll(next_Bt, last_Bt, backToMenu_Bt, text, tenChoice, fourChoice, bar, section);

            return assess_Pane;
        }
    
    	public void caseSwitch() {
    		switch (questionNumber) {
				case 1:
					section.setText("Auditory Processing");
					break;
				case 5:
					section.setText("Problem Solving");
					break;
				case 9:
					section.setText("Reasoning");
					break;
				case 12:
					section.setText("Memory");
					break;
				case 15:
					section.setText("Pragmatics");
					break;
				case 18:
					section.setText("Auditory Processing");
					break;
				case 23:
					section.setText("Problem Solving");
					break;
				case 28:
					section.setText("Memory");
					break;
				case 32:
					section.setText("Reasiong");
					break;
				case 37:
					section.setText("Pragmatics");
					break;
			}
    	}
    	
    	public int sumArray(int[] array) {
    		return IntStream.of(array).sum();
    	}
    	
    	public int sumStringArray(String[] array) {
    		int sum = 0;
    		for (int i = 0; i < array.length; i++) {
    			arra
    		}
    		return 0;
    	}
    
}
