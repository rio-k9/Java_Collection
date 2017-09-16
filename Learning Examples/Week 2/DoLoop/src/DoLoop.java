public class DoLoop
{
   // Temperature conversion using do loop
   public static void main(String[] args)
   {
      int centTemp, fahTemp;
      centTemp = 0;
      do
      {
         fahTemp = ( centTemp * 9 ) / 5 + 32;
         System.out.println( centTemp 
                      + " degrees C = "
                      + fahTemp + " degrees F" );
         centTemp++;
      } while ( centTemp <= 20 );
   }
}
