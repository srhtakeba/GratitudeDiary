package view;

import java.io.IOException;

public interface GratitudeDiaryView {

  /**
   * Return the present state of the gratitude diary as a string
   * @return the string format of the current state of gratitude diary
   */
  String toString();

  /**
   * Render the diary to the provided data destination
   * @throws IOException if transmission of the diary to the data destination fails
   */
  void renderDiary() throws IOException;

  /**
   * Render a specific message to the provided data destination
   * @param message the message to be transmitted
   * @throws IOException if transmission of the message to the data destination fails
   */
  void renderMessage(String message) throws IOException;

}
