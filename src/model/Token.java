package model;
import java.time.LocalDate;

/**
 * Interface that represents a Token of gratitude to be used in a gratitude diary.
 */
public interface Token {

  /**
   * Returns the token of gratitude's text
   */
  String getText();

  /**
   * Returns the date of token creation
   */
  LocalDate getCreationDate();

  /**
   * Returns the recipient of token of gratitude
   */
  Recipient getRecipient();
}
