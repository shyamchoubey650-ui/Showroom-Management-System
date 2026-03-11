// package Java_projects;

import java.util.Scanner;
import java.util.UUID;

//**************************************
// SHOWROOM MANAGEMENT SYSTEM USING JAVA
//**************************************

public class Project1 {
    interface Utility{
        void get_details();
        void set_details();
    }

    // FOR MAIN CLASS
        public static void main_menu(){
            System.out.println();
            System.out.println("======================= *** WELCOME TO SHOWROOM MANAGEMENT SYSTEM *** =====================");
            System.out.println();
            System.out.println("============================== ***ENTER YOUR CHOICE *** ===================================");
            System.out.println();
            System.out.println("1].ADD SHOWROOM \t\t\t 2].ADD EMPLOYEES \t\t\t 3].ADD CARS");
            System.out.println();
            System.out.println("4].GET SHOWROOM \t\t\t 5].GET EMPLOYEES \t\t\t 6].GET CARS");
            System.out.println();
            System.out.println("=============================== *** ENTER 0 TO EXIT *** ==================================");
        }


    // FOR SHOWROOM CLASS

    public static class showRoom implements Utility {
        String showroom_name;
        String showroom_address;
        int total_employees;
        int total_cars_in_stock = 0;
        String manager_name;

        public void get_details() {
            System.out.println("Showroom Name : " + showroom_name);
            System.out.println("Showroom Address : " + showroom_address);
            System.out.println("Manager Name : " + manager_name);
            System.out.println("Total Employees : " + total_employees);
            System.out.println("Total Cars In Stock : " + total_cars_in_stock);

        }


        public void set_details() {
            Scanner sc = new Scanner(System.in);
            System.out.println("===============================***ENTER SHOWROOM DETAILS ***====================================");
            System.out.println();
            System.out.println("SHOWROOM NAME: ");
            showroom_name = sc.nextLine(); //  Reads the entire line of text (including spaces)
            // and stores it in the variable showroom_name and also taking for user input.
            System.out.println("SHOWROOM ADDRESS: ");
            showroom_address = sc.nextLine();
            System.out.println("MANAGER NAME: ");
            manager_name = sc.nextLine();
            System.out.println("TOTAL NO OF EMPLOYEES: ");
            total_employees = sc.nextInt();//  Reads an integer value and stores it in total_employees.
            System.out.println("TOTAL CARS IN STOCK: ");
            total_cars_in_stock = sc.nextInt();

        }
    }


    // FOR EMPLOYEES CLASS

    public static class Employees extends showRoom implements Utility{ // use of inheritance and
        // Acheive multiple inheritance using interface.
        String emp_id;
        String emp_name;
        int emp_age;
        String emp_department;

        public void get_details() {
            System.out.println("ID : " + emp_id);
            System.out.println("NAME : " + emp_name);
            System.out.println("AGE : " + emp_age);
            System.out.println("DEPARTMENT : " + emp_department );
            System.out.println("SHOWROOM NAME : " + showroom_name);

        }

        public void set_details() {
            Scanner sc = new Scanner(System.in);
            UUID uuid = UUID.randomUUID(); // that one line generates a unique random identifier and
            // stores it in uuid.
            emp_id = String.valueOf(uuid);
            System.out.println("===============================***ENTER EMPLOYEE DETAILS ***====================================");
            System.out.println();
            System.out.println("EMPLOYEE NAME:");
            emp_name = sc.nextLine();
            System.out.println("EMPLOYEE AGE:");
            emp_age = sc.nextInt();
            sc.nextLine();
            System.out.println("EMPLOYEE DEPARTMENT:");
            emp_department = sc.nextLine();
            System.out.println("SHOWROOM NAME:");
            showroom_name = sc.nextLine();


        }

    }

    // FOR CAR CLASS

    public static class Car extends showRoom implements Utility{
        String car_name;
        String car_color;
        String car_fuel_type;
        int car_price;
        String car_type;
        String car_transmission;

