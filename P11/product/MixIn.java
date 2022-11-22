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
	
	public double price(){
		double pricemixin = this.flavor.price;
		switch (this.amount) {
			case Light:
				pricemixin = 0.8 * pricemixin;
				break;
			case Normal:
				pricemixin = pricemixin;
				break;
			case Extra:
				pricemixin = 1.2 * pricemixin;
				break;
			case Drenched:
				pricemixin = 2.0 * pricemixin;
				break;
		}
		return pricemixin;
	}
	
	@Override
	public String toString(){
		if (amount.equals(MixInAmount.Normal)){
			return "" + flavor;
		}
		
		return flavor + "(" + amount + ")";
	}
}
