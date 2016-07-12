package in.mahendrabagul.products.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan("in.mahendrabagul.products")
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter
{

}