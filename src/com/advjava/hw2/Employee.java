package com.advjava.hw2;
import java.util.Comparator;

/**
 * 
 * @author archana 
 * 
 * Employee class for holding employee details.
 *
 */
public class Employee implements Comparable<Employee> {

	String firstName;
	String LastName;
	int salary;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	/**
	 * checks only first name,this method is not used.
	 */
	public static final Comparator<Employee> firstNameComp = new Comparator<Employee>() {

		@Override
		public int compare(Employee o1, Employee o2) {
			return o1.firstName.compareTo(o2.firstName);
		}

	};

	/**
	 * checks the last name only, this method is not used.
	 */
	public static final Comparator<Employee> lastNameComp = new Comparator<Employee>() {

		@Override
		public int compare(Employee o1, Employee o2) {
			return o1.LastName.compareTo(o2.LastName);
		}

	};

	/**
	 * this method is used for sorting the employee objects
	 */
	public static final Comparator<Employee> NameComparator = new Comparator<Employee>() {

		@Override
		public int compare(Employee o1, Employee o2) {
			// check last name then first name for equals case
			int lastCmp = o1.LastName.compareTo(o2.LastName);
			return (lastCmp != 0 ? lastCmp : o1.firstName.compareTo(o2.firstName));

		}
	};

	/**
	 * checks for equality of the object. When user gives an input, it checks for
	 * the object in the array list and returns the emp object location
	
	@Override
	public int compareTo(Object o) {
		Employee toCompare = (Employee) o;
		int fName = this.getFirstName().compareTo(toCompare.getFirstName());
		int lName = this.getLastName().compareTo(toCompare.getLastName());
		if (fName == 0 && lName == 0) {
			// this object is equal to 2nd one
			return 0;
		} else if (lName > 0) {
			// this object is greater
			return 1;
		} else {
			return -1;
		}
	}
 */
	
	/**
	 * Prints the employee object.
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String employee = "Employee : " + firstName + "  " + LastName + "  " + salary;
		//System.out.println(employee);
		return employee.toString();
	}

	/**
	 * checks for equality of the object. When user gives an input, it checks for
	 * the object in the array list and returns the emp object location
	 */
	@Override
	public int compareTo(Employee o) {
		Employee toCompare = (Employee) o;
		int fName = this.getFirstName().compareTo(toCompare.getFirstName());
		int lName = this.getLastName().compareTo(toCompare.getLastName());
		if (fName == 0 && lName == 0) {
			// this object is equal to 2nd one
			return 0;
		} else if (lName > 0) {
			// this object is greater
			return 1;
		} else {
			return -1;
		}
	}

}
