/*
 * Essa classe é reponsável por criar novos trabalhadores, como também associalos a um
 * departamento, adicionar e retirar contratos da ficha do mesmo, além disso calcular
 * o seu remdimento mensal, através do método #income();
 * 
 * @autor::elizeuebay@gmail.com  25-03-2019
 */
package br.com.spoc.entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.spoc.entities.enums.WorkerLevel;

public class Worker {
	
	private String name;
	
//Aqui uma associação com o enum WorkLevel;
	private WorkerLevel level;
	
	private Double baseSalary;
	
//Aqui temos uma associção com a classe Department pois um Worker tem um Department;
	private Department department;
	
/*
 * Já aqui temos uma associaçaõ com uma lista da classe &HourContract pois worker pode ter
 * vários contracts...
 * Em uma relação de um pode ter vários é representada por uma lista...
 */	
	private List<HourContract> hourContracts = new ArrayList<>();

//Construtor padrão;	
	public Worker() {
	}
//Construtor com argumentos;
	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
		
//Metodos acessores geters and seters;		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public WorkerLevel getLevel() {
		return level;
	}
	public void setLevel(WorkerLevel level) {
		this.level = level;
	}
	public Double getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public List<HourContract> getHourContracts() {
		return hourContracts;
	}
	/*
	 * Esse metodo acrescenta contratos á lista de contratos do trabalhador;
	 */
	public void addContracts(HourContract contract) {
		hourContracts.add(contract);
	}
	/*
	 * Esse metodo remove contratos da lista de contratos do trabalhador;
	 */
	public void removeContract(HourContract contract) {
		hourContracts.remove(contract);
	}
	/*
	 * Usamos a classe Calendar para trabalhar com as datas referentes ao contrato e ao
	 * método #income() para calcular os proventos do trabalhador...nessa data;
	 */
	Calendar cal = Calendar.getInstance();
	/*
	 * Método responsável por calcular o redimento mensal do trabalhador;
	 */
	public Double income(int month, int year) {
		Double sum = baseSalary;
		/*
		 * O médoto #income() recebe dois paramentros o +mes e o +ano ou seja uma data. Essa
		 * data é usada para calcular os proventos do tralhador nesse período.
		 * O objeto @cal da classe &Calendar seta a data do contrato e estrai o +mes e o +ano
		 * de cada contrato iterado pelo foreach, e se esse +mes e esse +ano for igual ao +mes
		 * e +ano recebido pelo parametro do metodo #income(), o valor desse contrato sera 
		 * acrescentado a variável *sum atraves do método #totalValue() oferecido pela classe 
		 * %HourContract. 
		 */
		for(HourContract c : hourContracts) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
		    int c_month = 1 + cal.get(Calendar.MONTH);
		    
			if(c_year == year && c_month == month) {
	            sum += c.totalValue();
			}
		}
		return sum;
	}
	
	
	
	

}
