import java.util.List;

public class HomeController {
}@RestController
@RequestMapping({"/"})
public class HomeController {
    @Autowired
    LibServiceImpl libService;

    public HomeController() {
    }

    @GetMapping({"/library/all"})
    public List<Library> getAllLibraries() {
        return this.libService.getAllLibraries();
    }

    @GetMapping({"/addresses"})
    public List<Address> getAllAddresses() {
        return this.libService.getAllAddresses();
    }

    @PostMapping({"/library/add"})
    public ResponseEntity<Library> createLibrary(@RequestBody Library library) {
        Address savedAddress = this.libService.addAddress(library.getAddress());
        library.setAddress(savedAddress);
        Library savedLibrary = this.libService.addLibrary(library);
        return ResponseEntity.ok(savedLibrary);
    }

    @DeleteMapping({"/library/delete/{id}"})
    public ResponseEntity<Void> deleteLibrary(@PathVariable Long id) {
        this.libService.removeLibrary(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping({"/libraries"})
    public ResponseEntity<Library> getLibraryByName(@RequestParam String name) {
        Library library = this.libService.getLibraryByName(name);
        return library != null ? ResponseEntity.ok(library) : ResponseEntity.notFound().build();
    }

    @GetMapping({"/dummy"})
    public Library getDummyData() {
        Library lib = new Library();
        Address addr = new Address();
        addr.setLocation("K. Petrauusko g.");
        Address savedAddress = this.libService.addAddress(addr);
        lib.setName("Mazvydo");
        lib.setAddress(savedAddress);
        this.libService.addLibrary(lib);
        return lib;
    }
}
