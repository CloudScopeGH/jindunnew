package com.cloudspace.jindun.fragment;


import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cloudspace.jindun.R;
import com.cloudspace.jindun.activity.Woyao.CellActivitye;
import com.cloudspace.jindun.activity.Woyao.NameAlterActivitye;
import com.cloudspace.jindun.activity.Woyao.PassActivitye;
import com.cloudspace.jindun.activity.Woyao.SystemSettingsActivity;
import com.cloudspace.jindun.ui.RoundCornerImageView;
import com.cloudspace.jindun.window.SelectPicPopupWindow;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuLeftFragment extends Fragment {


    @Bind(R.id.drawer_image_head)
    RoundCornerImageView mDrawerImageHead;
    @Bind(R.id.drawer_text_name)
    TextView mDrawerTextName;
    @Bind(R.id.drawer_image_phone)
    ImageView mDrawerImagePhone;
    @Bind(R.id.drawer_text_phone)
    TextView mDrawerTextPhone;
    @Bind(R.id.drawer_collect_r2)
    RelativeLayout mDrawerCollectR2;
    @Bind(R.id.drawer_image_pass)
    ImageView mDrawerImagePass;
    @Bind(R.id.drawer_text_pass)
    TextView mDrawerTextPass;
    @Bind(R.id.drawer_collect_r3)
    RelativeLayout mDrawerCollectR3;
    @Bind(R.id.drawer_text_sys)
    TextView mDrawerTextSys;

    RelativeLayout mMain;
    private SelectPicPopupWindow menuWindow;

    public MenuLeftFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_left, container, false);

        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.drawer_image_head, R.id.drawer_text_name, R.id.drawer_collect_r2, R.id.drawer_collect_r3, R.id.drawer_text_sys})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.drawer_image_head:
                /** TODO
                 * 弹窗
                 * */
                showDialog(getContext());
                break;
            case R.id.drawer_text_name:
                Intent intentName = new Intent();
                intentName.setClass(getContext(), NameAlterActivitye.class);
                startActivity(intentName);
                break;
            case R.id.drawer_collect_r2:
                Intent intentCall = new Intent();
                intentCall.setClass(getContext(), CellActivitye.class);
                startActivity(intentCall);
                break;
            case R.id.drawer_collect_r3:
                Intent intentPass = new Intent();
                intentPass.setClass(getContext(), PassActivitye.class);
                startActivity(intentPass);
                break;
            case R.id.drawer_text_sys:
                Intent intentSys = new Intent();
                intentSys.setClass(getContext(), SystemSettingsActivity.class);
                startActivity(intentSys);
                break;
        }
    }

    private View.OnClickListener itemsOnClick = new View.OnClickListener() {

        public void onClick(View v) {
            menuWindow.dismiss();
            switch (v.getId()) {
                case R.id.btn_take_photo:
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2);
                        Intent intent2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                        startActivityForResult(intent2, 2);
                    } else {
                        Intent intent2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                        startActivityForResult(intent2, 2);
                    }

                    break;
                case R.id.btn_pick_photo:
                    Intent intent = new Intent();
                    //intent = new Intent(Intent.ACTION_GET_CONTENT);
                /* 开启Pictures画面Type设定为image */
                    intent.setType("image/*");
                /* 使用Intent.ACTION_GET_CONTENT这个Action */
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                /* 取得相片后返回本画面 */
                    startActivityForResult(intent, 1);
                    break;
                default:
                    break;
            }
        }

    };

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // TODO Auto-generated method stub
        if (requestCode == 1) {
            Uri selectedImage = data.getData();
            try {

                Bitmap bitmap = BitmapFactory.decodeStream(getContext()
                        .getContentResolver().openInputStream(Uri.parse(selectedImage.toString())));
                mDrawerImageHead.setImageBitmap(bitmap);
                Toast.makeText(getContext(), "上传成功",
                        Toast.LENGTH_SHORT).show();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (requestCode == 2) {

            String sdStatus = Environment.getExternalStorageState();
            if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) { // 检测sd是否可用
                Log.i("TestFile",
                        "SD card is not avaiable/writeable right now.");
                return;
            }

            //.format("yyyyMMdd_hhmmss", Calendar.getInstance(Locale.CHINA)) + ".jpg";
            Bundle bundle = data.getExtras();
            Bitmap bitmap = (Bitmap) bundle.get("data");// 获取相机返回的数据，并转换为Bitmap图片格式

            FileOutputStream b = null;
            File file = new File("/sdcard/myImage/");
            file.mkdirs();// 创建文件夹
            String fileName = "/sdcard/myImage/" + "111";

            try {
                b = new FileOutputStream(fileName);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文件
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    b.flush();
                    b.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            mDrawerImageHead.setImageBitmap(bitmap);
            ;// 将图片显示在ImageView里
        }

    }
    public  Dialog showDialog(final Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.alert_dialog, null);

        final Dialog dialog = new AlertDialog.Builder(context).setView(view).create();

        dialog.show();
        Button take= (Button) view.findViewById(R.id.btn_take_photo);
        Button pick= (Button) view.findViewById(R.id.btn_pick_photo);
        final Button cancel= (Button) view.findViewById(R.id.btn_cancel);
        take.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "11111", Toast.LENGTH_SHORT).show();
            }
        });
        pick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "22222", Toast.LENGTH_SHORT).show();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        return dialog;
    }
}
