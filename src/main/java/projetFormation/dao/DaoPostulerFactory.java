package projetFormation.dao;

public class DaoPostulerFactory {
	private static DaoPostuler singleton = null;

	public static DaoPostuler getInstance() {
		if (singleton == null) {
			singleton = new DaoPostulerJpaImpl();
		}
		return singleton;
	}

	private DaoPostulerFactory() {

	}
}
