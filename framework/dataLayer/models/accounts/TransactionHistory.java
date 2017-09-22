package lab8.finalProject.framework.dataLayer.models.accounts;


import java.time.LocalDateTime;

public class TransactionHistory
{
    private int transactionId;
    private LocalDateTime date;
    private String description;
    private double amount;
    private byte[] rowVer;

    public TransactionHistory(int transactionId, LocalDateTime date, String description, double amount) {
        this.transactionId = transactionId;
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.rowVer = null;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public byte[] getRowVer() {
        return rowVer;
    }
}
