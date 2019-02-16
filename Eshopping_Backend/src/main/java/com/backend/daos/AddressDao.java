package com.backend.daos;

import java.util.List;

import com.backend.models.Address;

public interface AddressDao {

	public boolean insertAddress(Address address);
	public Address getAddressById(int addressId);
	public boolean updateAddress(Address address);
	public boolean deleteAddress(Address address);
	public List<Address> getAddressForUser(String customerId);
}
