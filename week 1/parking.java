import java.util.Arrays;
import java.util.Scanner;

class Car{
    String RegNo;
    String make;
    //create constructor
    public Car(String RegNo, String make){
        this.RegNo = RegNo;
        this.make = make;
    }
}


class parkingLot {
    public Car queue[];
    public int population;
    public parkingLot(){
        this.queue = new Car[10];
        this.population = 0;
    }

    public void addCar(Car car){
        if(this.population < 10){
            this.queue[this.population] = car;
            this.population++;
        } else {
            System.out.println("Deck is full");
        }
    }
    public Car front(){
        if(this.population > 0){
            return this.queue[0];
        } else {
            // System.out.println("queue is empty");
            return null;
        }
    }

    public Car dequeue(){
        if(this.population > 0){
            Car first = this.queue[0];
            this.queue = Arrays.copyOfRange(this.queue, 1, this.population);
            this.population--;
            return first;
        } else {
            // System.out.println("Deck is empty");
            return null;
        }

    }
}

class parking{
    public static void main(String[] args){
        parkingLot myParkingLot = new parkingLot();

        // take input if the user wants to do operations
        Scanner input = new Scanner(System.in);
        
        //asking if the users want to do operations
        String operation = "pass";

            
        while (!operation.equals("exit")){
            // get operation place, peek or draw
            if(operation.equals("add")){
                //get input of suit and value seperated by space
                System.out.println("Enter Regno and make seperated by space");
                String Suit = input.next();
                String Value = input.next();
                Car car = new Car(Suit, Value);
                myParkingLot.addCar(car);
                System.out.println("Car added"+ "\n");

            } else if(operation.equals("front")) {
                Car car = myParkingLot.front();
                if (car != null) {
                    System.out.println(car.RegNo + " " + car.make+ "\n");
                }else {
                    System.out.println("the queue is empty" + "\n");
                }
           
            } else if (operation.equals("remove")){
                Car temp = myParkingLot.dequeue();
                
                if (temp != null){
                    System.out.println("the car removed from queue is:  " + temp.RegNo + " of make" + temp.make+ "\n");
                } else {
                    System.out.println("the queue is empty"+ "\n");
                }
            }

            System.out.println("Enter operation: add or front or remove");
            operation = input.next();
    

        }
        input.close();

    }
}