package bank;

import java.util.ArrayList;

/**
 *  Customer class
 *  
 *  This class represents a bank customer that is related to a branch
 *  It has a String field for the name and an ArrayList of Doubles that
 *	represent the custommer's Transactions 
 */
public class Customer {
	private String name;
	private ArrayList<Double> transactions;

	/**
	 * @param name
	 * @param initialTransaction
	 * 
	 * This constructor initiates and sets the name of the custommer
	 * while also initiates the Double list of transactions
	 * and adds the initial one.
	 */
	public Customer(String name, Double initialTransaction) {
		this.name = name;
		this.transactions = new ArrayList<Double>();
		this.transactions.add(initialTransaction);
	}

	// This method adds an a transaction to the list
	public void addTransaction(Double transaction) {
		this.transactions.add(transaction);
	}

	// This method returns the name of the Customer
	public String getName() {
		return name;
	}

	// This method returns the list of the transactions.
	public ArrayList<Double> getTransactions() {
		return transactions;
	}

}
