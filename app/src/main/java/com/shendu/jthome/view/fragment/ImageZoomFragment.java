package com.shendu.jthome.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.shendu.jthome.R;
import com.shendu.jthome.http.VolleyHttpRequest;
import com.shendu.jthome.view.activity.ImageZoom;
import com.shendu.jthome.view.myview.imageview.ZoomImageView;


public class ImageZoomFragment extends Fragment {

    private int position = 0;
    private ZoomImageView imageView;


    public static ImageZoomFragment newInstance(int position) {
        ImageZoomFragment f = new ImageZoomFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        f.setArguments(args);
        return f;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt("position");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_image_zoom, container, false);
        imageView = (ZoomImageView) v.findViewById(R.id.imageView);
        VolleyHttpRequest.imageLoader(ImageZoom.pic_url[position], imageView, 0, 0);
        imageView.setScaleType(ImageView.ScaleType.MATRIX);

        return v;
    }


}
