package com.bethel.wtavg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataLoader {
    private static DataLoader dataLoader = null;

    public static DataLoader getInstance(){
        if ( dataLoader == null ) dataLoader = new DataLoader();

        return dataLoader;
    }

    public List<Trade> loadTradeData(String productId, int totalRows){
        List<Trade> trades = new ArrayList<>(totalRows);

        for ( int i=0; i<totalRows;i++ ){
            Trade trade = Trade
                    .builder()
                    .productId(productId)
                    .currentQty(90)
                    .tradeId("Trade-Id-"+i)
                    .account("Account-"+i)
                    .impliedFee( randFloat(2,10))
                    .profitCenter("TEST")
                    .price(randFloat(60, 200))
                    .build();

            trade.setTradeNotional(trade.getCurrentQty()*trade.getPrice());
            trades.add(trade);
        }

        return trades;
    }

    public static float randFloat(float min, float max) {

        Random rand = new Random();

        return rand.nextFloat() * (max - min) + min;

    }

}
