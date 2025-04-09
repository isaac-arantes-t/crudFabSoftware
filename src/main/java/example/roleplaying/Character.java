package example.roleplaying;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 1000)
    private String nomeAdventurer;

    private int level;

    private float strength;

    private float defense;

    @Enumerated(EnumType.STRING)
    @Column(updatable = false)
    private Category category;

    @OneToMany(mappedBy = "character", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> items = new ArrayList<>();

    public Character() {}

    public Character(Long id, String name, String nomeAdventurer, int level, float strength, float defense, Category category) {
        this.id = id;
        this.name = name;
        this.nomeAdventurer = nomeAdventurer;
        this.level = level;
        this.strength = strength;
        this.defense = defense;
        this.category = category;
    }

    // getters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return nomeAdventurer;
    }

    public int getLevel() {
        return level;
    }

    public float getStrength() {
        return strength;
    }

    public float getDefense() {
        return defense;
    }

    public Category getCategory() {
        return category;
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }

    // setters

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String nomeAdventurer) {
        this.nomeAdventurer = nomeAdventurer;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setStrength(float strength) {
        this.strength = strength;
    }

    public void setDefense(float defense) {
        this.defense = defense;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void addItem(Item item) {
        item.setCharacter(this);
        this.items.add(item);
    }

    public void removeItem(Item item) {
        item.setCharacter(null);
        this.items.remove(item);
    }
}
