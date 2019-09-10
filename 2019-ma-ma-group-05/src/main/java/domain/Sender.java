package domain;

import dtoClases.SenderDto;

public abstract class Sender {
	protected void configurar() {	}
	protected void enviar(SenderDto dto){	}
}
