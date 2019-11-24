package io.github.kevy9099;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

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

/**
 * Controller class handles results and actions, such as: buttons, establishes database connection,
 * and enabling items to be added to database. Allows information to be pulled by a single input to
 * and from database, depending on its scope.
 *
 * @author Kevin Mak 9/24/2019
 */
public class Controller {
  // fx:Id initialize and connected to the FXML file.
  @FXML public Button btnAddProduct;
  @FXML public Button btnRecordProduct;
  @FXML private ChoiceBox<String> chbItemType;
  @FXML private ComboBox<Integer> cbQuantity;
  @FXML private TextField txtName;
  @FXML private TextField txtMan;
  @FXML private TableView<Product> tbvProduction;
  @FXML private TableColumn<?, ?> tbcName;
  @FXML private TableColumn<?, ?> tbcMan;
  @FXML private TableColumn<?, ?> tbcType;
  @FXML private ListView<Product> lvtChooseProd;

  // fx:Id initialize reference for CSS file.
  @FXML private TextArea txtProdLog;
  @FXML public TabPane tabPane;
  @FXML public Tab tab1;
  @FXML public GridPane grid1;
  @FXML public Label lblExistProd;
  @FXML public Tab tab2;
  @FXML public AnchorPane ancRecordPane;
  @FXML public Tab tab3;

  // Global Variable Connection and Statement.
  private Connection conn;
  private Statement stmt;

  // Global ObservableList.
  final ObservableList<Product> productLine = FXCollections.observableArrayList();

  /**
   * RecordButtonAction calls addToProductionDB, showProduction, LoadProductionLog. This method
   * creates an ArrayList of ProductionRecord called productionRun, that associates with productLine
   * listView items. Selecting an item will get productionLog information, display on Production Log
   * textArea, saved to the ProductionRecord database.
   *
   * @param event when the Add button is pressed, and input stores to db.
   */
  @FXML
  protected void handleRecordButtonAction(ActionEvent event) throws SQLException {
    // ArrayList Of ProductionRecord.
    ArrayList<ProductionRecord> productionRun = new ArrayList<>();

    // dbRecord selects an item from the listView.
    Product dbRecord = lvtChooseProd.getSelectionModel().getSelectedItem();

    // quantity selects a listView item and correspond it with a integer from the comboBox.
    // cast the cbQuantity an amount of times, depending on the number chosen.
    int quantity =
        Integer.parseInt(String.valueOf(cbQuantity.getSelectionModel().getSelectedItem()));

    // ProductionRecord variable.
    ProductionRecord pr;

    // loop through the amount of quantity.
    for (int i = 1; i < quantity; i++) {
      pr = new ProductionRecord(dbRecord, i);
      productionRun.add(pr);
    }

    // calls addToProductionDB and adds productionRun.
    addToProductionDB(productionRun);

    // calls showProduction and adds productionRun.
    showProduction(productionRun);

    // calls loadProductionLog and adds productionRun.
    loadProductionLog(productionRun);
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

    // Testing for insertion of products.
    System.out.println("Inserted records into the table...");

    // Clears the text field of name and manufacturer.
    txtName.clear();
    txtMan.clear();

    //  Adds Items of Product to TableView and ListView.
    setupProductLineTable(productLine);

    // Adds the current data in to the TableView and ListView.
    loadProductionList(productLine);
  }

  /**
   * Table columns are used to set name, manufacturer, and type in the tableView. Display Products
   * in TableView and ListView when add button is clicked.
   *
   * @param productLine An observableList of a product.
   */
  private void setupProductLineTable(ObservableList<Product> productLine) {

    // Table columns are set to product textFields inputs.
    tbcName.setCellValueFactory(new PropertyValueFactory<>("name"));
    tbcMan.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
    tbcType.setCellValueFactory(new PropertyValueFactory<>("type"));

    // Displays the Products from ProductLine in TableView.
    tbvProduction.setItems(this.productLine);

    // Displays the Products from ProductLine in ListView.
    lvtChooseProd.setItems(this.productLine);
  }

  /**
   * A function that that creates Product objects from the Product database table and adds them to
   * the productLine ObservableList.
   *
   * @param productLine An observable list that hold product objects.
   */
  private void loadProductionList(ObservableList<Product> productLine) throws SQLException {
    // Select all from product table.
    String sql = "SELECT * FROM PRODUCT";
    stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(sql);

    // gets items from product table.
    while (rs.next()) {
      String name = rs.getString(2);
      String manufacturer = rs.getString(3);
      String type = rs.getString(4);

      // Product object called dbProduct, holds name, manufacturer and type.
      Product dbProduct = new Product(name, manufacturer, ItemType.valueOf((type))) {};

      // adds the dbProduct to the productLine.
      productLine.add(dbProduct);
    }
  }

  /**
   * A function that adds information to ProductionRecord table (ProductionNumber, ProductionID,
   * SerialNumber, and Date).
   *
   * @param productionRun An arrayList of productionRun.
   */
  private void addToProductionDB(ArrayList<ProductionRecord> productionRun) {
    // Creates a new timeStamp and date for objects created in the listView.
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    Date date = new Date();
    System.out.println(new Timestamp(date.getTime()));
    System.out.println(timestamp.getTime());
  }

  /**
   * A function that sets the productionRun arrayList objects to the textArea of production Log.
   * Displays the Information from the productionLog, replacing the productId with the productName.
   *
   * @param productionRun An arrayList of productionRun.
   */
  private void showProduction(ArrayList<ProductionRecord> productionRun) {
    txtProdLog.setText(productionRun.toString());
  }

  /**
   * A function that select all from productionRecord ( productionNumber, productionId, serial and
   * date). Display for the textArea. populates he productionLog ArrayList.
   *
   * @param productionRun An arrayList of productionRun.
   */
  private void loadProductionLog(ArrayList<ProductionRecord> productionRun) throws SQLException {
    String sql = "SELECT * FROM PRODUCTIONRECORD";
    stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(sql);
    while (rs.next()) {
      int number = rs.getInt(2);
      int id = rs.getInt(3);
      String serial = rs.getString(4);
      Date date = rs.getDate(5);

      ProductionRecord dbRecord = new ProductionRecord(number, id, serial, date) {};

      productionRun.add(dbRecord);
    }
  }

  /**
   * initialize method is the first method to run, it sets values in the combo box, starts the
   * connection to the database, and gathers information from the database and stores it into a
   * list. Database information is pass to an observable list. This list sets the values to text
   * area, table view, and list view.
   */
  public void initialize() throws IOException {
    // connects and run database once for the application.
    initializeDB();

    // Display an object of ProductionRecord in Text Area
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
      choiceList.add(String.valueOf(it));
    }
    chbItemType.getItems().addAll(choiceList);
  }

  /**
   * initializeDB method is called once in initialize method. DB establishes a connection, user and
   * pass.
   */
  private void initializeDB() throws IOException {
    // Connection establish.
    final String jdbcDriver = "org.h2.Driver";
    final String dbUrl = "jdbc:h2:./Lib/ProductDB";

    // Initialize a User and Pass.
    final String user = "";
    final String pass;

    // Properties gets and set the password from file.
    Properties prop = new Properties();
    prop.load(new FileInputStream("Lib/Properties"));
    pass = prop.getProperty("password");

    try {
      Class.forName(jdbcDriver);

      conn = DriverManager.getConnection(dbUrl, user, pass);

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }
}
