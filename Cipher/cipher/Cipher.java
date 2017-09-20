package cipher;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Cipher implements ActionListener{
	private JTextArea text1= new JTextArea("Enter Encryption"),text2= new JTextArea("Decryption"), text3= new JTextArea("Key");
	private JButton b1;
	
	 public Cipher() {
		 int width = 300 ,height = 500;
		 /* JFRAME */
		 	JFrame frame = new JFrame();
			frame.setSize(width, height);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocationRelativeTo(null);
			
			/* COMPONENTS */
			text1.setColumns(25);
			text1.setRows(5);
			text1.setBackground(new Color(220,220,220));
			text1.setEditable(true);
			text1.setLineWrap(true);
			
			text2.setColumns(25);
			text2.setRows(5);
			text2.setBackground(new Color(220,220,220));
			text2.setEditable(false);
			text2.setLineWrap(true);
			
			text3.setColumns(25);
			text3.setRows(1);
			text3.setBackground(new Color(220,220,220));
			text3.setEditable(true);
			text3.setLineWrap(true);

			b1 = new JButton("encrypt");
			b1.setActionCommand("encrypt");
			b1.addActionListener(this);
			
			/* JPANEL */
			JPanel panelMain = new JPanel(new FlowLayout());
			
			panelMain.setBackground(Color.WHITE);
			
			panelMain.add(text1);
			
			panelMain.add(text2);
			panelMain.add(text3);
			
			panelMain.add(b1);
			
			
			/* CONFIGURE JFRAME */
			
			frame.add(panelMain);
			frame.setVisible(true);

	}
	public static void main(String[] args){
		new Cipher();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if("encrypt".equals(e.getActionCommand())){
			String text = text1.getText();
			String cypher = "";
			String key = text3.getText();
			int[] arr = new int[text.length()];
			int shift = 0;
			for(int i = 0; i < key.length(); i++){
				shift *= 10;
				shift += key.charAt(i) - 48;

			}
			for(int i = 0; i < text.length(); i++){
				if(text.charAt(i) < 97)
					arr[i] = text.charAt(i) - 65;
				else
					arr[i] = text.charAt(i) - 97;
				if(arr[i] == 32 - 65)
					arr[i] = 32;
				else{
					arr[i] = ((arr[i] + shift) % 26) + 97;
				}
				char c = (char) arr[i];
				cypher += String.valueOf(c);
				System.out.println(cypher);
			}
			text2.setText(cypher);
		}
		
	}
}
