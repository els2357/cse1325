package gui;

import emporium.Emporium;

import product.IceCreamFlavor;
import product.Scoop;
import product.MixIn;
import product.MixInAmount;
import product.MixInFlavor;

import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.UIManager;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToggleButton;

import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import java.awt.FlowLayout;

import java.awt.Font;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MainWin extends JFrame {
	private Emporium emporium;
	private File filename;
	
	private JLabel display;
	private JMenuItem scoopc;
	private String NAME = "MICE";
	private String VERSION = "0.11";
	private String FILE_VERSION = "1.0";
	private String MAGIC_COOKIE = "Mav";
	
    public MainWin(){
    	super("Mavs Ice Cream Emporium");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        filename = new File("untitled.mav");
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
         		  scoopc      		= new JMenuItem("Scoop");
        JMenu     help				= new JMenu("Help");
        JMenuItem about      		= new JMenuItem("About");
        
        quit.			 addActionListener(event -> onQuitClick());
        icecreamflavorc. addActionListener(event -> onCreateIceCreamFlavorClick());
        mixinflavorc.	 addActionListener(event -> onCreateMixInFlavorClick());
        scoopc.			 addActionListener(event -> onCreateScoopClick());
        scoopc.setEnabled(false);
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
        
        JToolBar toolbar = new JToolBar("Toolbar");
        
        JButton save = new JButton(new ImageIcon("gui/save.png"));
        toolbar.add(save);
        save.addActionListener(event -> onSaveClick());
        save.setEnabled(true);
        
        JButton saveAs = new JButton(new ImageIcon("gui/saveAs.png"));
        toolbar.add(saveAs);
        saveAs.addActionListener(event -> onSaveAsClick());
        saveAs.setEnabled(true);
        
        JButton open = new JButton(new ImageIcon("gui/open.png"));
        toolbar.add(open);
        open.addActionListener(event -> onOpenClick());
        open.setEnabled(true);
        
        JButton createIceCream = new JButton(new ImageIcon("gui/createIceCream.png"));
        toolbar.add(createIceCream);
        createIceCream.addActionListener(event -> onCreateIceCreamFlavorClick());
        createIceCream.setEnabled(true);
        
        JButton createMixIn = new JButton(new ImageIcon("gui/createMixIn.png"));
        toolbar.add(createMixIn);
        createMixIn.addActionListener(event -> onCreateMixInFlavorClick());
        createMixIn.setEnabled(true);
        
        JButton createScoop = new JButton(new ImageIcon("gui/createScoop.png"));
        toolbar.add(createScoop);
        createScoop.addActionListener(event -> onCreateScoopClick());
        createScoop.setEnabled(true);
        
        JButton viewIceCream = new JButton(new ImageIcon("gui/viewIceCream.png"));
        toolbar.add(viewIceCream);
        viewIceCream.addActionListener(event -> onViewIceCreamFlavorClick());
        viewIceCream.setEnabled(true);
        
        JButton viewMixIn = new JButton(new ImageIcon("gui/viewMixIn.png"));
        toolbar.add(viewMixIn);
        viewMixIn.addActionListener(event -> onViewMixInFlavorClick());
        viewMixIn.setEnabled(true);
        
        JButton viewScoop = new JButton(new ImageIcon("gui/viewScoop.png"));
        toolbar.add(viewScoop);
        viewScoop.addActionListener(event -> onViewScoopClick());
        viewScoop.setEnabled(true);
        
        toolbar.add(Box.createHorizontalStrut(25));
        toolbar.add(Box.createHorizontalGlue());
        
        getContentPane().add(toolbar, BorderLayout.PAGE_START);
        
        display = new JLabel();
        display.setFont(new Font("Courier New", Font.BOLD, 16));
        display.setVerticalAlignment(JLabel.TOP);
        add(display, BorderLayout.CENTER);
        setVisible(true);
        
        emporium = new Emporium();
    }
    
    public void onQuitClick(){
    	System.exit(0);
    }
    
    public void onSaveClick(){
    	try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(MAGIC_COOKIE + '\n');
            bw.write(FILE_VERSION + '\n');
            emporium.save(bw);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Unable to open " + filename + '\n' + e,
                "Failed", JOptionPane.ERROR_MESSAGE); 
        }
    }
    
    public void onSaveAsClick(){
    	final JFileChooser fc = new JFileChooser(filename);  // Create a file chooser dialog
        FileFilter mavFiles = new FileNameExtensionFilter("Mav files", "Mav");
        fc.addChoosableFileFilter(mavFiles);         // Add "Nim file" filter
        fc.setFileFilter(mavFiles);                  // Show Nim files only by default
        
        int result = fc.showSaveDialog(this);        // Run dialog, return button clicked
        if (result == JFileChooser.APPROVE_OPTION) { // Also CANCEL_OPTION and ERROR_OPTION
            filename = fc.getSelectedFile();         // Obtain the selected File object
            if(!filename.getAbsolutePath().endsWith(".mav"))  // Ensure it ends with ".nim"
                filename = new File(filename.getAbsolutePath() + ".mav");
            onSaveClick();                       // Delegate to Save method
        }
    }
    
    public void onOpenClick(){
    	final JFileChooser fc = new JFileChooser(filename);
        FileFilter mavFiles = new FileNameExtensionFilter("Mav files", "Mav");
        fc.addChoosableFileFilter(mavFiles);         
        fc.setFileFilter(mavFiles);                  
        
        int result = fc.showOpenDialog(this);        // Run dialog, return button clicked
        if (result == JFileChooser.APPROVE_OPTION) { // Also CANCEL_OPTION and ERROR_OPTION
            filename = fc.getSelectedFile();        // Obtain the selected File object
            
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String magicCookie = br.readLine();
                if(!magicCookie.equals(MAGIC_COOKIE)) throw new RuntimeException("Not a Mav file");
                String fileVersion = br.readLine();
                if(!fileVersion.equals(FILE_VERSION)) throw new RuntimeException("Incompatible Mav file format");
                
                emporium = new Emporium(br);                   // Open a new game
                view(Screen.ICE_CREAM_FLAVORS);                // Update with call to MainWin.view method;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,"Unable to open " + filename + '\n' + e, 
                    "Failed", JOptionPane.ERROR_MESSAGE); 
             }
        }
    }
    
    public void onCreateIceCreamFlavorClick(){
    	try {
            emporium.addIceCreamFlavor(new IceCreamFlavor(
                JOptionPane.showInputDialog(this, "Name?", "Create Ice Cream Flavor", JOptionPane.QUESTION_MESSAGE),
                JOptionPane.showInputDialog(this, "Description?"," Create Ice Cream Flavor", JOptionPane.QUESTION_MESSAGE),
                Integer.parseInt(JOptionPane.showInputDialog(this, "Price?", "Create Ice Cream Flavor", JOptionPane.QUESTION_MESSAGE)),
                Integer.parseInt(JOptionPane.showInputDialog(this, "Cost?", "Create Ice Cream Flavor", JOptionPane.QUESTION_MESSAGE))
            ));
        } catch(Exception e) {
        }
        scoopc.setEnabled(false);
        scoopc.setEnabled(true);
        view(Screen.ICE_CREAM_FLAVORS);
    }
    
    public void onCreateMixInFlavorClick(){
    	try{
    		emporium.addMixInFlavor(new MixInFlavor(
                JOptionPane.showInputDialog(this, "Name?", "Create MixIn Flavor", JOptionPane.QUESTION_MESSAGE),
                JOptionPane.showInputDialog(this, "Description?"," Create MixIn Flavor", JOptionPane.QUESTION_MESSAGE),
                Integer.parseInt(JOptionPane.showInputDialog(this, "Price?", "Create MixIn Flavor", JOptionPane.QUESTION_MESSAGE)),
                Integer.parseInt(JOptionPane.showInputDialog(this, "Cost?", "Create MixIn Flavor", JOptionPane.QUESTION_MESSAGE))
            ));
        } catch(Exception e) {
        }
        view(Screen.MIX_IN_FLAVORS);
    }
    
    public void onCreateScoopClick(){   	
    	IceCreamFlavor object = (IceCreamFlavor) JOptionPane.showInputDialog(this, "Select an Ice Cream Flavor!", "Scoop", 3, null, emporium.iceCreamFlavors(), null);
    	if (object != null){
    		Scoop scoop = new Scoop(object);
    	    if(emporium.mixInFlavors().length > 0) {
                String prompt = "<html>" + scoop + "<br/>Add a mix in?</html>";
                while(true) {
                    MixInFlavor mif = (MixInFlavor) JOptionPane.showInputDialog(this, prompt, 
                        "Add Mix In", JOptionPane.QUESTION_MESSAGE, null, 
                        emporium.mixInFlavors(), null);
                    if(mif == null) break;
                    MixInAmount mia = (MixInAmount) JOptionPane.showInputDialog(this, prompt, 
                        "Add Mix In", JOptionPane.QUESTION_MESSAGE, null, 
                        MixInAmount.values(), MixInAmount.Normal);
                    scoop.addMixIn(new MixIn(mif, mia));
                    prompt = "<html>" + scoop + "<br/>Add another mix in?</html>";
                }
            }
            emporium.addScoop(scoop);
            view(Screen.SCOOPS);         
        }
    }	
    
    public void onViewIceCreamFlavorClick(){
    	String title = "";
    	StringBuilder s = new StringBuilder();
    	title = "Ice Cream Flavors";
    	for (var t : emporium.iceCreamFlavors()) s.append(t.toString() + "<br/>");
    	display.setText("<html><font size=+4>" + title + 
                         "<br/></font><font size=+2>" + s.toString() + 
                         "</font></html>");
    }
    
    public void onViewMixInFlavorClick(){
    	String title = "";
    	StringBuilder s = new StringBuilder();
    	title = "MixIn Flavors";
    	for (var t : emporium.mixInFlavors()) s.append(t.toString() + "<br/>");
    	display.setText("<html><font size=+4>" + title + 
                         "<br/></font><font size=+2>" + s.toString() + 
                         "</font></html>");
    }
    
    public void onViewScoopClick(){
    	String title = "";
    	StringBuilder s = new StringBuilder();
    	title = "Scoops";
    	for (var t : emporium.scoops()) s.append(t.toString() + "<br/>");
    	display.setText("<html><font size=+4>" + title + 
                         "<br/></font><font size=+2>" + s.toString() + 
                         "</font></html>");
    }
    
    public void onAboutClick(){
    	JDialog about = new JDialog();
        about.setLayout(new BoxLayout(about.getContentPane(), BoxLayout.PAGE_AXIS));
        about.setTitle("Mav's Ice Cream Emporium");
        
        JLabel title = new JLabel("<html>"
          + "<p><font size=+4>Mav's Ice Cream Emporium</font></p>"
          + "</html>", JLabel.CENTER);
        about.add(title);
        
        try {
            BufferedImage myPicture = ImageIO.read(new File("gui/temp.png"));
            JLabel logo = new JLabel(new ImageIcon(myPicture));
            about.add(logo);
        } catch(IOException e) {
        }       
        
        JLabel info = new JLabel("<html>"
          + "<p>Version 0.11</p>"
          + "<p>Copyright 2022 by Ethan Sprinkle</p>"
          + "<p>Licensed under Gnu GPL 3.0</p>"
          + "<p>Portions of this applications source code attributed to Professor George F. Rice</p>"
          + "<p>Icons by Ethan Sprinkle</p>"
          + "<p>Logo by ccarson, per the Open Clipart License</p>"
          + "<p><font size=-2>Rice, G (2022) MainWin source code (Version 0.2) [Source code]. https://github.com/prof-rice/cse1325-prof/blob/main/P06/gui/MainWin.java</font><p>"
          + "<p><font size=-2>https://openclipart.org/detail/178983/ice-cream- cone<p>"
          + "<br/></html>", JLabel.CENTER);
        about.add(info);

		JPanel panel = new JPanel();
        JButton ok = new JButton("OK");
        ok.addActionListener(event -> about.setVisible(false));
        panel.add(ok);
        about.add(Box.createVerticalStrut(10));
        
        about.pack();
        about.setVisible(true);
    }
    
    private void view(Screen screen){
    	String title = "";
    	StringBuilder s = new StringBuilder();
    	if (screen.equals(Screen.ICE_CREAM_FLAVORS)){
    		title = "Ice Cream Flavors";
    		for (var t : emporium.iceCreamFlavors()) s.append(t.toString() + "<br/>");
    	}
    	if (screen.equals(Screen.MIX_IN_FLAVORS)){
    	    title = "Mix In Flavors";
    		for (var t : emporium.mixInFlavors()) s.append(t.toString() + "<br/>");
    	}
    	if (screen.equals(Screen.SCOOPS)){
    		title = "Scoops";
    		for (var t : emporium.scoops()) s.append(t.toString() + "<br/>");
    	}
    	display.setText("<html><font size=+4>" + title + 
                         "<br/></font><font size=+2>" + s.toString() + 
                         "</font></html>");
    }
}
