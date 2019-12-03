package tutorial15;

import java.util.ArrayList;

public class Task2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float taxRate = (float) 0.2;
		
		ArrayList<Float> incomes = new ArrayList<>();
		
		
		//Generate incomes
		for(int i = 0; i < 5; i++) {
			incomes.add((float) (Math.random() * 10000));
		}
		
		System.out.println("Taxable incomes contributing to total payable tax:\n");
		for(float i:incomes) {
			System.out.printf("£%.2f\n",i);
		}
		System.out.printf("TaxRate: %.0f%% \nTotal tax payable: £%.2f",taxRate*100, (float) calculateTaxes(incomes,(float)taxRate));
	}

	public static float calculateTax(float income, float taxRate) {
		
		float totalTax = income * taxRate;
		
		return totalTax;
	}
	
	public static float calculateTaxes(ArrayList<Float> incomes, float taxRate) {
		
		float totalTaxForMany = 0 ;
		
		for(Float i: incomes) {
			totalTaxForMany += calculateTax(i,taxRate);
		}
		
		return totalTaxForMany;
		
	}
}
