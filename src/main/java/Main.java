public class Main {
    public static void main(String[] args) {
        DBService dbService = new DBService();
        AccountsService ac = new AccountsService(dbService);

        System.out.println(ac.searchInRepository("user1"));
        dbService.closeConnection();
    }
}