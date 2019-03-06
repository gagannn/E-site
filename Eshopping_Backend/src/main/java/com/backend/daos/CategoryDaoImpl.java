package com.backend.daos;

import java.util.Collections;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.backend.models.Category;


@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao{


	@Autowired
	SessionFactory SessionFactory;
	
	public boolean addCategory(Category cat) {
		try {
			Session session=SessionFactory.getCurrentSession();
			session.save(cat);
			return true;
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return false;
	}

	public boolean deleteCategory(Category cat) {
		try {
			Session session=SessionFactory.getCurrentSession();
			session.delete(cat);
			return true;
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return false;	}

	public boolean updateCategory(Category cat) {
		try {
			Session session=SessionFactory.getCurrentSession();
			session.update(cat);
			return true;
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return false;
	}

	public Category getCategory(int categoryId) {
		try {
			Session session=SessionFactory.getCurrentSession();
			Category cat=(Category)session.get(Category.class,categoryId);
			return cat;
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return null;
	}

	public List<Category> getAllCategories() {
		try{
			Session session=SessionFactory.getCurrentSession();
			Query query=session.createQuery("from Category");
			List<Category> list=query.getResultList();
			return list;
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return null;
	}

	@Override
	public List<Category> threeCategories() {
		try{
			Session session=SessionFactory.getCurrentSession();
			Query query=session.createQuery("from Category");
			List<Category> list=query.getResultList();
			Collections.shuffle(list);
			List<Category> threeCategory=list.subList(0, 3);
			return threeCategory;
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return null;
	}

}