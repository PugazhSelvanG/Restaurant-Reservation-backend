package com.becoder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.becoder.model.Product;
import com.becoder.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;

	@Override
	public Product saveProduct(Product product) {

		return productRepo.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		return productRepo.findAll();
	}

	@Override
	public Product getProductById(Integer id) {
		return productRepo.findById(id).get();
	}

	@Override
	public String deleteProduct(Integer id) {
		Product product = productRepo.findById(id).get();

		if (product != null) {
			productRepo.delete(product);
			return "Product Delete Sucessfully";
		}

		return "Something wrong on server";
	}

	@Override
	public Product editProduct(Product p, Integer id) {

		Product oldProduct = productRepo.findById(id).get();

		oldProduct.setName(p.getName());
		oldProduct.setEmail(p.getEmail());
		oldProduct.setDate(p.getDate());
		oldProduct.setRestaurant(p.getRestaurant());
		oldProduct.setDate(p.getTime());
		oldProduct.setGuests(p.getGuests());

		return productRepo.save(oldProduct);
	}

}