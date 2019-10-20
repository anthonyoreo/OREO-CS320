import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Formatter;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.geometry.Pos;
import javafx.scene.text.Text;
import javafx.scene.control.ChoiceBox;

public class gui extends Application {
    private TextField login_user, create_login_user;
    private PasswordField login_Pass, create_login_Pass, conlogin_Pass;
    private Label loginError, userError, passError;
    private login login = new login();
    private Pane create_Pane;
    public StackPane assess_Pane;
    private Button LI_enter_Bt1, create_enter_Bt, create_back_Bt, create_Bt, 
                    search_Bt, help_Bt, logoff_Bt, search_back_Bt, next_Bt,
                    last_Bt, return_Bt, start_Bt, backToMenu_Bt;
    private Scene login_Scene, create_Scene, menu_Scene, search_Scene, assess_Scene;
    //public Scene login_Scene, create_Scene, menu_Scene, search_Scene;
    public Button back_Bt1;
    public Node enter_Bt2;
    public Node logoff_Bt1;
    private Button enter_Bt3;
    public int loginCheck = 0;
    public static int end = 0;
    public int questionNumber;
    public questions questions = new questions();
    public Text text;
    public ChoiceBox tenChoice, fourChoice;

    Label title = new Label(" Informal Cognitive Linguistic Assessment");

    public void setupLogin() {
        Pane login_Pane = new Pane();
        login_Pane.setStyle("-fx-background-color: white");
        title.setStyle("-fx-font: 25 arial;");
        title.setTranslateX(70);
        //highS.setTranslateY(100);
        //StackPane secondaryLayout = new StackPane();
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
        create_Pane.getChildren().add(userError);
        userError.setVisible(false);

        passError = new Label("Passwords do not match");
        passError.setStyle("-fx-font: 10 arial");
        passError.setTranslateX(250);
        passError.setTranslateY(75);
        create_Pane.getChildren().add(passError);
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

        // Check password w/ encription: if it doesn't match username throw error

        LI_enter_Bt1 = new Button("Enter");
        LI_enter_Bt1.setLayoutX(325);
        LI_enter_Bt1.setLayoutY(200);
        LI_enter_Bt1.setStyle("-fx-font-size: 15 arial; ");
        loginCheck = 1;
        LI_enter_Bt1.setDefaultButton(true);

        create_Bt = new Button("Create Account");
        create_Bt.setLayoutX(175);
        create_Bt.setLayoutY(200);
        create_Bt.setStyle("-fx-font-size: 15 arial; ");


        login_Pane.getChildren().addAll(create_Bt, LI_enter_Bt1);
        login_Scene = new Scene(login_Pane, 600, 400);

    }

    public void setupCreate() {
        create_Pane = new Pane();
        create_Pane.setStyle("-fx-background-color: white");
        title.setStyle("-fx-font: 25 arial;");
        title.setTranslateX(70);
        //highS.setTranslateY(100);
        //StackPane secondaryLayout = new StackPane();
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

        create_back_Bt = new Button("   Back   ");
        create_back_Bt.setLayoutX(175);
        create_back_Bt.setLayoutY(300);
        create_back_Bt.setStyle("-fx-font-size: 15 arial; ");

        create_Pane.getChildren().addAll(create_enter_Bt, create_back_Bt);
        create_Scene = new Scene(create_Pane, 600, 400);

    }

    public void setupMenu() {
        Pane menu_Pane = new Pane();
        menu_Pane.setStyle("-fx-background-color: white");
        title.setStyle("-fx-font: 25 arial;");
        title.setTranslateX(60);
        //highS.setTranslateY(100);
        //StackPane secondaryLayout = new StackPane();
        menu_Pane.getChildren().add(title);

        Label menu_Lab = new Label("MENU");
        menu_Lab.setStyle("-fx-font: 20 arial;");
        menu_Lab.setTranslateX(250);
        menu_Lab.setTranslateY(50);
        menu_Pane.getChildren().add(menu_Lab);

        start_Bt = new Button("         Start         ");
        start_Bt.setLayoutX(205);
        start_Bt.setLayoutY(100);
        start_Bt.setStyle("-fx-font-size: 18 arial; ");

        menu_Pane.getChildren().addAll(start_Bt);

        search_Bt = new Button("Search Patients ");
        search_Bt.setLayoutX(205);
        search_Bt.setLayoutY(150);
        search_Bt.setStyle("-fx-font-size: 18 arial; ");

        menu_Pane.getChildren().addAll(search_Bt);

        help_Bt = new Button("         Help         ");
        help_Bt.setLayoutX(205);
        help_Bt.setLayoutY(200);
        help_Bt.setStyle("-fx-font-size: 18 arial; ");


        menu_Pane.getChildren().addAll(help_Bt);

        logoff_Bt = new Button("       Log Off       ");
        logoff_Bt.setLayoutX(205);
        logoff_Bt.setLayoutY(250);
        logoff_Bt.setStyle("-fx-font-size: 18 arial; ");

        menu_Pane.getChildren().addAll(logoff_Bt);
        menu_Scene = new Scene(menu_Pane, 600, 400);
    }

