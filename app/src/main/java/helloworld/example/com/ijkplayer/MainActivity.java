package helloworld.example.com.ijkplayer;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.widget.media.AndroidMediaController;
import tv.danmaku.ijk.media.widget.media.IjkVideoView;

public class MainActivity extends AppCompatActivity {


    private IjkVideoView mIjvideo;
    private ImageView bofang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIjvideo= (IjkVideoView) findViewById(R.id.ijvideo);
        bofang = findViewById(R.id.bofang);

        initView();
    }

    private void initView() {

        AndroidMediaController controller = new AndroidMediaController(this, false);
        mIjvideo.setMediaController(controller);
        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");

        bofang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 链接
                String url = "http://ips.ifeng.com/video19.ifeng.com/video09/2014/06/16/1989823-102-086-0009.mp4";
                mIjvideo.setVideoURI(Uri.parse(url));
                mIjvideo.start();
                bofang.setVisibility(View.GONE);
            }
        });
    }


}
