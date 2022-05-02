package app.Controller;


import app.Service.AcademyService;
import app.dto.AcademyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/academy")
public class AcademyController {
    @Autowired
    private AcademyService academyService;

    @GetMapping("/list")
    public String list(Model model) {
        System.out.println("맵핑 실행");
        List<AcademyDto> academy = academyService.get();
        System.out.println("모델 불러오기");
        model.addAttribute("academyList", academy);

        return "/academy/list";
    }


}
