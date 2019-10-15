package sample;

import java.sql.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * Kevin Mak 09/11/2019 - TBA https://github.com/Kevy9099/ProductionLineTracker Production
 * LineTracker ~ Object-Oriented Programming ~ COP 3003 Helping Resources: Github, Stack-over-flow,
 * w3schools, jetbrains (tools, plugins, etc.) Oracle Resources, Google, Youtube, and Class Course
 * Website (COP 3003). Purpose of Project: Utilizing GUI in JavaFX and Database. A Software
 * Application for a media player production facility. This application will keep track of what
 * products are produced. The products will be Recorded and logged. Also, this application will have
 * the ability to add to the production line (e.g. Catalog of products).
 */

// Controller runs the JavaFx.
public class Controller {
  @FXML public Button AddProductButton;
  @FXML public Button RecordProductButton;
  @FXML private ComboBox<Integer> ProduceComboBox;
  @FXML private ChoiceBox<String> ChoiceBox;

  // fx:id reference for ProdLineTrack.css file
  @FXML private TabPane tabPane;
  @FXML private GridPane grid1;
  @FXML private Tab tab1;
  @FXML private Tab tab2;
  @FXML private Tab tab3;
  @FXML private Label label1;
  @FXML private AnchorPane ancRecordPane;
  @FXML private TextArea txtArea1;
  @FXML private TableView tableView;

  @FXML
  protected void handleAddButtonAction(ActionEvent event) {
    System.out.println("Product has been added!");
  }

  @FXML
  protected void handleRecordButtonAction(ActionEvent event) {
    System.out.println("Record Not Available...");
  }

  public void initialize() {
    // Connection establish.
    final String jdbcDriver = "org.h2.Driver";
    final String dbUrl = "jdbc:h2:./Lib/H2";

    final String USER = "";
    final String PASS = "";
    Connection conn;
    Statement stmt;

    try {
      Class.forName(jdbcDriver);

      conn = DriverManager.getConnection(dbUrl, USER, PASS);

      stmt = conn.createStatement();

      //      String sql = "INSERT INTO Product(type,manufacturer, name) VALUES (protoType.getType()
      // + 'iPod', 'Audio', 'Apple')";

      String sql = "INSERT INTO PRODUCT (NAME, TYPE, MANUFACTURER) VALUES ('iPod', 'Audio', 'Apple')";

      stmt.executeUpdate(sql);

      System.out.println("Inserted records into the table...");

      stmt.close();
      conn.close();

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    // Populate the comboBox with an array of ints.
    ObservableList<Integer> List = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    ProduceComboBox.setItems(List);
    ProduceComboBox.getSelectionModel().selectFirst();
    ProduceComboBox.setEditable(true);

    // for(int i = 0; i <= 10; i++){ // ProduceComboBox.getItems().add(i); // }
    // A for loop for producing the added items. (This works, but I like the ObservableList).

    // populate choiceBox with an array of values from class items. using an enhance for loop.
    ObservableList<String> choiceList = FXCollections.observableArrayList();
    for (ItemType it : ItemType.values()) {
      System.out.println(it + " " + it.values);
      choiceList.add(String.valueOf(it));
    }
    ChoiceBox.getItems().addAll(choiceList);
  }
}
