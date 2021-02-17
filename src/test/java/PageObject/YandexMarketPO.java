package PageObject;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class YandexMarketPO {

    private String catalogSelector = "//a[@class='_1CD2dC53fk _3TMSxdxhdt']";

    public YandexMarketPO() {
    }

    public CatalogPO goToCatalog() {
        $(By.xpath(catalogSelector)).click();
        return page(CatalogPO.class);
    }

}
