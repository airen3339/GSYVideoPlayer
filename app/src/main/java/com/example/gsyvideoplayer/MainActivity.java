package com.example.gsyvideoplayer;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.gsyvideoplayer.databinding.ActivityListVideoBinding;
import com.example.gsyvideoplayer.databinding.ActivityMainBinding;
import com.example.gsyvideoplayer.simple.SimpleActivity;
import com.example.gsyvideoplayer.utils.JumpUtils;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.player.IjkPlayerManager;
import com.shuyu.gsyvideoplayer.player.PlayerFactory;
import com.shuyu.gsyvideoplayer.player.SystemPlayerManager;
import com.shuyu.gsyvideoplayer.utils.Debuger;

import permissions.dispatcher.PermissionUtils;
import tv.danmaku.ijk.media.exo2.Exo2PlayerManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    ActivityMainBinding binding;

    final String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        View rootView = binding.getRoot();
        setContentView(rootView);

        Debuger.enable();

        binding.openBtn.setOnClickListener(this);
        binding.listBtn.setOnClickListener(this);
        binding.listBtn2.setOnClickListener(this);
        binding.listDetail.setOnClickListener(this);
        binding.clearCache.setOnClickListener(this);
        binding.recycler.setOnClickListener(this);
        binding.recycler2.setOnClickListener(this);
        binding.recycler2.setOnClickListener(this);
        binding.listDetailList.setOnClickListener(this);
        binding.webDetail.setOnClickListener(this);
        binding.danmakuVideo.setOnClickListener(this);
        binding.fragmentVideo.setOnClickListener(this);
        binding.moreType.setOnClickListener(this);
        binding.inputType.setOnClickListener(this);
        binding.openBtnEmpty.setOnClickListener(this);
        binding.openControl.setOnClickListener(this);
        binding.openFilter.setOnClickListener(this);
        binding.openBtnPick.setOnClickListener(this);
        binding.openBtnAuto.setOnClickListener(this);
        binding.openScroll.setOnClickListener(this);
        binding.openWindow.setOnClickListener(this);
        binding.openBtnAd.setOnClickListener(this);
        binding.openBtnMulti.setOnClickListener(this);
        binding.openBtnAd2.setOnClickListener(this);
        binding.openListAd.setOnClickListener(this);
        binding.openCustomExo.setOnClickListener(this);
        binding.openSimple.setOnClickListener(this);
        binding.openSwitch.setOnClickListener(this);
        binding.mediaCodec.setOnClickListener(this);
        binding.detailNormalActivity.setOnClickListener(this);
        binding.detailDownloadActivity.setOnClickListener(this);
        binding.detailAudioActivity.setOnClickListener(this);
        binding.detailSubtitleActivity.setOnClickListener(this);
        binding.changeCore.setOnClickListener(this);
        binding.viewPager2Activity.setOnClickListener(this);


        boolean hadPermission = PermissionUtils.hasSelfPermissions(this, permissions);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !hadPermission) {
            String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
            requestPermissions(permissions, 1110);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        boolean sdPermissionResult = PermissionUtils.verifyPermissions(grantResults);
        if (!sdPermissionResult) {
            Toast.makeText(this, "????????????sd???????????????????????????????????????", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onClick(View view) {
        Log.e("################# ","################# ");
        switch (view.getId()) {
            case R.id.open_simple:
                //???????????????
                startActivity(new Intent(this, SimpleActivity.class));
                break;
            case R.id.open_btn:
                //???????????????????????????
                JumpUtils.goToVideoPlayer(this, binding.openBtn);
                break;
            case R.id.list_btn:
                //?????????????????????????????????????????????????????????????????????????????????????????????
                JumpUtils.goToVideoPlayer(this);
                break;
            case R.id.list_btn_2:
                //??????????????????????????????????????????????????????????????????
                JumpUtils.goToVideoPlayer2(this);
                break;
            case R.id.recycler:
                //recycler???demo
                JumpUtils.goToVideoRecyclerPlayer(this);
                break;
            case R.id.recycler_2:
                //recycler???demo
                JumpUtils.goToVideoRecyclerPlayer2(this);
                break;
            case R.id.list_detail:
                //?????????????????????????????????
                JumpUtils.goToDetailPlayer(this);
                break;
            case R.id.list_detail_list:
                //????????????????????????
                JumpUtils.goToDetailListPlayer(this);
                break;
            case R.id.web_detail:
                //??????????????????preview
                JumpUtils.gotoWebDetail(this);
                break;
            case R.id.danmaku_video:
                //????????????????????????
                JumpUtils.gotoDanmaku(this);
                break;
            case R.id.fragment_video:
                //????????????????????????
                JumpUtils.gotoFragment(this);
                break;
            case R.id.more_type:
                //??????????????????????????????????????????????????????????????????
                JumpUtils.gotoMoreType(this);
                break;
            case R.id.input_type:
                JumpUtils.gotoInput(this);
                break;
            case R.id.open_btn_empty:
                JumpUtils.goToPlayEmptyControlActivity(this, binding.openBtnEmpty);
                break;
            case R.id.open_control:
                JumpUtils.gotoControl(this);
                break;
            case R.id.open_filter:
                JumpUtils.gotoFilter(this);
                break;
            case R.id.open_btn_pick:
                //????????????
                JumpUtils.goToVideoPickPlayer(this, binding.openBtn);
                break;
            case R.id.open_btn_auto:
                //??????????????????
                JumpUtils.goToAutoVideoPlayer(this);
                break;
            case R.id.open_scroll:
                //??????????????????
                JumpUtils.goToScrollDetailPlayer(this);
                break;
            case R.id.open_window:
                //????????????????????????
                JumpUtils.goToScrollWindow(this);
                break;
            case R.id.open_btn_ad:
                //??????
                JumpUtils.goToVideoADPlayer(this);
                break;
            case R.id.open_btn_multi:
                //??????????????????
                JumpUtils.goToMultiVideoPlayer(this);
                break;
            case R.id.open_btn_ad2:
                //??????????????????
                JumpUtils.goToVideoADPlayer2(this);
                break;
            case R.id.open_list_ad:
                //??????????????????
                JumpUtils.goToADListVideoPlayer(this);
                break;
            case R.id.open_custom_exo:
                //??????????????????
                JumpUtils.goToDetailExoListPlayer(this);
                break;
            case R.id.open_switch:
                JumpUtils.goToSwitch(this);
                break;
            case R.id.media_codec:
                JumpUtils.goMediaCodec(this);
                break;
            case R.id.detail_normal_activity:
                JumpUtils.goToDetailNormalActivity(this);
                break;
            case R.id.detail_download_activity:
                JumpUtils.goToDetailDownloadActivity(this);
                break;
            case R.id.detail_subtitle_activity:
                JumpUtils.goToGSYExoSubTitleDetailPlayer(this);
                break;
            case R.id.detail_audio_activity:
                JumpUtils.goToDetailAudioActivity(this);
                break;
            case R.id.view_pager2_activity:
                JumpUtils.goToViewPager2Activity(this);
                break;
            case R.id.change_core:
                i += 1;
                if (i % 3 == 0) {
                    PlayerFactory.setPlayManager(IjkPlayerManager.class);
                    binding.changeCore.setText("IJK ??????");
                } else if (i % 3 == 1) {
                    PlayerFactory.setPlayManager(Exo2PlayerManager.class);
                    binding.changeCore.setText("EXO ??????");
                } else if (i % 3 == 2) {
                    PlayerFactory.setPlayManager(SystemPlayerManager.class);
                    binding.changeCore.setText("?????? ??????");
                }
                break;
            case R.id.clear_cache:
                //????????????
                GSYVideoManager.instance().clearAllDefaultCache(MainActivity.this);
                //String url = "https://res.exexm.com/cw_145225549855002";
                //GSYVideoManager.clearDefaultCache(MainActivity.this, url);
                break;
        }
    }
}
