import java.util.function.DoubleFunction;

public enum Compound {
    O3("Âµg/m3", "ozone content", Compound::calcO3AQI),
    SO2("Âµg/m3", "sulfur dioxide content", Compound::calcSO2AQI),
    NO2("Âµg/m3", "nitrogen dioxide content", Compound::calcNO2AQI),
    PM10("Âµg/m3","fine particles content", Compound::calcPM10AQI);

    private final String unit;
    private final String description;
    private final DoubleFunction function;

    private static double calcO3AQI(double v){
        double AQI;
        double c=(Math.floor(v))/1000;
        if (c>=0 && c<.055)
        {
            AQI=linear(50,0,0.054,0,c);
        }
        else if (c>=.055 && c<.071)
        {
            AQI=linear(100,51,.070,.055,c);
        }
        else if (c>=.071 && c<.086)
        {
            AQI=linear(150,101,.085,.071,c);
        }
        else if (c>=.086 && c<.106)
        {
            AQI=linear(200,151,.105,.086,c);
        }
        else if (c>=.106 && c<.201)
        {
            AQI=linear(300,201,.200,.106,c);
        }

        else if (c>=.125 && c<.165)
        {
            AQI=linear(150,101,.164,.125,c);
        }
        else if (c>=.165 && c<.205)
        {
            AQI=linear(200,151,.204,.165,c);
        }
        else if (c>=.205 && c<.405)
        {
            AQI=linear(300,201,.404,.205,c);
        }
        else if (c>=.405 && c<.505)
        {
            AQI=linear(400,301,.504,.405,c);
        }
        else if (c>=.505 && c<.605)
        {
            AQI=linear(500,401,.604,.505,c);
        }
        else
        {
            AQI=-1;
        }
        return AQI;
    }
    private static double calcSO2AQI(double v){
        double AQI;
        double c=Math.floor(v);
        if (c>=0 && c<36)
        {
            AQI=linear(50,0,35,0,c);
        }
        else if (c>=36 && c<76)
        {
            AQI=linear(100,51,75,36,c);
        }
        else if (c>=76 && c<186)
        {
            AQI=linear(150,101,185,76,c);
        }
        else if (c>=186 && c<=304)
        {
            AQI=linear(200,151,304,186,c);
        }
       else if (c>=304 && c<605)
        {
            AQI=linear(300,201,604,305,c);
        }
        else if (c>=605 && c<805)
        {
            AQI=linear(400,301,804,605,c);
        }
        else if (c>=805 && c<=1004)
        {
            AQI=linear(500,401,1004,805,c);
        }
        else
        {
            AQI=-1;
        }
        return AQI;
    }
    private static double calcNO2AQI(double v){
        double AQI;
        double c=(Math.floor(v))/1000;
        if (c>=0 && c<.054)
        {
            AQI=linear(50,0,.053,0,c);
        }
        else if (c>=.054 && c<.101)
        {
            AQI=linear(100,51,.100,.054,c);
        }
        else if (c>=.101 && c<.361)
        {
            AQI=linear(150,101,.360,.101,c);
        }
        else if (c>=.361 && c<.650)
        {
            AQI=linear(200,151,.649,.361,c);
        }
        else if (c>=.650 && c<1.250)
        {
            AQI=linear(300,201,1.249,.650,c);
        }
        else if (c>=1.250 && c<1.650)
        {
            AQI=linear(400,301,1.649,1.250,c);
        }
        else if (c>=1.650 && c<=2.049)
        {
            AQI=linear(500,401,2.049,1.650,c);
        }
        else
        {
            AQI=-1;
        }
        return AQI;
    }

    //Taken straight from the source code of https://www.airnow.gov/aqi/aqi-calculator-concentration/
    private static double calcPM10AQI(double v){
        double AQI;
        double c=Math.floor(v);
        if (c>=0 && c<55)
        {
            AQI=linear(50,0,54,0,c);
        }
        else if (c>=55 && c<155)
        {
            AQI=linear(100,51,154,55,c);
        }
        else if (c>=155 && c<255)
        {
            AQI=linear(150,101,254,155,c);
        }
        else if (c>=255 && c<355)
        {
            AQI=linear(200,151,354,255,c);
        }
        else if (c>=355 && c<425)
        {
            AQI=linear(300,201,424,355,c);
        }
        else if (c>=425 && c<505)
        {
            AQI=linear(400,301,504,425,c);
        }
        else if (c>=505 && c<605)
        {
            AQI=linear(500,401,604,505,c);
        }
        else
        {
            AQI=-1;
        }
        return AQI;
    }

    //Taken straight from the source code of https://www.airnow.gov/aqi/aqi-calculator-concentration/
    private static double linear(double AQIhigh, double AQIlow, double conchigh, double conclow, double concentration) {
        double a=((concentration-conclow)/(conchigh-conclow))*(AQIhigh-AQIlow)+AQIlow;
        return Math.round(a);
    }


    Compound(String unit, String description, DoubleFunction m) {
        this.unit = unit;
        this.description = description;
        this.function = m;
    }

    public String getUnit() { return unit; }
    public String getDescription() { return description; }
<<<<<<< Updated upstream
    public DoubleFunction getFunction(){return function;}

=======
>>>>>>> Stashed changes

}