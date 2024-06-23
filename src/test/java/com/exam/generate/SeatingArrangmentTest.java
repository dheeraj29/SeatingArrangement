package com.exam.generate;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.exam.generate.exception.InsufficientSeats;
import com.exam.generate.model.SeatLocation;
import com.exam.generate.service.GenerateSeating;

public class SeatingArrangmentTest {
	
	private final GenerateSeating GenerateSeating = new GenerateSeating();
	
	@Test
	void NeighbourTest() throws InsufficientSeats {
		//Initiating Branch
        Map<String,SeatLocation> branchLastSeat = new HashMap<>(Map.ofEntries(
        		Map.entry("CS",new SeatLocation(0,0)),
        		Map.entry("EC",new SeatLocation(0,0)),
        		Map.entry("EE",new SeatLocation(0,0)),
        		Map.entry("ME",new SeatLocation(0,0))));
        try {
        	final String[][] output = GenerateSeating.generate(8, 3, branchLastSeat, "test-samples/neighbour.txt");
        	final String output1 = output[3][1].substring(0,2);
        	final String output2 = output[2][1].substring(0,2);
        	assertNotEquals(output1, output2);
        } catch(InsufficientSeats e) {
			fail("Neightbour test failed");
		}
	}
	
	@Test
	void IndexTest() throws InsufficientSeats {
		//Initiating Branch
        Map<String,SeatLocation> branchLastSeat = new HashMap<>(Map.ofEntries(
        		Map.entry("CS",new SeatLocation(0,0)),
        		Map.entry("EC",new SeatLocation(0,0)),
        		Map.entry("EE",new SeatLocation(0,0)),
        		Map.entry("ME",new SeatLocation(0,0))));
		try {
			final String[][] output = GenerateSeating.generate(4, 3, branchLastSeat, "test-samples/index.txt");
			assertNotNull(output[0][0]);
			assertNotNull(output[3][2]);
		} catch(InsufficientSeats e) {
			fail("Index test failed");
		}
	}
	
	@Test
	void InvalidBranchTest() throws InsufficientSeats {
		//Initiating Branch
        Map<String,SeatLocation> branchLastSeat = new HashMap<>(Map.ofEntries(
        		Map.entry("CS",new SeatLocation(0,0)),
        		Map.entry("EC",new SeatLocation(0,0)),
        		Map.entry("EE",new SeatLocation(0,0)),
        		Map.entry("ME",new SeatLocation(0,0))));
		try {
			final String[][] output = GenerateSeating.generate(4, 3, branchLastSeat, "test-samples/invalid-branch.txt");
			assertNull(output[0][0]);
		} catch(InsufficientSeats e) {
			fail("Branch test failed");
		}
	}
	
	@Test
	void InvalidHallTicketTest() throws InsufficientSeats {
		//Initiating Branch
        Map<String,SeatLocation> branchLastSeat = new HashMap<>(Map.ofEntries(
        		Map.entry("CS",new SeatLocation(0,0)),
        		Map.entry("EC",new SeatLocation(0,0)),
        		Map.entry("EE",new SeatLocation(0,0)),
        		Map.entry("ME",new SeatLocation(0,0))));
		try {
			final String[][] output = GenerateSeating.generate(4, 3, branchLastSeat, "test-samples/invalid-hallticket.txt");
			assertNull(output[0][0]);
		} catch(InsufficientSeats e) {
			fail("HallTicket test failed");
		}
	}
	
}
