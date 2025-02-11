package com.develogical;

import java.util.ArrayList;
import java.util.List;

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
        String secondNumberWithoutQuestion = parts[4].replace("?", "");
        int second = Integer.parseInt(secondNumberWithoutQuestion);
        return Integer.toString(first + second);
    } else if (getLowerCase(query).contains("largest")) {
        String[] parts = getLowerCase(query).split(":");
        String[] numbers = parts[1].split(",");
        int max = Integer.MIN_VALUE;
        for (String number : numbers) {
            if (number.contains("?")) {
                number = number.replace("?", "");
            }
            int current = Integer.parseInt(number.trim());
            if (current > max) {
                max = current;
            }
        }
        return Integer.toString(max);
    } else if (getLowerCase(query).contains("square") && getLowerCase(query).contains("cube")) {
        String[] parts = getLowerCase(query).split(":");
        String[] numbers = parts[1].split(",");
        for (String number : numbers) {
            if (number.contains("?")) {
                number = number.replace("?", "");
            }
            int current = Integer.parseInt(number.trim());
            if (isSquareAndCube(current)) {
                return Integer.toString(current);
            }
        }
    } else if (getLowerCase(query).contains("multiplied")) {
        String[] parts = getLowerCase(query).split(" ");
        int first = Integer.parseInt(parts[2]);
        String secondNumberWithoutQuestion = parts[5].replace("?", "");
        int second = Integer.parseInt(secondNumberWithoutQuestion);
        return Integer.toString(first * second);
    } else if (getLowerCase(query).contains("minus")) {
        String[] parts = getLowerCase(query).split(" ");
        int first = Integer.parseInt(parts[2]);
        String secondNumberWithoutQuestion = parts[4].replace("?", "");
        int second = Integer.parseInt(secondNumberWithoutQuestion);
        return Integer.toString(first - second);
    } else if (getLowerCase(query).contains("primes")) {
        String[] parts = getLowerCase(query).split(":");
        String[] numbers = parts[1].split(",");
        List<Integer> primes = new ArrayList<>();
        for (String number : numbers) {
            if (number.contains("?")) {
                number = number.replace("?", "");
            }
            int current = Integer.parseInt(number.trim());
            if (isPrime(current)) {
                primes.add(current);
            }
        }
        return primes.toString();
    }
    return "";
  }

    private boolean isPrime(int current) {
        if (current <= 1) {
            return false;
        }
        for (int i = 2; i < current; i++) {
            if (current % i == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isSquareAndCube(int current) {
        return Math.sqrt(current) == Math.cbrt(current);
    }

    private static String getLowerCase(String query) {
    return query.toLowerCase();
  }
}
