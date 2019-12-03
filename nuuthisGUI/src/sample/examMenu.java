
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
    private Button next_Bt, last_Bt, backToMenu_Bt, seeResults_Bt;
    private Text text, section, exam;
    private int questionNumber = 0;
    private double progress = 0.0;
    private double increment = 0.0238;
    String[] PLOFanswers = new String[19];
    public double[] answers = new double[42];
    public double[] results = new double[5];
    public double[] plofResults = new double[5];
    private int resultIndex;
    int[] test = new int[5];
    ProgressBar bar;
    int tmp = 0;


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
        fourChoice.getItems().addAll("None", "Min", "Moderate", "Max");
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
        section.setTranslateX(-150);
        section.setTranslateY(-60);
        
        exam = new Text();
        StackPane.setAlignment(exam,  Pos.CENTER);
        exam.setTranslateY(-100);
        exam.setStyle("-fx-font-size: 25 arial; ");

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
        next_Bt.setOnAction(e -> {
                //caseSwitch();
                text.setText(questions.getQuestion(questionNumber));
                if (questionNumber >= 0 && questionNumber < 18) {
                    fourChoice.setVisible(true);
                    questionNumber++;
                } else if (questionNumber >= 18 && questionNumber < 41) {
                    fourChoice.setVisible(false);
                    tenChoice.setVisible(true);
                    questionNumber++;
                } else if (questionNumber >= 41) {
                    results[4] = sumArray() * ( 5.0/6 );
                    paneController.setResults(results[4]);
                    paneController.enterResultsMenu();
                    //questionNumber++;
                }
                ;
            //
            try {
                caseSwitch();
                if (questionNumber >= 18) {
                    answers[questionNumber - 1] = Integer.parseInt(tenChoice.getValue().toString());
                    //Integer.parseInt(fourChoice.getValue().toString());
                } else if (questionNumber > 1 && questionNumber < 18) {
                    //try throw catch insert for no answer input
                    PLOFanswers[questionNumber - 1] = fourChoice.getValue().toString();

                    if (PLOFanswers[questionNumber - 1].equals("None")) {answers[questionNumber - 1] = 0;}
                    else if (PLOFanswers[questionNumber - 1].equals("Min")) {answers[questionNumber - 1] = 1.75;}
                    else if (PLOFanswers[questionNumber - 1].equals("Moderate")) {answers[questionNumber - 1] = 4.5;}
                    else if (PLOFanswers[questionNumber - 1].equals("Max")) {answers[questionNumber - 1] = 8.0;}

                }
                //System.out.println(answers[questionNumber-1]);
                bar.setProgress(progress += increment);
            }
            catch(Exception k)
            {
                bar.setProgress(progress += increment);;
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
        last_Bt.setOnAction(e -> {
            if (questionNumber > 0) {

                if (questionNumber < 19) {
                    fourChoice.setVisible(true);
                } else if (questionNumber >= 19) {
                    fourChoice.setVisible(false);
                    tenChoice.setVisible(true);
                } else if (questionNumber == 41) {
                    paneController.enterResultsMenu();
                }
                ;
                text.setText(questions.getQuestion(--questionNumber));
                caseSwitch();
            }
         else {
            ;
        };
            bar.setProgress(progress -= increment);
            next_Bt.setVisible(true);
        });


        seeResults_Bt = new Button("view exam results");
        seeResults_Bt.setStyle("-fx-font-size: 15 arial; "
                + "-fx-background-color: #1dbfdb; "
                + "-fx-text-fill: white;"
                + "-fx-background-radius: 25px;");
        StackPane.setAlignment(seeResults_Bt, Pos.BOTTOM_CENTER);
        seeResults_Bt.setTranslateY(-20);
        seeResults_Bt.setTranslateX(20);
        seeResults_Bt.setOnAction(e -> {paneController.enterResultsMenu();});

        backToMenu_Bt = new Button("Save and Return to Menu");
        backToMenu_Bt.setStyle("-fx-font-size: 15 arial; "
                + "-fx-background-color: #1dbfdb; "
                + "-fx-text-fill: white;"
                + "-fx-background-radius: 25px;");
        StackPane.setAlignment(backToMenu_Bt, Pos.TOP_LEFT);
        backToMenu_Bt.setTranslateY(15);
        backToMenu_Bt.setTranslateX(15);
        backToMenu_Bt.setOnAction(e -> {paneController.enterMainMenu();
            //System.out.print(sumStringArray(PLOFanswers));
            //System.out.print(sumArray(answers));

        });

        assess_Pane.getChildren().addAll(next_Bt, last_Bt, backToMenu_Bt, text, tenChoice, fourChoice, bar, section, seeResults_Bt, exam);

        return assess_Pane;
    }

    public void caseSwitch() {
        switch (questionNumber-1) {
            case 1:
                section.setText("Auditory Processing");
                exam.setText("Prior Level of Function");
                tmp = questionNumber;
                break;
            case 4:
                section.setText("Auditory Processing");
                break;

            case 5:
                section.setText("Problem Solving");
                plofResults[0] = (5.4/5) * (sumArray());
                paneController.setPlofResults(plofResults[0]);
                System.out.println(paneController.getPlofResults()[0]);
                //plofResults[0] = (answers[0] + answers[1] + answers[2] + answers[3])/4;
                break;
            case 8:
                section.setText("Problem Solving");
                break;

            case 9:
                section.setText("Reasoning");
                plofResults[1] = (6/5) * (sumArray());
                paneController.setPlofResults(plofResults[1]);
                break;
            case 11:
                section.setText("Reasoning");
                break;
            case 12:
                section.setText("Memory");
                plofResults[2] = (6/5) * (sumArray());
                paneController.setPlofResults(plofResults[2]);
                break;
            case 14:
                section.setText("Memory");
                break;
            case 15:
                section.setText("Pragmatics");
                plofResults[3] = (6/5) * (sumArray());
                paneController.setPlofResults(plofResults[3]);
                break;
            case 17:
                section.setText("Pragmatics");
                break;
            case 18:
                //tmp = questionNumber;
                section.setText("Auditory Processing");
                exam.setText("Patient Exam");
                plofResults[4] = (6/5) * (sumArray());
                paneController.setPlofResults(plofResults[4]);
                break;
            case 22:
                section.setText("Auditory Processing");
                break;
            case 23:
                section.setText("Problem Solving");
                results[0] = sumArray();
                paneController.setResults(results[0]);
                break;
            case 27:
                section.setText("Problem Solving");
                break;
            case 28:
                section.setText("Memory");
                results[1] = sumArray();
                paneController.setResults(results[1]);
                break;
            case 31:
                section.setText("Memory");
                break;
            case 32:
                section.setText("Reasoning");
                results[2] = sumArray();
                paneController.setResults(results[2]);
                break;
            case 36:
                section.setText("Reasoning");
                break;
            case 37:
                section.setText("Pragmatics");
                results[3] = sumArray();
                paneController.setResults(results[3]);
                break;
            case 40:
                section.setText("Pragmatics");
                break;
        }
    }

    public double sumArray() {

        double len = questionNumber - tmp;
        double sum = 0;

        for(int i = 0 ; i < len; i++)
        { sum += answers[questionNumber - i - 1];}

        tmp = questionNumber;
        System.out.println(((sum/(len*10) *100 ) / 80 ) * 100 );
        return ((sum/(len*10) *100 ) / 80 ) * 100 ;
    }

    public double[] getAnswers()
    {
        return answers;
    }

    public double[] getResults()
    {
        return results;
    }

    public double[] getPlofResults()
    {
        return plofResults;
    }

}
