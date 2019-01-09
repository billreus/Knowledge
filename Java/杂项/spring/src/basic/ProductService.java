package basic;

import org.springframework.stereotype.Component;

@Component("s") //注解类
public class ProductService {

    public void dosomeService(){
        System.out.println("dosomeService");
    }
}
