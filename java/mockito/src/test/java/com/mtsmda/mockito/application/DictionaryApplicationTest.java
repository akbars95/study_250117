package com.mtsmda.mockito.application;

import com.mtsmda.mockito.service.DictionaryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by dminzat on 12/27/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class DictionaryApplicationTest {

    @Mock
    private DictionaryService dictionaryService;

    @InjectMocks
    private DictionaryApplication dictionaryApplication;

    @Test
    public void test(){
        Mockito.when(dictionaryService.getMeaning("hello")).thenReturn("privet");
        Assert.assertEquals(dictionaryApplication.getMeaning("hello"), "privet");
    }

}