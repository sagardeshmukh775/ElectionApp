package com.smartloan.smtrick.jagrutiapp;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.smartloan.smtrick.jagrutiapp.Constants.GLOBAL_DATE_FORMATE;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.ViewHolder> {

    private List<Reportmodel> leedsModelArrayList;
    private Context context;

   public ReportAdapter(Context context, List<Reportmodel> data){
       this.context = context;
       this.leedsModelArrayList = data;
   }





    @Override
    public ReportAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cataloglist, parent, false);
        ReportAdapter.ViewHolder viewHolder = new ReportAdapter.ViewHolder(v);
      //  context = parent.getContext();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ReportAdapter.ViewHolder holder, final int position) {
       //String pname = list.get(position);
        final Reportmodel pveo = leedsModelArrayList.get(position);

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

       // holder.pname.setText(pname);






//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //Do on click stuff
//                Toast.makeText(holder.catalogname.getContext(), list.get(position), Toast.LENGTH_SHORT).show();
//                String item = list.get(position).toString();
//                Intent intent = new Intent(holder.catalogname.getContext(),SubCatalogActivity.class);
//                intent.putExtra("itemName",item);
//                holder.catalogname.getContext().startActivity(intent);
//
//            }
//        });

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
        return leedsModelArrayList.size();
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

    public void reload(ArrayList<Reportmodel> list) {
        list.clear();
        list.addAll(list);
        notifyDataSetChanged();
    }
}
