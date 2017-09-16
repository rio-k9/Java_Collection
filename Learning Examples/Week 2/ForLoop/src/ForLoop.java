public class ForLoop
{
   // Temperature conversion using for loop
   public static void main(String[] args)
   {
      int centTemp, fahTemp;
      for ( centTemp = 0; centTemp <= 20; centTemp++ )
      {
         fahTemp = ( centTemp * 9 ) / 5 + 32;
         System.out.println( centTemp 
                      + " degrees C = "
                      + fahTemp + " degrees F" );
      }
   }
}
