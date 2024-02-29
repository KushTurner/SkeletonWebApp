package com.develogical;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class QueryProcessorTest {

  QueryProcessor queryProcessor = new QueryProcessor();

  @Test
  public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
    assertThat(queryProcessor.process("test"), is(""));
  }

  @Test
  public void knowsAboutShakespeare() throws Exception {
    assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
  }

  @Test
  public void knowsWhatYourNameIs() throws Exception {
    assertThat(queryProcessor.process("What is your name?"), containsString("KushTeam"));
  }

  @Test
  public void knowsAddition () {
    assertThat(queryProcessor.process("what is 5 plus 3?"), containsString("8"));
  }

  @Test
  public void knowsFollowingLargestNumber() {
    assertThat(queryProcessor.process("which of the following numbers is the largest: 1, 2, 3, 4?"), containsString("4"));
  }

  @Test
  public void knowsWhichValueIsBothASquareAndCube() {
    assertThat(queryProcessor.process("which of the following numbers is both a square and a cube: 1, 2, 3, 4?"), containsString("1"));
  }

  @Test
  public void knowsHowToMultiply() {
    assertThat(queryProcessor.process("What is 3 multiplied by 64?"), containsString("192"));
  }

  @Test
  public void knowsHowToMinus() {
    assertThat(queryProcessor.process("What is 3 minus 64?"), containsString("-61"));
  }

}
