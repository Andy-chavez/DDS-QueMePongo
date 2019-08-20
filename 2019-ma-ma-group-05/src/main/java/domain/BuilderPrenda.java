package domain;

import java.awt.Color;

public class BuilderPrenda {
	private Prenda prenda;
	private Tipo tipo;

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
	public BuilderPrenda setTipoAUtilizar(Tipo tipoDeEstaPrenda) {
		this.tipo = tipoDeEstaPrenda;
		return this;
	}

	public BuilderPrenda setearTelaATipo(Tela unaTela) {
		this.tipo.establecerTela(unaTela);
		return this;
	}

	public Prenda crearPrenda() {
		this.prenda.validarAtributos();
		return prenda;
	}
}
