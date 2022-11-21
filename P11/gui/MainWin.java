package gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.imageio.ImageIO;

import product.Item;
import product.IceCreamFlavor;
import product.MixInFlavor;
import product.MixInAmount;
import product.MixIn;
import product.Container;
import product.Scoop;
import product.Serving;
import product.Order;

import emporium.Emporium;

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
        JMenuItem save              = new JMenuItem("Save");
        JMenuItem saveAs            = new JMenuItem("Save As");
        JMenuItem open              = new JMenuItem("Open");
        JMenu     view       		= new JMenu("View");
        JMenuItem icecreamflavorv	= new JMenuItem("Ice Cream Flavor");
        JMenuItem mixinflavorv      = new JMenuItem("Mix In Flavor");
        JMenuItem containerv      	= new JMenuItem("Container");
        JMenuItem orderv			= new JMenuItem("Order");

        
        JMenu	  create			= new JMenu("Create");
        JMenuItem icecreamflavorc	= new JMenuItem("Ice Cream Flavor");
        JMenuItem mixinflavorc      = new JMenuItem("Mix In Flavor");
        JMenuItem containerc      	= new JMenuItem("Container");
        JMenuItem orderc			= new JMenuItem("Order");
        
        JMenu     help				= new JMenu("Help");
        JMenuItem about      		= new JMenuItem("About");
        
        open.            addActionListener(event -> onOpenClick());
        save.            addActionListener(event -> onSaveClick());
        saveAs.          addActionListener(event -> onSaveAsClick());
        quit.			 addActionListener(event -> onQuitClick());
        icecreamflavorc. addActionListener(event -> onCreateIceCreamFlavorClick());
        mixinflavorc.	 addActionListener(event -> onCreateMixInFlavorClick());
        containerc.		 addActionListener(event -> onCreateContainerClick());
        orderc.		     addActionListener(event -> onCreateOrderClick());               
        about.			 addActionListener(event -> onAboutClick());
        icecreamflavorv. addActionListener(event -> view(Screen.ICE_CREAM_FLAVORS));
        mixinflavorv.	 addActionListener(event -> view(Screen.MIX_IN_FLAVORS));       
        containerv.		 addActionListener(event -> view(Screen.CONTAINERS));
        orderv.		 	 addActionListener(event -> view(Screen.ORDERS));
        
        file.add(quit);
     	file.add(open);
        file.add(save);
        file.add(saveAs);
        
        view.add(icecreamflavorv);
        view.add(mixinflavorv);
        view.add(containerv);
        view.add(orderv);
        
        create.add(icecreamflavorc);
        create.add(mixinflavorc);
        create.add(containerc);
        create.add(orderc);               
        help.add(about);
        
        menubar.add(file);
        menubar.add(view);
        menubar.add(create);
        menubar.add(help);
        
        setJMenuBar(menubar);
        
        JToolBar toolbar = new JToolBar("Toolbar");
        
        JButton saveButton = new JButton(new ImageIcon("gui/save.png"));
        toolbar.add(saveButton);
        saveButton.addActionListener(event -> onSaveClick());
        saveButton.setEnabled(true);
        
        JButton saveAsButton = new JButton(new ImageIcon("gui/saveAs.png"));
        toolbar.add(saveAsButton);
        saveAsButton.addActionListener(event -> onSaveAsClick());
        saveAsButton.setEnabled(true);
        
        JButton openButton = new JButton(new ImageIcon("gui/open.png"));
        toolbar.add(openButton);
        openButton.addActionListener(event -> onOpenClick());
        openButton.setEnabled(true);
        
        JButton createIceCream = new JButton(new ImageIcon("gui/createIceCream.png"));
        toolbar.add(createIceCream);
        createIceCream.addActionListener(event -> onCreateIceCreamFlavorClick());
        createIceCream.setEnabled(true);
        
        JButton createMixIn = new JButton(new ImageIcon("gui/createMixIn.png"));
        toolbar.add(createMixIn);
        createMixIn.addActionListener(event -> onCreateMixInFlavorClick());
        createMixIn.setEnabled(true);
        
        JButton createContainer = new JButton(new ImageIcon("gui/createContainer.png"));
        toolbar.add(createContainer);
        createContainer.addActionListener(event -> onCreateContainerClick());
        createContainer.setEnabled(true);
        
        JButton createOrder = new JButton(new ImageIcon("gui/createScoop.png"));
        toolbar.add(createOrder);
        createOrder.addActionListener(event -> onCreateOrderClick());
        createOrder.setEnabled(true);
        
        JButton viewIceCream = new JButton(new ImageIcon("gui/viewIceCream.png"));
        toolbar.add(viewIceCream);
        viewIceCream.addActionListener(event -> onViewIceCreamFlavorClick());
        viewIceCream.setEnabled(true);
        
        JButton viewMixIn = new JButton(new ImageIcon("gui/viewMixIn.png"));
        toolbar.add(viewMixIn);
        viewMixIn.addActionListener(event -> onViewMixInFlavorClick());
        viewMixIn.setEnabled(true);
        
        JButton viewContainer = new JButton(new ImageIcon("gui/viewContainer.png"));
        toolbar.add(viewContainer);
        viewContainer.addActionListener(event -> onViewContainerClick());
        viewContainer.setEnabled(true);
        
        JButton viewOrder = new JButton(new ImageIcon("gui/viewScoop.png"));
        toolbar.add(viewOrder);
        viewOrder.addActionListener(event -> onViewOrderClick());
        viewOrder.setEnabled(true);
        
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
    
    protected void onCreateContainerClick() {
        try {
            JLabel name = new JLabel("<html>Name</html>");
            JTextField names = new JTextField(20);
            JLabel desc = new JLabel("<html><br/>Description</html>");
            JTextField descs = new JTextField(20);
            JLabel scoop = new JLabel("<html><br/>Max Scoops</html>");
            SpinnerModel range = new SpinnerNumberModel(1, 0, 15, 1);
            JSpinner scoops = new JSpinner(range);
            
            Object[] objects = { // Array of widgets to display
                name,   names,
                desc,   descs,
                scoop,  scoops};
            int button = JOptionPane.showConfirmDialog(
                this, objects, "New Container", JOptionPane.OK_CANCEL_OPTION,
                  JOptionPane.QUESTION_MESSAGE, new ImageIcon("gui/container_icon.png"));
            if(button == JOptionPane.OK_OPTION) {
                emporium.addContainer(new Container(
                    names.getText(), descs.getText(), (Integer) scoops.getValue()));
                view(Screen.CONTAINERS);         
           }
        } catch(Exception e) {
            System.err.println("onCreateContainerClick exception: " + e);
        }
    }
    
    protected void onCreateIceCreamFlavorClick() {
        try {
            JLabel name = new JLabel("<html>Name</html>");
            JTextField names = new JTextField(20);
            JLabel desc = new JLabel("<html><br/>Description</html>");
            JTextField descs = new JTextField(20);
            JLabel price = new JLabel("<html><br/>Price</html>");
            SpinnerModel priceRange = new SpinnerNumberModel(1, 0, 15, 1);
            JSpinner prices = new JSpinner(priceRange);
            JLabel cost = new JLabel("<html><br/>Cost</html>");
            SpinnerModel costRange = new SpinnerNumberModel(1, 0, 15, 1);
            JSpinner costs = new JSpinner(costRange);
            
            Object[] objects = { // Array of widgets to display
                name,   names,
                desc,   descs,
                price,  prices,
                cost,   costs};
            int button = JOptionPane.showConfirmDialog( 
                this, objects, "New Ice Cream Flavor", JOptionPane.OK_CANCEL_OPTION,
                  JOptionPane.QUESTION_MESSAGE, new ImageIcon("gui/createIceCreamFlavorButton.png"));
            if(button == JOptionPane.OK_OPTION) {
                emporium.addIceCreamFlavor(new IceCreamFlavor(
                    names.getText(), descs.getText(), 
                    (Integer) prices.getValue(), (Integer) costs.getValue()));
                view(Screen.ICE_CREAM_FLAVORS);         
           }
        
        } catch(Exception e) {
        }
        try {
            view(Screen.ICE_CREAM_FLAVORS);         
        } catch(Exception e) {
            System.err.println("onCreateIceCreamFlavorClick exception: " + e);
        }
    }
    
    protected void onCreateMixInFlavorClick() {
        try {
            JLabel name = new JLabel("<html>Name</html>");
            JTextField names = new JTextField(20);
            JLabel desc = new JLabel("<html><br/>Description</html>");
            JTextField descs = new JTextField(20);
            JLabel price = new JLabel("<html><br/>Price</html>");
            SpinnerModel priceRange = new SpinnerNumberModel(1, 0, 150, 1);
            JSpinner prices = new JSpinner(priceRange);
            JLabel cost = new JLabel("<html><br/>Cost</html>");
            SpinnerModel costRange = new SpinnerNumberModel(1, 0, 150, 1);
            JSpinner costs = new JSpinner(costRange);
            
            Object[] objects = { // Array of widgets to display
                name,   names,
                desc,   descs,
                price,  prices,
                cost,   costs};
            int button = JOptionPane.showConfirmDialog( // Show the dialog
                this, objects, "Create Mix In Flavor", JOptionPane.OK_CANCEL_OPTION,
                  JOptionPane.QUESTION_MESSAGE, new ImageIcon("gui/createMixInFlavorButton.png"));
            if(button == JOptionPane.OK_OPTION) {
                emporium.addMixInFlavor(new MixInFlavor(
                    names.getText(), descs.getText(), 
                    (Integer) prices.getValue(), (Integer) costs.getValue()));
                view(Screen.MIX_IN_FLAVORS);         
           }

          
            view(Screen.MIX_IN_FLAVORS);         
        } catch(Exception e) {
            System.err.println("onCreateMixInFlavorClick exception: " + e);
        }
    }
    protected void onCreateOrderClick() {
        Order order = null;
        try {
            Serving serving = null;
            while((serving = onCreateServing()) != null) {
                if(order == null) order = new Order();
                order.addServing(serving);
                int result = JOptionPane.showConfirmDialog(
                    this, order, "Add Another Serving?", JOptionPane.YES_NO_CANCEL_OPTION);
                if(result == JOptionPane.CANCEL_OPTION) return;
                if(result == JOptionPane.NO_OPTION) break;
            }
            if(order != null) emporium.addOrder(order);
            view(Screen.ORDERS);
        } catch(Exception e) {
            System.err.println("onCreateScoop exception: " + e);
        }
    }
    protected Serving onCreateServing() {
        Serving serving = null;
        try {
            Container container = (Container) JOptionPane.showInputDialog(this, "Container?", "New Container", JOptionPane.QUESTION_MESSAGE, null, emporium.containers(), null);
            if(container != null) {
                serving = new Serving(container);
                Scoop scoop = null;
                boolean noScoop = true;
                while((scoop = onCreateScoop()) != null) {
                    serving.addScoop(scoop);
                    noScoop = false;
                    int result = JOptionPane.showConfirmDialog(
                        this, serving, "Add another scoop?", JOptionPane.YES_NO_CANCEL_OPTION);
                    if(result == JOptionPane.CANCEL_OPTION) return null;
                    if(result == JOptionPane.NO_OPTION) break;
                }
                if(noScoop) return null; 
                if(emporium.mixInFlavors().length > 0) {
                    String prompt = "<html>" + serving + "<br/>Add a topping?</html>";
                    MixIn topping = null;
                    while((topping = onCreateMixIn(prompt)) != null) {
                        serving.addTopping(topping);
                        prompt = "<html>" + serving + "<br/>Add another topping?</html>";
                    }
                }  
            }
        } catch(Exception e) {
            System.err.println("onCreateScoop exception: " + e);
            return null;
        }
        return serving;
    }

    protected Scoop onCreateScoop() {
        Scoop scoop = null;
        try {
            IceCreamFlavor icf = (IceCreamFlavor) JOptionPane.showInputDialog(this, "Ice Cream Flavor?", "New Scoop", JOptionPane.QUESTION_MESSAGE, null, emporium.iceCreamFlavors(), null);
            if(icf != null) {
                scoop = new Scoop(icf);
                if(emporium.mixInFlavors().length > 0) {
                    String prompt = "<html>" + scoop + "<br/>Add a mix in?</html>";
                    MixIn mixin = null;
                    while((mixin = onCreateMixIn(prompt)) != null) {
                        scoop.addMixIn(mixin);
                        prompt = "<html>" + scoop + "<br/>Add another mix in?</html>";
                    }
                }  
            }
        } catch(Exception e) {
            System.err.println("onCreateScoopClick exception: " + e);
            scoop = null;
        }
        return scoop;
    }
    
    
    protected MixIn onCreateMixIn(String prompt) {
        MixIn mixin = null;
        try {
            JLabel status = new JLabel(prompt);
            JLabel flavor = new JLabel("<html><br/>MixIn Flavor</html>");
            JComboBox<Object> flavors = new JComboBox<>(emporium.mixInFlavors());
            JLabel amount = new JLabel("<html><br/>MixIn Amount</html>");
            JComboBox<MixInAmount> amounts = new JComboBox<>(MixInAmount.values());
            amounts.setSelectedItem(MixInAmount.Normal); // default value
          
            Object[] objects = { // Array of widgets to display
                status,
                flavor, flavors,
                amount, amounts};
            int button = JOptionPane.showConfirmDialog( // Show the dialog
                this, objects, "New MixIn", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, new ImageIcon("gui/MixInIcon.png"));
            if(button == JOptionPane.YES_OPTION) 
                mixin = new MixIn((MixInFlavor) flavors.getSelectedItem(), 
                                  (MixInAmount) amounts.getSelectedItem());         
        } catch(Exception e) {
            System.err.println("onCreateMixIn exception: " + e);
        }
        return mixin;
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
    	final JFileChooser fc = new JFileChooser(filename);  
        FileFilter mavFiles = new FileNameExtensionFilter("Mav files", "Mav");
        fc.addChoosableFileFilter(mavFiles);         
        fc.setFileFilter(mavFiles);                  
        
        int result = fc.showSaveDialog(this);        
        if (result == JFileChooser.APPROVE_OPTION) { 
            filename = fc.getSelectedFile();         
            if(!filename.getAbsolutePath().endsWith(".mav"))  
                filename = new File(filename.getAbsolutePath() + ".mav");
            onSaveClick();                       
        }
    }
    
    public void onOpenClick(){
    	final JFileChooser fc = new JFileChooser(filename);
        FileFilter mavFiles = new FileNameExtensionFilter("Mav files", "Mav");
        fc.addChoosableFileFilter(mavFiles);         
        fc.setFileFilter(mavFiles);                  
        
        int result = fc.showOpenDialog(this);        
        if (result == JFileChooser.APPROVE_OPTION) { 
            filename = fc.getSelectedFile();        
            
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String magicCookie = br.readLine();
                if(!magicCookie.equals(MAGIC_COOKIE)) throw new RuntimeException("Not a Mav file");
                String fileVersion = br.readLine();
                if(!fileVersion.equals(FILE_VERSION)) throw new RuntimeException("Incompatible Mav file format");
                
                emporium = new Emporium(br);                   
                view(Screen.ICE_CREAM_FLAVORS);                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,"Unable to open " + filename + '\n' + e, 
                    "Failed", JOptionPane.ERROR_MESSAGE); 
             }
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
    
    public void onViewContainerClick(){
    	String title = "";
    	StringBuilder s = new StringBuilder();
    	title = "Containers";
    	for (var t : emporium.containers()) s.append(t.toString() + "<br/>");
    	display.setText("<html><font size=+4>" + title + 
                         "<br/></font><font size=+2>" + s.toString() + 
                         "</font></html>");
    }
    
    public void onViewOrderClick(){
    	String title = "";
    	StringBuilder s = new StringBuilder();
    	title = "Orders";
    	for (var t : emporium.orders()) s.append(t.toString() + "<br/>");
    	display.setText("<html><font size=+4>" + title + 
                         "<br/></font><font size=+2>" + s.toString() + 
                         "</font></html>");
    }
    
    public void onAboutClick(){    	
    	JDialog about = new JDialog();
        about.setLayout(new BoxLayout(about.getContentPane(), BoxLayout.PAGE_AXIS));
        about.setTitle("Mav's Ice Cream Emporium");
        Canvas canvas = new Canvas();
        about.add(canvas);
        about.pack();
        about.setVisible(true);      
        
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
        
        about.add(Box.createVerticalStrut(10));
        JButton ok = new JButton("OK");
        ok.addActionListener(event -> about.setVisible(false));
        about.add(ok);
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
    	
    	if (screen.equals(Screen.CONTAINERS)){
    		title = "Containers";
    		for (var t : emporium.containers()) s.append(t.toString() + "<br/>");
    	}
    	
    	if (screen.equals(Screen.ORDERS)){
    		title = "Orders";
    		for (var t : emporium.orders()) s.append(t.toString() + "<br/>");
    	}
    	
    	display.setText("<html><font size=+4>" + title + 
                         "<br/></font><font size=+2>" + s.toString() + 
                         "</font></html>");
    }
}
