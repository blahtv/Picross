public class PuzzleData {
    private static boolean x = true;
    private static boolean o = false;


    public static boolean[][] puzzle1(){
        return new boolean[][]{
        {o, o,  o,  o,  o,  o,  o,  o,  o,  o},
        {o, x,  x,  o,  o,  o,  o,  x,  x,  o},
        {o, x,  x,  o,  o,  o,  o,  x,  x,  o},
        {o, x,  x,  o,  o,  o,  o,  x,  x,  o},
        {o, x,  x,  o,  o,  o,  o,  x,  x,  o},
        {o, o,  o,  o,  o,  o,  o,  o,  o,  o},
        {x, x,  o,  o,  o,  o,  o,  o,  x,  x},
        {x, x,  x,  x,  x,  x,  x,  x,  x,  x},
        {o, x,  x,  x,  x,  x,  x,  x,  x,  o},
        {o, o,  x,  x,  x,  x,  x,  x,  o,  o}
        };
    };

    public static boolean[][] puzzle2(){
        return new boolean[][]{
        {o, o,  o,  o,  o,  o,  o,  o,  o,  o},
        {o, x,  x,  x,  o,  o,  x,  x,  x,  o},
        {x, x,  x,  x,  x,  x,  x,  x,  x,  x},
        {x, x,  o,  o,  x,  x,  x,  x,  x,  x},
        {x, x,  x,  o,  x,  x,  x,  x,  x,  x},
        {x, x,  x,  x,  x,  x,  x,  x,  x,  x},
        {o, x,  x,  x,  x,  x,  x,  x,  x,  o},
        {o, o,  x,  x,  x,  x,  x,  x,  o,  o},
        {o, o,  o,  x,  x,  x,  x,  o,  o,  o},
        {o, o,  o,  o,  x,  x,  o,  o,  o,  o}
        };
    };

    public static boolean[][] puzzle3(){
        return new boolean[][]{
        {o, o,  x,  x,  o,  o,  x,  x,  o,  o},
        {o, o,  x,  x,  o,  o,  x,  x,  o,  o},
        {o, o,  x,  x,  o,  o,  x,  x,  o,  o},
        {o, o,  x,  x,  o,  o,  x,  x,  o,  o},
        {o, x,  x,  x,  x,  x,  x,  x,  x,  o},
        {x, x,  x,  x,  x,  x,  x,  x,  x,  x},
        {x, x,  x,  x,  x,  x,  x,  x,  x,  x},
        {x, x,  o,  x,  x,  x,  x,  o,  x,  x},
        {o, x,  x,  x,  o,  o,  x,  x,  x,  o},
        {o, o,  x,  x,  x,  x,  x,  x,  o,  o}
        };
    };

    public static boolean[][] puzzle4(){
        return new boolean[][]{
        {o, o,  x,  o,  x,  o,  o,  o,  o,  o},
        {o, x,  x,  o,  x,  x,  o,  o,  o,  o},
        {o, x,  x,  x,  x,  x,  o,  o,  o,  o},
        {x, x,  o,  x,  o,  x,  x,  o,  o,  x},
        {o, x,  x,  x,  x,  x,  o,  o,  x,  x},
        {o, o,  x,  x,  x,  o,  o,  o,  x,  o},
        {x, x,  x,  x,  x,  x,  o,  o,  x,  x},
        {x, o,  x,  x,  x,  x,  x,  x,  o,  x},
        {o, o,  x,  x,  x,  x,  x,  x,  x,  x},
        {o, x,  x,  o,  x,  x,  x,  x,  o,  o}
        };
    }

    public static boolean[][] puzzle5(){
        return new boolean[][]{
        {o, o,  o,  x,  o,  o,  o,  x,  o,  o},
        {o, o,  x,  x,  x,  o,  x,  x,  x,  o},
        {o, o,  x,  x,  x,  o,  x,  x,  x,  o},
        {o, o,  o,  x,  o,  o,  o,  x,  o,  o},
        {o, x,  x,  x,  o,  x,  x,  x,  x,  o},
        {o, x,  x,  x,  o,  x,  x,  x,  x,  o},
        {o, o,  o,  x,  o,  o,  o,  x,  o,  o},
        {x, x,  x,  x,  x,  x,  x,  x,  x,  x},
        {o, x,  x,  x,  x,  x,  x,  x,  x,  x},
        {o, o,  x,  x,  x,  x,  x,  x,  x,  o}
        };
    }

    public static boolean[][] puzzle6(){
        return new boolean[][]{
        {o, o,  o,  o,  o,  o,  o,  o,  o,  x,  x,  x,  o,  o,  o},
        {o, o,  o,  o,  o,  o,  o,  o,  x,  x,  x,  x,  x,  o,  o},
        {o, o,  o,  o,  o,  o,  o,  x,  x,  x,  x,  o,  x,  x,  x},
        {o, o,  o,  o,  o,  o,  o,  x,  x,  x,  x,  x,  x,  x,  o},
        {o, o,  o,  o,  o,  o,  o,  o,  x,  x,  x,  x,  x,  o,  o},
        {o, o,  o,  o,  o,  o,  o,  o,  o,  x,  x,  x,  o,  o,  o},
        {o, o,  o,  o,  o,  o,  o,  o,  x,  x,  x,  x,  x,  o,  o},
        {x, o,  o,  o,  o,  o,  x,  x,  x,  x,  x,  x,  x,  x,  o},
        {x, x,  x,  o,  o,  x,  x,  x,  o,  o,  o,  x,  x,  x,  o},
        {x, x,  x,  x,  x,  x,  x,  o,  x,  x,  x,  o,  x,  x,  o},
        {o, x,  x,  x,  x,  x,  o,  x,  x,  x,  x,  o,  x,  x,  o},
        {o, x,  x,  x,  x,  x,  x,  x,  x,  o,  o,  x,  x,  o,  o},
        {o, o,  x,  x,  x,  x,  x,  x,  x,  x,  x,  x,  o,  o,  o},
        {o, o,  o,  o,  x,  x,  o,  x,  x,  x,  o,  o,  o,  o,  o},
        {o, o,  o,  o,  o,  o,  x,  x,  x,  x,  x,  x,  o,  o,  o}
        };
    }

    public static boolean[][] puzzle7(){
        return new boolean[][]{
        {o, o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o},
        {o, o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o},
        {o, o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o},
        {o, o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o},
        {o, o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o},
        {o, o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o},
        {o, o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o},
        {o, o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o},
        {o, o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o},
        {o, o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o},
        {o, o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o},
        {o, o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o},
        {o, o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o},
        {o, o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o},
        {o, o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o,  o}
        };
    }
}
