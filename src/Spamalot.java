	import java.awt.Frame;
	
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

	

	
public class Spamalot implements ActionListener{
	JTextField question;
	static final String FAKE_USERNAME = "51yummyyummyinmytummy15@gmail.com";
	static final String FAKE_PASSWORD = "LemonadeIsYummy245";
	String subject = "MYLEMONSNEEDTOBESQUEEZED";
	String message = "PLEASESQUEEZEMYLEMONS";
	JButton button = new JButton();
	JButton button1 = new JButton();
	public static void main(String[] args) {
		
	
		Spamalot spam = new Spamalot();
		spam.createUI();
	}

	

private void createUI() {
	Frame frame = new JFrame();
	JPanel panel = new JPanel();
	
	question = new JTextField(40);
	frame.setVisible(true);
	question.setText("EMAIL");
	frame.add(panel);
	panel.add(question);
	panel.add(button);
	panel.add(button1);
	
	button1.setText("BAD");
	button.setText("GOOD");
	
	frame.pack();
	
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource() == button) {
	sendSpam(question.getText(), subject, message);
	System.out.println(sendSpam);
	}
}

private boolean sendSpam(String recipient, String subject, String content) {

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(FAKE_USERNAME, FAKE_PASSWORD);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(FAKE_USERNAME));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
			message.setSubject(subject);
			message.setText(content);
			Transport.send(message);
			return true;

		} catch (MessagingException e) {
e.printStackTrace();
return false;
		}
	}

}


