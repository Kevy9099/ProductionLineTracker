package sample;

public class MoviePlayer extends Product implements MultimediaControl {
    private String screen;
    private String monitorType;

  public MoviePlayer(String type, String manufacturer, String name, String screen, String monitorType) {
    super(name, "VISUAL", manufacturer);
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

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getMonitorType() {
        return monitorType;
    }

    public void setMonitorType(String monitorType) {
        this.monitorType = monitorType;
    }

    public String toString(){
        return super.toString() + ", Screen Size = '" + this.screen + "\'"
                + ", Monitor Type = '" + this.monitorType + "\'" + '}';
    }
}
