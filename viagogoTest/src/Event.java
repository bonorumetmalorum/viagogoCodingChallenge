
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.management.RuntimeErrorException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Govind
 */
public class Event{
    private int x;
    private int y;
    private ArrayList<Ticket> tickets;
    private final int iD;
    
    /**
     * The event 
     * @param x x coordinate of the event
     * @param y y coordinate of the event
     * @param ID Unique iD of the event
     * @param tickets Arraylist of tickets being sold at the event
     */
    public Event(int x, int y, int ID, ArrayList<Ticket> tickets){
        this.x = x;
        this.y = y;
        this.iD = ID;
        this.tickets = tickets;
    }
    
    /**
     * sorts the tickets by cheapest price first and returns the cheapest price
     * @return a float value of the cheapest ticket price
     */
    public Double getCheapestTicket() throws RuntimeException{
        if(tickets.size() != 0){
            Collections.sort(tickets, (Ticket o1, Ticket o2) -> o1.getPrice().compareTo(o2.getPrice()));
            return tickets.get(0).getPrice();
        }
        return null;
    }
    /**
     * gives the events current ticket list, ordered or unordered
     * @return 
     */
    public ArrayList<Ticket> getTickets(){
        return tickets;
    }
    
    /**
     * the x coordinate of the event
     * @return int x coordinate
     */
    public int getXCoordinate(){
        return x;
    }
    
    /**
     * the y coordinate of the event
     * @return int y coordinate of event
     */
    public int getYCoordinate(){
        return y;
    }
    
    /**
     * The iD of this event
     * @return int iD of event
     */
    public int getID(){
        return iD;
    }
}
