package com.ramana.loans.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class Loans {
    @Id
    @GenericGenerator(name = "loan_no", strategy = "com.ramana.loans.util.LoanIdGenerator")
    @GeneratedValue(generator = "loan_no")
    @Column(name = "loan_number")
    private Long loanNumber;
    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "loan_type")
    private String loanType;
    @Column(name = "total_loan")
    private Double totalLoan;
    @Column(name = "amount_paid")
    private Double amountPaid;
    @Column(name = "out_standing_amount")
    private Double outstandingAmount;
    @Column(name = "created_date")
    private Date createDate;

    public Loans(int customerId, LocalDate startDate, String loanType, Double totalLoan, Double amountPaid, Double outstandingAmount, Date createDate) {
        this.customerId = customerId;
        this.startDate = startDate;
        this.loanType = loanType;
        this.totalLoan = totalLoan;
        this.amountPaid = amountPaid;
        this.outstandingAmount = outstandingAmount;
        this.createDate = createDate;
    }
}
