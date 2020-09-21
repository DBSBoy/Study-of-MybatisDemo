package com.ibm;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibm.mybatis.dao.UserDao;
import com.ibm.mybatis.model.User;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
	
		InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = sqlSessionFactory.openSession();
		UserDao dao = session.getMapper(UserDao.class);
		User user = dao.findUserById(2);
		System.out.println(user.toString());
	}
	
}
