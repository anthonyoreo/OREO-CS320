package sample;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

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

        StackPane login_Pane = new StackPane();
        login_Pane.setStyle("-fx-background-color: white");
        title.setStyle("-fx-font: 25 arial;");
        StackPane.setAlignment(title, Pos.TOP_CENTER);
        login_Pane.getChildren().add(title);

        Label login_Lab = new Label("LOGIN");
        login_Lab.setStyle("-fx-font: 20 arial;");
        StackPane.setAlignment(login_Lab, Pos.TOP_CENTER);
        login_Lab.setTranslateY(50);
        login_Pane.getChildren().add(login_Lab);
//
//        loginError = new Label("Username or Password is incorrect");
//        loginError.setStyle("-fx-font: 10 arial");
//        StackPane.setAlignment(title, Pos.TOP_CENTER);
//        loginError.setTranslateY(50);
//        login_Pane.getChildren().add(loginError);
//        loginError.setVisible(false);
//
//        userError = new Label("That username is already taken");
//        userError.setStyle("-fx-font: 10 arial");
//        StackPane.setAlignment(title, Pos.TOP_CENTER);
//        userError.setTranslateY(50);
//        userError.setVisible(false);
//
//        passError = new Label("Passwords do not match");
//        passError.setStyle("-fx-font: 10 arial");
//        StackPane.setAlignment(title, Pos.TOP_CENTER);
//        passError.setTranslateY(50);
//        passError.setVisible(false);

        Label user_Lab = new Label("Username:");
        user_Lab.setStyle("-fx-font: 20 arial;");
        StackPane.setAlignment(title, Pos.TOP_CENTER);
        user_Lab.setTranslateX(-115);
        user_Lab.setTranslateY(-75);
        login_Pane.getChildren().add(user_Lab);
        
        login_user = new TextField();
        login_user.setPromptText("your username");
        login_user.setMaxWidth(200);
        StackPane.setAlignment(title, Pos.TOP_CENTER);
        login_user.setTranslateX(45);
        login_user.setTranslateY(-75);
        login_Pane.getChildren().add(login_user);
        // Check user name w/ database: if it matches none throw error

        Label pass_Lab = new Label("Password:");
        pass_Lab.setStyle("-fx-font: 20 arial;");
        StackPane.setAlignment(title, Pos.TOP_CENTER);
        pass_Lab.setTranslateX(-115);
        pass_Lab.setTranslateY(-45);
        login_Pane.getChildren().add(pass_Lab);

        login_Pass = new PasswordField();
        login_Pass.setPromptText("your password");
        login_Pass.setMaxWidth(200);
        StackPane.setAlignment(title, Pos.TOP_CENTER);
        login_Pass.setTranslateX(45);
        login_Pass.setTranslateY(-45);
        login_Pane.getChildren().add(login_Pass);

        // Check password w/ encryption: if it doesn't match username throw error

        LI_enter_Bt1 = new Button("Enter");
        StackPane.setAlignment(LI_enter_Bt1, Pos.CENTER);
        LI_enter_Bt1.setTranslateX(50);
        LI_enter_Bt1.setStyle("-fx-font-size: 15 arial;"
        		+ "-fx-background-color: #1dbfdb; "
        		+ "-fx-text-fill: white;"
        		+ "-fx-background-radius: 25px; ");
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
        StackPane.setAlignment(create_Bt, Pos.CENTER);
        create_Bt.setTranslateX(-60);
        create_Bt.setStyle("-fx-font-size: 15 arial; "
        		+ "-fx-background-color: #1dbfdb; "
        		+ "-fx-text-fill: white;"
        		+ "-fx-background-radius: 25px;");

        create_Bt.setOnAction(e ->{
            try {
                login.getData();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            paneController.enterAccountMenu();
        });

        recover_Bt = new Button( "forgot your information?");
        StackPane.setAlignment(recover_Bt, Pos.BOTTOM_CENTER);
        recover_Bt.setTranslateY(-30);
        recover_Bt.setStyle("-fx-font-size: 15 arial; ");
        recover_Bt.setOnAction(e -> {paneController.enterRecoverMenu();});


        login_Pane.getChildren().addAll(create_Bt, LI_enter_Bt1,recover_Bt);
        return login_Pane;
    }



}