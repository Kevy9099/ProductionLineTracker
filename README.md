# ProductionLineTracker
An application that utilize a JavaFx database and Java GUI SceneBuilder. Coding with Java and SQL, 
to develop an application for a media player production facility that will keep track of what products are produced.

# Goals
* Production tracking to be more automated.  
* Login will be more accurate, and it will be easier to generate production reports. 
* In addition to the ability to record production, the software also needs the ability to add to the product line.

# Information and Resources
1. GitHub [Basic Writing and Formatting Syntax](https://help.github.com/en/articles/basic-writing-and-formatting-syntax#links)
2. [StackOverFlow](https://stackoverflow.com)
3. TutorialPoint [Java-Interfaces](https://www.tutorialspoint.com/java/java_interfaces.htm)
4. TutorialPoint [Java-Enum](https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html)
5. Basic [Java](https://www.w3schools.com/java/), [SQL](https://www.w3schools.com/sql/), and [CSS](https://www.w3schools.com/css/) syntax

# Sprint 1

* Week 1
  - Create a JavaFx Project using **IntelliJ**. 
  - Add project to **GitHub**, make the repository **_private_**.
  - Documentation using a **README** file.
  
* Week 2
  - Created a **SceneBuilder**, using **sample.fxml** file from JavaFx project.
  -  Added a **_tab view_** and three **_tabs_** called:
     - Product Line
     - Produce 
     - Production Log
  - Added a **CSS** file with personalize codes.
  - **Project Expectation**
    - Quality Expectations
    - Style Expectations
    - Documentation Expectations
    
* Week 3
  - Inside the Product Line Tab:
    - Added an **AnchorPane**.
      - Added to AnchorPane, a 2x3 **GridPane**.
        - Added to the GridPane: **3 labels(_Product Name, Manufacturer, and Item Type_)**, **2 Text Fields**, and a **ChoiceBox** for Item Type.
    - Added a **Button** that says "Add Product".
      - Added an **Event Handler** for button **click event**. 
    - Added a **Label** called Existing Products and a **Table View**.
  - Inside the Produce Tab: 
    - Added an **AnchorPane**
      - Added **2 Labels(_Choose Produce, and Choose Quantity_)**, A **List View** for Choose Produce, and a **ComboBox(_returns data type String_)** for Choose Quantity. 
  - Inside the Production Log Tab:
    - Added an **AnchorPane**.
      - Added a **TextArea**.

* Week 4
  - Installed database software, add-ons, and imports.
  - Created a res folder. 
    - Created a database in the res folder.
  - **_Connected_** to the database.

* Week 5
  - Added **Database Driver, Database Credentials, Open a Connection, and Execute a Query**.
  - Added to the Add Button event handler to add products into the database.
  - Added to the ComboBox
    - Populated values from 1-10 in the **_ initialize method_**  
    - Allow the user to enter other value inside the combobox. 
    - Show a default value. 
    
# Sprint 2

* Week 6 - Enum, Interface, Abstract Class
* Issue 1 - Product
  - Created an **Enum** called ItemType.
    - This enum class holds 4 types and codes: **_Audio(AU), Visual(VI), AudioMobile(AM), VisualMobile(VM)_**.
  - Inside the Product Line Tab:
    - Filled the ChoiceBox with the types and used a for **enhanced for loop** to add all ItemTypes.
  - Created an **Interface** called Item and inside created methods:
    - getId( ); that returns a integer.
    - setName(String s); that returns one string parameter.
    - getName( ); that returns a string.
    - setManufacturer(String m); that return one string parameter.
    - getManufacturer( ); that returns a string.
  - Created an **abstract type** called Product. This abstract will **implement** the Item class.
    - Added fields to the abstract type and the fields from the product class.
      - int id;
      - String type;
      - String manufacturer;
      - String name;
  - Added a **constructor** that will take name of the product and set to field variables name.
  - Created a class called Widget, that will **extends** the Product class.
  
* Week 7 - Inheritance
* Issue 2 - Audio Player
  - Created an Interface called **MultimediaControl** and methods:
    - play( );
    - stop( );
    - previous( );
    - next( );
  - Created a **Concrete class** called **AudioPlayer**.
    - This is a subclass of Product and Implements the MultimediaControl interface.
    - This class will have **2 fields**:
      - String audioSpecification
      - String mediaType
  - Created a constructor that should call its parents constructor and setups the media type.
  - Created a toString method that displays the superclass's toString method.
    - This will add rows for Audio Spec and Type at the same time.
  - Created a driver class for AudioPlayer.
  
* Week 8 - Polymorphism
* Issue 3 - MonitorType, ScreenSpec, Screen, MoviePlayer Classes
  - Created an **Enum** called MonitorType.
    - Stores 2 Type: LCD, and LED. 
  - Created an **Interface** called ScreenSpec.
    - Define 3 methods: getResolution, getRefreshRate(), and getResponseTime.
  - Created a **Class** called Screen, that **implements** ScreenSpec.
    - Added three fields: resolution, refreshrate, and responsetime
  - Created a **Class** called MoviePlayer that **extends** Product, and **implements** MultimediaControl.
  
* Week 9
* Issue 4 - ProductionRecord
  - Created a **Class** called ProductionRecord.
    - Create fields: productionNumber, productID, serialNumber, and dateProduced.
  - **Overloaded Contructors** that hold different parameters.
  - Create a **toString** to format: "Prod. Num: 0 Product ID: 0 Serial Num: 0 Date: Mon Oct 14 10:29:48 UTC 2019".
  - Displays the production record in the TextArea and the Production Log.
  
* Week 10 Encapsulation
* Issue  5 - Production Enhancement
  - Added the **ability for the program to generate a unique serial number.**
    - **Overloaded Constructor** that holds a count of items created, idNumber of each serial number, serialID, and dateProduce.
  
* Week 11 Lists and ArrayLists
* Issue 6 - TableView
  - Products are **added and display** to the TableView.
    - Created an **ObservableList** name productLine to hold all the Products that can be produced.
  - Display the production log in the tab TextArea.
  
# Sprint 3

* Week 12 Lambda Expressions
* Issue 7 - Full Database Integration
  
        
        
        
        
        
