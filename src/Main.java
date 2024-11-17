// Interface DataSource
interface myDataSource {
    void execute();
}

// Abstract class Account
abstract class Account {
    protected int id;
    protected String name;
    protected myDataSource myData;

    public Account(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void performOperation(myDataSource myData) {
        this.myData = myData;
        myData.execute();
    }
}

// Concrete class Admin extending Account
class Admin extends Account {
    private String authPassword;

    public Admin(int id, String name, String authPassword) {
        super(id, name);
        this.authPassword = authPassword;
    }

    // ... other methods for Admin
}

// Concrete class User extending Account
class User extends Account {
    public User(int id, String name) {
        super(id, name);
    }

    // ... other methods for User
}

// Concrete class Update implementing DataSource
class Update implements myDataSource {
    @Override
    public void execute() {
        System.out.println("Update operation performed.");
    }
}

// Concrete class View implementing DataSource
class View implements myDataSource {
    @Override
    public void execute() {
        System.out.println("View operation performed.");
    }
}

// Concrete class Delete implementing DataSource
class Delete implements myDataSource {
    @Override
    public void execute() {
        System.out.println("Delete operation performed.");
    }
}

// Example usage:
public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin(1, "Alice", "admin123");
        admin.performOperation(new Update());
        admin.performOperation(new View());
        admin.performOperation(new Delete());
    }
}