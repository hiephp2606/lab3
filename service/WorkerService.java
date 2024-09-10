package service;

import data.Database;
import entities.Worker;

import java.sql.Struct;
import java.util.Scanner;

public class WorkerService {
    public Worker addworker (Scanner scanner) {
        int id = codeInput(scanner);
        System.out.printf("Enter Name: ");
        String name = scanner.nextLine();
        System.out.printf("Enter Age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.printf("Enter Salary: ");
        int salary = Integer.parseInt(scanner.nextLine());
        System.out.printf("Enter work location: ");
        String location = scanner.nextLine();
        Worker worker = new Worker(id,name, age, salary, location);
        Database.workers.add(worker);
//        Database.salaryInformation.add(new Worker(id, name,salary, "UP"));
        System.out.println("Adding successful!");

        return worker;
    }


    public Worker codeLogin (Scanner scanner) {
        Worker workers = null;
        int inputCode;
        do {
            System.out.printf("Enter Code: ");
            int code = Integer.parseInt(scanner.nextLine());
            inputCode = code;
            Worker worker = codeFinder(inputCode);
            if (worker == null) {
                System.out.println("This code doesn't exists! Please enter again");
            }
            else {
                workers = worker;
            }
        } while (codeFinder(inputCode) == null);


        return workers;
    }

//    updateService
    public void salaryUp (Scanner scanner, Worker worker) {
        boolean loop = true;
        int salary = 0;
        while (loop == true) {
            System.out.printf("Insert new salary: ");
            int salaryUpdate = Integer.parseInt(scanner.nextLine());
            if (salaryUpdate > worker.getSalary()) {
                worker.setStatus("UP");
                Database.salaryInformation.add(new Worker(worker.getId(), worker.getName(), salaryUpdate, "UP"));
                loop = false;
            }
            else {
                System.out.println("New salary must higher than the previous one");
            }
        }
        System.out.println("Update salary successfully");
    }
    public void salaryDown (Scanner scanner, Worker worker) {
        boolean loop = true;
        int salary = 0;
        while (loop == true) {
            System.out.printf("Insert new salary: ");
            int salaryUpdate = Integer.parseInt(scanner.nextLine());
            if (salaryUpdate < worker.getSalary()) {
                worker.setSalary(salaryUpdate);
                worker.setStatus("DOWN");
                Database.salaryInformation.add(new Worker(worker.getId(), worker.getName(), salaryUpdate, "DOWN"));
                loop = false;
            }
            else {
                System.out.println("New salary must lower than the previous one");
            }
        }
        System.out.println("Update salary successfully");
    }

//    checkService
    public Worker codeFinder (int code) {
        for (Worker worker: Database.workers) {
            if (worker.getId() == code) {
                return worker;
            }
        }
        return null;
    }

    public int codeInput (Scanner scanner) {
        int input = 1;
        boolean loop = true;
        do {
            System.out.printf("Enter Code: ");
            int code = Integer.parseInt(scanner.nextLine());
            if (codeFinder(code) != null) {
                System.out.println("This code already exists! Please enter again");
            }
            else {
                input = code;
                loop = false;
            }
        } while (loop == true);

        return input;
    }

}
