package domain;

import java.awt.Color;

public class C_BuilderPrenda {
	private C_Prenda prenda;
	private C_BuilderTipos fabricaTipo;

	public C_BuilderPrenda empezarCreacion() {
		prenda = new C_Prenda();
		return this;
	}

	// Seteo los colores
	public C_BuilderPrenda setColorPrimario(Color unColorPrimario) {
		prenda.setColorPrimario(unColorPrimario);
		return this;
	}

	public C_BuilderPrenda setColorSecundarioOpcional(Color unColorSecundario) {
		prenda.setColorSecundario(unColorSecundario);
		return this;
	}

	// Llamo al builder de Tipos
	public C_BuilderPrenda setTipoAUtilizar(C_FamiliaTipos tipoDeEstaPrenda) {
		fabricaTipo = new C_BuilderTipos();
		this.fabricaTipo.setFabricaTipos(tipoDeEstaPrenda);
		return this;
	}

	public C_BuilderPrenda crearTipoConTelaYCategoria(Tela unaTela) {
		Tipo tipoDeEstaPrenda = 
				fabricaTipo
				.empezarCreacion()
				.setTela(unaTela)
				.crearTipo();
		prenda.setTipo(tipoDeEstaPrenda);
		return this;
	}

	public C_Prenda crearPrenda() {
		this.prenda.validarAtributos();
		return prenda;
	}
}
