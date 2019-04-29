package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static final double GRAVITY = 1200;
    public static final double DRAG = 0.2;
    public static final double BOUNCE = 0.6;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("gameScreen.fxml"));
        primaryStage.setTitle("Game");
        primaryStage.setScene(new Scene(root, 800, 700));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
