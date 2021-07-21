package com.caden.productsAndCategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caden.productsAndCategories.models.Category;
import com.caden.productsAndCategories.models.Product;
import com.caden.productsAndCategories.repositories.CategoryRepository;
import com.caden.productsAndCategories.repositories.ProductRepository;

@Service 
public class TheService {
	@Autowired
	private CategoryRepository cRepo;
	@Autowired
	private ProductRepository pRepo;
	
	public Product createProduct(Product product) {
		return this.pRepo.save(product);
		
	}
	public Category createCategory(Category cat) {
		return this.cRepo.save(cat);
	}
	public Category getSingleCat(Long id) {
		return this.cRepo.findById(id).orElse(null);
	}
	public Product getSingleProduct(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	public List<Category> findCatNotInProd(Product product){
		return this.cRepo.findByProductsNotContains(product);
	}
	public List<Product> findProdNotInCat(Category category){
		return this.pRepo.findByCategoriesNotContains(category);
	}
	public void addCategoryToProduct(Product product, Category category) {
		List<Category> existingCats = product.getCategories();
		existingCats.add(category);
		this.pRepo.save(product);
	}
	public void addProductToCategory(Product product, Category category) {
		List<Product> existingProds = category.getProducts();
		existingProds.add(product);
		this.cRepo.save(category);
	}


}
