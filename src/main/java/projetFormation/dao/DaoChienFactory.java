package projetFormation.dao;

public class DaoChienFactory {
	private static DaoChien singleton = null;

	public static DaoChien getInstance() {
		if (singleton == null) {
			singleton = new DaoChienJpaImpl();
		}
		return singleton;
	}

	private DaoChienFactory() {

	}
}
