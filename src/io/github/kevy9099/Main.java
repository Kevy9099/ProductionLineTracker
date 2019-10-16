package io.github.kevy9099;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Kevin Mak 09/11/2019 - TBA https://github.com/Kevy9099/ProductionLineTracker Production
 * LineTracker ~ Object-Oriented Programming ~ COP 3003 Helping Resources: Github, Stack-over-flow,
 * w3schools, jetbrains (tools, plugins, etc.) Oracle Resources, Google, Youtube, and Class Course
 * Website (COP 3003). Purpose of Project: Utilizing GUI in JavaFX and Database. A Software
 * Application for a media player production facility. This application will keep track of what
 * products are produced. The products will be Recorded and logged. Also, this application will have
 * the ability to add to the production line (e.g. Catalog of products).
 */
public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
    Scene scene = new Scene(root, 690, 630);
    root.setId("pane");
    primaryStage.setTitle("Production Line Tracker");
    primaryStage.setScene(scene);
    scene
        .getStylesheets() // Gets CSS file data.
        .add(Main.class.getResource("ProdLineTrack.css").toExternalForm()); // adds the css file.
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
