package com.smartloan.smtrick.jagrutiapp;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.ServerValue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PatientVO implements Serializable {

    public String pname,cdoctor,address,religion,ses,age,dob,gender,marrialstatus,occupation,education,ruralarban,residencial,
            office,howcontact,diagnosys,dsmvcode,reviseddiagnosys,informant,odp,gexamination,cns,cvs,
            pulse,bp,rs,pa,imark,formulation,managementplan,investigation,refralwithreasons,rehabitationneed,persnality,
            socialsupport,pasthistory,familyhistory,devhistoryandchildhood,occupationalhistory,psmhistory,appearanceandbehaviour,
            speechmoodeffect,insightgudgementmemory,patientId,leedId;
    public Long createdDateTime;

    public PatientVO() {

    }

    public PatientVO(int id) {}

    public PatientVO(String pname, String cdoctor, String address, String setreligion, String setses,String setage,String setdob,
                     String setrecidencial,String setoffice, String setdignosys, String setdsmvcode, String setreviseddignosis,
                     String setinformant,String setodp,String setgeneralexamination,String setcns,String setcvs,String setpulse,
                     String setbp,String setrs,String setpa,String setidentificationmark,String setformulation,String setmanagementplan,
                     String setinvestigation,String setrefwithresons,String setrehabitationneed,String setpersnality,
                     String setsocialsupport,String setpasthistory,String setfamilyhistory,String setdevchild,
                     String setoccupationalhistory,String setpsmhistory,String setapearanceandbehaviour,String setspeechmoodeffects,
                     String setinsidejudmentmemory,String patientId,String leedId,String gender,String marrialstatus,String occupation,
                     String education,String howcontact,String referel) {

        this.pname = pname;
        this.cdoctor = cdoctor;
        this.address = address;
        this.createdDateTime = createdDateTime;
        this.religion = setreligion;
        this.ses = setses;
        this.age = setage;
        this.dob = setdob;
        this.gender = gender;
        this.marrialstatus = marrialstatus;
        this.occupation = occupation;
        this.education = education;
        this.ruralarban = setrecidencial;
        this.residencial = referel;
        this.office = setoffice;
        this.howcontact = howcontact;
        this.rs = setrs;
        this.pa = setpa;
        this.odp = setodp;
        this.gexamination = setgeneralexamination;
        this.cns = setcns;
        this.cvs = setcvs;
        this.diagnosys = setdignosys;
        this.dsmvcode = setdsmvcode;
        this.reviseddiagnosys = setreviseddignosis;
        this.informant = setinformant;
        this.appearanceandbehaviour = setapearanceandbehaviour;
        this.speechmoodeffect = setspeechmoodeffects;
        this.insightgudgementmemory = setinsidejudmentmemory;
        this.pasthistory = setpasthistory;
        this.familyhistory = setfamilyhistory;
        this.devhistoryandchildhood = setdevchild;
        this.occupationalhistory = setoccupationalhistory;
        this.refralwithreasons = setrefwithresons;
        this.rehabitationneed = setrehabitationneed;
        this.persnality = setpersnality;
        this.socialsupport = setsocialsupport;
        this.pulse = setpulse;
        this.bp = setbp;
        this.patientId = patientId;
        this.leedId = leedId;

        this.imark = setidentificationmark;
        this.formulation = setformulation;
        this.managementplan = setmanagementplan;
        this.investigation = setinvestigation;
        this.psmhistory = setpsmhistory;



    }



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

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getLeedId() {
        return leedId;
    }

    public void setLeedId(String leedId) {
        this.leedId = leedId;
    }

    public String getImark() {
        return imark;
    }

    public void setImark(String imark) {
        this.imark = imark;
    }

    public String getFormulation() {
        return formulation;
    }

    public void setFormulation(String formulation) {
        this.formulation = formulation;
    }

    public String getManagementplan() {
        return managementplan;
    }

    public void setManagementplan(String managementplan) {
        this.managementplan = managementplan;
    }

    public String getInvestigation() {
        return investigation;
    }

    public void setInvestigation(String investigation) {
        this.investigation = investigation;
    }

    public String getPsmhistory() {
        return psmhistory;
    }

    public void setPsmhistory(String psmhistory) {
        this.psmhistory = psmhistory;
    }

    public static ArrayList<Reportmodel> getLeeds() {
        ArrayList<Reportmodel> leedsModelArrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Reportmodel reportmodel = new Reportmodel(i);
            leedsModelArrayList.add(reportmodel);
        }
        return leedsModelArrayList;
    }

    @Exclude
    public Map getLeedStatusMap() {
        Map<String, Object> leedMap = new HashMap();

        leedMap.put("pname", getPname());
        leedMap.put("cdoctor", getCdoctor());
        leedMap.put("address", getAddress());
        leedMap.put("createdDateTime", getCreatedDateTime());
        leedMap.put("religion", getReligion());
        leedMap.put("ses", getSes());
        leedMap.put("age", getAge());
        leedMap.put("dob", getDob());
        leedMap.put("gender", getGender());
        leedMap.put("marrialstatus", getMarrialstatus());
        leedMap.put("occupation", getOccupation());
        leedMap.put("education", getEducation());
        leedMap.put("ruralarban", getRuralarban());
        leedMap.put("residencial", getResidencial());
        leedMap.put("office", getOffice());
        leedMap.put("howcontact", getHowcontact());
        leedMap.put("rs", getRs());
        leedMap.put("pa", getPa());
        leedMap.put("odp", getOdp());
        leedMap.put("gexamination", getGexamination());
        leedMap.put("cns", getCns());
        leedMap.put("cvs", getCvs());
        leedMap.put("diagnosys", getDiagnosys());
        leedMap.put("dsmvcode", getDsmvcode());
        leedMap.put("reviseddiagnosys", getReviseddiagnosys());
        leedMap.put("informant", getInformant());
        leedMap.put("appearanceandbehaviour", getAppearanceandbehaviour());
        leedMap.put("speechmoodeffect", getSpeechmoodeffect());
        leedMap.put("insightgudgementmemory", getInsightgudgementmemory());
        leedMap.put("pasthistory", getPasthistory());
        leedMap.put("familyhistory", getFamilyhistory());
        leedMap.put("devhistoryandchildhood", getDevhistoryandchildhood());
        leedMap.put("occupationalhistory", getOccupationalhistory());
        leedMap.put("refralwithreasons", getRefralwithreasons());
        leedMap.put("rehabitationneed", getRehabitationneed());
        leedMap.put("persnality", getPersnality());
        leedMap.put("socialsupport", getSocialsupport());
        leedMap.put("pulse", getPulse());
        leedMap.put("bp", getBp());
        leedMap.put("PatientId", getPatientId());
        leedMap.put("leedId", getLeedId());

        return leedMap;

    }

}


