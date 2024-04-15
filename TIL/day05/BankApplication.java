package com.shinhan.day05;

import java.util.Scanner;

public class BankApplication {
    String accNum;
    String accNm;
    int balance;
    static Scanner sc = new Scanner(System.in); // Scanner 객체를 정적으로 선언하여 메서드에서 사용 가능하게 함

    public BankApplication(String accNum, String accNm, int balance) {
        this.accNum = accNum;
        this.accNm = accNm;
        this.balance = balance;
        System.out.println("계좌가 생성되었습니다.");
    }

    public void save(int amount) {
        balance += amount;
    }

    public int withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("출금이 성공되었습니다.");
            return amount;
        } else {
            System.out.println("잔고가 부족합니다.");
            return 0;
        }
    }

    public static void main(String[] args) {
        boolean isGo = true;
        BankApplication[] arr = new BankApplication[5];
        int index = 0;

        while (isGo) {
            menuPrint();
            System.out.print("선택> ");
            int job = sc.nextInt();
            switch (job) {
                case 1:
                    System.out.println("---------");
                    System.out.println("계좌 생성");
                    System.out.println("---------");
                    if (index == arr.length) {
                        System.out.println("더 이상 계좌 생성 불가");
                        break;
                    }

                    System.out.print("계좌번호: ");
                    String accNum = sc.next();
                    System.out.print("계좌주: ");
                    String accNm = sc.next();
                    System.out.print("초기입금금액: ");
                    int balance = sc.nextInt();

                    arr[index++] = new BankApplication(accNum, accNm, balance);
                    break;
                case 2:
                    System.out.println("---------");
                    System.out.println("계좌 목록");
                    System.out.println("---------");
                    for (BankApplication acc : arr) {
                        if (acc == null)
                            break;
                        System.out.printf("계좌번호: %s, 계좌주: %s, 잔액: %d\n", acc.accNum, acc.accNm, acc.balance);
                    }
                    break;
                case 3:
                    inputAccount(arr, index); // 예금 기능 호출
                    break;
                case 4:
                    outputAccount(arr, index); // 출금 기능 호출
                    break;
                case 5:
                    isGo = false;
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
        }
        sc.close();
    }

    private static void outputAccount(BankApplication[] arr, int index) {
        System.out.print("계좌번호> ");
        String accNum = sc.next();
        System.out.print("출금액> ");
        int amount = sc.nextInt();
        for (int i = 0; i < index; i++) {
            if (accNum.equals(arr[i].accNum)) {
                arr[i].withdraw(amount);
                break;
            }
        }
    }

    private static void inputAccount(BankApplication[] arr, int index) {
        System.out.print("계좌번호> ");
        String accNum = sc.next();
        System.out.print("예금액> ");
        int amount = sc.nextInt();
        for (int i = 0; i < index; i++) {
            if (accNum.equals(arr[i].accNum)) {
                arr[i].save(amount);
                break;
            }
        }
    }

    private static void menuPrint() {
        System.out.println("-----------------------------------");
        System.out.println("1. 계좌 생성 | 2. 계좌 목록 | 3. 예금 | 4. 출금 | 5. 종료");
        System.out.println("-----------------------------------");
    }
}
