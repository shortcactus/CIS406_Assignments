//Amanda Parten CIS406 Order Entry Phase 3
package orderEntryPhase3;

import java.util.Scanner;
import java.util.InputMismatchException;

public class OrderEntryPhase3 {
	//Instance Variables
	private String itemNumber;
	private String itemDescription;
	private Double itemPrice = 0.0;
	private Double grossAmount = 0.0;
	private Integer itemQuantity = 0;
	private Double taxPercentage = 0.0;
	private Double taxAmount = 0.0;
	private Double discountPercent = 0.0;
	private Double discountAmount = 0.0;
	private Double itemNetAmt = 0.0;
	

	
	private void getData()
	{

	Scanner input = new Scanner(System.in);	
	//Keep reading new order lines

		
			try
			{
				//Get itemNumber from user input
				System.out.print("Enter the item number: ");
				itemNumber = input.nextLine();
				
				//Get itemDescription from user input
				System.out.print("Enter the item description: ");
				itemDescription = input.nextLine();
				
				//Get itemPrice from user
				System.out.print("Enter item price: $");
				itemPrice = input.nextDouble();
				
				//Get itemQuantity from user
				System.out.print("Enter item quantity: ");
				itemQuantity = input.nextInt();
				
				//Get itemTax from user
				System.out.print("Enter the tax percentage for this item: ");
				taxPercentage = input.nextDouble();
				
				//Get itemDiscount from user
				System.out.print("Enter the discount percentage for this item: ");
				discountPercent = input.nextDouble();
			}
			catch (InputMismatchException e)
			{
				System.out.println("Input format error!");
				e.printStackTrace();
			}
			catch (Exception e)
			{
				System.out.println("Some other input error!");
			}
			
			//Calculations
			//Get grossAmount
			grossAmount = itemPrice * itemQuantity;
			
			//Get taxAmount
			taxAmount = (grossAmount * taxPercentage) / 100.00;
			grossAmount += taxAmount; //Add tax to gross
			
			//Get discount amount
			discountAmount = (grossAmount * discountPercent) / 100.00;
			
			//Get itemNetAmt
			itemNetAmt = grossAmount - discountAmount; //apply discount; 
	
		
		
	}
	
	public String toString()
	{
		return("\nOrder Details:\n"+
				"\nItem Number \tItem Description \tItem Price \tItem Quantity \tTax % \tItem Tax \tGross Amount \tDiscount % \tItem Discount \tNet Amount"
				+"\n------------------------------------------------------------------------------------------------------------------------------------------------------------\n"
				+ itemNumber + 
				"\t\t" + itemDescription + 
				"\t\t$" + itemPrice + 
				"\t\t" + itemQuantity + 
				"\t\t" + taxPercentage + 
				"\t$" + taxAmount + 
				"\t\t$" + grossAmount +
				"\t\t" + discountPercent +
				"\t\t$" + discountAmount +
				"\t\t$" + itemNetAmt
				);
				
	}
	
	
	
	
	public static void main(String[] args) {

		//Display information
		OrderEntryPhase3 myOrder = new OrderEntryPhase3();
		Scanner input = new Scanner(System.in);
		
		char moreItems = 'y';
		
		do
		{
			//Get Data for order
			myOrder.getData();
			
			//Display Details for order 
			System.out.println(myOrder.toString());
			
			//Continue?
			System.out.print("Are there more items to enter? (y/n): ");
			moreItems = input.next().charAt(0);
			input.nextLine();
		} while (moreItems != 'n' && moreItems != 'N');
		
		input.close();

	}

}
