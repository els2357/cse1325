import java.util.ArrayList;

public class Scoop{
	private IceCreamFlavor flavor;
	private ArrayList<MixIn> mixins;
	
	public Scoop(IceCreamFlavor flavor){
		this.flavor = flavor;
	}
	
	public void addMixIn(MixIn mixin){
		new ArrayList<MixIn>();
		mixins.add(mixin);
	}
	
	@Override
	public String toString(){
		if (mixins.isEmpty()){
			return flavor + " ";
		}
		
		for (MixIn mixin : mixins){
			return flavor + " with " + mixin;
		}
		
		return flavor + "";
	}
}
