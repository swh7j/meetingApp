package app.Entity;


import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity(name = "academy")
@Table(name = "academy")
public class AcademyEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long ID;

    @Column
    private String ATPT_OFCDC_SC_CODE;
    @Column
    private String ATPT_OFCDC_SC_NM;
    @Column
    private String ADMST_ZONE_NM;
    @Column
    private String ACA_INSTI_SC_NM;
    @Column
    private Long ACA_ASNUM;
    @Column
    private String ACA_NM;
    @Column
    private int ESTBL_YMD;
    @Column
    private int REG_YMD;
    @Column
    private String REG_STTUS_NM;
    @Column
    private String CAA_BEGIN_YMD;
    @Column
    private String CAA_END_YMD;
    @Column
    private int TOFOR_SMTOT;
    @Column
    private int DTM_RCPTN_ABLTY_NMPR_SMTOT;
    @Column
    private String REALM_SC_NM;
    @Column
    private String LE_ORD_NM;
    @Column
    private String LE_CRSE_LIST_NM;
    @Column
    private String LE_CRSE_NM;
    @Column
    private String PSNBY_THCC_CNTNT;
    @Column
    private String THCC_OTHBC_YN;
    @Column
    private String BRHS_ACA_YN;
    @Column
    private int FA_RDNZC;
    @Column
    private String FA_RDNMA;
    @Column
    private String FA_RDNDA;
    @Column
    private int LOAD_DTM;

    @Builder
    public AcademyEntity(Long ID, String ATPT_OFCDC_SC_CODE, String ATPT_OFCDC_SC_NM, String ADMST_ZONE_NM, String ACA_INSTI_SC_NM, Long ACA_ASNUM, String ACA_NM, int ESTBL_YMD, int REG_YMD, String REG_STTUS_NM, String CAA_BEGIN_YMD, String CAA_END_YMD, int TOFOR_SMTOT, int DTM_RCPTN_ABLTY_NMPR_SMTOT, String REALM_SC_NM, String LE_ORD_NM, String LE_CRSE_LIST_NM, String LE_CRSE_NM, String PSNBY_THCC_CNTNT, String THCC_OTHBC_YN, String BRHS_ACA_YN, int FA_RDNZC, String FA_RDNMA, String FA_RDNDA, int LOAD_DTM) {
        this.ID = ID;
        this.ATPT_OFCDC_SC_CODE = ATPT_OFCDC_SC_CODE;
        this.ATPT_OFCDC_SC_NM = ATPT_OFCDC_SC_NM;
        this.ADMST_ZONE_NM = ADMST_ZONE_NM;
        this.ACA_INSTI_SC_NM = ACA_INSTI_SC_NM;
        this.ACA_ASNUM = ACA_ASNUM;
        this.ACA_NM = ACA_NM;
        this.ESTBL_YMD = ESTBL_YMD;
        this.REG_YMD = REG_YMD;
        this.REG_STTUS_NM = REG_STTUS_NM;
        this.CAA_BEGIN_YMD = CAA_BEGIN_YMD;
        this.CAA_END_YMD = CAA_END_YMD;
        this.TOFOR_SMTOT = TOFOR_SMTOT;
        this.DTM_RCPTN_ABLTY_NMPR_SMTOT = DTM_RCPTN_ABLTY_NMPR_SMTOT;
        this.REALM_SC_NM = REALM_SC_NM;
        this.LE_ORD_NM = LE_ORD_NM;
        this.LE_CRSE_LIST_NM = LE_CRSE_LIST_NM;
        this.LE_CRSE_NM = LE_CRSE_NM;
        this.PSNBY_THCC_CNTNT = PSNBY_THCC_CNTNT;
        this.THCC_OTHBC_YN = THCC_OTHBC_YN;
        this.BRHS_ACA_YN = BRHS_ACA_YN;
        this.FA_RDNZC = FA_RDNZC;
        this.FA_RDNMA = FA_RDNMA;
        this.FA_RDNDA = FA_RDNDA;
        this.LOAD_DTM = LOAD_DTM;
    }
}
