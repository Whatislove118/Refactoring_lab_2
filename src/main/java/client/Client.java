package client;

import model.State;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        ConsoleApp app=new ConsoleApp();
        Scanner scanner = new Scanner(System.in);
        app.print();
        while(scanner.hasNext()){
            app.handle(scanner.next());
            app.print();

        }
    }
}
