package application;

import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import java.util.Random;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.input.KeyEvent;

public class DemoController {

	int x = 0;
	    @FXML
	    private ComboBox<String> myDropBox;

	    @FXML
	    private Label myLabel;

	    @FXML
	    private Button myButton2;
	   
	    @FXML
	    private Button myButton3;
	    
	    @FXML
	    private PieChart myPieChart;

	    @FXML
	    private TextField myTextField;

	    @FXML
	    private Button myButton1;

	    @FXML
	    void buttonOneClicked(ActionEvent event) {
//	    	System.out.println("Button one clicked");
	    	x++;
	    	myLabel.setText("Button One Clicked " + x + " times.");

	    }
	    @FXML
	    void buttonTwoClicked(ActionEvent event) {
	    	Random rand = new Random();
	    	PieChart.Data[] data = new PieChart.Data[5];
	    	data[0] = new PieChart.Data("zero", rand.nextInt(100));
	    	data[1] = new PieChart.Data("one", rand.nextInt(100));
	    	data[2] = new PieChart.Data("two", rand.nextInt(100));
	    	data[3] = new PieChart.Data("three", rand.nextInt(100));
	    	data[4] = new PieChart.Data("four", rand.nextInt(100));
	    	myPieChart.setData(FXCollections.observableArrayList(data));
	    }
	    
	    @FXML
	    void buttonThreeClicked(ActionEvent event) {
	    	myTextField.setText("");
	    }
	    @FXML
	    void keyTypedInTextField(KeyEvent event) {
	    	String textTyped = event.getCharacter();
	    	//String textTyped = myTextField.getText();
	    	myLabel.setText("Last typed: " + textTyped);
	    }
	    
	    @FXML
	    void initialize(){
	    	String[] values = {"Zero", "One", "Two", "Three", "Four", "NEW ITEM"};
	    	myDropBox.setItems(FXCollections.observableArrayList(values));
	    	myDropBox.getSelectionModel().selectedIndexProperty().addListener(
	    			new ChangeListener<Number>() {
	    				@Override
	    				public void changed(ObservableValue observable, Number oldValue, Number newValue) {
	    					int index = newValue.intValue();
	    					if (index >= 0) {
	    						myTextField.setText("Selected: " + values[index] + " (location: " + index +" )");
	    						
	    					}
	  
	    				} 
	    			} 
	    		);
	    			
	    }

	}

