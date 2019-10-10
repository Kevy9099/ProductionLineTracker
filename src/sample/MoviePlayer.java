package sample;

public class MoviePlayer extends Product implements MultimediaControl {
    private String screen;
    private String monitorType;

  public MoviePlayer(int id, String type, String manufacturer, String name, String screen, String monitorType) {
    super(id, name, "VISUAL", manufacturer);
      this.screen = screen;
      this.monitorType = monitorType;
}
    public void play() {
        System.out.println("Playing...");
    }

    public void stop() {
        System.out.println("Stopping...");
    }

    public void previous() {
        System.out.println("<< Back");
    }

    public void next() {
        System.out.println("Next >>");
    }

}
