package com.koreait.crawling;

import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawling2 {

	public static void main(String[] args) {
		String url="https://music.bugs.co.kr/chart";
		
		Document doc = null;
		try {
			doc=Jsoup.connect(url).get();				//html가져옴 + get방식
			//System.out.println("접속 성공!");
			//System.out.println(doc.html());
			
			
		}catch(Exception e) {
		e.printStackTrace();	
		}

			Elements elements = doc.select("table.byChart");	//Element 객체안의 모든것을 찾아옴
		
			Iterator<Element> title =elements.select("p.title").iterator();	//여러개가 rank안에 들어감
			Iterator<Element> artist =elements.select("p.artist").iterator();	//여러개가 rank안에 들어감
		
			
			int rank = 1;
			while(title.hasNext()) {
			System.out.println(rank+ "위" + artist.next().text() + "-" + title.next().text());
			rank++;
			}

	}

}
