package gpaCalculator;
import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.text.PlainView;

public class gpaAverage {
    ArrayList<Double> allGpa = new ArrayList<Double>();

    public void gpa(double gap) {
        allGpa.add(gap);
    }

    public double calculate(){
        double total = 0;
        for(double i : allGpa){
            total += i;
        }
        if(total > 0){
            return total / allGpa.size();
        }
        return 0;
    }

    public void clear(){
        allGpa = new ArrayList<Double>();
    }


    
}
