package org.java.full.stack.spring.security;

//@Configuration
//@EnableWebSecurity
//public class WebSecurity extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {
public class WebSecurity {

//	@Override
//	protected void configure(HttpSecurity security) throws Exception {
//		security.authorizeRequests().antMatchers("/", "/home", "/orders", "/products", "/customers").permitAll()
//				.anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().and().logout()
//				.permitAll();
//		;
//	}
//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/home").setViewName("index");
//		registry.addViewController("/").setViewName("index");
//		registry.addViewController("/hello").setViewName("hello");
//		registry.addViewController("/login").setViewName("login");
//	}
//
//	@Bean
//	@Override
//	public UserDetailsService userDetailsService() {
//		UserDetails user = User.withDefaultPasswordEncoder().username("user").password("password").roles("USER")
//				.build();
//
//		return new InMemoryUserDetailsManager(user);
//	}
}
