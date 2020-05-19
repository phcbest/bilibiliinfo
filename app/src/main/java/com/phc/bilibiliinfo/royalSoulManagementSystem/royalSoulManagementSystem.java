package com.phc.bilibiliinfo.royalSoulManagementSystem;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.phc.bilibiliinfo.R;
import com.phc.bilibiliinfo.utils.FileUtil;
import com.squareup.picasso.Picasso;


public class royalSoulManagementSystem extends Fragment {
    private static final String TAG = "royalSoulManagementSyst";

    private Button fragmentRoyalSoulManagementSystemButton;
    private Button fragmentRoyalSoulManagementSystemButton2;
    private ImageView fragmentRoyalSoulManagementSystemImageView;
    private final int REQUEST_CHOOSEFILE = 111;
    private final int REQUEST_PERMISSION = 100;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_royal_soul_management_system, container, false);
        initView(view);

        //i need button click listener
        fragmentRoyalSoulManagementSystemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //button start up photo activity
                //需要先处理动态权限问题，判断用户是否有授权
                if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
//            进行申请权限,第一个参数为活动，第二个为权限组，第三个为返回码，活动兼容.请求权限许可
                    ActivityCompat.requestPermissions
                            (getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_PERMISSION);
                } else {
                    //有权限许可，进行下面的操作
                    choosePhoto();
                }
            }
        });
        //button2 can get json file
        return view;
    }

    //该方法对相册进行访问
    private void choosePhoto() {
        //use intent jump pick
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(intent, REQUEST_CHOOSEFILE);
    }


    /**
     * this is request permission call back function
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.d(TAG, "onRequestPermissionsResult: "+requestCode);
        switch (requestCode) {
            case REQUEST_PERMISSION:
                //直接进行相册选择图片界面
                Log.d(TAG, "onRequestPermissionsResult: user give permission");
                choosePhoto();
                break;
            default:
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CHOOSEFILE) {
            Uri uri = data.getData();
            String filePath = FileUtil.getFilePathByUri(getContext(), uri);
            if (!TextUtils.isEmpty(filePath)) {
                //get photo with uri 通过 uri 获得图片
                Log.d(TAG, "onActivityResult: " + filePath);
                //show by Picasso
                fragmentRoyalSoulManagementSystemImageView.setVisibility(View.VISIBLE);
                Picasso.get().load(uri).into(fragmentRoyalSoulManagementSystemImageView);

            }
        }
    }

    private void initView(View view) {
        fragmentRoyalSoulManagementSystemButton = (Button) view.findViewById(R.id.fragment_royal_soul_management_system_button);
        fragmentRoyalSoulManagementSystemImageView = (ImageView) view.findViewById(R.id.fragment_royal_soul_management_system_ImageView);
        fragmentRoyalSoulManagementSystemButton2 = (Button) view.findViewById(R.id.fragment_royal_soul_management_system_button2);
    }

}
