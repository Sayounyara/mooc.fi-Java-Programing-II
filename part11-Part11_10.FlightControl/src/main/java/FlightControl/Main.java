package FlightControl;

import java.util.Scanner;
import flightControl.logic.FlightControl;
import flightControl.ui.TextUI;

public class Main {

    public static void main(String[] args) {
        FlightControl flightCtrl = new FlightControl();
        Scanner scanner = new Scanner(System.in);
        
        new TextUI(flightCtrl, scanner).start();
    }
}
