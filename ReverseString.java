// Rotate Array, reverse words in a String

public class ReverseString {
  public static void main(String[] args){
    ReverseString rs = new ReverseString();
    String output = rs.reverseUsingArray("Hello this is Qing Zhang");
    System.out.println(output);
    System.out.println(rs.reverseDirectly("Hello this is Qing Zhang"));
  }

  public String reverseDirectly(String inputStr) {
    String[] array = inputStr.split(" ");
    String begStr = "";
    String endStr = "";
    for (int i=0; i<array.length/2; i++) {
      begStr += array[array.length-i-1] + " ";
      endStr = array[i] + " " + endStr;
    }

    return begStr + array[array.length/2 + array.length % 2 - 1] + " " + endStr;
  }

  // split into string array, reverse and then construct the string again
  public String reverseUsingArray(String inputStr) {
    String[] array = inputStr.split(" ");
    reverseArray(array);

    String outputStr = "";
    for (int i=0; i<array.length - 1; i++) {
      outputStr += array[i] + " ";
    }
    outputStr += array[array.length -1];
    return outputStr;
  }

  public void reverseArray(String[] array) {
    for (int i=0; i<array.length/2; i++) {
      String temp = array[i];
      array[i] = array[array.length-i-1];
      array[array.length-i-1] = temp;
    }
  }

}
