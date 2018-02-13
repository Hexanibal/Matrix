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
        speed =  5.5 + random(5);  
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