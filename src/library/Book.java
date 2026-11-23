package library;

public class Book {
    private String title;
    public String author;
    String inventoryNumber;
    protected String shelf;
    private boolean borrowed;
    private static int createdCount = 0;

    // Общая точка инициализации: счетчик увеличивается ровно один раз.
    private Book(String title, String author, String inventoryNumber, boolean initialize) {
        this.title = title;
        this.author = author;
        this.inventoryNumber = inventoryNumber;
        this.shelf = "Не назначена";
        this.borrowed = false;
        createdCount++;
    }

    public Book(String title, String author) {
        this(title, author, "Без номера", true);
    }

    Book(String title, String author, String inventoryNumber) {
        this(title, author, inventoryNumber, true);
    }

    protected Book(String title) {
        this(title, "Неизвестен", "Без номера", true);
    }

    private Book() {
        this("Демонстрационная книга", "Неизвестен", "Без номера", true);
    }

    private boolean canBorrow() {
        return !borrowed;
    }

    public boolean borrow() {
        if (canBorrow()) {
            borrowed = true;
            return true;
        }
        return false;
    }

    public boolean giveBack() {
        if (borrowed) {
            borrowed = false;
            return true;
        }
        return false;
    }

    public String getTitle() {
        return title;
    }

    public void printInfo() {
        System.out.println("Название: " + title
                + ", автор: " + author
                + ", номер: " + inventoryNumber
                + ", полка: " + shelf
                + ", состояние: " + (borrowed ? "Выдана" : "Свободна"));
    }

    void assignInventoryNumber(String number) {
        inventoryNumber = number;
    }

    protected void moveToShelf(String shelf) {
        this.shelf = shelf;
    }

    public static int getCreatedCount() {
        return createdCount;
    }

    public static Book createDemo() {
        return new Book();
    }

    // Отдельный опыт: вызов этого метода не требуется в основном сценарии.
    public static void checkAccessInside() {
        Book book = new Book("Тест", "Автор");
        System.out.println(book.author);
        System.out.println(book.title);
        System.out.println(book.inventoryNumber);
        System.out.println(book.shelf);
        book.printInfo();
        System.out.println(book.canBorrow());
        book.assignInventoryNumber("TEST-001");
        book.moveToShelf("T1");

        new Book("Название", "Автор");
        new Book("Название", "Автор", "B-010");
        new Book("Название");
        new Book();
    }
}
