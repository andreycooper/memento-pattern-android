package by.cooper.memento;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void onWithoutMementoClick(View view) {
        startActivity(new Intent(this, SimpleActivity.class));
    }

    public void onMementoClick(View view) {
        startActivity(new Intent(this, MementoActivity.class));
    }
}
