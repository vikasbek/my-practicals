package com.sample.test.design.vendingMachine1;

import java.io.Serializable;
import java.util.Arrays;
import java.util.stream.Collectors;

class SerializableTest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}

public class Test {
	public Test() {}

	public static void main(String[] args) {
		String rupayAcquirer = "ICIR,HDFR";
		
		String bankIdStr = Arrays.asList(rupayAcquirer.split(",")).stream().map((p) -> {
			try {
				return p.trim();
			} catch (Exception e) {
//				LOGGER.error("Exception while using cacheDao.getBAnkId:{}, exception:{}", p, e);
			}
			return p;
		}).collect(Collectors.joining("','", "'", "'"));
		
		
		System.out.println(bankIdStr);
		
		
		
		VendingMachine machine = new VendingMachine();
		machine.reFill(2); //
		// First despense
		try {
			machine.insertCoin();
			machine.pressButton();
		} catch (MachineWarning e) {
			System.out.println("Test 1:" + e.getMessage());
		}
		// Second Test
		try {
			machine.insertCoin();
			machine.insertCoin();
			machine.pressButton();
		} catch (MachineWarning e) {
			System.out.println("Test 2:" + e.getMessage());
			try {
				machine.pressButton();
			} catch (MachineWarning f) {
				// TODO
			}
		}
		// Test THree
		try {
			machine.pressButton();
		} catch (MachineWarning e) {
			System.out.println("Test 3:" + e.getMessage());
		}
		// Test Four
		try {
			machine.insertCoin();
		} catch (MachineWarning e) {
			System.out.println("Test 4:" + e.getMessage());
		}
	}
}
