package service;

import java.util.Calendar;
import java.util.Date;

import entities.Contract;
import entities.Installment;

public class ContractService {
	private OnlinePaymentService onlinePaymentService;
	private PaypalService paypalService;
	
	public ContractService(OnlinePaymentService onlinePaymentService){
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public void processContract(Contract contract, Integer months) {
		double number = contract.getTotalValue()/ months;
		for(int month = 1; month <= months; month++) {
		
			double abQuota = number + onlinePaymentService.interest(number, month);
			double acQuota = abQuota + onlinePaymentService.paymentFee(abQuota);
			Date addMonths = calendar(contract.getDate(), month );
			contract.getInstallements().add(new Installment(addMonths, acQuota));
		}
	
	}
	public Date calendar(Date date, int n) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, n);
		return calendar.getTime();
	}
		
}
