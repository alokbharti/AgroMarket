package garg.hackfest;

public class Seller {
    private String mSellerName;
    private String mSellerAddress;
    private String mSellerDistrict;
    private String mSellerState;
    private String mSellerCommodity;
    private String mSellerWeight;
    private String SIUnit;
    private String Date;
    private String Status;
    private String Price;
    private String PhoneNumber;

    public Seller() {
    }

    public Seller(String mSellerName, String mSellerAddress, String mSellerDistrict, String mSellerState,
                  String mSellerCommodity, String mSellerWeight, String SIUnit, String date, String Status,String Price,String PhoneNumber) {

        this.mSellerName = mSellerName;
        this.mSellerAddress = mSellerAddress;
        this.mSellerDistrict = mSellerDistrict;
        this.mSellerState = mSellerState;
        this.mSellerCommodity = mSellerCommodity;
        this.mSellerWeight = mSellerWeight;
        this.SIUnit = SIUnit;
        this.Status=Status;
        Date = date;
        this.Price = Price;
        this.PhoneNumber=PhoneNumber;
    }

    public String getmSellerName() {
        return mSellerName;
    }

    public String getmSellerAddress() {
        return mSellerAddress;
    }

    public String getmSellerDistrict() {
        return mSellerDistrict;
    }

    public String getmSellerState() {
        return mSellerState;
    }

    public String getmSellerCommodity() {
        return mSellerCommodity;
    }

    public String getmSellerWeight() {
        return mSellerWeight;
    }

    public String getSIUnit() {
        return SIUnit;
    }

    public String getDate() {
        return Date;
    }

    public String getStatus() {
        return Status;
    }

    public String getPrice() {
        return Price;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public void setmSellerName(String mSellerName) {
        this.mSellerName = mSellerName;
    }

    public void setmSellerAddress(String mSellerAddress) {
        this.mSellerAddress = mSellerAddress;
    }

    public void setmSellerDistrict(String mSellerDistrict) {
        this.mSellerDistrict = mSellerDistrict;
    }

    public void setmSellerState(String mSellerState) {
        this.mSellerState = mSellerState;
    }

    public void setmSellerCommodity(String mSellerCommodity) {
        this.mSellerCommodity = mSellerCommodity;
    }

    public void setmSellerWeight(String mSellerWeight) {
        this.mSellerWeight = mSellerWeight;
    }

    public void setSIUnit(String SIUnit) {
        this.SIUnit = SIUnit;
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
