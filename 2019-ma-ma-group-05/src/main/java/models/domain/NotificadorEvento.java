package models.domain;

import models.entities.Evento;

import java.util.TimerTask;

public class NotificadorEvento extends TimerTask{
	Evento evento;
	public NotificadorEvento(Evento evento){
		this.evento = evento;
	}
	
	@Override
	public void run() {
		
	}
}
