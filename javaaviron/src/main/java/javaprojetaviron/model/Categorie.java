package javaprojetaviron.model;

public enum Categorie {

    MINIME(1500, 10),
    CADET (3000, 14),
    JUNIOR(4000, 18),
    SENIOR(6000, 40),
    VETERANT(6000, 200);

    private int nb_max_m;
    private int max_age;

    public int getNb_max_m() {
        return nb_max_m;
    }

    public int getMax_age() {
        return max_age;
    }

    private Categorie(int nb_max_km, int max_age) {
        this.nb_max_m = nb_max_km;
        this.max_age = max_age;
    }

    public static Categorie getCategorie(String type){
        return switch (type) {
            case "M" -> Categorie.MINIME;
            case "C" -> Categorie.CADET;
            case "J" -> Categorie.JUNIOR;
            case "S" -> Categorie.SENIOR;
            case "V" -> Categorie.VETERANT;
            default -> null;
        };
    }
}
