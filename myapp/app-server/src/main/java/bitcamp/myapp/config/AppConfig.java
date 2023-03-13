package bitcamp.myapp.config;

import bitcamp.myapp.controller.StudentController;
import bitcamp.myapp.controller.TeacherController;
import bitcamp.myapp.web.interceptor.AuthInterceptor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration

@ComponentScan(
    value = "bitcamp.myapp.controller",
    excludeFilters = {
        @Filter(
            type = FilterType.ASSIGNABLE_TYPE,
            classes = {StudentController.class, TeacherController.class})
    })

// WebMVC 관련 설정을 처리하고 싶다면 다음 애노테이션을 추가하라!
// => WebMVC 관련 설정을 수행하는 클래스를 정의했으니,
//    WebMvcConfigurer 구현체를 찾아
//    해당 인터페이스에 정의된대로 메서드를 호출하여
//    설정을 수행하라는 의미다!
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {

  Logger log = LogManager.getLogger(getClass());

  {
    log.trace("AppConfig 생성됨!");
  }

  @Bean
  public MultipartResolver multipartResolver() {
    log.trace("MultipartResolver 생성됨!");
    return new StandardServletMultipartResolver();
  }

  // WebMvcConfigurer 규칙에 맞춰 인터셉터를 등록한다.
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    log.trace("AppConfig.addInterceptors() 호출됨!");
    registry.addInterceptor(new AuthInterceptor()).excludePathPatterns("/auth/**");
  }
}

