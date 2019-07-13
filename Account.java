package com.company;

import java.util.Scanner;

public class Account {
    public static Scanner scanner = new Scanner(System.in);
    private int Acno;
    private String Name;
    private float Balance;

    public void Init(){
        System.out.print("Enter account number: ");
        Acno = scanner.nextInt();
        System.out.print("Enter client name: ");
        Name = scanner.nextLine();
        Name = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        Balance = scanner.nextFloat();
    }

    public void Show() {
        System.out.println("com.company.Account{" +
                "Acno=" + Acno +
                ", Name='" + Name + '\'' +
                ", Balance=" + Balance +
                '}');
    }

    public void Deposit(int Amt){
        Balance += Amt;
    }

    public void Withdraw(int Amt){
        if((Balance-Amt)>=500){
            Balance -= Amt;
        }
    }

    public float RBalance() {
        return Balance;
    }

    public int getAcno() {
        return Acno;
    }
}
