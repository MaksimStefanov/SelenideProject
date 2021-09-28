package com.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

public class BasketPage {

    @FindBy(xpath = "//span[@class='plus']")
    private SelenideElement plusButton;
    @FindBy(xpath = "//input[@readonly='readonly']")
    private SelenideElement quantity;
    @FindBy(xpath = "//td[@class='text-center biger-text hidden-xs']/a")
    private SelenideElement deleteButton;
    @FindBy(xpath = "//span[contains(.,'Your shopping cart is empty')]")
    private SelenideElement emptyCart;
    @FindBy(xpath = "//div[@class='text-center pull-right']/span")
    private SelenideElement sum;




    @Step
    public SelenideElement plusButton() {
        return plusButton;
    }
    @Step
    public SelenideElement quantity() {
        return quantity;
    }
    @Step
    public SelenideElement deleteButton() {
        return deleteButton;
    }
    @Step
    public SelenideElement emptyCart() {
        return emptyCart;
    }
    @Step
    public SelenideElement sum() {
        return sum;
    }
}
