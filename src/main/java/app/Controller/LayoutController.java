package app.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class LayoutController {

    @GetMapping("/layout")
    public String layout() {
        return "layout";
    }

}
