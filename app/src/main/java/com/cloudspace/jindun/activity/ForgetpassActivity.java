package com.cloudspace.jindun.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.cloudspace.jindun.R;

import java.io.FileNotFoundException;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


//忘记密码
public class ForgetpassActivity extends CustomTitleBaseActivity {

    @Bind(R.id.back)
    ImageView mBack;
    @Bind(R.id.forget_et_id)
    EditText mForgetEtId;
    @Bind(R.id.forget_bt_addImage)
    Button mForgetBtAddImage;
    @Bind(R.id.forget_bt_present)
    Button mForgetBtPresent;

    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpass, false);
        ButterKnife.bind(this);
        iv = (ImageView) findViewById(R.id.forget_iv_text);
    }

    @OnClick({R.id.back, R.id.forget_bt_addImage, R.id.forget_bt_present})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.forget_bt_addImage:
                Intent intent = new Intent();
                //intent = new Intent(Intent.ACTION_GET_CONTENT);
                /* 开启Pictures画面Type设定为image */
                intent.setType("image/*");
                /* 使用Intent.ACTION_GET_CONTENT这个Action */
                intent.setAction(Intent.ACTION_GET_CONTENT);
                /* 取得相片后返回本画面 */
                startActivityForResult(intent, 1);
                break;
            case R.id.forget_bt_present:
                Toast.makeText(ForgetpassActivity.this, "222", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        //if (requestCode  == REQUEST_OK) {
        Uri selectedImage = data.getData();
        try {
            Bitmap bitmap = BitmapFactory.decodeStream(this
                    .getContentResolver().openInputStream(Uri.parse(selectedImage.toString())));
            iv.setImageBitmap(bitmap);
            Toast.makeText(getApplicationContext(), "上传成功",
                    Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //  }
        super.onActivityResult(requestCode, resultCode, data);
    }

}
