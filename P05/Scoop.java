import java.util.ArrayList;

public class Scoop{
	private IceCreamFlavor flavor;
	private ArrayList<MixIn> mixins = new ArrayList<MixIn>();;
	
	public Scoop(IceCreamFlavor flavor){
		this.flavor = flavor;
	}
	
	public void addMixIn(MixIn mixin){
		mixins.add(mixin);
	}
	
	@Override
	public String toString(){
		if (mixins.isEmpty()){
			return flavor + " ";
		}
		
		else {	//works for one topping, but not more than one
			for (MixIn mixin : mixins){
				return flavor + " with " + mixin;
			}
		}
		
		return flavor + "";
	}
}
