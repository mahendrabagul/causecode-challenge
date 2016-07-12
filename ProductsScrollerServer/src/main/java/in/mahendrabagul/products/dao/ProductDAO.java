package in.mahendrabagul.products.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import in.mahendrabagul.products.bean.Product;
import in.mahendrabagul.products.bean.data.CommonConstants;

@Component
public class ProductDAO
{
	// Dummy database. Initialize with some dummy values.
	private static List<Product> products;
	{
		products = new ArrayList<>();
		Product product = null;
		for (int i = 1; i <= 2000; i++)
		{
			product = new Product(i + "", "Product" + i, "Mahendra" + i);
			products.add(product);
		}
	}

	public List<Product> list(int after)
	{
		if (after > products.size())
		{
			return null;
		}
		if ((after + CommonConstants.MAX_RECORDS.getEntityTimeLockOut()) > products.size())
		{
			int remaining = (after + CommonConstants.MAX_RECORDS.getEntityTimeLockOut()) - products.size();
			return products.subList(after, after + remaining);
		}
		return products.subList(after, after + CommonConstants.MAX_RECORDS.getEntityTimeLockOut());
	}

	public Product get(String id)
	{
		for (Product product : products)
		{
			if (product.getId().equals(id))
			{
				return product;
			}
		}
		return null;
	}
}