package co.aurasphere.bluepair.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import co.aurasphere.bluepair.R;
import co.aurasphere.bluepair.operation.BluetoothOperation;

public class CustomHydroMassage extends AppCompatActivity {
    private ImageView imgBackBtn;
    private SeekBar seekBarHydroMassage,seekBarAirMassage;
    private TextView tvHydroMassage,tvAirMassage;
    private Button start;
    private boolean isOn = false;
    int mins1=00,mins2=00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_hydro_massage);
        getSupportActionBar().hide();
        init();
    }

    public void  init(){
        imgBackBtn=findViewById(R.id.custom_hydro_message_back_btn);
        start = findViewById(R.id.chkState);
        imgBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        seekBarAirMassage=findViewById(R.id.air_massage_Seek_bar);
        tvAirMassage=findViewById(R.id.custom_air_massage_timer);
        seekBarAirMassage.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tvAirMassage.setText(i +" Mins");
                mins2 = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




        seekBarHydroMassage=findViewById(R.id.hydro_massage_Seek_bar);
        tvHydroMassage=findViewById(R.id.custom_hydro_massage_timer);

        seekBarHydroMassage.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tvHydroMassage.setText(i +" Mins");
                mins1 = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isOn){
                    BluetoothOperation.sendCommand("#$TOGHYDROAIROFF$#");
                    isOn = false;
                    start.setText("START");
                }
                else {
                    BluetoothOperation.sendCommand("#$TOGHYDRO"+mins1+"AIR"+mins2+"ON$#");
                    isOn = true;
                    start.setText("STOP");
                }
            }
        });
    }
}