# Filter

> ποΈ **νν° (Filter)**
> 
>J2EE νμ€ κΈ°μ λ‘ ν΄λΌμ΄μΈνΈ μμ²­μ΄ DispatcherServlet μ μ λ¬ λκΈ° μ , ν μμ μΌλ‘ λμνμ¬ μμ²­, μλ΅μ λν μ μ΄λ₯Ό ν  μ μλ κ²


π‘ **J2EE ?**

```java
μλ°(JAVA) κΈ°μ λ‘ κΈ°μνκ²½μ μ΄νλ¦¬μΌμ΄μμ λ§λλλ° νμν μ€νλ€μ λͺ¨μλ μ€ν μ§ν©μ
```

# β Filter κ΅¬μ‘°

<br>

![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/7ab3db6b-1856-4291-b393-1a71006358de/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220308%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220308T125046Z&X-Amz-Expires=86400&X-Amz-Signature=f6ba4ed79a584f982f2431fcde0e2cc31d81cf7cd84fde3382bcab4b73f088e1&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject)

κ·Έλ¦Όκ³Ό κ°μ΄ `Filter` λ `Web Context` κ³μΈ΅μ μμΉνλ€. μμ λ§ν κ²μ²λΌ Spring μμ `Front Controller` μ­ν μ μννλ `DispatcherServlet` μ μμ²­μ΄ μ λ¬λκΈ° μ κ³Ό ν μμ μ λμνλ€.

μ΄ λ§μ μ¦, `Spring Context` λ₯Ό λ²μ΄λμ `Tomcat, Jetty` λ± `WAS` κ³μΈ΅μ μ μ­μ μΌλ‘ νΉμ  μ‘μμ μ·¨ν΄μΌ ν  λ μ¬μ©νλ€.

μλ₯Ό λ€λ©΄, μΈμ¦, κΆν μ²΄ν¬ μ΄μλ μ΄λ―Έμ§ νΉμ λ°μ΄ν°μ λν λ¬Έμμ΄ μΈμ½λ© μ²λ¦¬ λ°©μμ μ²λ¦¬νλ λ±μ μ¬μ©νλ€. Spring μμλ Filter κ³μΈ΅μ μ΄μ©ν΄μ κ°λ°μλ‘ νμ¬κΈ λ³΄μ λͺ¨λμ μ κ³΅νλλ° μ΄ λͺ¨λμ΄ λ°λ‘ `Spring Security` μ΄λ€.

λν `Filter` κ° μ¬λ¬ κ°λ₯Ό κ΅¬μ±ν΄μ `FilterChain` ννλ₯Ό μ·¨ν  μ μλ€λ κ²μ΄λ€. Filter μ²λ¦¬ μμμ λν΄μ κ°λ°μκ° μ§μ ν΄μ€ μλ μλ€.

# β Filter μ μλͺ μ£ΌκΈ°

<br>

```java
package javax.servlet;

import java.io.IOException;

public interface Filter {
    default void init(FilterConfig filterConfig) throws ServletException {
    }

    void doFilter(ServletRequest var1, ServletResponse var2, FilterChain var3) throws IOException, ServletException;

    default void destroy() {
    }
}

```

`Filter` μΈν°νμ΄μ€λ₯Ό νκ³  λ€μ΄κ°λ³΄λ©΄ μμ κ°μ΄ μκ²Όλ€. μλͺ μ£ΌκΈ°λ μλμ κ°λ€.

<br>

### 1οΈβ£ init()

- μμ²­μ΄ λ°μνλ©΄ μΉ μ»¨νμ΄λκ° νμν νν° κ°μ²΄λ₯Ό μ΄κΈ°ννκ³  μλΉμ€μ μΆκ°νλ€.

### 2οΈβ£ doFilter()

