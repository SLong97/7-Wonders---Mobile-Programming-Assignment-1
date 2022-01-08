package com.example.thesevenwonders;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

public class wonderFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_wonder, container, false);
        MediaController mc = new MediaController(getActivity());
        String path = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.the7wonders;
        VideoView view = (VideoView) rootView.findViewById(R.id.video_view);
        view.setVideoURI(Uri.parse(path));
        view.setMediaController(mc);
        view.start();


        // Inflate the layout for this fragment
        return rootView;
    }




}