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

package control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.Business;


public class ControlBusiness extends VBox{
	@FXML private TextField textField;
	
	Business business;

    public ControlBusiness() {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../gui/firstW.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);        
        try {
            fxmlLoader.load();
            loadChanges();
        } catch (IOException | ClassNotFoundException exception) {
            throw new RuntimeException(exception);
        }
    	
    }
    
    public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	@FXML
    protected void doSomething() {
        System.out.println("The button was clicked!");
    }
    
    
    public void saveChanges() throws FileNotFoundException, IOException {
    	if (business != null) {
    		File file = new File(getBusiness().getName());
    		
    		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
    		oos.writeObject(business);
    		oos.close();
		}
		
	}
	
	public boolean loadChanges() throws FileNotFoundException, IOException, ClassNotFoundException {
		boolean done = false;
		
		File file = new File("Gafas");
	
		if (file.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			this.business = (Business) ois.readObject();
			ois.close();
			done = true;
		}
		return done;
	}
    
    
	


} //end of class
