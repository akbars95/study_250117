package com.mtsmda.mockito.application;

import com.mtsmda.mockito.service.VoidReturnTypeService;

/**
 * Created by dminzat on 12/27/2016.
 */
public class VoidReturnTypeApplication {

    private VoidReturnTypeService voidReturnTypeService;

    public void printText(String text) throws NullPointerException {
        voidReturnTypeService.print(text);
    }

}