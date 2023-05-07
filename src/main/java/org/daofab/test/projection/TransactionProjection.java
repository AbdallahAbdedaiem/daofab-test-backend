package org.daofab.test.projection;


import java.math.BigDecimal;

public interface TransactionProjection {

    Long getId();

    String getSender();
    String getReceiver();

    BigDecimal getTotalAmount();

    BigDecimal getTotalPaidAmount();

}
