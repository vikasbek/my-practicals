package com.sample.test.design.vendingMachine1;

public interface State {
   
   public void insertCoin()throws MachineWarning;
   public void pressButton()throws MachineWarning;
   public void dispense()throws MachineWarning;
}
