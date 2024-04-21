package PracticeJava;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class NotebookOne {
    public static void main(String[] args) {
        Notebook note1 = new Notebook(4, 250, "Windows", "grey", "IPS", "HDD");
        Notebook note2 = new Notebook(8, 250, "Windows", "black", "VA", "HDD");
        Notebook note3 = new Notebook(16, 500, "Linux", "black", "AMOLED", "SSD");
        Notebook note4 = new Notebook(16, 1000, "MacOs", "white", "OLED", "HDD");
        Notebook note5 = new Notebook(4, 250, "Windows", "grey", "IPS", "HDD");

        HashSet<Notebook> notes = new HashSet<Notebook>();

        notes.add(note1);
        notes.add(note2);
        notes.add(note3);
        notes.add(note4);
        notes.add(note5);

        for (Notebook note : notes) {
            System.out.println(note);
        }

        Scanner scanner = new Scanner(System.in);
        Map<String, String> listOptions = new HashMap<>();
        System.out.println(
                "Введите цифру показателя, который вас интересует: 1. ОЗУ, 2. Объем ЖД, 3. Операционная систама, 4. Цвет, 5. Экран, 6. Накопитель, 7. Выход");
        String answer = "yes";
        while (answer.equals("yes")) {
            getChoice(scanner, listOptions);
            System.out.println("Выбрать еще один параметр?  yes/no");
            answer = scanner.nextLine();
        }
        System.out.println(listOptions);
        HashSet<Notebook> listNew = new HashSet<Notebook>();
        listNew = checkListOptions(listOptions, notes);
        
        System.out.println("Ноутбуки, подходящие по выбранным вами параметрам: ");
        for (Notebook note : listNew) {
            System.out.println(note);
        }
    }

    public static HashSet<Notebook> checkListOptions(Map<String, String> listOptions, HashSet<Notebook> notes) {
        HashSet<Notebook> listNew = new HashSet<Notebook>();
        Set<String> myArray = listOptions.keySet();
        for (String key : myArray) {
            System.out.println(key);
            System.out.println(listOptions.get(key));
            for (Notebook note : notes) {
                checkKeys(listOptions, listNew, key, note);
            }
        }
        return listNew;
    }

    private static void checkKeys(Map<String, String> listOptions, HashSet<Notebook> listNew, String key,
            Notebook note) {
        if (key == "ram") {
            int val = Integer.parseInt(listOptions.get(key));
            int temp = note.getRam();
            if (val <= temp) {
                listNew.add(note);
            }
        }
        if (key == "capacityHardDrive") {
            int val = Integer.parseInt(listOptions.get(key));
            int temp = note.getCapacityHardDrive();
            if (val <= temp) {
                listNew.add(note);
            }
        }
        if (key == "color") {
            String temp = note.getColor();
            if (listOptions.get(key).equals(temp)) {
                listNew.add(note);
            }
        }
        if (key == "screen") {
            String temp = note.getScreen();
            if (listOptions.get(key).equals(temp)) {
                listNew.add(note);
            }
        }
        if (key == "operatirnSystem") {
            String temp = note.getOperatingSystem();
            if (listOptions.get(key).equals(temp)) {
                listNew.add(note);
            }
        }
        if (key == "storageDevice") {
            String temp = note.getStorageDevice();
            if (listOptions.get(key).equals(temp)) {
                listNew.add(note);
            }
        }
    }

    private static void getChoice(Scanner scanner, Map<String, String> listOptions) {
        int choice = scanner.nextInt();
        while (choice < 1 || choice > 7) {
            System.out.println("Вы неверно ввели число. Проверьте и попробуйте снова");
            choice = scanner.nextInt();
        }
        listOptions.put(getKeyName(choice), handlingChoice(choice));
    }

    public static String handlingChoice(int choice) {
        Scanner scanner = new Scanner(System.in);
        String result = "";
        if (choice == 1) {
            System.out.println("Введите минимально необходимый размер ОЗУ. Минимальный 4, макисмальный 32");
            int number = scanner.nextInt();
            while (number < 4 || number > 32) {
                System.out.println("Число не входит в заданный диапазон. Попробуйте снова");
                number = scanner.nextInt();
            }
            result = Integer.toString(number);
            scanner.close();
            return result;
        }
        if (choice == 2) {
            System.out.println("Введите минимально необходимый объем жесткого диска. Не менее 250 и не более 1000");
            int number = scanner.nextInt();
            while (number < 250 || number > 1000) {
                System.out.println("Число не входит в заданный диапазон. Попробуйте снова");
                number = scanner.nextInt();
            }
            result = Integer.toString(number);
            scanner.close();
            return result;
        }
        if (choice == 3) {
            System.out.println("Введите одну из необходимых операционных систем: Windows, MacOs, Linux");
            result = scanner.nextLine();
            while ((!result.equals("Windows")) && (!result.equals("MacOs")) && (!result.equals("Linux"))) {
                System.out.println("Вы ввели неправильно. Попробуйте снова");
                result = scanner.next();
            }
            scanner.close();
            return result;
        }
        if (choice == 4) {
            System.out.println("Введите необходимый цвет. В наличии: black, grey, white ");
            result = scanner.nextLine();
            while ((!result.equals("black")) && (!result.equals("white")) && (!result.equals("grey"))) {
                System.out.println("Вы ввели неправильно. Попробуйте снова");
                result = scanner.nextLine();
            }
            scanner.close();
            return result;
        }
        if (choice == 5) {
            System.out.println("Введите необходимый вид экрана: IPS, OLED, AMOLED, VA");
            result = scanner.nextLine();
            while ((!result.equals("IPS")) && (!result.equals("OLED")) && (!result.equals("AMOLED"))
                    && (!result.equals("VA"))) {
                System.out.println("Вы ввели неправильно. Попробуйте снова");
                result = scanner.nextLine();
            }
            scanner.close();
            return result;
        }
        if (choice == 6) {
            System.out.println("Введите необходимый вид накопителя: HDD, SSD");
            result = scanner.nextLine();
            while ((!result.equals("HDD")) && (!result.equals("SSD"))) {
                System.out.println("Вы ввели неправильно. Попробуйте снова");
                result = scanner.nextLine();
            }
            scanner.close();
            return result;
        }
        scanner.close();
        return "null";
    }

    public static String getKeyName(int choice) {
        if (choice == 1) {
            return "ram";
        }
        if (choice == 2) {
            return "capacityHardDrive";
        }
        if (choice == 3) {
            return "operatirnSystem";
        }
        if (choice == 4) {
            return "color";
        }
        if (choice == 5) {
            return "screen";
        }
        if (choice == 6) {
            return "stirageDevice";
        } else {
            return "null";
        }
    }
}