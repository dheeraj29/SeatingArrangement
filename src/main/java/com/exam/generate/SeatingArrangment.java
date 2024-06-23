package com.exam.generate;

import java.util.HashMap;
import java.util.Map;

import com.exam.generate.exception.InsufficientSeats;
import com.exam.generate.model.SeatLocation;
import com.exam.generate.service.GenerateSeating;

public class SeatingArrangment 
{
    public static void main( String[] args ) throws InsufficientSeats
    {
    	//Can be changed. 40 students 4 branches and expected columns is 3. Hence array of 240 size
    	final int rows = 80;
    	final int columns = 3;
        
        //Initiating Branch
        Map<String,SeatLocation> branchLastSeat = new HashMap<>(Map.ofEntries(
        		Map.entry("CS",new SeatLocation(0,0)),
        		Map.entry("EC",new SeatLocation(0,0)),
        		Map.entry("EE",new SeatLocation(0,0)),
        		Map.entry("ME",new SeatLocation(0,0))));
        
        GenerateSeating generateseating = new GenerateSeating();
        final String[][] seatAssigned = generateseating.generate(rows, columns, branchLastSeat, "hallticket.txt");
        
        //Printing Output
        int unrev = 0;
        int i = 0;
        while(i < rows && unrev < 3) {
    		int j = 0;
    		while(j < columns) {
    			if(seatAssigned[i][j] != null) {
    				System.out.print(seatAssigned[i][j]+" ");
    				unrev = 0;
    			} else {
    				System.out.print("* ");
    				unrev++;
    			}
    			j++;
    		}
    		System.out.println("");
    		i++;
    	}
        
    }
}
