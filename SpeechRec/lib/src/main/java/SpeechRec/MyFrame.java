package SpeechRec;

import javax.swing.*;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Window.*;

public class MyFrame extends JFrame implements ActionListener{
//   public LiveSpeechRecognizer speech;
//   MyFrame(LiveSpeechRecognizer speech){
//	   this.speech = speech;
//   }


	
	private Container c;
    private JLabel title;
    private JLabel x;
    private JTextField xname;
    private JLabel y;
    private JTextField yname;
    private JTextField tname;
    private JLabel mno;
    private JTextField tmno;
    private JLabel gender;
    private JRadioButton male;
    private JRadioButton female;
    private ButtonGroup gengp;
    private JLabel dob;
    private JComboBox date;
    private JComboBox month;
    private JComboBox year;
    private JLabel add;
    private JTextArea tadd;
    private JCheckBox term;
    private JButton sub;
    private JButton reset;
    private JTextArea tout;
    private JLabel res;
    private JTextArea resadd;
 
  
    // constructor, to initialize the components
    // with default values.
    public MyFrame()
    {
        setTitle("Registration Form");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
 
        c = getContentPane();
        c.setLayout(null);
 
        title = new JLabel("Choose Co-ordinates");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(0+10, 0);
        c.add(title);
        
        
        x = new JLabel("x");
        x.setFont(new Font("Arial", Font.PLAIN, 20));
        x.setSize(100, 20);
        x.setLocation(100, 100);
        c.add(x);
        
        xname = new JTextField();
        xname.setFont(new Font("Arial", Font.PLAIN, 15));
        xname.setSize(190, 20);
        xname.setLocation(200, 100);
        xname.setText("100");
        c.add(xname);
        
        y = new JLabel("y");
        y.setFont(new Font("Arial", Font.PLAIN, 20));
        y.setSize(100, 20);
        y.setLocation(100, 100+50);
        c.add(y);
        
        yname = new JTextField();
        yname.setFont(new Font("Arial", Font.PLAIN, 15));
        yname.setSize(190, 20);
        yname.setLocation(200, 100+50);
        c.add(yname);
        
        
       
        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 50);
        sub.setLocation(150, 450);
        sub.addActionListener(this);
        c.add(sub);
// 
        reset = new JButton("Record");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 50);
        reset.setLocation(270, 450);
        reset.addActionListener(this);
        c.add(reset);
// 
//        tout = new JTextArea();
//        tout.setFont(new Font("Arial", Font.PLAIN, 15));
//        tout.setSize(300, 400);
//        tout.setLocation(500, 100);
//        tout.setLineWrap(true);
//        tout.setEditable(false);
//        c.add(tout);
// 
//        res = new JLabel("");
//        res.setFont(new Font("Arial", Font.PLAIN, 20));
//        res.setSize(500, 25);
//        res.setLocation(100, 500);
//        c.add(res);
// 
//        resadd = new JTextArea();
//        resadd.setFont(new Font("Arial", Font.PLAIN, 15));
//        resadd.setSize(200, 75);
//        resadd.setLocation(580, 175);
//        resadd.setLineWrap(true);
//        c.add(resadd);
 
        setVisible(true);
    }
 
    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    
    public void Addx() {
        Configuration config = new Configuration();
        config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        config.setDictionaryPath("src\\main\\resources\\5908.dic");
    	config.setLanguageModelPath("src\\main\\resources\\5908.lm");
    	
    	try {
    		LiveSpeechRecognizer speech = new LiveSpeechRecognizer(config);
    		speech.startRecognition(true);
    		
    		SpeechResult speechResult = null;
    		String x_coordinate = "";
    		while ((speechResult = speech.getResult()) != null) {
    			String voiceCommand = speechResult.getHypothesis();
    			System.out.println("Voice Command is " + voiceCommand);
    			if(voiceCommand.equalsIgnoreCase("OK")) {
    				xname.setText(x_coordinate);
    				break;
    			}
    			x_coordinate = voiceCommand;
    			
    		}
    		
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	
    }
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == sub) {
        	
        	
        	
        	
  	
        	System.out.println("x = "+xname.getText()+" y = "+yname.getText()+ " \n Closing!!!");
        	String rec_code = "    <svg width=\"400\" height=\"180\"> <rect x=" + x + " y="+y+" width= "+"\"150\""+" height="+"\"150\" "+"style=\"fill:blue;stroke:pink;stroke-width:5;fill-opacity:0.1;stroke-opacity:0.9\" /></svg>";
//    		System.out.print(rec_code);
    		
    		
    		
    		File file = new File("C:\\Users\\admin\\eclipse-workspace\\Demo\\hello.html");
    		BufferedWriter bw = null;
			try {
				bw = new BufferedWriter(new FileWriter(file));
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
    		try {
				bw.write("<html><head><title>New Page</title></head><body><p>This is Body</p>"+ rec_code  +"</body></html>");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		try {
				bw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		
    		
    		String url = "C:\\Users\\admin\\eclipse-workspace\\Demo\\hello.html";
    		File f = new File(url);
    		try {
				Desktop.getDesktop().browse(f.toURI());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		
        	System.exit(0);

        }
        if(e.getSource() == reset) {
        	
        	Configuration config = new Configuration();
            config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
            config.setDictionaryPath("src\\main\\resources\\5908.dic");
        	config.setLanguageModelPath("src\\main\\resources\\5908.lm");
        	try {
				LiveSpeechRecognizer speech = new LiveSpeechRecognizer(config);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	
        	xname.setText("x_coordinate");
        	System.exit(0);
        	
        	
        	
//        	try {
//        		LiveSpeechRecognizer speech = new LiveSpeechRecognizer(config);
//        		speech.startRecognition(true);
//        		
//        		SpeechResult speechResult = null;
//        		String x_coordinate = "";
//        		while ((speechResult = speech.getResult()) != null) {
//        			System.out.print("Inside Recording");
//        			String voiceCommand = speechResult.getHypothesis();
//        			System.out.println("Voice Command is " + voiceCommand);
//        			if(voiceCommand.equalsIgnoreCase("OK")) {
//        				xname.setText(x_coordinate);
//        				break;
//        			}
//        			x_coordinate = voiceCommand;
//        			
//        		}
//        		
//        	} catch (IOException e1) {
//        		e1.printStackTrace();
//        	}
//        	Addx();
        }
        
       
        
 
     
    }
}
