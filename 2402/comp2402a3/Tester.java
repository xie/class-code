package comp2402a3;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class Tester {

  public static int testCount = 10000;

  public static double t = 0.015;

  // Handy for testing correctness now that we know A2Table works
  public static <T> boolean tableEquals(Table<T> t1, Table<T> t2) {
    if (t1.rows() != t2.rows()) return false;
    if (t1.cols() != t2.cols()) return false;
    for (int i = 0; i < t1.rows(); i++) {
      for (int j = 0; j < t2.cols(); j++) {
        T x1 = t1.get(i, j);
        T x2 = t2.get(i, j);
        if (x1 != null && x2 == null) return false;
        if (x1 == null && x2 != null) return false;
        if (x1 != null && !x1.equals(x2)) return false;
      }
    }
    return true;
  }


  public static boolean testPart1(Table<Integer> t) {

    for (int i = 0; i < 10; i++) {
      t.addRow(i);
    }
    for (int i = 0; i < 10; i++) {
      t.addCol(i);
    }

    for (int i = 0; i < t.rows(); i++) {
      for (int y = 0; y < t.cols(); y++) {
        t.set(i, y, 1);
      }
    }
      System.out.println(t);


    t.addCol(0);
    t.addCol(9);
    t.addCol(9);
    t.addCol(9);
    t.addCol(9);


    System.out.println(t);


    return true;
  }

  public static void testTable(Table<Integer> tab) {
    long start = System.nanoTime();
    boolean result = Tester.testPart1(tab);
    long stop = System.nanoTime();
    double elapsed = (stop-start)/1e9;
    System.out.println("testPart1 returns " + result + " in " + elapsed + "s"
                       + " when testing a " + tab.getClass().getName());
  }


  public static boolean testPart2(List<Integer> ell) {

    Stopwatch s = new Stopwatch();

    ell.add(0, 1);
    if (ell.get(0) != 1) {
      return false;
    }


    ell.remove(0);

    ell.add(0,0);
    ell.add(0,99);
    if (ell.get(0) != 99) {
      return false;
    }

    ell.remove(0);
    ell.remove(0);

    //add to end
    s.start();
    for (int i = 0; i < testCount; i++) {
    	ell.add(i, i);
      if (ell.get(i) != i) {
        return false;
      }
    }
    s.stop();
    if (s.elapsedSeconds() > t) {
    	return false;
    }

    System.out.println(ell);

    s.start();
    for (int i = 0; i < testCount; i++) {
      ell.remove(0);
    }
    s.stop();
    if (s.elapsedSeconds() > t) {
    	return false;
    }
    System.out.println(ell);

    for (int i = 0; i < testCount; i++) {
      ell.add(0, i);
    }

    for (int i = testCount-1; i >= 0; i--) {
      ell.remove(i);
    }


    //System.out.println(ell);

    ell.toString();

		return true;
	}

  public static void testDefaultList(List<Integer> ell) {
    long start = System.nanoTime();
    boolean result = Tester.testPart2(ell);
    long stop = System.nanoTime();
    double elapsed = (stop-start)/1e9;
    System.out.println("testPart1 returns " + result + " in " + elapsed + "s"
                       + " when testing a " + ell.getClass().getName());
  }

}
