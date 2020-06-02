package a01164474;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

import a01164474.ApplicationException;
import a01164474.data.Customer;
import a01164474.data.util.CompareByJoinedDate;
import a01164474.io.CustomerReader;
import a01164474.io.CustomerReport;

/**
 * Project: lab4
 * @author Nathan de Souza - A01164474
 */
public class Lab4 {
	
	private static final Instant startTime = Instant.now();
	
	public static void main(String[] args) throws ApplicationException {
		System.out.println("------------------------------");
		System.out.println(startTime);
		System.out.println("------------------------------");
		if (args.length == 0) {
			System.out.println("Input data is missing.");
			printTime();
			System.exit(-1);
		} else {
			new Lab4().run(args[0]);
		}	
	} 	
	
	private void run(String inputData) throws ApplicationException {
		
		try {
			List<Customer> listOfcustomers = CustomerReader.arrayOfCustomer(inputData);
			listOfcustomers.sort(new CompareByJoinedDate());
			CustomerReport.write(listOfcustomers);
		} catch (ApplicationException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println();
			System.out.println("------------------------------");
			printTime();
			System.out.println("------------------------------");
		}
	}
	
	public static void printTime() {
		Instant time = Instant.now();
		System.out.println(time);
		System.out.println(String.format("Duration: %d ms", Duration.between(startTime, time).toMillis()));
	}
}
