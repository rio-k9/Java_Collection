public class Q_1A {

    public static void main (String[] args)  {

        int inum  = 19;
        double dnum = 2.6;
        double result1 = (double) inum / 5 + dnum;
        double result2 = (double) ( inum %  3 + (1/2) * dnum) ;
        System.out.println(result2);

        double test= (double) (double)( 19%3 + (1/2) * 2.6);

        System.out.println("this is " + (19%3 +0.5 *2.6));

        String result3 = inum + "+" + dnum;
        StringBuffer buffer = new StringBuffer (result3) ;
        buffer.insert(2,"abc");
        System.out.println("This is the buffer === " + buffer.toString());
        String result4 = buffer.toString() ;
        buffer.replace (1, 4 , "to") ;
        String result5 = buffer.toString() ;

        System.out.println("This is the result4 === " + result5);

    }

}