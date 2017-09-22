package lab8.finalProject.creditCardSystem.dataLayer.models.creditCardDetails;


public class CreditCardDetails
{
    private int creditCardDetailsID;
    private CreditCardType creditCardType;
    private double monthlyInterest;
    private double minimumPayment;

    public CreditCardDetails(int creditCardDetailsID, CreditCardType creditCardType, double monthlyInterest, double minimumPayment) {
        this.creditCardDetailsID = creditCardDetailsID;
        this.creditCardType = creditCardType;
        this.monthlyInterest = monthlyInterest;
        this.minimumPayment = minimumPayment;
    }

    public int getCreditCardDetailsID() {
        return creditCardDetailsID;
    }

    public CreditCardType getCreditCardType() {
        return creditCardType;
    }

    public double getMonthlyInterest() {
        return monthlyInterest;
    }

    public double getMinimumPayment() {
        return minimumPayment;
    }
}
