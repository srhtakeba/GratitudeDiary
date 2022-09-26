package model;

/**
 * Interface to represent a GratitudeDiary which holds Tokens of Gratitude and Stores Them
 */
public interface GratitudeDiaryModel {

  /**
   * Adds a token of gratitude to the gratitude diary
   * (Use LocalDate.now(),
   */
  void addToken(String text, Recipient to);
}
