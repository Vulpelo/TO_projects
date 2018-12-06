package _02_FigureDrawer;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {
    Controller ctr;
    Group root;
    Group renderGroup;

    @Override
    public void start(Stage stage) {
        // overall place
        root = new Group();
        createRenderGroup();

        ctr = new Controller(renderGroup);

        Button b1 = new Button("Load and draw");
        b1.setOnAction((event)->drawButtonClicked());
        root.getChildren().add(b1);

        Scene scene = new Scene(root, 600, 300);
        stage.setTitle("Load and Draw");
        stage.setScene(scene);
        stage.show();
    }

    void createRenderGroup() {
        // part of window were figures will be displayed
        renderGroup = new Group();
        renderGroup.setTranslateX(0);
        renderGroup.setTranslateY(40);
        root.getChildren().add(renderGroup);
    }

    void drawButtonClicked(){
        ctr.buttonClicked();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
