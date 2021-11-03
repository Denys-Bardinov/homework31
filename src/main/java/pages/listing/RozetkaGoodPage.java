package pages.listing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.base.BasePage;

public class RozetkaGoodPage extends BasePage {
    public RozetkaGoodPage(WebDriver driver) {
        super(driver);
    }

@FindBy(xpath = "//rz-product/div/rz-product-top/div/div[1]/h1")
WebElement goodTitle;

    public String checkFirstElement () {
        String textTitle = goodTitle.getText();
        return textTitle;
    }

}
