package com.example.rr;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.learn.R;

public class SettingsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        View aboutView = view.findViewById(R.id.AboutView1);
        View termsView = view.findViewById(R.id.termsBar);
        View privacyView = view.findViewById(R.id.PrivacyView);
        View shareView = view.findViewById(R.id.shareview);

        aboutView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment= new aboutPage();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.settingsFrame, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        termsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment= new termsPage();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.settingsFrame, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        privacyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment= new privacyPage();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.settingsFrame, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        shareView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain"); // Set MIME type to text/plain for sharing text
                String body = "Download This App";
                String sub = "https://www.youtube.com/watch?v=i41rmT-GDXc"; // This is the subject
                intent.putExtra(Intent.EXTRA_TEXT, body); // Set the body of the message
                intent.putExtra(Intent.EXTRA_SUBJECT, sub); // Set the subject of the message
                startActivity(Intent.createChooser(intent, "Share using: "));
            }
        });
        return view;
    }
}