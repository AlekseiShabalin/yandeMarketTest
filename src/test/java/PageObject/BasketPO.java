package PageObject;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BasketPO {

    public String getName(String nameInBasketSelector) {
        String resultName = $(By.xpath(nameInBasketSelector)).getText();
        return resultName;
    }

    public String getPrice(String priceInBasketSelector) {
        String resultPrice = $(By.xpath(priceInBasketSelector)).getText();
        return resultPrice;
    }

}
