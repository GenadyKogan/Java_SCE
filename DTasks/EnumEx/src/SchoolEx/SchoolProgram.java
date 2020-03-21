package SchoolEx;

import java.util.Scanner;

public class SchoolProgram {
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		School theSchool=new School();
		boolean fContine=true;
		do {
			System.out.print("Add srudent? (Y/N) ");
			char answer = s.next().charAt(0);
			s.nextLine();
			if(answer=='n'||answer=='N') {
				fContine=false;
			}else if (answer!='y'&& answer!='Y') {
				System.out.println("Invalid answer...");
			}
			else {
				System.out.println("Enter stuent's name: ");
				String name=s.nextLine();
				System.out.println("Enter student's degree: ");
				Student.eDegree[] allDegree =Student.eDegree.values();
				for(int i=0;i<allDegree.length;i++) {
					System.out.println((allDegree[i].ordinal()+1)+") "+allDegree[i].name());
				}
				System.out.println("---> ");
				Student.eDegree theDegree = Student.eDegree.valueOf(s.nextLine());
				School.eAddStudentStatus res=theSchool.addStudent(new Student(name, theDegree));
				if (res==School.eAddStudentStatus.Succeed)
					System.out.println("Student is added successfully");
				else if (res==School.eAddStudentStatus.FailedStudentAlreadyRegistred)
					System.out.println("Student is already registred to the school");
				else {
					System.out.println("Failed adding the student, capacity is full");
					fContine=false;
				}
			}
			System.out.println();
		}while(fContine && theSchool.canAddMoreStudents());
		System.out.println(theSchool.toString());
	}
}