    public void setupSearch() {
        Pane search_Pane = new Pane();
        search_Pane.setStyle("-fx-background-color: white");
        //Label title = new Label(" Informal Cognitive Lingistic Assessment");
        title.setStyle("-fx-font: 25 arial;");
        title.setTranslateX(70);
        //highS.setTranslateY(100);
        //StackPane secondaryLayout = new StackPane();
        search_Pane.getChildren().add(title);

        Label search_Lab = new Label("Search Patients");
        search_Lab.setStyle("-fx-font: 20 arial;");
        search_Lab.setTranslateX(225);
        search_Lab.setTranslateY(50);
        search_Pane.getChildren().add(search_Lab);

        Label search_user_Lab = new Label("Enter Patient Name:");
        search_user_Lab.setStyle("-fx-font: 20 arial;");
        search_user_Lab.setTranslateX(100);
        search_user_Lab.setTranslateY(105);
        search_Pane.getChildren().add(search_user_Lab);

        TextField search_login_user = new TextField();
        search_login_user.setPromptText("Name");
        search_login_user.setTranslateX(295);
        search_login_user.setTranslateY(100);
        search_Pane.getChildren().add(search_login_user);

        enter_Bt3 = new Button("Enter");
        enter_Bt3.setLayoutX(325);
        enter_Bt3.setLayoutY(200);
        enter_Bt3.setStyle("-fx-font-size: 15 arial; ");

        search_Pane.getChildren().addAll(enter_Bt3);

        search_back_Bt = new Button("Back");
        search_back_Bt.setLayoutX(175);
        search_back_Bt.setLayoutY(200);
        search_back_Bt.setStyle("-fx-font-size: 15 arial; ");

        search_Pane.getChildren().addAll(search_back_Bt);
        search_Scene = new Scene(search_Pane, 600, 400);
    }

    public void setupAssess() {
        assess_Pane = new StackPane();
        assess_Pane.setStyle("-fx-background-color: white");        

        tenChoice = new ChoiceBox();
        tenChoice.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        StackPane.setAlignment(tenChoice, Pos.CENTER);
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

        assess_Pane.getChildren().addAll(next_Bt, last_Bt, backToMenu_Bt, text);

        assess_Scene = new Scene(assess_Pane, 600, 400);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        questionNumber = 0;
        // Setup each scene of the menus
        setupCreate();
        setupMenu();
        setupSearch();
        setupLogin();
        setupAssess();
        // Establish function of each button
        create_Bt.setOnAction(e ->{
            try {
                login.getData();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            primaryStage.setScene(create_Scene);
            primaryStage.show();
        });

        if(loginCheck == 1) {
            LI_enter_Bt1.setOnAction(e ->{
                try {
                    login.getData();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                if (login.checkCreds(login_user.getText(), login_Pass.getText())) {
                    primaryStage.setScene(menu_Scene);
                    primaryStage.show();
                } else {
                    login_Pass.clear();
                    loginError.setVisible(true);
                }
            });
        }

        create_enter_Bt.setOnAction(e ->{
            //adds info to system and brings to main menu
            if (login.checkKey(create_login_user.getText())) {
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
                    primaryStage.setScene(menu_Scene);
                    primaryStage.show();
                } else {
                    conlogin_Pass.clear();
                    passError.setVisible(true);
                }
            }

        });

        create_back_Bt.setOnAction(e ->{
            primaryStage.setScene(login_Scene);
            primaryStage.show();
        });

        start_Bt.setOnAction(e ->{
            primaryStage.setScene(assess_Scene);
            primaryStage.show();
    	});

        search_Bt.setOnAction(e ->{
            primaryStage.setScene(search_Scene);
            primaryStage.show();
        });
        //help_Bt.setOnAction(e ->{

        //primaryStage.setScene(help_Scene);
        //primaryStage.show();
        //});
        search_back_Bt.setOnAction(e ->{

            primaryStage.setScene(menu_Scene);
            primaryStage.show();
        });

        logoff_Bt.setOnAction(e ->{
           // login_Pass.hide();
            primaryStage.setScene(login_Scene);
            primaryStage.show();
        });

        next_Bt.setOnAction(e ->{

            text.setText(questions.getQuestion(++questionNumber));

            if (questionNumber == 1) {
                assess_Pane.getChildren().add(fourChoice);
            } else if (questionNumber == 18) {
                assess_Pane.getChildren().remove(fourChoice);
                assess_Pane.getChildren().add(tenChoice);
            }

        });

        last_Bt.setOnAction(e ->{

            if (questionNumber > 0) {
                text.setText(questions.getQuestion(--questionNumber));
            }

            if (questionNumber < 18 && questionNumber > 0) {
                assess_Pane.getChildren().add(fourChoice);
            } else if (questionNumber > 18) {
                assess_Pane.getChildren().remove(fourChoice);
                assess_Pane.getChildren().add(tenChoice);
            }
        });


        primaryStage.setScene(login_Scene);
        primaryStage.setTitle("Informal Cognitive Linguistic Assessment");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
