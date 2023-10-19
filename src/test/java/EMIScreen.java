import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EMIScreen {

    @FindBy(id="com.continuum.emi.calculator:id/btnStart")
    WebElement btnStart;

    @FindBy(id="com.continuum.emi.calculator:id/etLoanAmount")
    WebElement txtAmount;

    @FindBy(id="com.continuum.emi.calculator:id/etInterest")
    WebElement txtInterest;

    @FindBy(id="com.continuum.emi.calculator:id/etYears")
    WebElement txtYear;

    @FindBy(id="com.continuum.emi.calculator:id/etFee")
    WebElement txtProcessingFee;

    @FindBy(id="com.continuum.emi.calculator:id/btnCalculate")
    WebElement btnCalculate;

    @FindBy(id="com.continuum.emi.calculator:id/btnReset")
    WebElement btnReset;

    @FindBy(id="com.continuum.emi.calculator:id/monthly_emi_result")
    WebElement lblMonthlyEMI;

    @FindBy(id="com.continuum.emi.calculator:id/total_interest_result")
    WebElement lblTotalInterest;

    @FindBy(id="com.continuum.emi.calculator:id/processing_fee_result")
    WebElement lblTotalProcessingFee;

    @FindBy(id="com.continuum.emi.calculator:id/total_payment_result")
    WebElement lblTotalPayment;

    public EMIScreen(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void calculateEMI(int amount, double interest, int period, double processingFee){
        //btnStart.click();
        txtAmount.sendKeys(String.valueOf(amount));
        txtInterest.sendKeys(String.valueOf(interest));
        txtYear.sendKeys(String.valueOf(period));
        txtProcessingFee.sendKeys(String.valueOf(processingFee));
        btnCalculate.click();
    }
}
