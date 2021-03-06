package eventManager;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

/*
 * @author monalika
 */

public class SendMessageFrame extends JFrame {
	
	private JTextField textField;
	public String t = "   ";
	static String y = "  ";
	String u ;
	public SendMessageFrame(String usern) {
		
		u = usern;
		init();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public void init(){
		
		 int i =0;
		 String[] x = new String[50];
		
		try{
			FileReader inputFile = new FileReader("\\Group-1\\res\\message.txt");
		
		 BufferedReader bufferReader = new BufferedReader(inputFile);
		 String line;
		 while ((line = bufferReader.readLine()) != null)   {
			 
			//to store all the lines
			x[i] = line;
			i++;
	        System.out.println(line);
	        
	    }
		
	    bufferReader.close();
	    }

	catch(Exception e){
	            System.out.println("Error while reading file line by line:" 
	            + e.getMessage());                      
	    }
		 
		 
		
		this.setBounds(100, 100, 450, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblMessanger = new JLabel("MESSENGER");
		lblMessanger.setBounds(168, 12, 113, 36);
		getContentPane().add(lblMessanger);
		
		JLabel lblMessage = new JLabel("Message:");
		lblMessage.setBounds(45, 80, 70, 15);
		getContentPane().add(lblMessage);
		
		textField = new JTextField();
		textField.setBounds(142, 78, 251, 17);
		getContentPane().add(textField);
		textField.setColumns(10);
		
	
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(283, 109, 117, 25);
		getContentPane().add(btnSubmit);
		btnSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String text = textField.getText();
				
		       try {
		    	   BufferedWriter output = new BufferedWriter(new FileWriter("\\Group-1\\res\\message.txt",true));
		  
		         output.append(text+'\n');
		    //     output.newLine();
		         
		         output.close();
		       } catch ( IOException e ) {
		          e.printStackTrace();
		       }
		       
		       y= "Message Sent!!!";
		       setVisible(false);
		       SendMessageFrame updated = new SendMessageFrame(u);
		       updated.setVisible(true);
				
			}
		});

		
		
		JButton btnShowRecentMessages = new JButton("Show Recent Messages");
		btnShowRecentMessages.setBounds(33, 146, 218, 25);
		
		
		
		String message = "   ";
		int p=i;
	
		if(p>7){
			message = x[i-1]+'\n'+x[i-2]+'\n'+x[i-3]+'\n'+x[i-4]+'\n'+x[i-5]+x[i-6]+'\n'+x[i-7] + '\n' + x[i-8];
		}
		else if (p==7){
			message = x[i-1]+'\n'+x[i-2]+'\n'+x[i-3]+'\n'+x[i-4]+'\n'+x[i-5]+x[i-6]+'\n'+x[i-7];

		}
		else if(p==6){
			message = x[i-1]+'\n'+x[i-2]+'\n'+x[i-3]+'\n'+x[i-4]+'\n'+x[i-5]+x[i-6];

		}
		else if(p==5){
			message = x[i-1]+'\n'+x[i-2]+'\n'+x[i-3]+'\n'+x[i-4]+'\n'+x[i-5];

		}
		else if(p==4){
			message = x[i-1]+'\n'+x[i-2]+'\n'+x[i-3]+'\n'+x[i-4];

		}
		else if(p==3){
			message = x[i-1]+'\n'+x[i-2]+'\n'+x[i-3];

		}
		else if(p==2){
			message = x[i-1] + '\n' + x[i-2];

		}
		else if(p==1){
			message = x[i-1];

		}
		else if(p<1){
			message = " ";

		}
		
		JTextArea textArea = new JTextArea(message);
		textArea.setBounds(45, 161, 374, 150);
		getContentPane().add(textArea);
		
		JLabel lblRecentMessages = new JLabel("Recent Messages");
		lblRecentMessages.setBounds(43, 139, 163, 15);
		getContentPane().add(lblRecentMessages);
		
		JButton btnEmHome = new JButton("EM Home");
		btnEmHome.setBounds(168, 339, 127, 23);
		getContentPane().add(btnEmHome);
		
		
		
		JLabel lblNewLabel = new JLabel("User:" + u);
		lblNewLabel.setBounds(313, 12, 106, 15);
		getContentPane().add(lblNewLabel);
		
		
		btnEmHome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				EventManagerFrame fr = new EventManagerFrame(u);
				setVisible(false);
			}
		});
	}
}
	