package domain;

public class C_BuilderTipos {
	
	private Tipo miTipo;
	public C_FamiliaTipos fabricaTipos;
	

	public C_BuilderTipos empezarCreacion() {
		miTipo = new Tipo();
		return this;
	}

	public C_BuilderTipos setFabricaTipos(C_FamiliaTipos fabricaTipos) {
		this.fabricaTipos = fabricaTipos;
		return this;
	}

	public C_BuilderTipos setTela(Tela tela) {
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
		return miTipo;
	}
}
