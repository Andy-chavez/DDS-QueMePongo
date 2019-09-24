package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
 // TO DO not sure about this
@Entity
@Table(name = "capa")
public enum Capa {
	@Id
	@Column(columnDefinition = "tipo_capa")
	@Enumerated(EnumType.STRING)
	CALZADO, PANTALON, ACCESORIO, REMERA, CAMISA, SWEATER, CAMPERA
}
