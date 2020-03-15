
public class HR {
	private Employee[] allEmployees;
	private int numOfEmployees;
	private Department[] allDepartments;
	private int numOfDepartments;
//============================================================================	
	public HR (int maxEmployees, int maxDepartments) {
		allEmployees =new Employee[maxEmployees];
		numOfEmployees=0;
		allDepartments=new Department[maxDepartments];
		numOfDepartments=0;
	}
//============================================================================		
	/*public Employee[] getAllEmployees() {
		return allEmployees;
	}*/
	/*public void setAllEmployees(Employee[] allEmployees) {
		this.allEmployees = allEmployees;
	}*/
	public int getNumOfEmployees() {
		return numOfEmployees;
	}
	public void setNumOfEmployees(int numOfEmployees) {
		this.numOfEmployees = numOfEmployees;
	}
	public Department[] getAllDepartments() {
		return allDepartments;
	}
	public void setAllDepartments(Department[] allDepartments) {
		this.allDepartments = allDepartments;
	}
	public int getNumOfDepartments() {
		return numOfDepartments;
	}
	public void setNumOfDepartments(int numOfDepartments) {
		this.numOfDepartments = numOfDepartments;
	}
//============================================================================	
	public String toString() {
		StringBuffer str=new StringBuffer();
		str.append("The company has "+numOfDepartments+" departments:\n");
		for(int i =0;i<numOfDepartments;i++)
			str.append(allDepartments[i].toString()+"\n");
		return str.toString();
	}
	public Department getDepartmentByName(String name) {
		for (int i =0;i<numOfDepartments;i++) 
			if(allDepartments[i].getName().equals(name))
				return allDepartments[i];
		return null;
	}
	public Employee getEmployeestByName(String name) {
		for (int i =0;i<numOfEmployees;i++) 
			if(allEmployees[i].getName().equals(name))
				return allEmployees[i];
		return null;
	}
	public boolean addDepartment(String name,int maxEmployees) {
		if (numOfDepartments==allDepartments.length)
			return false;
		allDepartments[numOfDepartments++]=new Department(name, maxEmployees);
		return true;
	}
	public boolean addEmployee(Employee theEmployee,String departmentName) {
		if(numOfEmployees==allEmployees.length)
			return false;
		Department theDepartment = getDepartmentByName(departmentName);
		if(theDepartment==null)
			return false;
		else {
			allEmployees[numOfEmployees]=new Employee(theEmployee);
			theDepartment.addEmployee(allEmployees[numOfEmployees]);
			numOfEmployees++;
			return true;
		}
		}
	}
	

