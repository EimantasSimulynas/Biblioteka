
package.javau9.Biblioteka

public class AdressRespository {
    import lt.mark3r.biblioteka.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface AddressRepository extends JpaRepository<Adress.Address, Long> {
    }

}
