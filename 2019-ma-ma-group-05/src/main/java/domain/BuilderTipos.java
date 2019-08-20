package domain;

public class BuilderTipos {
	
	private Tipo miTipo;
	private FamiliaTipos fabricaTipos;
	

	public BuilderTipos empezarCreacion() {
		miTipo = new Tipo();
		return this;
	}

	public BuilderTipos setFabricaTipos(FamiliaTipos fabricaTipos) {
		this.fabricaTipos = fabricaTipos;
		return this;
	}

	public BuilderTipos setTela(Tela tela) {
		if (fabricaTipos.getTelasPosibles().contains(tela)) {
			miTipo.setTela(tela);
			return this;
		}
		else
			throw new IllegalArgumentException("Tela no permitida");
	}
	
	public Tipo crearTipo() {
		miTipo.setCategoria(fabricaTipos.getCategoria());
		miTipo.setNombre(fabricaTipos.getTipo());
		miTipo.setCapa(fabricaTipos.getCapa());
		miTipo.setNivelAbrigo(fabricaTipos.getNivelAbrigo());
		return miTipo;
	}
}
