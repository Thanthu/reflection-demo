package com.thanthu.exercises.objectsize;

public class Main {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		AccountSummary accountSummary = new AccountSummary("John", "Smith", (short)20, 100_000);
		ObjectSizeCalculator calculator = new ObjectSizeCalculator();
		System.out.println(calculator.sizeOfObject(accountSummary));

	}

	public static class AccountSummary {
		private final String firstname;
		private final String lastname;
		private final short address;
		private final int salary;

		public AccountSummary(String firstname, String lastname, short address, int salary) {
			this.firstname = firstname;
			this.lastname = lastname;
			this.address = address;
			this.salary = salary;
		}

	}

}
