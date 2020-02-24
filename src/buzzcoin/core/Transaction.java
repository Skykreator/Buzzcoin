package buzzcoin.core;

import java.util.Arrays;

public class Transaction {
    // transaction size = sender + receipient + amnt + transId + sig
    //					   2048		2048		 64		64		  256 = 4480 bits = 560 bytes
    private byte[] data;

    public Transaction(byte[] data) throws Exception {
        if (data.length != 560)
            throw new Exception("data must be 560 bytes");
        this.data = data;
    }

    public Transaction(byte[] sender, byte[] recipient, byte[] amount, byte[] transactionId, byte[] signature) throws Exception {
        if (sender.length != 256)
            throw new Exception("sender must be 256 bytes");
        if (recipient.length != 256)
            throw new Exception("recipient must be 256 bytes");
        if (amount.length != 8) throw new Exception("amount must be 8 bytes");
        if (transactionId.length != 8)
            throw new Exception("transaction id must be 8 bytes");
        if (signature.length != 32)
            throw new Exception("signature must be 32 bytes");

        // TODO: Fix this awful line
        this.data = concat(sender, concat(recipient, concat(amount, concat(transactionId, signature))));

    }

    public static byte[] concat(byte[] a, byte[] b) {
        int lenA = a.length;
        int lenB = b.length;
        byte[] c = Arrays.copyOf(a, lenA + lenB);
        System.arraycopy(b, 0, c, lenA, lenB);
        return c;
    }
    
    public static boolean isValid(byte[] hash) {
		if (hash[0] == (int)'B' && hash[1] == (int)'U' && hash[558] == (int)'Z' && hash[559] == (int)'Z')
			return true;
		else
			return false;
	}
}
