package co.aurasphere.bluepair.activity;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import co.aurasphere.bluepair.Modes;
import co.aurasphere.bluepair.R;
import co.aurasphere.bluepair.activity.custom.CustomSequanceActivity;
import co.aurasphere.bluepair.operation.BluetoothOperation;

public class CustomActivity extends AppCompatActivity implements View.OnClickListener {


    private ImageView imgHydroMassageSetting,imgAirMassageSetting,imgWaterFallMassageSetting,imgNeckFallSetting,imgChromaLightSetting,imgOzoneSetting,custom_heater_setting;
    private CheckBox airSwitch,neckSwitch,ozoneSwitch,checkBoxWaterFall,checkBoxHeater,checkBoxDrain,checkBoxCleaning;
    private ImageView imgBackBtn,custom_drain_setting;
    private TextView tvHyrdoTimer,tvAirTimer,tvOzoneTimer,tvWaterFallTImer,tvNeckFallTimer,tvChromaLight;
    private LinearLayout tvHydroSequance;
    private String timer = "05";
    private String hydroMassageTime,airMassageTimer,waterMassageTimer,neckMassageTimer,chromaTimer,ozoneTimer,heaterTimer,drainTimer,cleaningTimer;
    private CheckBox checkBoxHydroMassage;
    private TextView tvHydroMassageOnOff,tvAirMassageONOFF,tvWaterFallOnOFF,tvNeckFallOnOff,tvChromaLightONOFF,tvHeaterONOFF,checkBoxDrainOnOff,tvCustomCleaningONOFF,tvOzoneOnOff;
    private TextView tvAirMassageToggle,tvNeckFallToggle,tvSequenceWaterFall;
    private TextView tvCustomHeaterTime,tvCustomDrainTime,tvCustomCleaningTime,tvChromaLightTimer;
    private Button chromaSwitch;
    private CHROMESTATE light;

