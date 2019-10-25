package io.github.kevy9099;

import java.sql.*;
import java.util.ArrayList;

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
  @FXML private TextField productTxt;
  @FXML private TextField productManu;

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

  private String querySQL;
  private Connection conn;
  private PreparedStatement pstmt;

  @FXML
  protected void handleRecordButtonAction(ActionEvent event) {
    System.out.println("Record Not Available...");
  }

  @FXML
  public void handleAddButtonAction(ActionEvent event) throws SQLException {
    String prodName = productTxt.getText();
    String prodManufacturer = productManu.getText();
    String chosenItem = ChoiceBox.getValue();

//    initializeDB();

    querySQL = "INSERT INTO PRODUCT (NAME, MANUFACTURER, TYPE) VALUES (?,?,?)";

    pstmt = conn.prepareStatement(querySQL);

    pstmt.setString(1, prodName);
    pstmt.setString(2, prodManufacturer);
    pstmt.setString(3, chosenItem);
    pstmt.executeUpdate();

    System.out.println("Inserted records into the table...");

    productTxt.clear();
    productManu.clear();
  }

  public void initialize() {
    initializeDB();

    ProductionRecord record = new ProductionRecord(0);
    String product = record.toString();
    txtArea1.setText(product);

    // Populate the comboBox with an array of ints.
    ObservableList<Integer> List = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    ProduceComboBox.setItems(List);
    ProduceComboBox.getSelectionModel().selectFirst();
    ProduceComboBox.setEditable(true);

    // populate choiceBox with an array of values from class items. using an enhance for loop.
    ObservableList<String> choiceList = FXCollections.observableArrayList();
    for (ItemType it : ItemType.values()) {
      System.out.println(it + " " + it.values);
      choiceList.add(String.valueOf(it));
    }
    ChoiceBox.getItems().addAll(choiceList);

//    AudioPlayer newAudioProduct = new AudioPlayer("DP-X1A", "Onkyo",
//            "DSD/FLAC/ALAC/WAV/AIFF/MQA/Ogg-Vorbis/MP3/AAC", "M3U/PLS/WPL");
//    Screen newScreen = new Screen("720x480", 40, 22);
//    MoviePlayer newMovieProduct = new MoviePlayer("DBPOWER MK101", "OracleProduction", newScreen,
//            MonitorType.LCD);
//    ArrayList<MultimediaControl> productList = new ArrayList<MultimediaControl>();
//    productList.add(newAudioProduct);
//    productList.add(newMovieProduct);
//    for (MultimediaControl p : productList) {
//      System.out.println(p);
//      p.play();
//      p.stop();
//      p.next();
//      p.previous();
//      }
  }

  private void initializeDB() {
    // Connection establish.
    final String jdbcDriver = "org.h2.Driver";
    final String dbUrl = "jdbc:h2:./Lib/ProductDB";

    final String USER = "";
    final String PASS = "";

    try {
      Class.forName(jdbcDriver);

      conn = DriverManager.getConnection(dbUrl, USER, PASS);

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }
}
