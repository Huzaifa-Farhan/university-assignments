public class Rank {
    enum Cards {zero, ace, two, three, four, five, six, seven, eight, nine, jack, queen, king}
    public static void main(String[] args) {
        Rank.Cards highCard = Rank.Cards.ace;
        Rank.Cards faceCard = Rank.Cards.king;
        Rank.Cards card1 = Rank.Cards.two;
        Rank.Cards card2 = Rank.Cards.eight;
        System.out.println("A blackjack Hand: " + highCard+ " and " + faceCard+ "\t");
        int card1Val = card1.ordinal();
        int card2Val = card2.ordinal();
        System.out.println("A two hand card: " + card1 + " and " + card2 + "\n" + "Hand Value: " + (card1Val+card2Val));
}

}