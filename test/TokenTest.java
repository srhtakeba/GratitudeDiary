import static org.junit.Assert.*;

import java.time.LocalDate;
import model.token.Recipient;
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
  private Recipient r;


  @Before
  public void setUp() throws Exception {
    this.t1 = new TokenImpl("good dinner", r);
    this.t2 = new TokenImpl("nice weather", r);
    this.t3 = new TokenImpl("train on time",r);
    this.now = LocalDate.now();
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void getText() {
    assertEquals("good dinner", t1.getText());
    assertEquals("nice weather", t2.getText());
    assertEquals("train on time", t3.getText());
    assertNotEquals("train on time", t1.getText());
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
  }

  @Test
  public void testHashCode() {
  }
}