package Utilitiespackage;

import java.util.Date;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date=new Date();
		System.out.println(date.toString().replace(" ", "_").replace(":", "_"));
		//System.out.println(date.toString().replace(" ", "_").replace(":", "_"));
        String datetext=(date.toString().replace(" ", "_").replace(":", "_"));

	}

}
