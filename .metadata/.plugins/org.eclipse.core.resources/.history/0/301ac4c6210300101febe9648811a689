package jeroquest.boardgame;

import java.util.Random;

public class Dice {
  private static Random generator = new Random();
  
  public static void setSeed(long seed) {
    generator.setSeed(seed);
  }
  
  public static int roll() {
    return roll(6);
  }
  
  public static int roll(int sides) {
    return generator.nextInt(sides) + 1;
  }
  
  public static void testDice() {
    int TRIES = 1000000;
    double[] totals = { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D };
    int x;
    for (x = 0; x < 1000000; x++)
      totals[roll() - 1] = totals[roll() - 1] + 1.0D; 
    for (x = 0; x < 6; x++) {
      System.out.printf("%d: %f\n", new Object[] { Integer.valueOf(x), Double.valueOf(totals[x] / 1000000.0D) });
    } 
  }
}