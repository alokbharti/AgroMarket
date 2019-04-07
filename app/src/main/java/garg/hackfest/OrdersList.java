package garg.hackfest;

public class OrdersList {

    private String OrderID;
    private String OrderName;
    private String OrderWeight;
    private String OrderPrice;
    private String OrderDate;
    private String OrderAddress;

    public OrdersList() {
    }

    public OrdersList(String orderID, String orderName, String orderWeight, String orderPrice, String orderDate, String orderAddress) {
        OrderID = orderID;
        OrderName = orderName;
        OrderWeight = orderWeight;
        OrderPrice = orderPrice;
        OrderDate = orderDate;
        OrderAddress = orderAddress;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    public String getOrderName() {
        return OrderName;
    }

    public void setOrderName(String orderName) {
        OrderName = orderName;
    }

    public String getOrderWeight() {
        return OrderWeight;
    }

    public void setOrderWeight(String orderWeight) {
        OrderWeight = orderWeight;
    }

    public String getOrderPrice() {
        return OrderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        OrderPrice = orderPrice;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String orderDate) {
        OrderDate = orderDate;
    }

    public String getOrderAddress() {
        return OrderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        OrderAddress = orderAddress;
    }
}
