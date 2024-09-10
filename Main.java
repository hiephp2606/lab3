import view.Menu;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();

        menu.startMenuSelecttion(scanner);


//        LocalDateTime updateTime = LocalDateTime.now();
//        DateTimeFormatter Format = DateTimeFormatter.ofPattern("dd / MM / yyyy");
//        String formattedDate = updateTime.format(Format);
//        System.out.println(formattedDate);

    }
}
