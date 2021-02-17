package PageObject;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class CatalogPO {

    private String buttonBasketSelector = "//a[contains(@href, 'my/cart')]";

    public BasketPO goToBasket() {
            $(By.xpath(buttonBasketSelector)).click();
        return page(BasketPO.class);
    }

    public void putInBasket(String buttonSelector) {
        $(By.xpath(buttonSelector)).shouldBe(visible).click();
        $(By.xpath("//div[@class='b_2ll3z2LP8N b_39vchGP76M b_17HsszYfH8']//span/span")).shouldBe(appear);
    }

    public String getName(String nameProduct) {
        String resultName = $(By.xpath(nameProduct)).getText();
        return resultName;
    }

    public String getPrice(String priceProduct) {
        String resultPrice = $(By.xpath(priceProduct)).getText();
        return resultPrice;
    }
}
