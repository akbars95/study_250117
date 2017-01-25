package com.mtsmda.mockito.application;

import com.mtsmda.mockito.service.CalculatorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;

/**
 * Created by dminzat on 12/26/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTest {

    @InjectMocks
    private MathApplication mathApplication;

    @Mock
    private CalculatorService calculatorService;

    @Test
    public void testAdd() {
        when(calculatorService.add(50.0, 75.0)).thenReturn(50.0 + 75.0);
        assertTrue(mathApplication.add(50.0, 75.0) == 125.0);
        verify(calculatorService, times(1)).add(50.0, 75.0);
    }

    @Test
    public void testSubtract() {
        Map<Double, Double> mapSubtract = new LinkedHashMap<>();
        mapSubtract.put(90D, 25D);
        mapSubtract.put(901D, 75D);
        mapSubtract.put(9054D, 2625D);
        mapSubtract.put(5590D, 2230D);
        mapSubtract.put(550D, 230D);
        mapSubtract.forEach((key, value) -> {
            when(calculatorService.subtract(key, value)).thenReturn(key - value);
            assertTrue(mathApplication.subtract(key, value) == key - value);
        });
        verify(calculatorService, times(1)).subtract(90D, 25D);

        when(calculatorService.subtract(95, 72)).thenReturn(95 - 72D);
        when(calculatorService.subtract(95, 72)).thenReturn(95 - 72D);
        when(calculatorService.subtract(95, 72)).thenReturn(95 - 72D);
        when(calculatorService.subtract(95, 72)).thenReturn(95 - 72D);
        when(calculatorService.subtract(95, 72)).thenReturn(95 - 72D);
        when(calculatorService.subtract(95, 72)).thenReturn(95 - 72D);

        assertTrue(mathApplication.subtract(95, 72) == 95 - 72);
        assertTrue(mathApplication.subtract(95, 72) == 95 - 72);
        assertTrue(mathApplication.subtract(95, 72) == 95 - 72);
        assertTrue(mathApplication.subtract(95, 72) == 95 - 72);
        assertTrue(mathApplication.subtract(95, 72) == 95 - 72);

        verify(calculatorService, times(5)).subtract(95, 72D);

        verify(calculatorService, times(0)).subtract(90, 72D);
        verify(calculatorService, never()).subtract(90, 72D);

        when(calculatorService.multiply(95D, 20D)).thenReturn(95D * 20);

        verify(calculatorService, never()).multiply(95D, 20d);

        verify(calculatorService, atLeastOnce()).subtract(90D, 25D);

        when(calculatorService.divide(15., 25.)).thenReturn(15. / 25.);
        assertTrue(mathApplication.divide(15., 25.) == 15. / 25.);
        assertTrue(mathApplication.divide(15., 25.) == 15. / 25.);
        assertTrue(mathApplication.divide(15., 25.) == 15. / 25.);
        verify(calculatorService, atLeast(2)).divide(15., 25.);
        verify(calculatorService, atMost(3)).divide(15., 25.);
    }

    @Test(expected = RuntimeException.class)
    public void testDivide() {
        doThrow(new RuntimeException("Error")).when(mathApplication.divide(15.0, 7.5));
        assertTrue(mathApplication.divide(15., 7.5) == 15. / 7.5);
    }

    @Test
    public void testException() {
        try {
            doThrow(new Exception("Error")).when(mathApplication.divide(15.0, 7.5));
            assertTrue(mathApplication.divide(15., 7.5) == 15. / 7.5);
        } catch (Exception e) {
            System.out.println("message - " + e.getMessage());
            assertNotNull(e.getMessage());
        }
    }

    @Test
    public void testJavaCreateMockObject() {
        MathApplication mathApplication = new MathApplication();
        CalculatorService calculatorService = mock(CalculatorService.class);
        mathApplication.setCalculatorService(calculatorService);

        when(calculatorService.subtract(50., 80.)).thenReturn(50.0 - 80);
        assertTrue(mathApplication.subtract(50., 80.) == 50.0 - 80);
        verify(calculatorService).subtract(50., 80);
    }

    @Test
    public void testInOrder() {
        when(calculatorService.add(50.0, 80.5)).thenReturn(50 + 80.5);
        when(calculatorService.multiply(50.0, 80.5)).thenReturn(50 * 80.5);

        assertTrue(mathApplication.add(50., 80.5) == (50. + 80.5));
        assertTrue(mathApplication.multiply(50., 80.5) == 50. * 80.5);

//        assertTrue(mathApplication.multiply(50., 80.5) == 50. * 80.5);
//        assertTrue(mathApplication.add(50., 80.5) == (50. + 80.5));

        InOrder inOrder = inOrder(calculatorService);
        inOrder.verify(calculatorService).add(50., 80.5);
        inOrder.verify(calculatorService).multiply(50., 80.5);
    }

    @Test
    public void testCallback() {
        when(calculatorService.add(50.0, 80.5)).thenAnswer(invocation -> {
//            Object o = invocation.callRealMethod();
            System.out.println("getArguments - " + invocation.getArguments());
            System.out.println("getMethod - " + invocation.getMethod());
            System.out.println("getMock - " + invocation.getMock());
            return 50.0 + 80.5;
        });
        System.out.println(mathApplication.add(50., 80.5));

        assertTrue(mathApplication.add(50., 80.5) == (50.0 + 80.5));
        verify(calculatorService, times(2)).add(50., 80.5);
    }

    @Test
    public void testSpying() {
        MathApplication mathApplication = new MathApplication();
        Calculator calculator = new Calculator();
        CalculatorService calculatorService = spy(calculator);
        mathApplication.setCalculatorService(calculatorService);

        assertTrue(mathApplication.add(150., 17) == 150. + 17);
//        assertTrue(mathApplication.subtract(150., 17) == 150. - 17);
    }

    class Calculator implements CalculatorService {

        @Override
        public double add(double num1, double num2) {
            return num1 + num2;
        }

        @Override
        public double subtract(double num1, double num2) {
            throw new UnsupportedOperationException("Method not implemented yet!");
        }

        @Override
        public double multiply(double num1, double num2) {
            throw new UnsupportedOperationException("Method not implemented yet!");
        }

        @Override
        public double divide(double num1, double num2) {
            throw new UnsupportedOperationException("Method not implemented yet!");
        }
    }

    @Test
    public void testResetMockobject() {
        when(calculatorService.add(12., 95.)).thenReturn(12 + 95.);
        assertTrue(mathApplication.add(12., 95.) == 12 + 95.);
        verify(calculatorService, times(1)).add(12., 95.);
        reset(calculatorService);
        try {
            assertTrue(mathApplication.add(12., 95.) == 12 + 95.);
        } catch (Throwable e) {
            System.out.println(e.getMessage() + " _ " + e.getClass().getCanonicalName());
        }
    }

    @Test
    public void testDrivenDevelopment(){
        //given
        given(calculatorService.add(17., 18.)).willReturn(17.0 + 18);
        //when
        double add = mathApplication.add(17.0, 18.);
        //then
        assertTrue(add == 17. + 18);
    }

    @Test
    public void testTimeout(){
        when(calculatorService.add(12., 95.)).thenReturn(12 + 95.);
        assertTrue(mathApplication.add(12., 95.) == 12 + 95.);
        verify(calculatorService, timeout(10_000)).add(12., 95.);
        verify(calculatorService, timeout(1).times(1)).add(12., 95.);
    }

}