package example.roleplaying;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @PostMapping
    public ResponseEntity<Character> createCharacter(@RequestBody Character character) {
        Character created = characterService.createCharacter(character);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<Character>> getAllCharacters() {
        return ResponseEntity.ok(characterService.getAllCharacters());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Character> getCharacterById(@PathVariable Long id) {
        return ResponseEntity.ok(characterService.getCharacterById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Character> updateCharacter(@PathVariable Long id, @RequestBody Character character) {
        return ResponseEntity.ok(characterService.updateCharacter(id, character));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable Long id) {
        characterService.deleteCharacter(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/items")
    public ResponseEntity<Character> addItemToCharacter(@PathVariable Long id, @RequestBody Item item) {
        return ResponseEntity.ok(characterService.addItemToCharacter(id, item));
    }

    @GetMapping("/{id}/total-strength")
    public ResponseEntity<int> getTotalStrength(@PathVariable Long id) {
        Character character = characterService.getCharacterById(id);
        int total = characterService.getTotalStrength(character);
        return ResponseEntity.ok(total);
    }

    @GetMapping("/{id}/total-defense")
    public ResponseEntity<int> getTotalDefense(@PathVariable Long id) {
        Character character = characterService.getCharacterById(id);
        int total = characterService.getTotalDefense(character);
        return ResponseEntity.ok(total);
    }
}
