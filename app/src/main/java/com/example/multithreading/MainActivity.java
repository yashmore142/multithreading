package com.example.multithreading;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btndownload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        clicklistener();
    }
    public void initView(){
        btndownload=findViewById(R.id.btndownload);
    }
    public void clicklistener(){
        btndownload.setOnClickListener(new btndownloadClickListener());
    }
    class btndownloadClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
    new doownloadThread().execute((String) null);
        }
    }
    private class doownloadThread extends AsyncTask<String,Integer,Float>{
        private ProgressDialog progressDialog;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog=new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("BGMI");
            progressDialog.setMessage("Fetteching Data....");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
           // progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.show();

        }
        @Override
        protected Float doInBackground(String... input) {
          for (int i=0;i<=100;i++){
              Log.e("tag",i+"%");
              progressDialog.setProgress(i);
              try {
                  Thread.sleep(100);
              }
              catch (InterruptedException e){
                  e.printStackTrace();
              }
          }
          return null;
        }

    }
}