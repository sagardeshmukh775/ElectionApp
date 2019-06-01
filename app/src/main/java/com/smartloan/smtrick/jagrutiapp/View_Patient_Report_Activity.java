package com.smartloan.smtrick.jagrutiapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import static com.smartloan.smtrick.jagrutiapp.Constants.GLOBAL_DATE_FORMATE;


public class View_Patient_Report_Activity extends AppCompatActivity implements View.OnClickListener {

    private TextView etname;
    private TextView etresaddress;
//    private EditText etdocturcunsultant;

    private TextView spinneroccu;
    private TextView sexspinner;
    private TextView spinnermaritalstatus;
    private TextView spinneroccupation;
    private TextView spinnereducation;
    private TextView spinneraddress;
    private TextView spinnerrefferral;

    private DatabaseReference mDatabaseRefpatient;

    private Button AddsubData;
    private Button AddmainData;
    private List<String> mainproductlist;
    private List<String> subproductlist;
    // MainProducts mainProducts;

    Reportmodel invoice;
    LeedRepository leedRepository;

    private List<String> listmalefemale;
    private List<String> listmaritalstatus;
    private List<String> listoccupation;
    private List<String> listeducation;
    private List<String> listaddress;
    private List<String> listrefferal;
    // String mainproduct;

    private TextView etreligion, etses, etage, etdob, etrecidencial, etoffice, etdignosys, etdsmvcode, etreviseddignosis,
            etinformant, etodp, etgeneralexamination, etcns, etcvs, etpulse, etbp, etrs, etpa, etidentificationmark,
            etformulation, etmanagementplan, etinvestigation, etrefwithresons, etrehabitationneed, etpersnality, etsocialsupport,
            etpasthistory, etfamilyhistory, etdevchild, etoccupationalhistory, etpsmhistory, etapearanceandbehaviour,
            etspeechmoodeffects, etinsidejudmentmemory;

    private String Sreligion, Sses, Sage, Sdob, Srecidential, Soffice, Sdignosys, Sdsmvcode, Sreviseddignosys,
            Sinformant, Sodp, Sgeneralexamination, Scns, Scvs, Spulse, Sbp, Srs, Spa, Sidentificationalmark,
            Sformulation, Smanagementplan, Sinvestigation, Srefwithresons, Srehabitetionneed, Spersnality, Ssocialsupport,
            Spasthistory, Sfamilyhistory, Sdevchild, Soccupationalhistory, Spsmhistory, Sapearenceandbehaviour,
            Sspeechmodeffects, Sinsidejudmentmemory;

    private TextView etdocturcunsultant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_patient_report_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        Intent intent = getIntent();
        invoice = (Reportmodel) intent.getSerializableExtra("report");
        leedRepository = new LeedRepositoryImpl();

        etname = (TextView) findViewById(R.id.name);
        etresaddress = (TextView) findViewById(R.id.residencial);
        etdocturcunsultant = (TextView) findViewById(R.id.Doctorcunsoltunt);
        etreligion = (TextView) findViewById(R.id.religion);
        etage = (TextView) findViewById(R.id.age);
        etses = (TextView) findViewById(R.id.ses);
        etdob = (TextView) findViewById(R.id.dob);
        etrecidencial = (TextView) findViewById(R.id.residencial);
        etoffice = (TextView) findViewById(R.id.office);
        etdignosys = (TextView) findViewById(R.id.diagnosis);
        etdsmvcode = (TextView) findViewById(R.id.dsmvcode);
        etreviseddignosis = (TextView) findViewById(R.id.reviseddignosis);
        etinformant = (TextView) findViewById(R.id.informant);
        etodp = (TextView) findViewById(R.id.odp);
        etgeneralexamination = (TextView) findViewById(R.id.generalexamination);
        etcns = (TextView) findViewById(R.id.cns);
        etcvs = (TextView) findViewById(R.id.cvs);
        etpulse = (TextView) findViewById(R.id.pulse);
        etbp = (TextView) findViewById(R.id.bp);
        etrs = (TextView) findViewById(R.id.rs);
        etpa = (TextView) findViewById(R.id.pa);
        etidentificationmark = (TextView) findViewById(R.id.imark);
        etformulation = (TextView) findViewById(R.id.formulation);
        etmanagementplan = (TextView) findViewById(R.id.managementplan);
        etinvestigation = (TextView) findViewById(R.id.investigations);
        etrefwithresons = (TextView) findViewById(R.id.refwithreasons);
        etrehabitationneed = (TextView) findViewById(R.id.rehabilationneeds);
        etpersnality = (TextView) findViewById(R.id.persnality);
        etsocialsupport = (TextView) findViewById(R.id.socialsupport);
        etpasthistory = (TextView) findViewById(R.id.pasthistory);
        etfamilyhistory = (TextView) findViewById(R.id.familyhistory);
        etdevchild = (TextView) findViewById(R.id.dhandchildad);
        etoccupationalhistory = (TextView) findViewById(R.id.occuhistory);
        etpsmhistory = (TextView) findViewById(R.id.personalhistory);
        etapearanceandbehaviour = (TextView) findViewById(R.id.apearanceandbehaviour);
        etspeechmoodeffects = (TextView) findViewById(R.id.speachmoodefect);
        etinsidejudmentmemory = (TextView) findViewById(R.id.insightjugecodition);

