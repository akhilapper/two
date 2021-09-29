package com.example.covidcasesansvaccine;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class VaccineActivity extends AppCompatActivity {

    private Button searchButton;
    public EditText pinCodeEdt;
    public RecyclerView centersRV;
    public CenterRVAdapter centerRVAdapter;
    public List centerList;
    public ProgressBar loadingPB;


    public final EditText getPinCodeEdt() {
        EditText var10000 = this.pinCodeEdt;


        return var10000;
    }

    public final void setPinCodeEdt( EditText var1) {

        this.pinCodeEdt = var1;
    }


    public final RecyclerView getCentersRV() {
        RecyclerView var10000 = this.centersRV;


        return var10000;
    }

    public final void setCentersRV( RecyclerView var1) {

        this.centersRV = var1;
    }


    public final CenterRVAdapter getCenterRVAdapter() {
        CenterRVAdapter var10000 = this.centerRVAdapter;
        if (var10000 == null) {

        }

        return var10000;
    }

    public final void setCenterRVAdapter( CenterRVAdapter var1) {

        this.centerRVAdapter = var1;
    }


    public final List getCenterList() {
        List var10000 = this.centerList;


        return var10000;
    }

    public final void setCenterList( List var1) {

        this.centerList = var1;
    }


    public final ProgressBar getLoadingPB() {
        ProgressBar var10000 = this.loadingPB;
        if (var10000 == null) {

        }

        return var10000;
    }

    public final void setLoadingPB( ProgressBar var1) {

        this.loadingPB = var1;
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(1300000);
        View var10001 = this.findViewById(1000022);

        this.searchButton = (Button)var10001;
        var10001 = this.findViewById(R.id.idBtnSearch);

        this.pinCodeEdt = (EditText)var10001;
        var10001 = this.findViewById(R.id.idEdtPinCode);

        this.centersRV = (RecyclerView)var10001;
        var10001 = this.findViewById(R.id.centersRV);

        this.loadingPB = (ProgressBar)var10001;
        this.centerList = (new ArrayList());
        Button var10000 = this.searchButton;


        var10000.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                final String pinCode = VaccineActivity.this.getPinCodeEdt().getText().toString();
                if (pinCode.length() != 6) {
                    Toast.makeText((Context)VaccineActivity.this, (CharSequence)"Please enter valid pin code", 0).show();
                } else {
                    List var10000 =VaccineActivity.this.getCenterList();
                    if (var10000 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<com.example.covidcasesansvaccine.CenterRVModel>");
                    }

                    ((ArrayList)var10000).clear();
                    Calendar c = Calendar.getInstance();
                    int year = c.get(1);
                    int month = c.get(2);
                    int day = c.get(5);
                    DatePickerDialog dpd = new DatePickerDialog((Context)VaccineActivity.this, (DatePickerDialog.OnDateSetListener)(new DatePickerDialog.OnDateSetListener() {
                        public final void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            VaccineActivity.this.getLoadingPB().setVisibility(0);
                            String dateStr = dayOfMonth + " - " + (monthOfYear + 1) + " - " + year;
                            VaccineActivity.this.getAppointments(pinCode, dateStr);
                        }
                    }), year, month, day);
                    dpd.show();
                }

            }
        }));
    }

    private final void getAppointments(String pinCode, String date) {
        String url = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByPin?pincode=" + pinCode + "&date=" + date;
        RequestQueue queue = Volley.newRequestQueue((Context)this);

        JsonObjectRequest request = new JsonObjectRequest(0, url, (JSONObject)null, (Response.Listener)(new Response.Listener() {
            // $FF: synthetic method
            // $FF: bridge method
            public void onResponse(Object var1) {
                this.onResponse((JSONObject)var1);
            }

            public final void onResponse(JSONObject response) {
                Log.e("TAG", "SUCCESS RESPONSE IS " + response);
                VaccineActivity.this.getLoadingPB().setVisibility(View.VISIBLE);

                try {
                    JSONArray centerArray = response.getJSONArray("centers");
                    if (Integer.valueOf(centerArray.length()).equals(0)) {
                        Toast.makeText((Context)VaccineActivity.this, (CharSequence)"No Center Found", 0).show();
                    }
                    for(int i=0;i<centerArray.length();i++)
                    {
                        JSONObject centerObj = centerArray.getJSONObject(i);
                    String var10000 = centerObj.getString("name");

                    String centerName = var10000;
                    var10000 = centerObj.getString("address");

                    String centerAddress = var10000;
                    var10000 = centerObj.getString("from");

                    String centerFromTime = var10000;
                    var10000 = centerObj.getString("to");

                    String centerToTime = var10000;
                    var10000 = centerObj.getString("fee_type");

                    String fee_type = var10000;
                    JSONObject sessionObj = centerObj.getJSONArray("sessions").getJSONObject(0);
                    int ageLimit = sessionObj.getInt("min_age_limit");
                    var10000 = sessionObj.getString("vaccine");

                    String vaccineName = var10000;
                    int avaliableCapacity = sessionObj.getInt("available_capacity");
                    CenterRVModel center =new CenterRVModel(centerName, centerAddress, centerFromTime, centerToTime, fee_type, ageLimit, vaccineName, avaliableCapacity);
                        centerList += center;
                    }} catch (JSONException e) {
                    e.printStackTrace();
                }
                VaccineActivity.this.setCenterRVAdapter(new CenterRVAdapter(VaccineActivity.this.getCenterList()));
                    VaccineActivity.this.getCentersRV().setLayoutManager((RecyclerView.LayoutManager)(new LinearLayoutManager((Context)VaccineActivity.this)));
                    VaccineActivity.this.getCentersRV().setAdapter((RecyclerView.Adapter<RecyclerView.ViewHolder>)VaccineActivity.this.getCenterRVAdapter());
                    VaccineActivity.this.getCenterRVAdapter().notifyDataSetChanged();
                } catch (JSONException var14) {
                    var14.printStackTrace();
                }

            }
        }), (Response.ErrorListener)(new Response.ErrorListener() {
            public final void onErrorResponse(VolleyError error) {
                Log.e("TAG", "RESPONSE IS " + error);
                Toast.makeText((Context)VaccineActivity.this, (CharSequence)"Fail to get response", 1).show();
            }
        }));
        queue.add((Request<JSONObject>)request);
    }
}