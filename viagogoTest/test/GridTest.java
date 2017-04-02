/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Govind
 */
public class GridTest {
    private static final Random rand = new Random();
    Grid grid;
    
    public GridTest() {
    }
    
    @Before
    public void setUp() {
         ArrayList<Event> events = new ArrayList<>();
         for(int j = 0; j < 10; j++){
             events.add(new Event(rand.nextInt(20) - 10, rand.nextInt(20) - 10, j, tickets()));
         }
         grid = new Grid(events, -10, 10, -10, 10, 5);
    }
    
    public ArrayList<Ticket> tickets(){
        ArrayList<Ticket>tickets = new ArrayList<>();
        for(int i = 0; i < 9; i++){
             tickets.add(new Ticket(rand.nextInt(90) + rand.nextDouble() + 10, rand.nextInt()));
         }
        return tickets;
    }

    /**
     * Test of userCoordinates method, of class Grid.
     */
    @Test
    public void test(){
        grid.userCoordinates(0, 0);
        for(Event e:grid.getClosestEvent()){
            System.out.println(e.getID() + " Distance: " + grid.manhattanDistance(e));
        }
    }
}
