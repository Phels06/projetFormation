package projetFormation.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import projetFormation.config.AppConfig;

public class TestValentin {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		ctx.close();

	}

}
