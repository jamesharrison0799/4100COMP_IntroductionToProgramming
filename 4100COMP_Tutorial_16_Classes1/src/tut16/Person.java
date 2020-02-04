package tut16;

public class Person {
	String name;
	int age;
	char sexType;
	
	public Person(String name, int age, char sexType) {
		this.name = name;
		this.age = age;
		this.sexType = sexType;
	}
	
	public void print() {
		System.out.printf("Name: %s, Age: %d, sexType: %s\n", name, age, sexType);
	}
	
	public static void main(String[] args) {
		Person person1 = new Person("Joe Blogs", 21, 'm');
		Person person2 = new Person("Sue White", 22, 'f');
		Person person3 = new Person("Ben Black", 23,'m');
		person1.print();
		person2.print();
		person3.print();
	}
}

