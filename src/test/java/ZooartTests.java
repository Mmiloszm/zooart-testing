import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pageObjects.*;


import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

public class ZooartTests {

    @BeforeAll
    public static void setup() {
        Configuration.browser = "edge";
    }

    @Test
    @DisplayName("Checks that feedback message contains given text after fail login.")
    public void checkIfSystemProvidesInformationOfWrongLoginOrPassword() {

        ZooartHomePage zooartHomePage = new ZooartHomePage();
        ZooartLoginPage zooartLoginPage = new ZooartLoginPage();

        zooartHomePage.open().loginOrRegisterButton.click();
        zooartLoginPage.setUsername("anytestingemail423432231@gmail.com")
                .setPassword("anytestingpass")
                .loginButton.click();
        zooartLoginPage.badLoginOrPassInfoVisible();
    }

    @Test
    @DisplayName("Add most expensive item in shop to basket and after check if delivery is free")
    public void checkIfFreeDeliveryWorksCorrectly() {

        ZooartHomePage zooartHomePage = new ZooartHomePage();
        ZooartResultPage zooartResultPage = new ZooartResultPage();
        ZooartProductPage zooartProductPage = new ZooartProductPage();
        ZooartBasketPage zooartBasketPage = new ZooartBasketPage();

        zooartHomePage.open().fillSearchLabel("pies");
        zooartHomePage.searchButton.click();

        zooartResultPage.sortMenu.click();
        zooartResultPage.priceHighToLow.click();
        zooartResultPage.firstItem.click();
        float convertedPrice = zooartProductPage.convertSoloPriceToFloat();

        if (convertedPrice >= 95.00) { // minimum price for free delivery
            zooartHomePage.expandBasketButton.click();
            zooartHomePage.basketButton.click();
            zooartBasketPage.isDeliveryPriceFree();
        } else {
            assertTrue(convertedPrice >= 95.00);
        }
    }

    @Test
    @DisplayName("Set number of items display on page.")
    public void checkIfSystemDisplayGivenNumberOfItems() {

        ZooartHomePage zooartHomePage = new ZooartHomePage();
        ZooartResultPage zooartResultPage = new ZooartResultPage();

        zooartHomePage.open().fillSearchLabel("pies");
        zooartHomePage.searchButton.click();

        zooartResultPage.numberOfItemsMenu.click();
        zooartResultPage.select60Items.click();
        zooartResultPage.checkIfThereAreGivenNumberItemsVisible(60);
    }

    @Test
    @DisplayName("Check if advanced searching works correctly by pass the maximum value to 150.")
    public void checkIfMaximumPriceSetTo150ByUserWorks() {

        ZooartHomePage zooartHomePage = new ZooartHomePage();
        ZooartAdvancedSearchingPage zooartAdvancedSearchingPage = new ZooartAdvancedSearchingPage();
        ZooartResultPage zooartResultPage = new ZooartResultPage();

        zooartHomePage.open().advancedSearchButton.click();

        zooartAdvancedSearchingPage.setMaxPrice("150");
        zooartAdvancedSearchingPage.expandSortByMenu.click();
        zooartAdvancedSearchingPage.selectSortByPrice.click();
        zooartAdvancedSearchingPage.sortHighToLow.click();
        zooartAdvancedSearchingPage.searchButton.click();

        float convertedPrice = zooartResultPage.convertPriceOfFirstItem();

        assertTrue(convertedPrice <= 150.00);
    }

    @Test
    @DisplayName("Check if adding item to favorite works correctly by comparing items before and after adding them to favorite tab")
    public void checkIfAddToFavoriteFunctionAddsTheSameItem() {

        ZooartHomePage zooartHomePage = new ZooartHomePage();
        ZooartResultPage zooartResultPage = new ZooartResultPage();
        ZooartFavoritePage zooartFavoritePage = new ZooartFavoritePage();

        zooartHomePage.open()
                .fillSearchLabel("pies")
                .searchButton.click();

        String preAddedName = zooartResultPage.getFirstItemNameInUpperCase();
        zooartResultPage.addFirstItemToFavorite.click();
        zooartResultPage.favoriteList.click();

        zooartFavoritePage.checkIfItemIsVisibleInFavoriteList(preAddedName);
    }

    @Test
    @DisplayName("Check if number given in bracket next to filter shows correct number of items in that category.")
    public void checkIfNumbersInFilteringToolWorksCorrectly() {

        ZooartHomePage zooartHomePage = new ZooartHomePage();
        ZooartResultPage zooartResultPage = new ZooartResultPage();

        zooartHomePage.open()
                .fillSearchLabel("karma")
                .searchButton.click();

        zooartResultPage.randomBrand.click();
        int count = zooartResultPage.getNumberOfItemsInShopOfPrevSelectedBrand();
        zooartResultPage.submitFilterOptions.click();
        zooartResultPage.checkIfThereAreGivenNumberItemsVisible(count);
    }

    @Test
    @DisplayName("Checks that the registration form correctly checks that both given passwords are the same.")
    public void checkIfSystemCorrectlyDisplayInfoAboutTwoOtherPassword() {

        ZooartHomePage zooartHomePage = new ZooartHomePage();
        ZooartLoginPage zooartLoginPage = new ZooartLoginPage();
        ZooartRegisterPage zooartRegisterPage = new ZooartRegisterPage();

        zooartHomePage.open()
                .loginOrRegisterButton.click();

        zooartLoginPage.registerFormButton.click();

        zooartRegisterPage.setPassword("TestoweHasl0#1")
                .repeatPassword("TestoweHasl0!1")
                .checkIfInformationOfInvalidPassExist();
    }

}
