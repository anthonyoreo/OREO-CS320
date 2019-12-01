package sample;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class loginMenu extends Scene{

    private TextField login_user;
    private PasswordField login_Pass;
    private Label loginError, userError, passError;
    private loginDB login = new loginDB();
    private Button LI_enter_Bt1, create_Bt, recover_Bt;
    Label title = new Label(" Informal Cognitive Linguistic Assessment");

    public loginMenu(Parent root, double width, double height) {
            super(root, width, height);



        }

    public Pane login_Pane(paneController paneController){



        Pane login_Pane = new Pane();
        login_Pane.setStyle("-fx-background-color: white");
        title.setStyle("-fx-font: 25 arial;");
        title.setTranslateX(70);
        login_Pane.getChildren().add(title);

        Label login_Lab = new Label("LOGIN");
        login_Lab.setStyle("-fx-font: 20 arial;");
        login_Lab.setTranslateX(250);
        login_Lab.setTranslateY(50);
        login_Pane.getChildren().add(login_Lab);

        Label user_Lab = new Label("Username:");
        user_Lab.setStyle("-fx-font: 20 arial;");
        user_Lab.setTranslateX(130);
        user_Lab.setTranslateY(105);
        login_Pane.getChildren().add(user_Lab);

        loginError = new Label("Username or Password is incorrect");
        loginError.setStyle("-fx-font: 10 arial");
        loginError.setTranslateX(250);
        loginError.setTranslateY(75);
        login_Pane.getChildren().add(loginError);
        loginError.setVisible(false);

        userError = new Label("That username is already taken");
        userError.setStyle("-fx-font: 10 arial");
        userError.setTranslateX(250);
        userError.setTranslateY(75);
        userError.setVisible(false);

        passError = new Label("Passwords do not match");
        passError.setStyle("-fx-font: 10 arial");
        passError.setTranslateX(250);
        passError.setTranslateY(75);
        passError.setVisible(false);

        login_user = new TextField();
        login_user.setPromptText("your username");
        login_user.setTranslateX(250);
        login_user.setTranslateY(100);
        login_Pane.getChildren().add(login_user);
        // Check user name w/ database: if it matches none throw error

        Label pass_Lab = new Label("Password:");
        pass_Lab.setStyle("-fx-font: 20 arial;");
        pass_Lab.setTranslateX(130);
        pass_Lab.setTranslateY(155);
        login_Pane.getChildren().add(pass_Lab);

        login_Pass = new PasswordField();
        login_Pass.setPromptText("your password");
        login_Pass.setTranslateX(250);
        login_Pass.setTranslateY(150);
        login_Pane.getChildren().add(login_Pass);

        // Check password w/ encryption: if it doesn't match username throw error

        LI_enter_Bt1 = new Button("Enter");
        LI_enter_Bt1.setLayoutX(325);
        LI_enter_Bt1.setLayoutY(200);
        LI_enter_Bt1.setStyle("-fx-font-size: 15 arial; ");
        LI_enter_Bt1.setOnAction(e ->{
                try {
                    login.getData();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                if (login.checkCreds(login_user.getText(), login_Pass.getText())) {
                    paneController.enterMainMenu();
                } else {
                    login_Pass.clear();
                    loginError.setVisible(true);
                }
            });

        LI_enter_Bt1.setDefaultButton(true);

        create_Bt = new Button("Create Account");
        create_Bt.setLayoutX(175);
        create_Bt.setLayoutY(200);
        create_Bt.setStyle("-fx-font-size: 15 arial; ");

        create_Bt.setOnAction(e ->{
            try {
                login.getData();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            paneController.enterAccountMenu();
        });

        recover_Bt = new Button( "forgot your information?");
        recover_Bt.setLayoutX(500);
        recover_Bt.setLayoutY(400);
        recover_Bt.setStyle("-fx-font-size: 15 arial; ");
        recover_Bt.setOnAction(e -> {paneController.enterRecoverMenu();});


        login_Pane.getChildren().addAll(create_Bt, LI_enter_Bt1,recover_Bt);
        return login_Pane;
    }



}