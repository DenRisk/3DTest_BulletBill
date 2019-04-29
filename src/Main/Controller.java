package Main;

import Physics.MoveEngine;
import Sprite.Sphere;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Pane panetl;

    @FXML
    private Pane panetr;

    @FXML
    private Pane panebl;

    AnimationTimer animationTimerXY;
    private boolean living = true;
    Sphere xySphere;
    Sphere xzSphere;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        xySphere = new Sphere(200, 50,0, 20, Color.BLACK, 0, 0, 0, 1);
        panetr.getChildren().add(xySphere);

        xzSphere = new Sphere(200,0,50,20, Color.BLACK, 0,0,0,2);
        panetl.getChildren().add(xzSphere);

        animationTimerXY = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (living == true) {
                    xySphere.setCenterX(xySphere.getX0());
                    xySphere.setCenterY(xySphere.getY0());

                    xzSphere.setCenterX(xzSphere.getX0());
                    xzSphere.setCenterY(xzSphere.getZ0());

                    new MoveEngine(now, xySphere, xzSphere);

                }
            }
        };
        animationTimerXY.start();

    }
}
