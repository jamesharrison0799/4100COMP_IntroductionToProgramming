package tutorial14;

public class Task1 {

	public static void main(String[] args) {
		
		//task 1
		System.out.println("sayHello()\n");
		sayHello();
		
		//task 2;
		System.out.println("\n\ntripleHello()\n");
		tripleHello();
		
		//Extra
		System.out.println("\n\nmultiHelo()\n");
		multiHello(20);
	}

	public static void sayHello() {
		System.out.println("Hello World!");
	}
	
	public static void tripleHello() {
		sayHello();
		sayHello();
		sayHello();
	}
	
	public static void multiHello(int times) {
		for(int i = 0; i<times;i++) {
			sayHello();
		}
	}
	
}
