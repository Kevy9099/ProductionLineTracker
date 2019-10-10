package sample;

public class AudioPlayer extends Product implements MultimediaControl{
    private String audioSpecification;
    private String mediaType;

    public AudioPlayer(int id, String type, String manufacturer, String name, String audioSpecification, String mediaType) {
        super(id, type, manufacturer, name);
        this.audioSpecification = audioSpecification;
        this.mediaType = mediaType;
    }

  public String toString() {
    String spec = ", AudioSpec = '" + this.audioSpecification + "\'";
    String media = ", Type = '" + this.mediaType + "\'" + '}';
    System.out.println("Playing...");
    return  super.toString() + spec + media;
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


    public String getAudioSpecification() {
        return audioSpecification;

    }

    public void setAudioSpecification(String audioSpecification) {
        this.audioSpecification = audioSpecification;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

}
