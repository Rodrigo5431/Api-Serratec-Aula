package org.serratec.backend.serviceDto.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailConfig {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendEmail(String para, String Assunto, String texto) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("rodrigokarvalho12890@gmail.com");
		message.setTo(para);
		message.setSubject(Assunto);
		message.setText("Teteu, perdoe");
	}
}
