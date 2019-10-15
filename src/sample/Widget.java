package sample;

import java.util.ArrayList;
//Issue 2 Widget prototype error, not yet fixed.
public class Widget extends Product {
  public Widget( String name, String manufacturer, String type) {
    super( name, manufacturer, type);
  }

  public static void main(String[] args) {
    Widget protoType = new Widget( "Windows", "Microsoft", "AM");
    ArrayList<Widget> productLine = new ArrayList<>();
    productLine.add(protoType);
    System.out.println(protoType.toString());

    //String userType = cb.value;
    //protoType.setType(userType);
    //ArrayList<product>ProductLine = new ArrayList<>();
    //productLine.add(addedProduct);
  }
}
