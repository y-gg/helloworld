package com.example.yg.helloworld;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by yg on 2016/4/27.
 */
public class NewActivity extends AppCompatActivity implements DFragment.MyListener{
    TextView textView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);
        final Bundle bundle = this.getIntent().getExtras();
        String name = bundle.getString("name");
        textView = (TextView)findViewById(R.id.name);
        textView.setText(name);
        Intent intent = new Intent();
        bundle.putString("yg", "snail");
        intent.putExtras(bundle);
        this.setResult(1, intent);
        final EditText editText = (EditText) findViewById(R.id.text);
        final TextView view = (TextView) findViewById(R.id.fragmenttext);
        Button button = (Button) findViewById(R.id.chenge);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setText("chenged");
            }
        });
        Button btn = (Button) findViewById(R.id.fragmentin);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                DFragment fragment = new DFragment();
                Bundle bundle1 = new Bundle();
                bundle.putString("name",text);
                fragment.setArguments(bundle);
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.frag,fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });
    }

    @Override
    public void getDate(String text) {
        textView.setText(text);
    }
}
