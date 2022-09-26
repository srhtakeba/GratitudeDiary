package model;

import java.util.List;
import model.token.Recipient;
import model.token.Token;

/**
 * Interface to represent a GratitudeDiary which holds Tokens of Gratitude and Stores Them
 */
public interface GratitudeDiaryModel {

  /**
   * Adds a token of gratitude to the gratitude diary
   * (Use LocalDate.now(),
   */
  void addToken(String text, Recipient to);

  /**
   * Get a list of Tokens on oldest date
   */
  List<Token> getOldest();

  /**
   * Get a list of Tokens of most recent date
   */
  List<Token> getMostRecent();

  /**
   * Get a list of Tokens by recipient
   */
  List<Token> getTokensByRecipient(Recipient r);

  /**
   * Get the list of recipients
   */
  List<Recipient> getRecipients();
}
