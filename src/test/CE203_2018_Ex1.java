package test;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Color;
//import java.time.Year;


public class CE203_2018_Ex1 {
                                                            // All variables listed
    private JFrame window;
    private JPanel contains, dataContains;
    private JLabel DispatchMe, rd, gn, bl;                //all colors
    private JTextField rdSection, gnSection, blSection;          // all color fields
    private JButton rebootB, viewB;                     //reset,display color buttons


    public CE203_2018_Ex1() {

        FrameLocation();           // jFrame created to display GUI using swing
        Observers();                // callback listeners



        window.setVisible(true);            // displaying program

    }




    private void FrameLocation() {                     //create frame and components, method is called inside of class




        window = new JFrame("Michael Ajibola 1701303");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(499, 399);


        contains = new JPanel();                                // main panel in the frame which act as content pane
        contains.setBackground(Color.LIGHT_GRAY);
        contains.setLayout(new BorderLayout(0, 0));             // setting border layout for mainPanel
        window.setContentPane(contains);


        rebootB = new JButton("RESET");
        rebootB.setBackground(new Color(255, 255, 255));
        contains.add(rebootB, BorderLayout.NORTH);


        DispatchMe = new JLabel("CE203 Assignment 1, Submitted By: Michael Ajibola, 1701303");    //adding text at center
        DispatchMe.setHorizontalAlignment(SwingConstants.CENTER);
        contains.add(DispatchMe, BorderLayout.CENTER);


        dataContains = new JPanel();                                  //adding rgb data fields

        dataContains.setLayout(new GridLayout(4, 2, 0, 0));   // Grid Layout with 4 rows and 2 columns.
        contains.add(dataContains, BorderLayout.SOUTH);

        // text fields and labels for rgb
        rd = new JLabel("Red:");                   // redLabel
        rd.setHorizontalAlignment(SwingConstants.CENTER);
        dataContains.add(rd);

        rdSection = new JTextField();
        dataContains.add(rdSection);

        gn = new JLabel("Green:");                 //greenLabel
        gn.setHorizontalAlignment(SwingConstants.CENTER);
        dataContains.add(gn);

        gnSection = new JTextField();
        dataContains.add(gnSection);

        bl = new JLabel("Blue:");
        bl.setHorizontalAlignment(SwingConstants.CENTER);
        dataContains.add(bl);

        blSection = new JTextField();
        dataContains.add(blSection);


        viewB = new JButton("PRESS ME TO DISPLAY");
        viewB.setBackground(new Color(255, 255, 255));
        dataContains.add(viewB);

    }



    public static void main(String[] args) {                    // my main method for testing


        new CE203_2018_Ex1();                                  // object to start frame

    }








    private void Observers() {                                           //Listeners created


        rebootB.addActionListener(new ActionListener() {                        //action when reset is touched

            @Override
            public void actionPerformed(ActionEvent e) {


                rdSection.setText("");                                        //setting color sections as empty
                blSection.setText("");
                gnSection.setText("");

            }

        });


        viewB.addActionListener(new ActionListener() {                        // when display button is pressed, it will take input from fields

            @Override
            public void actionPerformed(ActionEvent e) {                       //action method

                int rd = 0, gn = 0, bl = 0;
                boolean y = false;


                try {
                    rd = Integer.parseInt(rdSection.getText());                 // moving red to an integer
                }catch(Exception ex) {

                    rdSection.setText("");
                    y = true;                                                    // setting an error expectation
                }

                try {
                    bl = Integer.parseInt(blSection.getText());             // moving blue to integer
                }catch(Exception ex) {

                    blSection.setText("");
                    y = true;
                }

                try {
                    gn = Integer.parseInt(gnSection.getText());                 // moving green to integer
                }catch(Exception ex) {

                    gnSection.setText("");
                    y = true;                                                       // setting an error flag
                }


                if(y) {


                    JOptionPane.showMessageDialog(null, "Error please type in an integer.");

                }else {


                    if(rd < 0) {                               // Sets  colors value if data out of range
                        rd = 200;
                        rdSection.setText("200");
                    }else if(rd > 255) {
                        rd = 255;
                        rdSection.setText("255");
                    }


                    if(gn < 0) {
                        gn = 200;
                        gnSection.setText("200");
                    }else if(gn > 255) {
                        gn = 255;
                        gnSection.setText("255");
                    }


                    if(bl < 0) {
                        bl = 200;
                        blSection.setText("200");
                    }else if(bl > 255) {
                        bl = 255;
                        blSection.setText("255");
                    }


                    Color style = new Color(rd, gn, bl);                              //creates color

                    DispatchMe.setForeground(style);                          //sets color in foreground
                }

            }

        });

    }



}
