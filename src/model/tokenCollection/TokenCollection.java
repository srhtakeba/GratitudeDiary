package model.tokenCollection;

import java.time.LocalDate;
import java.util.List;
import model.token.Token;

/**
 * An interface to represent a collection of {@code Token}. This token collection is a place
 * to store these Tokens for a Gratitude Diary.
 */
public interface TokenCollection {

  /**
   * A method to add a token of gratitude to this {@code TokenCollection}
   * @param token the token to be added
   */
  public void addToken(Token token);

  /**
   * A method to find the tokens made on a specific date
   * @param date the date to be searched for
   * @return the list of tokens made on the specific date
   */
  public List<Token> getTokensFromDate(LocalDate date);

  /**
   * A method to find the tokens made on the oldest date
   * @return the list of tokens made on the oldest date
   */
  public List<Token> getOldestTokens();

  /**
   * A method to find the tokens made on the most recent date
   * @return the list of tokens made on the most recent date
   */
  public List<Token> getMostRecentTokens();

  /**
   * A method to count the number of tokens in this {@code TokenCollection}
   * @return the int number of tokens of gratitude in this token collection
   */
  public int countTokens();

}
