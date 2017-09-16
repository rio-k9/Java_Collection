public class WhileLoop
{
   // Temperature conversion using while loop
   public static void main(String[] args)
   {
      int centTemp, fahTemp;
      centTemp = 0;
      while ( centTemp <= 20 )
      {
         fahTemp = ( centTemp * 9 ) / 5 + 32;
         System.out.println( centTemp 
             + " degrees C = "
             + fahTemp + " degrees F" );
         centTemp++;
      }
   }
}
