    package com.example.mvp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Contract.View {

    private TextView textView;
    private ProgressBar progressBar;
    private Button button;
    Contract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewsFinderById();

        presenter = new Presenter(this, new Model());
        button.setOnClickListener(v -> presenter.onButtonClick());
    }


    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        textView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
        textView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setString(String string) {
        textView.setText(string);
    }















    private void viewsFinderById(){
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button_name);
        progressBar = findViewById(R.id.progressBar);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        presenter.onDestroy();
    }


}