package com.sitrack.test;

import java.io.IOException;
import java.util.Scanner;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(TestApplication.class, args);
		
		@SuppressWarnings("resource")
		Scanner log = new Scanner(System.in, "utf-8");
		System.out.println("Qual link deseja buscar?");
		
		String link = log.nextLine();
		Conexao lg = new Conexao();
		Document doc = lg.conexao(link);
		
		System.out.println("Qual frase deseja busca?");
		String frase = log.nextLine().toString();
		Elements text = doc.getElementsMatchingOwnText(frase);
		CounterFrase contador = new CounterFrase();
		int total = contador.counter(text);
		System.out.println("a frase"+'"'+frase+'"'+ " se repite "+total+ " veces");
		
	String[] palavra = frase.split(" ");
		
		for(String word : palavra) {
			
			int i = 0;
			String words = doc.body().text();
			words = words.replaceAll("[^a-zA-Z0-9_]"," ");
			String[] allWords =  words.split(" ");
			for(String eachWord : allWords ) {
				if(word.equals(eachWord)) {
					i++;
				}
			}
			
			
			
			System.out.println('"'+word+'"'+ " se repite "+ i + " veces");
		}
	}

}
