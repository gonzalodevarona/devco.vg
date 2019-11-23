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


public class Business {

	private LinkedList linkedList;
	private Tree tree;
	private ArrayList<Client> clients;
	private ArrayList<Sale> sales;
	private String name;
	private String email;
	private String phone;
	private String address;
	private String nit;
	private GregorianCalendar birthDate;

	/**
	 * 
	 * @param name
	 * @param phone
	 * @param address
	 * @param email
	 * @param nit
	 * @param birthDate
	 */
	

	public Business(String name, String email, String phone, String address, String nit, GregorianCalendar birthDate) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.nit = nit;
		this.birthDate = birthDate;
		this.tree = null;
		this.linkedList = null;
		sales = new ArrayList<Sale>();
		clients = new ArrayList<Client>();
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

	public String getEmail() {
		return this.email;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return this.phone;
	}

	/**
	 * 
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return this.address;
	}

	/**
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	public String getNit() {
		return this.nit;
	}

	/**
	 * 
	 * @param nit
	 */
	public void setNit(String nit) {
		this.nit = nit;
	}

	public GregorianCalendar getBirthDate() {
		return this.birthDate;
	}

	/**
	 * 
	 * @param birthDate
	 */
	public void setBirthDate(GregorianCalendar birthDate) {
		this.birthDate = birthDate;
	}

	public LinkedList getLinkedList() {
		return linkedList;
	}

	public void setLinkedList(LinkedList linkedList) {
		this.linkedList = linkedList;
	}

	public Tree getTree() {
		return tree;
	}

	public void setTree(Tree tree) {
		this.tree = tree;
	}

	public ArrayList<Client> getClients() {
		return clients;
	}

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}

	public ArrayList<Sale> getSales() {
		return sales;
	}

	public void setSales(ArrayList<Sale> sales) {
		this.sales = sales;
	}
	
	
	
	
	
	//-------------------- METHODS FOR SALE --------------------
	
	public void addSale(Sale newSale) {
		sales.add(newSale);
	}
	
	public void eraseSale(Sale death) {
		sales.remove(death);
	}
	
	public void eraseAllSales() {
		sales.clear();
	}
	
	//BINARY SEARCH BY NUMBER OF SALE (ID)
	public Sale findSaleByNumber(String id) {
		Sale theOne = null;
		
		sortSalesByNumber();
		
		int begin = 0;
		int end = sales.size() -1;
		
		while (begin <= end && theOne == null) {
			int medium = (begin+end)/2;
			String id2Evaluate = sales.get(medium).getNumberOfSale();
			if(id2Evaluate.compareToIgnoreCase(id) == 0) {
				theOne = sales.get(medium); 
			} else if(id2Evaluate.compareToIgnoreCase(id) < 0) {
				begin = medium +1;
			} else {
				end = medium -1;
			}
		}
		
		return theOne;
	}
	
	//BINARY SEARCH BY DATE
	public Sale findSaleByDate(GregorianCalendar theDate) {
		Sale theOne = null;
		
		sortSalesByDate();
		
		int begin = 0;
		int end = sales.size() -1;
		
		while (begin <= end && theOne == null) {
			int medium = (begin+end)/2;
			GregorianCalendar date2Evaluate = sales.get(medium).getSaleDate();
			if(date2Evaluate.compareTo(theDate) == 0) {
				theOne = sales.get(medium); 
			} else if(date2Evaluate.compareTo(theDate) < 0) {
				begin = medium +1;
			} else {
				end = medium -1;
			}
		}
		
		return theOne;
	}
	
	
	//BUBBLE SORT 1
	public void sortSalesByNumber() {
		
		ArrayList<Sale> sorted = getSales();
		
		for (int i = sorted.size(); i > 0; i--) {
			for (int j = 1; j < i; j++) {
				
				if (sorted.get(j).compareByNumber( sorted.get(j-1)) < 0) {
					Sale temp = sorted.get(j);
					sorted.set(j, sorted.get(j-1)) ;
					sorted.set(j-1, temp) ;
				} 
			}
		}
		
		
		setSales(sorted);
	}
	
	//BUBBLE SORT 2
	public void sortSalesByDate() {
			
			ArrayList<Sale> sorted = getSales();
			
			for (int i = sorted.size(); i > 0; i--) {
				for (int j = 1; j < i; j++) {
					
					if (sorted.get(j).compareByDate( sorted.get(j-1)) < 0) {
						Sale temp = sorted.get(j);
						sorted.set(j, sorted.get(j-1)) ;
						sorted.set(j-1, temp) ;
					} 
				}
			}
			
			
			setSales(sorted);
		}
	
	
	
	
	
	//-------------------- METHODS FOR CLIENT --------------------
	


	public boolean addClient(Client newClient) throws NumberFormatException {
		boolean done = false;
		String theId = newClient.getId();
		
		
			int idN = Integer.parseInt(theId);
			if (findClientById(theId) == null) {
				clients.add(newClient);
				done = true;
			}
		
		return done;
		
	}
	
	public void eraseClient(Client death) {
		clients.remove(death);
	}
	
	public void eraseAllClients() {
		clients.clear();
	}
	
	//BINARY SEARCH BY ID
	public Client findClientById(String id) {
		Client theOne = null;
		
		sortClientsById();
		
		int begin = 0;
		int end = clients.size() -1;
		
		while (begin <= end && theOne == null) {
			int medium = (begin+end)/2;
			String id2Evaluate = clients.get(medium).getId();
			if(id2Evaluate.compareToIgnoreCase(id) == 0) {
				theOne = clients.get(medium); 
			} else if(id2Evaluate.compareToIgnoreCase(id) < 0) {
				begin = medium +1;
			} else {
				end = medium -1;
			}
		}
		
		return theOne;
	}
	
	//BINARY SEARCH BY LAST NAME
	public Client findClientByLastName(String lastName) {
		Client theOne = null;
		
		sortClientsByLastName();
		
		int begin = 0;
		int end = clients.size() -1;
		
		while (begin <= end && theOne == null) {
			int medium = (begin+end)/2;
			String lastName2Evaluate = clients.get(medium).getLastName();
			if(lastName2Evaluate.compareToIgnoreCase(lastName) == 0) {
				theOne = clients.get(medium); 
			} else if(lastName2Evaluate.compareToIgnoreCase(lastName) < 0) {
				begin = medium +1;
			} else {
				end = medium -1;
			}
		}
		
		return theOne;
	}
	
	
	
	//INSERTION SORT 1 
	public void sortClientsById(){
		ArrayList<Client> sorted = getClients();
		for (int i = 1; i < sorted.size(); i++) {
			for (int j = i; j > 0; j--) {
				
				if (sorted.get(j).compareById(sorted.get(j-1)) < 0) {
					Client temp = sorted.get(j);
					sorted.set(j, sorted.get(j-1)) ;
					sorted.set(j-1, temp) ;
				} 
			}
		}
		
		setClients(sorted);
	}
	
	//INSERTION SORT 2 
	public void sortClientsByLastName(){
		ArrayList<Client> sorted = getClients();
		for (int i = 1; i < sorted.size(); i++) {
			for (int j = i; j > 0; j--) {
				
				if (sorted.get(j).compareByLastName(sorted.get(j-1)) < 0) {
					Client temp = sorted.get(j);
					sorted.set(j, sorted.get(j-1)) ;
					sorted.set(j-1, temp) ;
				} 
			}
		}
		
		setClients(sorted);
	}
	
	

	
	
	

} //end of class