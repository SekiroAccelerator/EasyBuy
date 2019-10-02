package pojo;

public class Order_Detail {
    private Integer id;

    private Integer orderId;

    private Integer productId;

    private Product product;

    private Integer quantity;

    private Float cost;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Order_Detail{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", productId=" + productId +
                ", product=" + product +
                ", quantity=" + quantity +
                ", cost=" + cost +
                '}';
    }
}