    enum CHROMESTATE{
        ON,PAUSE,OFF
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        getSupportActionBar().hide();
        init();
    }
    private void init(){
        light = CHROMESTATE.OFF;
        tvCustomDrainTime=findViewById(R.id.custom_drain_timer);
        tvCustomHeaterTime=findViewById(R.id.custom_heater_time);
        tvCustomCleaningTime=findViewById(R.id.custom_cleaning_time);
        checkBoxHydroMassage=findViewById(R.id.custom_check_box_hydro_massage);
        tvHyrdoTimer=findViewById(R.id.custom_hydro_timer);
        tvHydroSequance=findViewById(R.id.hydroseqlay);
        ozoneSwitch=findViewById(R.id.custom_ozone);
        tvHydroMassageOnOff=findViewById(R.id.custom_hydro_on_off);
        tvOzoneTimer=findViewById(R.id.custom_ozone_timer);
        tvWaterFallTImer=findViewById(R.id.custom_water_fall_timer);
        tvWaterFallTImer.setText(Modes.getModes().getWaterTime());
//        timer=tvOzoneTimer.getText().toString();
        tvNeckFallTimer=findViewById(R.id.custom_neck_fall_timer);
        tvChromaLight=findViewById(R.id.custom_activity_chroma_light_timer);
        tvCustomHeaterTime=findViewById(R.id.custom_heater_timer);
        tvChromaLight.setText(Modes.getModes().getChromaTime());
        tvNeckFallTimer.setText(Modes.getModes().getNeckTime());
        tvOzoneTimer.setText(Modes.getModes().getOzoneTime());
        tvHyrdoTimer.setText(Modes.getModes().getHydroTime());
        tvCustomHeaterTime.setText(Modes.getModes().getHeaterTime());
        tvCustomCleaningTime.setText(Modes.getModes().getCleaningTime());
        tvAirTimer=findViewById(R.id.custom_air_massage);
        tvAirMassageONOFF=findViewById(R.id.custom_air_massage_on_off);
        tvAirTimer.setText(Modes.getModes().getAirTime());
        tvCustomDrainTime.setText(Modes.getModes().getDrainTime());

//        findViewById(R.id.massage_toggle).setOnClickListener(this);
        findViewById(R.id.falltogglelay).setOnClickListener(this);
        findViewById(R.id.cleaning_icon).setOnClickListener(this);
        imgHydroMassageSetting=findViewById(R.id.custom_hydro_massage_setting);
        imgHydroMassageSetting.setOnClickListener(this);
        imgAirMassageSetting=findViewById(R.id.custom_air_massage_setting);
        imgAirMassageSetting.setOnClickListener(this);
        imgWaterFallMassageSetting=findViewById(R.id.custom_water_fall_setting);
        imgWaterFallMassageSetting.setOnClickListener(this);
        imgNeckFallSetting=findViewById(R.id.custom_neck_fall_setting);
        imgNeckFallSetting.setOnClickListener(this);
        imgChromaLightSetting=findViewById(R.id.custom_chroma_fall_setting);
        imgChromaLightSetting.setOnClickListener(this);
        imgOzoneSetting=findViewById(R.id.custom_ozone_setting);
        custom_heater_setting=findViewById(R.id.custom_heater_setting);
        custom_drain_setting=findViewById(R.id.custom_drain_setting);
        imgOzoneSetting.setOnClickListener(this);
        custom_heater_setting.setOnClickListener(this);
        custom_drain_setting.setOnClickListener(this);
        imgBackBtn=findViewById(R.id.cutsom_activity_back_btn);
        tvChromaLightTimer=findViewById(R.id.custom_chroma_light_time);
        tvChromaLightTimer.setText(Modes.getModes().getChromaTime());
        imgBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        hydroMassageTime=tvHyrdoTimer.getText().toString();
        airMassageTimer=tvAirTimer.getText().toString();
        waterMassageTimer=tvWaterFallTImer.getText().toString();
        neckMassageTimer=tvNeckFallTimer.getText().toString();
        chromaTimer=tvChromaLightTimer.getText().toString();
        drainTimer=tvCustomDrainTime.getText().toString();
        heaterTimer=tvCustomHeaterTime.getText().toString();
        ozoneTimer=tvOzoneTimer.getText().toString();
        cleaningTimer=tvCustomCleaningTime.getText().toString();
        tvOzoneOnOff=findViewById(R.id.custom_ozone_timer_on_off);



//        hyrdroSwitch=findViewById(R.id.hydro_on_off);



        // water fall

        tvWaterFallOnOFF=findViewById(R.id.custom_water_fall_on_off);
        checkBoxWaterFall=findViewById(R.id.checkbox_water_Fall);
        checkBoxWaterFall.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    BluetoothOperation.sendCommand("#$CASCADEON"+timer+"$#");
                    tvWaterFallOnOFF.setText("ON");

                }else{
                    BluetoothOperation.sendCommand("#$CASCADEOFF$#");
                    tvWaterFallOnOFF.setText("OFF");

                }
            }
        });


        ozoneSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    tvOzoneOnOff.setText("ON");
                    BluetoothOperation.sendCommand("#$OZONEON"+timer);
                }else{
                    tvOzoneOnOff.setText("OFF");
                    BluetoothOperation.sendCommand("#$OZONEOFF");

                }
            }
        });

        checkBoxHydroMassage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    BluetoothOperation.sendCommand("#$HYDROON010$#");
