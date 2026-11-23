package library;

public class LibraryDesk {

    public static Book prepareBook(
            String title, String author, String inventoryNumber, String shelf) {
        Book book = new Book(title, author, inventoryNumber);
        book.moveToShelf(shelf);
        return book;
    }

    // Отдельный опыт проверки доступа из другого класса того же пакета.
    public static void checkAccess() {
        Book book = new Book("Тест", "Автор");
        System.out.println(book.author);          // public
        // System.out.println(book.title);        // private: доступен только внутри Book
        System.out.println(book.inventoryNumber); // package-private: тот же пакет
        System.out.println(book.shelf);           // protected: тот же пакет
        book.printInfo();                         // public
        // book.canBorrow();                      // private
        book.assignInventoryNumber("TEST-002");  // package-private
        book.moveToShelf("T2");                   // protected

        new Book("Название", "Автор");            // public
        new Book("Название", "Автор", "B-010");   // package-private
        new Book("Название");                     // protected, тот же пакет
        // new Book();                            // private
    }
}
