package controller;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;
import model.GratitudeDiaryModel;
import model.token.Recipient;
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
    while(!quit) {
      askUser();
    }

    // check for quit and end game as appropriate
    if (quit) {
      sendMessage("Diary quit prematurely.");
    }
  }

  /**
   * Ask for commands and check for quite statement
   */
  private void askUser() {
    sendMessage("A) add");
    sendMessage("S) show");
    sendMessage("Q) quit");
    sendMessage("Input your command. \n > ");
    String command = readFromScanner();
    if(command.equalsIgnoreCase("A")) {
      readNewToken();
    }
    else if (command.equalsIgnoreCase("S")) {
      sendDiary();
    }
    else if(command.equalsIgnoreCase("Q")) {
      quit = true;
    }
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

  /**
   * Scans the contents of a new Gratitude token
   *
   */
  private void readNewToken() {
    scan.reset();
    String recipientText;
    String gratitudeText;
    Recipient recipient;

    // first ask for recipient, if the reader is empty, however,
    // let the client know that there are no inputs to be read
    sendMessage("Input your recipient. \n > ");
    if (scan.hasNext()) {
      recipientText = readFromScanner();
    } else {
      throw new IllegalStateException("No inputs to be read.");
    }

    // CHECK FOR VALIDITY OF THE RECIPIENT HERE
    if( ! checkForRecipient(recipientText)) {
      throw new IllegalStateException("Recipient is invalid.");
    }
    else {
      recipient = findRecipient(recipientText);
    }

    // next ask for gratitude text
    sendMessage("Enter your gratitude. \n > ");
    if (scan.hasNext()) {
      gratitudeText = readFromScanner();
    } else {
      throw new IllegalStateException("No inputs to be read.");
    }

    model.addToken(gratitudeText, recipient);
  }

  /**
   * Check if the recipient exists in this model
   * @param recipientText the string representation of recipient
   * @return a boolean representing whether the given recipient exists
   * in this model or not.
   */
  private boolean checkForRecipient(String recipientText) {
    List<Recipient> modelRecipients = model.getRecipients();
    boolean exists = false;
    for(Recipient r : modelRecipients) {
      if( (recipientText.toUpperCase()).equals(r.toString())) {
        exists = true;
      }
    }
    return exists;
  }

  /**
   * Find the Recipient represented by the given string
   * @param recipientText the string representation of the recipient
   * @return the recipient to be found
   */
  private Recipient findRecipient(String recipientText) {
    List<Recipient> modelRecipients = model.getRecipients();
    Recipient result;
    for(Recipient r : modelRecipients) {
      if( (recipientText.toUpperCase()).equals(r.toString())) {
        result = r;
        return result;
      }
    }
    return null;
  }

}
