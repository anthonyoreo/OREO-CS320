package sample;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;


public class recoverMenu extends Scene {

    Label title = new Label(" Informal Cognitive Linguistic Assessment");

    public recoverMenu(Parent root, double width, double height) {
        super(root, width, height);
    }

    public Pane recoverPane(paneController paneController)
    {
        Pane recoverPane = new Pane();

        recoverPane.setStyle("-fx-background-color: white");
        //Label title = new Label(" Informal Cognitive Lingistic Assessment");
        title.setStyle("-fx-font: 25 arial;");
        title.setTranslateX(70);
        recoverPane.getChildren().add(title);

        TextField recoverEmail = new TextField("enter email");
        recoverEmail.setPromptText("email");
        recoverEmail.setTranslateX(295);
        recoverEmail.setTranslateY(100);
        recoverPane.getChildren().add(recoverEmail);

        Button recoverButton = new Button("sendEmail");
        recoverButton.setTranslateX(295);
        recoverButton.setTranslateY(130);
        recoverButton.setOnAction(e ->{System.out.println(recoverEmail.getText());paneController.sendRecover(recoverEmail.getText());});
        //below code is to test input of mailsend object; errors still present;
        //NoClassDefFoundError: javax/activation/DataHandler ; java9 no support for jar; must ...
        //... install directories through maven; will implement; *same error as above code*
        //recoverButton.setOnAction( e -> {paneController.sendRecover("hello@gmail.com");});
        recoverPane.getChildren().add(recoverButton);

        Button backButton = new Button("back");
        backButton.setTranslateY(255);
        backButton.setTranslateX(130);
        backButton.setOnAction( e -> {paneController.enterLoginMenu();});
        recoverPane.getChildren().add(backButton);

        return recoverPane;
    }
}
