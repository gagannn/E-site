package com.backend.daos;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.backend.models.Supplier;

@Repository("supplierDao")
@Transactional
public class SupplierDaoImpl implements SupplierDao {

	@Autowired
	SessionFactory SessionFactory;

	public boolean addSupplier(Supplier supp) {
		try {
			Session session=SessionFactory.getCurrentSession();
			session.save(supp);
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteSupplier(Supplier supp) {
		try {
			Session session=SessionFactory.getCurrentSession();
			session.delete(supp);
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateSupplier(Supplier supp) {
		try {
			Session session=SessionFactory.getCurrentSession();
			session.update(supp);
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public Supplier getSupplier(int supplierId) {
		try {
			Session session=SessionFactory.getCurrentSession();
			Supplier supp=(Supplier)session.get(Supplier.class, supplierId);
			return supp;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public List<Supplier> getAllSuppliers() {
		try {
			Session session=SessionFactory.getCurrentSession();
			Query query=session.createQuery("from Supplier");
			List<Supplier> list=query.getResultList();
			return list;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
