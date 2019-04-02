/*
 * "Essa classe é responsável por criar contratos para os trabalhadores
 * e também calcular o valor do contrato após ser cumprido." 
 * 
 * @autor:elizeuebay@gmail.com
 * --23-03-2019--
 */

package br.com.spoc.entities;         


import java.util.Date;

public class HourContract {
//Variáveis de instacia(atributos),usando wrapper classes e um Date;
	private Date date;
	private Double valuePerHour;
	private Integer hours;
//Construtor padão;
	public HourContract() {
	}
//Construtor com argumentos;
	public HourContract(Date date, Double valuePerHour, Integer hours) {
		this.date = date;
		this.valuePerHour = valuePerHour;
		this.hours = hours;
	}

	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}

	public Double getValuePerHour() {
		return valuePerHour;
	}

	public void setValuePerHour(Double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}
	/*
	 * =>Método totalValue()<=
	 *  Responsável por fazer o calcúlo do valor final do contrato;
	 */
	public Double totalValue() {
		return valuePerHour * hours;
	}
}
