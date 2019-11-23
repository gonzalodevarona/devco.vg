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

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Sale {

	private ArrayList<Product> saleProducts;
	private Client client;
	private String numberOfSale;
	private double amount;
	private GregorianCalendar saleDate;

	/**
	 * 
	 * @param numberOfSale
	 * @param amount
	 * @param saleDate
	 * @param client
	 */
	
	

	public String getNumberOfSale() {
		return this.numberOfSale;
	}

	public Sale(Client client, String numberOfSale, double amount, GregorianCalendar saleDate) {
		super();
		this.client = client;
		this.numberOfSale = numberOfSale;
		this.amount = amount;
		this.saleDate = saleDate;
		saleProducts = new ArrayList<Product>();
	}

	/**
	 * 
	 * @param numberOfSale
	 */
	public void setNumberOfSale(String numberOfSale) {
		this.numberOfSale = numberOfSale;
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

	public GregorianCalendar getSaleDate() {
		return this.saleDate;
	}

	/**
	 * 
	 * @param saleDate
	 */
	public void setSaleDate(GregorianCalendar saleDate) {
		this.saleDate = saleDate;
	}

	public Client getClient() {
		return this.client;
	}

	/**
	 * 
	 * @param client
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	public ArrayList<Product> getSaleProducts() {
		return saleProducts;
	}

	public void setSaleProducts(ArrayList<Product> saleProducts) {
		this.saleProducts = saleProducts;
	}

	public int compareByNumber(Sale sale2) {
		int value = 0;
		
		String saleId = sale2.getNumberOfSale();
		if(getNumberOfSale().compareToIgnoreCase(saleId) >0){
			value = 1;
		}else if(getNumberOfSale().compareToIgnoreCase(saleId) <0){
			value = -1;
		} 
	    
		return value;
	}

	public int compareByDate(Sale sale2) {
		
		int value = 0;
		
		GregorianCalendar sale2Date = sale2.getSaleDate();
    	if(getSaleDate().compareTo(sale2Date) > 0 ){
    		value = 1;
    	}else if(getSaleDate().compareTo(sale2Date) < 0){
    		value = -1;
    	} 
        
		return value;
		
	}
	
	

} //end of class
