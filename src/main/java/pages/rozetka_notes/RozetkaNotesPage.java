package pages.rozetka_notes;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.base.BasePage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static constans.Constant.TimeoutVariable.IMPLICIT_WAIT;

public class RozetkaNotesPage extends BasePage {
    public RozetkaNotesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//aside/rz-filter-stack/div[1]/div/rz-scrollbar/div/div[1]/div/div/rz-filter-checkbox/ul[1]/li[1]/a/label")
    WebElement SalerRozetka;
    @FindBy(xpath = "//rz-catalog/div/rz-catalog-settings/div/rz-selected-filters/div/ul/li[2]/a")
    WebElement filterRozetka;
    @FindBy(xpath = "//rz-catalog/div/rz-catalog-settings/div/rz-sort/select/option[1]")
    WebElement firstSortOption;
    @FindBy(xpath = "//rz-scrollbar/div/div[1]/div/div/rz-filter-section-autocomplete/ul[1]/li[1]/a/label")
    WebElement firsrBrandFacet;
    @FindBy(xpath = "//rz-selected-filters/div/ul/li[1]/button")
    WebElement resetButton;
    @FindBy(xpath = "//rz-catalog-settings/div/rz-selected-filters/div/ul/li")
    List<WebElement> facetList;
    @FindBy(xpath = "//rz-filter-stack/div[10]/div/rz-filter-searchline/div/input")
    WebElement graphickCardSearchInput;
    @FindBy(xpath = "//rz-scrollbar/div/div[1]/div/div/rz-filter-checkbox/ul[2]/li[@class='checkbox-filter__item ng-star-inserted']//label[@for='GeForce GTX 1050 Ti']")
    WebElement graphickCardSearchFirstInput;
    @FindBy(xpath = "//rz-catalog/div/div/section/rz-paginator/div/ul/li[2]")
    WebElement paginationTwo;
    @FindBy(xpath = "//rz-user/button")
    WebElement loginButton;
    @FindBy(xpath = "//*[@id='auth_email']")
    WebElement emailInput;
    @FindBy(xpath = "//*[@id='auth_pass']")
    WebElement passwordInput;
    @FindBy(xpath = "//rz-user-identification/rz-auth/div/form/fieldset/div[1]/p")
    WebElement emailError;
    @FindBy(xpath = "//rz-grid/ul/li[1]/app-goods-tile-default/div/div[2]/div[4]/div[2]/app-buy-button/button")
    WebElement firstGoodAddToCard;
    @FindBy(xpath = "//rz-cart/button")
    WebElement cartButton;
    @FindBy(xpath = "//rz-shopping-cart/div/ul/li")
    WebElement cartFirstElement;
    @FindBy(xpath = "//rz-grid/ul/li[1]/app-goods-tile-default/div/div[2]/a[2]/span")
    WebElement firstGoodText;
    @FindBy(xpath = "//rz-catalog/div/div/section/rz-grid/ul/li[1]/app-goods-tile-default/div")
    WebElement firstGood;


    public RozetkaNotesPage checkSalerCheckbox() {
        SalerRozetka.click();
        String filterRozetkaText = filterRozetka.getText();
        Assert.assertTrue(filterRozetkaText.contains("Rozetka"));
        return this;
    }


    public RozetkaNotesPage checkFirstSortOption() {
        String firstSortOptionText = firstSortOption.getText();
        Assert.assertTrue(firstSortOptionText.contains("По рейтингу"));
        return this;
    }

    public RozetkaNotesPage checkFilterReset() {
        SalerRozetka.click();
        firsrBrandFacet.click();
        resetButton.click();
        Assert.assertTrue(facetList.isEmpty());
        return this;
    }

    public RozetkaNotesPage checkGraphicsCardSearch() {
        graphickCardSearchInput.click();
        graphickCardSearchInput.sendKeys("GeForce GTX 1050 Ti");
        graphickCardSearchInput.sendKeys(Keys.ENTER);
        String graphickCardSearchFirstInputText = graphickCardSearchFirstInput.getText();
        Assert.assertTrue(graphickCardSearchFirstInputText.contains("GeForce GTX 1050 Ti"));
        return this;
    }

    public RozetkaNotesPage checkIncorrectCreeds() throws InterruptedException {
        loginButton.click();
        emailInput.click();
        emailInput.sendKeys("1");
        passwordInput.click();
        passwordInput.sendKeys("2");
        String emailErrorText = emailError.getText();
       Thread.sleep(2000);
        Assert.assertTrue(emailErrorText.contains("Введен неверный адрес эл.почты или номер телефона"));
        return this;
    }

    public RozetkaNotesPage checkAddingToCard() {
        firstGoodAddToCard.click();
        cartButton.click();
        Assert.assertNotNull(cartFirstElement);
        return this;
    }

    public String checkCorrectDetailGoodPage() {
        String text = firstGoodText.getText();
        firstGood.click();
        return text;
    }

}
