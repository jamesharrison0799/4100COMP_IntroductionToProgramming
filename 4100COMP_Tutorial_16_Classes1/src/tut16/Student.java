package tut16;

public class Student {

	int id;
	String name;
	String course;
	int[] marks;
	
	public Student(int id, String name, String course, int[] marks) {
		this.id = id;
		this.name = name;
		this.course = course;
		this.marks = marks;
	}
	
	public int average() {
		int total = 0;
		for (int i = 0; i<marks.length; i++) {
			total += marks[i];
		}
		
		return total/marks.length;
	}
	
	
	public void print() {
		System.out.printf("ID: %d, NAME: %s, COURSE: %s, AVERAGE MARKS: %d \n", id,name,course,average());
	}
	
	public static void main(String[] args) {
		Student student1 = new Student(1234, "Joe Blogs", "Computer Studies", new int[]{67,55,78,72,50});
		Student student2 = new Student(2341, "Sue White", "Computer Science", new int[]{57,85,58,79,61});
		Student student3 = new Student(3412, "Ben Black", "Software Engineering", new int[]{71,45,66,70,51});
		
		student1.print();
		student2.print();
		student3.print();
	}

}
