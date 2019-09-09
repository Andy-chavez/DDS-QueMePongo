package domain;

public interface Observee {
	public void registrar(Observer o);
	public void sacar(Observer o);
	public void notificarObservers();
}
