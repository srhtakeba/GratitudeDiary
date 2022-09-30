package controller;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import model.GratitudeDiaryModel;
import view.GratitudeDiaryTextView;
import view.GratitudeDiaryView;

public class SimpleGratitudeDiaryController implements GratitudeDiaryController{

  private final GratitudeDiaryModel model;
  private final Scanner scan;
  private final GratitudeDiaryView view;

  private boolean quit;

  /**
   * Constructs a {@code SimpleGratitudeDiaryController} object.
   *
   * @param model the gratitude diary model to be connected
   * @param rd the {@code Readable} object that this controller will be getting input from.
   * @param ap the {@code Appendable} object that this controller will be using to make a new view from.
   *
   *
   * @throws IllegalArgumentException if {@code model}, {@code ap}, or {@code rd} is null.
   */
  public SimpleGratitudeDiaryController(GratitudeDiaryModel model, Readable rd, Appendable ap)
  throws IllegalArgumentException {
    if (rd == null || ap == null) {
      throw new IllegalArgumentException("Null Readable or Appendable object.");
    }
    if (model == null) {
      throw new IllegalArgumentException("Null model can not be processed.");
    }
    this.model = model;
    this.scan = new Scanner(rd);
    this.view = new GratitudeDiaryTextView(model, ap);
    this.quit = false;
  }

  @Override
  public void startDiary() throws IllegalStateException {

  }

  /**
   * Sends the current diary state to this {@code SimpleGratitudeDiaryController}'s view, ending the
   * output with a new line token.
   *
   * @throws IllegalStateException if writing to the Appendable object used by it fails
   */
  private void sendDiary() throws IllegalStateException {
    try {
      view.renderDiary();
      view.renderMessage("\n");
    } catch (IOException e) {
      throw new IllegalStateException("Appending to Appendable object failed.");
    }
  }

  /**
   * Sends the given to this {@code SimpleGratitudeDiaryController}'s view. Will not add an additional new
   * line at the end of the given message.
   *
   * @param message a message of type {@code String} to be sent to the view.
   * @throws IllegalStateException if writing to the Appendable object used by it fails
   */
  private void sendMessage(String message) throws IllegalStateException {
    try {
      view.renderMessage(message);
    } catch (IOException e) {
      throw new IllegalStateException("Appending to Appendable object failed.");
    }
  }

  /**
   * Finds and returns the String value of next token from this {@code SimpleGratitudeDiaryController}'s
   * scanner, handling the {@code NoSuchElementException} if it is thrown.
   *
   * @return the next token from the scanner.
   * @throws IllegalStateException if reading from the provided Readable fails.
   */
  private String readFromScanner() throws IllegalStateException {
    try {
      return scan.next();
    } catch (NoSuchElementException e) {
      throw new IllegalStateException("The Readable ran out of inputs.");
    }
  }
}
