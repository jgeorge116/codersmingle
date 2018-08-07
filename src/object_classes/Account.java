package object_classes;

public class Account {
	String CardNumber;
	String AcctNum;
	String OwnerSSN;

	public Account(String cardNumber, String acctNum, String ownerSSN) {
		CardNumber = cardNumber;
		AcctNum = acctNum;
		OwnerSSN = ownerSSN;
	}

	public String getOwnerSSN() {
		return OwnerSSN;
	}

	public void setOwnerSSN(String ownerSSN) {
		OwnerSSN = ownerSSN;
	}

	public String getCardNumber() {
		return CardNumber;
	}

	public void setCardNumber(String cardNumber) {
		CardNumber = cardNumber;
	}

	public String getAcctNum() {
		return AcctNum;
	}

	public void setAcctNum(String acctNum) {
		AcctNum = acctNum;
	}

}
