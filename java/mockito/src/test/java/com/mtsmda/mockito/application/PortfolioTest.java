package com.mtsmda.mockito.application;

import com.mtsmda.mockito.service.StockService;
import com.mtsmda.mockito.domain.Stock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by dminzat on 12/26/2016.
 */
public class PortfolioTest {

    private Portfolio portfolio;
    private StockService stockService;

    public static void main(String[] args) {
        PortfolioTest portfolioTest = new PortfolioTest();
        portfolioTest.setUp();
        System.out.println(portfolioTest.test() ? "OK" : "ERROR");
    }

    public void setUp(){
        portfolio = new Portfolio();
        stockService = mock(StockService.class);
        portfolio.setStockService(stockService);
    }

    public boolean test(){
        List<Stock> stocks = new ArrayList<>();
        Stock stockMicrosoft = new Stock("1", "Microsoft", 15);
        Stock stockGoogle = new Stock("2", "Google", 110);
        stocks.add(stockGoogle);
        stocks.add(stockMicrosoft);

        portfolio.setStocks(stocks);

        when(stockService.getPrice(stockMicrosoft)).thenReturn(10.0);
        when(stockService.getPrice(stockGoogle)).thenReturn(50D);

        double marketValue = portfolio.getMarkerValue();
        return marketValue == 5_650;
    }

}