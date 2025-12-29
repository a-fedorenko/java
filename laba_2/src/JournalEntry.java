import java.util.Objects;

public class JournalEntry {
    private String lastName;
    private String firstName;
    private String birthDate;
    private String phone;
    private String address;

    public JournalEntry(String lastName, String firstName, String birthDate, String phone, String address) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        JournalEntry that = (JournalEntry) o;
        
        return Objects.equals(lastName, that.lastName) &&
               Objects.equals(firstName, that.firstName) &&
               Objects.equals(birthDate, that.birthDate) &&
               Objects.equals(phone, that.phone) &&
               Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, birthDate, phone, address);
    }

    @Override
    public String toString() {
        return String.format("Запис: %s %s | Дата: %s | Тел: %s | Адреса: %s", 
                lastName, firstName, birthDate, phone, address);
    }
}