package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private LogicLayer ll;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("ui.fxml"));
        primaryStage.setTitle("StorJ UI");
        primaryStage.setScene(new Scene(root, 460, 350));
        primaryStage.show();


        ll = new LogicLayer();
        ll.Test();

        // try to get connection to storJ (is server online?)

        //get login shit from form. tty to sign in.

        //if (login.succesfull) show 2e form.

        //else show error message.

    }


    public static void main(String[] args) {
        launch(args);
    }
}
