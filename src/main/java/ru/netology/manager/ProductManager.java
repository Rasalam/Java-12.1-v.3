package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repositories = new ProductRepository();

    public ProductManager() {
    }

    public void add(Product product) {
        repositories.saveProduct(product);
    }

    public Product[] searchBy(String search) {
        Product[] result = new Product[0];
        for (Product product : repositories.getAllProduct()) {
            if (matches(product, search)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        return (product.getName().contains(search));

    }

    public Product[] findAll() {
        return repositories.getAllProduct();
    }

}
