package _08_ParticleSimulator;

import _08_ParticleSimulator.Controller;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    Controller ctr;
    Group root;
    Group renderGroup;
    int offsetY = 40;

    @Override
    public void start(Stage stage) {
        // overall place
        root = new Group();
        createRenderGroup();

        ctr = new Controller(renderGroup);

        Timeline wonder = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ctr.eventTick();
            }
        }));

        wonder.setCycleCount(Timeline.INDEFINITE);
        wonder.play();

        Button b1 = new Button("Save state");
        b1.setOnAction((event)->saveStateButtonClicked());
        root.getChildren().add(1, b1);

        Button b2 = new Button("Load state");
        b2.setLayoutX(100);
        b2.setOnAction((event)->loadStateButtonClicked());
        root.getChildren().add(2, b2);

        Scene scene = new Scene(root, 200, 200 + offsetY);
        stage.setTitle("Particle Simulator");
        stage.setScene(scene);
        stage.show();
    }

    void saveStateButtonClicked() {
        ctr.saveState();
        System.out.println("save");
    }

    void loadStateButtonClicked() {
        ctr.loadState();
        System.out.println("load");
    }

    void createRenderGroup() {
        // part of window were figures will be displayed
        renderGroup = new Group();
        renderGroup.setTranslateX(0);
        renderGroup.setTranslateY(offsetY);
        root.getChildren().add(renderGroup);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
