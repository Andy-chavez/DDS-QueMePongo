package domain;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="suscripcion")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminador")
public abstract class Suscripcion extends EntidadPersistente {
	protected abstract void agregarPrenda(Guardarropa armario,Prenda prenda);
	protected abstract void cambiarAPremium(Usuario u);
	protected abstract void cambiarAFree(Usuario u);
	protected abstract List<Prenda> getPrendasDelGuardarropa(Guardarropa g);
}
