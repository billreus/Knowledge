package Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import basic.ProductService;

public class TestSpringAOP {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
        ProductService s =(ProductService) context.getBean("s");
        s.dosomeService();
    }
}
