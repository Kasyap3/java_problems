package myPack;

import java.util.*;
//import java.util.random;
import java.lang.Exception;


class MyException extends Exception
{
	MyException(String Message)
	{
		super(Message);
	}
}

interface Account
{
	void CreateAcc(); // abstract methods
	void Deposit();
	void Withdraw();
}


class BankUtilities
{
	int acctype, year = 1, ssn = 0, accnum;
	
	float intr;
	String name ="";
	String loc = "";
	
	Scanner in = new Scanner(System.in);
	Random rnd = new Random();
	
	double temp = 0.0, bal = 0.0;
	
}

class Bank extends BankUtilities implements Account
{
	
	void getInfo()
	{
		try
		{
			System.out.println("Enter the name");
			name = in.next();
			
			System.out.println("Enter the SSN");
			ssn = in.nextInt();
			
			System.out.println("Enter the location");
			loc = in.next();
			
			System.out.println("Enter the account type: \n 1. Savings (10% interest) \t 2. Current (7% interest");
			acctype = in.nextInt();
			
			
			switch(acctype)
			{
			
			case 1:
				System.out.println(" Enter the initial amount to be deposited");
				temp = in.nextDouble();
				
				if (temp <0)
				{
					System.out.println("iNVALID AMOUNT \n TRY AGAIN !!!!!!");
					
					System.out.println("Enter the initial amount to be deposited");
					temp = in.nextDouble();
				}
				
				Deposit(temp);
				System.out.println("Enter number of years");
				year = in.nextInt();
				
				if(year<=0)
				{
					System.out.println("INVALID YEAR \\n TRY AGAIN !!!!!!");
					year = in.nextInt();
					
				}
				break;
				
			case 2:
				System.out.println(" Enter the initial amount to be deposited");
				temp = in.nextDouble();
				
				if (temp <0)
				{
					System.out.println("iNVALID AMOUNT \n TRY AGAIN !!!!!!");
					
					System.out.println("Enter the initial amount to be deposited");
					temp = in.nextDouble();
				}
				
				Deposit(temp);
				
				break;
				
				default: System.out.println("Invalid Option");
				
				
			}
			
			
			
		}
		
		catch(Exception e)
		{
			System.out.println("Inbiult Exception!!!!!!!!" +e);
		}
	}
	
	public void CreateAcc()
	{
		try
		{
			getInfo();
			
			System.out.println("Account Succefully Created:");
			accnum = rnd.nextInt(1000)+1;
			System.out.println("Hello" +name+ "Your Account is Successfully Created" +accnum+ "\n");
			
		}
		
		catch(Exception e)
		{
			System.out.println(" fatal error");
		}
	}
	
	 void Deposit(double temp) //inital deposit amount
	{
		try
		{
			if (temp > 500)
			{
				bal = bal + temp;
				System.out.println("Successfully Credited");
			}
			
			else
			{
				throw new MyException("Minimum deposit rule violated");
			}
		}
		catch(MyException a)
		{
			System.out.println(a.getMessage());
			System.out.println("Transaction Failure");
			System.exit(0);
		}
	}
	
	 
	 public void Deposit()
	 {
		 System.out.println("Enter the amount to be deposited");
		 temp = in.nextDouble();
		 
		 try
		 {
			 if (temp > 0)
			 {
				 bal = bal + temp;
				 System.out.println("Successfully Credited");
			 }
			 
			 
				 else
					{
						throw new MyException("Minimum deposit rule violated");
					}
			 
		 }
		 
		 catch(MyException b)
		 {
			 System.out.println(b.getMessage());
				System.out.println("Transaction Failure");
				System.exit(0);
		 }
	 }
	 
	 
	 
	 public void Withdraw()
	 {
		 System.out.println("Enter the amount you want to withdraw");
		 temp = in.nextDouble();
		 
		 if (temp < 0)
		 {
			 System.out.println("Invalid amount");
			 System.exit(0);
		 }
		 
		 
		 try
		 {
			 if (temp < bal)
			 {
				 bal = bal -temp;
				 System.out.println("Successfully Debited");
			 }
			 
			 else
			 {
				 throw new MyException("Minimum deposit rule violated");
			 }
		 }
		 
		 catch(MyException c)
		 {
			 System.out.println(c.getMessage());
				System.out.println("Transaction Failure");
				System.exit(0); 
		 }
	 }
	 
	 
	 void Interest()
	 {
		 try
		 {
			 if (ssn==0)
			 {
				// System.out.println("Account not found");
				 throw new MyException("Account not found");
			 }
			 
			 else 
			 {
				 if (acctype == 1)
				 {
					 bal = year*bal*0.10;
					 System.out.println("10% interest added");
					 
				 }
				 
				 else if(acctype == 2)
				 {
					 bal = year*bal*0.07;
					 System.out.println("7% interest added");
				 }
			 }
		 }
		 
		 catch(MyException d)
		 {
			 System.out.println(d.getMessage());
				System.out.println("Transaction Failure");
				System.exit(0); 
		 }
	 }
	 
	 void checkBalance()
	 {
		 System.out.println("Balance is:" +bal);
	 }
}







public class BankDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		Bank obj = new Bank();
		
		System.out.println("............Bank Statement....................");
		
		try
		{
			while(true)
			{
				System.out.println("1. Create Account \t 2. Check Balance \t 3. Deposit \t 4. Withdraw \t 5. Interest \t 6. Exit ");
				
				int ch = in.nextInt();
				
				
				switch(ch)
				{
				case 1:
					obj.CreateAcc();
					break;
					
				case 2:
					obj.checkBalance();
					break;
					
				case 3:
					obj.Deposit();
					break;
					
				case 4:
					obj.Withdraw();
					break;
					
				case 5:
					obj.Interest();
					break;
					
				case 6:
					System.exit(0);
					break;
					
					default: System.out.println("Invalid option");
				
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(" No Exception");
		}

	}

}
