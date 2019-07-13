package com.company;
import java.util.Scanner;
public class Accounts {
    public static Scanner scanner = new Scanner(System.in);
    private Account[] accountList;
    private int totalAccounts;

    public void Register(){
        System.out.print("Enter total of accounts: ");
        totalAccounts = scanner.nextInt();
        accountList = new Account[totalAccounts];
        for(int i=0; i<totalAccounts; i++){
            accountList[i] = new Account();
            System.out.println("Collecting data for each account.");
            accountList[i].Init();
            System.out.println();
        }
    }

    public void Transact(){
        boolean accFound = false;
        while(!accFound)
        {
            System.out.print("Enter account number for transaction.");
            int findingAcc = scanner.nextInt();
            for(int i=0; i<totalAccounts; i++)
            {
                if(findingAcc == accountList[i].getAcno())
                {
                    accFound = true;
                    int input;
                    boolean quit = false;
                    while(!quit) {
                        System.out.print("Enter 1 for deposit." +
                                          "\nEnter 2 for withdraw." +
                                          "\nEnter 3 to return." +
                                          "\nYour choice: ");
                        input = scanner.nextInt();
                        if (input == 1) {
                            System.out.print("Enter deposit value: ");
                            int Amt = scanner.nextInt();
                            accountList[i].Deposit(Amt);
                        } else if (input == 2) {
                            boolean validAmount = false;
                            while (!validAmount) {
                                System.out.print("Enter withdrawal value: ");
                                int Amt = scanner.nextInt();
                                if ((accountList[i].RBalance() - Amt) >= 500) {
                                    accountList[i].Withdraw(Amt);
                                    System.out.println("New balance: " + accountList[i].RBalance());
                                    validAmount = true;
                                } else {
                                    System.out.println("Invalid amount. Try again. Max allowed: " + (accountList[i].RBalance() - 500));
                                }
                            }
                        }else if(input == 3){
                            quit = true;
                        }
                    }
                }
            }
        }



    }

    public void DisplayALL(){
        for(int i=0; i<totalAccounts; i++){
            accountList[i].Show();
            System.out.println();
        }
    }

    public void Menu(){
        boolean quit = false;
        while(!quit){
            System.out.print("Enter 1 to Register accounts." +
                                "\nEnter 2 for transactions." +
                                "\nEnter 3 to display all accounts." +
                                "\nEnter 4 to quit." +
                                "\nEnter your choice: ");
            int userInput = scanner.nextInt();
            if(userInput == 1){
                Register();
            }else if(userInput == 2){
                Transact();
            }else if(userInput == 3){
                DisplayALL();
            }else if(userInput == 4){
                quit = true;
            }else{
                System.out.println("Invalid choice. Try again.");
            }

        }
    }

}
