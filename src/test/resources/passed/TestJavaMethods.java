public class TestJavaMethods {

  public void mathodOne(int num) {
    if (num > 0) {
      System.out.println("Number is positive");
    } else if (num < 0) {
      System.out.println("Number is negative");
    } else {
      System.out.println("Number is zero");
    }
  }

  public int MethodTwo(int[] array) {
    int sum = 0;
    for (int num : array) {
      sum += num;
    }
    return sum;
  }

  public void methodthree() {
    int i = 0;
    while (i < 5) {
      System.out.println("Iteration: " + i);
      i++;
    }
  }

  public String METHODFOUR(String[] array) {
    StringBuilder result = new StringBuilder();
    for (String str : array) {
      if (str.length() > 3) {
        result.append(str).append(", ");
      }
    }
    return result.toString();
  }
}
