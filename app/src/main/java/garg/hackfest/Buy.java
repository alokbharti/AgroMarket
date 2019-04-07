package garg.hackfest;

import java.util.Date;

public class Buy {
    private String mItemName;
    private String mDate;
    private String mLocation;
    private String mPrice;
    private String mQuatity;
    private String mUnit;
    private String Key;

    public Buy() {
    }

    public Buy(String itemName, String date, String location, String price, String quatity, String unit,String Key)
    {
        mItemName = itemName;
        mDate = date;
        mLocation = location;
        mPrice = price;
        mQuatity = quatity;
        mUnit = unit;
        this.Key=Key;
    }

    public String getItemName(){ return mItemName;}

    public String getDate(){ return mDate;}

    public String getLocation(){ return mLocation;}

    public String getPrice(){ return mPrice;}

    public String getQuatity() { return mQuatity;}

    public String getUnit(){ return mUnit;}

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public void setmItemName(String mItemName) {
        this.mItemName = mItemName;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public void setmLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    public void setmPrice(String mPrice) {
        this.mPrice = mPrice;
    }

    public void setmQuatity(String mQuatity) {
        this.mQuatity = mQuatity;
    }

    public void setmUnit(String mUnit) {
        this.mUnit = mUnit;
    }
}
