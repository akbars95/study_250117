package com.mtsmda.mockito.application;

import com.mtsmda.mockito.service.ExceptionService;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by dminzat on 12/27/2016.
 */
public class ExceptionApplicationTest {

    @Mock
    private ExceptionService exceptionService;

    @InjectMocks
    private ExceptionApplication exceptionApplication;

    @Test(expected = Exception.class)
    public void testException() throws Exception {
        when(exceptionService.isException()).thenThrow(new Exception("exception"));
        System.out.println(exceptionApplication.isException());
    }

    @Test
    public void testExceptionNotCatch() throws Exception {
        try {
            when(exceptionService.isException()).thenThrow(new Exception("exception"));
            System.out.println(exceptionApplication.isException());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}