package com.sitrack.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;



import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

class CounterTest {

	@Test
	public void testCounter() throws IOException {
		BufferedReader log = new BufferedReader(
	            new InputStreamReader(System.in));
		//Link a busca "https://es.wikipedia.org/wiki/Pirámides_de_Egipto"
		System.out.println("Qual link deseja buscar?");
		
		String link = log.readLine();
		Conexao lg = new Conexao();
		Document doc = lg.conexao(link);
		//Frase a buscar "bloques de piedra"
		System.out.println("Qual frase deseja busca?");
		String frase = log.readLine();
		Elements text = doc.getElementsMatchingOwnText(frase);
		CounterFrase contador = new CounterFrase();
		int total = contador.counter(text);
		assertEquals(2, total);
	}
}
