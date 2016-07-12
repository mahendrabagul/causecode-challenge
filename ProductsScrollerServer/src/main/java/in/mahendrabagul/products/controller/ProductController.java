package in.mahendrabagul.products.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.mahendrabagul.products.bean.Product;
import in.mahendrabagul.products.dao.ProductDAO;

@RestController
public class ProductController
{

	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = "/products")
	public Map<String, List<Product>> getProducts(
			@RequestParam(value = "after", required = false, defaultValue = "0") int after)
	{
		HashMap<String, List<Product>> hashMap = null;
		List<Product> products = productDAO.list(after);
		if (products != null)
		{
			hashMap = new HashMap<String, List<Product>>();
			hashMap.put("children", products);
		}
		return hashMap;
	}

	@RequestMapping(value = "/products/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id") String id)
	{
		Product product = productDAO.get(id);
		return ResponseEntity.accepted().body(product);
	}
}