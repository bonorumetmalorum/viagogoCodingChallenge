
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.zip.InflaterInputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Govind
 */
public class Run {
    private static final Random rand = new Random();
    private static int x;
    private static int y;
    
    /**
     * creates a scanner and reads in user input
     */
    public static void reader(){
        Scanner scanner = new Scanner(System.in);
        while(!scanner.hasNextInt()){
            System.out.println("please specify x and y coordinates like so: 5 6");
            scanner.nextLine();
        }
        x = scanner.nextInt();
        y = scanner.nextInt();
        
    }
    
    /**
     * main method to run program according to specification in brief
     * @param args command line arguments
     */
    public static void main(String[] args){
        System.out.println("Please input coordinates");

        ArrayList<Event> events = new ArrayList<>();
        Grid grid = new Grid(events, -10, 10, -10, 10, 5);
        //retry while the input is still wrong
        boolean valid = false;
        while(!valid){
            try{
                reader();
                grid.userCoordinates(x, y);
                valid = true;
            }catch(IndexOutOfBoundsException e){
                System.out.println(e.getMessage());
                valid = false;
            }
        }
        
        //setting the upper bound on the number of events in the graph.
        int numberOfEvents = rand.nextInt(10) + 1;
        //used to set the maximum number of ticket types an event can have
        int numberOfTickets;
        //create the array of event, where for each event there is an array of tickets.
        for(int i = 0; i < numberOfEvents; i++){
            ArrayList<Ticket> tickets = new ArrayList<>();
            numberOfTickets = rand.nextInt(100);
            for(int j = 0; j < numberOfTickets; j++){
                tickets.add(new Ticket((rand.nextDouble() + rand.nextInt(100))));
            }
            events.add(new Event(rand.nextInt(20) -10, rand.nextInt(20) -10, i, tickets));
        }
        //get the closest list of events
        List<Event>closest = grid.getClosestEvent();
        //print out the closest events
        for(Event e : closest){
            Double cheapestTicket = e.getCheapestTicket();
            if(cheapestTicket == null){
                System.out.println("Event: " + e.getID() + " - no tickets available" + ", Distance " + grid.manhattanDistance(e));
            }else{
                System.out.println("Event: " + e.getID() + " - $" + e.getCheapestTicket() + ", Distance " + grid.manhattanDistance(e));
            }
        }
    }
}
