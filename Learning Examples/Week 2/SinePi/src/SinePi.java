// Use of sin method and constant PI of the Math class
import java.lang.Math;
public class SinePi
{
   public static void main( String[] args )
   {
      int degrees = 30;
      double radians;
      radians = degrees * 2 * Math.PI / 360;
      System.out.println( Math.sin( radians ) );
   }
}
