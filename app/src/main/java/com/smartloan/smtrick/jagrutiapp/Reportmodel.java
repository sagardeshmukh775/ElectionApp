package com.smartloan.smtrick.jagrutiapp;

import com.google.firebase.database.ServerValue;

import java.util.ArrayList;
import java.util.Map;

public class Reportmodel {

    public String pname,cdoctor,address,religion,ses,age,dob,gender,marrialstatus,occupation,education,ruralarban,residencial,
            office,howcontact,diagnosys,dsmvcode,reviseddiagnosys,informant,odp,gexamination,cns,cvs,
            pulse,bp,rs,pa,imark,formulation,managementplan,investigation,refralwithreasons,rehabitationneed,persnality,
            socialsupport,pasthistory,familyhistory,devhistoryandchildhood,occupationalhistory,appearanceandbehaviour,
            speechmoodeffect,insightgudgementmemory;
    public Long createdDateTime;

    public Reportmodel() {

    }

    public Reportmodel(int id) {}

    public Reportmodel(String pname, String cdoctor, String address) {





        this.pname = pname;
        this.cdoctor = cdoctor;
        this.address = address;
        this.createdDateTime = createdDateTime;
        this.religion = religion;
        this.ses = ses;
        this.age = age;
        this.dob = dob;
        this.gender = gender;
        this.marrialstatus = marrialstatus;
        this.occupation = occupation;
        this.education = education;
        this.ruralarban = ruralarban;
        this.residencial = residencial;
        this.office = office;
        this.howcontact = howcontact;
        this.rs = rs;
        this.pa = pa;
        this.odp = odp;
        this.gexamination = gexamination;
        this.cns = cns;
        this.cvs = cvs;
        this.diagnosys = diagnosys;
        this.dsmvcode = dsmvcode;
        this.reviseddiagnosys = reviseddiagnosys;
        this.informant = informant;
        this.appearanceandbehaviour = appearanceandbehaviour;
        this.speechmoodeffect = speechmoodeffect;
        this.insightgudgementmemory = insightgudgementmemory;
        this.pasthistory = pasthistory;
        this.familyhistory = familyhistory;
        this.devhistoryandchildhood = devhistoryandchildhood;
        this.occupationalhistory = occupationalhistory;
        this.refralwithreasons = refralwithreasons;
        this.rehabitationneed = rehabitationneed;
        this.persnality = persnality;
        this.socialsupport = socialsupport;
        this.pulse = pulse;
        this.bp = bp; }



    public String getAppearanceandbehaviour() {
        return appearanceandbehaviour;
    }

    public void setAppearanceandbehaviour(String appearanceandbehaviour) {
        this.appearanceandbehaviour = appearanceandbehaviour;
    }

    public String getSpeechmoodeffect() {
        return speechmoodeffect;
    }

    public void setSpeechmoodeffect(String speechmoodeffect) {
        this.speechmoodeffect = speechmoodeffect;
    }

    public String getInsightgudgementmemory() {
        return insightgudgementmemory;
    }

    public void setInsightgudgementmemory(String insightgudgementmemory) {
        this.insightgudgementmemory = insightgudgementmemory;
    }


    public String getPasthistory() {
        return pasthistory;
    }

    public void setPasthistory(String pasthistory) {
        this.pasthistory = pasthistory;
    }


    public String getFamilyhistory() {
        return familyhistory;
    }

    public void setFamilyhistory(String familyhistory) {
        this.familyhistory = familyhistory;
    }

    public String getDevhistoryandchildhood() {
        return devhistoryandchildhood;
    }

    public void setDevhistoryandchildhood(String devhistoryandchildhood) {
        this.devhistoryandchildhood = devhistoryandchildhood;
    }


    public String getOccupationalhistory() {
        return occupationalhistory;
    }

    public void setOccupationalhistory(String occupationalhistory) {
        this.occupationalhistory = occupationalhistory;
    }

    public String getRefralwithreasons() {
        return refralwithreasons;
    }

    public void setRefralwithreasons(String refralwithreasons) {
        this.refralwithreasons = refralwithreasons;
    }
    public String getRehabitationneed() {
        return rehabitationneed;
    }

    public void setRehabitationneed(String rehabitationneed) {
        this.rehabitationneed = rehabitationneed;
    }

    public String getPersnality() {
        return persnality;
    }

    public void setPersnality(String persnality) {
        this.persnality = persnality;
    }


    public String getSocialsupport() {
        return socialsupport;
    }

    public void setSocialsupport(String socialsupport) {
        this.socialsupport = socialsupport;
    }

    public String getPulse() {
        return pulse;
    }

    public void setPulse(String pulse) {
        this.pulse = pulse;
    }
    public String getBp() {
        return bp;
    }

    public void setBp(String bp) {
        this.bp = bp;
    }

    public String getRs() {
        return rs;
    }

    public void setRs(String rs) {
        this.rs = rs;
    }

    public String getPa() {
        return pa;
    }

    public void setPa(String pa) {
        this.pa = pa;
    }


    public String getOdp() {
        return odp;
    }

    public void setOdp(String odp) {
        this.odp = odp;
    }
    public String getGexamination() {
        return gexamination;
    }

    public void setGexamination(String gexamination) {
        this.gexamination = gexamination;
    }

    public String getCns() {
        return cns;
    }

    public void setCns(String cns) {
        this.cns = cns;
    }

    public String getCvs() {
        return cvs;
    }

    public void setCvs(String cvs) {
        this.cvs = cvs;
    }

    public String getDiagnosys() {
        return diagnosys;
    }

    public void setDiagnosys(String diagnosys) {
        this.diagnosys = diagnosys;
    }

    public String getDsmvcode() {
        return dsmvcode;
    }

    public void setDsmvcode(String dsmvcode) {
        this.dsmvcode = dsmvcode;
    }


    public String getReviseddiagnosys() {
        return reviseddiagnosys;
    }

    public void setReviseddiagnosys(String reviseddiagnosys) {
        this.reviseddiagnosys = reviseddiagnosys;
    }

    public String getInformant() {
        return informant;
    }

    public void setInformant(String informant) {
        this.informant = informant;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getSes() {
        return ses;
    }

    public void setSes(String ses) {
        this.ses = ses;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getMarrialstatus() {
        return marrialstatus;
    }

    public void setMarrialstatus(String marrialstatus) {
        this.marrialstatus = marrialstatus;
    }



    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
}


    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }



    public String getRuralarban() {
        return ruralarban;
    }

    public void setRuralarban(String ruralarban) {
        this.ruralarban = ruralarban;
    }

    public String getResidencial() {
        return residencial;
    }

    public void setResidencial(String residencial) {
        this.residencial = residencial;
    }
    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getHowcontact() {
        return howcontact;
    }

    public void setHowcontact(String howcontact) {
        this.howcontact = howcontact;
    }

    public Long getCreatedDateTimeLong() {
        return createdDateTime;
    }

    public Map<String, String> getCreatedDateTime() {
        return ServerValue.TIMESTAMP;
    }

    public void setCreatedDateTime(Long createdDateTime) {
        this.createdDateTime = (Long) createdDateTime;
    }
    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getCdoctor() {
        return cdoctor;
    }

    public void setCdoctor(String cdoctor) {
        this.cdoctor = cdoctor;
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }












    public static ArrayList<Reportmodel> getLeeds() {
        ArrayList<Reportmodel> leedsModelArrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Reportmodel reportmodel = new Reportmodel(i);
            leedsModelArrayList.add(reportmodel);
        }
        return leedsModelArrayList;
    }
}



