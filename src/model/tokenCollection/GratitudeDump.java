package model.tokenCollection;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.token.Token;

/**
 * A class to represent a {@code GratitudeDump} this is a token collection where all of the
 * tokens are quite literally 'dumped' here. Mostly for testing purposes
 */
public class GratitudeDump implements TokenCollection {
  private List<Token> tokens;

  /**
   * Constructs a new {@code GratitudeDump} object.
   */
  public GratitudeDump() {
    this.tokens = new ArrayList<Token>();
  }

  /**
   * Adds a new token to this {@code GratitudeDump}.
   * @param token the token to be added
   */
  @Override
  public void addToken(Token token) {
    this.tokens.add(token);
  }

  /**
   * Finds a list of {@code Token} objects in this {@code GratitudeDump} which have the
   * same date as the date passed.
   * @param date the date to be searched for
   * @return the list of {@code Token} objects of the given date
   */
  @Override
  public List<Token> getTokensFromDate(LocalDate date) {
    List<Token> result = new ArrayList();
    for (Token current : this.tokens) {
      if(current.getCreationDate().equals(date)) {
        result.add(current);
      }
    }
    return result;
  }

  @Override
  public List<Token> getOldestTokens() {
    return this.getTokensFromDate(this.getOldestDate());
  }

  @Override
  public List<Token> getMostRecentTokens() {
    return this.getTokensFromDate(this.getMostRecentDate());
  }

  @Override
  public int countTokens() {
    return this.tokens.size();
  }

  @Override
  public LocalDate getOldestDate() {
    LocalDate result = LocalDate.now();
    int currentDay;
    int currentYear;
    int currentMonth;
    LocalDate currentDate;
    if(this.tokens.size()>0){
      for(Token current : this.tokens) {
        currentYear = current.getCreationDate().getYear();
        currentMonth = current.getCreationDate().getMonthValue();
        currentDay = current.getCreationDate().getDayOfMonth();
        currentDate = LocalDate.of(currentYear, currentMonth, currentDay);

        if(current.getCreationDate().isBefore(result)) {
          result = currentDate;
        }
      }
      return result;
    }
    else {
      return null;
    }
  }

  @Override
  public LocalDate getMostRecentDate() {
    LocalDate result = LocalDate.MIN;
    int currentDay;
    int currentYear;
    int currentMonth;
    LocalDate currentDate;
    if(this.tokens.size()>0){
      for(Token current : this.tokens) {
        currentYear = current.getCreationDate().getYear();
        currentMonth = current.getCreationDate().getMonthValue();
        currentDay = current.getCreationDate().getDayOfMonth();
        currentDate = LocalDate.of(currentYear, currentMonth, currentDay);

        if(current.getCreationDate().isAfter(result)) {
          result = currentDate;
        }
      }
      return result;
    }
    else {
      return null;
    }
  }
}
