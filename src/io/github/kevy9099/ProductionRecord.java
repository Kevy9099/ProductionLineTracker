package io.github.kevy9099;

import java.util.Date;

/**
 * Production Record class creates data for a product, given unique details, keeps a count of
 * similar data, and displays the information to the tableView. Constructors are overloaded that
 * works didn't part of ProductionRecord.
 *
 * @author Kevin Mak 9/24/2019
 */
public class ProductionRecord {
  private int productionNumber;
  private int productID;
  private String serialNumber;
  private Date dateProduced;

  /**
   * A ProductionRecord constructor for when a user records products from the user interface and
   * sets productionNumber to 0, serialNumber to 0, and a current date of creation.
   *
   * @param productID corresponds to the productID from database.
   */
  public ProductionRecord(int productID) {
    this.productID = productID;
    productionNumber = 0;
    serialNumber = "0";
    dateProduced = new Date();
  }

  /**
   * An overloaded constructor that initialize ProductionRecord fields.
   *
   * @param productionNumber Production Number is an unique number that is auto-incremented (ie 0)
   * @param productID ProductID sets a current ID. (ie 0)
   * @param serialNumber Serial Number unique set of numbers of a product. (ie AU0000)
   * @param dateProduced Date Produced is the current date and time of creation. (ie 11/3/2019 at
   *     11:02)
   */
  public ProductionRecord(
      int productionNumber, int productID, String serialNumber, Date dateProduced) {
    this.productionNumber = productionNumber;
    this.productID = productID;
    this.serialNumber = serialNumber;
    this.dateProduced = dateProduced;

  }

  /**
   * A overloaded constructor that produce a unique set of numbers for a product.
   *
   * @param productProduced Product Produced is a product that gets a serialNumber, idNumber, and
   *     date.
   * @param counter Counter is the number of items of its type that as been created.
   */
  public ProductionRecord(Product productProduced, int counter) {
    String idNumber = String.format("%05d", counter);
    this.serialNumber =
        productProduced.getManufacturer().substring(0, 3)
            + productProduced.getType().getValue()
            + idNumber;
    this.dateProduced = new Date();
  }

  /**
   * A constructor that sets a Date.
   *
   * @param dateProduced Current date.
   */
  public ProductionRecord(Date dateProduced) {
    this.dateProduced = dateProduced;
  }

  /**
   * Method that enables access productionNumber.
   *
   * @return productionNumber
   */
  public int getProductionNumber() {
    return productionNumber;
  }

  /**
   * Method that sets a value of productionNumber.
   *
   * @param productionNumber Production Number is an unique number that is auto-incremented (ie 0)
   */
  public void setProductionNumber(int productionNumber) {
    this.productionNumber = productionNumber;
  }

  /**
   * Method that enables access to productID.
   *
   * @return productID
   */
  public int getProductID() {
    return productID;
  }

  /**
   * Method that sets a value of productID.
   *
   * @param productID ProductID sets a current ID. (ie 0)
   */
  public void setProductID(int productID) {
    this.productID = productID;
  }

  /**
   * Method that enables access serialNumber.
   *
   * @return serialNumber
   */
  public String getSerialNumber() {
    return serialNumber;
  }

  /**
   * Method that sets a value of serialNumber.
   *
   * @param serialNumber Serial Number unique set of numbers of a product. (ie AU0000)
   */
  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  /**
   * Method that enables access dateProduced.
   *
   * @return dateProduced
   */
  public Date getDateProduced() {
    return dateProduced;
  }

  /**
   * Method that sets a value of dateProduced.
   *
   * @param dateProduced Date Produced is the current date and time of creation. (ie 11/3/2019 at
   *     11:02)
   */
  public void setDateProduced(Date dateProduced) {
    this.dateProduced = dateProduced;
  }

  /**
   * ProductionRecord fields returns as a single line String, using toString(). Printed to the
   * console and the Production Log Text Area.
   *
   * @return productionNumber, productID, serialNumber, and a Date.
   */
  public String toString() {
    return " Prod. Num: "
        + productionNumber
        + " Product ID: "
        + productID
        + " Serial Num: "
        + serialNumber
        + " Date: "
        + dateProduced;
  }
}
