//
// Use of String methods
//
public class StringMethods
{
   public static void main( String[] args )
   {
      String surName = "Smith";
      String foreName = "John";
      String fullName;
      int numChars;
      fullName = foreName + " " + surName;
      System.out.println(fullName);
      fullName = foreName.toUpperCase() + " "
                              + surName.toUpperCase();
      System.out.println(fullName);
      fullName = foreName.toLowerCase() + " "
                              + surName.toLowerCase();
      System.out.println(fullName);
      numChars = surName.length();
      System.out.println("The length of \"" + surName
               + "\" is " + numChars + " characters");
      fullName = foreName + " " + surName;
      surName = fullName.substring(5);
      System.out.println("The surname is " + surName);
      foreName = fullName.substring(0,4);
      System.out.println("The forename is " + foreName);
   }
}
