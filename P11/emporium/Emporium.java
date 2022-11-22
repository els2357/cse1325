package emporium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import product.IceCreamFlavor;
import product.MixInFlavor;
import product.MixInAmount;
import product.MixIn;
import product.Container;
import product.Order;
import product.Serving;
import product.Scoop;
import person.Person;
import person.Customer;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Emporium{
	private ArrayList<MixInFlavor> mixInFlavors = new ArrayList <>();
	private ArrayList<IceCreamFlavor> iceCreamFlavors = new ArrayList <>();
	private ArrayList<Container> containers = new ArrayList <>();
	private ArrayList<Order> orders = new ArrayList <>();
	private ArrayList<Customer> customers = new ArrayList <>();
	private MultiMap<Customer, Serving> favoriteServings = new MultiMap<>();
	
	public Emporium(){
	}
	
	public Emporium(BufferedReader br) throws IOException{
		int count = Integer.parseInt(br.readLine());		
		
		for (int i = 0; i < count; i++){
			addIceCreamFlavor(new IceCreamFlavor(br));
		}
		
		count = Integer.parseInt(br.readLine());
		for (int i = 0; i < count; i++){
			addMixInFlavor(new MixInFlavor(br));
		}
			
		count = Integer.parseInt(br.readLine());
		for (int i = 0; i < count; i++){
			addContainer(new Container(br));
		}
		
		count = Integer.parseInt(br.readLine());
		for (int i = 0; i < count; i++){
			addOrder(new Order(br));
		}
		
		count = Integer.parseInt(br.readLine());
		for (int i = 0; i < count; i++){
			addCustomer(new Customer(br));
		}
	}
	
	public void save(BufferedWriter out) throws IOException{
		int count = iceCreamFlavors.size();
		out.write(count + "\n");
		for (int i = 0; i < count; i++){
			iceCreamFlavors.get(i).save(out);
		}
		
		count = mixInFlavors.size();
		out.write(count + "\n");
		for (int i = 0; i < count; i++){
			mixInFlavors.get(i).save(out);
		}
		
		count = containers.size();
		out.write(count + "\n");
		for (int i = 0; i < count; i++){
			containers.get(i).save(out);
		}
		
		count = orders.size();
		out.write(count + "\n");
		for (int i = 0; i < count; i++){
			orders.get(i).save(out);
		}
		
		count = customers.size();
		out.write(count + "\n");
		for (int i = 0; i < count; i++){
			customers.get(i).save(out);
		}
	}
	
	public void addCustomer(Customer customer){
		customers.add(customer);
	}
	
	public void addMixInFlavor(MixInFlavor flavor){
		mixInFlavors.add(flavor);
	}
	
	public void addIceCreamFlavor(IceCreamFlavor flavor){
		iceCreamFlavors.add(flavor);
	}
	
	public void addContainer(Container container){
		containers.add(container);
	}
	
	public void addOrder(Order order){
		orders.add(order);
		Customer customer = order.getCustomer();
		for(Object o : order.servings()){
			favoriteServings.put(customer, (Serving) o);
		}
	}
	
	public Object[] customers(){
		Object[] customersObject = customers.toArray();
		return customersObject;
	}
	
	public Object[] mixInFlavors(){
		Object[] mixInFlavorsObject = mixInFlavors.toArray();
		return mixInFlavorsObject;
	}
	
	public Object[] iceCreamFlavors(){
		Object[] iceCreamFlavorsObject = iceCreamFlavors.toArray();
		return iceCreamFlavorsObject;
	}
	
	public Object[] containers(){
		Object[] containersObject = containers.toArray();		
		return containersObject;
	}
	
	public Object[] orders(){
		Object[] ordersObject = orders.toArray();		
		return ordersObject;
	}
	
	public Object[] favoriteServings(Customer customer){
		Object[] ordersObject = favoriteServings.get(customer);		
		return ordersObject;
	}
}
