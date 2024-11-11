/**
 * Name: Zach Kaiser
 * Purpose: Controller for the TipCalculator App
 * Date: 11/8/2024
 * CSC331-001
 */

package com.example.demo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class TipCalculatorController {
	private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
	private static final NumberFormat percent = NumberFormat.getPercentInstance();
	
	private BigDecimal tipPercentage = new BigDecimal(0.15);
	
    @FXML
    private Label tipPercentageLabel;

    @FXML
    private TextField amountTextField;

    @FXML
    private TextField tipTextField;

    @FXML
    private TextField totalTextField;

    @FXML
    private Slider tipPercentageSlider;

	@FXML
	private TextField amountOfPeopleTextField;

	@FXML
	private TextField amountPerPersonTextField;

    @FXML
    private void calculateButtonPressed(ActionEvent event) {
    	try {
    		BigDecimal amount = new BigDecimal(amountTextField.getText());
			BigDecimal amountOfPeople = new BigDecimal(amountOfPeopleTextField.getText());
			//^Edited to account for the amount of people that need to split the bill
    		BigDecimal tip = amount.multiply(tipPercentage);
    		BigDecimal total = amount.add(tip);
			BigDecimal amountPerPerson = total.divide(amountOfPeople);
			//^Edited to add another field that is calculated to divide the total by the number of people
    		
    		tipTextField.setText(currency.format(tip));
    		totalTextField.setText(currency.format(total));
			amountPerPersonTextField.setText(currency.format(amountPerPerson));
    	}
    	catch (NumberFormatException ex){
    		amountTextField.setText("Enter amount");
    		amountTextField.selectAll();
    		amountTextField.requestFocus();
    	}
    }

    public void initialize() {
    	currency.setRoundingMode(RoundingMode.HALF_UP);
    	
    	tipPercentageSlider.valueProperty().addListener(new ChangeListener<Number>() {
    		@Override
    		public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
    			tipPercentage = BigDecimal.valueOf(newValue.intValue() / 100.0);
    			tipPercentageLabel.setText(percent.format(tipPercentage));
    		}
    				
    	}
    	);
    }
}


