package app.Controller.Academy;

import app.Domain.Entity.Academy.AcademyEntity;
import app.Service.Academy.AcademyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class AcademyController {

    @Autowired
    private AcademyService academyService;

    // get all board
    @GetMapping("/list")
    public List<AcademyEntity> academy_list() {
        List<AcademyEntity> list = academyService.get();
        return list;
    }

}