
> # About
 <hr>
 This is a test project to get acquainted with the blockchain. <br/> A huge advantage of the blockchain system compared to a distributed system is that it is resistant to any sudden changes in the central node/database. <br/>
 Blockchain is the combination of blocks and chain. Block stores the data, chain stores a sequence of blocks. <br/>
 Why is it needed? In order to understand the principle of decentralized data storage. <br/>
 The meaning of this project is to transfer some information between nodes, in this example, food shops. <br/> Each shop, called Node, has a single blockchain. To make sure that blockchain consistently, when a node mines a block, it needs to notify all nodes in the network by method mine(). 
 <hr/>

> # Classes
 <hr>

### `Block`
Object of this class stores the data or information.
Each Block has the unique ID, called hash. <br />
Head block that doesn’t have previous one, called genesis block.

### `Blockchain`
Class BlockChain contains list of blocks. <br />

### `BlockChainTest`
My entire algorithm is tested in this class. <br />

### `Generator`
In this class, a random hash sequence is created based on the SHA-256 cryptographic algorithm. <br />

### `Node`
This class stores information about the node, which is, in this case, a store interested in transmitting data. <br />

### `Order`
This class stores data about the order made by the customer. <br />

### `Store`
The Store class is required for testing.
 <hr/>

> # Conclusion
> <hr>
Of course, this is not a real, used blockchain system. In this example, PoW, sub chain, confirmation are not used. <br />
This project is my personal initiative and was created for educational purposes.
 <hr/>

