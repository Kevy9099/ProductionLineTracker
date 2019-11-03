package io.github.kevy9099;

public class AudioPlayer extends Product implements MultimediaControl {
  private String audioSpecification;
  private String mediaType;

  /**
   * Creates a class that allow us to capture details of an AudioPlayer. Extends from class product,
   * calls the super constructor of product details: Name, Manufacturer and Type. Audio is called by
   * the ItemType Enum class. Also, implements the MultimediaControl class, using its fields:
   * Play(), Stop(), Next(), and Back().
   */
  public AudioPlayer(
      String name, String manufacturer, String audioSpecification, String mediaType) {
    super(name, manufacturer, ItemType.Audio);
    this.audioSpecification = audioSpecification;
    this.mediaType = mediaType;
  }

  /**
   * AudioPlayer fields are represented as strings, using the toString( ) method.
   *
   * @return string audioSpecification, mediaType and parent super toString().
   */
  public String toString() {
    return super.toString()
        + "  "
        + "Audio Specifications: "
        + this.audioSpecification
        + "  "
        + "Media Type: "
        + this.mediaType
        + "  ";
  }

  public void play() {
    System.out.println("Playing...");
  }

  public void stop() {
    System.out.println("Stopping..");
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
