import java.util.*;

class Product {
    String name;
    int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " - $" + price;
    }
}

public class ProductList {
    private static ArrayList<Product> productList = new ArrayList<>();

    public static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add Product");
        System.out.println("2. Sort Products by Name");
        System.out.println("3. Display Products");
        System.out.println("4. Exit");
    }

    public static void addProduct(Scanner scanner) {
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Product Price: ");
        int price = scanner.nextInt();
        scanner.nextLine();
        Product product = new Product(name, price);
        productList.add(product);
        System.out.println(name + " added successfully with price $" + price);
    }

    public static void sortProducts() {
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.name.compareTo(p2.name);
            }
        });
        System.out.println("Products sorted by name.");
    }

    public static void displayProducts() {
        if (productList.isEmpty()) {
            System.out.println("No products in the list.");
        } else {
            System.out.println("Products in the list: ");
            for (Product product : productList) {
                System.out.println(product);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addProduct(scanner);
                    break;
                case 2:
                    sortProducts();
                    break;
                case 3:
                    displayProducts();
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}



















// import java.util.*;

// class Product {
//     String name;
//     int price;

//     public Product(String name, int price) {
//         this.name = name;
//         this.price = price;
//     }

//     @Override
//     public String toString() {
//         return name + " - $" + price;
//     }
// }

// public class ProductList {
//     private static ArrayList<String> namesList = new ArrayList<>();

//     public static void displayMenu() {
//         System.out.println("\nMenu:");
//         System.out.println("1. Add Product");
//         System.out.println("2. Sort Product by Name");
//         System.out.println("3. Display Product");
//         System.out.println("4. Exit");
//     }

//     public static void addProduct(Scanner scanner) {
//         System.out.print("Enter Product to add: ");
//         String name = scanner.nextLine();
//         int price = scanner.nextInt();
//                     scanner.nextLine();

       
//         Product product = new Product(name, price);
//         productList.add(product);


//         // namesList.add(name,price);
//         System.out.println(name +"&"+price+ " added successfully.");
//     }

//     public static void sortProduct(Scanner scanner) {
//         System.out.println("Sorted Products are : ");
//         Collections.sort(nameList);
//         System.out.print(nameList);
//     }

//     public static void displayProducts() {
//         if (namesList.isEmpty()) {
//             System.out.println("No Products in the list.");
//         } else {
//             System.out.println("Products in the list: ");
//             for (String name : namesList) {
//                 System.out.println(name);
//             }
//         }
//     }

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         int choice;

//         do {
//             displayMenu();
//             System.out.print("Enter your choice: ");
//             choice = scanner.nextInt();
//             scanner.nextLine();  

//             switch (choice) {
//                 case 1:
//                     addProduct(scanner);
//                     break;
//                 case 2:
//                     sortProduct(scanner);
//                     break;
//                 case 3:
//                     displayProducts(scanner);
//                     break;
//                 case 4:
//                     System.out.println("Exiting the program.");
//                     break;
                    
//                 default:
//                     System.out.println("Invalid choice! Please try again.");
//             }
//         } while (choice != 4);

//         scanner.close();
//     }
// }


