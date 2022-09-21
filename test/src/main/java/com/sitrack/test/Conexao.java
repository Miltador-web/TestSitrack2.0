package com.sitrack.test;

import java.io.IOException;
import java.io.InputStreamReader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class Conexao {
	public Document conexao (String link) throws IOException {
		Document doc = Jsoup.connect(link).get();
		return doc;
	}
}
