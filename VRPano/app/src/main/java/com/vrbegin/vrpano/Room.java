package com.vrbegin.vrpano;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.vr.sdk.widgets.pano.VrPanoramaView;


public class Room extends Fragment {
    private OnRoomListener listener;
    private ImageLoaderTask backgroundImageLoaderTask;
    private VrPanoramaView pano;

    public Room() {
    }
    public static Room newInstance() {
        Room fragment = new Room();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.room, container,false);
        return v;

    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        pano = (VrPanoramaView) view.findViewById(R.id.pano_view);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadPanoImage();
    }
    @Override
    public void onResume() {
        pano.resumeRendering();
        super.onResume();
    }
    @Override
    public void onPause() {
        pano.pauseRendering();
        super.onPause();
    }
    @Override
    public void onDestroy() {
        pano.shutdown();
        super.onDestroy();
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnRoomListener) {
            listener = (OnRoomListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
    private synchronized void loadPanoImage() {
        ImageLoaderTask task = backgroundImageLoaderTask;
        if (task != null && !task.isCancelled()) {
            task.cancel(true);
        }
        VrPanoramaView.Options viewOptions = new VrPanoramaView.Options();
        viewOptions.inputType = VrPanoramaView.Options.TYPE_STEREO_OVER_UNDER;
        String panoImageName = "pano.jpg";
        task = new ImageLoaderTask(pano, viewOptions, panoImageName);
        task.execute(getActivity().getAssets());
        backgroundImageLoaderTask = task;
    }
    public interface OnRoomListener {
        void onRoom(Uri uri);
    }
}
