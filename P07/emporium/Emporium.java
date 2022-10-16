package emporium;

import java.util.ArrayList;
import product.IceCreamFlavor;
import product.MixInFlavor;
import product.MixInAmount;
import product.MixIn;
import product.Scoop;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Emporium{
	private ArrayList<MixInFlavor> mixInFlavors = new ArrayList <>();
	private ArrayList<IceCreamFlavor> iceCreamFlavors = new ArrayList <>();
	private ArrayList<Scoop> scoops = new ArrayList <>();
	
	public Emporium(){
	}
	
	public Emporium(BufferedReader br) throws IOException{
		
	}
	
	public void save(BufferedWriter out) throws IOException{
	}
	
	public void addMixInFlavor(MixInFlavor flavor){
		mixInFlavors.add(flavor);
	}
	
	public void addIceCreamFlavor(IceCreamFlavor flavor){
		iceCreamFlavors.add(flavor);
	}
	
	public void addScoop(Scoop scoop){
		scoops.add(scoop);
	}
	
	public Object[] mixInFlavors(){
		Object[] mixInFlavorsObject = mixInFlavors.toArray();
		return mixInFlavorsObject;
	}
	
	public Object[] iceCreamFlavors(){
		Object[] iceCreamFlavorsObject = iceCreamFlavors.toArray();
		return iceCreamFlavorsObject;
	}
	
	public Object[] scoops(){
		Object[] scoopsObject = scoops.toArray();		
		return scoopsObject;
	}
}
