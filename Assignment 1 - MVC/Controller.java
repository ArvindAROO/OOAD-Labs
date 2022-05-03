import java.awt.event.*;

public class Controller {

    private Model model;
    private View view;
    private ActionListener incActionListener;
    private ActionListener decActionListener;
    private ActionListener resetActionListener;
    private ActionListener setActionListener;
    
    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
                          
    }
    
    public void control(){        
        incActionListener = new ActionListener() {
                public void actionPerformed(ActionEvent actionEvent) {                  
                    incLinkBtnAndLabel();
                }
        };                
        view.getIncButton().addActionListener(incActionListener);   

        decActionListener = new ActionListener() {
                public void actionPerformed(ActionEvent actionEvent) {                  
                    decLinkBtnAndLabel();
                }
        };
        view.getDecButton().addActionListener(decActionListener);

        resetActionListener = new ActionListener() {
                public void actionPerformed(ActionEvent actionEvent) {                  
                    resetLinkBtnAndLabel();
                }
        };
        view.getResetButton().addActionListener(resetActionListener);

        setActionListener = new ActionListener() {
                public void actionPerformed(ActionEvent actionEvent) {                  
                    setLinkBtnAndLabel();
                }
        };
        view.getSetButton().addActionListener(setActionListener);
    }
    
    private void incLinkBtnAndLabel(){
        int flag = model.incX();   
        if(flag == 0){
            view.setText(Integer.toString(model.getX()));
        }else{
            view.setText("Max value reached");
            view.createPopUP();
        }    
    }
    private void decLinkBtnAndLabel(){
        model.decX();   
        view.setText(Integer.toString(model.getX()));
    }

    private void resetLinkBtnAndLabel(){
        model.resetX();   
        view.setText(Integer.toString(model.getX()));
    }

    private void setLinkBtnAndLabel(){
        //handle exception of non integers being passed
        try{
            int copy = Integer.parseInt(view.input1.getText());
        
            model.setX(copy);
            view.setText(Integer.toString(model.getX()));
        } catch(NumberFormatException e){
            view.setText("Invalid integer");
        }
        
    }
}