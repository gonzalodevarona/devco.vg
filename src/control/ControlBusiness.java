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
import java.time.LocalDate;
import java.util.GregorianCalendar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Business;


public class ControlBusiness extends VBox{
	
	Business business;
	

	@FXML private FXMLLoader fxmlLoader;
	@FXML private Menu modifyBusiness;
	
    @FXML
    private TextField nameBusiness;

    @FXML
    private TextField emailBusiness;

    @FXML
    private TextField phoneBusiness;

    @FXML
    private TextField addressBusiness;

    @FXML
    private TextField nitBusiness;

    @FXML
    private DatePicker openingDate;

    @FXML
    private Button saveBusiness;
    
    private Stage stage;


	
    	
    
    public ControlBusiness() {
		
	}
    
    




	public Stage getStage() {
		return stage;
	}






	public void setStage(Stage stage) {
		this.stage = stage;
	}






	public Business getBusiness() {
		return business;
	}




	public void setBusiness(Business business) {
		this.business = business;
		
	}


	public Menu getModifyBusiness() {
		return modifyBusiness;
	}

	public void setModifyBusiness(Menu modifyBusiness) {
		this.modifyBusiness = modifyBusiness;
	}






	@FXML
    public void modifyBusiness(ActionEvent e) {
    	try {
    		Parent root = FXMLLoader.load(getClass().getResource("../gui/viewBusiness.fxml"));

    		stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setResizable(false);
			stage.show();
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}

	


    @FXML
    public void saveBusiness(ActionEvent event) {
    	if (nameBusiness.getText().equalsIgnoreCase("") == false && addressBusiness.getText().equalsIgnoreCase("") == false && phoneBusiness.getText().equalsIgnoreCase("") == false) {
			business.setName(nameBusiness.getText());
			business.setAddress(addressBusiness.getText());
			business.setPhone(phoneBusiness.getText());
			business.setEmail(emailBusiness.getText());
			business.setNit(nitBusiness.getText());
			
			LocalDate ld = openingDate.getValue();
			int z = ld.getYear();
			int y = ld.getMonth().getValue();
			int x = ld.getDayOfMonth();
					
			GregorianCalendar gc = new GregorianCalendar(z, y,x);
			
			business.setBirthDate(gc);
			
			getStage().close();
			
		}

    }
    
    
	


} //end of class
