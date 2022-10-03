import java.util.ArrayList;

public class Scoop{
	private IceCreamFlavor flavor;
	private ArrayList<MixIn> mixins = new ArrayList<MixIn>();
	
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
		
		else if (mixins.size() == 1) {
			String scoop = flavor + " with ";
			for (MixIn mixin : mixins){
				 scoop = scoop + "" + mixin;
			}
			return "" + scoop;
		}
			
		else {
			String scoop = flavor + " with ";
			for (MixIn mixin : mixins){
				scoop = scoop + mixin + ", ";
			}
			return "" + scoop;
		}
	}
}
