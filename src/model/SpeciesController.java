package model;

public class SpeciesController {

	private Species[] species;

	public SpeciesController() {

		this.species = new Species[80];

	}

	public boolean registerFlora(String name, String scientificName, boolean flowes, boolean fruits, double maxHeight) {

		for (int i = 0; i < species.length; i++) {
			if (species[i] == null) {
				species[i] = new Flora(name, scientificName, flowes, fruits, maxHeight);
				return true;
			}

		}

		return false;

	}

	public boolean registerFauna(String name, String scientificName, boolean migratory, double maxWeight) {

		for (int i = 0; i < species.length; i++) {
			if (species[i] == null) {
				species[i] = new Fauna(name, scientificName, migratory, maxWeight);
				return true;
			}

		}

		return false;

	}

	public String showSpeciesList() {

		String msg = "";

		for (int i = 0; (i < species.length); i++) {
			if (species[i] != null) {
				msg += "\n" + (i + 1) + ". " + species[i].getName();
			}
		}

		return msg;

	}

	public Species searchSpecies(String name) {

		if (species == null) {
			return null;
		} else {
			for (int k = 0; k < species.length; k++) {
				if (species[k] != null && species[k].getName().equalsIgnoreCase(name)) {
					return species[k];
				}
			}
		}
		return null;
	}

	public String showSpeciesInfo(String name) {
		Species foundSpecies = searchSpecies(name); 
	
		if (foundSpecies != null) {
			return foundSpecies.toString(); 
		} else {
			return "Species not found.";
		}
	}

	public boolean deleteSpecies(String name) {
		Species speciesToDelete = searchSpecies(name); 
	
		if (speciesToDelete != null) {
			for (int i = 0; i < species.length; i++) {
				if (species[i] == speciesToDelete) { 
					species[i] = null;
					return true;
				}
			}
		}
		return false; 
	}
	
	

}
