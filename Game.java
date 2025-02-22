public class Game{ 
    // instance variables
    private String numeral; 
    private int year; 
    private String location; 
    private String winningTeam; 
    private String losingTeam; 
    private String score; 
    
    // Game constructor 
    public Game(String n, int y, String l, String wT, String lT, String s){ 
        numeral = n; 
        year = y; 
        location = l; 
        winningTeam = wT; 
        losingTeam = lT; 
        score = s; 
    } 
    
    // getter for numeral 
    public String getNumeral(){ 
        return numeral; 
    } 
    
    // setter for numeral 
    public void setNumeral(String n){ 
        numeral = n; 
    } 
    
    // getter for year
    public int getYear(){ 
        return year; 
    } 
    
    // setter for year 
    public void setYear(int y){ 
        year = y; 
    } 
    
    // getter for location 
    public String getLocation(){
        return location; 
    }
    
    // setter for location 
    public void setLocation(String l){ 
        location = l; 
    } 
    
    // getter for winning team 
    public String getWinningTeam(){ 
        return winningTeam; 
    } 
    
    // setter for winning team 
    public void setWinningTeam(String wT){ 
        winningTeam = wT; 
    } 
    
    // getter for losing team 
    public String getLosingTeam(){ 
        return losingTeam; 
    } 
    
    // setter for losing team 
    public void setLosingTeam(String lT){ 
        losingTeam = lT; 
    } 
    
    // getter for score 
    public String getScore(){ 
        return score; 
    } 
    
    // setter for score 
    public void setScore(String s){ 
        score = s; 
    } 
    
    // toString 
    public String toString(){ 
        return "\nSuperbowl " + numeral + ": " + winningTeam + " defeated " + losingTeam + "\nScore: " + score + "\nYear: " + year + "\nLocation: " + location + "\n"; 
    }
}