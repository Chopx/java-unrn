package ar.unrn.tp3.modelo;

public class RegionParticipante {
	private String region;

	public RegionParticipante(String region) {

		if (!region.equals("China") && !region.equals("US") && !region.equals("Europa"))
			new RuntimeException("Region desconocida. Las conocidas son: China, US, Europa");
		
		this.region = region;
	}
	
	public String obtenerRegion () {
		return this.region;
	}
}
