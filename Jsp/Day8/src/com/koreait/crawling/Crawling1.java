package com.koreait.crawling;

import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawling1 {

	public static void main(String[] args) {
	//cgv 19개의 데이터 끌어오기
		String url="https://www.cgv.co.kr/movies/";
		//System.out.println("접속주소:" + url);

		Document doc = null;
		try {
			doc=Jsoup.connect(url).get();
			//System.out.println("접속 성공!");
			//System.out.println(doc.html());
			
			
		}catch(Exception e) {
		e.printStackTrace();	
		}
		Elements elements = doc.select("div.sect-movie-chart");	//Element 객체안의 모든것을 찾아옴
		Iterator<Element> rank =elements.select("strong.rank").iterator();	//여러개가 rank안에 들어감
		Iterator<Element> title =elements.select("strong.title").iterator();	//여러개가 rank안에 들어감
	
		while(rank.hasNext()) {
			System.out.println(rank.next().text() + ":" + title.next().text());
		}
	
	}
}
