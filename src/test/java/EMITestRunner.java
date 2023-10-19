import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class EMITestRunner extends Setup{

    @BeforeTest
    public void startEMICalc(){
        EMIScreen emiScreen = new EMIScreen(driver);
        emiScreen.btnStart.click();

    }

    @Test(priority = 1, dataProviderClass = Dataset.class, dataProvider = "data-provider")
    public void calculateEMI(int amount, double interest, int period, double processingFee, double mEMI, double tInterest, int pFee, double tPayment){
        EMIScreen emiScreen = new EMIScreen(driver);
        emiScreen.calculateEMI(amount, interest, period, processingFee);

        String actualEMI = emiScreen.lblMonthlyEMI.getText().replace(",","");
        String actualInterest = emiScreen.lblTotalInterest.getText().replace(",","");
        String actualpFee = emiScreen.lblTotalProcessingFee.getText().replace(",","");
        String actualpayment = emiScreen.lblTotalPayment.getText().replace(",","");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualEMI, String.valueOf(mEMI));
        softAssert.assertEquals(actualInterest, String.valueOf(tInterest));
        softAssert.assertEquals(actualpFee, String.valueOf(pFee));
        softAssert.assertEquals(actualpayment, String.valueOf(tPayment));
        softAssert.assertAll();


        emiScreen.btnReset.click();
    }

}
