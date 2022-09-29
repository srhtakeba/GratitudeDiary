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
  private LocalDate now;
  private LocalDate march012020;
  private LocalDate march012022;

  private TokenCollection dump;
  private TokenCollection dump1;

  @Before
  public void setup() throws Exception {
    this.r1 = new RecipientImpl("family");
    this.r2 = new RecipientImpl("nature");
    this.r3 = new RecipientImpl("myself");

    this.now = LocalDate.now();
    this.march012020 = LocalDate.of(2020, 3, 1);
    this.march012022 = LocalDate.of(2022, 3, 1);

    // t1 date is now
    this.t1 = new TokenImpl("good dinner", r1);
    // t2 date is march 01 2020
    this.t2 = new TokenImpl("nice weather", r2);
    this.t2.setCreationDate(march012020);
    // t3 date is march 01 2022
    this.t3 = new TokenImpl("wake up on time",r3);
    this.t3.setCreationDate(march012022);


    this.dump = new GratitudeDump();
    this.dump1 = new GratitudeDump();
    this.dump1.addToken(this.t1);
    this.dump1.addToken(this.t2);
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
    // try with dump with tokens
    List<Token> expected = Arrays.asList(this.t1);
    List<Token> actual = this.dump1.getTokensFromDate(this.now);

    assertTrue(expected.size() == actual.size() &&
        expected.containsAll(actual) && actual.containsAll(expected));

    // try with empty dump
    expected = Arrays.asList();
    actual = this.dump.getTokensFromDate(this.now);
    assertTrue(expected.size() == actual.size() &&
        expected.containsAll(actual) && actual.containsAll(expected));
  }

  @Test
  public void testGetOldestTokens() {
    List<Token> expected = Arrays.asList(this.t2);
    List<Token> actual = this.dump1.getOldestTokens();

    assertTrue(expected.size() == actual.size() &&
        expected.containsAll(actual) && actual.containsAll(expected));

    // try with empty dump
    expected = Arrays.asList();
    actual = this.dump.getOldestTokens();
    assertTrue(expected.size() == actual.size() &&
        expected.containsAll(actual) && actual.containsAll(expected));
  }

  @Test
  public void testGetMostRecentTokens() {
    List<Token> expected = Arrays.asList(this.t1);
    List<Token> actual = this.dump1.getMostRecentTokens();

    assertTrue(expected.size() == actual.size() &&
        expected.containsAll(actual) && actual.containsAll(expected));

    // try with empty dump
    expected = Arrays.asList();
    actual = this.dump.getMostRecentTokens();
    assertTrue(expected.size() == actual.size() &&
        expected.containsAll(actual) && actual.containsAll(expected));
  }

  @Test
  public void testCountTokens() {
    assertEquals(this.dump1.countTokens(), 2);
    assertEquals(this.dump.countTokens(), 0);
  }

  @Test
  public void testGetOldestDate() {
    assertEquals(this.dump1.getOldestDate(), this.march012020);

    // try with empty list
    assertNull(this.dump.getOldestDate());
  }

  @Test
  public void testGetMostRecentDate() {
    assertEquals(this.dump1.getMostRecentDate(), this.now);

    // try with empty list
    assertNull(this.dump.getMostRecentDate());
  }




}