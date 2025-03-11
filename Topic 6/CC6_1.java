import java.util.Random;

public class BankAccount {

	private double balance = 0.0d;
	private String accountID;

	public double getBalance() {
		return this.balance;
	}
	
	public String getAccountID() {
		return this.accountID;
	}
	
	public BankAccount() {
		this.accountID = ("acc" + (new Random().nextInt(9)) + (new Random().nextInt(9)) + (new Random().nextInt(9)) + (new Random().nextInt(9)));
		}
	
	public BankAccount(double startBalance) {
		this.accountID = ("acc" + (new Random().nextInt(9)) + (new Random().nextInt(9))
						 + (new Random().nextInt(9)) + (new Random().nextInt(9)));
		
		this.balance = startBalance;
		}
	
	public BankAccount(double startBalance, String startAccountID) {
		this.accountID = startAccountID;
		this.balance = startBalance;
		}

	public BankAccount(BankAccount toCopy) {
		this.balance = toCopy.getBalance();
		this.accountID = toCopy.getAccountID();
		}

	public void withdraw(double amount) {
		if ( (balance - amount) >= 0 && (amount > 0)) {
			this.balance -= amount;
		}
	}

	public void deposit(double amount) {
		if (amount >= 0) {
		this.balance += amount;
		}
	}
	
	public void transfer(double amount, BankAccount toAccount) {
		if (balance >= amount) {
			this.balance -= amount;
			toAccount.deposit(amount);
		}
	}

	public String toString() {
		return (accountID + ": " + balance);
		}
}
