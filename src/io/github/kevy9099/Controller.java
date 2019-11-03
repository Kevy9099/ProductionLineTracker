package io.github.kevy9099;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

// Controller runs the JavaFx.
public class Controller {
  @FXML public Button addProductButton;
  @FXML public Button recordProductButton;
  @FXML private ChoiceBox<String> chbItemType;
  @FXML private ComboBox<Integer> cbQuantity;
  @FXML private TextField txtName;
  @FXML private TextField txtMan;
  @FXML private TableView<Product> tbvProduction;
  @FXML private TableColumn<?, ?> tbcName;
  @FXML private TableColumn<?, ?> tbcMan;
  @FXML private TableColumn<?, ?> tbcType;
  @FXML private ListView<Product> lvtChooseProd;

  // fx:id reference for CSS file.
  @FXML private TabPane tabPane;
  @FXML private GridPane grid1;
  @FXML private Tab tab1;
  @FXML private Tab tab2;
  @FXML private Tab tab3;
  @FXML private Label lblExistProd;
  @FXML private AnchorPane ancRecordPane;
  @FXML private TextArea txtProdLog;

  // Global Variable Connection.
  private Connection conn;

  // Global ObservableList.
  final ObservableList<Product> productLine = FXCollections.observableArrayList();

  @FXML
  protected void handleRecordButtonAction(ActionEvent event) {
    System.out.println("Record Not Available...");
  }

  /**
   * Accepts user inputs from text fields and choice box: name, manufacturer and type. Stores the
   * inputs in the database. Displays the inputs in the TableView and ListView.
   *
   * @param event when the Add button is pressed, and input stores to db.
   * @throws SQLException throws an error message for wrong input.
   */
  @FXML
  public void handleAddButtonAction(ActionEvent event) throws SQLException {
    // Creates variables to hold textfield inputs of name, manufacturer, and type.
    String prodName = txtName.getText();
    String prodMan = txtMan.getText();
    String chosenItem = chbItemType.getValue();

    // Accepts input from name, manufacturer, and type. uses place holders as values.
    String query = "INSERT INTO PRODUCT (NAME, MANUFACTURER, TYPE) VALUES(?,?,?)";

    // PreparedStatement is created and secure.
    PreparedStatement pstmt = conn.prepareStatement(query);

    // PreparedStatement check and set strings of name, manufacturer, and type.
    pstmt.setString(1, prodName);
    pstmt.setString(2, prodMan);
    pstmt.setString(3, chosenItem);
    pstmt.executeUpdate();

    System.out.println("Inserted records into the table...");

    // Clears the text field of name and manufacturer.
    txtName.clear();
    txtMan.clear();

    // table columns are used to set name, manufacturer, and type in the tableView.
    // sets the items to productLine(observableList).
    // adds an object of widgets that holds the fields of product.
    tbcName.setCellValueFactory(new PropertyValueFactory("name"));
    tbcMan.setCellValueFactory(new PropertyValueFactory("manufacturer"));
    tbcType.setCellValueFactory(new PropertyValueFactory("type"));

    tbvProduction.setItems(productLine);

    productLine.add(new Widget(prodName, prodMan, ItemType.valueOf((chosenItem))));

    lvtChooseProd.setItems(productLine);
  }

  /**
   * Initialize( ) is executed after the InitializrDB(DB connection) with in the controller.
   * Populates the ComboBox, by an ObservableList that holds a list of integers. Populates the
   * ChoiceBox, by an ObservableList that holds a list of String Types. This choiceBox is then loop
   * though 4 different types.
   */
  public void initialize() {
    initializeDB();

    ProductionRecord record = new ProductionRecord(0);
    String product = record.toString();
    txtProdLog.setText(product);

    // Populate the comboBox with an array of ints.
    ObservableList<Integer> list = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    cbQuantity.setItems(list);
    cbQuantity.getSelectionModel().selectFirst();
    cbQuantity.setEditable(true);

    // populate choiceBox with an array of values from class items. using an enhance for loop.
    ObservableList<String> choiceList = FXCollections.observableArrayList();
    for (ItemType it : ItemType.values()) {
      System.out.println(it + " " + it.values);
      choiceList.add(String.valueOf(it));
    }
    chbItemType.getItems().addAll(choiceList);

    // Audio Player tester.
    AudioPlayer newAudioProduct =
        new AudioPlayer(
            "DP-X1A", "Onkyo", "DSD/FLAC/ALAC/WAV/AIFF/MQA/Ogg-Vorbis/MP3/AAC", "M3U/PLS/WPL");
    Screen newScreen = new Screen("720x480", 40, 22);
    MoviePlayer newMovieProduct =
        new MoviePlayer("DBPOWER MK101", "OracleProduction", newScreen, MonitorType.LCD);
    ArrayList<MultimediaControl> productList = new ArrayList<>();
    productList.add(newAudioProduct);
    productList.add(newMovieProduct);
    for (MultimediaControl p : productList) {
      System.out.println(p);
      p.play();
      p.stop();
      p.next();
      p.previous();
    }
  }

  private void initializeDB() {
    // Connection establish.
    final String jdbcDriver = "org.h2.Driver";
    final String dbUrl = "jdbc:h2:./Lib/ProductDB";

    final String user = "";
    final String pass = "";

    try {
      Class.forName(jdbcDriver);

      conn = DriverManager.getConnection(dbUrl, user, pass);

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }
}
