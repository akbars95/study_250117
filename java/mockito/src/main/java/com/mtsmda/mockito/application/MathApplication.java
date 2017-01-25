package com.mtsmda.mockito.application;

import com.mtsmda.mockito.service.CalculatorService;

/**
 * Created by dminzat on 12/26/2016.
 */
public class MathApplication {

    private CalculatorService calculatorService;

    public void setCalculatorService(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public double add(double num1, double num2) {
        /*try {
            Thread.currentThread().sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return this.calculatorService.add(num1, num2);
    }

    public double subtract(double num1, double num2) {
        return this.calculatorService.subtract(num1, num2);
    }

    public double multiply(double num1, double num2) {
        return this.calculatorService.multiply(num1, num2);
    }

    public double divide(double num1, double num2) {
        return this.calculatorService.divide(num1, num2);
    }

}