package SchoolEx;

public class School {
	public enum eAddStudentStatus{Succeed,FailedCapacityFull, FailedStudentAlreadyRegistred};
	private Student[] allStudent;
	private int numOfStudent;
	public School() {
		allStudent=new Student[3];
		numOfStudent=0;
	}
	public String toString() {
		StringBuffer sb=new StringBuffer("there are "+ numOfStudent+ " student:\n");
		for(int i=0;i<numOfStudent;i++)
			sb.append(allStudent[i].toString()+"\n");
		return sb.toString();
	}
	public boolean canAddMoreStudents() {
		return numOfStudent<allStudent.length;
	}
	public eAddStudentStatus addStudent(Student s) {
		if(numOfStudent==allStudent.length)
			return eAddStudentStatus.FailedCapacityFull;
		for(int i=0;i<numOfStudent;i++) {
			if(allStudent[i].getName().equals(s.getName()))
				return eAddStudentStatus.FailedStudentAlreadyRegistred;
		}
		allStudent[numOfStudent++]=s;
		return eAddStudentStatus.Succeed;
	}
}
