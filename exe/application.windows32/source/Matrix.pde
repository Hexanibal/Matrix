ArrayList<Column> columns = new ArrayList();

void setup(){
    //size(1000, 600);
    fullScreen(SPAN);
      
    for(int i = 0; i < (int) width / 11 + 5; i++){
        columns.add(new Column(i));
    }
}

void draw(){
    background(0);
    for(Column c : columns){
        c.update(); 
    }  
}