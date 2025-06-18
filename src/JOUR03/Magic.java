package JOUR03;

public class Magic {
    public static void main(String[] args) {
        // create deck
        Deck deck = new Deck();

        // add Card until the deck is full
        deck.addCard(new LandCard(LandCard.Color.BLUE));
        deck.addCard(new CreatureCard("Dragon", 10, 10));
        deck.addCard(new SpellCard("Fireball", "A fireball that deals 10 damage to any target."));
        deck.addCard(new LandCard(LandCard.Color.RED));
        deck.addCard(new CreatureCard("Goblin", 2, 2));
        deck.addCard(new SpellCard("Lightning bolt", "A bolt of lightning that deals 2 damage to any target."));
        deck.addCard(new LandCard(LandCard.Color.GREEN));
        deck.addCard(new CreatureCard("Orc", 3, 3));
        deck.addCard(new SpellCard("Fireball", "A fireball that deals 3 damage to any target."));
        deck.addCard(new LandCard(LandCard.Color.WHITE));
        deck.addCard(new LandCard(LandCard.Color.WHITE));

        // play and print all cards
        for (int i = 0; i < 10; i++) {
            Card card = deck.playCard();
            if (card != null) {
                System.out.println(card.toString());
            }
        }

    }
}

abstract class Card {
    public Card() {}
    public String toString() {
        return "";
    }
}

class LandCard extends Card {
    public enum Color {
        WHITE, BLUE, GREEN, RED, BLACK
    }

    private Color color;
    final int cost = 0;

    public LandCard(Color color) {
        super();
        this.color = color;
        System.out.println("Card type : Land");
    }

    @Override
    public String toString() {
        return "\nLandCard : \ncolor : " + this.color + "\ncost : " + this.cost;
    }
}

class CreatureCard extends Card {
    private String name;
    private int damage;
    private int health;
    final int cost = 3;

    public CreatureCard(String name, int damage, int health) {
        super();
        this.name = name;
        this.damage = damage;
        this.health = health;
        System.out.println("Card type : Creature");
    }

    @Override
    public String toString() {
        return "\nCreatureCard : \nname : " + this.name + "\ndamage : " + this.damage + "\nhealth : " + this.health +
                "\ncost : " + this.cost;
    }
}

class SpellCard extends Card {
    private String name;
    private String description;
    final int cost = 1;

    public SpellCard(String name, String description) {
        super();
        this.name = name;
        this.description = description;
        System.out.println("Card type : Spell");
    }

    @Override
    public String toString() {
        return "\nSpellCard : \nname : " + this.name + "\ndescription : " + this.description + "\ncost : " + this.cost;
    }
}

class Deck {
    private Card[] cards = new Card[10];

    public Deck() {
        for (int i = 0; i < cards.length; i++) {
            cards[i] = null;
        }
    }

    public void addCard(Card card) {
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] == null) {
                cards[i] = card;
                return;
            }
        }
        System.out.println("The deck is full !");
    }

    public Card playCard() {
        for (int i = 0; i < cards.length; i++) {
            if( cards[i] != null) {
                Card playedCard = cards[i];
                cards[i] =null;
                return playedCard;
            }
        }
        return null;
    }

}
