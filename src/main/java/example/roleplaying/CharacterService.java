package example.roleplaying;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private ItemRepository itemRepository;

    public Character createCharacter(Character character) {
        return characterRepository.save(character);
    }

    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }

    public Character getCharacterById(Long id) {
        return characterRepository.findById(id).orElseThrow(() -> new RuntimeException("Autor não encontrado"));
    }

    public Character updateCharacter(Long id, Character updatedCharacter) {
        Character character = getCharacterById(id);
        character.setName(updatedCharacter.getName());
        character.setDescription(updatedCharacter.getDescription());
        return characterRepository.save(character);
    }

    public void deleteCharacter(Long id) {
        characterRepository.deleteById(id);
    }

    public Item addItemToCharacter(Long bookId, Item item) {
        Character character = getCharacterById(characterId);
        character.setCharacter(character);
        return characterRepository.save(character);
    }
}
