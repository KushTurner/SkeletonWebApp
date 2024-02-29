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
    assertThat(queryProcessor.process("what is 5 plus 3"), containsString("8"));
  }

  @Test
  public void knowsFollowingLargestNumber() {
    assertThat(queryProcessor.process("which of the following numbers is the largest: 1, 2, 3, 4"), containsString("4"));
  }

}
