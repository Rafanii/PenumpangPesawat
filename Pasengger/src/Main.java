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
    }

    public void removePassenger(String name) {
        if (head == null) {
            System.out.println("Tidak ada penumpang untuk dihapus.");
            return;
        }

        if (head.name.equals(name)) {
            head = head.next;
            return;
        }

        Passenger current = head;
        Passenger previous = null;

        while (current != null && !current.name.equals(name)) {
            previous = current;
            current = current.next;
        }

        if (current != null) {
            previous.next = current.next;
        } else {
            System.out.println("Penumpang tidak ditemukan.");
        }
    }

    public void displayPassengers() {
        if (head == null) {
            System.out.println("Tidak ada penumpang di penerbangan.");
            return;
        }

        Passenger current = head;
        while (current != null) {
            System.out.println(current.name);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Flight flight = new Flight();

        flight.addPassenger("Fani");
        flight.addPassenger("Nia");
        flight.addPassenger("Dila");

        System.out.println("Daftar Penumpang:");
        flight.displayPassengers();

        flight.removePassenger("Dila");

        System.out.println("\nDaftar Penumpang Setelah Penghapusan:");
        flight.displayPassengers();
    }
}