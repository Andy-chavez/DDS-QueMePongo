package entities;

public interface Observer {
	public void registrar(Observee o);
	public void sacar(Observee o);
	public void notificarObservers();
}
