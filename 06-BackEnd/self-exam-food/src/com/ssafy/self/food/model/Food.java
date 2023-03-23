package com.ssafy.self.food.model;

/*
create table food(
		no int auto_increment,
		name varchar(30) not null,
		category varchar(1) not null,
		contents varchar(200),
	    price int default 0,
		primary key(no)
	);
*/
public class Food {
	private int no;
	private String name;
	private String category;
	private String contents;
	private int price;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
