package sample;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;


public class searchMenu extends Scene{


    private loginDB login = new loginDB();
    private Button search_back_Bt;
    private Button enter_Bt3;
    Label title = new Label(" Informal Cognitive Linguistic Assessment");


    public searchMenu(Parent root, double width, double height) {
        super(root, width, height);
    }

    public Pane search_Pane(paneController paneController)
    {
        Pane search_Pane = new Pane();
        search_Pane.setStyle("-fx-background-color: white");
        title.setStyle("-fx-font: 25 arial;");
        title.setTranslateX(70);
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

        search_back_Bt.setOnAction(e -> {paneController.enterMainMenu();});

        search_Pane.getChildren().addAll(search_back_Bt);
        return search_Pane;
    }

    ;
}