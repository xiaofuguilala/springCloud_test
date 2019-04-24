package com.example.demo.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.baomidou.springboot.mapper*")
public class MybatisPlusConfig {
    // 分页拦截器
    @Bean
    public PaginationInterceptor paginationInterceptor(){

        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }

}