//                    Toast.makeText(CustomActivity.this,"Hydro Massage On "+Modes.getModes().getHydroTime(),Toast.LENGTH_SHORT).show();
                    tvHydroMassageOnOff.setText("ON");
                }else{
                    BluetoothOperation.sendCommand("#$HYDROOFF$#");
                    tvHydroMassageOnOff.setText("OFF");
//                    Toast.makeText(CustomActivity.this,"Hydro Massage Off ",Toast.LENGTH_SHORT).show();

                }
            }
        });



        tvHydroSequance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(CustomActivity.this, "OnClick", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(CustomActivity.this, HydroMessage.class);
                startActivity(intent);
            }
        });


        airSwitch=findViewById(R.id.air_massage_on_off);

        airSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    BluetoothOperation.sendCommand("#$AIRON010$#");
                    tvAirMassageONOFF.setText("ON");
                }else{

                    BluetoothOperation.sendCommand("#$AIROFF$#");
                    tvAirMassageONOFF.setText("OFF");
                }
            }
        });



        neckSwitch=findViewById(R.id.neck_fall_switch_on_off);
        tvNeckFallOnOff=findViewById(R.id.custom_neck_fall_on_off);


        neckSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    BluetoothOperation.sendCommand("#$NECKON010$#");
                    tvNeckFallOnOff.setText("ON");

                }else{
                    BluetoothOperation.sendCommand("#$NECKOFF#");
                    tvNeckFallOnOff.setText("OFF");


                }
            }
        });

        chromaSwitch=findViewById(R.id.chroma_switch_on_off);
        tvChromaLightONOFF=findViewById(R.id.custom_chroma_light_on_off);


        chromaSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (light){
                    case OFF:
                        BluetoothOperation.sendCommand("#$CHROMAON$#");
                        tvChromaLightONOFF.setText("PAUSE");
                        light = CHROMESTATE.PAUSE;
                        break;
                    case PAUSE:
                        BluetoothOperation.sendCommand("#$CHROMAPAUSE$#");
                        tvChromaLightONOFF.setText("OFF");
                        light = CHROMESTATE.ON;
                        break;
                    case ON:
                        BluetoothOperation.sendCommand("#$CHROMAOFF$#");
                        tvChromaLightONOFF.setText("ON");
                        light = CHROMESTATE.OFF;
                        break;
                }
            }
        });

        // heater massage

        checkBoxHeater=findViewById(R.id.custom_heater_on_off);
        tvHeaterONOFF=findViewById(R.id.custom_heater_timer_on_off);


        checkBoxHeater.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    BluetoothOperation.sendCommand("#$HEATERON05$#");
                    tvHeaterONOFF.setText("ON");
                    //startActivity(new Intent(CustomActivity.this,CustomHeaterActivity.class));
                    //finish();
                }else{
                    BluetoothOperation.sendCommand("#$HEATEROFF$#");
                    tvHeaterONOFF.setText("OFF");
                }
            }
        });

        TextView custom_heater_temp = findViewById(R.id.custom_heater_temp);
        custom_heater_temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CustomActivity.this,CustomHeaterTemp.class));
                //finish();
            }
        });

        checkBoxDrain=findViewById(R.id.custom_check_box_drain);
        checkBoxDrainOnOff=findViewById(R.id.custom_drain_timer_on_off);



        checkBoxDrain.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    checkBoxDrainOnOff.setText("ON");
                    BluetoothOperation.sendCommand(" #$DRAINON"+timer+"$#");
                }else{
                    checkBoxDrainOnOff.setText("OFF");
                    BluetoothOperation.sendCommand("#$DRAINOFF$#");
                }
            }
        });


        checkBoxCleaning=findViewById(R.id.custom_check_box_cleaning);
        tvCustomCleaningONOFF=findViewById(R.id.checkbox_cleaning_on_off);

        checkBoxCleaning.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    tvCustomCleaningONOFF.setText("ON");
