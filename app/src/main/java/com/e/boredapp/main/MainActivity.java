package com.e.boredapp.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.e.boredapp.R;
import com.e.boredapp.data.BoredApiClient;
import com.e.boredapp.data.IBoredApiClient;
import com.e.boredapp.model.BoredAction;

public class MainActivity extends AppCompatActivity {

    TextView textView, textType, textPrice,textAccessibility, textPaticipans, textlink;
    Button btnRefresh;
    ProgressBar progressBar;


    public  static void start(Context context){
        Intent intent= new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView= findViewById(R.id.text_view);
        btnRefresh= findViewById(R.id.refreshBtn);
        textType=findViewById(R.id.text_type);
        textPrice= findViewById(R.id.text_price);
        textAccessibility= findViewById(R.id.textAccess);
        progressBar = findViewById(R.id.progressBar);
        textPaticipans= findViewById(R.id.text_patisipans);
        textlink= findViewById(R.id.text_link);

    }

    public void OnClick(View view) {
        progressBar.setVisibility(View.VISIBLE);
        textView.setVisibility(View.GONE);
        textType.setVisibility(View.GONE);
        textAccessibility.setVisibility(View.GONE);
        textPrice.setVisibility(View.GONE);
        textPaticipans.setVisibility(View.GONE);
        textlink.setVisibility(View.GONE);

        new BoredApiClient().getBoredAction(new IBoredApiClient.BoredActionCallback() {
            @Override
            public void onSuccess(BoredAction action) {
                textView.setText(action.getActivity());
                textType.setText(action.getType());
                textPrice.setText(Float.toString(action.getPrice()));
                textAccessibility.setText(Float.toString(action.getAccessibility()));
                textPaticipans.setText(Integer.toString(action.getParticipants()));
                textlink.setText(action.getLink());

                setVisible();
                Log.d("ololo", "Responce "+action.getActivity());
            }

            @Override
            public void onFailure(Exception e) {
                Log.d("ololo", "Failure"+e.getMessage());
              progressBar.setVisibility(View.GONE);
            }
        });
    }
    private void setVisible(){
        textView.setVisibility(View.VISIBLE);
        textType.setVisibility(View.VISIBLE);
        textAccessibility.setVisibility(View.VISIBLE);
        textPrice.setVisibility(View.VISIBLE);
        textPaticipans.setVisibility(View.VISIBLE);
        textlink.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }
}
