package view;

import data.Database;
import entities.Worker;
import service.WorkerService;

import java.sql.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    WorkerService workerService = new WorkerService();

//    startMenu
    public void startMenuDisplay () {
        System.out.println("======== Worker Management ========");
        System.out.println("    1. Add Worker");
        System.out.println("    2. Up salary");
        System.out.println("    3. Down salary");
        System.out.println("    4. Display Information salary");
        System.out.println("    5. Exit");
    }
    public void startMenuSelecttion (Scanner scanner) {
        boolean loop = true;
        while (loop == true) {
            startMenuDisplay();
            System.out.printf("Insert option selection: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("======== Add Worker ========");
                    Worker worker = workerService.addworker(scanner);
                    break;
                case 2:
                    System.out.println("======== Up salary ========");
                    Worker workerUp = workerService.codeLogin(scanner);
                    workerService.salaryUp(scanner, workerUp);
                    break;
                case 3:
                    System.out.println("======== Down salary ========");
                    Worker workerDown = workerService.codeLogin(scanner);
                    workerService.salaryDown(scanner, workerDown);
                    break;
                case 4:
                    informationMenuDisplay();
                    break;
                case 5:
                    loop = false;
                    break;
            }
        }
    }

//    informationMenu
    public void informationMenuDisplay () {
        System.out.println("---------------------Display Information Salary---------------------");
        System.out.println("Code        Name        Salary        Status        Date");
        for (Worker worker:Database.salaryInformation) {
            System.out.printf("W " + worker.getId());
            System.out.printf("        " + worker.getName());
            System.out.printf("        " + worker.getSalary());
            System.out.printf("        " + worker.getStatus());
            LocalDateTime updateTime = LocalDateTime.now();
            DateTimeFormatter Format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String formattedDate = updateTime.format(Format);
            System.out.println("        "+formattedDate);
        }

    }
}
