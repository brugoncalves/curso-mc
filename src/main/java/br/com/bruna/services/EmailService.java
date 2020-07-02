package br.com.bruna.services;

import org.springframework.mail.SimpleMailMessage;

import br.com.bruna.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}
