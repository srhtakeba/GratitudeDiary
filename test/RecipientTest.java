import static org.junit.Assert.*;

import model.token.Recipient;
import model.token.RecipientImpl;
import org.junit.Before;
import org.junit.Test;

public class RecipientTest {

  private Recipient r1;
  private Recipient r2;
  private Recipient r3;

  @Before
  public void setUp() throws Exception {
    this.r1 = new RecipientImpl("mySelf");
    this.r2 = new RecipientImpl("family");
    this.r3 = new RecipientImpl("MYSElf");
  }

  @Test
  public void testToString() {
    assertEquals(r1.toString(), "MYSELF");
    assertEquals(r2.toString(), "FAMILY");
    assertEquals(r3.toString(), "MYSELF");
    assertEquals(r1.toString(), r3.toString());
  }
}