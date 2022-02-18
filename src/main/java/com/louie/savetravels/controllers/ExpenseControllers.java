package com.louie.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.louie.savetravels.models.Expense;
import com.louie.savetravels.services.ExpenseServices;

@Controller
public class ExpenseControllers {

	@Autowired
	ExpenseServices expenseService;

	@GetMapping("/")
	public String index(@ModelAttribute("expense") Expense expense, Model model) {
		List<Expense> allExpenses = expenseService.allExpenses();
		model.addAttribute("allExpenses", allExpenses);
		return "index.jsp";
	}

	@PostMapping("/expense/create")
	public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		}
		expenseService.createExpense(expense);
		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "/edit.jsp";
	}

	@PutMapping("/editProcess/{id}")
	public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if (result.hasErrors()) {
			return "/edit.jsp";
		} else {
			expenseService.updateExpense(expense);
			return "redirect:/";
		}
	}
}
