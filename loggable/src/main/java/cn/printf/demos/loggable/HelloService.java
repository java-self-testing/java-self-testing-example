package cn.printf.demos.loggable;


import com.github.rozidan.springboot.logger.Loggable;
import org.springframework.stereotype.Service;

@Service
@Loggable
public class HelloService {
    @Loggable
    public String hello(String name) {
        if(null == name){
            return null;
        }

        return "Hello " + name;
    }
}
