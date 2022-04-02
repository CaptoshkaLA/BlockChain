/**
 * Class which stores the order
 * @author Captoshka
 */

public class Order {
    public String customer;
    public String details;
    public long total;

    public Order(String customer, String details, long total) {
        this.customer = customer;
        this.details = details;
        this.total = total;
    }

    public String getString() {
        return String.format(
                this.customer,
                this.details,
                this.total);
    }
}