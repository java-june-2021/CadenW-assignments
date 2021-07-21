package com.caden.productsAndCategories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.caden.productsAndCategories.models.Category;
import com.caden.productsAndCategories.models.Product;
import com.caden.productsAndCategories.services.TheService;

@Controller
public class HomeController {
	@Autowired
	private TheService tService;
	
	@GetMapping("/product/new")
	public String newProduct() {
		return "newProduct.jsp";
	}
	@GetMapping("/category/new")
	public String newCategory() {
		return "newCategory.jsp";
	}
	
	@PostMapping("/newCat")
	public String makeCategory(@RequestParam("cat") String category) {
		Category newCat = new Category();
		newCat.setName(category);
		this.tService.createCategory(newCat);
		return "redirect:/category/new";
		
	}
	@PostMapping("/newProduct")
	public String makeProduct(@RequestParam("name") String name, @RequestParam("desc") String desc, @RequestParam("price") Double price) {
		Product newProduct = new Product(name, desc, price);
		this.tService.createProduct(newProduct);
		return "redirect:/product/new";
		
	}
	@GetMapping("/{id}")
	public String showProduct(Model viewModel, @PathVariable("id") Long id) {
		Product productToShow = this.tService.getSingleProduct(id);
		viewModel.addAttribute("notInProd", this.tService.findCatNotInProd(productToShow));
		viewModel.addAttribute("product", productToShow);
		return "showProduct.jsp";
	}
	@GetMapping("/cat/{id}")
	public String showCategory(Model viewModel, @PathVariable("id") Long id) {
		Category catToShow = this.tService.getSingleCat(id);
		viewModel.addAttribute("notInCat", this.tService.findProdNotInCat(catToShow));
		viewModel.addAttribute("category", catToShow);
		return "showCategory.jsp";
	}
	@PostMapping("/addCatToProd/{id}")
	public String addCatToProd(@RequestParam("cats") Long id, @PathVariable("id") Long productId) {
		Product productToAddCatTo = this.tService.getSingleProduct(productId);
		Category categoryToAdd = this.tService.getSingleCat(id);
		this.tService.addCategoryToProduct(productToAddCatTo, categoryToAdd);
		return "redirect:/{id}";
	}
	@PostMapping("/addProdToCat/{id}")
	public String addProdToCat(@RequestParam("prod") Long id, @PathVariable("id") Long categoryId) {
		Product productToAddCatTo = this.tService.getSingleProduct(id);
		Category categoryToAdd = this.tService.getSingleCat(categoryId);
		this.tService.addProductToCategory(productToAddCatTo, categoryToAdd);
		return "redirect:/cat/{id}";
	}
}
