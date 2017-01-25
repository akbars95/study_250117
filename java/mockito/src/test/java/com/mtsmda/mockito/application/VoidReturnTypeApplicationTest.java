package com.mtsmda.mockito.application;

import com.mtsmda.mockito.service.VoidReturnTypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.exceptions.misusing.NullInsteadOfMockException;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * Created by dminzat on 12/27/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class VoidReturnTypeApplicationTest {

    @Mock
    private VoidReturnTypeService voidReturnTypeService;

    @InjectMocks
    private VoidReturnTypeApplication voidReturnTypeApplication;

    @Test(expected = NullPointerException.class)
    public void test(){
        doThrow(new NullPointerException("text is null")).when(voidReturnTypeService).print(null);
        voidReturnTypeApplication.printText(null);
        verify(voidReturnTypeService).print(null);
    }

}