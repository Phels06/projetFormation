package projetFormation.dao;

public class DaoAnnonceFactory {
	private static DaoAnnonce singleton = null;

	public static DaoAnnonce getInstance() {
		if (singleton == null) {
			singleton = new DaoAnnonceJpaImpl();
		}
		return singleton;
	}

	private DaoAnnonceFactory() {

	}
}
