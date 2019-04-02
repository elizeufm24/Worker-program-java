package br.com.spoc.aplication;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import br.com.spoc.entities.Department;
import br.com.spoc.entities.HourContract;
import br.com.spoc.entities.Worker;
import br.com.spoc.entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		    System.out.println("============= PROGRAM ============");
		    System.out.print("Enter with department's name: ");
			String department = sc.nextLine();
			System.out.println("Enter worker data:");
            System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Level: ");
			String level = sc.nextLine();
			System.out.print("Base salary: ");
			double baseSalary = sc.nextDouble();
			sc.nextLine();
		    Worker worker = new Worker(name, WorkerLevel.valueOf(level.toUpperCase()), baseSalary, new Department(department));
		
			System.out.print("How many contracts to this worker: ");
			int numOfContracts = sc.nextInt();
			
			for(int i=0; i<numOfContracts; i++) {
				System.out.println("Enter with contract #"+(i+1) + " data:");
				System.out.print("Date (dd/MM/yyyy): ");
				Date date = sdf.parse(sc.next());
				System.out.print("Value per hour: ");
				double valuePerHour = sc.nextDouble();
				System.out.print("Hours: ");
				int hours = sc.nextInt();
				HourContract contract = new HourContract(date, valuePerHour, hours);
				worker.addContracts(contract);
			}
		
			System.out.println();
			sc.nextLine();
			System.out.print("Enter with month and year to calculate income (MM/yyyy): ");
			String data = sc.nextLine();
			System.out.println("Name: " +worker.getName());
			System.out.println("Department: " +worker.getDepartment().getName());
			int month = Integer.parseInt(data.substring(0, 2));
			int year = Integer.parseInt(data.substring(3));
			System.out.println("Income for "+ data + ": " + String.format(" R$%.2f",worker.income(month, year)));
			
			
		sc.close();
    }
}

