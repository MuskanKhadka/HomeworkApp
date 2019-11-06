package com.muskan.homeworkapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.muskan.homeworkapp.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import com.muskan.homeworkapp.model.DetailsClass;

public class AdapterView extends RecyclerView.Adapter<AdapterView.ContactsViewHolder>  {
    Context context;
    List<DetailsClass> detailsClassList;

    public AdapterView(Context context, List<DetailsClass> detailsClassList) {
        this.context = context;
        this.detailsClassList = detailsClassList;
    }

    @NonNull
    @Override
    public AdapterView.ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_view, parent, false);
        return new ContactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterView.ContactsViewHolder holder, int position) {
        final DetailsClass detailsClass = detailsClassList.get(position);
        holder.imgview.setImageResource(detailsClass.getImagenumber());
        holder.txnames.setText(detailsClass.getName());
        holder.txgenders.setText(detailsClass.getGender());
        holder.txages.setText(detailsClass.getAge());

    }

    @Override
    public int getItemCount() {
        return detailsClassList.size();

    }

    public class ContactsViewHolder extends RecyclerView.ViewHolder {
        ImageView imgview;
        TextView txnames, txages, txgenders;
        public ContactsViewHolder(View view) {
            super(view);
            imgview = itemView.findViewById(R.id.imgv);
            txnames = itemView.findViewById(R.id.name);
            txages = itemView.findViewById(R.id.age);
            txgenders = itemView.findViewById(R.id.gender);
        }
    }
}
