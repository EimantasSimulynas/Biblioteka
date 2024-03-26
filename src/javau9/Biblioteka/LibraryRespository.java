package javau9.Biblioteka;

public class LibraryRespository {
}import lt.mark3r.biblioteka.models.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library.Library, Long> {
    Library.Library findByName(String name);
}
