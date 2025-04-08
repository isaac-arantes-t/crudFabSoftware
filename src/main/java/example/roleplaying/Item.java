package example.roleplaying;

import jakarta.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private float strength;

    private float defense;

    @Enumerated(EnumType.STRING)
    private ItemType itemType;

    @ManyToOne
    @JoinColumn(name = "character_id")
    private Character character;

    public Item(Long id, String name, float strength, float defense, ItemType itemType, Character character) {
        this.id = id;
        this.name = name;
        this.strength = strength;
        this.defense = defense;
        this.itemType = itemType;
        this.character = character;
    }
}
