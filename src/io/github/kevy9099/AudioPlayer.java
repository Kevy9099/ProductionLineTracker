package io.github.kevy9099;

/**
 * AudioPlayer class gives details to audioSpecification and mediaType of a product. Sets its own
 * fields, uses fields from Product class and implements MultimediaControl methods.
 *
 * @author Kevin Mak 9/24/2019
 */
public class AudioPlayer extends Product implements MultimediaControl {
  private String audioSpecification;
  private String mediaType;

  /**
   * Constructor of class AudioPlayer accepting and setting its own parameters, and calls the parent
   * class fields.
   *
   * @param name Name of a Product. (ie iPod)
   * @param manufacturer Manufacturer that created the Product. (ie Apple)
   * @param audioSpecification AudioSpecification of the Product. (ie Dolby Digital)
   * @param mediaType MediaType of the product. (ie iTunes)
   */
  public AudioPlayer(
      String name, String manufacturer, String audioSpecification, String mediaType) {
    super(name, manufacturer, ItemType.Audio);
    this.audioSpecification = audioSpecification;
    this.mediaType = mediaType;
  }

  /**
   * AudioPlayer fields are represented as strings, using the toString( ). Sets the fields of Audio
   * Player and Parent fields to a single string displays to the console and product log.
   *
   * @return string audioSpecification, mediaType and parent toString().
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
  // prints play, stop, back and next to the console.
  // getters and setters for only AudioPlayer fields.

  /** Method that enables access to play, that has no returnType. */
  public void play() {
    System.out.println("Playing...");
  }

  /** Method that enables access to stop, that has no returnType. */
  public void stop() {
    System.out.println("Stopping..");
  }

  /** Method that enables access to previous, that has no returnType. */
  public void previous() {
    System.out.println("<< Back");
  }

  /** Method that enables access to next, that has no returnType. */
  public void next() {
    System.out.println("Next >>");
  }

  /**
   * Method that enables access to audioSpecification.
   *
   * @return audioSpecification
   */
  public String getAudioSpecification() {
    return audioSpecification;
  }

  /**
   * Method that sets a value of audioSpecification.
   *
   * @param audioSpecification AudioSpecification of the Product. (ie Dolby Digital)
   */
  public void setAudioSpecification(String audioSpecification) {
    this.audioSpecification = audioSpecification;
  }

  /**
   * Method that enables access to mediaType.
   *
   * @return mediaType
   */
  public String getMediaType() {
    return mediaType;
  }

  /**
   * Method that sets a value of mediaType.
   *
   * @param mediaType MediaType of the product. (ie iTunes)
   */
  public void setMediaType(String mediaType) {
    this.mediaType = mediaType;
  }
}
