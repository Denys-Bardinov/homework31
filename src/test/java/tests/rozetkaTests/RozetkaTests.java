package tests.rozetkaTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constans.Constant.Urls.ROZETKA_NOTES_PAGE;

public class RozetkaTests extends BaseTest {

    @Test
    public void checkFilterSaler() {
basePage.open(ROZETKA_NOTES_PAGE);
rozetkaNotesPage.checkSalerCheckbox();
    }

    @Test
    public void checkFirstSortOptionTest() {
        basePage.open(ROZETKA_NOTES_PAGE);
        rozetkaNotesPage.checkFirstSortOption();
    }

    @Test
    public void checkResetFacet() {
        basePage.open(ROZETKA_NOTES_PAGE);
        rozetkaNotesPage.checkFilterReset();
    }

    @Test
    public void checkGraphicCardSearch() {
        basePage.open(ROZETKA_NOTES_PAGE);
        rozetkaNotesPage.checkGraphicsCardSearch();
    }

    @Test
    public void checkEmailErrorTest() throws InterruptedException {
        basePage.open(ROZETKA_NOTES_PAGE);
        rozetkaNotesPage.checkIncorrectCreeds();
    }

    @Test
    public void checkAddingToCardTest() {
        basePage.open(ROZETKA_NOTES_PAGE);
        rozetkaNotesPage.checkAddingToCard();
    }

    @Test
    public void checkGoodDetail() {
        basePage.open(ROZETKA_NOTES_PAGE);
        String a = rozetkaNotesPage.checkCorrectDetailGoodPage();
        String b = rosetkaGoodPage.checkFirstElement();
        Assert.assertTrue(a.contains(b));
    }


}
