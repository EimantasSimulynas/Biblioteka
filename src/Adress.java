public class Adress {
    import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

    @Entity
    public class Address {
        @Id
        @GeneratedValue
        private long id;
        @Column(
                nullable = false
        )
        private String location;
        @OneToOne(
                mappedBy = "address"
        )
        @JsonBackReference
        private Library library;

        public Address(long id, String location, Library library) {
            this.id = id;
            this.location = location;
            this.library = library;
        }

        public Address() {
        }

        public long getId() {
            return this.id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getLocation() {
            return this.location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public Library getLibrary() {
            return this.library;
        }

        public void setLibrary(Library library) {
            this.library = library;
        }

        public String toString() {
            return "Address{id=" + this.id + ", location=" + this.location + "}";
        }
    }


}
