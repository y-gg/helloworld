package com.example.yg.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;
//1
public class MainActivity extends AppCompatActivity {
    String msg = "Android : ";
    /***活动第一次被创建时调用**/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                       .setAction("Action", null).show();
            }
        });
        Log.d(msg, "The onCreate() event");
        Button toActivity = (Button)findViewById(R.id.toActivity);
        toActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("name","yg");
                Intent intent = new Intent();
                intent.putExtras(bundle);
                intent.setClass(MainActivity.this,NewActivity.class);
                startActivityForResult(intent,1);
            }
        });

        Button btnViewpager = (Button) findViewById(R.id.toViewPager);
        btnViewpager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,Viewpager.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1) {
            String yg = data.getExtras().getString("yg");
            Toast.makeText(MainActivity.this, "yg:"+yg, Toast.LENGTH_SHORT).show();
        }
    }

    public void startService(View view){
        startService(new Intent(getBaseContext(), MyService.class));
    }
    public void stopService(View view){
        stopService(new Intent(getBaseContext(), MyService.class));
    }
    public void broadcastIntent(View view){
        Intent intent = new Intent();
        intent.setAction("yg.example.CUSTOM_INTENT");
        sendBroadcast(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
