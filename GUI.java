import java.awt.event.*; 
import javax.swing.*; 

public class GUI{
    public void runGUI() throws Exception{ 

        GameList game = new GameList(); 

        JFrame f=new JFrame("Superbowl Data");  //Creates a Frame with Title
        final JTextField tf=new JTextField();  //Creates a text Field
        tf.setBounds(215,56, 110,20); 
        //setBounds(x location, y location, width, height)
        JButton b1=new JButton("Number of wins");  //Creates a Button
        b1.setBounds(50,50,150,35);
        JButton b2=new JButton("Order by Year");  //Creates a Button
        b2.setBounds(50,100,200,35); 
        JButton b3=new JButton("Order by Winning team");  //Creates a Button
        b3.setBounds(50,150,200,35); 
        JButton b4=new JButton("Order by point Spread");  //Creates a Button
        b4.setBounds(50,200,200,35); 

            //The blocks of code below this tells the program what to do when the button is clicked.
            b1.addActionListener(new ActionListener(){ 
                public void actionPerformed(ActionEvent e){ 
                    String textFieldValue = tf.getText(); //Obtains String typed into text value 
                        int wins = game.numWins(textFieldValue); 
                        System.out.println(wins); 
                    } 
            });

            b2.addActionListener(new ActionListener(){ 
                public void actionPerformed(ActionEvent e){ 
                    game.sortByYear(); 
                    System.out.println(game.getSuperBowls()); 
                } 
            }); 
            
            b3.addActionListener(new ActionListener(){ 
                public void actionPerformed(ActionEvent e){ 
                    game.sortByWinningTeam(); 
                    System.out.println(game.getSuperBowls()); 
                } 
            }); 

            b4.addActionListener(new ActionListener(){ 
                public void actionPerformed(ActionEvent e){ 
                    game.sortByPointDifferential(); 
                    System.out.println(game.getSuperBowls()); 
                } 
            });

        //Adds objects to our GUI, and sets basic preferences
        f.add(tf);
        f.add(b1);
        f.add(b2); 
        f.add(b3); 
        f.add(b4);   
        f.setSize(400,600); 
        f.setLayout(null); 
        f.setVisible(true);
    }
}