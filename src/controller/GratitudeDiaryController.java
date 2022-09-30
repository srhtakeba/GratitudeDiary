package controller;

/**
 * Interface for a gratitude diary controller.
 */
public interface GratitudeDiaryController {

  /**
   * Start a new gratitude diary.
   * @throws IllegalStateException if writing to the Appendable object used by it
   * fails or reading from the provided Readable fails
   */
  void startDiary() throws IllegalStateException;
}
