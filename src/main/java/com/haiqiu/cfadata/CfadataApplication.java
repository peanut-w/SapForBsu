package com.haiqiu.cfadata;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

import javax.servlet.Filter;

@SpringBootApplication
@MapperScan("com.haiqiu.cfadata.dao")
public class CfadataApplication  {

    public static void main(String[] args) {
        SpringApplication.run(CfadataApplication.class, args);
    }
    /**
     * Etag 过滤器
     */
    @Bean
    public Filter filter() {
        ShallowEtagHeaderFilter filter = new ShallowEtagHeaderFilter();
        filter.setWriteWeakETag(Boolean.TRUE);
        filter.getFilterConfig();
        return filter;
    }
}
