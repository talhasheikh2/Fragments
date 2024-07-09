package com.example.myfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ToggleButton;

class MyFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the fragment layout
        return inflater.inflate(R.layout.activity_main, container, false);
    }
}

public class MainActivity extends AppCompatActivity {


    private ToggleButton toggleButton;
    private Fragment fragment;
    private FrameLayout fragmentContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton = findViewById(R.id.toggle_button);
        fragmentContainer = findViewById(R.id.fragment_container);

        // Create your fragment instance here (assuming MyFragment)
        fragment = new MyFragment();

        // Initially hide the fragment
        fragmentContainer.setVisibility(View.GONE);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Show the fragment
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.fragment_container, fragment)
                            .commit();
                    fragmentContainer.setVisibility(View.VISIBLE);
                } else {
                    // Hide the fragment
                    getSupportFragmentManager().beginTransaction()
                            .remove(fragment)
                            .commit();
                    fragmentContainer.setVisibility(View.GONE);
                }
            }
        });
    }
}