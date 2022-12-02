package co.aurasphere.bluepair.activity;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import co.aurasphere.bluepair.Modes;
import co.aurasphere.bluepair.R;
import co.aurasphere.bluepair.activity.custom.CustomSequanceActivity;
import co.aurasphere.bluepair.operation.BluetoothOperation;

public class CustomMassageActivity extends AppCompatActivity {

    private String massageTitle;
    private TextView tvMassageTitle;
    private SeekBar seekBarSelectTime;
    private Operations key;
    private TextView tvTimer;
    private TextView tvStart;
    private ImageView imgBackBtn;
    private String time;
    private int mins = 0;
    private boolean isOn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_massage);
        getSupportActionBar().hide();
        init();

    }

    private void init(){
        massageTitle=getIntent().getStringExtra("title");
        key=(Operations) getIntent().getSerializableExtra("key");
        tvMassageTitle=findViewById(R.id.custom_massage_title);
        tvMassageTitle.setText(massageTitle);


            tvTimer=findViewById(R.id.custom_massage_time);
            time=getIntent().getStringExtra("time");
            tvTimer.setText(time);
            tvStart=findViewById(R.id.custom_massage_start);
            imgBackBtn=findViewById(R.id.custom_massage_back_btn);
            imgBackBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackPressed();
                }
            });

           seekBarSelectTime=(SeekBar)findViewById(R.id.seekBar);
           seekBarSelectTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
               @Override
              public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//                Toast.makeText(CustomMassageActivity.this ,"Seek Bar progress"+i,Toast.LENGTH_LONG).show();
                   mins = i;
                    tvTimer.setText(String.valueOf(i)+"\n  Min");
                    setTitleForModes(String.valueOf(i)+"\n  Min");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(CustomMassageActivity.this ,"Seek Bar start",Toast.LENGTH_LONG).show();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(CustomMassageActivity.this ,"Seek Bar stop",Toast.LENGTH_LONG).show();

            }
        });



           tvStart.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {

                   //Intent intent=new Intent(CustomMassageActivity.this,CustomActivity.class);
                   //startActivity(intent);
                   String time = String.format("%03d", mins);
                   switch (key){

                       case HYDRO:
                           if (isOn){
                               BluetoothOperation.sendCommand("#$HYDROOFF$#");
                               tvStart.setText("START");
                               isOn = false;
                           }else{
                               BluetoothOperation.sendCommand("#$HYDROON"+time+"$#");
                               tvStart.setText("STOP");
                               isOn = true;
                           }

                           break;
                       case AIR:
                           if (isOn){
                               BluetoothOperation.sendCommand("#$AIROFF$#");
                               tvStart.setText("START");
                               isOn = false;
                           }else{
                               BluetoothOperation.sendCommand("#$AIRON"+time+"$#");
                               tvStart.setText("STOP");
                               isOn = true;
                           }
                           break;
                       case WATER:
                           if (isOn){
                               BluetoothOperation.sendCommand("#$CASCADEOFF$#");
                               tvStart.setText("START");
                               isOn = false;
                           }else{
                               BluetoothOperation.sendCommand("#$CASCADEON"+time+"$#");
                               tvStart.setText("STOP");
                               isOn = true;
                           }
                           break;
                       case NECK:
                           if (isOn){
                               BluetoothOperation.sendCommand("#$NECKOFF$#");
                               tvStart.setText("START");
                               isOn = false;
                           }else{
                               BluetoothOperation.sendCommand("#$NECKON"+time+"$#");
                               tvStart.setText("STOP");
                               isOn = true;
                           }
                           break;
                       case CHROMA:
                           break;
                       case OZONE:
                           if (isOn){
                               BluetoothOperation.sendCommand("#$OZONEOFF$#");
                               tvStart.setText("START");
                               isOn = false;
                           }else{
                               BluetoothOperation.sendCommand("#$OZONEON"+time+"$#");
                               tvStart.setText("STOP");
                               isOn = true;
                           }
                           break;
                       default:
                           break;

                   }
               }
           });

    }

    private void setTitleForModes(String s) {
        switch (key){

            case HYDRO:
                Modes.getModes().setHydroTime(s);
                break;
            case AIR:
                Modes.getModes().setAirTime(s);
                break;
            case WATER:
                Modes.getModes().setWaterTime(s);
                break;
            case NECK:
                Modes.getModes().setNeckTime(s);
                break;
            case CHROMA:
                Modes.getModes().setChromaTime(s);
                break;
            case OZONE:
                Modes.getModes().setOzoneTime(s);
                break;
            default:
                break;

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}