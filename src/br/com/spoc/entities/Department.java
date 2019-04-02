/*
 * Essa classe é responsável por informar o departamento do trabalhador;
 * onde cada trabalhador tem um department e um department tem vários trabalhadores;
 */

package br.com.spoc.entities;

public class Department {
	
	private String name;
	
	public Department() {
	}

	public Department(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
}
