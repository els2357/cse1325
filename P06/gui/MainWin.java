package gui;

import emporium.Emporium;
import product.IceCreamFlavor;
import product.Scoop;
import product.MixIn;
import product.MixInAmount;
import product.MixInFlavor;


import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

public class MainWin extends JFrame {
	private Emporium emporium = new Emporium();
	private JLabel display = new JLabel();
	
    public MainWin(){
    	super("Mavs Ice Cream Emporium");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        
        JMenuBar menubar = new JMenuBar();

        JMenu     file       		= new JMenu("File");
        JMenuItem quit       		= new JMenuItem("Quit");
        JMenu     view       		= new JMenu("View");
        JMenuItem icecreamflavorv	= new JMenuItem("Ice Cream Flavor");
        JMenuItem mixinflavorv      = new JMenuItem("Mix In Flavor");
        JMenuItem scoopv      		= new JMenuItem("Scoop");
        JMenu	  create			= new JMenu("Create");
        JMenuItem icecreamflavorc	= new JMenuItem("Ice Cream Flavor");
        JMenuItem mixinflavorc      = new JMenuItem("Mix In Flavor");
        JMenuItem scoopc      		= new JMenuItem("Scoop");
        JMenu     help				= new JMenu("Help");
        JMenuItem about      		= new JMenuItem("About");
        
        quit.			 addActionListener(event -> onQuitClick());
        icecreamflavorc. addActionListener(event -> onCreateIceCreamFlavorClick());
        mixinflavorc.	 addActionListener(event -> onCreateMixInFlavorClick());
        scoopc.			 addActionListener(event -> onCreateScoopClick());
        about.			 addActionListener(event -> onAboutClick());
        icecreamflavorv. addActionListener(event -> view(Screen.ICE_CREAM_FLAVORS));
        mixinflavorv.	 addActionListener(event -> view(Screen.MIX_IN_FLAVORS));       
        scoopv.			 addActionListener(event -> view(Screen.SCOOPS));
        
        file.add(quit);
        view.add(icecreamflavorv);
        view.add(mixinflavorv);
        view.add(scoopv);
        create.add(icecreamflavorc);
        create.add(mixinflavorc);
        create.add(scoopc);
        help.add(about);
        
        menubar.add(file);
        menubar.add(view);
        menubar.add(create);
        menubar.add(help);
        setJMenuBar(menubar);
        
        add(display);
        setVisible(true);
    }
    
    public void onQuitClick(){
    	System.exit(0);
    }
    
    public void onCreateIceCreamFlavorClick(){
    	String name = JOptionPane.showInputDialog(this, "Name?");
    	String description = JOptionPane.showInputDialog(this, "Description?");
    	String cost = JOptionPane.showInputDialog(this, "Cost?");
    	int costInt = Integer.parseInt(cost);
    	String price = JOptionPane.showInputDialog(this, "Price?");
    	int priceInt = Integer.parseInt(price);
    	IceCreamFlavor flavor = new IceCreamFlavor(name, description, costInt, priceInt);
    	emporium.addIceCreamFlavor(flavor);
    	Object[] flavors = emporium.iceCreamFlavors();
    	//System.out.println(Arrays.toString(flavors));
    	String output = Arrays.toString(flavors);
		display.setText("IceCreamFlavors - " + output);
		display.setVisible(true);
    }
    
    public void onCreateMixInFlavorClick(){
    	String name = JOptionPane.showInputDialog(this, "Name?");
    	String description = JOptionPane.showInputDialog(this, "Description?");
    	String cost = JOptionPane.showInputDialog(this, "Cost?");
    	int costInt = Integer.parseInt(cost);
    	String price = JOptionPane.showInputDialog(this, "Price?");
    	int priceInt = Integer.parseInt(price);
    	MixInFlavor flavor = new MixInFlavor(name, description, costInt, priceInt);
    	emporium.addMixInFlavor(flavor);
    	Object[] flavors = emporium.mixInFlavors();
    	//System.out.println(Arrays.toString(flavors));
    	String output = Arrays.toString(flavors);
		display.setText("MixIn Flavors - " + output);
		display.setVisible(true);
    }
    
    public void onCreateScoopClick(){
    	Object[] iceflavors = emporium.iceCreamFlavors();
    	Object scoopclick = JOptionPane.showInputDialog(this, "Select an Ice Cream Flavor!", "Scoop", 3, null, iceflavors, null);
    	IceCreamFlavor object = (IceCreamFlavor) scoopclick;
    	Scoop scoop = new Scoop(object);
    	
    	Object[] mixflavors = emporium.mixInFlavors();
    	Object scoopclick1 = JOptionPane.showInputDialog(this, "Select a Mix in Flavor!", "Scoop", 3, null, mixflavors, null);
    	MixInFlavor object1 = (MixInFlavor) scoopclick1;
    	
    	Object scoopclick2 = JOptionPane.showInputDialog(this, "Select a Mix in Amount!", "Scoop", 3, null, MixInAmount.values(), null);
    	MixInAmount object2 = (MixInAmount) scoopclick2;
    	MixIn mixin = new MixIn(object1, object2);
    	
    	scoop.addMixIn(mixin);
    	emporium.addScoop(scoop);
    	Object[] scoops = emporium.scoops();
    	String output = Arrays.toString(scoops);
    	
		display.setText("Scoops - " + output);
		display.setVisible(true);    	
    }
    
    public void onAboutClick(){
    	JDialog about = new JDialog();
        about.setLayout(new FlowLayout());
        about.setTitle("Mav's Ice Cream Emporium");
        
        /*try {
            BufferedImage myPicture = ImageIO.read(new File("128px-Pyramidal_matches.png"));
            JLabel logo = new JLabel(new ImageIcon(myPicture));
            about.add(logo);
        } catch(IOException e) {
        }*/
        
        JLabel title = new JLabel("<html>"
          + "<p><font size=+4>Mav's Ice Cream Emporium</font></p>"
          + "</html>");
        about.add(title);
        
        JLabel info = new JLabel("<html>"
          + "<p>Version 0.1</p>"
          + "<p>Copyright 2022 by Ethan Sprinkle</p>"
          + "</html>");
        about.add(info);

        JButton ok = new JButton("OK");
        ok.addActionListener(event -> about.setVisible(false));
        about.add(ok);
        
        about.setSize(700,400);
        about.setVisible(true);
    }
    
    private void view(Screen screen){
    	if (screen.equals(Screen.ICE_CREAM_FLAVORS)){
    		Object[] flavors = emporium.iceCreamFlavors();
    		String output = Arrays.toString(flavors);
			display.setText("Ice Cream Flavors - " + output);
			display.setVisible(true);
    	}
    	if (screen.equals(Screen.MIX_IN_FLAVORS)){
    	    Object[] flavors = emporium.mixInFlavors();
    		String output = Arrays.toString(flavors);
			display.setText("MixIn Flavors - " + output);
			display.setVisible(true);
    	}
    	if (screen.equals(Screen.SCOOPS)){
    		Object[] scoops = emporium.scoops();
    		String output = Arrays.toString(scoops);
    		display.setText("Scoops - " + output);
			display.setVisible(true); 
    	}
    }
}
