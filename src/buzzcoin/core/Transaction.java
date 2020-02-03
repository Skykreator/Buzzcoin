package buzzcoin.core;

public class Transaction {
	
	// transaction size = sender + receipient + amnt + transId + sig
	//					   2048		2048		 64		64		  256 = 4480 bits = 560 bytes
	public Transaction(byte[] data) {
		
	}
	
	public Transaction(byte[] sender, byte[] receip, byte[] amnt, byte[] transId, byte[] sig) {
		
	}
	
}
