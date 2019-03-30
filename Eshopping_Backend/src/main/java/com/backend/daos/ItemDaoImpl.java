package com.backend.daos;

import java.util.List;

import javax.persistence.Query;
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
		System.out.println(productId+" "+customerId);
		try{
			Session session=SessionFactory.getCurrentSession();
			Query query=session.createQuery("from Item where customerId=:a and product.productId=:b");
			query.setParameter("a",customerId);
			query.setParameter("b",productId);
			List<Item> items=query.getResultList();
			System.out.println("list = "+items);
			if(items.size()==0){
				return null;
			}
			else {
				return items.get(0);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;	
	}

	@Override
	public List<Item> getItemsListByCart(int cartId) {
		try{
			Session session=SessionFactory.getCurrentSession();
			Query query=session.createQuery("from Item where cart.cartId=:x ");
			query.setParameter("x",cartId);
			List<Item> items=query.getResultList();
			if(items.size()==0){
				return null;
			}
			else {
				return items;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean increaseQuantity(int itemId) {
		try {
			Session session=SessionFactory.getCurrentSession();
			Item itemObj=session.get(Item.class,itemId);
			itemObj.setQuantity(itemObj.getQuantity()+1);
			session.merge(itemObj);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean decreaseQuantity(int itemId) {
		try {
			Session session=SessionFactory.getCurrentSession();
			Item itemObj=session.get(Item.class,itemId);
			itemObj.setQuantity(itemObj.getQuantity()-1);
			session.merge(itemObj);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Item getItemByItemId(int id) {
		try{
			Session session=SessionFactory.getCurrentSession();
			Item obj=(Item)session.get(Item.class, id);
			return obj;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Double getTotalPrice(int id) {
		List<Item> l=getItemsListByCart(id);
		double sum=0;
		if(l==null)
			return null;
		for(Item i:l) {
			sum+=i.getQuantity()*i.getProduct().getPrice();
		}
		return sum;
	}

}
