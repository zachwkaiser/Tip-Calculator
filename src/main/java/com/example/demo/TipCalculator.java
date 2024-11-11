/**
 * Name: Zach Kaiser
 * Purpose: Driver for the TipCalculator app
 * Date: 11/8/2024
 * CSC331-001
 */


package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TipCalculator extends Application{
	@Override
	public void start(Stage stage) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("TipCalculator.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("TipCalculator");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}