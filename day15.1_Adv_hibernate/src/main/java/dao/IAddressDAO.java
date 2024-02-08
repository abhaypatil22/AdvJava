package dao;

import pojos.AddressEntity;

public interface IAddressDAO {
	
	//add a method to save address details, linked to a student
	String assignAddressDetails(int studentId, AddressEntity address);

}
