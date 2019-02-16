package com.backend.daos;



import java.util.List;
import com.backend.models.Supplier;



public interface SupplierDao {

	public boolean addSupplier(Supplier supp);
	public boolean deleteSupplier(Supplier supp);
	public boolean updateSupplier(Supplier supp);
	public Supplier getSupplier(int supplierId);
	public List<Supplier> getAllSuppliers();
}
