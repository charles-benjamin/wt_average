package com.bethel.wtavg;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
public class WtAvgRunner {
    public static void main(String args[]){
        DataLoader loader = DataLoader.getInstance();
        List<Trade> trades = loader.loadTradeData("TSLA", 10);
        log.info ("Running Wt Avg On - {}", trades);
        float wtAvg = computeWtAvg(trades);
        Trade trade = computeBestBorrow(trades);
        log.info("Wt. Average -> {}", wtAvg);
        log.info("best borrow - {} ", trade);
        trade = computeWorstBorrow(trades);
        log.info("worst borrow - {}", trade);
        computeWtAverage(trades);
    }

    private static void computeWtAverage(List<Trade> trades) {
        return;
    }

    private static Trade computeWorstBorrow(List<Trade> trades) {
        return trades.stream().max(Comparator.comparing(Trade::getImpliedFee)).orElseThrow(NoSuchElementException::new);
    }

    private static Trade computeBestBorrow(List<Trade> trades) {
        return trades.stream().min(Comparator.comparing(Trade::getImpliedFee)).orElseThrow(NoSuchElementException::new);
    }

    private static float computeWtAvg(List<Trade> trades) {

        float numerator = 0, denominator = 0;
        for (Trade trade : trades) {
            numerator = numerator + ( trade.tradeNotional * trade.impliedFee);
            denominator = denominator + trade.tradeNotional;

        }
        return numerator/denominator;
    }
}
