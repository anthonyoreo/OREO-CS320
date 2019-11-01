package sample;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.*;
import javax.activation.DataHandler;


public class paneController {

    private Scene accountMenu, loginMenu, mainMenu, searchMenu, recoverMenu, examMenu;
    private Stage primaryStage;
    private AnchorPane root;

    public paneController(Stage primaryStage){
        this.primaryStage = primaryStage;
    }

    public Scene initStart(){
        clearRoot();
        loginMenu loginScene = new loginMenu(root, 800, 600);
        loginMenu = new Scene(loginScene.login_Pane(this), 800, 600);
        return loginMenu;
    }

    public void setInitialScene(){
        primaryStage.setTitle("Informal Cognitive Linguistic Assessment");
        primaryStage.setScene(initStart());
        primaryStage.show();
    }

    public void enterLoginMenu(){
        clearRoot();
        loginMenu loginScene = new loginMenu(root, 800, 600);
        loginMenu = new Scene(loginScene.login_Pane(this), 800, 600);
        primaryStage.setScene(loginMenu);

    }

    public void enterAccountMenu(){
        clearRoot();
        accountMenu accountScene = new accountMenu(root, 800, 600);
        accountMenu = new Scene(accountScene.accountPane(this), 800, 600);
        primaryStage.setScene(accountMenu);
    }

    public void enterMainMenu(){
        clearRoot();
        mainMenu mainMenuScene = new mainMenu(root, 800, 600);
        mainMenu = new Scene(mainMenuScene.menu_Pane(this), 800, 600);
        primaryStage.setScene(mainMenu);
    }

    public void enterSearchMenu(){
        clearRoot();
        searchMenu searchScene = new searchMenu(root, 800, 600);
        searchMenu = new Scene(searchScene.search_Pane(this), 800, 600);
        primaryStage.setScene(searchMenu);
    }

    public void enterRecoverMenu(){
        clearRoot();
        recoverMenu recoverScene = new recoverMenu(root, 800, 600);
        recoverMenu = new Scene(recoverScene.recoverPane(this),800,600);
        primaryStage.setScene(recoverMenu);
    }

    public void enterExamMenu(){
        clearRoot();
        examMenu examScene = new examMenu(root, 800, 600);
        examMenu = new Scene(examScene.assess_Pane(this), 800, 600);
        primaryStage.setScene(examMenu);
    }

    public void sendRecover(String who){
        //javaMail javaMail = new javaMail(who);
        try {
            javaMail.sendMail(who);
        }
        catch(Exception e)
        {
            ;
        }
    }

    public void clearRoot(){
        AnchorPane root = new mainPane();
        this.root = root;
    }

}
