package Singly_Linked_List;

public class polynomialAddition {

    static class Node {
        int degree;
        int coefficient;
        Node next;

        public Node(int degree, int coefficient) {
            this.degree = degree;
            this.coefficient = coefficient;
            this.next = null;
        }
    }

    // Head of the list
    Node head;

    // Add term to polynomial in sorted order (by degree)
    public void insertTerm(int degree, int coefficient) {
        if (coefficient == 0) return; // Ignore zero coefficients

        Node newNode = new Node(degree, coefficient);

        if (head == null || head.degree > degree) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.degree < degree) {
            temp = temp.next;
        }

        if (temp.next != null && temp.next.degree == degree) {
            temp.next.coefficient += coefficient;
        } else {
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    // Display polynomial in readable format
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.coefficient + "x^" + temp.degree);
            if (temp.next != null && temp.next.coefficient >= 0)
                System.out.print(" + ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Add two polynomials and return result as a new polynomial
    public static polynomialAddition add(polynomialAddition p1, polynomialAddition p2) {
        polynomialAddition result = new polynomialAddition();

        Node a = p1.head;
        Node b = p2.head;

        while (a != null && b != null) {
            if (a.degree == b.degree) {
                result.insertTerm(a.degree, a.coefficient + b.coefficient);
                a = a.next;
                b = b.next;
            } else if (a.degree < b.degree) {
                result.insertTerm(a.degree, a.coefficient);
                a = a.next;
            } else {
                result.insertTerm(b.degree, b.coefficient);
                b = b.next;
            }
        }

        // Add remaining terms
        while (a != null) {
            result.insertTerm(a.degree, a.coefficient);
            a = a.next;
        }

        while (b != null) {
            result.insertTerm(b.degree, b.coefficient);
            b = b.next;
        }

        return result;
    }

    // Test the code
    public static void main(String[] args) {
        polynomialAddition poly1 = new polynomialAddition();
        polynomialAddition poly2 = new polynomialAddition();

        // Polynomial 1: 5x^2 + 4x^1 + 2
        poly1.insertTerm(2, 5);
        poly1.insertTerm(1, 4);
        poly1.insertTerm(0, 2);

        // Polynomial 2: 5x^1 + 5
        poly2.insertTerm(1, 5);
        poly2.insertTerm(0, 5);

        System.out.print("Polynomial 1: ");
        poly1.display();

        System.out.print("Polynomial 2: ");
        poly2.display();

        polynomialAddition sum = add(poly1, poly2);

        System.out.print("Sum: ");
        sum.display();
    }
}