- Filterλ₯Ό μ»€μ€νν΄μ μ¬μ©ν  λ ν΄λΉ λ©μλλ₯Ό λ°λμ μ μν΄μ£Όμ΄μΌ νλ€. ν΄λΉ λ©μλλ DispatcherServlet μΌλ‘ μμ²­μ΄ μ λ¬λκΈ° μ , νλ‘ νν°λ₯Ό λμμν€λ λ©μλμ΄λ€.
- λ§€κ°λ³μλ‘ λ€μ΄κ°λ FilterChain μ doFilter() λ©μλλ₯Ό νΈμΆνλ©΄, μμ²­μ λ·λ¨μΌλ‘ μ λ¬νλ€.
- κ·Έλμ, filterChain.doFilter() λ₯Ό νΈμΆ νκΈ° μ μ μ΄λ ν μ²λ¦¬ κ³Όμ μ λ£μ΄ μ€ μ μλ€.

### 3οΈβ£ destory()

- μΉ μ»¨νμ΄λκ° μμ±ν νν° κ°μ²΄λ₯Ό μ κ±°νκ³  μμμ λ°ννλ€.

# β Spring μμ Filter μ¬μ©νκΈ°

<br>

μλͺμ£ΌκΈ°μμ μΈκΈν κ²μ²λΌ, μ»€μ€ν νν°λ₯Ό κ΅¬ννκΈ° μν΄μλ μ `Filter` μΈν°νμ΄μ€λ₯Ό κ΅¬ννλ©΄ λλ€. μμ²­μ΄ νΈλ€λ¬κΉμ§ μ λ¬λκΈ° μ μ λ‘κ·Έλ₯Ό λ¨κΈ°κ³  μΆλ€κ³  κ°μ νλ€.

λ¨Όμ , λ‘κ·Έλ₯Ό λ¨κΈ°λ νν° ν΄λμ€λ₯Ό κ΅¬ννλ€. λν, Chain ννλ‘ κ΅¬μ±ν΄μ μ¬λ¬ νν°λ₯Ό λ§λ€ κ²μ΄λ€.

λ§λ€ μ¬λ¬ νν°λ€μ λν΄ μμλ₯Ό λ³΄μ₯νκΈ° μν΄ `@Order` μ£Όμμ μ¬μ©νλ€.

```java
@Component
@Slf4j
@Order(1)
public class RequestLoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("In Request Logging Filter !!");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
```

```java
@Component
@Slf4j
@Order(2)
public class ResponseLoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("In Response Logging Filter !!");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
```

νν°λ₯Ό λ§λ€μ΄μ `bean` μΌλ‘ λ±λ‘μ ν΄λμλ€. μ΄λ κ² μ€μ νκ³  Spring μ λλ¦¬λ©΄, `λͺ¨λ  μμ²­`μ λν΄μ μ νν°λ€μ΄ μ μ©λ  κ²μ΄λ€. μ΄μ  νΈλ€λ¬(Controller) νλλ₯Ό λ§λ€μ΄ `/` κ²½λ‘λ‘ μμ²­μ λ³΄λ΄λ³΄μ.

```java
@RestController
@Slf4j
public class HomeController {

    @GetMapping("/")
    public String hello() {
        log.info("hello() handler processing");
        return "Hello spring-til";
    }
```

```
μμ²­ κ²½λ‘ : "/"

(κ²°κ³Ό)
c.study.til.filter.RequestLoggingFilter  : In Request Logging Filter !!
c.s.til.filter.ResponseLoggingFilter     : In Response Logging Filter !!
c.s.t.s.controller.HomeController        : hello() handler processing
```

μ μμ μΌλ‘ `DispatcherServlet` μ΄ νΈλ€λ¬λ₯Ό μ°Ύμμ νΈλ€λ§ νκΈ° μ μ νν°λ€μ΄ μμμ λ§κ² μ€νλ κ²μ μ μ μλ€.

# β νΉμ  Url μ λ°μνλ Filter λ§λ€κΈ°

<br>

