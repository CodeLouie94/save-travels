package com.louie.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louie.savetravels.models.Expense;
import com.louie.savetravels.repositories.ExpenseRepository;


@Service
public class ExpenseServices {

	@Autowired
	private ExpenseRepository expenseRepository;
    
    // returns all the books
    public List<Expense> allExpenses() {
        return expenseRepository.findAll();
    }
    // creates a book
    public Expense createExpense(Expense b) {
        return expenseRepository.save(b);
    }
    // retrieves a book
    public Expense findExpense(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            return null;
        }
    }

    public Expense updateExpense(Expense b) {
    	return expenseRepository.save(b);
    }
    
}


