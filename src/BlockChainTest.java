import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main class which test the algorithms
 * @author captoshka
 * @see Node
 * @see Block
 * @see BlockChain
 */

public class BlockChainTest {

    public static void main(String[] args) {
        Store kfc = new Store("KFC Voronezh", null);
        Store burger = new Store("Burger King Voronezh", kfc);
        Store ra = new Store("Russian Appetite Voronezh", kfc);

        Store[] stores = {kfc, burger, ra};

        for (Store store : stores) {
            Thread thread = new Thread(store);
            thread.start();
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(BlockChainTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Store store : stores) {
            System.out.println("");
            store.printBlockChain();
        }
    }

}