        public void get_details() {
            System.out.println("NAME : " + car_name);
            System.out.println("COLOR : " + car_color);
            System.out.println("FUEL TYPE : " + car_fuel_type );
            System.out.println("PRICE : " + car_price);
            System.out.println("CAR TYPE  : " + car_type);
            System.out.println("TRANSMISSION : " + car_transmission);

        }

        public void set_details() {
            Scanner sc = new Scanner(System.in);
            System.out.println("===============================***ENTER CAR DETAILS ***====================================");
            System.out.println();
            System.out.println("CAR NAME: ");
            car_name = sc.nextLine();
            System.out.println("CAR1 COLOR: ");
            car_color = sc.nextLine();
            System.out.println("CAR FUEL TYPE(PETROL/DIESEL): ");
            car_fuel_type = sc.nextLine();
            System.out.println("CAR PRICE: ");
            car_price = sc.nextInt();
            sc.nextLine();
            System.out.println("CAR TYPE: ");
            car_type = sc.nextLine();
            System.out.println("TRANSMISSION TYPE(AUTOMATIC/MANUAL): ");
            car_transmission = sc.nextLine();
            total_cars_in_stock++;

        }

    }

    static void main() {
       Scanner sc = new Scanner(System.in);
       showRoom ShowRoom[] = new showRoom[5];  // create arrays types object and length is 5.
        Employees employee[] = new Employees[5]; // we add maximum 5 showroom,employees,and cars.
        Car car[] = new Car[5];
        int car_counter = 0;
        int showroom_counter = 0;
        int employees_counter = 0;
        int choose = 100;
        while (choose!=0){

            main_menu();
            choose = sc.nextInt();

            while (choose!=9 && choose!=0){
                switch (choose){
                    case 1:
                        ShowRoom[showroom_counter] = new showRoom();
                        ShowRoom[showroom_counter].set_details();
                        showroom_counter++;
                        System.out.println();
                        System.out.println("1].ADD NEW SHOWROOM");
                        System.out.println("9].GO BACK TO MAIN MENU");
                        choose = sc.nextInt();
                        break;

                    case 2:
                        employee[employees_counter] = new Employees();
                        employee[employees_counter].set_details();
                        employees_counter++;
                        System.out.println();
                        System.out.println("2].ADD NEW EMPLOYEE");
                        System.out.println("9].GO BACK TO MAIN MENU");
                        choose = sc.nextInt();
                        break;

                    case 3:
                        car[car_counter] = new Car();
                        car[car_counter].set_details();
                        car_counter++;
                        System.out.println();
                        System.out.println("2].ADD NEW CAR");
                        System.out.println("9].GO BACK TO MAIN MENU");
                        choose = sc.nextInt();
                        break;

                    case 4:
                        for(int i = 0; i < showroom_counter;i++){
                            ShowRoom[i].get_details();
                            System.out.println();
                            System.out.println();
                        }
                        System.out.println();
                        System.out.println("9].GO BACK TO MAIN MENU");
                        System.out.println("0].EXIT");
                        choose = sc.nextInt();
                        break;

                    case 5:
                        for (int i = 0; i < employees_counter;i++){
                            employee[i].get_details();
                            System.out.println();
                            System.out.println();
                        }
                        System.out.println();
                        System.out.println("9].GO BACK TO MAIN MENU");
                        System.out.println("0].EXIT");
                        choose = sc.nextInt();
                        break;

                    case 6:
                        for (int i = 0; i < car_counter;i++){
                            car[i].get_details();
                            System.out.println();
                            System.out.println();
                        }
                        System.out.println();
                        System.out.println("9].GO BACK TO MAIN MENU");
                        System.out.println("0].EXIT");
                        choose = sc.nextInt();
                        break;

                    default:
                        System.out.println("ENTER INVALID CHOICE: ");
                        break;
                }
            }

        }
    }

}
