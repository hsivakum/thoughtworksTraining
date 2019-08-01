package cumulative.poetry;

import java.util.Arrays;

public class Poet {
    public static final String[] tot = new String[]{"house that Jack built", "malth that lay in", "rat that ate", "cat that killed", "dog that worried", "cow with the crumpled horn that tossed", "maiden all forlorn that milked", "man all tattered and torn that kissed", "priest all shaven and shorn that married", "rooster that crowed in the morn that woke", "farmer sowing his corn that kept", "horse and the hound and the horn that belonged to"};

    public Poet() {
    }


    public String recite(int tillday,boolean cond)
    {
        StringBuilder s = new StringBuilder();
        s.append("This is the " + tot[tillday-1] + "\n");

        if(cond)
        {
            s.append(" the "+tot[tillday-1]+"\n");
        }
        for(int i = tillday - 2; i >= 0; --i) {
            String add = " the " + tot[i] + "\n";
            s.append(add);
            if(cond)
            {
                s.append(add);
            }
        }

        return s.toString();
    }

    public static void main(String[] args) {
        Poet p = new Poet();
        boolean echo = Arrays.asList(args).contains("--echo");
        boolean reveal_for_day = Arrays.asList(args).contains("--reveal-for-day");
        boolean recite = Arrays.asList(args).contains("--recite");
        System.out.println(echo);
        if (args.length >= 2 && reveal_for_day) {
            System.out.println(p.recite(Integer.parseInt(args[1]),echo));
        } else if(args.length<=2 && recite)
        {
            for(int i = 1; i < tot.length; ++i) {
                System.out.println("Day " + i);
                System.out.println(p.recite(i,echo));
            }
        }

    }
}

