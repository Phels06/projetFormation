package projetFormation.dao;

public class DaoPersonneFactory {
	private static DaoPersonne singleton = null;

	public static DaoPersonne getInstance() {
		if (singleton == null) {
			singleton = new DaoPersonneJpaImpl();
		}
		return singleton;
	}

	private DaoPersonneFactory() {

	}
}
