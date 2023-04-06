package com.ssafy.mybatis.util;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyAppSqlConfig {
	private static SqlSessionFactory sqlFactory;
	static {
		try {
			String resource = "mybatis/sqlMapConfig.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			sqlFactory = 
					new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlFactory;
	}
}