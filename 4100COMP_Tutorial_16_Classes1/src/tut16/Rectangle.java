package tut16;

public class Rectangle {

	double width;
	double height;

	public Rectangle() {
		this.width = 1;
		this.height = 1;
	}

	public Rectangle(double w, double h) {
		this.width = w;
		this.height = h;
	}

	public double area() {
		return width * height;
	}

	public void scale(double factor) {
		width = width * factor;
		height = height * factor;
	}

	// task2
	public Rectangle add(Rectangle r) {
		width += r.width;
		height += r.height;
		return new Rectangle(width, height);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Rectangle rectangle1 = new Rectangle();
		Rectangle rectangle2 = new Rectangle(2, 3);
		Rectangle rectangle3 = new Rectangle(4, 6);

		System.out.println(rectangle1.area());
		System.out.println(rectangle2.area());
		System.out.println(rectangle3.area());

		rectangle1.scale(4);
		rectangle2.scale(0.5);

		System.out.println(rectangle1.area());
		System.out.println(rectangle2.area());

		System.out.println("rectangle 1 + rectangle 2 = " + rectangle1.add(rectangle2).area());

	}

}
