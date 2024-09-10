package view;

import data.Database;
import entities.Worker;
import service.WorkerService;

import java.sql.Array;
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
        List<Integer> id = new ArrayList<>();
        List<Integer> salary = new ArrayList<>();
        List<String> name = new ArrayList<>();
        List[] menu = new List[5];
        for (Worker worker:Database.workers) {
            id.add(worker.getId());
            salary.add(worker.getSalary());
            name.add(worker.getName());
        }
        for (int i = 0; i < 3; i++) {
            while (i == 0) {
                menu[0] = id;
                break;
            }
            while (i == 1) {
                menu[1] = name;
                break;
            }
            while (i == 2) {
                menu[2] = salary;
                break;
            }
        }
        System.out.println(menu);
    }
}
