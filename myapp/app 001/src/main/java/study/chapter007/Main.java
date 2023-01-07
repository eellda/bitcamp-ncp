package study.chapter007;

// 문자열을 int, long, float, double 로 변환하기
public class Main {
  private static final String TO_INT = "453";
  private static final String TO_LONG = "45234223233";
  private static final String TO_FLOAT = "45.823F";
  private static final String TO_DOUBLE = "13.83423D";

  private static final String TO_INT_NEGATIVE = "-453";
  private static final String TO_LONG_NEGATIVE = "-45234223233";
  private static final String TO_FLOAT_NEGATIVE = "-45.823F";
  private static final String TO_DOUBLE_NEGATIVE = "13.83423D";

  private static final String WRONG_NUMBER = "452w";

  public static void main(String[] args) {
    Integer toInt1 = Integer.valueOf(TO_INT);
    int toInt2 = Integer.parseInt(TO_INT);
    Integer toIntNegative1 = Integer.valueOf(TO_INT_NEGATIVE);
    int toIntNegative2 = Integer.parseInt(TO_INT_NEGATIVE);

    Long toLong1 = Long.valueOf(TO_LONG);
    long toLong2 = Long.parseLong(TO_LONG);
    Long toLongNegative1 = Long.valueOf(TO_LONG_NEGATIVE);
    long toLongNegative2 = Long.parseLong(TO_LONG_NEGATIVE);

    Float toFloat1 = Float.valueOf(TO_FLOAT);
    float toFloat2 = Float.parseFloat(TO_FLOAT);
    Float toFloatNegative1 = Float.valueOf(TO_FLOAT_NEGATIVE);
    float toFloatNegative2 = Float.parseFloat(TO_LONG_NEGATIVE);

    Double toDouble1 = Double.valueOf(TO_DOUBLE);
    double toDouble2 = Double.parseDouble(TO_DOUBLE);
    Double toDoubleNegative1 = Double.valueOf(TO_DOUBLE_NEGATIVE);
    double toDoubleNegative2 = Double.parseDouble(TO_DOUBLE_NEGATIVE);

    System.out.println("\"" + TO_INT + "\"" + " as int is " + toInt1 + " and as Integer is " + toInt2);
    System.out.println("\"" + TO_INT_NEGATIVE + "\"" + " as int is " + toIntNegative1 + " and as Integer is " + toIntNegative2);
    System.out.println("\"" + TO_LONG + "\"" + " as long is " +  toLong1 + " and as Integer is " + toLong2);
    System.out.println("\"" + TO_LONG_NEGATIVE + "\"" + " as long is " + toLongNegative1 + " and as Integer is " + toLongNegative2);
    System.out.println("\"" + TO_FLOAT + "\"" + " as float is " + toFloat1 + " and as Integer is " + toFloat2);
    System.out.println("\"" + TO_FLOAT_NEGATIVE + "\"" + " as float is " + toFloatNegative1 + " and as Integer is " + toFloatNegative2);
    System.out.println("\"" + TO_DOUBLE + "\"" + " as double is " + toDouble1 + " and as Integer is " + toDouble2);
    System.out.println("\"" + TO_DOUBLE_NEGATIVE + "\"" + " as double is " + toDoubleNegative1 +" and as Integer is " + toDoubleNegative2);

    try {
      Integer toIntWrong1 = Integer.valueOf(WRONG_NUMBER);
    } catch (NumberFormatException e) {
      System.err.println(e);
    }

    try {
      int toIntWrong2 = Integer.parseInt(WRONG_NUMBER);
    } catch (NumberFormatException e) {
      System.err.println(e);
    }
  }

}
