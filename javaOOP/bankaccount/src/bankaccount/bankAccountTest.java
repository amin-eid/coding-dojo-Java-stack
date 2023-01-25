package bankaccount;

public class bankAccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        BankAccount act = new BankAccount();
        
        System.out.println("The bank account number for this account is : " + act.accountNumber);
        System.out.println(act.getCheckingbalance());
        System.out.println(act.getSavingsbalance());
        act.depositChecking(200);
        act.depositSavings(500);
        act.withdrawChecking(100);
        System.out.println(act.getCheckingbalance());
        act.withdrawSavings(200);
        System.out.println(act.getSavingsbalance());
        act.totalAmount();
        System.out.println("The total amount  is : " + act.totalAmount());
        
   }
	

}
