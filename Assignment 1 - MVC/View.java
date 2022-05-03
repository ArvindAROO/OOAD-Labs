import javax.swing.*;
import java.awt.*;

public class View {
      
    private JFrame frame;
    private JLabel label;
    private JLabel srn;
    private JButton incrementButton;
    private JButton decrementButton;
    private JButton resetButton;
    private JButton setButton;
    Controller  controller;
    
    JTextField input1 = new JTextField(10);

    
    public View(){
        frame = new JFrame("PES1UG19CS090");                                    
        frame.getContentPane().setLayout(new BorderLayout());                                          
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        
        frame.setLocationRelativeTo(null);       
        frame.setSize(300, 400);
        frame.setLayout(null);        
        frame.setVisible(true);
        
        incrementButton = new JButton("Increase");
        incrementButton.setBounds(50,30,200,40);
        frame.add(incrementButton);

        decrementButton = new JButton("Decrease");
        decrementButton.setBounds(50,80,200,40);
        frame.add(decrementButton);

        label = new JLabel("0");
        label.setBounds(150, 130,2000, 10);
        frame.getContentPane().add(label);

        resetButton = new JButton("Reset");
        resetButton.setBounds(50,170,200,40);
        frame.add(resetButton);


        input1.setBounds(50,220,200,40);

        setButton = new JButton("Set value");
        setButton.setBounds(50,270,200,40);

        frame.add(setButton);
        frame.add(input1);

        srn = new JLabel("PES1UG19CS090");
        srn.setBounds(90, 320, 200, 10);
        frame.getContentPane().add(srn);
    }
        
    public JButton getIncButton(){
        return incrementButton;
    }

    public JButton getDecButton(){
        return decrementButton;
    }
    
    public JButton getResetButton(){
        return resetButton;
    }

    public JButton getSetButton(){
        return setButton;
    }

    public void setText(String text){
        label.setText(text);
    }   

    public void createPopUP(){
        JOptionPane.showMessageDialog(frame, "Max value reached");
    }
}
