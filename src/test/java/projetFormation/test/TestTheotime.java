package projetFormation.test;



import projetFormation.dao.DaoPersonne;
import projetFormation.dao.DaoPersonneFactory;
import projetFormation.entity.Inscription;
import projetFormation.entity.Personne;

public class TestTheotime {

	public static void main(String[] args) {

		DaoPersonne daoPersonne = DaoPersonneFactory.getInstance();
		
		Personne p1 = new Personne("1", "1",new Inscription("toto","toto"));
		
		daoPersonne.insert(p1);

	} 

}
