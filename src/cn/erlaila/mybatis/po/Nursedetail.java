package cn.erlaila.mybatis.po;

public class Nursedetail {
    private Integer nursedetailid;

    private Integer userid;

    private String nurserealname;

    private String idcardno;

    private String adress;

    private String adressdetail;

    private String height;

    private String weight;

    private String blood;

    private String nation;

    private String marriage;

    private String education;

    private String begoodat;

    private String experience;

    private String synopsis;
    
 

    public Integer getNursedetailid() {
        return nursedetailid;
    }

    public void setNursedetailid(Integer nursedetailid) {
        this.nursedetailid = nursedetailid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getNurserealname() {
        return nurserealname;
    }

    public void setNurserealname(String nurserealname) {
        this.nurserealname = nurserealname == null ? null : nurserealname.trim();
    }

    public String getIdcardno() {
        return idcardno;
    }

    public void setIdcardno(String idcardno) {
        this.idcardno = idcardno == null ? null : idcardno.trim();
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress == null ? null : adress.trim();
    }

    public String getAdressdetail() {
        return adressdetail;
    }

    public void setAdressdetail(String adressdetail) {
        this.adressdetail = adressdetail == null ? null : adressdetail.trim();
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height == null ? null : height.trim();
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight == null ? null : weight.trim();
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood == null ? null : blood.trim();
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage == null ? null : marriage.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getBegoodat() {
        return begoodat;
    }

    public void setBegoodat(String begoodat) {
        this.begoodat = begoodat == null ? null : begoodat.trim();
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience == null ? null : experience.trim();
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis == null ? null : synopsis.trim();
    }
}