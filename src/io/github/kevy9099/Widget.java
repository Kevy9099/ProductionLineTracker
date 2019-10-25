package io.github.kevy9099;

import java.util.ArrayList;

public class Widget extends Product {
  public Widget( String name, String manufacturer, String type) {
    super( name, manufacturer, type);
  }

  public static void main(String[] args) {
    Widget protoType = new Widget("Windows", "Microsoft", "AM");
    ArrayList<Widget> productLine = new ArrayList<>();
    productLine.add(protoType);
    System.out.println(protoType.toString());
    }
}
