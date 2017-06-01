package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private LogicLayer ll;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("ui.fxml"));
        primaryStage.setTitle("StorJ UI");
        primaryStage.setScene(new Scene(root, 460, 350));
        primaryStage.show();

        ll = new LogicLayer();


        System.out.println(ll.checkStorJInstalled());
        System.out.println(ll.checkConnectionStorJ());


        // try to get connection to storJ (is server online?)

        //get login shit from form. tty to sign in.

        //if (login.succesfull) show 2e form.

        //else show error message.

        }
}
