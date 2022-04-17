import java.util.Date;

/**
 * This class stores the data or information about something
 * @author captoshka
 * @see Cloneable
 * @see Node
 * @see Runnable
 * @see BlockChain
 * @see Order
 */

public class Block implements Cloneable {

    public String hashCode;
    public String previousHashCode;
    public Order order;
    public long timeStamp;

    public Block(Order order, String previousHashCode) {
        this.order = order;
        this.previousHashCode = previousHashCode;
        this.timeStamp = new Date().getTime();

        this.hashCode = Generator.generateHash(
                this.previousHashCode
                        + this.timeStamp
                        + this.order.toString());
    }

    public static Block getGenesisBlock() {
        Order order = new Order("Its me", "Nothing", 0);
        Block block = new Block(order, "");
        block.timeStamp = 0;
        block.hashCode = Generator.generateHash(
                block.previousHashCode
                        + block.timeStamp
                        + block.order.toString());
        return block;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}