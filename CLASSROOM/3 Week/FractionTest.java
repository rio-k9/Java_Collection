
public class FractionTest {
	public static void main(String[] args) {
		Fraction a = new Fraction(1, 2);
		Fraction b = new Fraction(1, 3);
		Fraction c = a.add(b);
		Fraction d = a.subtract(b);
		
		a.output();
		System.out.print(" + ");
		b.output();
		System.out.print(" = ");
		c.output();
		System.out.println();

		a.output();
		System.out.print(" - ");
		b.output();
		System.out.print(" = ");
		d.output();
		System.out.println();

		Fraction a2 = new Fraction(3, 5);
		Fraction b2 = new Fraction(2, 3);
		Fraction c2 = a2.multiple(b2);
		Fraction d2 = a2.divide(b2);
		
		a2.output();
		System.out.print(" * ");
		b2.output();
		System.out.print(" = ");
		c2.output();
		System.out.println();
		
		a2.output();
		System.out.print(" / ");
		b2.output();
		System.out.print(" = ");
		d2.output();
		System.out.println();
	}
}
