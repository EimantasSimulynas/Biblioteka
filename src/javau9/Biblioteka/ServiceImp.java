package javau9.Biblioteka;

import java.util.List;

public class ServiceImp {
    import java.util.List;
import javau9.biblioteka.models.Address;
import javau9.biblioteka.models.Library;
import javau9.biblioteka.repositories.AddressRepository;
import javau9.biblioteka.repositories.LibraryRepository;
import javau9.biblioteka.service.LibService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

    @Service
    public class LibServiceImpl implements LibService {
        private final LibraryRepository libraryRepository;
        private final AdressRespository.AddressRepository addressRepository;

        @Autowired
        public LibServiceImpl(LibraryRepository libraryRepository, AdressRespository.AddressRepository addressRepository) {
            this.libraryRepository = libraryRepository;
            this.addressRepository = addressRepository;
        }

        public Library.Library addLibrary(Library library) {
            return (Library)this.libraryRepository.save(library);
        }

        public Library.Library getLibraryById(Long id) {
            return (Library.Library)this.libraryRepository.findById(id).orElseThrow(() -> {
                return new IllegalArgumentException("Neteisingas ID");
            });
        }

        public List<Library> getAllLibraries() {
            return this.libraryRepository.findAll();
        }

        public void removeLibrary(Long id) {
            this.libraryRepository.deleteById(id);
        }

        public Library getLibraryByName(String name) {
            return this.libraryRepository.findByName(name);
        }

        public List<Address> getAllAddresses() {
            return this.addressRepository.findAll();
        }

        public Address addAddress(Address address) {
            return (Address)this.addressRepository.save(address);
        }
    }
}
