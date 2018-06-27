import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class InputNumberToEnglish {
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
    
      if (inputArray.length > 9) {
        System.out.println("Input is greater than 9 digits: "+line);
      } else {
        String result = InputNumberToEnglish.convertToEnglishNumber(inputArray, 0);
        System.out.println(result +"Dollars");
      }
    }
  }

  /*
    passin the input array, and index to determinate handle single, tends or hundreds 
    using remainder
    If in last 3 digits, handle and done
    If divisor is 1 or more, means in thousands, add the Word,
    advance index and handle rest by incursive
    if 
  */
  public static String convertToEnglishNumber(char[] inputArray, int index) {
    String output = "";
   int number = inputArray.length - index; 
   int wholeNumber = number / 3;
   int remainder  = number % 3;
   
   switch (remainder) {
    case 1: 
      output = handleSingleDigit(inputArray, index, wholeNumber);
      break;
    case 2: 
      output = handleTwoDigit(inputArray, index, wholeNumber); 
      break;
    case 0: 
      output = handleHundreds(inputArray, index, wholeNumber); 
      wholeNumber--;
      index += 3;
      break;
     default:
      System.out.println("invalid case of remainder:"+remainder + ", array length is:"+number);
   }
  
   if (number <= 3) {
     return output;
   }

    switch(wholeNumber) {
      case 1: 
        output += "Thousands";
        break;
      case 2: 
        output += "Millions"; 
        break;
      
  }
    output += convertToEnglishNumber(inputArray, index+remainder);
    return output;
  }



  // call for single digit and add hundred, advance the index and handle tens
  public static String handleHundreds(char[] inputArray, int index, int divisor) {
    String result = handleSingleDigit(inputArray, index, divisor);
      result += "Hundred";
    return result+handleTens(inputArray, index + 1, divisor);
  }

  // handle tends
  public static String handleTens(char[] inputArray, int index, int divisor) {
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
    return output + handleSingleDigit(inputArray, index + 1, divisor);
  }

  // handle two digits, under 20 or above, two cases
  public static String handleTwoDigit(char[] inputArray, int index, int divisor) {
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
        output = handleTens(inputArray, index, divisor);
        break;
    }
    return output;
  }
  
  public static String handleSingleDigit(char[] inputArray, int index, int divisor) {
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
