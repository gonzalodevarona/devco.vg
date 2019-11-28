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

package devco.vg;

import static org.junit.jupiter.api.Assertions.*;

import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

import model.Business;
import model.Client;
import model.Sale;

class TestBusiness {
	
	Business business;
	
	//Create new business
	
	public void setupStage() {
		business = new Business("Gafas","gafas@hotmail.com","310123433","San Andresito Local 11","123456789",new GregorianCalendar(2005,6,12));
		
		Client alf = new Client("Alfonso","Restrepo","14829312","31782933","donde clara ines", "ossa@gmail.com");
		Sale sale = new Sale(alf,"000", 100000, new GregorianCalendar(2018,3,4));
		
		Client sami = new Client("Sami","Restrepo","100627812","31782933","donde clara ines", "ossa@gmail.com");
		Sale sale2 = new Sale(sami,"001", 100000, new GregorianCalendar(2018,3,4));
		
		Client ossa = new Client("Juan","Ossa","188612653","31782933","donde clara ines", "ossa@gmail.com");
		Sale sale3 = new Sale(ossa,"002", 100000, new GregorianCalendar(2018,3,4));
		
		Client capitan = new Client("Capitan","Y","127863812","31782933","donde clara ines", "ossa@gmail.com");
		Sale sale4 = new Sale(capitan,"001", 100000, new GregorianCalendar(2018,3,4));
		
		business.addSale(sale);
		business.addSale(sale2);
		business.addSale(sale3);
		business.addSale(sale4);
		
		business.addClient(alf);
		business.addClient(sami);
		business.addClient(ossa);
		business.addClient(capitan);
	}
		
		
	@Test
	void testAddClient() {
		setupStage();
		Client alf = new Client("Alfonso","Restrepo","14829312","31782933","donde clara ines", "ossa@gmail.com");
		
		if (business.addClient(alf) == true) {
			fail();
		}
		
	}
	
	@Test
	void testAddSale() {
		setupStage();
		Client alf = new Client("Alfonso","Restrepo","14829312","31782933","donde clara ines", "ossa@gmail.com");
		Sale sale = new Sale(alf,"000", 100000, new GregorianCalendar(2018,3,4));
		
		if (business.addSale(sale) == true) {
			fail();
		}
		
	}
	
	@Test
	void testEraseSale() {
		setupStage();
		Client alf = new Client("Alfonso","Restrepo","14829312","31782933","donde clara ines", "ossa@gmail.com");
		Sale sale = new Sale(alf,"000", 100000, new GregorianCalendar(2018,3,4));
		
		business.eraseSale(sale);
		assertTrue(business.getSales().size() == 3);
		
	}
	
	@Test
	void testEraseClient() {
		setupStage();
		Client alf = new Client("Alfonso","Restrepo","14829312","31782933","donde clara ines", "ossa@gmail.com");
		
		business.eraseClient(alf);
		//CHECK
		
	}

} //end of class
