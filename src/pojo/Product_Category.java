package pojo;

import java.util.List;

public class Product_Category {
    private Integer id;

    private String name;

    private Integer parentId =0;

    private Integer type;

    private String iconClass;

    private Product product;

    private List<Product_Category> childList  ;   //子类，即二级分类，三级分类

    public List<Product_Category> getList() {
        return childList;
    }

    public void setList(List<Product_Category> childList) {
        this.childList = childList;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIconClass() {
        return iconClass;
    }

    public void setIconClass(String iconClass) {
        this.iconClass = iconClass == null ? null : iconClass.trim();
    }
}