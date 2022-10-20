public class Product {

    private boolean productType;

    private String productName;

    public Product(boolean productType, String productName) {
        this.productType = productType;
        this.productName = productName;
    }

    public boolean isProductType() {
        return productType;
    }

    public void setProductType(boolean productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
