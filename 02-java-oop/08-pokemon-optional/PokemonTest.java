public class PokemonTest{
    public static void main(String[] args) {
        Pokemon p1 = new Pokemon("Bugsy", 100, "worf");
        Pokemon p2 = new Pokemon("Mogly", 80, "weazle");
        p1.getName();
        Pokemon.numOfPokemon();
        p1.attackPokemon(p2);
        p2.getHealth();
        p2.setName("Caden");
        p2.getName();



    }
}