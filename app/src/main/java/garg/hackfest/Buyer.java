package garg.hackfest;

public class Buyer {
    private String mBuyerName;
    private String mBuyerPhoneNumber;
    private String mBuyerItemName;
    private String mBuyerWeight;
    private String mBuyerCost;
    private String mBuyerOrderName;
    private String mBuyerPaymentMode;
    private String mBuyerAddress;
    private String mBuyerDate;

    public Buyer() {
    }

    public Buyer(String mBuyerName, String mBuyerPhoneNumber, String mBuyerItemName, String mBuyerWeight, String mBuyerCost,
                 String mBuyerOrderName, String mBuyerPaymentMode, String mBuyerAddress, String mBuyerDate) {
        this.mBuyerName = mBuyerName;
        this.mBuyerPhoneNumber = mBuyerPhoneNumber;
        this.mBuyerItemName = mBuyerItemName;
        this.mBuyerWeight = mBuyerWeight;
        this.mBuyerCost = mBuyerCost;
        this.mBuyerOrderName = mBuyerOrderName;
        this.mBuyerPaymentMode = mBuyerPaymentMode;
        this.mBuyerAddress=mBuyerAddress;
        this.mBuyerDate=mBuyerDate;
    }

    public String getmBuyerName() {
        return mBuyerName;
    }

    public void setmBuyerName(String mBuyerName) {
        this.mBuyerName = mBuyerName;
    }

    public String getmBuyerPhoneNumber() {
        return mBuyerPhoneNumber;
    }

    public void setmBuyerPhoneNumber(String mBuyerPhoneNumber) {
        this.mBuyerPhoneNumber = mBuyerPhoneNumber;
    }

    public String getmBuyerItemName() {
        return mBuyerItemName;
    }

    public String getmBuyerAddress() {
        return mBuyerAddress;
    }

    public void setmBuyerAddress(String mBuyerAddress) {
        this.mBuyerAddress = mBuyerAddress;
    }

    public String getmBuyerDate() {
        return mBuyerDate;
    }

    public void setmBuyerDate(String mBuyerDate) {
        this.mBuyerDate = mBuyerDate;
    }

    public void setmBuyerItemName(String mBuyerItemName) {
        this.mBuyerItemName = mBuyerItemName;
    }

    public String getmBuyerWeight() {
        return mBuyerWeight;
    }

    public void setmBuyerWeight(String mBuyerWeight) {
        this.mBuyerWeight = mBuyerWeight;
    }

    public String getmBuyerCost() {
        return mBuyerCost;
    }

    public void setmBuyerCost(String mBuyerCost) {
        this.mBuyerCost = mBuyerCost;
    }

    public String getmBuyerOrderName() {
        return mBuyerOrderName;
    }

    public void setmBuyerOrderName(String mBuyerOrderName) {
        this.mBuyerOrderName = mBuyerOrderName;
    }

    public String getmBuyerPaymentMode() {
        return mBuyerPaymentMode;
    }

    public void setmBuyerPaymentMode(String mBuyerPaymentMode) {
        this.mBuyerPaymentMode = mBuyerPaymentMode;
    }
}
