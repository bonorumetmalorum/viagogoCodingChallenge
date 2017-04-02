
import java.text.DecimalFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Govind
 */
public class Ticket{

    private double price;
    private int numberOfTickets;
    private DecimalFormat decFormat = new DecimalFormat("##.##");

    public Ticket(Double price, int quantity){
        numberOfTickets = quantity;
        decFormat = new DecimalFormat("#00.##");
        this.price = Double.parseDouble(decFormat.format(price));

    }
    /**
     * returns the price of this ticket
     * @return float price
     */
    public Double getPrice(){
        return price;
    }
    /**
     * get the number of available tickets for sale of this type
     * @return int number of tickets
     */
    public int getNumberOfTickets(){
        return numberOfTickets;
    }
}
