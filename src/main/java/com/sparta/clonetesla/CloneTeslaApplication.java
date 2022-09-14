package com.sparta.clonetesla;

import com.sparta.clonetesla.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.io.IOException;

@SpringBootApplication
@EnableJpaAuditing
@RequiredArgsConstructor
public class CloneTeslaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloneTeslaApplication.class, args);
//	}
//
//	private final ProductRepository productRepository;
//	@EventListener(ApplicationReadyEvent.class)
//	public void init(){
//		try {
//			// 1. 수집 대상 URL
//			String CategoryURL = "https://shop.tesla.com/ko_kr/category/charging";
//
//			// 2. Connection 생성
//			Document doc = Jsoup.connect(CategoryURL).get();
//
//			// 3. 원하는 부분 가져오기
//			Elements titles = doc.select("#main-menu > div:nth-child(1) > ol");
//			String[] temp = titles.get(0).text().split(" ");
//
//			//4. Category 테이블 DB에 삽입
//			for(int i = 0; i < temp.length; i++){
//				Category category = Category.builder()
//						.categoryName(temp[i])
//						.build();
//
//				categoryRepository.save(category);
//				Elements link = doc.select("#category--charging--charging_at_home > ul > li:nth-child(1) > div.product-tile__container > div.product-tile__images > a");
//				String linkHref = link.first().attr("href");
//			}
//			// ------------------------------------------------------------------------
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void insertDB(String productURL, Category category){
//		String CategoryURL = productURL;
	}
}
