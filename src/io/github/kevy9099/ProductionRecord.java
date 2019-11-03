package io.github.kevy9099;

import java.util.Date;

public class ProductionRecord {
  private int productionNumber;
  private int productID;
  private String serialNumber;
  private Date dateProduced;

  /**
   * A ProductionRecord when the user record production from the user interface and sets
   * productionNumber to 0, serialNumber to 0, and a current date of creation.
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
   * An overloaded constructor used when creating productionRecord objects from the db.
   *
   * @param productionNumber product auto-incremented number.
   * @param productID sets to current productID.
   * @param serialNumber product unique set of numbers.
   * @param dateProduced current date and time.
   */
  public ProductionRecord(
      int productionNumber, int productID, String serialNumber, Date dateProduced) {
    this.productID = productID;
    this.productionNumber = productionNumber;
    this.dateProduced = dateProduced;
    this.serialNumber = serialNumber;
  }

  /**
   * A constructor that produce a unique set of numbers for a product.
   *
   * @param productProduced is a product that gets a serial number.
   * @param counter number of items of it type that as been created.
   */
  public ProductionRecord(Product productProduced, int counter) {
    String idNumber = String.format("%05d", counter);
    this.serialNumber =
        productProduced.getManufacturer().substring(0, 3)
            + productProduced.getType().getValue()
            + idNumber;
    this.dateProduced = new Date();
  }

  public int getProductionNumber() {
    return productionNumber;
  }

  public void setProductionNumber(int productionNumber) {
    this.productionNumber = productionNumber;
  }

  public int getProductID() {
    return productID;
  }

  public void setProductID(int productID) {
    this.productID = productID;
  }

  public String getSerialNumber() {
    return serialNumber;
  }

  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  public Date getDateProduced() {
    return dateProduced;
  }

  public void setDateProduced(Date dateProduced) {
    this.dateProduced = dateProduced;
  }

  /**
   * ProductionRecord fields are set as Strings, by toString() method.
   *
   * @return productionNumber, productID, serialNumber, and a Date of creation.
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
