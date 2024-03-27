package javau9.Biblioteka;

public class LibraryRespository {
import org.springframework.data.jpa.repository.JpaRepository;}

public interface LibraryRepository extends JpaRepository<Library.Library, Long> {
    Library.Library findByName(String name);

