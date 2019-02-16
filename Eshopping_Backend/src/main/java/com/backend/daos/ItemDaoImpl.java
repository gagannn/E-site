package com.backend.daos;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.backend.models.Item;
import com.backend.models.Product;

@Repository("itemDao")
@Transactional
public class ItemDaoImpl implements ItemDao {

	@Autowired
	SessionFactory SessionFactory;
	
	@Override
	public boolean addItem(Item item) {
		try{
			Session session=SessionFactory.getCurrentSession();
		session.save(item);
		return true;
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return false;
	}

	@Override
	public boolean updateItem(Item item) {
		try{
			Session session=SessionFactory.getCurrentSession();
	
		session.update(item);
		return true;
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return false;
	}

	@Override
	public boolean deleteItem(int itemId) {
		try{
			Session session=SessionFactory.getCurrentSession();
			Item obj=(Item)session.get(Item.class, itemId);
		session.delete(obj);
		return true;
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return false;
	}

	@Override
	public Item getItemByProductIdAndCustomerId(int productId, String customerId) {
		try{
			Session session=SessionFactory.getCurrentSession();
		//Item obj=(Item)session.get(Item.class, productId,customerId);

		return null;
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return null;
	}

	@Override
	public List<Item> getItemsListByCart(int cartId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean increaseQuantity(int itemId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean decreaseQuantity(int itemId) {
		// TODO Auto-generated method stub
		return false;
	}

}
