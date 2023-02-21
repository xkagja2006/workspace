package com.ssafy.education.subject;

import java.util.Arrays;

public class SubjectsMgrImpl implements SubjectsMgr {
	private Subject[] subjects;
	private int index;
	
	public SubjectsMgrImpl() {
		subjects=new Subject[100];		
	}
	
	@Override
	public void add(Subject s) throws DuplicatedException{
		System.out.println("과목으로검색함!");
		try {
			search(s.getName());
			throw new DuplicatedException(s.getName()+": 등록된 과목입니다."); 
		} catch (NotFoundException e) {
			subjects[index++]=s;
		}
	}
	@Override
	public Subject[] search() {
		return Arrays.copyOfRange(subjects, 0, index);
	}
	@Override
	public Subject search(String name) throws NotFoundException{
		System.out.println("이름으로 검색함!");
		for(int i=0; i<subjects.length; i++) {
			try {
				if(subjects[i].getName().equals(name)) {
					return subjects[i];
				}
			} catch (NullPointerException e) {
				throw new NotFoundException(name+": 미등록 과목입니다.");
			} 
		}
		return null;
	}
}
