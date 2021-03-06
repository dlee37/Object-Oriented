//Daniel Lee

package hw.hw3;

import javax.swing.JOptionPane;

public class HW3Simulation {
    private static final int SIMULATION_TIME = 10000;
    private static DiningHall d;
    private static ItemDistribution dist;
    private static int maxItems;
    
    public static void main(String[] args) {
        int standard = howManyNormalCashiers();
        int fast = howManyFastCashiers();
        
        
        setMaxItems();
        setDistributionType();
        d = new DiningHall(standard, fast, dist);
        d.setCashRegisters(); //this also includes cashiers as well
        
        for (int i = 0; i < SIMULATION_TIME; i++) {
            //System.out.println(i);
            d.elapseOneSecond(i);
        }
        
        d.printStats();
    }
    
    public static int howManyNormalCashiers() {
        String msg = "How many normal cashiers are in the dining hall?";
        String normalCashiers = JOptionPane.showInputDialog(msg);
        //System.out.println(normalCashiers);
        return Integer.parseInt(normalCashiers);
    }
    
    public static int howManyFastCashiers() {
        String msg = "How many fast cashiers are in the dining hall?";
        String fastCashiers = JOptionPane.showInputDialog(msg);
        //System.out.println(fastCashiers);
        return Integer.parseInt(fastCashiers);
    }
    
    public static void setDistributionType() {
        String msg = "Type u for uniform, or b for binormal distribution of items.";
        String distribution = JOptionPane.showInputDialog(msg);
        if (distribution.equals("u") || distribution.equals("U")) {
            dist = new Uniform(maxItems);
            //System.out.println(dist);
        }
        
        else { // just sets to bimodal if there is an incorrect answer
            dist = new Bimodal(maxItems);
            //System.out.println(dist);
        }
    }
    
    public static void setMaxItems() {
        String msg = "What is the maximum amount of items a person can carry?";
        String ans = JOptionPane.showInputDialog(msg);
        maxItems = Integer.parseInt(ans);
        //System.out.println(maxItems);
    }
}