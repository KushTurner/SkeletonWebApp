package com.develogical;

public class QueryProcessor {

  public String process(String query) {

    System.out.println("Received query:" + query);

    if (getLowerCase(query).contains("shakespeare")) {
      return "William Shakespeare (26 April 1564 - 23 April 1616) was an "
          + "English poet, playwright, and actor, widely regarded as the greatest "
          + "writer in the English language and the world's pre-eminent dramatist.";
    } else if (getLowerCase(query).contains("name")) {
      return "KushTeam";
    } else if (getLowerCase(query).contains("plus")) {
        String[] parts = getLowerCase(query).split(" ");
        int first = Integer.parseInt(parts[2]);
        int second = Integer.parseInt(parts[4]);
        return Integer.toString(first + second);
    } else if (getLowerCase(query).contains("largest")) {
        String[] parts = getLowerCase(query).split(":");
        String[] numbers = parts[1].split(",");
        int max = Integer.MIN_VALUE;
        for (String number : numbers) {
            int current = Integer.parseInt(number.trim());
            if (current > max) {
                max = current;
            }
        }
        return Integer.toString(max);
    }
    return "";
  }

  private static String getLowerCase(String query) {
    return query.toLowerCase();
  }
}
