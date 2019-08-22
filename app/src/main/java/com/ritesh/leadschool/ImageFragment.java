package com.ritesh.leadschool;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ImageFragment extends Fragment {

    private Bitmap bitmap;

    @BindView(R.id.res_photo)
    ImageView resPhoto;

    @BindView(R.id.res_photo_size)
    TextView resPhotoSize;

    @BindView(R.id.iv_back)
    ImageView iv_back;

    @BindView(R.id.btn_retake)
    Button btn_retake;

    public void imageSetupFragment(Bitmap bitmap) {
        if (bitmap != null) {
            this.bitmap = bitmap;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_image, container, false);
        ButterKnife.bind(this, view);
        //check if bitmap exist, set to ImageView
        if (bitmap != null) {
            resPhoto.setImageBitmap(bitmap);
            String info = "image with:" + bitmap.getWidth() + "\n" + "image height:" + bitmap.getHeight();
            resPhotoSize.setText("Before proceeding make sure that the data on the image is not blurred and entirely visible to you. Click 'retack' if you want to upload the image again.");
        }


        iv_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getActivity().onBackPressed();
//                Log.e("click","Back");
            }
        });

        btn_retake.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getActivity().onBackPressed();
//                Log.e("click","Back");
            }
        });


        return view;
    }

}
