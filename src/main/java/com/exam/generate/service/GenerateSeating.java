package com.exam.generate.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import com.exam.generate.exception.InsufficientSeats;
import com.exam.generate.model.SeatLocation;

public class GenerateSeating {
	public final String[][] generate(int rows, int columns, Map<String,SeatLocation> branchLastSeat, String filePath) throws InsufficientSeats {
		String[][] seatAssigned = new String[rows][columns];
		try(BufferedReader bf = new BufferedReader(new FileReader(filePath))) {
        	
        	String hallTicket = null;
        	
        	//Reading File
        	while((hallTicket = bf.readLine()) != null) {
        		if(hallTicket.length() == 7 && hallTicket.matches("^[A-Z]{2}\\d+")) {
        			String branch = hallTicket.substring(0, 2);
        			SeatLocation currentLocation = branchLastSeat.containsKey(branch)?branchLastSeat.get(branch):null;
        			boolean seatfound = false;
        			if(currentLocation != null) {
        				for(int i = currentLocation.getRow(); i < rows; i++) {
        					
        					//Reset column on row completion
        					int j = (i == currentLocation.getRow())?currentLocation.getColumn():0;
        					seatfound = false;
        					while(j < columns) {
        						if(seatAssigned[i][j] == null) {
        							if(i - 1 >= 0 && seatAssigned[i-1][j] != null && !seatAssigned[i-1][j].startsWith(branch)) {
        								seatAssigned[i][j] = hallTicket;
        								branchLastSeat.put(branch, new SeatLocation(i,j+2));
        								seatfound = true;
        								break;
        							} else if(i == 0 || seatAssigned[i-1][j] == null) {
        								seatAssigned[i][j] = hallTicket;
        								branchLastSeat.put(branch, new SeatLocation(i,j+2));
        								seatfound = true;
        								break;
        							}
        						}
        						j++;
        					}
        					if(seatfound) break;
        				}
        				if(!seatfound) {
        					throw new InsufficientSeats("Seating Not Available");
        				}
        			} else {
        				System.out.println("Invalid Branch for hallTicket: "+hallTicket);
        			}
        		} else {
        			System.out.println("Invalid hallTicket number: "+hallTicket);
        		}
        	}
        	return seatAssigned;
        } catch (IOException e) {
        	System.out.println("File not found "+e.toString());
        	return null;
        }
	}
}
