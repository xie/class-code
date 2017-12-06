
public class Temperature{

  // names for the different temperature scales
  public static String[] scales = {"Celsius", "Fahrenheit", "Kelvin"};
  public int currentScale = 0;
  public double tempValue = 0;


  /* ----------------------------------------------------
   * constructors
   * ----------------------------------------------------
   */

  public Temperature(double temp){
    this.tempValue = temp;
    // - creates a temperature object with given value in Celsius
  }

  public Temperature(double temp, String scale){
    this.tempValue = temp;
    if (scale.equals(scales[0])||scale.equals("C")) {
      this.currentScale = 0;
    }
    if (scale.equals(scales[1])||scale.equals("F")) {
      this.currentScale = 1;
      this.tempValue = ((temp/1.8)-32);
    }
    if (scale.equals(scales[2])||scale.equals("K")) {
      this.currentScale = 2;
      this.tempValue = (temp - 273.15);
    }
  }

  /* ----------------------------------------------------
   * methods
   * ----------------------------------------------------
   */

  public char getScale(){
    if (currentScale == 1) {
      return 'F';
    }
    if (currentScale == 2) {
      return 'K';
    }
    return 'C';
  }

  public double getTemp(){
    if (this.currentScale == 1) {
      return ((this.tempValue*1.8)+32);
    }
    if (this.currentScale == 2) {
      return (this.tempValue+273.15);
    }
    return this.tempValue;
  }



  public void setScale(String scale){
    if (scale.equals(scales[0])||(scale.equals("C"))) {
      this.currentScale = 0;
      return;
    }
    if (scale.equals(scales[1])||(scale.equals("F"))) {
      this.currentScale = 1;
      return;
    }
    if (scale.equals(scales[2])||(scale.equals("K"))) {
      this.currentScale = 2;
      return;
    }
  }



  public void setTemp(double temp){
    if (currentScale == 0) {
      this.tempValue = temp;
    }
    if (currentScale == 1) {
      this.tempValue = ((temp/1.8)-32);
    }
    if (currentScale == 2) {
      this.tempValue = (temp - 273.15);
    }
  }

  public void setTemp(double temp, char scale){
    if (scale == 'C') {
      currentScale = 0;
      this.tempValue = temp;
    }
    if (scale == 'F') {
      currentScale = 1;
      this.tempValue = ((temp/1.8)-32);
    }
    if (scale == 'K') {
      currentScale = 2;
      this.tempValue = (temp - 273.15);
    }
  }

  public void setTemp(double temp, String scale){
    if (scale.equals(scales[0])||(scale.equals("C"))) {
      currentScale = 0;
      this.tempValue = temp;
    }
    if (scale.equals(scales[1])||(scale.equals("F"))) {
      currentScale = 1;
      this.tempValue = ((temp/1.8)-32);
    }
    if (scale.equals(scales[2])||(scale.equals("K"))) {
      currentScale = 2;
      this.tempValue = (temp - 273.15);
    }
  }








  /* do not change anything below this line */
  /* -------------------------------------- */

  /* string representation of object */
  public String temp(){
    return "" + this.getTemp() + this.getScale();
  }



  /* Override the toString() method                                */
  /* with this we will not need the temp() method from above       */
  /* we will cover this soon!                                      */
  /* you do not need to use this for this assignment!              */
  @Override
  public String toString(){
    return "" + this.getTemp() + this.getScale();
  }

}
