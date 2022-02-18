import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
//import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class PasswordGenerator implements ActionListener {
	
	public JButton button;
	public JCheckBox checkBox;
	public JTextField field;
	public Label label;
	public Label label2;
	public JTextField field2;
	public Label label3;
	public int conv;
	public int state;
	public JButton button2;
	public JButton button3;
	public JButton saveButton;
	public JTextField purposeField;
	public JLabel purposeLabel;
	public JButton clearButton;
	public PasswordGenerator() {
		//pre window
		checkBox = new JCheckBox("Only numbers");
		JFrame preFrame = new JFrame();
		preFrame.setTitle("Select number of characters");
		label2 = new Label();
		label3 = new Label();
		button2 = new JButton("Only numbers");
		button3 = new JButton("Random number");
		label2.setText("How many characters do you want your password to be");
		label3.setText("Make sure you press ENTER after entering your desired amount of characters");
		preFrame.add(label2);
		preFrame.add(label3);
		preFrame.setSize(500, 200);
		preFrame.setLayout(new FlowLayout());
		preFrame.setVisible(true);
		preFrame.setAlwaysOnTop(true);
		field2 = new JTextField(2);
		preFrame.add(field2);
		
		
		field2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String grab = field2.getText();
				//System.out.println(grab);
				conv = Integer.parseInt(grab);	
			}
		});
		
		
		
		
		
		
		
		
		//main window
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		saveButton = new JButton("Save results");
		field = new JTextField(20);
		field.setEditable(false);
		
		
		purposeField = new JTextField(20);
		purposeLabel = new JLabel("What is this password for? (HIT ENTER AFTER TYPING IT IN)");
		
		
		
		field.setText("password goes here");
		frame.setTitle("Password Generator - coded by Entropy");
		frame.setSize(400, 300);
		frame.setVisible(true);
		frame.setLayout(new FlowLayout());
		button = new JButton("Generate");
		clearButton = new JButton("Clear passwords file");
		frame.add(field);
		frame.add(button);
		frame.add(saveButton);
		label = new Label();
		frame.add(label);
		//frame.add(checkBox);
		frame.add(button2);
		frame.add(button3);
		frame.add(clearButton);
		frame.add(purposeLabel);
		frame.add(purposeField);
		
		label.setVisible(true);
		state = 1;
		
		
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//File file = new File("password.txt");
				String str = "Test";
				File testFile = new File("password.txt");
				try(FileWriter writer = new FileWriter(testFile, true)) {
					
					
					
					writer.append("\n");
					writer.append(purposeField.getText() + " --> " + field.getText());
					
					
					
					
					
					
					
					
					
					
					
					
					
					System.out.println("hello");
				} catch (IOException e1) {
					e1.printStackTrace();
					
				}
				
				
				
				
				
				//System.out.println("hello");
				
			}
		});
		
		clearButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				File checkFile = new File("password.txt");
				boolean exists = checkFile.exists();
				if(exists) {
					checkFile.delete();
				}else {
					JOptionPane.showMessageDialog(frame, "The file doesn't exist!");
				}
				
			}
		});
		
	
		
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				char[] dictionary = {'@', '!', '?', '#', '%', '&', 'a','b','c','d','e','f','g','h','i',
							'j','k','l','m','n','o','p','q',
							'r','s','t','u', 'v', 'w','x','y','z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
					
					Random random = new Random();
					
					
					String password = "";
					
					for(int i = 0; i < conv; i++) {
						int x = random.nextInt(dictionary.length);
						password += dictionary[x];
					}
					
					field.setText(password);
				
					
					
				
				
				
			}
		});
		
		
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Random random = new Random();
				String password = "";
				char[] dictionary2 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
				for(int i = 0; i < conv; i++) {
					int y = random.nextInt(dictionary2.length);
					password += dictionary2[y];
				}
				field.setText(password);
				//state = 1;
				
			}
		});
		
		button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Random random = new Random();
					int rand = random.nextInt(conv);
					//System.out.println(conv);
					field.setText(Integer.toString(rand));	
				}catch (Exception eee) {
					JOptionPane.showMessageDialog(frame, "The number must be positive!");
				}
				
				
			}
		});
		
	}
	
	
	
	
	
	

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				new PasswordGenerator();
				
			}
		});
		
	
		
		
		
		
		//System.out.println(password);
		
		
		

	}




	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Generate")) {
			//System.out.println("Hello");
		}
		
	}

}
