package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {
	private Integer numer;
	private Date date;
	private Double totalValue;

	List<Installment> installements = new ArrayList<Installment>();
	public Contract(){
	}
	public Contract(Integer numer, Date date, Double totalValue) {

		this.numer = numer;
		this.date = date;
		this.totalValue = totalValue;

	}
	public Integer getNumer() {
		return numer;
	}
	public void setNumer(Integer numer) {
		this.numer = numer;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}
	public List<Installment> getInstallements() {
		return installements;
	}
	
	
	
}
