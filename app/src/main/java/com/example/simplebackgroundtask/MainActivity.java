package com.example.simplebackgroundtask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.net.ssl.HttpsURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;

    private Handler mHandler;
    private ProgressBar progressBar;
    private ProgressBar progressBar2;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textView1);
        progressBar = findViewById(R.id.progressBar);
        progressBar2 = findViewById(R.id.progressBar2);
        button = findViewById(R.id.button);
        mHandler = new Handler();


    }

    public void startTask(View view) {
        mTextView.setText(R.string.loading);
        progressBar.setVisibility((View.VISIBLE));
        progressBar2.setVisibility((View.VISIBLE));
        button.setVisibility(View.INVISIBLE);
        int n = new Random().nextInt(11);
        int s = 1000 + n * 400;

//        new Thread(()->{
//
//            try {
//                URL url = new URL("https://gorest.co.in/public/v2/users");
//                HttpsURLConnection httpsConnection = (HttpsURLConnection) url.openConnection();
//                httpsConnection.setRequestMethod("GET");
//
//                BufferedReader in = new BufferedReader(new InputStreamReader(httpsConnection.getInputStream()));
//                String inputLine;
//                StringBuffer response = new StringBuffer();
//                while ((inputLine = in.readLine()) != null) {
//                    response.append(inputLine);
//                }
//                in.close();
//
//                mHandler.post(()->{
//                    progressBar.setVisibility((View.INVISIBLE));
//
//                    mTextView.setText(response);
//                });
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//
//            try {
//                for (int i = 0; i < 100; i++) {
//                    Thread.sleep(s/100);
//                    int finalI = i;
//                    mHandler.post(()->{
//                        progressBar2.setProgress(finalI);
//                    });
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        }).start();

//        APIClient.getAPI().getAllUsers().enqueue(new Callback<ArrayList<User>>() {
//            @Override
//            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
//                ArrayList<User> userList = response.body();
//                mTextView.setText("Number of Users: " + userList.size());
//                progressBar.setVisibility((View.INVISIBLE));
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<User>> call, Throwable t) {
//                mTextView.setText("Error:" + t.getMessage());
//                progressBar.setVisibility((View.INVISIBLE));
//            }
//        });

//        APIClient.getAPI().getUsersByID(2327).enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                User user = response.body();
//                mTextView.setText(user.name);
//                progressBar.setVisibility((View.INVISIBLE));
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//                mTextView.setText("Error:" + t.getMessage());
//                progressBar.setVisibility((View.INVISIBLE));
//            }
//        });

//            User user = new User();
//            user.id = 3453;
//            user.name = "Trinh Van Quyet";
//            user.email = "quyet@test.com";
//            user.gender = "male";
//            user.status = "Active";
//            System.out.println(user.id);
//
//            APIClient.getAPI().addUser(user).enqueue(new Callback<User>() {
//                @Override
//                public void onResponse(Call<User> call, Response<User> response) {
////                    User user = response.body();
//                    System.out.println(user);
//                    mTextView.setText("User ID: " + user.id);
//                }
//
//                @Override
//                public void onFailure(Call<User> call, Throwable t) {
//                    mTextView.setText("Error:" + t.getMessage());
//                }
//            });


//        APIClient.getAPI().deleteUser(2327).enqueue(new Callback<Void>() {
//            @Override
//            public void onResponse(Call<Void> call, Response<Void> response) {
//                //Toast.makeText(MainActivity.this, response.code()+"t", Toast.LENGTH_LONG).show();
//                Toast.makeText(MainActivity.this, "Delete successfully", Toast.LENGTH_LONG).show();
//                finish();
//                startActivity(getIntent());
//
//            }
//
//            @Override
//            public void onFailure(Call<Void> call, Throwable t) {
//                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
//            }
//        });

        User user = new User("Trinh Van Quyet", "quyet676767@test.com", "male", "Active");

        APIClient.getAPI().updateUser(2323, user).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(MainActivity.this, "Updated", Toast.LENGTH_LONG).show();
                finish();
                startActivity(getIntent());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }
}