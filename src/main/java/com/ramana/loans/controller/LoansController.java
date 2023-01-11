package com.ramana.loans.controller;

import com.ramana.loans.model.Loans;
import com.ramana.loans.payload.LoansRequest;
import com.ramana.loans.services.LoansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoansController {

    @Autowired
    private LoansService loansService;

    @GetMapping("/myLoans/{customerId}")
    public List<Loans> getAllLoansByCustomerId(@PathVariable("customerId") int customerId){
        return loansService.getAllLoansByCustomerId(customerId);
    }

    @PostMapping("/createLoan")
    public Loans createNewLoan(@RequestBody LoansRequest request){
        Loans loan = loansService.createLoan(request);
        return loan;
    }
}
