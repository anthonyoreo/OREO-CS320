package sample;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;


public class accountMenu extends Scene{

    private TextField create_login_user;
    private PasswordField create_login_Pass, conlogin_Pass;
    private loginDB login = new loginDB();
    private Button create_enter_Bt, create_back_Bt;
    private paneController paneController;
    private Label userError, passError;

    Label title = new Label(" Informal Cognitive Linguistic Assessment");

    public accountMenu(Parent root, double width, double height) {
        super(root, width, height);
    }


    public Pane accountPane(paneController paneController){
        this.paneController = paneController;
        Pane create_Pane = new Pane();
        create_Pane.setStyle("-fx-background-color: white");
        title.setStyle("-fx-font: 25 arial;");
        title.setTranslateX(70);
        create_Pane.getChildren().add(title);

        Label create_Lab = new Label("Create an Account");
        create_Lab.setStyle("-fx-font: 20 arial;");
        create_Lab.setTranslateX(200);
        create_Lab.setTranslateY(50);
        create_Pane.getChildren().add(create_Lab);

        Label create_user_Lab = new Label("Username:");
        create_user_Lab.setStyle("-fx-font: 20 arial;");
        create_user_Lab.setTranslateX(130);
        create_user_Lab.setTranslateY(105);
        create_Pane.getChildren().add(create_user_Lab);

        create_login_user = new TextField();
        create_login_user.setPromptText("your username");
        create_login_user.setTranslateX(250);
        create_login_user.setTranslateY(100);
        create_Pane.getChildren().add(create_login_user);

        Label create_pass_Lab = new Label("Password:");
        create_pass_Lab.setStyle("-fx-font: 20 arial;");
        create_pass_Lab.setTranslateX(130);
        create_pass_Lab.setTranslateY(155);
        create_Pane.getChildren().add(create_pass_Lab);

        create_login_Pass = new PasswordField();
        create_login_Pass.setPromptText("your password");
        create_login_Pass.setTranslateX(250);
        create_login_Pass.setTranslateY(150);
        create_Pane.getChildren().add(create_login_Pass);

        Label conpass_Lab = new Label("Confirm Password:");
        conpass_Lab.setStyle("-fx-font: 20 arial;");
        conpass_Lab.setTranslateX(55);
        conpass_Lab.setTranslateY(205);
        create_Pane.getChildren().add(conpass_Lab);

        conlogin_Pass = new PasswordField();
        conlogin_Pass.setPromptText("confirm password");
        conlogin_Pass.setTranslateX(250);
        conlogin_Pass.setTranslateY(200);
        create_Pane.getChildren().add(conlogin_Pass);

        userError = new Label("That username is already taken");
        userError.setStyle("-fx-font: 10 arial");
        userError.setTranslateX(250);
        userError.setTranslateY(75);
        create_Pane.getChildren().add(userError);
        userError.setVisible(false);

        passError = new Label("Passwords do not match");
        passError.setStyle("-fx-font: 10 arial");
        passError.setTranslateX(250);
        passError.setTranslateY(75);
        create_Pane.getChildren().add(passError);
        passError.setVisible(false);

        Label email_Lab = new Label("Email:");
        email_Lab.setStyle("-fx-font: 20 arial;");
        email_Lab.setTranslateX(170);
        email_Lab.setTranslateY(255);
        create_Pane.getChildren().add(email_Lab);

        TextField login_email = new TextField();
        login_email.setPromptText("your email");
        login_email.setTranslateX(250);
        login_email.setTranslateY(250);
        create_Pane.getChildren().add(login_email);

        create_enter_Bt = new Button("   Enter   ");
        create_enter_Bt.setLayoutX(325);
        create_enter_Bt.setLayoutY(300);
        create_enter_Bt.setStyle("-fx-font-size: 15 arial; ");

        create_enter_Bt.setOnAction(e ->{

            //adds info to system and brings to main menu
            if (login.checkKey(create_login_user.getText())) {
                passError.setVisible(false);
                userError.setVisible(true);
                conlogin_Pass.clear();
            } else {
                if (conlogin_Pass.getText().equals(create_login_Pass.getText())) {
                    login.setUsername(create_login_user.getText());
                    login.setPassword(create_login_Pass.getText());
                    try {
                        login.putInfo();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    paneController.enterMainMenu();
                } else {
                    conlogin_Pass.clear();
                    userError.setVisible(false);
                    passError.setVisible(true);
                }
            }

        });

        create_Pane.getChildren().add(create_enter_Bt);

        create_back_Bt = new Button("   Back   ");
        create_back_Bt.setLayoutX(175);
        create_back_Bt.setLayoutY(300);
        create_back_Bt.setStyle("-fx-font-size: 15 arial; ");
        create_back_Bt.setOnAction(e ->{ paneController.enterLoginMenu();});
        create_Pane.getChildren().add(create_back_Bt);

        return create_Pane;
    }
    }

