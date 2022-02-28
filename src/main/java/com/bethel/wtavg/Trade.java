package com.bethel.wtavg;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class Trade {
    String productId;
    String tradeType;
    String account;
    float originalQty;
    float currentQty;
    float impliedFee;
    String tradeId;
    String profitCenter;
    float price;
    float tradeNotional;
}
