package com.mtsmda.mockito.application;

import com.mtsmda.mockito.service.ExceptionService;

/**
 * Created by dminzat on 12/27/2016.
 */
public class ExceptionApplication {

    private ExceptionService exceptionService;

    public ExceptionApplication() {

    }

    public ExceptionApplication(ExceptionService exceptionService) {
        this.exceptionService = exceptionService;
    }

    public void setExceptionService(ExceptionService exceptionService) {
        this.exceptionService = exceptionService;
    }

    public boolean isException() throws Exception {
        return this.exceptionService.isException();
    }

}