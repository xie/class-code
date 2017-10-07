import static java.lang.Math.*;

public class MaxTemp{

  /** t1 and t2 are considered the same if Math.abs(t1-t2) < EPSILON */
  public static final double EPSILON = 0.1;


  /* add attributes as you need */
  public Temperature[] temperatures;






  /* ----------------------------------------------------
   * constructor
   * ----------------------------------------------------
   */

  public MaxTemp(Temperature[] t) {
    temperatures = t;
  }


  /* ----------------------------------------------------
   * getter
   * ----------------------------------------------------
   */

  public double[] getMax(){
    // - returns null if empty array was passed to constructor
    // - returns null if null was passed to constructor
    // - otherwise, returns an array of length 2 [max, count]
    //   where max is the maximum temperature (expressed in the Kelvin scale)
    //   of all Temperature objects passed to the constructor, and count
    //   is the number of times that temperature was present (in the input
    //   array of the constructor)

    double max = 0;
    double count = 0;

    if (temperatures.length == 0) {
      return null;
    }
    if (temperatures == null) {
      return null;
    }

    for (int i = 0; i < temperatures.length; i ++) {
      temperatures[i].setScale("K");
      System.out.println(temperatures[i].getTemp());
      if (temperatures[i].getTemp() > max) {
        max = temperatures[i].getTemp();
      }
    }

    for (int i = 0; i < temperatures.length; i ++) {
      if (Math.abs(max - temperatures[i].getTemp()) < EPSILON) {
        count ++;
      }
    }

    return new double[]{max, count};
  }


  /* OPTIONAL - use your main method to test your code */
  public static void main(String[] args){
     // testing code here is optional
  }
}
