import static org.junit.Assert.*;

import org.junit.Test;

public class BankAccountTest
{
	
	// test constructors
	@Test
    public void test_creation(){
        BankAccount b = new BankAccount();
        assertEquals("Expected initial balance to be 0.0", 0.0, b.getBalance(), 0.00001);
        
		String actualAccountID = b.getAccountID();
        String prefix = actualAccountID.substring(0,3);
        String digits = actualAccountID.substring(3);
        assertEquals("Account ID should start with prefix 'acc'", "acc", prefix);
        assertEquals("Account ID should end with exactly length 4 (4 digits)", 4, digits.length());
        int num = Integer.parseInt(digits);
        assertTrue("Account number should end with a number between 0001 and 9999 (inclusive)", 1 <= num && num <= 9999);
    }
	
	@Test
	public void test_constructorWithBalance()
	{
		BankAccount b = new BankAccount(50.0);
		assertEquals("Unexpected balance",50.0,b.getBalance(), 0.00001);

		String actualAccountID = b.getAccountID();
        String prefix = actualAccountID.substring(0,3);
        String digits = actualAccountID.substring(3);
        assertEquals("Account ID should start with prefix 'acc'", "acc", prefix);
        assertEquals("Account ID should end with exactly length 4 (4 digits)", 4, digits.length());
        int num = Integer.parseInt(digits);
        assertTrue("Account number should end with a number between 0001 and 9999 (inclusive)", 1 <= num && num <= 9999);
	}
	
	@Test
	public void test_constructorWithBalance_negative()
	{
		BankAccount b = new BankAccount(-50.0);
		assertEquals("Unexpected balance",-50.0,b.getBalance(), 0.00001);

		String actualAccountID = b.getAccountID();
        String prefix = actualAccountID.substring(0,3);
        String digits = actualAccountID.substring(3);
        assertEquals("Account ID should start with prefix 'acc'", "acc", prefix);
        assertEquals("Account ID should end with exactly length 4 (4 digits)", 4, digits.length());
        int num = Integer.parseInt(digits);
        assertTrue("Account number should end with a number between 0001 and 9999 (inclusive)", 1 <= num && num <= 9999);
	}
	
	@Test
	public void test_constructorWithBalance_zero()
	{
		BankAccount b = new BankAccount(0.0);
		assertEquals("Unexpected balance",0.0,b.getBalance(), 0.00001);

        String actualAccountID = b.getAccountID();
        String prefix = actualAccountID.substring(0,3);
        String digits = actualAccountID.substring(3);
        assertEquals("Account ID should start with prefix 'acc'", "acc", prefix);
        assertEquals("Account ID should end with exactly length 4 (4 digits)", 4, digits.length());
        int num = Integer.parseInt(digits);
        assertTrue("Account ID should end with a number between 0001 and 9999 (inclusive)", 1 <= num && num <= 9999);
	}
	
	@Test
	public void test_construction_randomnessOfAccountID()
	{
		BankAccount b1 = new BankAccount();
		BankAccount b2 = new BankAccount();
		BankAccount b3 = new BankAccount();
		BankAccount b4 = new BankAccount();
		
		String id1 = b1.getAccountID();
		String id2 = b2.getAccountID();
		String id3 = b3.getAccountID();
		String id4 = b4.getAccountID();
		
		assertFalse("When randomly selecting 4 digits, they should not all be the same. Testing first digit", 
				id1.charAt(3) == id2.charAt(3) &&
				id1.charAt(3) == id3.charAt(3) &&
				id1.charAt(3) == id4.charAt(3));
		assertFalse("When randomly selecting 4 digits, they should not all be the same. Testing second digit", 
				id1.charAt(4) == id2.charAt(4) &&
				id1.charAt(4) == id3.charAt(4) &&
				id1.charAt(4) == id4.charAt(4));
		assertFalse("When randomly selecting 4 digits, they should not all be the same. Testing third digit", 
				id1.charAt(5) == id2.charAt(5) &&
				id1.charAt(5) == id3.charAt(5) &&
				id1.charAt(5) == id4.charAt(5));
		assertFalse("When randomly selecting 4 digits, they should not all be the same. Testing fourth digit", 
				id1.charAt(6) == id2.charAt(6) &&
				id1.charAt(6) == id3.charAt(6) &&
				id1.charAt(6) == id4.charAt(6));
	}
	
	@Test
	public void test_constructorWithBalanceAndAccountNumber() {
		BankAccount b = new BankAccount(100.0, "1234");
		assertEquals("Unexpected balance, created with argument 100.0 and '1234'", 100.0, b.getBalance(),0.00001);
		assertEquals("Unexpected account number, created with argument 100.0 and '1234'", "1234", b.getAccountID());		
	}
	
