package model.token;

import java.util.Locale;

public class RecipientImpl implements Recipient{
  private String name;

  /**
   * Creates a new {@code RecipientImpl} object
   * {@code String name} is the name of the recipient, stored in all upper case.
   */
  public RecipientImpl(String s) {
    this.name = s.toUpperCase(Locale.ROOT);
  }

  @Override
  public String toString() {
    return this.name;
  }

}
