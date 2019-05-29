package com.smartloan.smtrick.jagrutiapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import static com.smartloan.smtrick.jagrutiapp.Constants.AGENT_PREFIX;

public class Fragment_Add_Product_names extends Fragment implements View.OnClickListener {

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
    private DatabaseReference mDatabase;

    private Button AddsubData;
    private Button AddmainData;
    private List<String> mainproductlist;
    private List<String> subproductlist;
   // MainProducts mainProducts;

    private List<String> listmalefemale;
    private List<String> listmaritalstatus;
    private List<String> listoccupation;
    private List<String> listeducation;
    private List<String> listaddress;
    private List<String> listrefferal;
   // String mainproduct;

    private EditText etreligion,etses,etage,etdob,etrecidencial,etoffice,etdignosys,etdsmvcode,etreviseddignosis,etinformant
    ,etodp,etgeneralexamination,etcns,etcvs,etpulse,etbp,etrs,etpa,etidentificationmark,etformulation,etmanagementplan,
            etinvestigation,etrefwithresons,etrehabitationneed,etpersnality,etsocialsupport,etpasthistory,etfamilyhistory,etdevchild,
            etoccupationalhistory,etpsmhistory,etapearanceandbehaviour,etspeechmoodeffects,etinsidejudmentmemory;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_product_names, container, false);


        etname = (EditText) view.findViewById(R.id.name);
        etresaddress = (EditText) view.findViewById(R.id.residencial);
        etdocturcunsultant = (EditText) view.findViewById(R.id.Doctorcunsoltunt);
        etreligion = (EditText) view.findViewById(R.id.religion);
        etage = (EditText) view.findViewById(R.id.age);
        etses = (EditText) view.findViewById(R.id.ses);
        etdob = (EditText) view.findViewById(R.id.dob);
        etrecidencial = (EditText) view.findViewById(R.id.residencial);
        etoffice = (EditText) view.findViewById(R.id.office);
        etdignosys = (EditText) view.findViewById(R.id.diagnosis);
        etdsmvcode = (EditText) view.findViewById(R.id.dsmvcode);
        etreviseddignosis = (EditText) view.findViewById(R.id.reviseddignosis);
        etinformant = (EditText) view.findViewById(R.id.informant);
        etodp = (EditText) view.findViewById(R.id.odp);
        etgeneralexamination = (EditText) view.findViewById(R.id.generalexamination);
        etcns = (EditText) view.findViewById(R.id.cns);
        etcvs = (EditText) view.findViewById(R.id.cvs);
        etpulse = (EditText) view.findViewById(R.id.pulse);
        etbp = (EditText) view.findViewById(R.id.bp);
        etrs = (EditText) view.findViewById(R.id.rs);
        etpa = (EditText) view.findViewById(R.id.pa);
        etidentificationmark = (EditText) view.findViewById(R.id.imark);
        etformulation = (EditText) view.findViewById(R.id.formulation);
        etmanagementplan= (EditText) view.findViewById(R.id.managementplan);
        etinvestigation= (EditText) view.findViewById(R.id.investigations);
        etrefwithresons= (EditText) view.findViewById(R.id.refwithreasons);
        etrehabitationneed= (EditText) view.findViewById(R.id.rehabilationneeds);
        etpersnality= (EditText) view.findViewById(R.id.persnality);
        etsocialsupport= (EditText) view.findViewById(R.id.socialsupport);
        etpasthistory= (EditText) view.findViewById(R.id.pasthistory);
        etfamilyhistory= (EditText) view.findViewById(R.id.familyhistory);
        etdevchild= (EditText) view.findViewById(R.id.dhandchildad);
        etoccupationalhistory= (EditText) view.findViewById(R.id.occuhistory);
        etpsmhistory= (EditText) view.findViewById(R.id.personalhistory);
        etapearanceandbehaviour= (EditText) view.findViewById(R.id.apearanceandbehaviour);
        etspeechmoodeffects= (EditText) view.findViewById(R.id.speachmoodefect);
        etinsidejudmentmemory= (EditText) view.findViewById(R.id.insightjugecodition);

        // AddsubData = (Button) view.findViewById(R.id.submit);
        AddmainData = (Button) view.findViewById(R.id.submit);
        //spinneroccu = (Spinner) view.findViewById(R.id.occupation);

        sexspinner = (Spinner) view.findViewById(R.id.sexspinner);
        spinnermaritalstatus = (Spinner) view.findViewById(R.id.maritalstatus);
        spinneroccupation = (Spinner) view.findViewById(R.id.occupation);
        spinnereducation = (Spinner) view.findViewById(R.id.education);
        spinneraddress = (Spinner) view.findViewById(R.id.address);
        spinnerrefferral = (Spinner) view.findViewById(R.id.sourceofrefferal);

        mDatabaseRefpatient = FirebaseDatabase.getInstance().getReference("Patients");
        mDatabase = FirebaseDatabase.getInstance().getReference(Constants.DATABASE_PATH_PATIENTS);

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


        try{

            ArrayAdapter<String> mainproadapter = new ArrayAdapter<String>(getContext(),
                    android.R.layout.simple_spinner_item, listmalefemale);

            mainproadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            sexspinner.setAdapter(mainproadapter);

////

            ArrayAdapter<String> maritalstatus = new ArrayAdapter<String>(getContext(),
                    android.R.layout.simple_spinner_item, listmaritalstatus);

            maritalstatus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnermaritalstatus.setAdapter(maritalstatus);

///

            ArrayAdapter<String> occupation = new ArrayAdapter<String>(getContext(),
                    android.R.layout.simple_spinner_item, listoccupation);

            occupation.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinneroccupation.setAdapter(occupation);
//

            ArrayAdapter<String> education = new ArrayAdapter<String>(getContext(),
                    android.R.layout.simple_spinner_item, listeducation);

            education.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnereducation.setAdapter(education);
//
            ArrayAdapter<String> address = new ArrayAdapter<String>(getContext(),
                    android.R.layout.simple_spinner_item, listaddress);

            address.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinneraddress.setAdapter(address);
 //
            ArrayAdapter<String> refferal = new ArrayAdapter<String>(getContext(),
                    android.R.layout.simple_spinner_item, listrefferal);

            refferal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerrefferral.setAdapter(refferal);

        } catch (Exception e) {
        }
        AddmainData.setOnClickListener(this);

        return view;



    }

    @Override
    public void onClick(View v){

        try {


            if (v == AddmainData) {

                String name = etname.getText().toString();
                String cdoctor = etdocturcunsultant.getText().toString();
                String address = etresaddress.getText().toString();
                String setreligion = etreligion.getText().toString();
                String setses = etses.getText().toString();
                String setage = etage.getText().toString();
                String setdob = etdob.getText().toString();
                String setrecidencial = etrecidencial.getText().toString();
                String setoffice = etoffice.getText().toString();
                String setdignosys = etdignosys.getText().toString();
                String setdsmvcode = etdsmvcode.getText().toString();
                String setreviseddignosis = etreviseddignosis.getText().toString();
                String setinformant = etinformant.getText().toString();
                String setodp = etodp.getText().toString();
                String setgeneralexamination = etgeneralexamination.getText().toString();
                String setcns = etcns.getText().toString();
                String setcvs = etcvs.getText().toString();
                String setpulse = etpulse.getText().toString();
                String setbp = etbp.getText().toString();
                String setrs = etrs.getText().toString();
                String setpa = etpa.getText().toString();
                String setidentificationmark = etidentificationmark.getText().toString();
                String setformulation = etformulation.getText().toString();
                String setmanagementplan = etmanagementplan.getText().toString();
                String setinvestigation = etinvestigation.getText().toString();
                String setrefwithresons = etrefwithresons.getText().toString();
                String setrehabitationneed = etrehabitationneed.getText().toString();
                String setpersnality = etpersnality.getText().toString();
                String setsocialsupport = etsocialsupport.getText().toString();
                String setpasthistory = etpasthistory.getText().toString();
                String setfamilyhistory = etfamilyhistory.getText().toString();
                String setdevchild = etdevchild.getText().toString();
                String setoccupationalhistory = etoccupationalhistory.getText().toString();
                String setpsmhistory = etpsmhistory.getText().toString();
                String setapearanceandbehaviour = etapearanceandbehaviour.getText().toString();
                String setspeechmoodeffects = etspeechmoodeffects.getText().toString();
                String setinsidejudmentmemory = etinsidejudmentmemory.getText().toString();

                String ssexspinner = sexspinner.getSelectedItem().toString();
                String sspinnermaritalstatus = spinnermaritalstatus.getSelectedItem().toString();
                String sspinneroccupation = spinneroccupation.getSelectedItem().toString();
                String sspinnereducation = spinnereducation.getSelectedItem().toString();
                String sspinneraddress = spinneraddress.getSelectedItem().toString();
                String sspinnerrefferral = spinnerrefferral.getSelectedItem().toString();
                String patientId = Utility.generateAgentId(AGENT_PREFIX);
                String leedId = mDatabase.push().getKey();




                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(getContext(), "Enter Patient Name", Toast.LENGTH_SHORT).show();
                    return;
                }

                PatientVO patientaddforms = new PatientVO(name,cdoctor,address,setreligion,setses,setage,setdob,setrecidencial,setoffice,setdignosys,setdsmvcode,setreviseddignosis,setinformant
                        ,setodp,setgeneralexamination,setcns,setcvs,setpulse,setbp,setrs,setpa,setidentificationmark,setformulation,setmanagementplan,
                        setinvestigation,setrefwithresons,setrehabitationneed,setpersnality,setsocialsupport,setpasthistory,setfamilyhistory,setdevchild,
                        setoccupationalhistory,setpsmhistory,setapearanceandbehaviour,setspeechmoodeffects,setinsidejudmentmemory,patientId,leedId);

//                String uploadId = mDatabaseRefpatient.push().getKey();
                mDatabaseRefpatient.child(leedId).setValue(patientaddforms);

                    Toast.makeText(getContext(), "Application Submited", Toast.LENGTH_SHORT).show();

            }

        }catch (Exception e){}




    }


}
