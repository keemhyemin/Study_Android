package com.example.project02_lastproject.member;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.example.project02_lastproject.MainActivity;
import com.example.project02_lastproject.R;
import com.example.project02_lastproject.common.CommonConn;
import com.example.project02_lastproject.common.CommonVar;
import com.example.project02_lastproject.databinding.ActivityLoginBinding;
import com.google.gson.Gson;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.model.ClientErrorCause;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.User;
import com.navercorp.nid.NaverIdLoginSDK;
import com.navercorp.nid.oauth.NidOAuthLogin;
import com.navercorp.nid.oauth.OAuthLoginCallback;
import com.navercorp.nid.profile.NidProfileCallback;
import com.navercorp.nid.profile.data.NidProfileResponse;

import java.nio.file.attribute.UserPrincipal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

public class LoginActivity extends AppCompatActivity {
    // and/login?id=dev&password=dev
    // 구글 로그인은 혼자 해보기 ( 구글 개발자 콘솔 등록되어야 함)
    ActivityLoginBinding binding;
    SharedPreferences pref; // 자바 변수나 static 등의 멤버로 데이터를 저장하면 앱을 다시 실행시 처음부터 불러 옴 (DB)
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        KakaoSdk.init(this, "fea29372ced23857f31828bfb55189c2");
        NaverIdLoginSDK.INSTANCE.initialize(this, "B3s24AoajGMSIaSNBqE5", "7kQK0jEHZF", "Project02_LastProject");
        naverLogin();
        binding.btnLogin.setOnClickListener(v -> {
            login();
        });

        Log.d("키해시", "login: " + getKeyHash(this));

        binding.imgvKakaologin.setOnClickListener(v -> {
            kakaoLogin(this);
        });

        pref = getPreferences(MODE_PRIVATE);
        editor = pref.edit(); // 데이터를 넣거나 수정하기 위한 객체

        pref.getInt("permission", -1);

        // 최초 실행 시 숫자, -1
        // 한번 실행 후 -> ?
        // 두번 실행 후 -> ?
        // 거절 ->
        // 승인 ->

