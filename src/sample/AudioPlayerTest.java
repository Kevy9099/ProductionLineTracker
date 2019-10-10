package sample;

import java.util.ArrayList;

public class AudioPlayerTest extends AudioPlayer {
  public AudioPlayerTest(
      int id,
      String type,
      String manufacturer,
      String name,
      String audioSpecification,
      String mediaType) {
    super(id, type, manufacturer, name, audioSpecification, mediaType);
  }

  public static void main(String[] args) {
    AudioPlayerTest test =
        new AudioPlayerTest(
            2, "AM", "Microsoft", "Windows",
                "Windows Audio", "Windows Media Player");
    ArrayList<AudioPlayerTest> AudioLine = new ArrayList<>();
    AudioLine.add(test);
    System.out.println(AudioLine.toString());
  }
}
