package io.github.kevy9099;

import java.util.Date;

public class ProductionRecord {
  int productionNumber;
  int ProductID;
  String serialNumber;
  Date dateProduced;

  public int getProductionNumber() {
    return productionNumber;
  }

  public void setProductionNumber(int productionNumber) {
    this.productionNumber = productionNumber;
  }

  public int getProductID() {
    return ProductID;
  }

  public void setProductID(int productID) {
    ProductID = productID;
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
}
