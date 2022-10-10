package gui;

import emporium.Emporium;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.imageio.ImageIO;

public class MainWin extends JFrame {// implements ActionListener {
	private Emporium emporium;
	private JLabel display;
	
    public MainWin(){
    	super("MICE");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        
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
        
        quit.addActionListener(event -> onQuitClick());
        icecreamflavorc.addActionListener(event -> onCreateIceCreamFlavorClick());
        mixinflavorc.addActionListener(event -> onCreateMixInFlavorClick());
        scoopc.addActionListener(event -> onCreateScoopClick());
        about.addActionListener(event -> onAboutClick());
        icecreamflavorv.addActionListener(event -> view(Screen.ICE_CREAM_FLAVORS));
        mixinflavorv.addActionListener(event -> view(Screen.MIX_IN_FLAVORS));       
        scoopv.addActionListener(event -> view(Screen.SCOOPS));
        
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
    }
    
    public void onQuitClick(){
    	System.exit(0);
    }
    
    public void onCreateIceCreamFlavorClick(){
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
