import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    ArrayList<Person> contacts;
    // Declaring and initializing contact list
    public ContactList() {
        contacts = new ArrayList<Person>();
    }

    public ArrayList<Person> getContact(){return contacts;}

    public void addContact() {
        // Prompts user for type of person
        Scanner input = new Scanner(System.in);
        System.out.println("Select a type of person to add: ");
        System.out.println("1. Student");
        System.out.println("2. Worker");
        int choice = input.nextInt();
        // Reprompt if option is null
        while (choice < 1 || choice > 2) {
            System.out.println(("Error, please enter option 1 or 2"));
            choice = input.nextInt();
        }
        // Basic info of the new person
        String temp = input.nextLine();
        System.out.println("Please fill in the following information.");
        System.out.println("First Name: ");
        String firstName = input.nextLine();
        System.out.println("Last Name: ");
        String lastName = input.nextLine();
        System.out.println("Phone Number: ");
        String phoneNumber = input.nextLine();
        // Runs code depending on what the user chose
        if (choice == 1) {
            System.out.println("Grade: ");
            int grade = input.nextInt();
            Person newPerson = new Student(firstName, lastName, phoneNumber, grade);
            contacts.add(newPerson);
        }
        else if (choice == 2) {
            System.out.println("Salary: ");
            int salary = input.nextInt();
            Person newPerson = new Worker(firstName, lastName, phoneNumber, salary);
            contacts.add(newPerson);
        }
        else {
            Person newPerson = new Person(firstName, lastName, phoneNumber);
            contacts.add(newPerson);
        }
    }
    // Prints all contacts in the list
    public void printContacts() {
        for (Person p : contacts) {
            System.out.println(p.toString());
        }
    }

    public void sort(int sortBy) {
        int length = contacts.size();
        if (sortBy == 0) {
            // If the user chooses to sort by first name this code will run
            for (int i = 1; i < length; i++) {
                for (int j = 0; j < length - i; j++) {
                    if (contacts.get(j).getFirstName().compareTo(contacts.get(j + 1).getFirstName()) > 0) {
                       contacts.set(j + 1, contacts.set(j, contacts.get(j + 1)));
                       printContacts();
                    }
                }

            }
        }
        // This code is for sorting by last name
        else if (sortBy == 1) {
            for (int i = 1; i < length; i++) {
                for (int j = 0; j < length - i; j++) {
                    if (contacts.get(j).getLastName().compareTo(contacts.get(j + 1).getLastName()) > 0) {
                        contacts.set(j + 1, contacts.set(j, contacts.get(j + 1)));
                        printContacts();
                    }
                }
            }
        }
        // Finally this code is for sorting by phone #
        else if (sortBy == 2) {
            for (int i = 1; i < length; i++) {
                for (int j = 0; j < length - i; j++) {
                    if (contacts.get(j).getPhoneNumber().compareTo(contacts.get(j + 1).getPhoneNumber()) > 0) {
                        contacts.set(j + 1, contacts.set(j, contacts.get(j + 1)));
                        printContacts();
                    }
                }
            }
        }
    }
    // Prints all students in the list
    public void listStudents() {
        for (Person stu : contacts) {
            if (stu instanceof Student) {
                System.out.println(stu);
            }
        }
    }

    public Person searchByFirstName(String fName) {
        for (Person p : contacts) {
            // If the person returns the same name as the user input, it will return that person
            if (p.getFirstName().equals(fName)) {
                return p;
            }
        }
        System.out.println("Name is not in list");
        return null;
    }

    public Person searchByLastName(String lName) {
        for (Person p : contacts) {
            // Searches for inputted last name
            if (p.getLastName().equals(lName)) {
                return p;
            }
        }
        System.out.println("Name is not in list");
        return null;
    }

    public Person searchByPhoneNumber(String pNum) {
        for (Person p : contacts) {
            // Searches for inputted phone #
            if (p.getPhoneNumber().equals(pNum)) {
                return p;
            }
        }
        System.out.println("Phone number is not in list");
        return null;
    }
    // Prints the menu for user
    public void printInstructions() {
        System.out.println("Menu:");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts By First Name");
        System.out.println("3. List All Contacts By Last Name");
        System.out.println("4. List All Contacts By Phone Number");
        System.out.println("5. List All Students");
        System.out.println("6. Search By First Name");
        System.out.println("7. Search By Last Name");
        System.out.println("8. Search By Phone Number");
        System.out.println("0. Exit");
    }

    public void run() {
        printInstructions();
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        input.nextLine();
        // Will run different parts of the contact list code depending on user input
        while (choice != 0) {
            if (choice == 1) {
                addContact();
            } else if (choice == 2) {
                sort(0);
                printContacts();
            } else if (choice == 3) {
                sort(1);
                printContacts();
            } else if (choice == 4) {
                sort(2);
                printContacts();
            } else if (choice == 5) {
                listStudents();
            } else if (choice == 6) {
                System.out.println("Enter a name:");
                String name = input.nextLine();
                searchByFirstName(name);
            } else if (choice == 7) {
                System.out.println("Enter a last name:");
                String name = input.nextLine();
                searchByLastName(name);
            } else if (choice == 8) {
                System.out.println("Enter a phone number:");
                String num = input.nextLine();
                searchByPhoneNumber(num);
            }
            // Redraws the menu until the user inputs 0, finally ending the code
            printInstructions();
            choice = input.nextInt();
            input.nextLine();
        }
    }
}
