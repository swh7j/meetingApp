package app.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Controller
public class IndexController {
    // 메인페이지 매핑[연결]
//    @GetMapping({"/", "/error"})
//    public String index() {
//        return "layout";
//    }


    @GetMapping("/error")
    public String error(){return "error";}

}
