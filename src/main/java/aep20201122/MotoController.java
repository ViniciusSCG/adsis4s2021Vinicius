package aep20201122;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/motos")
public class MotoController {
    @Autowired
    private MotoRepository repo;
    
    @GetMapping("/maior-cilindrada")
    public int getMaiorCilindrada() {
        return repo.obterMaiorCilindrada();
    }
    
    @GetMapping
    public List<Moto> getAll() {
        return repo.findAll();
    }
    
    @PostMapping
    public String post(@RequestBody Moto novo) {
        if (repo.findById(novo.getId()).isPresent()) {            
            throw new RegistroExistente();
        }
        novo = repo.save(novo);
        return novo.getId();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
    	try {
    		repo.deleteById(id);
    		return ResponseEntity.ok().build();
		} catch (Exception e) {
    		return ResponseEntity.notFound().build();
		}
    }
    @GetMapping("/{id}")
    public ResponseEntity<Moto> getById(@PathVariable("id") String id) {
    	try {
            //return ResponseEntity.ok(repo.findById(id));
    		return ResponseEntity.status(HttpStatus.OK).body(repo.findById(id).get());
		} catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
		}
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Void> put(@PathVariable("id") String id, @RequestBody Moto moto) {
        if (!id.equals(moto.getId())) {
            return ResponseEntity.badRequest().build();
        }
        repo.save(moto);
        return ResponseEntity.ok().build();
    }
    

}
