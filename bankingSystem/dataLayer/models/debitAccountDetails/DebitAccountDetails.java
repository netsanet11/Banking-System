package lab8.finalProject.bankingSystem.dataLayer.models.debitAccountDetails;



public class DebitAccountDetails
{
    private int debitAccountDetailsID;
    private DebitAccountType debitAccountType;
    private double monthlyInterest;

    public DebitAccountDetails(int debitAccountDetailsID, DebitAccountType debitAccountType, double monthlyInterest) {
        this.debitAccountDetailsID = debitAccountDetailsID;
        this.debitAccountType = debitAccountType;
        this.monthlyInterest = monthlyInterest;
    }

    public int getDebitAccountDetailsID() {
        return debitAccountDetailsID;
    }

    public DebitAccountType getDebitAccountType() {
        return debitAccountType;
    }

    public double getMonthlyInterest() {
        return monthlyInterest;
    }
}
