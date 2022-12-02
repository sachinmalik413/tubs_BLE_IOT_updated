package co.aurasphere.bluepair;

public class Modes {

    private static Modes obj;
    private Modes(){}

    public static Modes getModes(){
        if (obj == null){
            obj = new Modes();
        }
        return obj;
    }

    private String HydroTime = "10 Min";
    private String AirTime = "10 Min";
    private String WaterTime = "10 Min";
    private String NeckTime = "10 Min";
    private String ChromaTime = "10  Min";
    private String OzoneTime= "10  Min";
    private String heaterTime= "10 Min";
    private String DrainTime="10 Min";
    private String CleaningTime="10 Min";

    public String getHeaterTime() {
        return heaterTime;
    }

    public void setHeaterTime(String heaterTime) {
        this.heaterTime = heaterTime;
    }

    public String getDrainTime() {
        return DrainTime;
    }

    public void setDrainTime(String drainTime) {
        DrainTime = drainTime;
    }

    public String getCleaningTime() {
        return CleaningTime;
    }

    public void setCleaningTime(String cleaningTime) {
        CleaningTime = cleaningTime;
    }

    public String getHydroTime() {
        return HydroTime;
    }

    public void setHydroTime(String hydroTime) {
        HydroTime = hydroTime;
    }

    public String getAirTime() {
        return AirTime;
    }

    public void setAirTime(String airTime) {
        AirTime = airTime;
    }

    public String getWaterTime() {
        return WaterTime;
    }

    public void setWaterTime(String waterTime) {
        WaterTime = waterTime;
    }

    public String getNeckTime() {
        return NeckTime;
    }

    public void setNeckTime(String neckTime) {
        NeckTime = neckTime;
    }

    public String getChromaTime() {
        return ChromaTime;
    }

    public void setChromaTime(String chromaTime) {
        ChromaTime = chromaTime;
    }

    public String getOzoneTime() {
        return OzoneTime;
    }

    public void setOzoneTime(String ozoneTime) {
        OzoneTime = ozoneTime;
    }
}
