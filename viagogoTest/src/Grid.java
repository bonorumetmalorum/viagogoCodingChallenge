
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Govind
 */
public class Grid {
    private ArrayList<Event> events;
    private Integer userX, userY = 0;
    private int searchLimit;
    private int xMin, xMax, yMin, yMax;
    
    /**
     * The grid is the space in which all events will be created and plotted
     * @param events the list of events to plot
     * @param xMin the minimum x value
     * @param xMax the maximum x value
     * @param yMin the minimum y value
     * @param yMax the maximum y value
     * @param searchLimit the search radius
     */
    public Grid(ArrayList<Event> events, int xMin, int xMax, int yMin, int yMax, int searchLimit){
        this.events = events;
        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax = yMax;
        this.searchLimit = searchLimit;
    }
    
    /**
     * This method sets the users location on the grid
     * @param x the x coordinate of the user
     * @param y the y coordinate of the user
     */
    public void userCoordinates(int x, int y) throws IndexOutOfBoundsException{
        if(x > xMax | x < xMin | y > yMax | y < yMin){
            throw new IndexOutOfBoundsException("invalid coordinates, you are out of range");
        }else{
            userX = (Integer)x;
            userX = (Integer)y;
        }
    }
    
    /**
     *This method sorts and returns the events within the grid by the manhattan distance
     * @return List containing the events within the grid space sorted by
     */
    public List<Event> getClosestEvent(){
        List<Event> closestEvents = new ArrayList<>();
        if(userX == null | userY == null){
            System.out.println("no user coordinates specified");
        }else{
            Collections.sort(events, (Event o1, Event o2) -> {
                Integer a = manhattanDistance(o1);
                Integer b = manhattanDistance(o2);
                return a.compareTo(b);
            });
            if(events.size() <= searchLimit ){
                closestEvents = events;
            }else{
            closestEvents = events.subList(0, searchLimit);
            }
        }
        return closestEvents;
    }
    
    /**
     * Calculates the manhattan distance from the users location to the event location
     * @param e the event to which the distance will be calculated
     * @return the integer representation of the manhattan distance to the event
     */
    public int manhattanDistance(Event e){
        int distance = Math.abs(e.getXCoordinate() - userX) + Math.abs(e.getYCoordinate() - userY);
        return distance;
    }
}
