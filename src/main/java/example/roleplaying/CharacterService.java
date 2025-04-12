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
        if (character.getStrength() + character.getDefense() != 10) {
            throw new IllegalArgumentException("A soma de força e defesa deve ser exatamente 10.");
        }

        if (character.getCategory() == null) {
            throw new IllegalArgumentException("A classe do personagem é obrigatória.");
        }

        return characterRepository.save(character);
    }

    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }

    public Character getCharacterById(Long id) {
        return characterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Personagem não encontrado."));
    }

    public Character updateCharacter(Long id, Character updatedCharacter) {
        Character character = getCharacterById(id);

        if (updatedCharacter.getStrength() + updatedCharacter.getDefense() != 10) {
            throw new IllegalArgumentException("A soma de força e defesa deve ser exatamente 10.");
        }

        character.setName(updatedCharacter.getName());
        character.setDescription(updatedCharacter.getDescription());
        character.setLevel(updatedCharacter.getLevel());
        character.setStrength(updatedCharacter.getStrength());
        character.setDefense(updatedCharacter.getDefense());
        character.setCategory(updatedCharacter.getCategory());

        return characterRepository.save(character);
    }

    public void deleteCharacter(Long id) {
        characterRepository.deleteById(id);
    }

    public Character addItemToCharacter(Long characterId, Item item) {
        Character character = getCharacterById(characterId);

        if (item.getItemType() == ItemType.Amuleto) {
            boolean alreadyHasAmulet = character.getItems().stream()
                    .anyMatch(existingItem -> existingItem.getItemType() == ItemType.Amuleto);

            if (alreadyHasAmulet) {
                throw new IllegalArgumentException("O personagem já possui um amuleto.");
            }
        }

        item.setCharacter(character);
        itemRepository.save(item);

        character.addItem(item);
        return characterRepository.save(character);
    }

    public int getTotalStrength(Character character) {
        int itemStrength = character.getItems().stream()
                .map(Item::getStrength)
                .reduce(0f, int::sum);
        return character.getStrength() + itemStrength;
    }

    public int getTotalDefense(Character character) {
        int itemDefense = character.getItems().stream()
                .map(Item::getDefense)
                .reduce(0f, int::sum);
        return character.getDefense() + itemDefense;
    }
}
