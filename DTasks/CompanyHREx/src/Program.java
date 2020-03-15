import java.util.Scanner;

public class Program {
	private static Scanner s=new Scanner (System.in);
	public static void main(String[] args) {
		final int EXIT=-1;
		int maxEmployees,maxDepartment;
		System.out.print("Enter max eployees --> ");
		maxEmployees=s.nextInt();
		System.out.print("Enter max departments --> ");
		maxDepartment=s.nextInt();
		HR theHR=new HR(maxEmployees,maxDepartment);
		int answer;
		do {
			System.out.println();
			System.out.println("Choose one of the following options: ");
			System.out.println("1) Add department");
			System.out.println("2) Add employees");
			System.out.println("3) Show all data");
			System.out.println("4) Change employee name");
			System.out.println(EXIT +") to exit");
			System.out.println("Enter your choise --> ");
			answer=s.nextInt();
			switch(answer) {
			case 1:
				readDepartments(theHR);
				break;
			case 2:
				readEmployees(theHR);
				break;
			case 3:
				System.out.println(theHR.toString());
				break;
			case 4:
				changeEmploueeName(theHR);
				break;
			case EXIT:
				System.out.println("Goodby");
			default:
				System.out.println("Invalid option");
				break;
			
			}
		}while(answer!=EXIT);
	}
//============================================================================
	public static void readDepartments(HR theHR) {
		Scanner s =new Scanner(System.in);
		boolean fContinue=true;
		do {
			String departmentName;
			int maxEmployees;
			System.out.println("Enter the name of department: ");
			departmentName=s.nextLine();
			System.out.println("Enter max employees: ");
			maxEmployees=s.nextInt();
			
			boolean res=theHR.addDepartment(departmentName,maxEmployees);
			if (res) {
				System.out.println("\nAdd another department? (Y/N) ");
				char answer=s.next().charAt(0);
				s.nextLine();
				if(answer=='n'||answer=='N') {
					fContinue=false;
				}
				else if (answer!='Y'&& answer!='y') {
					System.out.println("Invalid answer...");
				
				}
			}else {
					System.out.println("Can not add any more departments");
					fContinue=false;
				}
				
			
		}while(fContinue);
		
	}
//============================================================================	
	public static void readEmployees(HR theHR) {
		Scanner s =new Scanner(System.in);
		boolean fContinue=true;
		do {
			String employeeName, employeePhone,departmentName;
			System.out.println("Enter employee's name: ");
			employeeName=s.nextLine();
			System.out.println("Enter employee's pthone: ");
			employeePhone=s.next();
			System.out.println("Enter the employee's department");
			s.nextLine();
			departmentName=s.nextLine();
			boolean res=theHR.addEmployee(new Employee(employeeName,employeePhone), departmentName);
			if(res) {
				System.out.println("\nAdd another employee? (Y/N) ");
				char answer=s.next().charAt(0);
				s.nextLine();
				if(answer=='n'||answer=='N') {
					fContinue=false;
				}else if (answer!='Y'&& answer!='y') {
					System.out.println("Invalid answer..");
				}
			}else {
				System.out.println("Failed adding the employee "+"(ful capacity or department doesn't exist)");
				fContinue=false;
			}
			
		}while(fContinue);
		
	}
//============================================================================	
	public static void changeEmploueeName(HR theHR) {
		String name,newName;
		System.out.println("Enter name of employee to change: ");
		name=s.nextLine();
		Employee theEmployee=theHR.getEmployeestByName(name);
		if(theEmployee==null) {
			System.out.println("There is no employee with that name");
			return;
		}
		System.out.print("Enter new name: ");
		newName=s.nextLine();
		theEmployee.setName(newName);
		System.out.println("Name change succeed");
	}
	
}
