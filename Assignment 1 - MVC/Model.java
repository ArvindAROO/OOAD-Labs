

public class Model {
    
    private int x;
    
    public Model(){
        this.x = 0;
    }
    public void incX(){
        this.x++;
    }

    public void decX(){
        this.x--;
    }
    
    public int getX(){
        return this.x;
    }

    public void resetX(){
        this.x = 0;
    }

    public void setX(int copy){
        this.x = copy;
    }
}