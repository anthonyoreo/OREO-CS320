package sample;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;


public class mainMenu extends Scene{


    private loginDB login = new loginDB();
    private Button search_Bt, help_Bt, logoff_Bt, start_Bt;
    Label title = new Label(" Informal Cognitive Linguistic Assessment");

    public mainMenu(Parent root, double width, double height) {
        super(root, width, height);
    }

    public Pane menu_Pane(paneController paneController){


        StackPane menu_Pane = new StackPane();
        menu_Pane.setStyle("-fx-background-color: white");
        title.setStyle("-fx-font: 25 arial;");
        StackPane.setAlignment(title, Pos.TOP_CENTER);
        menu_Pane.getChildren().add(title);

        Label menu_Lab = new Label("MENU");
        menu_Lab.setStyle("-fx-font: 20 arial;");
        StackPane.setAlignment(menu_Lab, Pos.TOP_CENTER);
        menu_Lab.setTranslateY(50);
        menu_Pane.getChildren().add(menu_Lab);

        start_Bt = new Button("         Start         ");
        StackPane.setAlignment(start_Bt, Pos.TOP_CENTER);
        start_Bt.setTranslateY(100);
        start_Bt.setStyle("-fx-font-size: 18 arial;"
        		+ "-fx-background-color: #1dbfdb; "
        		+ "-fx-text-fill: white;"
        		+ "-fx-background-radius: 25px;");
        
        start_Bt.setOnAction(e -> {paneController.enterExamMenu();});
        
        menu_Pane.getChildren().addAll(start_Bt);

        search_Bt = new Button("Search Patients ");
        StackPane.setAlignment(search_Bt, Pos.TOP_CENTER);
        search_Bt.setTranslateY(150);
        search_Bt.setStyle("-fx-font-size: 18 arial; "
        		+ "-fx-background-color: #1dbfdb; "
        		+ "-fx-text-fill: white;"
        		+ "-fx-background-radius: 25px;");

        search_Bt.setOnAction(e -> {paneController.enterSearchMenu();});

        menu_Pane.getChildren().addAll(search_Bt);

        help_Bt = new Button("         Help         ");
        StackPane.setAlignment(help_Bt, Pos.TOP_CENTER);
        help_Bt.setTranslateY(200);
        help_Bt.setStyle("-fx-font-size: 18 arial; "
        		+ "-fx-background-color: #1dbfdb; "
        		+ "-fx-text-fill: white;"
        		+ "-fx-background-radius: 25px;");


        menu_Pane.getChildren().addAll(help_Bt);

        logoff_Bt = new Button("       Log Off       ");
        StackPane.setAlignment(logoff_Bt, Pos.TOP_CENTER);
        logoff_Bt.setTranslateY(250);
        logoff_Bt.setStyle("-fx-font-size: 18 arial; "
        		+ "-fx-background-color: #1dbfdb; "
        		+ "-fx-text-fill: white;"
        		+ "-fx-background-radius: 25px;");
        logoff_Bt.setOnAction(e -> {paneController.enterLoginMenu();});
        menu_Pane.getChildren().addAll(logoff_Bt);
        return menu_Pane;
    }
}