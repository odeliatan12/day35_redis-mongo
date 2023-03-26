package nus.iss.edu.server.models;

public class AccountTransfer {

    private String id;
    private String fromAccount;
    private String toAccount;
    private Double transferAmount;
    private String comments;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getFromAccount() {
        return fromAccount;
    }
    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }
    public String getToAccount() {
        return toAccount;
    }
    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }
    public Double getTransferAmount() {
        return transferAmount;
    }
    public void setTransferAmount(Double transferAmount) {
        this.transferAmount = transferAmount;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
}
