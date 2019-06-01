package com.smartloan.smtrick.jagrutiapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Add_Updatelead__bankresult_Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText etname;
    private EditText etresaddress;
    private EditText etdocturcunsultant;

    private Spinner spinneroccu;
    private Spinner sexspinner;
    private Spinner spinnermaritalstatus;
    private Spinner spinneroccupation;
    private Spinner spinnereducation;
    private Spinner spinneraddress;
    private Spinner spinnerrefferral;

    private DatabaseReference mDatabaseRefpatient;

    private Button AddsubData;
    private Button AddmainData;
    private List<String> mainproductlist;
    private List<String> subproductlist;
    // MainProducts mainProducts;

    PatientVO invoice;
    LeedRepository leedRepository;

    private List<String> listmalefemale;
    private List<String> listmaritalstatus;
    private List<String> listoccupation;
    private List<String> listeducation;
    private List<String> listaddress;
    private List<String> listrefferal;
    // String mainproduct;

    private EditText etreligion, etses, etage, etdob, etrecidencial, etoffice, etdignosys, etdsmvcode, etreviseddignosis,
            etinformant, etodp, etgeneralexamination, etcns, etcvs, etpulse, etbp, etrs, etpa, etidentificationmark,
            etformulation, etmanagementplan, etinvestigation, etrefwithresons, etrehabitationneed, etpersnality, etsocialsupport,
            etpasthistory, etfamilyhistory, etdevchild, etoccupationalhistory, etpsmhistory, etapearanceandbehaviour,
            etspeechmoodeffects, etinsidejudmentmemory;

    private String Sreligion, Sses, Sage, Sdob,Saddress, Srecidential, Soffice, Sdignosys, Sdsmvcode, Sreviseddignosys,
            Sinformant, Sodp, Sgeneralexamination, Scns, Scvs, Spulse, Sbp, Srs, Spa, Sidentificationalmark,
            Sformulation, Smanagementplan, Sinvestigation, Srefwithresons, Srehabitetionneed, Spersnality, Ssocialsupport,
            Spasthistory, Sfamilyhistory, Sdevchild, Soccupationalhistory, Spsmhistory, Sapearenceandbehaviour,
            Sspeechmodeffects, Sinsidejudmentmemory;

    String Sgender, SmaritalStatus, Sprofation, Seducation, Surbanrural, Sreferal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_bankresult_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        Intent intent = getIntent();
        invoice = (PatientVO) intent.getSerializableExtra("invoice");
        leedRepository = new LeedRepositoryImpl();

        etname = (EditText) findViewById(R.id.name);
        etresaddress = (EditText) findViewById(R.id.residencial);
        etdocturcunsultant = (EditText) findViewById(R.id.Doctorcunsoltunt);
        etreligion = (EditText) findViewById(R.id.religion);
        etage = (EditText) findViewById(R.id.age);
        etses = (EditText) findViewById(R.id.ses);
        etdob = (EditText) findViewById(R.id.dob);
        etrecidencial = (EditText) findViewById(R.id.residencial);
        etoffice = (EditText) findViewById(R.id.office);
        etdignosys = (EditText) findViewById(R.id.diagnosis);
        etdsmvcode = (EditText) findViewById(R.id.dsmvcode);
        etreviseddignosis = (EditText) findViewById(R.id.reviseddignosis);
        etinformant = (EditText) findViewById(R.id.informant);
        etodp = (EditText) findViewById(R.id.odp);
        etgeneralexamination = (EditText) findViewById(R.id.generalexamination);
        etcns = (EditText) findViewById(R.id.cns);
        etcvs = (EditText) findViewById(R.id.cvs);
        etpulse = (EditText) findViewById(R.id.pulse);
        etbp = (EditText) findViewById(R.id.bp);
        etrs = (EditText) findViewById(R.id.rs);
        etpa = (EditText) findViewById(R.id.pa);
        etidentificationmark = (EditText) findViewById(R.id.imark);
        etformulation = (EditText) findViewById(R.id.formulation);
        etmanagementplan = (EditText) findViewById(R.id.managementplan);
        etinvestigation = (EditText) findViewById(R.id.investigations);
        etrefwithresons = (EditText) findViewById(R.id.refwithreasons);
        etrehabitationneed = (EditText) findViewById(R.id.rehabilationneeds);
        etpersnality = (EditText) findViewById(R.id.persnality);
        etsocialsupport = (EditText) findViewById(R.id.socialsupport);
        etpasthistory = (EditText) findViewById(R.id.pasthistory);
        etfamilyhistory = (EditText) findViewById(R.id.familyhistory);
        etdevchild = (EditText) findViewById(R.id.dhandchildad);
        etoccupationalhistory = (EditText) findViewById(R.id.occuhistory);
        etpsmhistory = (EditText) findViewById(R.id.personalhistory);
        etapearanceandbehaviour = (EditText) findViewById(R.id.apearanceandbehaviour);
        etspeechmoodeffects = (EditText) findViewById(R.id.speachmoodefect);
        etinsidejudmentmemory = (EditText) findViewById(R.id.insightjugecodition);

        // AddsubData = (Button)findViewById(R.id.submit);
        AddmainData = (Button) findViewById(R.id.submit);
        //spinneroccu = (Spinner)findViewById(R.id.occupation);

        sexspinner = (Spinner) findViewById(R.id.sexspinner);
        spinnermaritalstatus = (Spinner) findViewById(R.id.maritalstatus);
        spinneroccupation = (Spinner) findViewById(R.id.occupation);
        spinnereducation = (Spinner) findViewById(R.id.education);
        spinneraddress = (Spinner) findViewById(R.id.address);
        spinnerrefferral = (Spinner) findViewById(R.id.sourceofrefferal);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


        mainproductlist = new ArrayList<>();
        subproductlist = new ArrayList<>();


        listmalefemale = new ArrayList<>();
        listmalefemale.add("Male");
        listmalefemale.add("Female");
        /////

        listmaritalstatus = new ArrayList<>();
        listmaritalstatus.add("Single");
        listmaritalstatus.add("Married");
        listmaritalstatus.add("Widowed");
        listmaritalstatus.add("Separated");
        listmaritalstatus.add("Divorced");
        listmaritalstatus.add("Deserted");

        listoccupation = new ArrayList<>();
        listoccupation.add("Not Applicable");
        listoccupation.add("Not Occupied");
        listoccupation.add("Professional");
        listoccupation.add("Service");
        listoccupation.add("Business");
        listoccupation.add("H.W");
        listoccupation.add("Vendor");
        listoccupation.add("Farmer");
        listoccupation.add("Student");
        listoccupation.add("Unemployed");
        listoccupation.add("Retired");
        listoccupation.add("Disability");
        listoccupation.add("Pension");
        listoccupation.add("Housemaid");
        listoccupation.add("Bara");
        listoccupation.add("Baluteder");
        listoccupation.add("Others");

        listeducation = new ArrayList<>();
        listeducation.add("No Formal Education");
        listeducation.add("Primary");
        listeducation.add("Secondary");
        listeducation.add("S.S.C");
        listeducation.add("Collage");
        listeducation.add("Graduate");
        listeducation.add("P.G");
        listeducation.add("Professional");
        listeducation.add("Technical");
        listeducation.add("Others");

        listaddress = new ArrayList<>();
        listaddress.add("Urban");
        listaddress.add("Semi-Urban");
        listaddress.add("Rural");


        listrefferal = new ArrayList<>();
        listrefferal.add("Self");
        listrefferal.add("Family member");
        listrefferal.add("Friend");
        listrefferal.add("Neighbor");
        listrefferal.add("Villager");
        listrefferal.add("G.P.(Ailo)");
        listrefferal.add("G.P.(Ayur,Homeo)");
        listrefferal.add("Specialist");
        listrefferal.add("Psychiatrist");
        listrefferal.add("Employer");
        listrefferal.add("Institution");
        listrefferal.add("Court");
        listrefferal.add("Dept.");
        listrefferal.add("Other Hospital");
        listrefferal.add("Para Medicals");
        listrefferal.add("Other");

        try {

            ArrayAdapter<String> mainproadapter = new ArrayAdapter<String>(getBaseContext(),
                    android.R.layout.simple_spinner_item, listmalefemale);

            mainproadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            sexspinner.setAdapter(mainproadapter);

////

            ArrayAdapter<String> maritalstatus = new ArrayAdapter<String>(getBaseContext(),
                    android.R.layout.simple_spinner_item, listmaritalstatus);

            maritalstatus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnermaritalstatus.setAdapter(maritalstatus);

///

            ArrayAdapter<String> occupation = new ArrayAdapter<String>(getBaseContext(),
                    android.R.layout.simple_spinner_item, listoccupation);

            occupation.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinneroccupation.setAdapter(occupation);
//

            ArrayAdapter<String> education = new ArrayAdapter<String>(getBaseContext(),
                    android.R.layout.simple_spinner_item, listeducation);

            education.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnereducation.setAdapter(education);
//
            ArrayAdapter<String> address = new ArrayAdapter<String>(getBaseContext(),
                    android.R.layout.simple_spinner_item, listaddress);

            address.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinneraddress.setAdapter(address);
            //
            ArrayAdapter<String> refferal = new ArrayAdapter<String>(getBaseContext(),
                    android.R.layout.simple_spinner_item, listrefferal);

            refferal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerrefferral.setAdapter(refferal);

        } catch (Exception e) {
        }
        //AddmainData.setOnClickListener(this);
        getdata();
        AddmainData.setOnClickListener(this);
    }

    private void getdata() {

        try {


            String name = invoice.getPname();
            String cdoctor = invoice.getCdoctor();
            String address = invoice.getAddress();
            String setreligion = invoice.getReligion();
            String setses = invoice.getSes();
            String setage = invoice.getAge();
            String setdob = invoice.getDob();
            String setrecidencial = invoice.getResidencial();
            String setoffice = invoice.getOffice();
            String setdignosys = invoice.getDiagnosys();
            String setdsmvcode = invoice.getDsmvcode();
            String setreviseddignosis = invoice.getReviseddiagnosys();
            String setinformant = invoice.getInformant();
            String setodp = invoice.getOdp();
            String setgeneralexamination = invoice.getGexamination();
            String setcns = invoice.getCns();
            String setcvs = invoice.getCvs();
            String setpulse = invoice.getPulse();
            String setbp = invoice.getBp();
            String setrs = invoice.getRs();
            String setpa = invoice.getPa();
            String setidentificationmark = invoice.getImark();
            String setformulation = invoice.getFormulation();
            String setmanagementplan = invoice.getManagementplan();
            String setinvestigation = invoice.getInvestigation();
            String setrefwithresons = invoice.getRefralwithreasons();
            String setrehabitationneed = invoice.getRehabitationneed();
            String setpersnality = invoice.getPersnality();
            String setsocialsupport = invoice.getSocialsupport();
            String setpasthistory = invoice.getPasthistory();
            String setfamilyhistory = invoice.getFamilyhistory();
            String setdevchild = invoice.getDevhistoryandchildhood();
            String setoccupationalhistory = invoice.getOccupationalhistory();
            String setpsmhistory = invoice.getPsmhistory();
            String setapearanceandbehaviour = invoice.getAppearanceandbehaviour();
            String setspeechmoodeffects = invoice.getSpeechmoodeffect();
            String setinsidejudmentmemory = invoice.getInsightgudgementmemory();

            String gender = invoice.getGender();
            String maritalstatus = invoice.getMarrialstatus();
            String profession = invoice.getOccupation();
            String education = invoice.getEducation();
            String urbalrural = invoice.getHowcontact();
            String referal = invoice.getResidencial();

            if (gender != null) {
                ArrayAdapter myAdap = (ArrayAdapter) sexspinner.getAdapter();
                int spinnerPosition = myAdap.getPosition(gender);
                sexspinner.setSelection(spinnerPosition);
            }
            if (maritalstatus != null) {
                ArrayAdapter myAdap = (ArrayAdapter) spinnermaritalstatus.getAdapter();
                int spinnerPosition = myAdap.getPosition(maritalstatus);
                spinnermaritalstatus.setSelection(spinnerPosition);
            }
            if (profession != null) {
                ArrayAdapter myAdap = (ArrayAdapter) spinneroccupation.getAdapter();
                int spinnerPosition = myAdap.getPosition(profession);
                spinneroccupation.setSelection(spinnerPosition);
            }
            if (education != null) {
                ArrayAdapter myAdap = (ArrayAdapter) spinnereducation.getAdapter();
                int spinnerPosition = myAdap.getPosition(education);
                spinnereducation.setSelection(spinnerPosition);
            }
            if (urbalrural != null) {
                ArrayAdapter myAdap = (ArrayAdapter) spinneraddress.getAdapter();
                int spinnerPosition = myAdap.getPosition(urbalrural);
                spinneraddress.setSelection(spinnerPosition);
            }
            if (referal != null) {
                ArrayAdapter myAdap = (ArrayAdapter) spinnerrefferral.getAdapter();
                int spinnerPosition = myAdap.getPosition(referal);
                spinnerrefferral.setSelection(spinnerPosition);
            }


            if (name != null) {
                etname.setText(name);
            }

            if (invoice.getCreatedDateTimeLong() != null) {
                // .setText(Utility.convertMilliSecondsToFormatedDate(invoice.getCreatedDateTimeLong(), GLOBAL_DATE_FORMATE));

            }
            if (cdoctor != null) {
                etdocturcunsultant.setText(cdoctor);

            }
            if (address != null) {
                etresaddress.setText(address);
            }

            if (setreligion != null) {
                etreligion.setText(setreligion);

            }
            if (setses != null) {
                etses.setText(setses);
            }
            if (setage != null) {
                etage.setText(setage);
            }
            if (setdob != null) {
                etdob.setText(setdob);
            }
            if (setrecidencial != null) {
                etrecidencial.setText(setrecidencial);
            }
            if (setoffice != null) {
                etoffice.setText(setoffice);
            }
            if (setdignosys != null) {
                etdignosys.setText(setdignosys);
            }
            if (setdsmvcode != null) {
                etdsmvcode.setText(setdsmvcode);
            }
            if (setreviseddignosis != null) {
                etreviseddignosis.setText(setreviseddignosis);
            }
            if (setinformant != null) {
                etinformant.setText(setinformant);
            }


            if (setodp != null) {
                etodp.setText(setodp);
            }
            if (setgeneralexamination != null) {
                etgeneralexamination.setText(setgeneralexamination);
            }
            if (setcns != null) {
                etcns.setText(setcns);
            }
            if (setcvs != null) {
                etcvs.setText(setcvs);
            }
            if (setpulse != null) {
                etpulse.setText(setpulse);
            }
            if (setbp != null) {
                etbp.setText(setbp);
            }
            if (setrs != null) {
                etrs.setText(setrs);
            }
            if (setpa != null) {
                etpa.setText(setpa);
            }

            if (setidentificationmark != null) {
                etidentificationmark.setText(setidentificationmark);
            }
            if (setformulation != null) {
                etformulation.setText(setformulation);
            }
            if (setmanagementplan != null) {
                etmanagementplan.setText(setmanagementplan);
            }
            if (setinvestigation != null) {
                etinvestigation.setText(setinvestigation);
            }

            if (setrefwithresons != null) {
                etrefwithresons.setText(setrefwithresons);
            }
            if (setrehabitationneed != null) {
                etrehabitationneed.setText(setrehabitationneed);
            }
            if (setpersnality != null) {
                etpersnality.setText(setpersnality);
            }
            if (setsocialsupport != null) {
                etsocialsupport.setText(setsocialsupport);
            }

            if (setpasthistory != null) {
                etpasthistory.setText(setpasthistory);
            }

            if (setfamilyhistory != null) {
                etfamilyhistory.setText(setfamilyhistory);
            }
            if (setdevchild != null) {
                etdevchild.setText(setdevchild);
            }
            if (setoccupationalhistory != null) {
                etoccupationalhistory.setText(setoccupationalhistory);
            }
            if (setpsmhistory != null) {
                etpsmhistory.setText(setpsmhistory);
            }

            if (setapearanceandbehaviour != null) {
                etapearanceandbehaviour.setText(setapearanceandbehaviour);
            }
            if (setspeechmoodeffects != null) {
                etspeechmoodeffects.setText(setspeechmoodeffects);
            }
            if (setinsidejudmentmemory != null) {
                etinsidejudmentmemory.setText(setinsidejudmentmemory);
            }


        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public void onClick(View v) {
        if (v == AddmainData) {
            SetData();
        }
    }

    private void SetData() {

        Sreligion = etreligion.getText().toString();
        Sses = etses.getText().toString();
        Sage = etage.getText().toString();
        Sdob = etdob.getText().toString();
        Saddress = etrecidencial.getText().toString();
        Srecidential = spinneraddress.getSelectedItem().toString();
        Soffice = etoffice.getText().toString();
        Sdignosys = etdignosys.getText().toString();
        Sdsmvcode = etdsmvcode.getText().toString();
        Sreviseddignosys = etreviseddignosis.getText().toString();
        Sinformant = etinformant.getText().toString();
        Sodp = etodp.getText().toString();
        Sgeneralexamination = etgeneralexamination.getText().toString();
        Scns = etcns.getText().toString();
        Scvs = etcvs.getText().toString();
        Spulse = etpulse.getText().toString();
        Sbp = etbp.getText().toString();
        Srs = etrs.getText().toString();
        Spa = etpa.getText().toString();
        Sidentificationalmark = etidentificationmark.getText().toString();
        Sformulation = etformulation.getText().toString();
        Smanagementplan = etmanagementplan.getText().toString();
        Sinvestigation = etinvestigation.getText().toString();
        Srefwithresons = etrefwithresons.getText().toString();
        Srehabitetionneed = etrehabitationneed.getText().toString();
        Spersnality = etpersnality.getText().toString();
        Ssocialsupport = etsocialsupport.getText().toString();
        Spasthistory = etpasthistory.getText().toString();
        Sfamilyhistory = etfamilyhistory.getText().toString();
        Sdevchild = etdevchild.getText().toString();
        Soccupationalhistory = etoccupationalhistory.getText().toString();
        Spsmhistory = etpsmhistory.getText().toString();
        Sapearenceandbehaviour = etapearanceandbehaviour.getText().toString();
        Sspeechmodeffects = etspeechmoodeffects.getText().toString();
        Sinsidejudmentmemory = etinsidejudmentmemory.getText().toString();

        Sgender = sexspinner.getSelectedItem().toString();
        SmaritalStatus = spinnermaritalstatus.getSelectedItem().toString();
        Sprofation = spinneroccupation.getSelectedItem().toString();
        Seducation = spinnereducation.getSelectedItem().toString();
        Surbanrural = spinneraddress.getSelectedItem().toString();
        Sreferal = spinnerrefferral.getSelectedItem().toString();

        updateData();

    }

    private void updateData() {

        invoice.setReligion(Sreligion);
        invoice.setSes(Sses);
        invoice.setAge(Sage);
        invoice.setDob(Sdob);
        invoice.setAddress(Saddress);
        invoice.setOffice(Soffice);
        invoice.setDiagnosys(Sdignosys);
        invoice.setDsmvcode(Sdsmvcode);
        invoice.setReviseddiagnosys(Sreviseddignosys);
        invoice.setInformant(Sinformant);
        invoice.setOdp(Sodp);
        invoice.setGexamination(Sgeneralexamination);
        invoice.setCns(Scns);
        invoice.setCvs(Scvs);
        invoice.setPulse(Spulse);
        invoice.setBp(Sbp);
        invoice.setRs(Srs);
        invoice.setPa(Spa);
        invoice.setImark(Sidentificationalmark);
        invoice.setFormulation(Sformulation);
        invoice.setManagementplan(Smanagementplan);
        invoice.setInvestigation(Sinvestigation);
        invoice.setRefralwithreasons(Srefwithresons);
        invoice.setRehabitationneed(Srehabitetionneed);
        invoice.setPersnality(Spersnality);
        invoice.setSocialsupport(Ssocialsupport);
        invoice.setPasthistory(Spasthistory);
        invoice.setFamilyhistory(Sfamilyhistory);
        invoice.setDevhistoryandchildhood(Sdevchild);
        invoice.setOccupationalhistory(Soccupationalhistory);
        invoice.setPsmhistory(Spsmhistory);
        invoice.setAppearanceandbehaviour(Sapearenceandbehaviour);
        invoice.setSpeechmoodeffect(Sspeechmodeffects);
        invoice.setInsightgudgementmemory(Sinsidejudmentmemory);
        invoice.setGender(Sgender);
        invoice.setMarrialstatus(SmaritalStatus);
        invoice.setOccupation(Sprofation);
        invoice.setEducation(Seducation);
        invoice.setResidencial(Srecidential);
        invoice.setHowcontact(Srecidential);



        updateLeed(invoice.getLeedId(), invoice.getLeedStatusMap());
    }


    private void updateLeed(String leedId, Map leedsMap) {

        leedRepository.updateLeed(leedId, leedsMap, new CallBack() {
            @Override
            public void onSuccess(Object object) {

            }

            @Override
            public void onError(Object object) {

            }
        });
    }
}