package liuquancai_1809070016;

public class Account {
	private double balance;
	
	public Account(double balance) {
		this.balance = balance;
	}
	
	public double getBalance() {
		return balance;
	}
	public double put(double amount) {
		if(amount < 0 ) {
			System.out.println("取款金额不能为负值");
		}
		else if(amount > balance) {
			System.out.println("余额不足");
		}
		else {
			balance -= amount;
		}
		return amount;
	}
	
	

}
