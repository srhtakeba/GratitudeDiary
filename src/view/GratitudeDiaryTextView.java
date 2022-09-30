package view;

import java.io.IOException;
import java.util.List;
import model.GratitudeDiaryModel;
import model.token.Token;

public class GratitudeDiaryTextView implements GratitudeDiaryView {

  private final GratitudeDiaryModel model;
  private final Appendable ap;

  /**
   * constructs a new {@code GratitudeDiaryTextView} object.
   *
   * @param model the {@code GratitudeDiaryModel} to be represented
   * @param ap    the {@code Appendable} destination platform of the view.
   * @throws IllegalArgumentException if the model is null
   */
  public GratitudeDiaryTextView(GratitudeDiaryModel model, Appendable ap) throws IllegalArgumentException {
    if (model == null) {
      throw new IllegalArgumentException("Can not accept null model.");
    }
    this.model = model;
    // if the appendable passed is a null object, set this appendable to the console.
    if (ap == null) {
      this.ap = System.out;
    } else {
      this.ap = ap;
    }
  }

  /**
   * constructs a new GratitudeDiaryTextView object, setting the appendable to the console.
   *
   * @param model the {@code GratitudeDiaryModel} to be represented
   * @throws IllegalArgumentException if the model is null
   */
  public GratitudeDiaryTextView(GratitudeDiaryModel model) throws IllegalArgumentException {
    if (model == null) {
      throw new IllegalArgumentException("Can not accept null model.");
    }
    this.model = model;
    this.ap = System.out;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    // try run through the gratitude dump
    try {
      List<Token> tokenList = this.model.getAllTokens();
      for(Token t : tokenList) {
        builder.append("To:  ");
        builder.append(t.getRecipient().toString()).append(" ");
        builder.append(t.getText()).append("  ");
        builder.append(t.getCreationDate().toString()).append("\n");
      }
    }
    catch (Exception e) {
      builder = new StringBuilder();
    }
    return builder.toString();
  }

  @Override
  public void renderDiary() throws IOException {
    ap.append(this.toString());
  }

  @Override
  public void renderMessage(String message) throws IOException {
    ap.append(message);
  }
}
