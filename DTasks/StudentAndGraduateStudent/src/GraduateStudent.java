public class GraduateStudent extends Student{
	public String name;
	public GraduateStudent(String name) {
		super(name);
		degree = 2;
	}
	public void changeName(String name){
		this.name = name;
	}
	public static Integer getDegree(){
		degree+=1;
		return degree;
	}
	public Student getStudent(){
		name = name+"-san";
		return super.getStudent();
	}
} //class GraduateStuden