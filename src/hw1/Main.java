package hw1;

public class Main {
    public static void main(String[] args) {
        Teams[] team = {
            new Cat("Мурзик", 60, 10),
            new Robot("Электро", 100, 1),
            new Human("Гриша", 40, 2),
            new Robot("Х700", 70, 15),
            new Cat("Барсик", 50, 7)
        };

        Barrier[] track = {
                new Track(60),
                new Track(40)
        };

        Barrier[] wall = {
                new Wall(4),
                new Wall(7)
        };

        for (Teams r : team){
            for (int i = 0; i < track.length; i++) {
               r.runing((Track) track[i]);
               r.jumping((Wall) wall[i]);
            }
        }


    }
}
