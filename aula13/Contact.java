import java.time.LocalDate;

public class Contact {
    private int id = 0;
    private String name;
    private int phoneNumber;
    private String email;
    private LocalDate birthDate;

    public Contact(int id, String name, int phoneNumber, String email, LocalDate birthDate) {
        this.id = id++;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.birthDate = birthDate;
    }

    public Contact(String name, int phoneNumber, String email, LocalDate birthDate) {
        this.id = id++;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return String.valueOf(phoneNumber);
    }

    public String getemail() {
        return email;
    }

    public LocalDate getDate() {
        return birthDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;

    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return name + " " + phoneNumber + " " + email + " " + birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Contact)) {
            return false;
        }
        Contact other = (Contact) o;
        if (id != other.id) {
            return false;
        }
        if (phoneNumber != other.phoneNumber) {
            return false;
        }
        if (email == null) {
            return other.email == null;
        } else {
            return email.equals(other.email);
        }
    }
}
