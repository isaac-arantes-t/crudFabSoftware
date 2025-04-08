package example.roleplaying;

import jakarta.persistence.*;
import jdk.jfr.Category;

public class Item {
    @Entity
    public class Book {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        @Enumerated(EnumType.STRING)
        private Category category;

        @ManyToOne
        @JoinColumn(name = "character_id")
        private Character character;
    }
}
