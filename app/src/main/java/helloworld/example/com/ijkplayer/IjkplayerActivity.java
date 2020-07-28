package helloworld.example.com.ijkplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class IjkplayerActivity extends AppCompatActivity {

    private JCVideoPlayerStandard jcVideoPlayerStandard;
    private JCVideoPlayerStandard jcVideoPlayerStandard1;
    String s1="http://ips.ifeng.com/video19.ifeng.com/video09/2014/06/16/1989823-102-086-0009.mp4";
    String s2="http://player.youku.com/player.php/sid/XMjUyODI2NDc2MA==/v.swf";//不支持swf格式的视频播放
    String s3="http://ips.ifeng.com/video19.ifeng.com/video09/2014/06/16/1989823-102-086-0009.mp4";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ijkplayer);

        getSupportActionBar().setTitle("BoBrother");
        jcVideoPlayerStandard= (JCVideoPlayerStandard) findViewById(R.id.jiecao_Player);
        jcVideoPlayerStandard1 = findViewById(R.id.jiecao_Player1);
        jcVideoPlayerStandard.setUp(s1,jcVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,"牛逼");
        jcVideoPlayerStandard1.setUp(s3,jcVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,"好用");
    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()){
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
