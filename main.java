package gpaCalculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class main {
    public static void main(String[] args) {
        System.out.println("Starting");
        JFrame frame = new JFrame("Gpa Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        //frame.setBackground(new Color(217, 215, 215));

        gpaPanel gpaInput = new gpaPanel();
        frame.add(gpaInput);
        frame.setVisible(true);
    }

}

class gpaPanel extends JPanel{
    JTextField currentField;
    gpaAverage currentGpa = new gpaAverage();
    JTextField total;
    public gpaPanel(){
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        JLabel totalLabel = new JLabel("Total GPA: ");

        topPanel.setLayout(new FlowLayout());
        total = new JTextField("0.0");
        total.setEditable(false);
        total.setPreferredSize(new Dimension(100,40));
        total.setFont(new Font("Arial", Font.BOLD, 30));
        totalLabel.setFont(new Font("Arial", Font.BOLD, 30));
        topPanel.setPreferredSize(new Dimension(0,100));
        topPanel.setBackground(new Color(30, 30, 30));
        totalLabel.setForeground(Color.WHITE);
        total.setForeground(Color.BLACK);
        topPanel.add(totalLabel);
        topPanel.add(total);
        add(topPanel, BorderLayout.SOUTH);

        JPanel topRightPanel = new JPanel();
        topRightPanel.setLayout(new BorderLayout());
        JLabel rLabel = new JLabel("GPA");
        JTextField inputGpa = new JTextField();
        inputGpa.setPreferredSize(new Dimension(100,40));
        currentField = inputGpa;

        JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton add = new JButton("Add");
        add.addActionListener(new ADD());
        wrapper.add(inputGpa);
        wrapper.add(add);
        wrapper.setOpaque(false);

        rLabel.setHorizontalAlignment(SwingConstants.CENTER);
        inputGpa.setFont(new Font("Arial", Font.BOLD, 20));
        rLabel.setFont(new Font("Arial", Font.BOLD, 20));
        //rLabel.setPreferredSize(new Dimension(0,200));
        topRightPanel.setPreferredSize(new Dimension(0,400));
        topRightPanel.add(rLabel, BorderLayout.NORTH);
        topRightPanel.add(wrapper, BorderLayout.CENTER);
        topRightPanel.setBackground(new Color(30, 30, 30));
        rLabel.setForeground(Color.WHITE);
        add(topRightPanel, BorderLayout.NORTH);

        JPanel totalGpa = new JPanel();
        JButton totalButton = new JButton("Calculate Total");
        totalButton.addActionListener(new Listen());
        totalButton.setFont(new Font("Segoe UI", Font.BOLD, 20)); 
        totalGpa.setBackground(new Color(30, 30, 30));
        totalGpa.add(totalButton);
        add(totalGpa, BorderLayout.CENTER);
    }
    private class Listen implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            double value = currentGpa.calculate();
            total.setText(String.format("%.2f", value));
            currentGpa.clear();
        }
    }

    private class ADD implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent x){
            double quantity;
            try {
                quantity = Double.parseDouble(currentField.getText());
            } catch (Exception e) {
                quantity = 0;
            }
            currentGpa.gpa(quantity);
            currentField.setText("");
        }
    }
}
