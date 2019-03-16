package com.backend.config;



import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.backend.models.Address;
import com.backend.models.Cart;
import com.backend.models.Category;
import com.backend.models.Item;
import com.backend.models.Order;
import com.backend.models.OrderItems;
import com.backend.models.Payment;
import com.backend.models.Product;
import com.backend.models.Supplier;
import com.backend.models.User;
import com.backend.validators.CategoryValidator;
import com.backend.validators.LoginValidator;
import com.backend.validators.MyPasswordValidator;
import com.backend.validators.PaymentValidator;
import com.backend.validators.PhoneNoValidator;
import com.backend.validators.ProductImageValidator;
import com.backend.validators.SupplierValidator;



@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages={"com.backend.config","com.backend.daos","com.backend.models"})
public class DBConfig {

	@Bean(name="dataSource")
	public DataSource getDataSource(){
	DriverManagerDataSource dataSource=new DriverManagerDataSource();	
	dataSource.setDriverClassName("org.h2.Driver");
	dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
	dataSource.setUsername("sa");
	dataSource.setPassword("");
	return dataSource;
	}
	
	@Bean(name="passwordEncoder")
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(){
		Properties p=new Properties();
		p.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		p.setProperty("hibernate.hbm2ddl.auto", "update");
		p.setProperty("hibernate.show_sql","true");
		
		LocalSessionFactoryBuilder sb=new LocalSessionFactoryBuilder(getDataSource());
		sb.addProperties(p);
		sb.scanPackages("com.mybackend.daos","com.mybackend.models");
		sb.addAnnotatedClass(Category.class);
		sb.addAnnotatedClass(Product.class);
		sb.addAnnotatedClass(Supplier.class);
		sb.addAnnotatedClass(User.class);
		sb.addAnnotatedClass(MyPasswordValidator.class);
		sb.addAnnotatedClass(Cart.class);
		sb.addAnnotatedClass(Address.class);
		sb.addAnnotatedClass(LoginValidator.class);
		sb.addAnnotatedClass(Item.class);
		sb.addAnnotatedClass(Order.class);
		sb.addAnnotatedClass(Payment.class);
		sb.addAnnotatedClass(OrderItems.class);
		sb.addAnnotatedClass(PhoneNoValidator.class);
		sb.addAnnotatedClass(ProductImageValidator.class);
		sb.addAnnotatedClass(SupplierValidator.class);
		sb.addAnnotatedClass(CategoryValidator.class);
		sb.addAnnotatedClass(PaymentValidator.class);
		return sb.buildSessionFactory();
	}
	
	@Bean(name="hibernateTransaction")
	@Autowired
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory){
	HibernateTransactionManager txManager=new HibernateTransactionManager(sessionFactory);
	return txManager;
	}
}
