
package.javau9.Biblioteka

public class AdressRespository {
import org.springframework.data.jpa.repository.JpaRepository;

    public interface AddressRepository extends JpaRepository<Adress.Address, Long> {
    }

}
