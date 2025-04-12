package example.roleplaying;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int strength;

    private int defense;

    @Enumerated(EnumType.STRING)
    private ItemType itemType;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "character_id")
    private Character character;

    public Item() {}

    public Item(Long id, String name, int strength, int defense, ItemType itemType, Character character) {
        this.id = id;
        this.name = name;
        this.strength = strength;
        this.defense = defense;
        this.itemType = itemType;
        this.character = character;
    }

    // getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getDefense() {
        return defense;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public Character getCharacter() {
        return character;
    }

    // setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
}
