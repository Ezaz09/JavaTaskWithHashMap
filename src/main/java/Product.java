import java.util.Objects;

public class Product {
    private String name;
    private String manufacturer;
    private int amount;

    public Product(String name, String manufacturer, int amount) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object anotherProduct) {
        if (this == anotherProduct) return true;
        if (anotherProduct == null || getClass() != anotherProduct.getClass()) return false;
        Product product = (Product) anotherProduct;
        return amount == product.amount && Objects.equals(name, product.name) && Objects.equals(manufacturer, product.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, manufacturer, amount);
    }
}
