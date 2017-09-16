//
// Calculations involving variables of differing types
//
public class MixedNumbers 
{
   public static void main(String[] args)
   {
      int inum = 27;
      double dnum;
      double decResult; 
      int intResult;
      decResult = inum / 5 + 10.5;
      System.out.println( decResult );
      decResult = inum / 5.0 + 10.5;
      System.out.println( decResult );
      decResult = (double) ( inum / 5 + 10.5 );
      System.out.println( decResult );
      decResult = (double) inum / 5 + 10.5;
      System.out.println( decResult );
      dnum = 13.75;
      intResult = (int) dnum * 100;
      System.out.println(intResult);
      intResult = (int) ( dnum * 100 );
      System.out.println( intResult );
      dnum = 4.35;
      intResult = (int) ( dnum * 100 );
      System.out.println( intResult );
      intResult = (int) Math.round( 4.35 * 100 );
      System.out.println( intResult );
   }
}