        // AddsubData = (Button)findViewById(R.id.submit);
        AddmainData = (Button) findViewById(R.id.submit);
        //spinneroccu = (Spinner)findViewById(R.id.occupation);

        sexspinner = (TextView) findViewById(R.id.sexspinner);
        spinnermaritalstatus = (TextView) findViewById(R.id.maritalstatus);
        spinneroccupation = (TextView) findViewById(R.id.occupation);
        spinnereducation = (TextView) findViewById(R.id.education);
        spinneraddress = (TextView) findViewById(R.id.address);
        spinnerrefferral = (TextView) findViewById(R.id.sourceofrefferal);

//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


//        mainproductlist = new ArrayList<>();
//        subproductlist = new ArrayList<>();
//
//
//        listmalefemale = new ArrayList<>();
//        listmalefemale.add("Male");
//        listmalefemale.add("Female");
//        /////
//
//        listmaritalstatus = new ArrayList<>();
//        listmaritalstatus.add("Single");
//        listmaritalstatus.add("Married");
//        listmaritalstatus.add("Widowed");
//        listmaritalstatus.add("Separated");
//        listmaritalstatus.add("Divorced");
//        listmaritalstatus.add("Deserted");
//
//        listoccupation = new ArrayList<>();
//        listoccupation.add("Not Applicable");
//        listoccupation.add("Not Occupied");
//        listoccupation.add("Professional");
//        listoccupation.add("Service");
//        listoccupation.add("Business");
//        listoccupation.add("H.W");
//        listoccupation.add("Vendor");
//        listoccupation.add("Farmer");
//        listoccupation.add("Student");
//        listoccupation.add("Unemployed");
//        listoccupation.add("Retired");
//        listoccupation.add("Disability");
//        listoccupation.add("Pension");
//        listoccupation.add("Housemaid");
//        listoccupation.add("Bara");
//        listoccupation.add("Baluteder");
//        listoccupation.add("Others");
//
//        listeducation = new ArrayList<>();
//        listeducation.add("No Formal Education");
//        listeducation.add("Primary");
//        listeducation.add("Secondary");
//        listeducation.add("S.S.C");
//        listeducation.add("Collage");
//        listeducation.add("Graduate");
//        listeducation.add("P.G");
//        listeducation.add("Professional");
//        listeducation.add("Technical");
//        listeducation.add("Others");
//
//        listaddress = new ArrayList<>();
//        listaddress.add("Urban");
//        listaddress.add("Semi-Urban");
//        listaddress.add("Rural");
//
//
//        listrefferal = new ArrayList<>();
//        listrefferal.add("Self");
//        listrefferal.add("Family member");
//        listrefferal.add("Friend");
//        listrefferal.add("Neighbor");
//        listrefferal.add("Villager");
//        listrefferal.add("G.P.(Ailo)");
//        listrefferal.add("G.P.(Ayur,Homeo)");
//        listrefferal.add("Specialist");
//        listrefferal.add("Psychiatrist");
//        listrefferal.add("Employer");
//        listrefferal.add("Institution");
//        listrefferal.add("Court");
//        listrefferal.add("Dept.");
//        listrefferal.add("Other Hospital");
//        listrefferal.add("Para Medicals");
//        listrefferal.add("Other");

//        try {
//
//            ArrayAdapter<String> mainproadapter = new ArrayAdapter<String>(getApplicationContext(),
//                    android.R.layout.simple_spinner_item, listmalefemale);
//
//            mainproadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//            sexspinner.setAdapter(mainproadapter);
//
//////
//
//            ArrayAdapter<String> maritalstatus = new ArrayAdapter<String>(getApplicationContext(),
//                    android.R.layout.simple_spinner_item, listmaritalstatus);
//
//            maritalstatus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//            spinnermaritalstatus.setAdapter(maritalstatus);
//
/////
//
//            ArrayAdapter<String> occupation = new ArrayAdapter<String>(getApplicationContext(),
//                    android.R.layout.simple_spinner_item, listoccupation);
//
//            occupation.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//            spinneroccupation.setAdapter(occupation);
////
//
//            ArrayAdapter<String> education = new ArrayAdapter<String>(getApplicationContext(),
//                    android.R.layout.simple_spinner_item, listeducation);
//
//            education.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//            spinnereducation.setAdapter(education);
////
//            ArrayAdapter<String> address = new ArrayAdapter<String>(getApplicationContext(),
//                    android.R.layout.simple_spinner_item, listaddress);
//
//            address.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//            spinneraddress.setAdapter(address);
//            //
//            ArrayAdapter<String> refferal = new ArrayAdapter<String>(getApplicationContext(),
//                    android.R.layout.simple_spinner_item, listrefferal);
//
//            refferal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//            spinnerrefferral.setAdapter(refferal);
//
//        } catch (Exception e) {
//        }
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
            String occupation = invoice.getOccupation();
            String education = invoice.getEducation();
            String ruralurban = invoice.getHowcontact();
            String referal = invoice.getResidencial();
            String maritalstatus = invoice.getMarrialstatus();


