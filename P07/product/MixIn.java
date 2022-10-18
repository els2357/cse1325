package product;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MixIn{
	private MixInFlavor flavor;
	private MixInAmount amount;
	
	public MixIn(MixInFlavor flavor, MixInAmount amount){
		this.flavor = flavor;
		this.amount = amount;
	}
	
	public MixIn(BufferedReader in) throws IOException{
		flavor = new MixInFlavor(in);
		this.amount = MixInAmount.valueOf( in.readLine() );
	}
	
	public void save(BufferedWriter out) throws IOException{
		flavor.save(out);
		out.write("" + amount + "\n");
	}
	
	@Override
	public String toString(){
		if (amount.equals(MixInAmount.Normal)){
			return "" + flavor;
		}
		
		return flavor + "(" + amount + ")";
	}
}
