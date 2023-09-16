/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activity2_bookworm;

/**
 *
 * @author khian
 */


import java.util.LinkedList;
import java.util.Scanner;

class Lex {
    String T, A, I;

    Lex(String T, String A, String I) {
        this.T = T;
        this.A = A;
        this.I = I;
    }
}

public class Activity2_BookWorm {
    public static void main(String[] args) {
        LinkedList<Lex> books = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBookworm Adventures - Library Management");
            System.out.println("[1] Add Book");
            System.out.println("[2] Delete Book");
            System.out.println("[3] Search by ISBN");
            System.out.println("[4] Display Books");
            System.out.println("[5] Exit");
            System.out.print("Input Option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                addBook(books, scanner);
            } else if (choice == 2) {
                deleteBook(books, scanner);
            } else if (choice == 3) {
                searchByIsbn(books, scanner);
            } else if (choice == 4) {
                displayBooks(books);
            } else if (choice == 5) {
                exitProgram();
                scanner.close();
                return;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addBook(LinkedList<Lex> books, Scanner scanner) {
        System.out.print("Enter title: ");
        String T = scanner.nextLine();
        System.out.print("Enter author: ");
        String A = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String I = scanner.nextLine();
        books.add(new Lex(T, A, I));
        System.out.println("Book added successfully.");
    }

    private static void deleteBook(LinkedList<Lex> books, Scanner scanner) {
        System.out.print("Enter ISBN to delete: ");
        String I = scanner.nextLine();
        boolean removed = books.removeIf(book -> book.I.equals(I));
        if (removed) {
            System.out.println("Book with ISBN " + I + " deleted.");
        } else {
            System.out.println("Book with ISBN " + I + " not found.");
        }
    }

    private static void searchByIsbn(LinkedList<Lex> books, Scanner scanner) {
        System.out.print("Enter ISBN to search: ");
        String I = scanner.nextLine();
        for (Lex book : books) {
            if (book.I.equals(I)) {
                displayBook(book);
                return;
            }
        }
        System.out.println("Book with ISBN " + I + " not found.");
    }

    private static void displayBooks(LinkedList<Lex> books) {
        System.out.println("All Books:");
        for (Lex book : books) {
            displayBook(book);
        }
    }

    private static void displayBook(Lex book) {
        System.out.println("Title: " + book.T);
        System.out.println("Author: " + book.A);
        System.out.println("ISBN: " + book.I);
        System.out.println();
    }

    private static void exitProgram() {
        System.out.println("Created by: Mary Christmas Aguinaldo, Head Librarian");
    }
}