package com.gdsc.waffle;

import com.gdsc.waffle.domain.CategoryEntity;
import com.gdsc.waffle.domain.TodoEntity;
import com.gdsc.waffle.repository.CategoryRepository;
import com.gdsc.waffle.repository.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@SpringBootApplication
public class WaffleApplication {

    public static void main(String[] args) {
        SpringApplication.run(WaffleApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(TodoRepository todoRepository) {
        return (args) -> IntStream.rangeClosed(1, 10).forEach(index -> todoRepository.save(TodoEntity.builder()
                .content("오늘 할 일" + index)
                .createdDateTime(LocalDateTime.now())
                .status(false)
                .build())
        );
    }

    /*@Bean
    public CommandLineRunner runner(CategoryRepository categoryRepository){
        return (args) -> IntStream.rangeClosed(1, 10).forEach(index -> categoryRepository.save(CategoryEntity.builder()
                .categoryId((long) index)
                .categoryTitle("카테고리 제목 : " + index)
                .build())
        );
    }*/
}
