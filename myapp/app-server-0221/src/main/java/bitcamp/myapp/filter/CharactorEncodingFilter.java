package bitcamp.myapp.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class CharactorEncodingFilter implements Filter {

  // 요청 데이터를 꺼내기 전에, 즉 gerParameter() 를 호출하기 전에
  // 클라이언트가 보낸 값이 어떤 문자 집합으로 인코딩 되었는지 알려줌
  // post 요청으로 한글 데이터가 들어 왔을때 한글을 깨트리지 않고 꺼낸느 방법

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    request.setCharacterEncoding("UTF-8");
    chain.doFilter(request, response); // 다음 필터가 없으면 최종 목적지인 서블릿 실행

  }

}
