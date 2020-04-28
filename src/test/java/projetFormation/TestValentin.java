package projetFormation;

import projetFormation.context.Context;

public class TestValentin {

	public static void main(String[] args) {
		Context.getEntityManagerFactory();
		
		Context.destroy();

	}

}
