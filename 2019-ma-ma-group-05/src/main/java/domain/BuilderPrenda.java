package domain;

import java.awt.Color;

public class BuilderPrenda {
	private Prenda prenda;
	private BuilderTipos fabricaTipo;

	public BuilderPrenda empezarCreacion() {
		prenda = new Prenda();
		return this;
	}

	// Seteo los colores
	public BuilderPrenda setColorPrimario(Color unColorPrimario) {
		prenda.setColorPrimario(unColorPrimario);
		return this;
	}

	public BuilderPrenda setColorSecundarioOpcional(Color unColorSecundario) {
		prenda.setColorSecundario(unColorSecundario);
		return this;
	}
	public BuilderPrenda setImagen(String path) {
		prenda.setImage(path);
		return this;
	}
	// Llamo al builder de Tipos
	public BuilderPrenda setTipoAUtilizar(FamiliaTipos tipoDeEstaPrenda) {
		fabricaTipo = new BuilderTipos();
		this.fabricaTipo.setFabricaTipos(tipoDeEstaPrenda);
		return this;
	}

	public BuilderPrenda crearTipoConTelaYCategoria(Tela unaTela) {
		Tipo tipoDeEstaPrenda = 
				fabricaTipo
				.empezarCreacion()
				.setTela(unaTela)
				.crearTipo();
		prenda.setTipo(tipoDeEstaPrenda);
		return this;
	}

	public Prenda crearPrenda() {
		this.prenda.validarAtributos();
		return prenda;
	}
}
