package myApp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name="passport")
@Entity
@NoArgsConstructor
@Setter
@Getter
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person personId;

    @Column(name = "passport_number")
    private String passportNumber;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    public Passport(String passportNumber, LocalDate expiryDate) {
        this.passportNumber = passportNumber;
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", passportNumber='" + passportNumber + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", personId=" + (personId != null ? personId.getId() : null) +
                '}';
    }
}
