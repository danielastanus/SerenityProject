package org.fasttrack.features;

import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.fasttrack.utils.EnvConstants;
import org.junit.Test;

public class CartTest extends BaseTest{

    RandomString randomString = new RandomString();
    String randomComment = randomString.nextString();

    @Test
    public void addToCartTest(){
        loginSteps.setValidCredentials(EnvConstants.USER_EMAIL, EnvConstants.USER_PASS);
        loginSteps.clickLoginButton();
        cartSteps.selectProductFromShop();
        cartSteps.clickAddToCartButton();
        cartSteps.productAddedConfirmation();
    }

    @Test
    public void addAVariableProductInCart(){
        loginSteps.setValidCredentials(EnvConstants.USER_EMAIL, EnvConstants.USER_PASS);
        loginSteps.clickLoginButton();
        cartSteps.selectVariableProductFromShop();
        cartSteps.variableProductAddedConfirmation();
    }

    @Test
    public void removeFromCartTest(){
        loginSteps.setValidCredentials(EnvConstants.USER_EMAIL, EnvConstants.USER_PASS);
        loginSteps.clickLoginButton();
        cartSteps.selectProductFromShop();
        cartSteps.clickAddToCartButton();
        cartSteps.productAddedConfirmation();
        cartSteps.clickOnViewCartButton();
        cartSteps.removeProductFromCart("Album");
        cartSteps.removeProductConfirmation();
    }

    @Test
    public void checkCartTotalSummaryTest() {
        loginSteps.setValidCredentials(EnvConstants.USER_EMAIL, EnvConstants.USER_PASS);
        loginSteps.clickLoginButton();
        cartSteps.selectProductFromShop();
        cartSteps.clickAddToCartButton();
        cartSteps.productAddedConfirmation();
        cartSteps.clickOnViewCartButton();
        cartSteps.checkSubtotalPriceIsDisplayedCorrectly();
        cartSteps.checkTotalPriceIsCorrect();
    }

    @Test
    public void changeQuantityOfAProduct(){
        loginSteps.setValidCredentials(EnvConstants.USER_EMAIL, EnvConstants.USER_PASS);
        loginSteps.clickLoginButton();
        cartSteps.selectProductFromShop();
        cartSteps.clickAddToCartButton();
        cartSteps.productAddedConfirmation();
        cartSteps.clickOnViewCartButton();
        cartSteps.changeQuantityInCart("8");
    }

    @Test
    public void reviewAProduct(){
        loginSteps.setValidCredentials(EnvConstants.USER_EMAIL, EnvConstants.USER_PASS);
        loginSteps.clickLoginButton();
        cartSteps.selectProductFromShop();
        cartSteps.leaveAReview("very"+ randomComment);
        cartSteps.commentIsDisplayed("very" + randomComment);
    }

    @Test
    public void reviewWithSameComment(){
        loginSteps.setValidCredentials(EnvConstants.USER_EMAIL, EnvConstants.USER_PASS);
        loginSteps.clickLoginButton();
        cartSteps.selectProductFromShop();
        cartSteps.leaveAReview("nice"+randomComment);
        cartSteps.leaveAReview("nice"+randomComment);
        cartSteps.commentIsDoubled();
    }




}
