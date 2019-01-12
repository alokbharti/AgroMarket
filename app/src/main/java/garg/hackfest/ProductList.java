package garg.hackfest;

public class ProductList {
    private String ProductName;
    private String ProductPrice;
    private String ProductDate;
    private String ProductStatus;
    private String ProductWeight;

    public ProductList() {
    }

    public ProductList(String productName, String productPrice, String productDate, String productStatus, String productWeight) {
        ProductName = productName;
        ProductPrice = productPrice;
        ProductDate = productDate;
        ProductStatus = productStatus;
        ProductWeight = productWeight;
    }

    public String getProductName() {
        return ProductName;
    }

    public String getProductPrice() {
        return ProductPrice;
    }

    public String getProductDate() {
        return ProductDate;
    }

    public String getProductStatus() {
        return ProductStatus;
    }

    public String getProductWeight() {
        return ProductWeight;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public void setProductPrice(String productPrice) {
        ProductPrice = productPrice;
    }

    public void setProductDate(String productDate) {
        ProductDate = productDate;
    }

    public void setProductStatus(String productStatus) {
        ProductStatus = productStatus;
    }

    public void setProductWeight(String productWeight) {
        ProductWeight = productWeight;
    }
}
