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

import javafx.scene.image.Image;

public class Product {

	private String name;
	private double price;
	private boolean preowned;
	private String description;
	private int quantity;
	private Image imgRef;

	/**
	 * 
	 * @param name
	 * @param price
	 * @param description
	 * @param quantity
	 * @param imgRef
	 */
	


	public Product(String name, double price, boolean preowned, String description, int quantity, Image imgRef) {
		super();
		this.name = name;
		this.price = price;
		this.preowned = preowned;
		this.description = description;
		this.quantity = quantity;
		this.imgRef = imgRef;
	}

	public String getName() {
		return this.name;
	}
	
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	/**
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
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

	public int getQuantity() {
		return this.quantity;
	}

	/**
	 * 
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Image getImgRef() {
		return this.imgRef;
	}

	/**
	 * 
	 * @param imgRef
	 */
	public void setImgRef(Image imgRef) {
		this.imgRef = imgRef;
	}

	public boolean getPreowned() {
		return preowned;
	}

	public void setPreowned(boolean preowned) {
		this.preowned = preowned;
	}
	
	public int compareByName( Product product2) {
		int value = 0;
			
		String product2Name = product2.getName();
		if(getName().compareToIgnoreCase(product2Name) >0){
			value = 1;
		}else if(getName().compareToIgnoreCase(product2Name) <0){
			value = -1;
		} 
	    
		return value;
	}
	
	public int compareByPrice(Product product2) {
		int value = 0;
		
		double product2Price = product2.getPrice();
		if(getPrice() > product2Price){
			value = 1;
		}else if(getPrice() < product2Price){
			value = -1;
		} 
	    
		return value;
	}
	
	public int compareByQuantity(Product product2) {
		int value = 0;
		
		int product2Quantity = product2.getQuantity();
		if(getQuantity() > product2Quantity){
			value = 1;
		}else if(getQuantity() < product2Quantity){
			value = -1;
		} 
	    
		return value;
	}
	
	public Product clone() {
		Product other = new Product("", 0, false, "", 0, null);
		
		other.setName(getName());
		other.setPrice(getPrice());
		other.setPreowned(getPreowned());
		other.setDescription(getDescription());
		other.setQuantity(getQuantity());
		other.setImgRef(getImgRef());
		

		return other;
	}
	
	

} //end of class