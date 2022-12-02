package co.aurasphere.bluepair.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import co.aurasphere.bluepair.R;
import co.aurasphere.bluepair.operation.BluetoothOperation;

public class ShoulderAndWaterFallActivity extends AppCompatActivity {
    private SeekBar seekBarShoulder;
    private TextView tvShoulderTimer;
    private SeekBar seekBarWater;
    private TextView tvSeekBarWater;
    private TextView tvStart;
    //private TextView tvStop;
    private ImageView imgbackBtn;
    private boolean isOn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoulder_and_water_fall);
        getSupportActionBar().hide();
        init();
    }

    private void init(){
        ((TextView)(findViewById(R.id.title1))).setText(getIntent().getStringExtra("title1"));
        ((TextView)(findViewById(R.id.title2))).setText(getIntent().getStringExtra("title2"));
        seekBarWater=findViewById(R.id.water_fall_seek_bar);
        imgbackBtn=findViewById(R.id.shoulder_and_water_fall);
        tvStart=findViewById(R.id.shoulder_and_water_start);
        //tvStop=findViewById(R.id.shoulder_and_water_stop);
        tvSeekBarWater=findViewById(R.id.water_fall_timer);
        tvSeekBarWater.setText("10 Min");
        tvShoulderTimer=findViewById(R.id.shoulder_tv);
        tvShoulderTimer.setText("10 Min");
        seekBarShoulder=(SeekBar) findViewById(R.id.shoulder_seek_bar);
        seekBarShoulder.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tvShoulderTimer.setText(i + " Min");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarWater.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tvSeekBarWater.setText(i + " Min");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        imgbackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        tvStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isOn){
                    isOn = false;
                    String stopCommand=getOffCommand();
                    BluetoothOperation.sendCommand(stopCommand);
                    tvStart.setText("START");
                }
                else {
                    String command = getCommand();
                    BluetoothOperation.sendCommand(command);
                    isOn = true;
                    tvStart.setText("STOP");
                }


            }
        });


    }

    private String getCommand() {
        String command = "#$";
        switch (getIntent().getStringExtra("key1")){
            case "HYDRO":
                command = command + "TOGHYDRO"+seekBarShoulder.getProgress()+"AIR"+seekBarWater.getProgress()+"ON" ;
                break;
            case "SHOULDER":
                command = command + "TOGSHD"+seekBarShoulder.getProgress()+"WAT"+seekBarWater.getProgress()+"ON" ;
                break;
            case "FILL":
                command = command + "CLEANINGONFILL"+seekBarShoulder.getProgress()+"DRAIN"+seekBarWater.getProgress() ;
                break;
        }
        command = command +"$#";
        return command;
    }

    private String getOffCommand() {
        String command = "#$";
        switch (getIntent().getStringExtra("key1")){
            case "HYDRO":
                command = command + "TOGHYDROAIROFF" ;
                break;
            case "SHOULDER":
                command = command + "TOGSHDWATOFF";
                break;
            case "FILL":
                command = command + "CLEANINGOFF" ;
                break;
        }
        command = command +"$#";
        return command;
    }
}