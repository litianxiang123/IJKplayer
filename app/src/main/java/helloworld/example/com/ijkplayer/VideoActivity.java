package helloworld.example.com.ijkplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class VideoActivity extends AppCompatActivity implements SurfaceHolder.Callback {

    private SurfaceView video_surface;
    private Button start;
    private Button pause;
    private IjkMediaPlayer mPlayer;
    boolean isPlay;
    private ImageView bofang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        video_surface = findViewById(R.id.video_surface);
        start = findViewById(R.id.start);
        pause = findViewById(R.id.pause);
        bofang = findViewById(R.id.bofang);

        isPlay = false;
        pause.setEnabled(false);
        video_surface.getHolder().addCallback(this);
        initPlayer();

    }

    private void initPlayer() {
        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");
        mPlayer = new IjkMediaPlayer();
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPlayer.reset();
                try {
                    mPlayer.setDataSource("http://ips.ifeng.com/video19.ifeng.com/video09/2014/06/16/1989823-102-086-0009.mp4");
                    mPlayer.prepareAsync();  //预加载视频
                    mPlayer.setDisplay(video_surface.getHolder());  //将视频画面输出到surface上
                    mPlayer.start();                                //开始播放
                    pause.setText("暂停");                        //pause此时为暂停
                    pause.setEnabled(true);                       //pause按钮此时可用
                    isPlay = true;
                }catch (IOException e){
                    Toast.makeText(VideoActivity.this,"发生错误",Toast.LENGTH_LONG).show();
                }
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击暂停时候 如果正在播放 就显示继续按钮
                if (isPlay == true){
                    pause.setText("继续");
                    mPlayer.pause();
                    isPlay = false;
                }else {
                    mPlayer.start();
                    pause.setText("暂停");
                    isPlay = true;
                }
            }
        });

        bofang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // mPlayer.reset();
                try {
                    mPlayer.setDataSource("http://ips.ifeng.com/video19.ifeng.com/video09/2014/06/16/1989823-102-086-0009.mp4");
                    mPlayer.prepareAsync();  //预加载视频
                    mPlayer.setDisplay(video_surface.getHolder());  //将视频画面输出到surface上
                    mPlayer.start();                                //开始播放
                    pause.setText("暂停");                        //pause此时为暂停
                    pause.setEnabled(true);                       //pause按钮此时可用
                    isPlay = true;
                    bofang.setVisibility(View.GONE);
                }catch (IOException e){
                    Toast.makeText(VideoActivity.this,"发生错误",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        mPlayer.setDisplay(surfaceHolder);
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }


}
