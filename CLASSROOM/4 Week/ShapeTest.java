public class ShapeTest
{
	public static void main(String [] args)
	{
		Rectangle r1 = new Rectangle(150, 100, 250, 200);
		Rectangle r2 = new Rectangle(0, 0, 50, 50);
		System.out.println(r1 + "- area: " + r1.getArea() + " circ: " + r1.getCircumference());
		System.out.println(r2 + "- area: " + r2.getArea() + " circ: " + r2.getCircumference());
		Circle c = new Circle(300, 300, 150);
		System.out.println(c + "- area: " + c.getArea() + " circ: " + c.getCircumference());
		r2.move(50, 50);
		Combined c1 = new Combined(r1, r2);
		Combined c2 = new Combined(c1, c);
		System.out.println(c2 + "- area: " + c2.getArea() + " circ: " + c2.getCircumference());
	}
}
