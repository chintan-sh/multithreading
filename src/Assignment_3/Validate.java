package Assignment_3;

import java.util.List;




/**
 *
 * @author : Chintan
 *
 * **/

/**
 * Validates a simulation
 */
public class Validate {
	private static class InvalidSimulationException extends Exception {
		public InvalidSimulationException() { }
	};

	// Helper method for validating the simulation
	private static void check(boolean check, String message) throws InvalidSimulationException {
		if (!check) {
			System.err.println("SIMULATION INVALID : "+message);
			throw new Validate.InvalidSimulationException();
		}
	}

	/** 
	 * Validates the given list of events is a valid simulation.
	 * Returns true if the simulation is valid, false otherwise.
	 *
	 * @param events - a list of events generated by the simulation
	 *   in the order they were generated.
	 *
	 * @returns res - whether the simulation was valid or not
	 */
	public static boolean validateSimulation(List<SimulationEvent> events) {
		boolean foundError = true;
		try {
			check(events.get(0).event == SimulationEvent.EventType.SimulationStarting,
					"Simulation didn't start with initiation event");

			check(Simulation.customersEntered == Simulation.customersLeft,
					"No of customers who entered and left are not same");

			check(Simulation.cooksInitiated == Simulation.cooksCreated,
					"No of cooks initiated are not same as no of cooks created");

			check(Simulation.tablesAvailableAtStart == Simulation.availableTables,
					"Total capacity of cafe not maintained");

			check(Simulation.totalOrderPlacedForMachines == Simulation.totalOrdersProcessedByMachines,
					"Total orders placed is not consistent with no of orders processed by machines");

			check(Simulation.customersPlacedOrder == Simulation.customersReceivedOrder,
					"Total orders placed is not consistent with no of orders customer received");

			check(events.get(events.size()-1).event ==
					SimulationEvent.EventType.SimulationEnded,
					"Simulation didn't end with termination event");



			return true;
		} catch (InvalidSimulationException e) {
			return false;
		}
	}
}
