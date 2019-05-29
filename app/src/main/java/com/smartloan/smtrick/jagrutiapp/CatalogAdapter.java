package com.smartloan.smtrick.jagrutiapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

import static com.smartloan.smtrick.jagrutiapp.Constants.GLOBAL_DATE_FORMATE;

public class CatalogAdapter extends RecyclerView.Adapter<CatalogAdapter.ViewHolder> {

    private Context context;
    private List<PatientVO> list;


    String item;


   public CatalogAdapter(Context context, List<PatientVO> list){
       this.context = context;
       this.list = list;
   }




   @Override
    public CatalogAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cataloglist, parent, false);
        CatalogAdapter.ViewHolder viewHolder = new CatalogAdapter.ViewHolder(v);
      //  context = parent.getContext();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final CatalogAdapter.ViewHolder holder, final int position) {
       //String pname = list.get(position);
        final PatientVO pveo = list.get(position);

        holder.pname.setText(pveo.getPname());
        holder.cdoctor.setText(pveo.getCdoctor());
        holder.address.setText(pveo.getAddress());
        try {
        if (pveo.getCreatedDateTimeLong() > 0)
            holder.adate.setText(Utility.convertMilliSecondsToFormatedDate(pveo.getCreatedDateTimeLong(), GLOBAL_DATE_FORMATE));
        else
            holder.adate.setText("Na");

        } catch (Exception e) {
            e.printStackTrace();
        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Do on click stuff
                //Toast.makeText(holder.pname.getContext(), list.get(position), Toast.LENGTH_SHORT).show();
                String item = list.get(position).toString();
                Intent intent = new Intent(holder.pname.getContext(),Add_Updatelead__bankresult_Activity.class);
                intent.putExtra("itemName",item);
                intent.putExtra("invoice", pveo);
                holder.pname.getContext().startActivity(intent);

            }
        });

        holder.cardView.setOnLongClickListener(new View.OnLongClickListener()

        {
            @Override
            public boolean onLongClick (View view){

// custom dialog
               return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView pname,adate,cdoctor,address;
        public CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            pname = (TextView) itemView.findViewById(R.id.pname);
            adate = (TextView) itemView.findViewById(R.id.gendate);
            cdoctor = (TextView) itemView.findViewById(R.id.cdoctor);
            address = (TextView) itemView.findViewById(R.id.address);
            cardView = (CardView) itemView.findViewById(R.id.card);

        }
    }
}