	@Test
	public void test_constructorWithBalanceAndAccountNumber_shortNumber() {
		BankAccount b = new BankAccount(100.0, "987");
		assertEquals("Unexpected balance, created with argument 100.0 and '987'", 100.0, b.getBalance(),0.00001);
		assertEquals("Unexpected account number, created with argument 100.0 and '987'", "987", b.getAccountID());		
	}
	
	@Test
	public void test_constructorWithBalanceAndAccountNumber_longNumber() {
		BankAccount b = new BankAccount(100.0, "78654");
		assertEquals("Unexpected balance, created with argument 100.0 and '78654'", 100.0, b.getBalance(),0.00001);
		assertEquals("Unexpected account number, created with argument 100.0 and '78654'", "78654", b.getAccountID());		
	}
	
	@Test
	public void test_copyConstructor() {
		BankAccount b = new BankAccount(150.0);
		String expectedAccountNumber = b.getAccountID();
		
		BankAccount copy = new BankAccount(b);
		
		assertEquals("Unexpected balance in copy",150.0,copy.getBalance(), 0.00001);
		assertEquals("Unexpected account number in copy", expectedAccountNumber, copy.getAccountID());
	}	
	
	// Testing deposit
	    
	@Test
    public void test_deposit() {
        BankAccount b = new BankAccount();
        b.deposit(10.25);
        assertEquals("Deposited 10.25.", 10.25, b.getBalance(), 0.000001);
    }
    
	@Test
    public void test_deposit_negativeAmount() {
        BankAccount b = new BankAccount();
        b.deposit(-10.25);
        assertEquals("Tried to deposit a negative amount, balance should remain unchanged.", 0.00, b.getBalance(), 0.000001);
    }
        
    // testing withdraw
	@Test
    public void test_withdraw_sufficientBalance() {
        BankAccount b = new BankAccount();
        b.deposit(500.00);
        b.withdraw(44.25);
        assertEquals("Withdrew 44.25 after depositing 500.00", 455.75, b.getBalance(), 0.000001);
    }
    
	@Test
    public void test_withdraw_insufficientFunds() {
        BankAccount b = new BankAccount();
        b.deposit(5.00);
        b.withdraw(5.01);
        assertEquals("Withdrew 5.01 after depositing 5.00", 5.00, b.getBalance(), 0.000001);
    }
	
	@Test
    public void test_withdraw_negativeAmount() {
        BankAccount b = new BankAccount();
        b.deposit(5.00);
        b.withdraw(-1.0);
        assertEquals("Withdrew -1 after depositing 5.00 (nothing should happen)", 5.00, b.getBalance(), 0.000001);
    }
	
	@Test
    public void test_withdraw_entireBalance() {
        BankAccount b = new BankAccount(5.00);
        b.withdraw(5.00);
        assertEquals("Withdrew 5.0 from account with start balance 5.0", 0.00, b.getBalance(), 0.000001);
    }	
	
	@Test
	public void test_transfer_moreThanSufficientFunds() {
		BankAccount b = new BankAccount(1340.0);
		BankAccount b2 = new BankAccount(500.0);
		b.transfer(1000,b2);
        assertEquals("Transfered 1000 from account with 1340 balance to account with 500 balance.  Testing from account", 340.0, b.getBalance(), 0.000001);
        assertEquals("Transfered 1000 from account with 1000 balance to account with 500 balance.  Testing to account", 1500.0, b2.getBalance(), 0.000001);
		
	}
	
	@Test
	public void test_transfer_exactlySufficientFunds() {
		BankAccount b = new BankAccount(1000.0);
		BankAccount b2 = new BankAccount(500.0);
		b.transfer(1000,b2);
        assertEquals("Transfered 1000 from account with 1000 balance to account with 500 balance.  Testing from account", 0.0, b.getBalance(), 0.000001);
        assertEquals("Transfered 1000 from account with 1000 balance to account with 500 balance.  Testing to account", 1500.0, b2.getBalance(), 0.000001);
		
	}
	
	@Test
	public void test_transfer_insufficientFunds() {
		BankAccount b = new BankAccount(1000.0);
		BankAccount b2 = new BankAccount(500.0);
		b.transfer(1001,b2);
        assertEquals("Transfered 1001 from account with 1000 balance to account with 500 balance.  Testing from account", 1000.0, b.getBalance(), 0.000001);
        assertEquals("Transfered 1001 from account with 1000 balance to account with 500 balance.  Testing to account", 500.0, b2.getBalance(), 0.000001);		
	}
	
	
	
	@Test
	public void test_toString() {
		BankAccount b = new BankAccount(101.56, "3426");
		assertEquals("Expected to string to return (<account number>: <balance>", "3426: 101.56", b.toString());
	}
}