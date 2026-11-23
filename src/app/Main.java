package app;

import library.Book;
import library.LibraryDesk;

public class Main {
    public static void main(String[] args) {
        Book first = new Book("Хоббит", "Толкин");
        Book second = new Book("Хоббит", "Толкин");
        Book third = LibraryDesk.prepareBook(
                "Остров сокровищ", "Стивенсон", "B-003", "A2");
        Book demo = Book.createDemo();

        System.out.println("=== Все книги ===");
        first.printInfo();
        second.printInfo();
        third.printInfo();
        demo.printInfo();
        System.out.println("Создано объектов: " + Book.getCreatedCount());

        System.out.println("\n=== Выдача первого экземпляра ===");
        System.out.println("Первая выдача: " + first.borrow());
        System.out.println("Повторная выдача: " + first.borrow());

        System.out.println("\n=== Состояние двух экземпляров ===");
        first.printInfo();
        second.printInfo();

        System.out.println("\n=== Выдача второго экземпляра ===");
        System.out.println("Выдача второго: " + second.borrow());

        System.out.println("\n=== Возврат первого экземпляра ===");
        System.out.println("Первый возврат: " + first.giveBack());
        System.out.println("Повторный возврат: " + first.giveBack());

        System.out.println("\n=== Состояние после возврата ===");
        first.printInfo();
        second.printInfo();

        System.out.println("\n=== Работа с одной ссылкой ===");
        Book sameBook = first;
        System.out.println("Выдача через sameBook: " + sameBook.borrow());
        System.out.println("Выдача через first: " + first.borrow());

        System.out.println("\\nСоздано объектов в конце: " + Book.getCreatedCount());

        // Отдельные эксперименты запускаются независимо от основного сценария:
        // Book.checkAccessInside();
        // LibraryDesk.checkAccess();

        // Примеры запрещенного доступа из пакета app:
        // System.out.println(first.title);                 // private
        // System.out.println(first.inventoryNumber);       // package-private
        // System.out.println(first.shelf);                  // protected: другой пакет, не наследник
        // first.canBorrow();                                // private
        // first.assignInventoryNumber("X");                 // package-private
        // first.moveToShelf("B1");                           // protected: другой пакет, не наследник
        // new Book("Название", "Автор", "B-010");           // package-private
        // new Book("Название");                             // protected: другой пакет, не наследник
        // new Book();                                       // private
    }
}
