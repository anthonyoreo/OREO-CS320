package sample;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;


public class mainMenu extends Scene{


    private loginDB login = new loginDB();
    private Button start_Bt, search_Bt, help_Bt, logoff_Bt;
    Label title = new Label(" Informal Cognitive Linguistic Assessment");

    public mainMenu(Parent root, double width, double height) {
        super(root, width, height);
    }

    public Pane menu_Pane(paneController paneController){


        Pane menu_Pane = new Pane();
        menu_Pane.setStyle("-fx-background-color: white");
        title.setStyle("-fx-font: 25 arial;");
        title.setTranslateX(60);
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
        start_Bt.setOnAction(e -> {paneController.enterPatientMenu();});

        menu_Pane.getChildren().addAll(start_Bt);

        search_Bt = new Button("Search Patients ");
        search_Bt.setLayoutX(205);
        search_Bt.setLayoutY(150);
        search_Bt.setStyle("-fx-font-size: 18 arial; ");

        search_Bt.setOnAction(e -> {paneController.enterSearchMenu();});

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
        logoff_Bt.setOnAction(e -> {paneController.enterLoginMenu();});
        menu_Pane.getChildren().addAll(logoff_Bt);
        return menu_Pane;
    }
}