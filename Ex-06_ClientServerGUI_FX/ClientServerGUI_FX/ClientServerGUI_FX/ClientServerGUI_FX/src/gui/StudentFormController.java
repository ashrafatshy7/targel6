package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import client.ClientUI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ComboBoxBase;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logic.Faculty;
import logic.Student;

public class StudentFormController implements Initializable {
	private Student s;
		
	@FXML
	private Label lblID;
	@FXML
	private Label lblName;
	@FXML
	private Label lblSurname;
	@FXML
	private Label lblFaculty;
	
	@FXML
	private TextField txtID;
	@FXML
	private TextField txtName;
	@FXML
	private TextField txtSurname;
	
	@FXML
	private Button btnclose=null;
	@FXML
	private Button btnsave=null;
	
	@FXML
	private ComboBox cmbFaculty;	
	
	ObservableList<String> list;
		
	public void loadStudent(Student s1) {
		this.s=s1;
		this.txtID.setText(s.getId());
		this.txtName.setText(s.getPName());
		this.txtSurname.setText(s.getLName());		
		this.cmbFaculty.setValue(s.getFc().getFName());
	}
	
	// creating list of Faculties
	private void setFacultyComboBox() {
		ArrayList<String> al = new ArrayList<String>();	
		al.add("ME");
		al.add("IE");
		al.add("SE");

		list = FXCollections.observableArrayList(al);
		cmbFaculty.setItems(list);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {	
		setFacultyComboBox();		
	}
	
	
	public void prevPage(ActionEvent event) throws Exception {
		Stage primaryStage = new Stage();
		((Node)event.getSource()).getScene().getWindow().hide();
		Parent root = FXMLLoader.load(getClass().getResource("/gui/AcademicFrame.fxml"));
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/gui/AcademicFrame.css").toExternalForm());
		primaryStage.setTitle("Academic Managment Tool");
		primaryStage.setScene(scene);
		
		primaryStage.show();	
		
	}
	
	
	public void Save(ActionEvent event) throws Exception {
		String id = txtID.getText();
		String name = txtName.getText();
		String surname = txtSurname.getText();
		String faculty = (String) cmbFaculty.getValue();
		String obj = "Save "+id+" "+name+" "+surname+" "+ faculty; 
		ClientUI.chat.accept(obj);
	}
	
}
