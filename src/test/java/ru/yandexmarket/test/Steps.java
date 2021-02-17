package ru.yandexmarket.test;

import PageObject.BasketPO;
import PageObject.CatalogPO;
import PageObject.YandexMarketPO;
import com.codeborne.selenide.Configuration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import static com.codeborne.selenide.Selenide.open;

public class Steps {

    YandexMarketPO yandexMarketPO;
    CatalogPO catalogPO;
    BasketPO basketPO;

    String nameProduct;
    String costProduct;
    String nameProductInCart;
    String costProductInCart;

    private String priceSelector = "//div[@class='b_Sb6Nn1Adl7' and position()=2]//div[@class='b_3bZBOZx4nL']/span/span[1]";
    private String nameSelector = "//div[@class='b_Sb6Nn1Adl7' and position()=2]//div[@class='b_3JBXGbvG3w b_BwiWCn5vjp _brandTheme-default']/span";
    private String putInBasketSelector = "//div[@class='b_Sb6Nn1Adl7' and position()=2]//button";

    private String priceInBasketSelector = "//div[@data-auto=\"CartOffer\"]//div[@data-auto=\"price\"]/span/span[1]";
    private String nameInBasketSelector = "//span[@class='b_3l-uEDOaBN b_3HI9bFuzIj b_3HJsMt3YC_ b_1MLtFZArtE']/a[@href]";

    @BeforeEach
    public void option() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @Given("go to website {string}")
    public void go_to_website(String url) {
        yandexMarketPO = open(url, YandexMarketPO.class);
    }

    @When("go to catalog")
    public void go_to_catalog() {
        catalogPO = yandexMarketPO.goToCatalog();
    }

    @Then("save name second product on the home page")
    public void save_name_second_product_on_the_home_page() {
        nameProduct = catalogPO.getName(nameSelector);
    }

    @Then("save cost second product on the home page")
    public void save_cost_second_product_on_the_home_page() {
        costProduct = catalogPO.getPrice(priceSelector);
    }

    @Then("put second item in the cart")
    public void put_second_item_in_the_cart() {
        catalogPO.putInBasket(putInBasketSelector);
    }

    @Then("go to cart")
    public void go_to_cart() {
        basketPO = catalogPO.goToBasket();
    }

    @Then("compare the name of the item in the cart with the name on the main page")
    public void compare_the_name_of_the_item_in_the_cart_with_the_name_on_the_main_page() {
        nameProductInCart = basketPO.getName(nameInBasketSelector);
        Assertions.assertEquals(nameProduct, nameProductInCart, "Название товара на главной странице и в корзине не совпадают");
    }

    @Then("compare the cost of an item in the cart by its status on the home page")
    public void compare_the_cost_of_an_item_in_the_cart_by_its_status_on_the_home_page() {
        costProductInCart = basketPO.getPrice(priceInBasketSelector);
        Assertions.assertEquals(costProduct, costProductInCart, "Стоимость товара на главной странице и в корзине не совпадают");
    }

}