        if(pref.getInt("permission", -1) == -1) {
            checkPermission();
        }

    }

    public void login() {
        if (binding.edtId.getText().toString().length() < 1
                || binding.edtPw.getText().toString().length() < 1) {
            Toast.makeText(this, "아이디 또는 패스워드를 입력하세요.", Toast.LENGTH_SHORT).show();
            return;
        }
        CommonConn conn = new CommonConn(this, "and/login");
        conn.addParamMap("id", binding.edtId.getText().toString());
        conn.addParamMap("password", binding.edtPw.getText().toString());
        conn.onExcute((isResult, data) -> {
            if (isResult) {
                CommonVar.loginInfo = new Gson().fromJson(data, AndMemberVO.class);
                if (CommonVar.loginInfo == null) {
                    Toast.makeText(this, "아이디 또는 비밀번호를 확인하세요.", Toast.LENGTH_SHORT).show();
                } else {
                    // CommonVar.loginInfo = vo;
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void naverLogin() {
        binding.buttonOAuthLoginImg.setOAuthLogin(new OAuthLoginCallback() {
            @Override
            public void onSuccess() {
                Log.d("네이버", "onSuccess: " + NaverIdLoginSDK.INSTANCE.getAccessToken());
                new NidOAuthLogin().callProfileApi(new NidProfileCallback<NidProfileResponse>() {
                    @Override
                    public void onSuccess(NidProfileResponse res) {
                        Log.d("네이버", "onSuccess: " + res.getProfile().getEmail());
                        Log.d("네이버", "onSuccess: " + res.getProfile().getNickname());
                    }

                    @Override
                    public void onFailure(int i, @NonNull String s) {

                    }

                    @Override
                    public void onError(int i, @NonNull String s) {

                    }
                });
            }

            @Override
            public void onFailure(int i, @NonNull String s) {
                Log.d("네이버", "onFailure: ");
            }

            @Override
            public void onError(int i, @NonNull String s) {
                Log.d("네이버", "onError: ");
            }
        });
    }

    public void kakaoLogin(Context context) {
        // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인(웹뷰)
        // Kotlin은 경우에 따라서 생성자 대신에 메소드로 객체를 리턴 받는다. UserApiClient name = new ... x => UserApiClient.{ static UserApiClient.method )

        Function2<OAuthToken, Throwable, Unit> callback = (token, error) -> {
            if (error == null) {
                getKakaoProfile();
            } else {
                Log.d("카카오", "kakaoLogin: 오류발생 " + error.getMessage());
            }
            return null;
        };

        if (UserApiClient.getInstance().isKakaoTalkLoginAvailable(context)) {
            Log.d("카카오", "isKakaoTalkLoginAvailable: true");
            UserApiClient.getInstance().loginWithKakaoTalk(context, callback);
        } else {
            Log.d("카카오", "isKakaoTalkLoginAvailable: false");
            UserApiClient.getInstance().loginWithKakaoAccount(context, callback);
        }

    }

    public void getKakaoProfile() {
        UserApiClient.getInstance().me((user, error) -> {
            if (error == null) {
                Log.d("카카오", "getKakaoProfile: " + user.toString());
                Log.d("카카오", "getKakaoProfile: " + user.getKakaoAccount().getEmail());
                Log.d("카카오", "getKakaoProfile: " + user.getKakaoAccount().getProfile().getNickname());
                Log.d("카카오", "getKakaoProfile: " + user.getKakaoAccount().getProfile().getThumbnailImageUrl());
            }
            return null;
        });
    }


    public static String getKeyHash(final Context context) {
        PackageManager pm = context.getPackageManager();
        try {
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES);
            if (packageInfo == null)
                return null;

            for (Signature signature : packageInfo.signatures) {
                try {
                    MessageDigest md = MessageDigest.getInstance("SHA");
                    md.update(signature.toByteArray());
                    return android.util.Base64.encodeToString(md.digest(), android.util.Base64.NO_WRAP);
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 나중에 재사용 가능하게 commonMethod등의 클래스 내부에 넣어두면 좋음.
    private final int REQ_PERMISSION = 1000;
    private final int REQ_PERMISSION_DENY = 1001;

    private void checkPermission() {
//        editor.putInt("permission", 0); // 데이터 0이 들어감.
//        editor.apply(); // 데이터를 확실히 넣어줌.
        int permission = pref.getInt("permission", -1);
        permission++;
        editor.putInt("permission", permission);
        editor.apply();

        String[] permissions = {Manifest.permission.CAMERA,
                                Manifest.permission.ACCESS_MEDIA_LOCATION,
                                Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE
        }; // 카메라 권한을 String으로 가져옴.
        // ContextCompat(액티비티가 아닌 곳에서 할 때), ActivityCompat (액티비티)
        for (int i = 0; i < permissions.length; i++) {
            // 내가 모든 권한이 필요하다면 전체 권한을 하나씩 체크해서 허용 안됨이 있는 경우 다시 요청을 하게 만든다.
            if (ActivityCompat.checkSelfPermission(this, permissions[i]) == PackageManager.PERMISSION_DENIED) {
                if(ActivityCompat.shouldShowRequestPermissionRationale(this , permissions[i])) {
                    // 최초 앱이 설치되고 실행 시 false가 나옴 => 사용자가 거부 후 true 재거부 => false
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("권한 요청").setMessage("권한이 반드시 필요합니다!! 미허용시 앱 사용 불가!");
                    builder.setPositiveButton("확인(권한허용)" , (dialog, which) -> {
                        // 2. 권한 설명 후 다시 보여줌
                        ActivityCompat.requestPermissions(this, permissions, REQ_PERMISSION_DENY);
                    });
                    builder.setNegativeButton("종료(권한허용불가)", (dialog, which) -> {
                       finish();
                    });
                    builder.create().show(); // <= 넣어줘야 함.
                }else {
                    // 1.
                    ActivityCompat.requestPermissions(this, permissions, REQ_PERMISSION);
                }
                break;
            }
        }

//        int result = ActivityCompat.checkSelfPermission(this, permissions[0]);
//        Log.d("권한", "checkPermission: " + result);
//        Log.d("권한", "checkPermission: " + PackageManager.PERMISSION_GRANTED);
//        Log.d("권한", "checkPermission: " + PackageManager.PERMISSION_DENIED);
//
//        if(ActivityCompat.shouldShowRequestPermissionRationale(this , permissions[0])){
//            Log.d("권한", "shouldShowRequestPermissionRationale: 설명이 필요한 권한. ");
//            ActivityCompat.requestPermissions(this,permissions , REQ_PERMISSION);
//        }else{
//            Log.d("권한", "shouldShowRequestPermissionRationale: 설명이 x");
//            ActivityCompat.requestPermissions(this,permissions , REQ_PERMISSION);
//        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (REQ_PERMISSION == requestCode) {
            for(int i = 0; i < grantResults.length; i++) {
                if(grantResults[i] == PackageManager.PERMISSION_DENIED) {
                    // 거절된 권한이 있음.
                    checkPermission();
                }
            }
            Log.d("권한", "onRequestPermissionsResult: 권한 요청 완료 ");
        } else if(REQ_PERMISSION_DENY == requestCode) {
            for(int i = 0; i < grantResults.length; i++) {
                if(grantResults[i] == PackageManager.PERMISSION_DENIED) {
                    Log.d("권한", "onRequestPermissionsResult: 다시 권한요청 화면을 띄울 수가 없음. 2회 거절 당함.");
                    editor.putInt("permission", -2);
                    // 3.
                    viewSetting();
                    // checkPermission();
                }
            }
        }
    }

    public void viewSetting() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse("package:" + getApplicationContext().getPackageName()));
        startActivity(intent);
    }
}