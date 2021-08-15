package com.sample.test.design.vendingMachine1;

public class VendingMachine {
	State coninInsertedState = new CoinInsertedState(this);
	State emptyState = new EmptyState(this);
	State noCoinInsertedState = new NoCoinInsertedState(this);
	State dispensingState = new DispensingState(this);
	State machineState = null;
	int capacity = 0;

	public VendingMachine() {
		machineState = noCoinInsertedState;
	}

	public void reFill(int count) {
		capacity += count;
		machineState = noCoinInsertedState;
	}

	/**
	 * Two Actions performed by MAchine
	 */
	public void insertCoin() throws MachineWarning {
		machineState.insertCoin();
	}

	public void pressButton() throws MachineWarning {
		machineState.pressButton();
		machineState.dispense();
		capacity--;
	}

	public boolean isEmpty() {
		if (capacity <= 0)
			return true;
		else
			return false;
	}

	public void setMachineState(State machineState) {
		this.machineState = machineState;
	}

	public State getMachineState() {
		return machineState;
	}

	public void setConinInsertedState(State coninInsertedState) {
		this.coninInsertedState = coninInsertedState;
	}

	public State getConinInsertedState() {
		return coninInsertedState;
	}

	public void setEmptyState(State emptyState) {
		this.emptyState = emptyState;
	}

	public State getEmptyState() {
		return emptyState;
	}

	public void setNoCoinInsertedState(State noCoinInsertedState) {
		this.noCoinInsertedState = noCoinInsertedState;
	}

	public State getNoCoinInsertedState() {
		return noCoinInsertedState;
	}

	public void setDispensingState(State dispensingState) {
		this.dispensingState = dispensingState;
	}

	public State getDispensingState() {
		return dispensingState;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}
}


// package statepattern;
// import statepattern.exception.MachineWarning;
// public class EmptyState implements State{
// VendingMachine machine;
// public EmptyState(VendingMachine machine) {
// this.machine = machine;
// }
// public void insertCoin() throws MachineWarning{
// throw new MachineWarning("Can not process the request");
// }
// public void pressButton() throws MachineWarning{
// throw new MachineWarning("Invalid Action");
// }
// public void dispense() throws MachineWarning{
// throw new MachineWarning("Invalid Action");
// }
// }


// package statepattern;
// import statepattern.exception.MachineWarning;
// public class NoCoinInsertedState implements State{
// VendingMachine machine;
// public NoCoinInsertedState(VendingMachine machine) {
// this.machine = machine;
// }
// public void insertCoin() throws MachineWarning{
// if (!machine.isEmpty()) {
// machine.setMachineState(machine.getConinInsertedState());
// }
// else {
// throw new MachineWarning("Can not process request .. Machine is out of stock");
// }
// }
// public void pressButton() throws MachineWarning{
// throw new MachineWarning("No coin inserted ..");
// }
// public void dispense() throws MachineWarning{
// throw new MachineWarning("Invalid Operation");
// }
// }


// package statepattern.test;
// import statepattern.exception.MachineWarning;
// import statepattern.VendingMachine;
// public class Test {
// public Test() {
// }
// public static void main(String[] args) {
// VendingMachine machine = new VendingMachine();
// machine.reFill(2); //
// //First despense
// try {
// machine.insertCoin();
// machine.pressButton();
// } catch (MachineWarning e) {
// System.out.println("Test 1:" + e.getMessage());
// }
// //Second Test
// try {
// machine.insertCoin();
// machine.insertCoin();
// machine.pressButton();
// } catch (MachineWarning e) {
// System.out.println("Test 2:" + e.getMessage());
// try {
// machine.pressButton();
// } catch (MachineWarning f) {
// // TODO
// }
// }
// //Test THree
// try {
// machine.pressButton();
// } catch (MachineWarning e) {
// System.out.println("Test 3:" + e.getMessage());
// }
// //Test Four
// try {
// machine.insertCoin();
// } catch (MachineWarning e) {
// System.out.println("Test 4:" + e.getMessage());
// }
// }
// }
