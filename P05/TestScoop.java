public class TestScoop{
	public static void main(String[] args){
	IceCreamFlavor vanilla = new IceCreamFlavor("Vanilla", "Vanilla bean with organic milk", 50, 5);
	IceCreamFlavor chocolate = new IceCreamFlavor("Chocolate", "Chocolate custard with chocolate chunks", 100, 5);
	IceCreamFlavor cookiesNcream = new IceCreamFlavor("Cookies and Cream", "Vanilla with Oreo's", 150, 10);
	
	MixInFlavor oreos = new MixInFlavor("Oreos", "Nabisco brand", 25, 1);
	MixInFlavor sprinkles = new MixInFlavor("Sprinkles", "Not to be confused with my family", 10, 1);
	MixInFlavor gummyWorms = new MixInFlavor("Gummy worms", "So realistic looking!", 15, 2);
	
	Scoop first = new Scoop(vanilla);
	MixIn mix1 = new MixIn(oreos, MixInAmount.Extra);
	first.addMixIn(mix1);
	
	Scoop second = new Scoop(chocolate);
	MixIn mix2 = new MixIn(sprinkles, MixInAmount.Normal);
	second.addMixIn(mix2);
	
	Scoop third = new Scoop(cookiesNcream);
	MixIn mix3 = new MixIn(gummyWorms, MixInAmount.Drenched);
	third.addMixIn(mix3);
	third.addMixIn(mix1);
	third.addMixIn(mix2);
	
	System.out.print(first.toString() + "\n");
	System.out.print(second.toString() + "\n");
	System.out.print(third.toString()  + "\n");
	
	System.exit(1);
	}
}