//                    BluetoothOperation.sendCommand("");
//                    startActivity(new Intent(CustomActivity.this,));

                }else {
                    tvCustomCleaningONOFF.setText("OFF");
                    //BluetoothOperation.sendCommand("#$CLEANINGOFF$#");
                }
            }
        });

        tvAirMassageToggle=findViewById(R.id.custom_air_massage_toggle);

        (findViewById(R.id.airtogglelay)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CustomActivity.this,CustomHydroMassage.class);
                startActivity(intent);
            }
        });

        /*tvAirMassageToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CustomActivity.this,CustomHydroMassage.class);
                startActivity(intent);
                //finish();
            }
        });*/

        tvSequenceWaterFall=findViewById(R.id.custom_water_fall_sequence);
        (findViewById(R.id.waterfalllay)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CustomActivity.this,ShoulderAndWaterFallActivity.class);
                intent.putExtra("key1","SHOULDER");
                startActivity(intent);
            }
        });
        /*tvSequenceWaterFall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CustomActivity.this,ShoulderAndWaterFallActivity.class);
                intent.putExtra("key1","SHOULDER");
                startActivity(intent);
                            }
        });*/
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.custom_hydro_massage_setting:
                Intent hydro_message=new Intent(CustomActivity.this,CustomMassageActivity.class);
                hydro_message.putExtra("title","Hydro Massage");
                hydro_message.putExtra("key",Operations.HYDRO);
                hydro_message.putExtra("time",hydroMassageTime);
                hydro_message.putExtra("image",R.drawable.hydro_massage);
                startActivity(hydro_message);
                break;
            case R.id.custom_air_massage_setting:
                Intent airMessage=new Intent(CustomActivity.this,CustomMassageActivity.class);
                airMessage.putExtra("title","Air Massage");
                airMessage.putExtra("time",airMassageTimer);

                airMessage.putExtra("key",Operations.AIR);

                startActivity(airMessage);
                break;
            case R.id.custom_water_fall_setting:
                Intent waterFall=new Intent(CustomActivity.this,CustomMassageActivity.class);
                waterFall.putExtra("title","Water Fall");
                waterFall.putExtra("time",waterMassageTimer);
                waterFall.putExtra("key",Operations.WATER);

                startActivity(waterFall);
                break;

            case R.id.custom_neck_fall_setting:
                Intent neckFall=new Intent(CustomActivity.this,CustomMassageActivity.class);
                neckFall.putExtra("title","Neck Fall");
                neckFall.putExtra("time",neckMassageTimer);
                neckFall.putExtra("key",Operations.NECK);
                startActivity(neckFall);
                break;
            case R.id.custom_chroma_fall_setting:
                Intent chromaFall=new Intent(CustomActivity.this,CustomMassageActivity.class);
                chromaFall.putExtra("title","Chroma Fall");
                chromaFall.putExtra("key",Operations.CHROMA);
                chromaFall.putExtra("time",chromaTimer);
                startActivity(chromaFall);
//                finish();
                break;

            case R.id.custom_ozone_setting:
                Intent ozone=new Intent(CustomActivity.this,CustomMassageActivity.class);
                ozone.putExtra("title","Ozone");
                ozone.putExtra("key",Operations.OZONE);
                ozone.putExtra("time",ozoneTimer);
                startActivity(ozone);
//                finish();
                break;

            case R.id.custom_heater_setting:
                startActivity(new Intent(CustomActivity.this,CustomHeaterActivity.class));
                break;

            case R.id.custom_drain_setting:
                startActivity(new Intent(CustomActivity.this,CustomDrainActivity.class));
                break;

                 case R.id.falltogglelay:
                Intent fall = new Intent(CustomActivity.this,CustomMassageActivity.class);
                    fall.putExtra("title1","Shoulder Fall");
                    fall.putExtra("title2","Water Fall");
                    fall.putExtra("time",ozoneTimer);
                    fall.putExtra("key1",Operations.SHOULDER.toString());
                    fall.putExtra("key2",Operations.WATER.toString());
                  startActivity(fall);
//                finish();
                break;

                case R.id.cleaning_icon:
                    Intent intent=new Intent(CustomActivity.this,ShoulderAndWaterFallActivity.class);
                    intent.putExtra("title1","Fill");
                    intent.putExtra("title2","Drain");
                    intent.putExtra("key1","FILL");
                    startActivity(intent);
                //finish();
                break;

//            case R.id.custom_hydro_sequence_tv:
//
//                Intent intent=new Intent(CustomActivity.this,ShoulderAndWaterFallActivity.class);
//                startActivity(intent);
//                break;
//
//            case R.id.custom_air_massage_toggle:
//                Intent toggleAirMassage=new Intent(CustomActivity.this,CustomHydroMassage.class);
////                toggleAirMassage.putExtra("time",);
//                startActivity(toggleAirMassage);
//                break;
//
            default:

                break;
//

        }
    }
}