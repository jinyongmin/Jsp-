package com.koreait.crawling;

import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;




public class Navermovie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="https://movie.naver.com/movie/sdb/rank/rmovie.naver";
		Document doc = null;
		try {
			doc=Jsoup.connect(url).get();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		Elements elements = doc.select("table.ranking");
		
		Iterator<Element> title =elements.select("h3.h_movie");
		Iterator<Element> score =elements.select("div.score_result");
		Iterator<Element> review=elements.select("ul.rvw_list_area");
		int rank=1;
		while(title.hasNext()) {
			System.out.println(rank+"순위"+score.next().text() + "평점"+review.next().text());
		}
		
	}

}
