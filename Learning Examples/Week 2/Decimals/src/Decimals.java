import java.text.NumberFormat;

public class Decimals
{
   public static void main(String[] args)
   {
 
      NumberFormat $formatDecimal = NumberFormat.getNumberInstance();
      $formatDecimal.setMinimumFractionDigits( 2 );
      $formatDecimal.setMaximumFractionDigits( 3 );
      double $inumber, $result;
      
      for ($inumber = 1; $inumber <= 8;  $inumber++ ){
    	  
    	 $result =  $inumber / 8;
         System.out.println($formatDecimal.format($result));
      }
   }
}

