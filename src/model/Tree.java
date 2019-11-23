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

public class Tree implements CrudExpense, CrudAccesory{

	private Accessory rootAccessory;
	private Expense rootExpense;
	
	
	public Tree() {
		super();
		this.rootAccessory = null;
		this.rootExpense = null;
	}
	
	public Accessory getRootAccessory() {
		return rootAccessory;
	}
	public void setRootAccessory(Accessory rootAccesory) {
		this.rootAccessory = rootAccesory;
	}
	public Expense getRootExpense() {
		return rootExpense;
	}
	public void setRootExpense(Expense rootExpense) {
		this.rootExpense = rootExpense;
	}
	
	//METHODS FOR EXPENSES

	@Override
	public void addExpense(Expense newExpense) {
		if (rootExpense == null) {
			setRootExpense(newExpense);
		} else {
			rootExpense.addExpense(newExpense);
			
		}
		
	}

	@Override
	public Expense searchExpenseByNumber(String theId) {
		//TODO
		return null;
	}

	@Override
	public Expense searchExpenseByDate(GregorianCalendar theDate) {
		Expense found = null;
		Expense root1 = getRootExpense();
		if (root1 != null) {
			Expense only4TheDate = new Expense("","",0,theDate);
			found = root1.searchExpenseByDate(only4TheDate);
		}
		
		return found;
	}
	
	
	
	//METHODS FOR ACCESSORY

	@Override
	public void addAccessory(Accessory newAccessory) {
		if (rootAccessory == null) {
			setRootAccessory(newAccessory);
		} else {
			rootAccessory.addAccessory(newAccessory);
			
		}
		
	}

	@Override
	public Accessory searchAccessoryByName(String theName) {
		Accessory found = null;
		Accessory root1 = getRootAccessory();
		if (root1 != null) {
			Accessory only4TheName = new Accessory(theName,0, false,"",0, null, "");
			found = root1.searchAccessoryByName(only4TheName);
		}
		
		return found;
	}

	

} //end of class
