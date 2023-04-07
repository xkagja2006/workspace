package com.ssafy.mybatis.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.ssafy.mybatis.model.Member;
import com.ssafy.mybatis.util.MyAppSqlConfig;

public class TestDaoImpl1 implements TestDao {
	private SqlSessionFactory sqlSessionFactory;
	private static String NS = "com.ssafy.mybatis.model.dao.TestMapper1.";

	public TestDaoImpl1() {
		sqlSessionFactory = MyAppSqlConfig.getSqlSessionFactory();
	}

	@Override
	public List<Member> selectMember() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Member> list = sqlSession.selectList(NS + "selectMember");
		return list;
		// return sqlSessionFactory.openSession().selectList(NS + "selectMember");
	}

	@Override
	public void insertMember(Member member) {
		SqlSession sqlSession = sqlSessionFactory.openSession(); // openSession(true) : 자동커밋.
		sqlSession.insert(NS + "insertMember", member);
		sqlSession.commit();
	}

	@Override
	public void updateMember(Member member) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMember(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession(); // openSession(true) : 자동커밋.
		sqlSession.delete(NS + "deleteMember", id);
		sqlSession.commit();
	}

}
