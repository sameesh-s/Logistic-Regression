import java.util.ArrayList;
//import java.util.HashSet;
import java.util.List;
//import java.util.Set;
//import java.util.SortedSet;
//import java.util.TreeSet;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComboBox {
    private static final ActionListener Event = null;
    JComboBox combo1;
    JComboBox combo2;
    JComboBox combo3;
    JComboBox combo4;
    JComboBox combo5;
    JTextField txt;
    Button boton;

    public static void main(String[] args) {
        ComboBox b = new ComboBox();
    }

    public ComboBox() {
        String course1[] = { "Have fever","dont have fever"};
        String course2[] = { "Platelet count low","Normal" };
        String course3[] = { "Abnormal BP", "Normal BP" };
        String course4[] = { "Abnormal Glucose level","Normal"};
        String course5[] = { "Family infected","No previous family history"};
        JFrame frame = new JFrame("Creating a JComboBox Component");
        JPanel panel = new JPanel();
        combo1 = new JComboBox(course1);
        combo2 = new JComboBox(course2);
        combo3 = new JComboBox(course3);
        combo4 = new JComboBox(course4);
        combo5 = new JComboBox(course5);
        txt = new JTextField(30);
        boton = new Button( "Boton");
        panel.add(combo1);
        panel.add(combo2);
        panel.add(combo3);
        panel.add(combo4);
        panel.add(combo5);
        panel.add(txt);
        panel.add(boton);
        frame.add(panel);

        boton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                    String str1 = (String) combo1.getSelectedItem();
                    String str2 = (String) combo2.getSelectedItem();
                    String str3 = (String) combo3.getSelectedItem();
                    txt.setText(str1+str2+str3);

            }
        });
        combo1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {

            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
