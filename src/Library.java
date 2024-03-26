public class Library {
    import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

    @Entity
    public class Library {
        @Id
        @GeneratedValue(
                strategy = GenerationType.IDENTITY
        )
        private long id;
        @Column
        private String name;
        @OneToOne
        @JoinColumn(
                name = "address_id"
        )
        @JsonManagedReference
        private Address address;

        public Library(long id, String name, Address address) {
            this.id = id;
            this.name = name;
            this.address = address;
        }

        public Library() {
        }

        public long getId() {
            return this.id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Address getAddress() {
            return this.address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        public String toString() {
            return "Library{id=" + this.id + ", name=" + this.name + "}";
        }
    }
}
