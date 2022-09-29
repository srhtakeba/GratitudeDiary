package model.token;
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

  /**
   * Sets the token of gratitude's text
   */
  void setText(String s);

  /**
   * Sets the recipient of token of gratitude
   */
  void setRecipient(Recipient r);

  /**
   * Sets the date of token
   */
  void setCreationDate(LocalDate d);

  /**
   * Returns the hashcode for this token
   */
  @Override
  int hashCode();

  /**
   * Checks for equality between and Object and this Token
   */
  @Override
  boolean equals(Object o);
}
