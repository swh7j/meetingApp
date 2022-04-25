package app.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    // 메인페이지 매핑[연결]
    @GetMapping("/") // url 지정
    public String main(){
        return "test";
    }

}
