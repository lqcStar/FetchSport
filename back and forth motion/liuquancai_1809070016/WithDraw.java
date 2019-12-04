package liuquancai_1809070016;

public class WithDraw extends Thread{
	private Account account;
	private double amount;
	
	public WithDraw(Account account,double amount) {
		this.account = account;
		this.amount = amount;
	}
	
	public void run() {
			synchronized (account) {
				
			String str = Thread.currentThread().getName()+"取款前余额："+account.getBalance();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(str+"取款金额： "+account.put(amount)+" 当前余额： "+account.getBalance());
		}
	}
	
	public static void main(String[] aggs) {
		Account account = new Account(500);
		for(int i=0;i< 10;i++){
			(new WithDraw(account,10+i)).start();
		}

	}
}
