import java.text.DecimalFormat;
import java.util.Scanner;

public class CurrencyConverterPart2 {
public static void main(String[]args) {
	double amount;
	double ruppee, dollar, yen, ringgit,pound, euro;
	int choice;
	DecimalFormat f = new DecimalFormat("##.#3");
	Scanner obj = new Scanner(System.in);
	
	System.out.println("Select your choice to convert from :");
	System.out.println("Enter 1 : Ruppee");
	System.out.println("Enter 2 : Dollar");
	System.out.println("Enter 3 : Pound");
	System.out.println("Enter 4 : Euro");
	System.out.println("Enter 5 :Yen ");
	System.out.println("Enter 6 : Ringgit");
	
	System.out.println("Choose from above option");
	choice = obj.nextInt();
	
	System.out.println("Enter the amount you want to convert : ");
	amount = obj.nextFloat();
	
	switch(choice) {
	
	case 1 ://ruppe conversion.
		dollar = amount/70;
		System.out.println(amount + " Ruppee = " + f.format(dollar) + "Dollar");
		
		pound = amount/88;
		System.out.println(amount + "Ruppee = " + f.format(pound) + "Pound");
		
		euro = amount/80;
		System.out.println(amount + "Ruppee = " + f.format(euro) + "Euro");
		
		yen = amount/0.63;
		System.out.println(amount + "Ruppee = " + f.format(yen) + "Yen");
		
		ringgit = amount/16;
		System.out.println(amount + "Ruppee = " + f.format(ringgit) + "Ringgit");
		break;
		
	case 2: //Dollar conversion.
		ruppee = amount * 70;
		System.out.println(amount + "Dollar = " + f.format(ruppee) + "Ruppes");
		
		pound = amount * 0.78;
		System.out.println(amount + "Dollar = " + f.format(pound) + "Pound");
		
		euro = amount * 0.87;
		System.out.println(amount + "Dollar = " + f.format(euro) + "Euro");
		
		yen = amount * 111.087;
		System.out.println(amount + "Dollar = " + f.format(yen) + "Yen");
		
		ringgit = amount * 4.17;
		System.out.println(amount + "Dollar = " + f.format(ringgit) + "Ringgit");
		break;
		
	case 3: // Pound.
		ruppee = amount * 88;
		System.out.println(amount + "Pound = " + f.format(ruppee) + "Ruppee");
		
		dollar = amount *88;
		System.out.println(amount + "pound = " + f.format(dollar) + "Dollar");
		
		euro = amount * 1.10;
		System.out.println(amount + "pound = " + f.format(euro) + "Euro" );
		
		yen = amount * 140.93;
		System.out.println(amount + "pound = " + f.format(yen) + "Yen");
		
		ringgit = amount * 5.29;
		System.out.println(amount + "pound = " + f.format(ringgit) + "Ringgit");
		break;
		
		
	case 4 ://Euro Conversion
		ruppee = amount * 80;
		System.out.println(amount + "Euro = " + f.format(ruppee) + "Ruppee");
		
		dollar = amount * 1.14;
		System.out.println(amount + "Euro = " + f.format(dollar) + "Dollar" );
		
		pound = amount * 0.90;
		System.out.println(amount + "Euro = " + f.format(pound) + "Pound");
		
		yen = amount * 127.32;
		System.out.println(amount + "Euro = " + f.format(yen) + "yen");
		
		ringgit = amount * 4.78;
		System.out.println(amount + "Euro = " + f.format(ringgit) + "Ringgit");
		break;
		
	case 5 ://Yen conversion.
		
		ruppee = amount * 0.63;
		System.out.println(amount + "Yen = " + f.format(ruppee) + "Ruppee");
		
		dollar = amount * 0.008;
		System.out.println(amount + "Yen = " + f.format(dollar) + "Dollar");
		
		euro = amount * 0.007;
		System.out.println(amount + "Yen = " + f.format(euro) + "Euro");
		
		pound  = amount * 0.007;
		System.out.println(amount + "Yen = " + f.format(pound) + "Pound");
		
		ringgit = amount * 0.037;
		System.out.println(amount + "Yen = " + f.format(ringgit) + "Ringgit");
		break;
		
	case 6: //ringgit conversion.
		
		ruppee = amount * 16.8;
		System.out.println(amount + "Ringgit = " + f.format(ruppee) + "Ruppee");
		
		dollar = amount * 0.239;
		System.out.println(amount + "Ringgit = " + f.format(dollar) + "Dollar");
		
		pound = amount * 0.188;
		System.out.println(amount + "Ringgit = " + f.format(pound) + "Pound");
		
		euro = amount * 0.209;
		System.out.println(amount + "Ringgit = " + f.format(euro) + "Euro");
		
		yen = amount * 26.63;
		System.out.println(amount + "Ringgit = " + f.format(yen) + "Yen");
		break;
		
		default : 
			System.out.println("Invalid input.");
	}
	
	obj.close();	
}
}
