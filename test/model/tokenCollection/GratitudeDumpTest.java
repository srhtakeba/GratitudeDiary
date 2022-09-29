package model.tokenCollection;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.token.Recipient;
import model.token.RecipientImpl;
import model.token.Token;
import model.token.TokenImpl;
import org.junit.Before;
import org.junit.Test;

public class GratitudeDumpTest {
  private Token t1;
  private Token t2;
  private Token t3;
  private Recipient r1;
  private Recipient r2;
  private Recipient r3;
  private LocalDate d1;
  private LocalDate d2;

  private TokenCollection dump;
  private TokenCollection dump1;

  @Before
  public void setup() throws Exception {
    this.r1 = new RecipientImpl("family");
    this.r2 = new RecipientImpl("nature");
    this.r3 = new RecipientImpl("myself");


    this.t1 = new TokenImpl("good dinner", r1);
    this.t2 = new TokenImpl("nice weather", r2);
    this.t3 = new TokenImpl("wake up on time",r3);
    this.d1 = LocalDate.now();

    this.dump = new GratitudeDump();
    this.dump1 = new GratitudeDump();
    this.dump1.addToken(this.t1);
  }

  @Test
  public void testConstructor() {
    TokenCollection dumpTest = new GratitudeDump();
    assertEquals(dumpTest.countTokens(), 0);
  }

  @Test
  public void testAddToken() {
    assertEquals(dump.countTokens(), 0);
    dump.addToken(this.t1);
    assertEquals(dump.countTokens(), 1);
    dump.addToken(this.t2);
    assertEquals(dump.countTokens(), 2);
    dump.addToken(this.t3);
    assertEquals(dump.countTokens(), 3);
  }

  @Test
  public void testGetTokensFromDate() {
    List<Token> expected = Arrays.asList(this.t1);
    List<Token> actual = this.dump1.getTokensFromDate(this.d1);

    assertTrue(expected.size() == actual.size() &&
        expected.containsAll(actual) && actual.containsAll(expected));

  }
}