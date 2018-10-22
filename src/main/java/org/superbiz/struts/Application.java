package org.superbiz.struts;

import com.opensymphony.module.sitemesh.filter.PageFilter;
import org.apache.struts2.dispatcher.ActionContextCleanUp;
import org.apache.struts2.dispatcher.FilterDispatcher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public FilterRegistrationBean struts2() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        registrationBean.setOrder(100);
        registrationBean.setName("struts2");
        registrationBean.setFilter(new FilterDispatcher());
        registrationBean.addUrlPatterns("/*");

        registrationBean.addInitParameter("actionPackages", "com.lq");

        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean strutsCleanup() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        registrationBean.setOrder(200);
        registrationBean.setName("struts-cleanup");
        registrationBean.setFilter(new ActionContextCleanUp());
        registrationBean.addUrlPatterns("/*");

        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean sitemesh() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        registrationBean.setOrder(300);
        registrationBean.setName("sitemesh");
        registrationBean.setFilter(new PageFilter());
        registrationBean.addUrlPatterns("/*");

        return registrationBean;
    }
}
