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
		ArrayList<MixInFlavor> mixInFlavors = new ArrayList <>();
		ArrayList<IceCreamFlavor> iceCreamFlavors = new ArrayList <>();
		ArrayList<Scoop> scoops = new ArrayList <>();
		int count = mixInFlavors.size();		
		for (int i = 0; i < count; i++){
			MixInFlavor flavor = new MixInFlavor(br);		
			mixInFlavors.add(i, flavor);
		}
		count = iceCreamFlavors.size();
		for (int i = 0; i < count; i++){
			IceCreamFlavor flavor = new IceCreamFlavor(br);		
			iceCreamFlavors.add(i, flavor);
		}
		count = scoops.size();
		for (int i = 0; i < count; i++){
			Scoop scoop = new Scoop(br);		
			scoops.add(i, scoop);
		}
	}
	
	public void save(BufferedWriter out) throws IOException{
		int count = mixInFlavors.size();
		for (int i = 0; i < count; i++){
			out.write("" + toString() + '\n');
		}
		
		count = iceCreamFlavors.size();
		for (int i = 0; i < count; i++){
			out.write("" + toString() + '\n');
		}
		
		count = scoops.size();
		for (int i = 0; i < count; i++){
			out.write("" + toString() + '\n');
		}
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
