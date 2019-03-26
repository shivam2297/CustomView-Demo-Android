package com.example.shivam.customviewsdemo.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.shivam.customviewsdemo.R;
import com.example.shivam.customviewsdemo.custom_views.MyCustomSquareView;

public class CustomSquareFragment extends Fragment {

    private MyCustomSquareView mCustomView;
    private BottomNavigationView mBottomNavBar;
    private boolean colorDefault = true;

    public CustomSquareFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_custom_square, container, false);
        mCustomView = view.findViewById(R.id.custom_view);
        mBottomNavBar = view.findViewById(R.id.bottom_navbar);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mBottomNavBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.padding_up:
                        mCustomView.setCustomPadding(-30);
                        break;
                    case R.id.swap_color:
                        mCustomView.swapColor(colorDefault);
                        colorDefault = !colorDefault;
                        break;
                    case R.id.padding_down:
                        mCustomView.setCustomPadding(30);
                        break;
                }

                return true;
            }
        });
    }
}
