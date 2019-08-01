package cumulative.poetry;

public class Poet {
    public static final String[] tot = new String[]{"house that Jack built", "malth that lay in", "rat that ate", "cat that killed", "dog that worried", "cow with the crumpled horn that tossed", "maiden all forlorn that milked", "man all tattered and torn that kissed", "priest all shaven and shorn that married", "rooster that crowed in the morn that woke", "farmer sowing his corn that kept", "horse and the hound and the horn that belonged to"};

    public Poet() {
    }

    public String recite(int tillday) {
        StringBuilder s = new StringBuilder();
        String var10001 = tot[tillday - 1];
        s.append("This is the " + var10001 + "\n");

        for(int i = tillday - 2; i >= 0; --i) {
            var10001 = tot[i];
            s.append(" the " + var10001 + "\n");
        }

        return s.toString();
    }

    public static void main(String[] args) {
        Poet p = new Poet();
        if (args.length == 2) {
            System.out.println(p.recite(Integer.parseInt(args[1])));
        } else {
            for(int i = 1; i < tot.length; ++i) {
                System.out.println("Day " + i);
                System.out.println(p.recite(i));
            }
        }

    }
}

