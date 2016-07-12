package com.example.yg.helloworld;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yg on 2016/4/21.
 */
public class LandscapeFragment extends Fragment{
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        return inflater.inflate(R.layout.landscape_fragment,container,false);
    }
}
