package TaskScheduler.UI;

import TaskScheduler.Core.MVP.Presenter;
import TaskScheduler.Core.MVP.View;

import java.util.Scanner;

import static TaskScheduler.Config.pathDb;

public class App {

    public static void ButtonClick() {
        System.out.print("\033[H\033[J");// ru.stackoverflow.com/questions/1315049/Как-очистить-консоль-в-java-во-время-действия-программы
        View view = new ConsoleView();
        Presenter presenter = new Presenter(view, pathDb);

        try (Scanner in = new Scanner(System.in)) {

            while (true) {
                try (Scanner scanner = new Scanner(System.in)) {
                    while (true) {
                        System.out.println("Введите опцию - 1 - добавить запись; 2- вывести записи на экран; 3 - удалить запись");
                        String key = scanner.next();
                        System.out.print("\033[H\033[J");
                        switch (key) {
                            case "1":
                                presenter.add();

                                break;
                            case "2":
                                presenter.LoadFromFile();
                                break;
                            case "3":

                                presenter.remove();
                                break;

                            default:
                                System.out.println("Такой команды нет");
                                break;
                        }
                    }
                }
            }


        }
    }
}