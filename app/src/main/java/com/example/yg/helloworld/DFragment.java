package com.example.yg.helloworld;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by yg on 2016/4/27.
 */
public class DFragment extends Fragment {
    static String txt = "hello,ygfdf";
    private MyListener listener;
    public interface MyListener{
        public void getDate(String text);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment,container,false);
        TextView textView = (TextView) view.findViewById(R.id.fragmenttext);
        Button btn = (Button) view.findViewById(R.id.chenge);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "yg,hello", Toast.LENGTH_SHORT).show();
            }
        });
        Bundle bundle = getArguments();
        String text = bundle.getString("name");
        textView.setText(text);
        listener.getDate(txt);
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        listener = (MyListener) activity;
    }
}
