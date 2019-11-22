/*
* ˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜
* ID
* UNIVERSIDAD ICESI (CALI-COLOMBIA)
* DEPARTAMENTO TIC - ALGORTIMOS Y PROGRAMACIÓN II
* FINAL PROJECT 
* @AUTHOR: GONZALO DE VARONA
* @LAST UPDATE DATE: 22 NOVEMBER 2019
* ˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜
*/

package model;

import java.util.GregorianCalendar;

public class Expense {

	private Expense rightExpense;
	private Expense leftExpense;
	private String numberOfSale;
	private String description;
	private double amount;
	private GregorianCalendar expenseDate;

	

	public Expense(String numberOfSale, String description, double amount, GregorianCalendar expenseDate) {
		super();
		this.numberOfSale = numberOfSale;
		this.description = description;
		this.amount = amount;
		this.expenseDate = expenseDate;
		this.leftExpense = null;
		this.rightExpense = null;
	}

	public String getNumberOfSale() {
		return this.numberOfSale;
	}

	/**
	 * 
	 * @param numberOfSale
	 */
	public void setNumberOfSale(String numberOfSale) {
		this.numberOfSale = numberOfSale;
	}

	public String getDescription() {
		return this.description;
	}

	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return this.amount;
	}

	/**
	 * 
	 * @param amount
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	public GregorianCalendar getExpenseDate() {
		return this.expenseDate;
	}

	/**
	 * 
	 * @param expenseDate
	 */
	public void setExpenseDate(GregorianCalendar expenseDate) {
		this.expenseDate = expenseDate;
	}

	public Expense getRightExpense() {
		return rightExpense;
	}

	public void setRightExpense(Expense rightExpense) {
		this.rightExpense = rightExpense;
	}

	public Expense getLeftExpense() {
		return leftExpense;
	}

	public void setLeftExpense(Expense leftExpense) {
		this.leftExpense = leftExpense;
	}
	
	

}
