package com.ssafy.corona.virus;

import java.util.Arrays;

public class VirusMgrImpl implements VirusMgr {
	private Virus[] virus;
	private int index;

	public VirusMgrImpl() {
		virus = new Virus[100];
	}

	@Override
	public void add(Virus v) throws DuplicatedException {
		try {
			search(v.getName());
			if(search(v.getName()) != null)
				throw new DuplicatedException(v.getName() + " : 중복된 바이러스 입니다.");
		} catch (NotFoundException e) {
			System.out.println(v.getName() + " 등록");
			virus[index++] = v;
		}
	}

	@Override
	public Virus[] search() {
		Virus[] v = Arrays.copyOfRange(virus, 0, index);
		return v;
	}

	@Override
	public Virus search(String name) throws NotFoundException {

		for (int i = 0; i < virus.length; i++) {
			try {
				if (virus[i].getName().equals(name)) {
					return virus[i];
				}
			} catch (NullPointerException e) {
				throw new NotFoundException(name + ": 미등록 바이러스입니다.");
			}
		}
		return null;
	}

}
