package app.Service.Academy;

import app.Domain.Entity.Academy.AcademyEntity;
import app.Domain.Entity.Academy.AcademyRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Transactional
@Service
public class AcademyService {

    @Autowired
    private AcademyRepository academyRepository;

    @Transactional
    public List<AcademyEntity> get() {

        System.out.println("get 메소드 실행1");
        List<AcademyEntity> academyEntityList = academyRepository.findAll();

        return academyEntityList;
    }

}