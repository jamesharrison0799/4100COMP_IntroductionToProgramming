package tutorial15;

public class Task1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		float income = 10239;
		float taxRate = (float) 0.2;
		System.out.printf("Taxable Income: £%.2f\nTaxRate: %.0f%% \nTotal tax payable: £%.2f",income, (float) taxRate*100, (float) calculateTax((float)income,(float)taxRate));
	}

	public static float calculateTax(float income, float taxRate) {
		
		float totalTax = income * taxRate;
		
		return totalTax;
	}
}
