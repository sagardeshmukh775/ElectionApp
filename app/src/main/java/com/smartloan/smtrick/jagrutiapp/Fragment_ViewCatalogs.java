package com.smartloan.smtrick.jagrutiapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class Fragment_ViewCatalogs extends Fragment {

    private RecyclerView catalogRecycler;
    private DatabaseReference mdataRefpatient;
    private List<PatientVO> catalogList;
    private ProgressBar catalogprogress;
    private RecyclerView.Adapter adapter;

    // int[] animationList = {R.anim.layout_animation_up_to_down};
    int i = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_viewcatalog, container, false);

        // getActivity().getActionBar().setTitle("Products");
        catalogprogress = (ProgressBar) view.findViewById(R.id.catalog_progress);
        catalogRecycler = (RecyclerView) view.findViewById(R.id.catalog_recycle);
        catalogList = new ArrayList<>();


        catalogprogress.setVisibility(View.VISIBLE);
        mdataRefpatient = FirebaseDatabase.getInstance().getReference("Patients");
        mdataRefpatient.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                catalogList.clear();
                for (DataSnapshot mainproductSnapshot : dataSnapshot.getChildren()) {

                    PatientVO mainProducts = mainproductSnapshot.getValue(PatientVO.class);
                    catalogList.add(mainProducts);
                }


                adapter = new CatalogAdapter(getActivity(), catalogList);

                //adding adapter to recyclerview
                catalogRecycler.setAdapter(adapter);
                // CatalogAdapter catalogAdapter = new CatalogAdapter(catalogList);
                catalogRecycler.setHasFixedSize(true);
                catalogRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
                //catalogRecycler.setAdapter(catalogAdapter);
                catalogprogress.setVisibility(View.GONE);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        return view;
    }


}
