package org.capco.domain;

import java.util.Collections;
import java.util.List;


public class Cart {
    private final Client client;
    private final List<Product> products;

    public Cart() {
        this.client = null;
        this.products = List.of();
    }

    public Cart(Client client, List<Product> products) {
        this.client = client;
        this.products = Collections.unmodifiableList(products);
    }

    public double compute(){
        return this.products.stream().mapToDouble(p -> p.getPriceBy(this.client)).sum();
    }
}
