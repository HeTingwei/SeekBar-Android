package com.xingyi.seekbartest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar1;//自定形状
    SeekBar seekBar2;//使用图片
    TextView textView,textView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        seekBar1= (SeekBar) findViewById(R.id.seekBar1);
        textView= (TextView) findViewById(R.id.textView);
        seekBar1.setMax(99);//设置最大进度(默认100)，这里的进度为0~10，可以在布局文件中设置
        seekBar1.setProgress(22);//设置开始时的进度，默认为0，可以在布局文件中设置
        textView.setText(seekBar1.getProgress()+"");//获取进度
       // seekBar1.setThumb(getDrawable(R.drawable.seek_bar_thumb));//设置滑块，可在布局文件中设置
       // seekBar1.setProgressDrawable(getDrawable(R.drawable.seek_bar_progess));//设置滑轨，可在布局文件中设置

        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //当滑块位置改变i的值时调用
                textView.setText(i+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //点击滑块，并且开始滑动时调用
                Toast.makeText(MainActivity.this, "start slide", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //松开滑块时调用
                Toast.makeText(MainActivity.this, "stop slide", Toast.LENGTH_SHORT).show();
            }
        });

        seekBar2= (SeekBar) findViewById(R.id.seekBar2);
        textView4= (TextView) findViewById(R.id.textView4);
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textView4.setText("进度："+i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
