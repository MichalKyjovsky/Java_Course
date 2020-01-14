/* $Id$ */
package cz.cuni.mff.java.strings;

/* Co program vypise
 * a) Pain nebo Gain nebo Main - ruzne pri kazdem behu
 * b) vzdy Pain
 * c) vzdy Gain
 * d) vzdy Main
 * d) neco jineho
 * e) nelze prelozit
 */
public class Test01 {
  private static java.util.Random rnd = new java.util.Random();

  public static void main(String[] args) {
    StringBuffer word = null;
    int a = rnd.nextInt(3);
    switch (a) {
      case 1:  word = new StringBuffer("P");
      break;
      case 2:  word = new StringBuffer("G");
      break;
      default: word = new StringBuffer("M");
    }
    word.append('a');
    word.append('i');
    word.append('n');
    System.out.println(word);
  }
}
