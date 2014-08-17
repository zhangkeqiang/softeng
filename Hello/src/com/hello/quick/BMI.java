package com.hello.quick;

import java.text.DecimalFormat; 
//import android.app.Activity;
//import android.os.Bundle;

/**
 *  BMI is a standard indicator
 *  change it 
 */
public class BMI {
	private double height;
	private double weight;
	private double bmi;
	private String strBMI;
	private int intAdvice;

	public BMI(double dbHeight, double dbWeight)
	{
		this.height = dbHeight/100;
		this.weight = dbWeight;
		bmi = weight/(height*height);

        if (bmi>25){
        	intAdvice= R.string.advice_heavy;
	    }else if(bmi<20){
	    	intAdvice = R.string.advice_light;
	    }else{
	    	intAdvice = R.string.advice_average;
	    } 				
	}
	
	public int getAdvice()
	{
		return intAdvice;
	}
	
	public double getBMI()
	{
		return bmi;
	}
	

}
