import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Node helper class
 * @author Captoshka
 * @see Node
 * @see Runnable
 * @see Block
 * @see BlockChain
 * @see Order
 */

public class Store extends Node implements Runnable {

    public Store(String address, Node connectedNode) {
        super(address, connectedNode);
    }

    public void testOrders() throws InterruptedException {
        String[] customerName = {"Anton", "Andrew", "Daniel"};
        String[] orderDetails = {"Burger1", "Burger2", "Cola" };
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            Block block = new Block(
                    new Order(customerName[random.nextInt(3)], orderDetails[random.nextInt(3)], random.nextInt(50)),
                    this.blockChain.getLastHash()
            );
            try {
                this.mine(block);
                System.out.println(String.format("%s mined: %s", address, block.hash));
            } catch (IllegalArgumentException ex) {
                System.out.println(String.format("%s mined invalid block: %s", address, block.hash));
            }
            Thread.sleep(random.nextInt(3) * 1000 + 100);
        }
    }

    public void printBlockChain() {
        System.out.println("<----- Block chain of [" + address + "] ----->");

        this.blockChain.getBlocks().forEach(block -> {
            System.out.println(block.hash);
        });

        System.out.println("<----- End of BlockChain ----->");
    }

    @Override
    public void run() {
        try {
            testOrders();
        } catch (InterruptedException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}