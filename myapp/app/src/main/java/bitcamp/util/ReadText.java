package bitcamp.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadText {
  public static void main(String[] args){
    try{
      File file = new File("/Users/sungminlee/git/bitcamp-ncp/myapp/app/board.csv");
      FileReader filereader = new FileReader(file);
      BufferedReader bufReader = new BufferedReader(filereader);
      String line = ",";
      while((line = bufReader.readLine()) != null){
        System.out.println(line);
      }
      bufReader.close();
    }catch (FileNotFoundException e) {
      // TODO: handle exception
    }catch(IOException e){
      System.out.println(e);
    }
  }
}
