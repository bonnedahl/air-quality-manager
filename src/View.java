import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DateEditor;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class View {
    List<Measurement> measurements;
    private JFrame frame;
    private JTextArea output;
    JPanel allSensors;
    List<String> selectedSensors = new ArrayList<>();
    DateEditor fromEditor, toEditor;
    JTextField percentageRate;
    SimpleDateFormat dateFormat;

    public View(List<Measurement> measurements) {
        this.measurements = measurements;
        dateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        buildGUI();
    }

    /**
     * Builds and shows the GUI
     */
    private void buildGUI() {
        frame = new JFrame("AirQualityManager");
        frame.setSize(1100, 500);
        frame.setMinimumSize(new Dimension(280, 200));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel(new BorderLayout());

        JPanel optionPane = buildOptionsPanel();
        output = buildOutput();

        contentPane.add(optionPane, BorderLayout.WEST);
        contentPane.add(output, BorderLayout.CENTER);

        frame.add(contentPane);
        frame.setVisible(true);
    }

    /**
     * Builds the table-panel
     *
     * @return The pre-built table-panel
     */
    private JTextArea buildOutput() {
        JTextArea output = new JTextArea("Choose a sensor to get started");

        return output;
    }

    private JScrollPane buildSensorSelector(){
        allSensors = new JPanel();
        allSensors.setLayout(new BoxLayout(allSensors, BoxLayout.PAGE_AXIS));
        JScrollPane scrollPane = new JScrollPane(allSensors);

        for (Sensor s : Sensor.values()) {
            JCheckBox check = new JCheckBox(String.valueOf(s.getSensorID()));
            check.addItemListener((ItemEvent e) -> toggleSensor(s.getSensorID(),
                e.getStateChange() == ItemEvent.SELECTED));
            allSensors.add(check);
        }
        return scrollPane;
    }

    private JPanel buildDateSpanSelector(){
        JPanel timeSelector = new JPanel();

        JSpinner fromSpinner = new JSpinner(new SpinnerDateModel());
        fromEditor = new DateEditor(fromSpinner, "yyyy:MM:dd'T'HH:mm:ss");
        fromSpinner.setEditor(fromEditor);


        timeSelector.add(fromSpinner);

        JSpinner toSpinner = new JSpinner(new SpinnerDateModel());
        toEditor = new DateEditor(toSpinner, "yyyy:MM:dd'T'HH:mm:ss");
        toSpinner.setEditor(toEditor);

        try {
            System.out.println(dateFormat.parse("2017:01:01 00:00:00"));
            fromSpinner.setValue(dateFormat.parse("2017:01:01 00:00:00"));
            toSpinner.setValue(dateFormat.parse("2017:01:01 00:59:59"));
        } catch (ParseException e) {
            System.out.println("Error");
        }
        fromSpinner.addChangeListener(e -> updateOutput());
        toSpinner.addChangeListener(e -> updateOutput());
        timeSelector.add(toSpinner);
        return timeSelector;
    }

    private JPanel buildPercentageSpanSelector(){
        JPanel percentageSpan = new JPanel();
        JTextArea text1 = new JTextArea("How many measurements fall within ±");
        text1.setEditable(false);
        percentageSpan.add(text1);
        percentageRate = new JTextField(2);
        percentageRate.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                warn();
            }
            public void removeUpdate(DocumentEvent e) {
                warn();
            }
            public void insertUpdate(DocumentEvent e) {
                warn();
            }

            public void warn() {
                updateOutput();
            }
        });
        percentageSpan.add(percentageRate);
        JTextArea text2 = new JTextArea("% from the average value?");
        text2.setEditable(false);
        percentageSpan.add(text2);
        return percentageSpan;
    }

    /**
     * Builds the channel-panel
     *
     * @return The pre-built channel-panel
     */
    private JPanel buildOptionsPanel() {
        JPanel optionsPane = new JPanel(new BorderLayout());
        JLabel text = new JLabel("Available sensors");
        optionsPane.add(text, BorderLayout.NORTH);

        JScrollPane sensorSelector = buildSensorSelector();
        optionsPane.add(sensorSelector, BorderLayout.NORTH);

        JPanel timeSelector = buildDateSpanSelector();
        optionsPane.add(timeSelector, BorderLayout.CENTER);

        JPanel percentageSpan = buildPercentageSpanSelector();
        optionsPane.add(percentageSpan, BorderLayout.SOUTH);

    return optionsPane;
    }

    /**
     * Toggles a sensor
     *
     * @param s       The name of the sensor to be toggled
     * @param checked If the sensor should be toggled on or of
     */
    private void toggleSensor(int s, boolean checked) {
        if (checked) {
            selectedSensors.add(String.valueOf(s));
        } else {
            selectedSensors.remove(String.valueOf(s));
        }
        updateOutput();
    }

    private void updateOutput(){
        String outputText = "";
        Date fromDate = fromEditor.getModel().getDate();
        Date toDate = toEditor.getModel().getDate();
        if(selectedSensors.size() == 0){
            output.setText("Choose a sensor to get started");
            return;
        }else if(fromDate.after(toDate)){
            output.setText("The from-date must be before the to-date");
            return;
        }

        Average SO2 = new Average(Compound.SO2);
        Average NO2 = new Average(Compound.NO2);
        Average O3 = new Average(Compound.O3);
        Average PM10 = new Average(Compound.PM10);
        for(Measurement m : measurements){
            if(m.getTimestamp().after(fromDate) && m.getTimestamp().before(toDate)){
                for(String s:selectedSensors) {
                    if(m.getSensor().getSensorID() == Integer.valueOf(s)) {
                        for (Density d : m.getValues()) {
                            switch (d.getCompound()) {
                                case NO2:
                                    NO2.add(d);
                                    break;
                                case O3:
                                    SO2.add(d);
                                    break;
                                case SO2:
                                    O3.add(d);
                                    break;
                                default:
                                    PM10.add(d);
                            }
                        }
                    }
                }
            }
        }

        if(SO2.count == 0){
            output.setText("No measurements were selected. Set a range between 2017-01-01 and 2017-12-31");
            return;
        }
        outputText += SO2.getOutput();
        outputText += NO2.getOutput();
        outputText += O3.getOutput();
        outputText += PM10.getOutput();

        output.setText(outputText);
    }



    class Average{
        float totalValue = 0;
        float totalAQI =0;
        int count;
        List<Float> values;
        Compound c;
        Average(Compound c){
            this.c = c;
            values = new ArrayList<>();
        }

        void add(Density d){
            count++;
            totalValue += d.getValue();
            totalAQI += d.getAQI();
            values.add(d.getValue());
        }

        float getAvgValue(){
            return totalValue/count;
        }

        float getAvgAQI(){
            return totalAQI/count;
        }

        String getOutput(){
            String output = "";
            output += "Average value for "+c.name()+": " + getAvgValue() +"\n";
            output += "\tAverage Air Quality Index for "+c.name()+": " + getAvgAQI() +" which is " + Density.getAQILevel(getAvgAQI()) +"\n";
            if(isInt(percentageRate.getText())){
                int range = Integer.valueOf(percentageRate.getText());
                output += "\t"+rateWithinRange(range)*100+"% fall within the range of ±"+ range+"% from the average "+c.name()+" value\n";
            }
            output += "\n";
            return output;
        }

        private boolean isInt(String s){
            if(s == null ||s.equals("")){
                return false;
            }else{
                try {
                    int i = Integer.parseInt(s);
                    return true;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        }

        double rateWithinRange(int range){
            double inRange = 0.0;
            for(float f: values){
                if(f>getAvgValue()*(1-range/100.0) && f<getAvgValue()*(1+range/100.0)){
                    inRange++;
                }
            }
            return inRange/values.size();
        }
    }
}
