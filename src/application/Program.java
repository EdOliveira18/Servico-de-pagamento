package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import service.ContractService;
import service.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner entrada = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter contract data");
		System.out.println("Number: ");
		Integer number = entrada.nextInt();
		System.out.println("Date (dd/MM/yyyy): ");
		Date date = sdf.parse(entrada.next());
		System.out.println("Contract value: ");
		Double totalValue = entrada.nextDouble();
		
		Contract contract = new Contract(number, date, totalValue);
		
		System.out.println("Enter number of installments: ");
		int month = entrada.nextInt();
		
		ContractService cs = new ContractService(new PaypalService());
		cs.processContract(contract, month);
		
		
		System.out.println("Installments: ");
		for(Installment it : contract.getInstallements()) {
			System.out.println(it);
		}
		
	}

}
