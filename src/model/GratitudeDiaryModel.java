package model;

import java.util.List;
import model.token.Recipient;
import model.token.Token;
import model.tokenCollection.TokenCollection;

/**
 * Interface to represent a GratitudeDiary which holds Tokens of Gratitude and Stores Them
 */
public interface GratitudeDiaryModel {

  /**
   * Adds a token of gratitude to the gratitude diary
   * (Use LocalDate.now(),
   * @param text The textual explanation of the token of gratitude.
   * @param to The recipient of the token of gratitude.
   * @param destination the destinating place to store this token of gratitude.
   */
  void addToken(String text, Recipient to, TokenCollection destination);

  /**
   * Get a list of Tokens on oldest date from a token collection
   * @param collection the token collection to search for the oldest tokens of gratitude
   * @return the list of tokens dropped on the oldest date
   */
  List<Token> getOldestTokens(TokenCollection collection);

  /**
   * Get a list of Tokens of most recent date
   * @param collection the token collection to search for the recent tokens of gratitude
   * @return the list of tokens dropped on the most recent date
   */
  List<Token> getMostRecentTokens(TokenCollection collection);

  /**
   * Get a list of Tokens by recipient
   * @param r the recipient to filter search for
   * @param collection the token collection to search within
   * @return the list of tokens sent to the specific recipient
   */
  List<Token> getTokensByRecipient(Recipient r, TokenCollection collection);

  /**
   * Get the list of recipients
   * @return the list of recipients in this Gratitude Diary
   */
  List<Recipient> getRecipients();
}
