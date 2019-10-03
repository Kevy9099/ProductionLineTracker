package sample;

import java.util.ArrayList;
//Issue 2 Widget prototype error, not yet fixed.
public class Widget extends Product {
  public Widget(int id, String type, String manufacturer, String name) {
    super(id, type, manufacturer, name);
  }

  public static void main(String[] args) {
    Widget protoType = new Widget( 2, "AM", "Microsoft", "Windows");
    ArrayList<Widget> productLine = new ArrayList<>();
    productLine.add(protoType);
    System.out.println(protoType.toString());

    //String userType = cb.value;
    //protoType.setType(userType);
    //ArrayList<product>ProductLine = new ArrayList<>();
    //productLine.add(addedProduct);
  }
}
