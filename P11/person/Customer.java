package person;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Customer extends Person{
	public Customer(String name, String phone){
		super(name, phone);
	}
	
	public Customer(BufferedReader in) throws IOException{
		super(in);
	}
	
	public void save(BufferedWriter out) throws IOException{
		super.save(out);
	}
	
	@Override
	public String toString(){
		return name;
	} 
}
