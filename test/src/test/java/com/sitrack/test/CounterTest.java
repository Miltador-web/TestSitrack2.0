package com.sitrack.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Scanner;



import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

class CounterTest {

	@Test
	public void testCounter() throws IOException {
		@SuppressWarnings("resource")
		Scanner log = new Scanner(System.in, "utf-8");
		//Link a busca "https://es.wikipedia.org/wiki/Pirámides_de_Egipto"
		String link = "https://es.wikipedia.org/wiki/Pirámides_de_Egipto";
		Conexao lg = new Conexao();
		Document doc = lg.conexao(link);
		//Frase a buscar "bloques de piedra"
		String frase = "bloques de piedra";
		Elements text = doc.getElementsMatchingOwnText(frase);
		CounterFrase contador = new CounterFrase();
		int total = contador.counter(text);
		assertEquals(2, total);
	}
}
