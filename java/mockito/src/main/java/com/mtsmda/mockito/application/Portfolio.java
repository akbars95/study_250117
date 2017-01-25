package com.mtsmda.mockito.application;

import com.mtsmda.mockito.domain.Stock;
import com.mtsmda.mockito.service.StockService;

import java.util.List;

/**
 * Created by dminzat on 12/26/2016.
 */
public class Portfolio {

    private StockService stockService;
    private List<Stock> stocks;

    public StockService getStockService() {
        return stockService;
    }

    public void setStockService(StockService stockService) {
        this.stockService = stockService;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public double getMarkerValue(){
        double marketValue = 0D;
        for(Stock stockCurrrent : stocks){
            marketValue += stockService.getPrice(stockCurrrent) * stockCurrrent.getQuantity();
        }
        return marketValue;
    }

}