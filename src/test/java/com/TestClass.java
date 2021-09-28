package com;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.pages.BasketPage;
import com.pages.GummiesPage;
import com.pages.InitialPage;
import com.sun.org.apache.xml.internal.security.Init;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.Constants.BASE_URL;
import static com.codeborne.selenide.Selenide.*;

public class TestClass extends SelenideRunner {

    @Description("Add to basket via “Buy now” button")
    @Test
    public void verifyDisplayedItemsWelcomePageLegalAge() {

        InitialPage initialPage = open(BASE_URL, InitialPage.class);
        GummiesPage gummiesPage = initialPage.clickGummies();
        gummiesPage.annoyingConfirmation().click();
        gummiesPage.buyNowButton()
                .hover()
                .shouldBe(Condition.visible)
                .click();
        gummiesPage.verifyProductInBasket().shouldBe(Condition.visible);
    }

    @Description("Remove product from basket")
    @Test
    public void verifyDeleteLogic() {
        InitialPage initialPage = open(BASE_URL, InitialPage.class);
        GummiesPage gummiesPage = initialPage.clickGummies();
        gummiesPage.annoyingConfirmation().click();
        gummiesPage.buyNowButton()
                .hover()
                .shouldBe(Condition.visible)
                .click();
        gummiesPage.verifyProductInBasket().shouldBe(Condition.visible);
        BasketPage basketPage = gummiesPage.myBasketClick();
        basketPage.deleteButton().click();
        Selenide.confirm();
        basketPage.emptyCart().shouldBe(Condition.visible);

    }

    @Description("Increase quantity of products in my basket")
    @Test
    public void verifyBuyNowLogic() throws InterruptedException {
        InitialPage initialPage = open(BASE_URL, InitialPage.class);
        GummiesPage gummiesPage = initialPage.clickGummies();
        gummiesPage.annoyingConfirmation().click();
        gummiesPage.buyNowButton()
                .hover()
                .shouldBe(Condition.visible)
                .click();
        gummiesPage.verifyProductInBasket().shouldBe(Condition.visible);
        BasketPage basketPage = gummiesPage.myBasketClick();
        int quantityBefore = Integer.parseInt(basketPage.quantity().getValue());
        double summBefore = Double.parseDouble(basketPage.sum().getText().replaceAll(" \\$", "").replaceAll(",","."));
        basketPage.plusButton().click();
        basketPage.quantity().getValue().equals(quantityBefore + 1);
        Thread.sleep(1000);
        double summAfter = Double.parseDouble(basketPage.sum().getText().replaceAll(" \\$", "").replaceAll(",","."));
        Assert.assertEquals(summAfter, (summBefore + summBefore));
    }
}
