package io.github.kevy9099;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Production LineTracker ~ Object-Oriented Programming COP 3003 ~ Helping Resources: Github,
 * Stack-over-flow, w3schools, Oracle Resources and Class Course Website. Purpose of Project:
 * Utilizing GUI in JavaFX and Database. A Software application for a media player production
 * facility. This application will keep track of what products are produced. The products will be
 * recorded and logged. Also, this application will have the ability to add to the production line.
 *
 * @author Kevin Mak 09/21/2019
 * @github https://github.com/Kevy9099/ProductionLineTracker
 */
public class Main extends Application {

  /**
   * JavaFX application starts with in Main. Start method initialize the primary window for the
   * application, and Stylesheet is initialize once for the the whole project.
   *
   * @param primaryStage parent scene for the application.
   * @throws Exception error for wrong file inputs.
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    // parent root, parent scene, and primaryStage.
    Parent root = FXMLLoader.load(getClass().getResource("Production.fxml"));
    Scene scene = new Scene(root);
    root.setId("pane");
    primaryStage.setTitle("Production Line Tracker");
    primaryStage.setScene(scene);
    scene
        .getStylesheets() // StyleSheet is called once (css file).
        .add(Main.class.getResource("ProdLineTrack.css").toExternalForm()); // adds the css file.
    primaryStage.show();
  }

  /**
   * Main Launch for Application.
   *
   * @param args Array of Strings.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
