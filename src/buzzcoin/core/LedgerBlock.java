package buzzcoin.core;

public class LedgerBlock {
	
	// LedgerBlock is 64 transactions
	private Transaction[] transactionBlock;
	private int filled;


	public LedgerBlock() {
		transactionBlock = new Transaction[64];
		filled = 0;
	}
	
	public LedgerBlock(Transaction[] transactionBlock, int filled) throws Exception {
		if (transactionBlock.length > 64)
			throw new Exception("transactionBlock length must be at most 64 transactions");
		if (filled > 64)
			throw new Exception("filled must be at most 64");
		this.transactionBlock = transactionBlock;
	}

	public void append(Transaction transaction) {
	    transactionBlock[filled] = transaction;
	    ++filled;
	}
	
	
}

