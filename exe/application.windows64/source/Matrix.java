import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Matrix extends PApplet {

ArrayList<Column> columns = new ArrayList();

public void setup(){
    //size(1000, 600);
    
      
    for(int i = 0; i < (int) width / 11 + 5; i++){
        columns.add(new Column(i));
    }
}

public void draw(){
    background(0);
    for(Column c : columns){
        c.update(); 
    }  
}
class Char{

    String[] chars = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    String c;
    PVector loc;
    boolean first;
    int opacity;

    public Char(PVector loc, boolean first, int opacity){
        this.loc = loc;
        this.first = first;
        this.opacity = opacity;
        this.c = chars[(int) random(chars.length - 1)];
    }
  
    public void display(){
        if(first)
            fill(255); 
        else
            fill(0, opacity, 0);
      
        text(c, loc.x, loc.y);
    }
}
class Column{
 
    final int charHeight = 10;
    final int cPerCol = 37;
  
    int rank;  
    ArrayList<Char> chars;
    float speed;
    PVector loc;  
  
  
    public Column(int rank){
        this.rank = rank;          
        randomizeColumn();
    }
     
    private void randomizeColumn(){
        loc = new PVector(rank * 11, -600); 
        chars = new ArrayList();    
        speed =  5.5f + random(5);  
        int opacity;
       
         for(int i = 0; i < cPerCol; i++){
             opacity = 255 - i * (255 / (cPerCol - 4));
             chars.add(new Char(new PVector(loc.x, loc.y - i * charHeight), i == 0, opacity));
         }
    }
  
    public void update(){
        loc.y = chars.get(0).loc.y;
    
        if(loc.y - cPerCol * charHeight > height + 20){
            randomizeColumn();
        }
    
        for(Char c : chars){
            c.loc.y += speed;
            c.display();
        }  
    }
}
    public void settings() {  fullScreen(SPAN); }
    static public void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "Matrix" };
        if (passedArgs != null) {
          PApplet.main(concat(appletArgs, passedArgs));
        } else {
          PApplet.main(appletArgs);
        }
    }
}
