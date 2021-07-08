package bank;

import java.util.ArrayList;

/**
 * This class represents a Bank. The bank has a name and a list of its own
 * branches.
 **/
public class Bank {
	private String name;
	private ArrayList<Branch> branches;

	/**
	 * @param name
	 * @param branches The constructor initiates and sets the name of the bank and
	 *                 it initiates the list of its departments.
	 **/
	public Bank(String name) {
		this.name = name;
		this.branches = new ArrayList<Branch>();
	}

	/**
	 * This method adds checks if a Branch with the same name exists in the list If
	 * there is another branch with the same name, it exits and returns false
	 * Otherwise, it creates a new Branch and adds it to the list.
	 **/
	public boolean addBranch(String nameOfBranch) {
		Branch branch = findBranch(nameOfBranch);
		if (branch == null) {
			branch = new Branch(nameOfBranch);
			this.branches.add(branch);
			return true;
		}
		return false;
	}

	/**
	 * This method checks if a branch with the same name exists in the list. If the
	 * branch does not exist in the list of the branches or a customer with the same
	 * name already exists in that branch, it exits and returns false. Otherwise, it
	 * adds the customer to the corresponding branch and returns true.
	 **/
	public boolean addCustomer(String nameOfBranch, String nameOfCustomer, double initialTransaction) {
		Branch branch = findBranch(nameOfBranch);
		if (branch != null) {
			return branch.newCustomer(nameOfCustomer, initialTransaction);
		}
		return false;
	}

	/**
	 * This method checks the a branch and its customer with their corresponding
	 * names. If the branch or its customer does not exist in their corresponding
	 * lists, it exits and returns false. Otherwise it adds the transaction to the
	 * corresponding customer of the branch.
	 **/
	public boolean addCustomerTransaction(String nameOfBranch, String nameOfCustomer, double transaction) {
		Branch branch = findBranch(nameOfBranch);
		if (branch == null) {
			return false;
		}
		return branch.addCustomerTransaction(nameOfCustomer, transaction);
	}

	/**
	 * This method checks if the branch with the name that we've given exists on the
	 * list If the branch exists does not exist in the list it returns false.
	 * Otherwise, it prints out the list of the branch's customers and optionally,
	 * we can print each customer's transactions.
	 **/
	public boolean listCustomers(String nameOfBranch, boolean printTransactions) {
		Branch branch = findBranch(nameOfBranch);
		if (branch == null) {
			return false;
		}
		String branchName = branch.getName();
		String branchMessage = "Customer details for branch " + branchName;
		System.out.println(branchMessage);
		ArrayList<Customer> customers = branch.getCustomers();
		for (int i = 0; i < customers.size(); i++) {
			Customer customer = customers.get(i);
			String customerName = customer.getName();
			int counteri = i + 1;
			String customerMessage = "Custommer: " + customerName + "[" + counteri + "]";
			System.out.println(customerMessage);
			if (printTransactions) {
				ArrayList<Double> transactions = customer.getTransactions();
				for (int j = 0; j < transactions.size(); j++) {
					double transaction = transactions.get(j);
					int counterj = j + 1;
					String transactionMessage = "[" + counterj + "]" + " Amount " + transaction;
					System.out.println(transactionMessage);
				}
			}
		}
		return true;
	}

	/**
	 * This method searches the brand by name and returns it from the list.
	 */
	private Branch findBranch(String name) {
		for (Branch branch : this.branches) {
			if (branch.getName().equals(name)) {
				return branch;
			}
		}
		return null;
	}

}
