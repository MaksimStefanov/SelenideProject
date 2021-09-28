package com.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class GummiesPage {


    @FindBy(id = "//h1[contains(.,'Gummies')]")
    private SelenideElement mainPageGummies;
    @FindBy(xpath = "//span[@class='btn btn-primary'][@data-name='Hair Care Panda Vegan Gummies']/strong")
    private SelenideElement buyNow;
    @FindBy(xpath = "//td[@class='name-cell'][contains(.,'Hair Care')]")
    private SelenideElement productInBasket;
    @FindBy(xpath = "//span[@class='price-container']")
    private SelenideElement buyNowHover;
    @FindBy(xpath = "//button[contains(.,'I understand')]")
    private SelenideElement annoyingConfirmation;
    @FindBy(xpath = "//strong[text()='My basket']")
    private SelenideElement myBasket;

    @Step
    public SelenideElement annoyingConfirmation() {
        return annoyingConfirmation;
    }

    @Step
    public SelenideElement mainPageGummies() {
        return mainPageGummies;
    }

    @Step
    public SelenideElement buyNowButton() {
        return buyNow;
    }

    @Step
    public SelenideElement verifyProductInBasket() {
        return productInBasket;
    }

    @Step
    public SelenideElement buyNowHover() {
        return buyNowHover;
    }

    @Step
    public BasketPage myBasketClick() {
        myBasket.click();
        return page(BasketPage.class);
    }
}
