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
			addScoop(new Scoop(br));
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
		
		count = scoops.size();
		out.write(count + "\n");
		for (int i = 0; i < count; i++){
			scoops.get(i).save(out);
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
