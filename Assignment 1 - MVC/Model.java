

public class Model {
    
    private int x;
    private boolean maxSet;
    private int maxVal;
    
    public Model(){
        this.x = 0;
        this.maxSet = false;
        this.maxVal = -1;
    }
    public int incX(){
        if((this.maxSet) && (this.x >= this.maxVal)){
            return 1;
        }else {
            this.x++;
            return 0;
        }
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
        this.maxSet = true;
        this.maxVal = copy;
    }
}