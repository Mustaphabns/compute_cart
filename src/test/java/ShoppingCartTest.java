import org.capco.domain.*;
import org.capco.domain.HighPhone;
import org.capco.domain.Laptop;
import org.capco.domain.LowPhone;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ShoppingCartTest {

    @Test
    void given_emptyCart(){
        //GIVEN
        Cart cart = new Cart();
        //WHEN
        double sum = cart.compute();
        //THEN
        assertThat(sum).isEqualTo(0);

    }


    @Test
    void given_cart_of_client_with_empty_product_list(){
        //GIVEN
        Client c = new IndividualClient(1, "bob");
        Cart cart = new Cart(c, List.of());
        //WHEN
        double sum = cart.compute();
        //THEN
        assertThat(sum).isEqualTo(0);
    }

    @Test
    void given_cart_of_individual_client_with_product_list(){
        //GIVEN
        Client c = new IndividualClient(1, "bob");
        Cart cart = new Cart(c, List.of(new HighPhone(), new LowPhone(), new Laptop()));
        //WHEN
        double sum = cart.compute();
        //THEN
        assertThat(sum).isEqualTo(3500);
    }

    @Test
    void given_cart_of_legal_client_with_high_profit_and_product_list(){
        //GIVEN
        Client c = new LegalClient(1, "BIG", 123, "BIG", 11_000_000);
        Cart cart = new Cart(c, List.of(new HighPhone(), new LowPhone(), new Laptop()));
        //WHEN
        double sum = cart.compute();
        //THEN
        assertThat(sum).isEqualTo(2450);
    }

    @Test
    void given_cart_of_legal_client_with_low_profit_and_product_list(){
        //GIVEN
        Client c = new LegalClient(2, "LOW", 123, "LOW", 9_000_000);
        Cart cart = new Cart(c, List.of(new HighPhone(), new LowPhone(), new Laptop()));
        //WHEN
        double sum = cart.compute();
        //THEN
        assertThat(sum).isEqualTo(2750);
    }
}
