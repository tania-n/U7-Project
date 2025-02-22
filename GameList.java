import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GameList{ 
    // instance variables 
    private ArrayList<Game> superBowls;
    private String numeral;
    private int year;
    private String location;
    private String winningTeam;
    private String losingTeam;
    private String score;
    
    public GameList() throws Exception{ 
        superBowls = new ArrayList<Game>(); 
        // opens the txt file
        File file = new File("SuperBowlData.txt");
        Scanner text = new Scanner(file); 
        // outside of while loop to skip the first line in the txt file 
        String str = text.nextLine();

        // loops through each line in the txt file 
        while(text.hasNextLine()){
            str = text.nextLine();
            // finds the index of every "-" in the line 
            int index1 = str.indexOf(",");
            int index2 = str.indexOf(",", index1 + 1);
            int index3 = str.indexOf(",", index2 + 1);
            int index4 = str.indexOf(",", index3 + 1);
            int index5 = str.indexOf(",", index4 + 1);
            int index6 = str.indexOf(",", index5 + 1);
            int index7 = str.indexOf(",", index6 + 1);
            int index8 = str.indexOf(",", index7 + 1);
            
            // saves the information between every "-" 
            String numeral = str.substring(0, index1);
            int year = Integer.valueOf(str.substring(index2 + 2, index3 - 1));
            String winningTeam = str.substring(index3 + 1, index4);
            String score = str.substring(index4 + 1, index5);
            String losingTeam = str.substring(index5 + 1, index6);
            String location = str.substring(index7 + 2, index8);
            
            // creates a new Game object and adds it to superBowls 
            Game g = new Game(numeral, year, location, winningTeam, losingTeam, score);
            superBowls.add(g);
        }
    }

    // getter for superBowls 
    public ArrayList<Game> getSuperBowls(){
        return this.superBowls;
    }
  
    public int numWins(String teamName){
        int count = 0; 
        // loops through each game in superbowls 
        for(Game game : superBowls){ 
            // if the winningTeam in the game matches the teamName 
            // count increases by 1
            if(game.getWinningTeam().equals(teamName)){
                count++;
            }
        }
        return count;
    }
  
    public void sortByYear(){ 
        for(int i = 0; i < superBowls.size() - 1; i++){
            for(int j = 0; j < superBowls.size() - i - 1; j++){  
                // checks if the year at index j is greater than the year at the index after j 
                if(superBowls.get(j).getYear() > superBowls.get(j + 1).getYear()){
                    // saves the game at index j to temp 
                    Game temp = superBowls.get(j);
                    // switches the game at index j and the game after index j 
                    superBowls.set(j, superBowls.get(j + 1));
                    superBowls.set(j + 1, temp);
                }
            }
        }
    }
  
    public void sortByWinningTeam(){
        for(int i = 0; i < superBowls.size(); i++){ 
            Game min = superBowls.get(i);
            int minIndex = i;
                for(int j = i; j < superBowls.size(); j++){ 
                    // checks if the value of the winningTeams is less than 0 
                    if(superBowls.get(j).getWinningTeam().compareTo(superBowls.get(minIndex).getWinningTeam()) < 0){
                        // changes min to the game at index j 
                        min = superBowls.get(j);
                        minIndex = j;
                    }
                } 
            // switches the game at index i and min 
            superBowls.set(minIndex, superBowls.get(i));
            superBowls.set(i, min);
        }
    }
  
   public void sortByPointDifferential(){
        for(int i = 0; i < superBowls.size(); i++){  
            // gets the number before and after "-" for the game at index i 
            int score1 = Integer.valueOf(superBowls.get(i).getScore().substring(0, 2));
            int score2 = Integer.valueOf(superBowls.get(i).getScore().substring(3));
            // gets the difference
            int min = Math.abs(score1 - score2); 
            Game score = superBowls.get(i); 
            int minIndex = i;
                for(int j = i; j < superBowls.size(); j++){ 
                    // gets the number before and after "-" for the game at index j 
                    int score3 = Integer.valueOf(superBowls.get(j).getScore().substring(0, 2));
                    int score4 = Integer.valueOf(superBowls.get(j).getScore().substring(3));
                    // gets the difference 
                    int difference = Math.abs(score3 - score4); 
                    // checks if the difference of score3 and score4 is greater than min 
                    if(difference > min){
                        min = difference; 
                        score = superBowls.get(j); 
                        minIndex = j;
                    }
               } 
            // swiches the game at index i and score 
            superBowls.set(minIndex, superBowls.get(i));
            superBowls.set(i, score);
        }
    }
}
