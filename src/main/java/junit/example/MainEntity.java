package junit.example;

public final class MainEntity {

  public double devide(double a, double b) {
    if (b == 0) {
      throw new IllegalArgumentException("Argumetn b = 0");
    }


    try {
      Thread.sleep(10);
    } catch (InterruptedException ignored) {
    }

    return a / b;
  }


  public double multiply(int a, int b) {
    return a * b;
  }
}
