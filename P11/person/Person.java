package person;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Person{
	protected String name;
	protected String phone;
	
	public Person(String name, String phone){
		this.name = name;
		this.phone = phone;
	}
	
	public Person(BufferedReader in) throws IOException{
		this.name = in.readLine();
		this.phone = in.readLine();		
	}
	
	public void save(BufferedWriter out) throws IOException{
		out.write("" + name + '\n');
		out.write("" + phone + '\n');
	}
	
	@Override
	public String toString(){
		return name;
	}
	
	//@Override
	public boolean equals(Person rhs){
		return true;
	}
	
	@Override
	public int hashCode(){
		return 0;
	}
}
