package com.ssafy.mybatis.test;

import java.util.List;

import com.ssafy.mybatis.model.Member;
import com.ssafy.mybatis.model.dao.TestDao;
import com.ssafy.mybatis.model.dao.TestDaoImpl1;

public class Test1 {
	private TestDao dao = new TestDaoImpl1();

	private void delete(String id) {
		dao.deleteMember(id);
		selectList();
	}

	private void join() {
		// id, name, area, tel
		/*
		 * 회원을 가입 하는 기능 구현
		 * 
		 * id : member7 name : 재곤현곤 area : 서대 tel : 010-1111-2345
		 * 
		 */
		// dao의 insertMember 호출
		String id = "member7";
		String name = "재곤현곤";
		String area = "서대";
		String tel = "010-1111-2345";
		Member member = new Member();
		member.setId(id);
		member.setName(name);
		member.setArea(area);
		member.setTel(tel);

		dao.insertMember(member);
		selectList();
	}

	private void selectList() {
		List<Member> members = dao.selectMember();
		for (Member m : members) {
			System.out.println(m.getId() + "," + m.getName() + "," + m.getArea());
		}
	}

	public static void main(String[] args) {
		Test1 test = new Test1();
//		test.selectList();
//		test.join();
		test.delete("member7");
	}
}
