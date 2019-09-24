package entities.EnumsNecesarios;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "suscripcion")
public enum SuscripcionEnum {
	@Id
	@Column(columnDefinition = "suscripcion_id")
	@Enumerated(EnumType.STRING)
	FREE,PREMIUM
}
