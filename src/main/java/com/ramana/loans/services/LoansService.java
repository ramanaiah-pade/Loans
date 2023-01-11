package com.ramana.loans.services;

import com.ramana.loans.model.Loans;
import com.ramana.loans.payload.LoansRequest;
import com.ramana.loans.repositories.LoansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;

@Service
public class LoansService {

    @Autowired
    private LoansRepository loansRepository;

    public List<Loans> getAllLoansByCustomerId(int customerId){
        return loansRepository.findByCustomerIdOrderByStartDate(customerId);
    }

    public Loans createLoan(LoansRequest request) {
        Loans loan = new Loans(request.getCustomerId(), request.getStartDate()
                                ,request.getLoanType(), request.getTotalLoan(), request.getAmountPaid(), request.getOutstandingAmount()
                                , new Date());
        return loansRepository.save(loan);
    }
}
