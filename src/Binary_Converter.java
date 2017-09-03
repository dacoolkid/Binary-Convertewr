import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Binary_Converter implements ActionListener{
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextField answer1 = new JTextField(20);
	JTextField question = new JTextField(20);
	JButton button = new JButton();
	public static void main(String[] args) {
		Binary_Converter converter = new Binary_Converter();
		converter.createUI();
		
		
		
	}
	private void createUI() {
		
		frame.add(panel);
		panel.add(question);
		panel.add(button);

		panel.add(answer1);
		button.setText("convert");
		button.addActionListener(this);
		frame.setVisible(true);
		panel.setVisible(true);
		panel.setSize(500, 500);
		frame.pack();
	}
	
	int convert(String binary) {
		if(binary.length() != 8){
			JOptionPane.showMessageDialog(null, "Enter 8 bits, silly!!!");
			return 0;
		}
		for(int i = 0; i < binary.length(); i++) {
			if(binary.charAt(i) != '0' && binary.charAt(i) != '1') {
				JOptionPane.showMessageDialog(null, "Binary!!");
				return 0;
			}
		}
			
		try {
			int asciiValue = Integer.parseInt(binary, 2);
			return asciiValue;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Enter a binary, silly!!!");
			question.setText("");
			return 0;
		}
	}
 String converts(String binary) {
   	 int asciiValue = Integer.parseInt(binary, 2);
   	 char theLetter = (char) asciiValue;
   	 return "" + theLetter;
    }
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	int answer = convert(question.getText());
	answer1.setText("" + answer);
	
}

}
