package a01164474.data.util;

import java.util.Comparator;

import a01164474.data.Customer;

/**
 * Project: Lab4
 * @author Nathan de Souza - A01164474
 */
public class CompareByJoinedDate implements Comparator<Customer> {

	@Override
	public int compare(Customer o1, Customer o2) {
		return o1.getJoinDate().compareTo(o2.getJoinDate());
	}

}
