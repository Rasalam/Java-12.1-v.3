package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    ProductManager productManager = new ProductManager();

    public Book book1 = new Book(1, "Book", 530, "Chekhov");
    public Book book2 = new Book(2, "Book", 520, "Chekhov");
    public Book book3 = new Book(3, "Book", 500, "Gogol");
    public Book book4 = new Book(4, "Book", 550, "Pushkin");
    public Book book5 = new Book(5, "Book", 500, "Gogol");
    public Smartphone smartphone1 = new Smartphone(6, "Smartphone", 100000, "Apple");
    public Smartphone smartphone2 = new Smartphone(7, "Smartphone", 25000, "Xiaomi");
    public Smartphone smartphone3 = new Smartphone(8, "Smartphone", 10000, "Vivo");
    public Smartphone smartphone4 = new Smartphone(9, "Smartphone", 32000, "Samsung");
    public Smartphone smartphone5 = new Smartphone(10, "Smartphone", 40000, "Samsung");

    public void prepareProduct() {
        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);
        productManager.add(book4);
        productManager.add(book5);
        productManager.add(smartphone1);
        productManager.add(smartphone2);
        productManager.add(smartphone3);
        productManager.add(smartphone4);
        productManager.add(smartphone5);

    }

    @Test
        // должен вернуть пустой массив
    void shouldReturnZeroProductTest() {
        prepareProduct();
        String search = "iPad";
        Product[] expected = productManager.searchBy(search);
        Product[] actual = new Product[0];
        assertArrayEquals(expected, actual);

    }

    @Test
        // должен вернуть массив содержащий все книги
    void shouldReturnAllBookTest() {
        prepareProduct();
        String search = "Book";
        Product[] expected = productManager.searchBy(search);
        Product[] actual = new Product[]{book1, book2, book3, book4, book5};
        assertArrayEquals(expected, actual);
    }

    @Test
        // должен вернуть массив содержащий все смартфоны
    void shouldReturnAllSmartphoneTest() {
        prepareProduct();
        String search = "Smartphone";
        Product[] expected = productManager.searchBy(search);
        Product[] actual = new Product[]{smartphone1, smartphone2, smartphone3, smartphone4, smartphone5};
        assertArrayEquals(expected, actual);
    }

    @Test
        // Должен добавить 1 книгу
    void shouldAddOneBookTest() {
        prepareProduct();
        Book book6 = new Book(6, "Book", 500, "Chekhov");
        productManager.add(book6);
        Product[] expected = productManager.findAll();
        Product[] actual = new Product[]{book1, book2, book3, book4, book5, smartphone1, smartphone2, smartphone3, smartphone4, smartphone5, book6};
        assertArrayEquals(expected, actual);
    }

    @Test
        // Должен добавить 1 смартфон
    void shouldAddOneSmartphoneTest() {
        prepareProduct();
        Smartphone smartphone6 = new Smartphone(6, "Smartphone", 200000, "Apple");
        productManager.add(smartphone6);
        Product[] expected = productManager.findAll();
        Product[] actual = new Product[]{book1, book2, book3, book4, book5, smartphone1, smartphone2, smartphone3, smartphone4, smartphone5, smartphone6};
        assertArrayEquals(expected, actual);
    }

}