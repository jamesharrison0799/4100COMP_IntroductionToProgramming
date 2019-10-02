package supplementary;

public class SupplementaryTasks {
	
	public static void main(String[] args) {
		
		//1. Stock Commission
		
		int numOfShares = 600;
		double shareValue = 21.77, commission = ((numOfShares*shareValue)/100)*2;
		System.out.println("Ted owes the broker £"+commission+" in commission.");
		
		
		//2. Temperature Conversion
		
		int fahrenheit = 96, celcius = ((fahrenheit-32)*5)/9;
		System.out.println("Fahrenheit: "+fahrenheit+" Celcius: "+celcius);
	
		//3. Energy Drink Consumption
		
		int numOfPeople = 12467, frequentBuyersPercentage = 12, preferCitrusPercentage = 64;
		int customersThatPreferCitrusFlavour = ((((numOfPeople)/100)*frequentBuyersPercentage)/100)*preferCitrusPercentage;
		System.out.println("Customers that prefer citrus flavour: "+customersThatPreferCitrusFlavour);
	}

}
