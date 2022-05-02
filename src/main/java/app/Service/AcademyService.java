package app.Service;

import app.Entity.AcademyEntity;
import app.Repository.AcademyRepository;
import app.dto.AcademyDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Transactional
@Service
public class AcademyService {

    @Autowired
    private AcademyRepository academyRepository;

    @Transactional
    public ArrayList<AcademyDto> get() {
        
        System.out.println("get 메소드 실행1");
        List<AcademyEntity> academyEntityList = academyRepository.findAll();
        System.out.println("get 메소드 실행2!");
        ArrayList<AcademyDto> list = new ArrayList<>();
        System.out.println("get 메소드 실행3!");

        for(AcademyEntity temp : academyEntityList){

            AcademyDto academyDto = AcademyDto.builder()
                    .ID(temp.getID())
                    .ATPT_OFCDC_SC_CODE(temp.getATPT_OFCDC_SC_CODE())
                    .ATPT_OFCDC_SC_NM(temp.getATPT_OFCDC_SC_NM())
                    .ADMST_ZONE_NM(temp.getADMST_ZONE_NM())
                    .ACA_INSTI_SC_NM(temp.getACA_INSTI_SC_NM())
                    .ACA_ASNUM(temp.getACA_ASNUM())
                    .ACA_NM(temp.getACA_NM())
                    .ESTBL_YMD(temp.getESTBL_YMD())
                    .REG_YMD(temp.getREG_YMD())
                    .REG_STTUS_NM(temp.getREG_STTUS_NM())
                    .CAA_BEGIN_YMD(temp.getCAA_BEGIN_YMD())
                    .CAA_END_YMD(temp.getCAA_END_YMD())
                    .TOFOR_SMTOT(temp.getTOFOR_SMTOT())
                    .DTM_RCPTN_ABLTY_NMPR_SMTOT(temp.getDTM_RCPTN_ABLTY_NMPR_SMTOT())
                    .REALM_SC_NM(temp.getREALM_SC_NM())
                    .LE_ORD_NM(temp.getLE_ORD_NM())
                    .LE_CRSE_LIST_NM(temp.getLE_CRSE_LIST_NM())
                    .LE_CRSE_NM(temp.getLE_CRSE_NM())
                    .PSNBY_THCC_CNTNT(temp.getPSNBY_THCC_CNTNT())
                    .THCC_OTHBC_YN(temp.getTHCC_OTHBC_YN())
                    .BRHS_ACA_YN(temp.getBRHS_ACA_YN())
                    .FA_RDNZC(temp.getFA_RDNZC())
                    .FA_RDNMA(temp.getFA_RDNMA())
                    .FA_RDNDA(temp.getFA_RDNDA())
                    .LOAD_DTM(temp.getLOAD_DTM())
                    .build();
            list.add(academyDto);
            return list;
        }
        return null;
    }

}

