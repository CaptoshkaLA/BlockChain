import java.util.ArrayList;

/**
 * BlockchainOfBlocks stores a series of blocks that each block points to the previous one(like a LinkedList)
 * @author captoshka
 * @see Cloneable
 * @see Node
 * @see Runnable
 * @see Block
 * @see Order
 */

public class BlockChain implements Cloneable {
    private final ArrayList<Block> chainOfBlocks;

    public BlockChain() {
        this.chainOfBlocks = new ArrayList<>();
        this.chainOfBlocks.add(Block.getGenesisBlock());
    }

    public ArrayList<Block> getBlocks() {
        return (ArrayList<Block>) chainOfBlocks.clone();
    }

    public long size() {
        return chainOfBlocks.size();
    }

    public void addBlock(Block block) {
        if (validateBlock(chainOfBlocks.get(chainOfBlocks.size() - 1), block)) {
            chainOfBlocks.add(block);
        } else {
            throw new IllegalArgumentException("Invalid block");
        }
    }

    public String getLastHash() {
        return this.chainOfBlocks.get(this.chainOfBlocks.size() - 1).hashCode;
    }

    public boolean validateBlock(Block previousBlock, Block block) {
        return block.previousHashCode.equals(previousBlock.hashCode);
    }

    public boolean validate() {
        ArrayList<Block> subchainOfBlocks = (ArrayList<Block>) chainOfBlocks.subList(1, chainOfBlocks.size() - 1);
        Block previousBlock = chainOfBlocks.get(0);

        for (Block currentBlock : subchainOfBlocks) {
            if (!validateBlock(previousBlock, currentBlock)) {
                return false;
            }
            previousBlock = currentBlock;
        }

        return true;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}