package com.atguigu.mytestcalss;

/**
 * table name:  student
 * author name: FelixChan
 * create time: 2022-05-03 00:47:47
 */ 
public class Student extends EntityHelper{

	private int id;
	private String name;
	private LocalDate birth;

	public Student() {
		super();
	}
	public Student(int id,String name,LocalDate birth) {
		this.id=id;
		this.name=name;
		this.birth=birth;
	}
	public void setId(int id){
		this.id=id;
	}
	public int getId(){
		return id;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setBirth(LocalDate birth){
		this.birth=birth;
	}
	public LocalDate getBirth(){
		return birth;
	}
	@Override
	public String toString() {
		return "student[" + 
			"id=" + id + 
			", name=" + name + 
			", birth=" + birth + 
			"]";
	}
	@Override
	public String getPrimaryKey() {
		return "id";
	}
}

