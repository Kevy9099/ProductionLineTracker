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
import java.util.Scanner;

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
import javafx.scene.image.ImageView;
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
  // Fx:Id initialize and connected to the FXML file.
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

  // Fx:Id initialize reference for CSS file.
  @FXML private TextArea txtProdLog;
  @FXML public TextArea txtEmpLog;
  @FXML public ImageView imgProductLine;
  @FXML public ImageView imgProductLog;
  @FXML public ImageView imgProductRecord;
  @FXML public ImageView imgEmpLog;
  @FXML public Tab tabEmpLog;
  @FXML public Tab tab1;
  @FXML public Tab tab2;
  @FXML public Tab tab3;
  @FXML public TabPane tabPane;
  @FXML public GridPane grid1;
  @FXML public Label lblExistProd;
  @FXML public AnchorPane ancRecordPane;

  // Global Variable Connection and Statement.
  private Connection conn;
  private Statement stmt;

  // Global ObservableList.
  final ObservableList<Product> productLine = FXCollections.observableArrayList();

  // ArrayList Of ProductionRecord.
  final ArrayList<ProductionRecord> productionRun = new ArrayList<>();

  /**
   * RecordButtonAction calls addToProductionDB, showProduction, LoadProductionLog. This method
   * creates an ArrayList of ProductionRecord called productionRun, that associates with productLine
   * listView items. Selecting an item will get productionLog information, display on Production Log
   * textArea, saved to the ProductionRecord database.
   *
   * @param event when the Add button is pressed, and input stores to db.
   */
  @FXML
  public void handleRecordButtonAction(ActionEvent event) throws SQLException {
    // Selects a dbRecord item from the listView.
    Product record = lvtChooseProd.getSelectionModel().getSelectedItem();

    // Quantity selects a listView item and correspond it with a integer from the comboBox.
    // Cast the cbQuantity an amount of times, depending on the number chosen.
    int quantity;
    quantity = Integer.parseInt(String.valueOf(cbQuantity.getSelectionModel().getSelectedItem()));

    // ProductionRecord variable.
    ProductionRecord pr;

    // Loop through the amount of quantity.
    for (int i = 0; i < quantity; i++) {
      pr = new ProductionRecord(record, i);
      productionRun.add(pr);

      // Testing for Pr.
      System.out.println("Added pr");
    }

    // Adds data into productionRecord.
    addToProductionDB(productionRun);

    // Displays productionRun to txtProdLog.
    showProduction(productionRun);

    // Get data from the productionRecord.
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
    loadProductList(productLine);
  }

  /**
   * Table columns are used to set name, manufacturer, and type in the tableView. Display Products
   * in TableView and ListView when add button is clicked.
   *
   * @param productLine An observableList of a product.
   */
  private void setupProductLineTable(ObservableList<Product> productLine) {

    // Table columns are set to product textFields inputs.
    tbcName.setCellValueFactory(new PropertyValueFactory("name"));
    tbcMan.setCellValueFactory(new PropertyValueFactory("manufacturer"));
    tbcType.setCellValueFactory(new PropertyValueFactory("type"));

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
  private void loadProductList(ObservableList<Product> productLine) throws SQLException {
    // Select all from product table.
    String sql = "SELECT * FROM PRODUCT";
    stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(sql);

    // Gets items from product table.
    while (rs.next()) {
      String name = rs.getString(2);
      String manufacturer = rs.getString(3);
      String type = rs.getString(4);

      // Product object called dbProduct, holds name, manufacturer and type.
      Product dbProduct = new Product(name, manufacturer, ItemType.valueOf((type))) {};

      // Adds the dbProduct to the productLine.
      productLine.add(dbProduct);
    }
  }

  /**
   * A function that adds information to ProductionRecord table (ProductionNumber, ProductionID,
   * SerialNumber, and Date).
   *
   * @param productionRun An arrayList of productionRun.
   */
  private void addToProductionDB(ArrayList<ProductionRecord> productionRun) throws SQLException {
    // For each productionRecord(pr) object, then productionRun adds.
    for (ProductionRecord pr : productionRun) {

      // Fields for productionId, serialNUmber, and date.
      int prodID = pr.getProductID();
      String serialNum = pr.getSerialNumber();
      Timestamp timestamp = new Timestamp(System.currentTimeMillis());

      // Insert into ProductionRecord, with placeholders as values.
      String sql =
          "INSERT INTO PRODUCTIONRECORD(PRODUCT_ID, SERIAL_NUM,DATE_PRODUCED)VALUES (?,?,?)";
      PreparedStatement pstmt = conn.prepareStatement(sql);

      // Get items from productId, serialNumber, and a date as timeStamp.
      pstmt.setInt(1, prodID);
      pstmt.setString(2, serialNum);
      pstmt.setTimestamp(3, timestamp);

      // Execute preparedStatement into database.
      pstmt.executeUpdate();

      // Text inserted records.
      System.out.println("Inserted records into the table...");

      // Displays productionRun to txtProdLog.
      showProduction(productionRun);
    }
  }

  /**
   * A function that sets the productionRun arrayList objects to the textArea of production Log.
   * Displays the Information from the productionLog, replacing the productId with the productName.
   *
   * @param productionRun An arrayList of productionRun.
   */
  private void showProduction(ArrayList<ProductionRecord> productionRun) {
    // Sets text from productionRun array list to txtArea(txtProdLog).
    txtProdLog.setText(productionRun.toString());
  }

  /**
   * A function that select all from productionRecord ( productionNumber, productionId, serial and
   * date). Display for the textArea. populates the productionLog ArrayList.
   *
   * @param productionRun An arrayList of productionRun.
   */
  private void loadProductionLog(ArrayList<ProductionRecord> productionRun) throws SQLException {
    // Select all values from productionRecord.
    String sql = "SELECT * FROM PRODUCTIONRECORD";
    stmt = conn.createStatement();

    // Execute statement into database.
    ResultSet rs = stmt.executeQuery(sql);
    while (rs.next()) {
      int number = rs.getInt("Production_Num");
      int id = rs.getInt("Product_ID");
      String serial = rs.getString("Serial_Num");
      Date date = rs.getDate("Date_Produced");

      // New object of productionRecord that calls the constructor with number,id,serial, and date.
      ProductionRecord dbRecord = new ProductionRecord(number, id, serial, date) {};

      // Testing output for dbRecord
      System.out.println(dbRecord.toString());

      // ProductionRun adds to dbRecord.
      productionRun.add(dbRecord);

      // ShowProduction adds to productionRun.
      showProduction(productionRun);
    }
  }

  /**
   * Allows input in the console, checks employee name and validates employee password. Prints
   * Employee Details to the console and to txtArea of Employee tab.
   */
  private void employeeDetails() {
    // Scanner for user input.
    Scanner scan = new Scanner(System.in);

    // Prompt user to enter first and last name.
    System.out.println("Enter Employee Name (first last)");
    String name = scan.nextLine();

    // Prompt user to enter password.
    System.out.println("Enter Employee password");
    String password = scan.nextLine();

    // New employee object that passes name and password.
    EmployeeInfo employee = new EmployeeInfo(name, password);
    System.out.println(employee.reverseString(password));
    System.out.println(employee);

    // Prints employee information to textArea (txtEmpLog).
    txtEmpLog.setText(String.valueOf(employee));
  }

  /**
   * initialize method is the first method to run, it sets values in the combo box, starts the
   * connection to the database, and gathers information from the database and stores it into a
   * list. Database information is pass to an observable list. This list sets the values to text
   * area, table view, and list view.
   */
  public void initialize() throws IOException, SQLException {
    // Connects and run database once for the application.
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

    // Populate choiceBox with an array of values from class items. using an enhance for loop.
    ObservableList<String> choiceList = FXCollections.observableArrayList();
    for (ItemType it : ItemType.values()) {
      choiceList.add(String.valueOf(it));
    }
    chbItemType.getItems().addAll(choiceList);

    // Calls method EmployeeDetails.
    employeeDetails();

    // Display products in listView and tableView.
    setupProductLineTable(productLine);

    // Get data from the productionRecord.
    loadProductionLog(productionRun);

    // Get data from product.
    loadProductList(productLine);
  }

  /**
   * initializeDB method is called once in initialize method. DB establishes a connection, user and
   * pass.
   */
  private void initializeDB() throws IOException {
    // Connection establish.
    final String jdbcDriver = "org.h2.Driver";
    final String dbUrl = "jdbc:h2:./Lib/productDb";

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
