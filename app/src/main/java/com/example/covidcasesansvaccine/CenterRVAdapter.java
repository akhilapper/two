package com.example.covidcasesansvaccine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CenterRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List centerList;


    @NonNull
    public CenterRVAdapter.CenterRVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(1300003, parent, false);

        return new CenterRVAdapter.CenterRVViewHolder(itemView);
    }

    // $FF: synthetic method
    // $FF: bridge method
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
        return (RecyclerView.ViewHolder)this.onCreateViewHolder(var1, var2);
    }

    public int getItemCount() {
        return this.centerList.size();
    }

    public void onBindViewHolder(CenterRVAdapter.CenterRVViewHolder holder, int position) {

        CenterRVModel currentItem = (CenterRVModel)this.centerList.get(position);
        holder.getCenterNameTV().setText((CharSequence)currentItem.getCenterName());
        holder.getCenterAddressTV().setText((CharSequence)currentItem.getCenterAddress());
        holder.getCenterTimings().setText((CharSequence)("From : " + currentItem.getCenterFromTime() + " To : " + currentItem.getCenterToTime()));
        holder.getVaccineNameTV().setText((CharSequence)currentItem.getVaccineName());
        holder.getCenterAgeLimitTV().setText((CharSequence)("Age Limit : " + String.valueOf(currentItem.getAgeLimit())));
        holder.getCenterFeeTypeTV().setText((CharSequence)currentItem.getFee_type());
        holder.getAvalabilityTV().setText((CharSequence)("Availability : " + String.valueOf(currentItem.getAvailableCapacity())));
    }

    // $FF: synthetic method
    // $FF: bridge method
    public void onBindViewHolder(RecyclerView.ViewHolder var1, int var2) {
        this.onBindViewHolder((CenterRVAdapter.CenterRVViewHolder)var1, var2);
    }

    public CenterRVAdapter( List centerList) {

        super();
        this.centerList = centerList;
    }


    public static final class CenterRVViewHolder extends RecyclerView.ViewHolder {

        private final TextView centerNameTV;

        private final TextView centerAddressTV;

        private final TextView centerTimings;

        private final TextView vaccineNameTV;

        private final TextView centerAgeLimitTV;

        private final TextView centerFeeTypeTV;

        private final TextView avalabilityTV;


        public final TextView getCenterNameTV() {
            return this.centerNameTV;
        }


        public final TextView getCenterAddressTV() {
            return this.centerAddressTV;
        }


        public final TextView getCenterTimings() {
            return this.centerTimings;
        }


        public final TextView getVaccineNameTV() {
            return this.vaccineNameTV;
        }


        public final TextView getCenterAgeLimitTV() {
            return this.centerAgeLimitTV;
        }


        public final TextView getCenterFeeTypeTV() {
            return this.centerFeeTypeTV;
        }


        public final TextView getAvalabilityTV() {
            return this.avalabilityTV;
        }

        public CenterRVViewHolder( View itemView) {

            super(itemView);
            View var10001 = itemView.findViewById(1000004);

            this.centerNameTV = (TextView)var10001;
            var10001 = itemView.findViewById(1000005);

            this.centerAddressTV = (TextView)var10001;
            var10001 = itemView.findViewById(1000013);

            this.centerTimings = (TextView)var10001;
            var10001 = itemView.findViewById(1000014);

            this.vaccineNameTV = (TextView)var10001;
            var10001 = itemView.findViewById(1000006);

            this.centerAgeLimitTV = (TextView)var10001;
            var10001 = itemView.findViewById(1000018);

            this.centerFeeTypeTV = (TextView)var10001;
            var10001 = itemView.findViewById(1000022);

            this.avalabilityTV = (TextView)var10001;
        }
    }

}
