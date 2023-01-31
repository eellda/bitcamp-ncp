package bitcamp.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class BinaryDecoder {

  public static int readInt(InputStream in) throws Exception {
    int value = 0;
    value  = in.read() << 24;
    value  |= in.read() << 16;
    value  |= in.read() << 8;
    value  |= in.read();
    return value;
  }

  public static boolean readBoolean(InputStream in) throws Exception {
    return in.read() == 1 ? true : false;
  }

  public static String readString(InputStream in) throws Exception {
    // [2byte: 문자열의 바이트 배열 길이][n바이트: 문자열의 바이트 배열]
    int length = in.read() << 8;
    length |= in.read();
    byte[] bytes = new byte[length];
    in.read(bytes, 0, length);
    String str = new String(bytes);

    return str;
  }

  public static char readChar(InputStream in) throws Exception {

    int ch1 = in.read();
    int ch2 = in.read();
    if ((ch1 | ch2) < 0)
      throw new Exception();
    return (char) ((ch1 << 8) + ch2);
  }

  public static byte readByte(InputStream in) throws Exception {
    return (byte)in.read();
  }

  //  public static String read(InputStream in) throws Exception {
  //    StringBuilder builder = new StringBuilder();
  //    char c;
  //    while ((c = readChar(in)) != 0)
  //      builder.append(c);
  //    return builder.toString();
  //  }

  public static void main(String[] args) throws Exception {

    // 데이터가 저장된 바이트 배열 준비
    byte[] bytes = new byte[] {0x00, 0x05, (byte)0x41, (byte)0x42, (byte)0xea, (byte)0xb0, (byte)0x80};

    // 바이트 배열에서 데이터를 읽는 도구 준비
    ByteArrayInputStream in = new ByteArrayInputStream(bytes);

    // 바이트 배열을 읽어서 String을 리턴 받는다.
    String str = BinaryDecoder.readString(in);

    // 잘읽었는지 출력해 본다.
    System.out.println(str);

    in.close();
  }
}









