import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    while ((line = in.readLine()) != null) {
      System.out.println("input: "+line);
      char[] inputArray = line.toCharArray();
    
      String result = Main.convertToEnglishNumber(inputArray, "");
      System.out.println(result);
    
    }
    
  }
  
  public static String convertToEnglishNumber(char[] inputArray, String result) {

   switch (inputArray.length) {
     case 1:       
       result = result + handleSingleDigit(inputArray, 0);
       break;
     case 2: 
      result = result + handleTwoDigit(inputArray, 0);
        break;  
     case 3:
        result = handleHundreds(inputArray, 0);
        break;
     case 4:
        result = handleThousands(inputArray, 0);
        break;
      case 5:
        result = handleTwoDigit(inputArray, 0) +"Thousands"+handleHundreds(inputArray, 2);
        break;
      case 6:
        result = handleHundreds(inputArray, 0) +"Thousands"+handleHundreds(inputArray, 3);
        break;
      case 7:
        result = handleSingleDigit(inputArray, 0) +"Million"+handleHundreds(inputArray, 1) + handleThousands(inputArray, 3);
        break;
      case 8:
        result = handleTwoDigit(inputArray, 0) +"Million"+handleHundreds(inputArray, 2) + handleThousands(inputArray, 4);
        break;
      case 9:
        result = handleHundreds(inputArray, 0) +"Million"+handleHundreds(inputArray, 3) + handleThousands(inputArray, 5);
        break;
      default: System.out.println("not valid:"+inputArray.length);
        break;

   }
    
    return result +"Dollars";
  }

  public static String handleThousands(char[] inputArray, int index) {
    String result = handleSingleDigit(inputArray, index);
    if (result.length() > 0) {
      result += "Thousands";
    }
    return result+handleHundreds(inputArray, index + 1);
  }

  public static String handleHundreds(char[] inputArray, int index) {
    String result = handleSingleDigit(inputArray, index);
    if (result.length() > 0) {
      result += "Hundred";
    }
    return result+handleTens(inputArray, index + 1);
  }


  public static String handleTens(char[] inputArray, int index) {
    String output = "";

    switch (inputArray[index]) {
      case '1': output = "Ten"; break;
      case '2': output = "Twenty"; break;
      case '3': output = "Thirty";  break;
      case '4': output = "Forty"; break;
      case '5': output = "Fifty"; break;
      case '6': output = "Sixty"; break;
      case '7': output = "Seventy"; break;
      case '8': output = "Eighty"; break;
      case '9': output = "Ninety"; break;
      default: 
        System.out.println("The ten digit number is: "+inputArray[index]);
    }
    return output + handleSingleDigit(inputArray, index + 1);
  }

  public static String handleTwoDigit(char[] inputArray, int index) {
    String output = "";
    String inputStr = new StringBuilder().append(inputArray[index]).append(inputArray[index+1]).toString();

    switch (Integer.parseInt(inputStr)) {
      case 10: output = "Ten"; break;
      case 11: output = "Eleven"; break;
      case 12: output = "twelve"; break;
      case 13: output = "Thirdteen";  break;
      case 14: output = "Forteen"; break;
      case 15: output = "Fifteen"; break;
      case 16: output = "Sixteen"; break;
      case 17: output = "Seventeen "; break;
      case 18: output = "Eighteen"; break;
      case 19: output = "Nineteen"; break;
      default: 
        output = handleTens(inputArray, index);
        break;
    }
    return output;
  }
  
  public static String handleSingleDigit(char[] inputArray, int index) {
    String output = "";

    switch (inputArray[index]) {
      case '0': output = ""; 
        if (inputArray.length == 1) {output = "Zero";} 
        break;
      case '1': output = "One"; break;
      case '2': output = "Two"; break;
      case '3': output = "Three";  break;
      case '4': output = "Four"; break;
      case '5': output = "Five"; break;
      case '6': output = "Six"; break;
      case '7': output = "Seven"; break;
      case '8': output = "Eight"; break;
      case '9': output = "Nine"; break;
      default: 
        System.out.println("The one digit number is: "+inputArray[0]);
    }
    return output;
  }
  

  
}
