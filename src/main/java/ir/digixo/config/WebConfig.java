package ir.digixo.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.util.UrlPathHelper;

import java.util.List;
import java.util.Properties;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"ir.digixo"})
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public ViewResolver viewResolver()
    {
        InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper=new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);
    }
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // converters.add(new StringHttpMessageConverter());
        // converters.add(new Jaxb2RootElementHttpMessageConverter());
        converters.add(new MappingJackson2HttpMessageConverter());
    }

    //
   /* @Bean
    public HandlerExceptionResolver getHandlerExceptionResolver() {
        return new HandlerExceptionResolver() {

            @Override
            public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

                ModelAndView modelAndView = new ModelAndView();
                modelAndView.setViewName("error");
                modelAndView.addObject("exception", ex);
                return modelAndView;
            }
        };
    }*/
   /* @Bean
    public HandlerExceptionResolver getHandlerExceptionResolver() {
       SimpleMappingExceptionResolver exceptionResolver=new SimpleMappingExceptionResolver();
       Properties properties=new Properties();
       properties.put("java.lang.Exception", "error1");
       properties.put("java.lang.Nu", "error2");

       exceptionResolver.setExceptionMappings(properties);
       exceptionResolver.addStatusCode("error1",404);
       exceptionResolver.setDefaultErrorView("error");
       return exceptionResolver;
    }*/
}
