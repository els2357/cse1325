package gui;

import emporium.Emporium;
import product.IceCreamFlavor;
import product.MixInFlavor;

import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
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
    	display.setVisible(false);
    	String name = JOptionPane.showInputDialog(this, "Name?");
    	String description = JOptionPane.showInputDialog(this, "Description?");
    	String cost = JOptionPane.showInputDialog(this, "Cost?");
    	int costInt = Integer.parseInt(cost);
    	String price = JOptionPane.showInputDialog(this, "Price?");
    	int priceInt = Integer.parseInt(price);
    	IceCreamFlavor flavor = new IceCreamFlavor(name, description, costInt, priceInt);
    	emporium.addIceCreamFlavor(flavor);
    	Object[] flavors = emporium.iceCreamFlavors();
    	System.out.println(Arrays.toString(flavors));
    	//String[] output = Arrays.asList(flavors).toArray(new String[0]);
		//display.setText(Arrays.toString(output));
		//display.setVisible(true);
    }
    
    public void onCreateMixInFlavorClick(){
    }
    
    public void onCreateScoopClick(){
    }
    
    public void onAboutClick(){
    	
    }
    
    private void view(Screen screen){
    }
}
