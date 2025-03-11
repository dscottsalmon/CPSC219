
public class SavingsAccount extends BankAccount{

	private double annualInterestRate = 0.05d;

	public double getAnnualInterestRate() {
		return this.annualInterestRate;
	}
	public void setAnnualInterestRate(double amount) {
		if (amount >= 0 && amount <= 1) {
		this.annualInterestRate = amount;
		}
	}
	public void depositMonthlyInterest() {
		deposit((getBalance() * annualInterestRate * (1d / 12d) ));
	}
}
