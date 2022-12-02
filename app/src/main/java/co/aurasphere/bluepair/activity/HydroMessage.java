package co.aurasphere.bluepair.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import com.daasuu.ahp.AnimateHorizontalProgressBar;

import co.aurasphere.bluepair.R;
import co.aurasphere.bluepair.operation.BluetoothOperation;

public class HydroMessage extends AppCompatActivity {

    private SeekBar massage2,massage3,massage4;
    int mins1=00,mins2=00,mins3=00,mins4=00;
    TextView start;
    private boolean isOn = false;
    SeekBar massage1;
    TextView massage1txt,massage2txt,massage3txt,massage4txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hydro_message);
        massage1 = findViewById(R.id.animate_progress_bar);
        massage2 = findViewById(R.id.animate_progress_bar2);
        massage3 = findViewById(R.id.animate_progress_bar3);
        massage4 = findViewById(R.id.animate_progress_bar4);
        massage1txt = findViewById(R.id.massage1txt);
        massage2txt = findViewById(R.id.massage2txt);
        massage3txt = findViewById(R.id.massage3txt);
        massage4txt = findViewById(R.id.massage4txt);
        start = findViewById(R.id.start);

        massage1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//                Toast.makeText(CustomMassageActivity.this ,"Seek Bar progress"+i,Toast.LENGTH_LONG).show();
                mins1 = i;
                massage1txt.setText(i+" Sec");
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
        massage2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//                Toast.makeText(CustomMassageActivity.this ,"Seek Bar progress"+i,Toast.LENGTH_LONG).show();
                mins2 = i;
                massage2txt.setText(i+" Sec");
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
        massage3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//                Toast.makeText(CustomMassageActivity.this ,"Seek Bar progress"+i,Toast.LENGTH_LONG).show();
                mins3 = i;
                massage3txt.setText(i+" Sec");
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
        massage4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//                Toast.makeText(CustomMassageActivity.this ,"Seek Bar progress"+i,Toast.LENGTH_LONG).show();
                mins4 = i;
                massage4txt.setText(i+" Sec");
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

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isOn){
                    BluetoothOperation.sendCommand("#$HYDROSEQOFF$#");
                    isOn = false;
                    start.setText("START");
                }
                else{
                    BluetoothOperation.sendCommand(getCommand());
                    isOn = true;
                    start.setText("STOP");
                }

            }
        });
    }

    private String getCommand() {
        return "#$HYDROSEQH1"+mins1+"H2"+mins2+"H3"+mins3+"H4"+mins4+"$#";
    }


}