λͺ¨λ  μμ²­μ΄ μλ **νΉλ³ν κ²½λ‘μ λν΄μ**λ§ Filter λ₯Ό λ§λ€κ³  μΆμ μ μλ€. μ΄λ° κ²½μ°, `@Component` μ£Όμμ μ¬μ©ν΄μ μ μ­ λΉμΌλ‘ λ±λ‘νλ κ²μ΄ μλλΌ, λ³λμ `Bean` μΌλ‘ λ±λ‘ν΄μ Spring μκ² μλ €μ£Όμ΄μΌ νλ€.

λ¨Όμ , νΉλ³ν κ²½λ‘μ λν΄ μ¬μ©ν  νν°λ₯Ό λ§λ λ€.

```java
@Slf4j
public class SpecificUrlPatternFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("In Specific Url Pattern Filter !!");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
```

κ·Έλ¦¬κ³ , νΉλ³ν κ²½λ‘μ μμ©ν  νΈλ€λ¬λ₯Ό λ§λ λ€.

```java
@RestController
@Slf4j
public class HomeController {

    ...

    @GetMapping("/specific-url-pattern")
    public String specificUrlPattern() {
				log.info("specificUrlPattern() handler processing");
        return "Test sepecific url pattern filter !!";
    }
}
```

κ·Έλ° λ€, `Bean`μ λ±λ‘νκΈ° μν μ€μ μ μ§ννλ€. 
bean μΌλ‘ λ±λ‘ν  μ£Όμ²΄λ`FilterRegistrationBean` μ΄κ³  ν΄λΉ κ°μ²΄μ λ΄κ° λ§λ  νν°μ μ΄λ url ν¨ν΄μ λ°μνκ² ν  μ§λ₯Ό μΈνν΄μΌ νλ€.
μ΄λ [Spring doc](https://www.baeldung.com/spring-exclude-filter#2-filterregistration) μμ μ°Έκ³ νμλ€.

```java
@SpringBootApplication
public class TilApplication {
    public static void main(String[] args) {
        SpringApplication.run(TilApplication.class, args);
    }

    @Bean
    FilterRegistrationBean<SpecificUrlPatternFilter> specificUrlPatternFilterFilterRegistrationBean() {
        final FilterRegistrationBean<SpecificUrlPatternFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new SpecificUrlPatternFilter());
        filterRegistrationBean.addUrlPatterns("/specific-url-pattern/*");
        return filterRegistrationBean;
    }
}
```

κ·Έλ° λ€ ν΄λΉ url ν¨ν΄μΈ `/specific-url-pattern` μΌλ‘ μμ²­μ λ³΄λ΄λ³΄μλ€.

```java
c.study.til.filter.RequestLoggingFilter  : In Request Logging Filter !!
c.s.til.filter.ResponseLoggingFilter     : In Response Logging Filter !!
c.s.til.filter.SpecificUrlPatternFilter  : In Specific Url Pattern Filter !!
c.s.t.s.controller.HomeController        : specificUrlPattern() handler processing
```

μλ λ§λ€μ΄λ κ²½λ‘μΈ `/` λ‘ λ³΄λ΄λ©΄, `SpecificUrlPatternFilter` κ° μ μ©λμ§ μκ³  **μΈνν΄λ url ν¨ν΄μ λ§λ μμ²­μΌλ‘ λ³΄λ΄λ©΄ ν΄λΉ νν°κ° μλ**νλ κ²μ μ μ μλ€.

λ¬Όλ‘  μ΄μ μ λ§λ€μ΄λ **2κ°μ νν°**λ `@Component` λ₯Ό μ¬μ©ν΄μ μ μ­ bean μΌλ‘ λ±λ‘ν΄λμκΈ° λλ¬Έμ λͺ¨λ  μμ²­μ λν΄ λ°μνλ κ²μ΄λ€.

<br>

---

π [https://www.baeldung.com/spring-exclude-filter](https://www.baeldung.com/spring-exclude-filter)

π [https://www.youtube.com/watch?v=h66g0mFpvVE](https://www.youtube.com/watch?v=h66g0mFpvVE)

π [https://mangkyu.tistory.com/173](https://mangkyu.tistory.com/173)

π [https://gardeny.tistory.com/35](https://gardeny.tistory.com/35)
