package com.ramana.loans.payload;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class LoansRequest {
    private int customerId;
    private LocalDate startDate;
    private String loanType;
    private Double totalLoan;
    private Double amountPaid;
    private Double outstandingAmount;
}
