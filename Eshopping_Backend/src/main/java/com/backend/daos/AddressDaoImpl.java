package com.backend.daos;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.backend.models.Address;
import com.backend.models.Product;

@Repository("addressDao")
@Transactional
public class AddressDaoImpl implements AddressDao {

	@Autowired
	SessionFactory SessionFactory;

	@Override
	public boolean insertAddress(Address address) {
		try{
			Session session=SessionFactory.getCurrentSession();
			session.save(address);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Address getAddressById(int addressId) {
		try{
			Session session=SessionFactory.getCurrentSession();
			Address obj=(Address)session.get(Address.class, addressId);
			return obj;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateAddress(Address address) {
		try{
			Session session=SessionFactory.getCurrentSession();
			session.update(address);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteAddress(Address address) {
		try{
			Session session=SessionFactory.getCurrentSession();
			session.delete(address);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Address> getAddressForUser(String customerId) {
		try{
			Session session=SessionFactory.getCurrentSession();
			Query q = session.createQuery("from Address where userObj.email=:x");
			q.setParameter("x",customerId);
			List<Address> list =q.getResultList();
			return list;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