            if (gender != null) {
                sexspinner.setText(gender);
            }

            if (occupation != null) {
                spinnermaritalstatus.setText(occupation);
            }

            if (education != null) {
                spinneroccupation.setText(education);
            }

            if (ruralurban != null) {
                spinnereducation.setText(ruralurban);
            }

            if (referal != null) {
                spinneraddress.setText(referal);
            }

            if (maritalstatus != null) {
                spinnerrefferral.setText(maritalstatus);
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
        }

    }


    @Override
    public void onClick(View v) {
        if (v == AddmainData) {

            File sd = Environment.getExternalStorageDirectory();
            String csvFile = "Patient.xls";

            File directory = new File(sd.getAbsolutePath());
            //create directory if not exist
            if (!directory.isDirectory()) {
                directory.mkdirs();
            }
            try {

                //file path
                File file = new File(directory, csvFile);
                WorkbookSettings wbSettings = new WorkbookSettings();
                wbSettings.setLocale(new Locale("en", "EN"));
                WritableWorkbook workbook;
                workbook = Workbook.createWorkbook(file, wbSettings);
                //Excel sheet name. 0 represents first sheet
                WritableSheet sheet = workbook.createSheet("userList", 0);

                sheet.addCell(new Label(0, 0, "Doctore")); // column and row
                sheet.addCell(new Label(0, 1, "Patient"));
                sheet.addCell(new Label(0, 2, "Religion"));
                sheet.addCell(new Label(0, 3, "SES"));
                sheet.addCell(new Label(0, 4, "Age"));

                sheet.addCell(new Label(0, 5, "D.O.B.")); // column and row
                sheet.addCell(new Label(0, 6, "Gender"));
                sheet.addCell(new Label(0, 7, "Marital Status"));
                sheet.addCell(new Label(0, 8, "Occupation"));
                sheet.addCell(new Label(0, 9, "Education"));
                sheet.addCell(new Label(0, 10, "Address")); // column and row
                sheet.addCell(new Label(0, 11, "Residential"));
                sheet.addCell(new Label(0, 12, "Office"));
                sheet.addCell(new Label(0, 13, "Referal Source"));
                sheet.addCell(new Label(0, 14, "Diagnosis"));
                sheet.addCell(new Label(0, 15, "dsmv Code")); // column and row
                sheet.addCell(new Label(0, 16, "Revised Diagnosis"));
                sheet.addCell(new Label(0, 17, "Informant"));
                sheet.addCell(new Label(0, 18, "O.D.P."));
                sheet.addCell(new Label(0, 19, "Examination"));
                sheet.addCell(new Label(0, 20, "C.N.S.")); // column and row
                sheet.addCell(new Label(0, 21, "C.V.S."));
                sheet.addCell(new Label(0, 22, "Pulse"));
                sheet.addCell(new Label(0, 23, "B.P."));
                sheet.addCell(new Label(0, 24, "R.S."));
                sheet.addCell(new Label(0, 25, "P.A.")); // column and row
                sheet.addCell(new Label(0, 26, "i-Mark"));
                sheet.addCell(new Label(0, 27, "Formulation"));
                sheet.addCell(new Label(0, 28, "DignosisPHY"));
                sheet.addCell(new Label(0, 29, "Management Plan"));
                sheet.addCell(new Label(0, 30, "Investigations")); // column and row
                sheet.addCell(new Label(0, 31, "R.E.F. with reasons"));
                sheet.addCell(new Label(0, 32, "Rehabilation Needs"));
                sheet.addCell(new Label(0, 33, "Persnality"));
                sheet.addCell(new Label(0, 34, "Social Support"));
                sheet.addCell(new Label(0, 35, "Past History")); // column and row
                sheet.addCell(new Label(0, 36, "Family History"));
                sheet.addCell(new Label(0, 37, "DEV History"));

                sheet.addCell(new Label(0, 38, "Occupation History"));
                sheet.addCell(new Label(0, 39, "Personal History"));
                sheet.addCell(new Label(0, 40, "Appearence")); // column and row
                sheet.addCell(new Label(0, 41, "Speech Mood"));
                sheet.addCell(new Label(0, 42, "Memory Condition"));


//                for (int i = 0; i<leedsModelArrayList.size(); i++) {
                String name = invoice.getPname();
                String doctor = invoice.getCdoctor();
                String religion = invoice.getReligion();
                String ses = invoice.getSes();
                String age = invoice.getAge();
                String dob = invoice.getDob();
                String gender = invoice.getGender();
                String marital = invoice.getMarrialstatus();
                String occu = invoice.getOccupation();
                String edu = invoice.getEducation();
                String address = invoice.getAddress();
                String residential = invoice.getResidencial();
                String office = invoice.getOffice();
                String referal = invoice.getRefralwithreasons();
                String diagnosis = invoice.getDiagnosys();
                String dsmv = invoice.getDsmvcode();
                String reviseddignosis = invoice.getReviseddiagnosys();
                String informant = invoice.getInformant();
                String odp = invoice.getOdp();
                String examination = invoice.getGexamination();
                String cns = invoice.getCns();
                String cvs = invoice.getCvs();
                String pulse = invoice.getPulse();
                String bp = invoice.getBp();
                String rs = invoice.getRs();
                String pa = invoice.getPa();
                String imark = invoice.getImark();
                String formulation = invoice.getFormulation();
                String diagnosisphy = invoice.getDiagnosys();
                String management = invoice.getManagementplan();
                String investigations = invoice.getInvestigation();
                String refwithreason = invoice.getRefralwithreasons();
                String rehabilationeed = invoice.getRehabitationneed();
                String persnality = invoice.getPersnality();
                String socialsupprt = invoice.getSocialsupport();
                String pasthistory = invoice.getPasthistory();
                String familyhistory = invoice.getFamilyhistory();
                String devhistory = invoice.getDevhistoryandchildhood();
                String occuhistory = invoice.getOccupationalhistory();
//                String personalhistory = invoice.getPasthistory();
                String appearenceandbehaviour = invoice.getAppearanceandbehaviour();
                String speechmood = invoice.getSpeechmoodeffect();
                String memorycondition = invoice.getInsightgudgementmemory();

                sheet.addCell(new Label(1, 0, doctor));
                sheet.addCell(new Label(1, 1, name));
                sheet.addCell(new Label(1, 2, religion));
                sheet.addCell(new Label(1, 3, ses));
                sheet.addCell(new Label(1, 4, age));

                sheet.addCell(new Label(1, 5, dob));
                sheet.addCell(new Label(1, 6, gender));
                sheet.addCell(new Label(1, 7, marital));
                sheet.addCell(new Label(1, 8, occu));
                sheet.addCell(new Label(1, 9, edu));
                sheet.addCell(new Label(1, 10, address));
                sheet.addCell(new Label(1, 11, residential));
                sheet.addCell(new Label(1, 12, office));
                sheet.addCell(new Label(1, 13, referal));
                sheet.addCell(new Label(1, 14, diagnosis));
                sheet.addCell(new Label(1, 15, dsmv));
                sheet.addCell(new Label(1, 16, reviseddignosis));
                sheet.addCell(new Label(1, 17, informant));
                sheet.addCell(new Label(1, 18, odp));
                sheet.addCell(new Label(1, 19, examination));
                sheet.addCell(new Label(1, 20, cns));
                sheet.addCell(new Label(1, 21, cvs));
                sheet.addCell(new Label(1, 22, pulse));
                sheet.addCell(new Label(1, 23, bp));
                sheet.addCell(new Label(1, 24, rs));
                sheet.addCell(new Label(1, 25, pa));
                sheet.addCell(new Label(1, 26, imark));
                sheet.addCell(new Label(1, 27, formulation));
                sheet.addCell(new Label(1, 28, diagnosisphy));
                sheet.addCell(new Label(1, 29, management));
                sheet.addCell(new Label(1, 30, investigations));
                sheet.addCell(new Label(1, 31, refwithreason));
                sheet.addCell(new Label(1, 32, rehabilationeed));
                sheet.addCell(new Label(1, 33, persnality));
                sheet.addCell(new Label(1, 34, socialsupprt));
                sheet.addCell(new Label(1, 35, pasthistory));
                sheet.addCell(new Label(1, 36, familyhistory));
                sheet.addCell(new Label(1, 37, devhistory));
                sheet.addCell(new Label(1, 38, occuhistory));
//                sheet.addCell(new Label(1, 39, personalhistory));
                sheet.addCell(new Label(1, 40, appearenceandbehaviour));
                sheet.addCell(new Label(1, 41, speechmood));
                sheet.addCell(new Label(1, 42, memorycondition));

//                }

                workbook.write();
                workbook.close();
                Toast.makeText(View_Patient_Report_Activity.this, "Data Exported in a Excel Sheet", Toast.LENGTH_SHORT).show();

                Intent myIntent = new Intent(Intent.ACTION_VIEW);
                myIntent.setData(Uri.fromFile(new File(csvFile)));
                Intent j = Intent.createChooser(myIntent, "Choose an application to open with:");
                startActivity(j);

            } catch (Exception e) {
                e.printStackTrace();
            }
//            SetData();
        }
    }

    private void SetData() {

        Sreligion = etreligion.getText().toString();
        Sses = etses.getText().toString();
        Sage = etage.getText().toString();
        Sdob = etdob.getText().toString();
        Srecidential = etrecidencial.getText().toString();
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
//        Sidentificationalmark = etidentificationmark.getText().toString();
//        Sformulation = etformulation.getText().toString();
//        Smanagementplan = etmanagementplan.getText().toString();
//        Sinvestigation = etinvestigation.getText().toString();
        Srefwithresons = etrefwithresons.getText().toString();
        Srehabitetionneed = etrehabitationneed.getText().toString();
        Spersnality = etpersnality.getText().toString();
        Ssocialsupport = etsocialsupport.getText().toString();
//        Spasthistory = etpasthistory.getText().toString();
        Sfamilyhistory = etfamilyhistory.getText().toString();
        Sdevchild = etdevchild.getText().toString();
        Soccupationalhistory = etoccupationalhistory.getText().toString();
//        Spsmhistory = etpsmhistory.getText().toString();
        Sapearenceandbehaviour = etapearanceandbehaviour.getText().toString();
        Sspeechmodeffects = etspeechmoodeffects.getText().toString();
        Sinsidejudmentmemory = etinsidejudmentmemory.getText().toString();

        updateData();

    }

    private void updateData() {

        invoice.setReligion(Sreligion);
        invoice.setSes(Sses);
        invoice.setAge(Sage);
        invoice.setDob(Sdob);
        invoice.setAddress(Srecidential);
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
//        invoice.setReligion(Sreligion);
//        invoice.setReligion(Sreligion);
//        invoice.setReligion(Sreligion);
//        invoice.setReligion(Sreligion);
        invoice.setRefralwithreasons(Srefwithresons);
        invoice.setRehabitationneed(Srehabitetionneed);
        invoice.setPersnality(Spersnality);
        invoice.setSocialsupport(Ssocialsupport);
        invoice.setPasthistory(Spasthistory);
        invoice.setFamilyhistory(Sfamilyhistory);
        invoice.setDevhistoryandchildhood(Sdevchild);
        invoice.setOccupationalhistory(Soccupationalhistory);
//        invoice.setReligion(Sreligion);
        invoice.setAppearanceandbehaviour(Sapearenceandbehaviour);
        invoice.setSpeechmoodeffect(Sspeechmodeffects);
        invoice.setInsightgudgementmemory(Sinsidejudmentmemory);

//        updateLeed(invoice);
//        updateLeed(invoice.getLeedId(), invoice.getLeedStatusMap());
    }

//    private void updateLeed(PatientVO invoice) {
//
//    }

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