package app.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class IndexController {
    // 메인페이지 매핑[연결]
    @GetMapping("/main") // url 지정
    public List<String> main(){
        return Arrays.asList();
    }

    @GetMapping("/error")
    public String error(){return "error";}


}
