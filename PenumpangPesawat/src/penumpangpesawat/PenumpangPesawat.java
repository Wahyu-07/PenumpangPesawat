package penumpangpesawat;

class Passenger {
    String name;
    Passenger next;

    public Passenger(String name) {
        this.name = name;
        this.next = null;
    }
}

class Flight {
    private Passenger head;
    
    public void addPassenger(String name) {
        Passenger newPassenger = new Passenger(name);
        if (head == null) {
            head = newPassenger;
        } else {
            Passenger current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newPassenger;
        }
        System.out.println(name + " ditambahkan ke daftar penumpang.");
    }
    
    public void removePassenger(String name) {
        if (head == null) {
            System.out.println("Daftar penumpang kosong.");
            return;
        }

        if (head.name.equals(name)) {
            head = head.next;
            System.out.println(name + " dihapus dari daftar penumpang.");
            return;
        }

        Passenger current = head;
        Passenger previous = null;
        while (current != null && !current.name.equals(name)) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println(name + " tidak ditemukan di daftar penumpang.");
        } else {
            previous.next = current.next;
            System.out.println(name + " dihapus dari daftar penumpang.");
        }
    }
    
    public void displayPassengers() {
        if (head == null) {
            System.out.println("Daftar penumpang kosong.");
            return;
        }

        Passenger current = head;
        System.out.println("Daftar penumpang:");
        while (current != null) {
            System.out.println("- " + current.name);
            current = current.next;
        }
    }
}

public class PenumpangPesawat {
    public static void main(String[] args) {
        Flight flight = new Flight();

        
        flight.addPassenger("Agus");
        flight.addPassenger("Habib");
        flight.addPassenger("Zainal");
        
        flight.displayPassengers();
        
        flight.removePassenger("Habib");
        
        flight.displayPassengers();
    }
}
