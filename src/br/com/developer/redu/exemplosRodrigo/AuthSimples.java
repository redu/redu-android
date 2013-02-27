package br.com.developer.redu.exemplosRodrigo;
import java.util.Scanner;

import br.com.developer.redu.DefaultReduClient;

public class AuthSimples {
	private static final String CONSUMER_KEY = "YzbH0ulBcOjXSPtmhJuEHNFFf6eZGiamQeOBQhU1";
	private static final String CONSUMER_SECRET_KEY = "kUdQsrimVZqgS7u1JuCnMGvARWhmiLWcbrZKwYO8";

	public static void main(String[] args) {
		DefaultReduClient redu = new DefaultReduClient(CONSUMER_KEY, CONSUMER_SECRET_KEY);
		Scanner in = new Scanner(System.in);
		System.out.println("Visit this url: "+redu.getAuthorizeUrl());
		//pin
		// z3nzIybwECnAxefLcdl0
		//String pin = in.nextLine();
		String pin = "z3nzIybwECnAxefLcdl0";

		System.out.println("Using this pin: "+ pin);
		

		redu.initClient(pin); // Só é necessário pedir um pin por usuário.

		// Teste a autenticação com uma requisição simples, este metódo deve retornar
		// as informações do usuário autorizado.
		System.out.println(redu.getMe());
	}	
}