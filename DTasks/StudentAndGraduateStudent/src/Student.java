
public class Student {
	public String name;
	public static Integer degree;
	public Student(String name){
		this.name = name;
		degree = 1;
	}
	public String getName(){
		return name;
	}
	public static Integer getDegree(){
		return degree;
	}
	public Student getStudent(){
		return this;
	}
	public Student getGradStudent(){
		return new GraduateStudent(name);
	}
} //class Student
