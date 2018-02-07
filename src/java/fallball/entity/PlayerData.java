/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fallball.entity;

import java.util.List;

/**
 *
 * @author Alumno-CT
 */
public class PlayerData {
    //STATIC INNER CLASSES ALLOW US TO INSTATIATE THEM WITHOUT HAVING AN INSTANCE OF ITS CONTAINER CLASS
    //USE NESTED CLASSES SINCE JAVA DOES NOT SUPPORT STRUCTS
    public static class Player{
        public int playerId;
        public String playerName;
        public float playerScore;
        public int level;
        /*public boolean lastPlayer;
        public float posX;
        public float posY;*/
        
        public Player(){
        }
        
        public Player(String playerName, float playerScore, int level){
            this.playerName = playerName;
            this.playerScore = playerScore;
            this.level = level;
        }
        
    }
    
    public List<Player> playerChart;
    public boolean level2Enabled;
    public boolean level3Enabled;
    public boolean ball2Enabled;
    public boolean ball3Enabled;
    public String currentSprite;
    
    public PlayerData(){
    }
}
