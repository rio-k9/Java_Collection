public class GasBill 
{
   // Gas bill calculation
   public static void main( String[] args )
   {
      final double STANDING_CHARGE = 9.56;
      final double COST_OF_UNIT;
      double total;
      COST_OF_UNIT = 0.48;
      int units = 10;
      total = STANDING_CHARGE +  COST_OF_UNIT * units;
      System.out.println( "Total gas bill is "
                                     + total );
   }
}

