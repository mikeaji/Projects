package test;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
//import java.awt.Frame;


public class CE203_2018_Ex2 {


    private JFrame frame;                                                // All variables listed
    private JPanel contains, mainPanelB;
    private JButton countButton, viewB, findWord,
            discardButton, removeAllOccurrences, clearList;
    private JLabel dispatchThis;
    private JTextField messagePassed;
    private ArrayList<String> storeLst;


    public CE203_2018_Ex2() {                                          //creating frame


        storeLst = new ArrayList<>();                                  //initializing the list

        FrameLocation();                               // jFrame created to display GUI using swing
        Observers();                                  // callback listeners


        frame.setVisible(true);                                         // displaying program

    }


    public static void main(String[] args) {                              //my main method to test


        new CE203_2018_Ex2();                                            // object to begin frame

    }




    private void FrameLocation() {                                     //create frame and components, method is called inside of class


        frame = new JFrame("Michael Ajibola 1701303");                //creates frame
        frame.setTitle("Michael Ajibola 1701303");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //used to specify one of several options for close button
        frame.setSize(981, 501);



        contains = new JPanel();                                        // main panel in the frame which act as content pane
        contains.setBackground(Color.GRAY);
        contains.setLayout(new BorderLayout(0, 0));            // setting border layout for mainPanel
        frame.setContentPane(contains);

                                                                           // Creating a flow layout for buttons
        mainPanelB = new JPanel();
        contains.add(mainPanelB, BorderLayout.NORTH);
        mainPanelB.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));


        countButton = new JButton("Add");                                          //List all buttons
        mainPanelB.add(countButton);

        viewB = new JButton("Display");
        mainPanelB.add(viewB);

        findWord = new JButton("Search");
        mainPanelB.add(findWord);

        discardButton = new JButton("Remove Last Occurrence Of Word");
        mainPanelB.add(discardButton);

        removeAllOccurrences = new JButton("Remove All Occurrence Of Word");
        mainPanelB.add(removeAllOccurrences);

        clearList = new JButton("Clear List");
        mainPanelB.add(clearList);


        dispatchThis = new JLabel("");                                            //adding output in center
        dispatchThis.setHorizontalAlignment(SwingConstants.CENTER);
        contains.add(dispatchThis, BorderLayout.CENTER);


        messagePassed = new JTextField();
        contains.add(messagePassed, BorderLayout.SOUTH);
        messagePassed.setColumns(10);

    }




    private void Observers() {                                                //enter listeners


        countButton.addActionListener(new ActionListener() {                   //action when button touched
            public void actionPerformed(ActionEvent e) {


                String phrase = messagePassed.getText();                              //extracting data
                if(phrase.equals("")) {

                    dispatchThis.setText("Not Valid Word! Empty Field!");

                }else {

                                                                             // checking if word is alphabetic
                    if(Character.isAlphabetic(phrase.charAt(0))) {

                        storeLst.add(phrase);
                        dispatchThis.setText("The word "+phrase+" is added to list.");


                    }else {
                        dispatchThis.setText("The string "+phrase+" cannot be added to list due to being invalid input!");
                    }

                }

            }
        });


        viewB.addActionListener(new ActionListener() {                                                // displays viewing button
            public void actionPerformed(ActionEvent e) {


                String type = messagePassed.getText();                                                 // extracting specific letter from input
                if(type.length() == 1) {

                    type = type.toLowerCase();                                                  // make it to lower case
                    String text = "";

                    for(String phrase: storeLst) {


                        if(phrase.toLowerCase().endsWith(type)) {

                            text += phrase + ", ";

                        }

                    }
                                                                                                                    // displaying list
                    dispatchThis.setText("<html>"+text+"</html>");     //giving jlabel power of html to move text on second line if text reaches total width

                }else {
                    dispatchThis.setText("Please Enter Text input letter should be 1");
                }

            }
        });


        findWord.addActionListener(new ActionListener() {                                //actions when the button is touched
            public void actionPerformed(ActionEvent e) {

                                                                                                   // get data from field
                String phrase = messagePassed.getText();
                if(phrase.length() == 0) {


                    dispatchThis.setText("Total Number Of Words In List: "+storeLst.size());

                }else {

                    String text = phrase+" existence in index [";
                    phrase = phrase.toLowerCase();
                    int y = 0;

                    for(int i = 0; i < storeLst.size(); i++) {


                        if(storeLst.get(i).toLowerCase().equals(phrase)) {

                            text += i+",";
                            y++;

                        }

                    }
                    text += "] Count: "+y;
                    dispatchThis.setText(text);

                }

            }
        });


        discardButton.addActionListener(new ActionListener() {                                   // When remove button is pressed
            public void actionPerformed(ActionEvent e) {


                String phrase = messagePassed.getText();
                if(phrase.length() == 0) {


                    dispatchThis.setText("Word is empty.");

                }else {

                    for(int x = storeLst.size() - 1; x >= 0; x--) {


                        if(storeLst.get(x).toLowerCase().equals(phrase)) {

                            storeLst.remove(x);
                            dispatchThis.setText("Removed "+phrase+" in index: "+x);
                            return;

                        }

                    }

                    dispatchThis.setText("Error! Word cannot be found");

                }

            }
        });


        removeAllOccurrences.addActionListener(new ActionListener() {                      // When remove all button is pressed
            public void actionPerformed(ActionEvent e) {


                String phrase = messagePassed.getText();
                if(phrase.length() == 0) {


                    dispatchThis.setText("Word is empty.");

                }else {

                    phrase = phrase.toLowerCase();
                    boolean logic = false;                                                         // to check any deletion

                    for(int x = 0; x < storeLst.size(); x++) {


                        if(storeLst.get(x).toLowerCase().equals(phrase)) {

                            storeLst.remove(x);
                             logic = true;                                                               //flag variable

                        }

                    }


                    if(!logic) {
                        dispatchThis.setText("Error! Word not found.");
                    }else {
                        dispatchThis.setText("All Occurrences of word "+phrase+" are now deleted.");
                    }

                }

            }
        });


        clearList.addActionListener(new ActionListener() {                                             // When clear button is pressed
            public void actionPerformed(ActionEvent e) {


                storeLst.clear();
                dispatchThis.setText("All Occurrences Of The Specific Word Is Removed.");

            }
        });

    }


}
