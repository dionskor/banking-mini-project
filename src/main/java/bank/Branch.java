package bank;

import java.util.ArrayList;

/**
 *  This class represents a Branch of the Bank.
 *  The branch has two fields:
 *  The string value of its name and the list of its customers.
*/
public class Branch {
	private String name;
	private ArrayList<Customer> customers;

	/**
	 * @param name
	 *  It initializes and sets the name of the bank.
	 *  Additionally it initializes the list of its customers
	 */
	public Branch(String name) {
		this.name = name;
		this.customers = new ArrayList<Customer>();
	}
	
	// This method returns the name of the Branch
	public String getName() {
		return name;
	}

	//This method returns the list of Customers
	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	/**
	 * This method checks if a customer with the same name already exists on the list
	 * If the name appears on the list the method exists and returns false
	 * Otherwise, it creates a new customer and returns true.
	 */
	public boolean newCustomer(String customerName, Double initialTransaction) {
		Customer customer = findCustomer(customerName);
		boolean succesfulAdd;
		if(customer !=null) {
			succesfulAdd=false;
		}else {
			System.out.println("Customer "+customerName+" does not exist");
			customer=new Customer(customerName, initialTransaction);
			this.customers.add(customer);
			succesfulAdd=true;
		}
		return succesfulAdd;
	}
	
	/**
	 * 	<
	 *  This method checks if a customer with the given name exists on the list.
	 *  If the name of the customer does not exist in the list, it returns false.
	 *  Otherwise, it adds the amount of the transaction and returns true. 
	 */
	public Boolean addCustomerTransaction(String customerName, Double transaction) {
		Customer customer = findCustomer(customerName);
		if(customer==null) {
			return false;
		}else {
			customer.addTransaction(transaction);
			return true;
		}
	}

	/**
	 * This method searches the list of customers by their name and returns 
	 * the corresponding object of the customer if it exists in the list. 
	 * Otherwise it returns null. 
	 */
	private Customer findCustomer(String name) {
		for (Customer customer : this.customers) {
			if (customer.getName().equals(name)) {
				return customer;
			}
		}
		return null;
	}

}
