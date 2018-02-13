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