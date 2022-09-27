package model.token;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Objects;

/**
 * A class that implements the Token model.
 */
public class TokenImpl implements Token{
  private String text;
  private LocalDate creationDate;
  private Recipient recipient;

  /**
   * Constructs an {@code TokenImpl} object.
   */
  public TokenImpl(String text, Recipient recipient){
    this.text = text;
    this.creationDate = LocalDate.now();
    this.recipient = recipient;
  }

  @Override
  public String getText() {
    return this.text;
  }

  @Override
  public LocalDate getCreationDate() {
    return this.creationDate;
  }

  @Override
  public Recipient getRecipient() {
    return this.recipient;
  }

  @Override
  public void setText(String s) {
    this.text = s;
  }

  @Override
  public void setRecipient(Recipient r) {
    this.recipient = r;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getText(), this.getCreationDate());
  }

  /**
   * Checks the given object with this {@code TokenImpl} for equality.
   *
   * @param o the object to be compared to
   * @return does this {@code TokenImpl} equal the given object?
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof TokenImpl)) {
      return false;
    }
    TokenImpl that = (TokenImpl) o;
    return this.text.equals(that.getText()) && this.recipient.equals(that.getRecipient())
        && this.creationDate.equals(that.getCreationDate());
  }
}
