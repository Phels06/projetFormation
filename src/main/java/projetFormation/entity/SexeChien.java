package projetFormation.entity;

public enum SexeChien {
	F("Feminin"), M("Masculin");

	private String sexeChien;

	private SexeChien(String sexeChien) {
	}

	public String getSexeChien() {
		return sexeChien;
	}

}
