package example.roleplaying;

import jakarta.persistence.*;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 1000)
    private String nomeAventurer;

    private int level;

    private float strength;

    private float defense;

    @Enumerated(EnumType.STRING)
    @Column(updatable = false)
    private Category category;

    @OneToMany(mappedBy = "character", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> items = new ArrayList<>();

    public Character(Long id, String name, String nomeAdventurer, int level, float strength, float defense, Category category) {
        this.id = id;
        this.name = name;
        this.nomeAventurer = nomeAdventurer;
        this.level = level;
        this.strength = strength;
        this.defense = defense;
        this.category = category;
    }

    public Object getName() {
        return null;
    }

    public Object getDescription() {
        return null;
    }

    public void setName(Object name) {
    }

    public void setDescription(Object description) {
    }

    public void setCharacter(Character character) {
    }
}