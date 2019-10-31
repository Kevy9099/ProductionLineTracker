package io.github.kevy9099;

import java.util.Date;

public class ProductionRecord {
  private int productionNumber;
  private int productID;
  private String serialNumber;
  private Date dateProduced;

  public ProductionRecord(int productID) {
    this.productID = productID;
    productionNumber = 0;
    serialNumber = "0";
    dateProduced = new Date();
  }

  public ProductionRecord(int productionNumber, int productID, String serialNumber, Date dateProduced) {
    this.productID = productID;
    this.productionNumber = productionNumber;
    this.dateProduced = dateProduced;
    this.serialNumber = serialNumber;
  }

  public ProductionRecord(Product productProduced, int counter) {
    String idNumber = String.format("%05d", counter);
    this.serialNumber = productProduced.getManufacturer().substring(0,3)+productProduced.getType().getValue()+idNumber;
    this.dateProduced = new Date();
  }

  public int getProductionNumber() {
    return productionNumber;
  }

  public void setProductionNumber(int productionNumber){
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

  public  String toString() {
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
