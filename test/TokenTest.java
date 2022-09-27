import static org.junit.Assert.*;

import java.time.LocalDate;
import model.token.Recipient;
import model.token.RecipientImpl;
import model.token.Token;
import model.token.TokenImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TokenTest {

  private Token t1;
  private Token t2;
  private Token t3;
  private LocalDate now;
  private Recipient r1;
  private Recipient r2;
  private Recipient r3;


  @Before
  public void setUp() throws Exception {
    this.r1 = new RecipientImpl("family");
    this.r2 = new RecipientImpl("nature");
    this.r3 = new RecipientImpl("myself");


    this.t1 = new TokenImpl("good dinner", r1);
    this.t2 = new TokenImpl("nice weather", r2);
    this.t3 = new TokenImpl("wake up on time",r3);
    this.now = LocalDate.now();
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void getText() {
    assertEquals("good dinner", t1.getText());
    assertEquals("nice weather", t2.getText());
    assertEquals("wake up on time", t3.getText());
    assertNotEquals("wake up on time", t1.getText());
  }

  @Test
  public void getCreationDate() {
    assertEquals(t1.getCreationDate(), this.now);
    assertEquals(t2.getCreationDate(), this.now);
    assertEquals(t3.getCreationDate(), this.now);
    assertEquals(t1.getCreationDate(), t3.getCreationDate());
  }

  @Test
  public void getRecipient() {
    assertEquals(t1.getRecipient(), r1);
    assertEquals(t2.getRecipient(), r2);
    assertEquals(t3.getRecipient(), r3);
    assertNotEquals(t3.getRecipient(), r2);

    assertEquals(t1.getRecipient().toString(), "FAMILY");
  }

  @Test
  public void setText() {
    assertEquals("good dinner", t1.getText());
    t1.setText("good lunch");
    assertEquals("good lunch", t1.getText());
    t1.setText("nice weather");
    assertEquals(t1.getText(), t2.getText());
  }

  @Test
  public void setRecipient() {
    assertEquals(t1.getRecipient(), r1);
    t1.setRecipient(r2);
    assertEquals(t1.getRecipient(), r2);
  }

  @Test
  public void testHashCode() {
  }
}