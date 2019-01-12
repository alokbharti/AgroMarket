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

    public Seller() {
    }

    public Seller(String mSellerName, String mSellerAddress, String mSellerDistrict, String mSellerState, String mSellerCommodity, String mSellerWeight, String SIUnit, String date) {

        this.mSellerName = mSellerName;
        this.mSellerAddress = mSellerAddress;
        this.mSellerDistrict = mSellerDistrict;
        this.mSellerState = mSellerState;
        this.mSellerCommodity = mSellerCommodity;
        this.mSellerWeight = mSellerWeight;
        this.SIUnit = SIUnit;
        Date = date;
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

    public String isSIUnit() {
        return SIUnit;
    }

    public String getDate() {
        return Date;
    }
}
