package com.smartloan.smtrick.jagrutiapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Request_Doctors_Fragment extends Fragment {

    private LeedRepository leedRepository;
    ArrayList<Users> invoiceArrayList;
    UserAdapter invoiceAdapter;
    private RecyclerView userrecycler;

    public Request_Doctors_Fragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_users, container, false);

        leedRepository = new LeedRepositoryImpl();
        invoiceArrayList = new ArrayList<>();
        userrecycler = (RecyclerView) view.findViewById(R.id.userRecycler);
        userrecycler.setHasFixedSize(true);
        userrecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        getRequestDoctors();

        return view;
    }

    private void getRequestDoctors() {

        leedRepository.readRequestUser("REQUEST", new CallBack() {
            @Override
            public void onSuccess(Object object) {

                if (object != null) {
                    invoiceArrayList = (ArrayList<Users>) object;
                    serAdapter(invoiceArrayList);
                }
            }

            @Override
            public void onError(Object object) {
//                Utility.showMessage(getActivity(), getMessage(R.string.registration_fail));
            }
        });
    }

    private void serAdapter(ArrayList<Users> invoiceArrayList) {
        if (invoiceArrayList != null) {
            if (invoiceAdapter == null) {
                invoiceAdapter = new UserAdapter(getActivity(), invoiceArrayList);
                userrecycler.setAdapter(invoiceAdapter);
            } else {
                ArrayList<Users> arrayList = new ArrayList<>();
                arrayList.addAll(invoiceArrayList);
                invoiceAdapter.reload(arrayList);
            }
        }
    }

}
