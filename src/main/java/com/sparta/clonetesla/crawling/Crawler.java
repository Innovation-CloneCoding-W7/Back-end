package com.sparta.clonetesla.crawling;

import com.sparta.clonetesla.entity.Category;
import com.sparta.clonetesla.repository.CategoryRepository;
import com.sparta.clonetesla.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

@RequiredArgsConstructor
public class Crawler {
//    private final CategoryRepository categoryRepository;
//    private final ProductRepository productRepository;

    public static void main(String args[]){
        try {
            // 1. 수집 대상 URL
            String CategoryURL = "https://shop.tesla.com/ko_kr/category/charging";

            // 2. Connection 생성
            Document doc = Jsoup.connect(CategoryURL).get();

            // 3. 원하는 부분 가져오기
            Elements titles = doc.select("#main-menu > div:nth-child(1) > ol");
            String[] temp = titles.get(0).text().split(" ");

            //4. Category 테이블 DB에 삽입
            for(int i = 0; i < temp.length; i++){
                Category category = Category.builder()
                        .category(temp[i])
                        .build();
//                categoryRepository.save(category);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
