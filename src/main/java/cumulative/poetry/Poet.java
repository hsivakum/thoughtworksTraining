package cumulative.poetry;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

public class Poet {
    public static int seedVal = 0;
    public static Random r;
    public static int reveal_for_date =0;
    public static boolean reveal_for_day = false;
    public static boolean recite = false;

    public static final String[] tot = new String[]{"house that Jack built", "malth that lay in", "rat that ate", "cat that killed", "dog that worried", "cow with the crumpled horn that tossed", "maiden all forlorn that milked", "man all tattered and torn that kissed", "priest all shaven and shorn that married", "rooster that crowed in the morn that woke", "farmer sowing his corn that kept", "horse and the hound and the horn that belonged to"};

    public Poet() {
    }

    public List<Integer> getRand(boolean seed)
    {
        r = new Random();

       if(seedVal!=0)
       {
           r.setSeed(seedVal);
       }
       else
       {
           seedVal = r.nextInt(500);
           r.setSeed(seedVal);
       }

       List<Integer> ob = new ArrayList<>();
       while(true)
       {
           if(ob.size()==11)
           {
               break;
           }
           else
           {
               int ans = r.nextInt(11)+1;
               if(ob.contains(ans))
               {
                   continue;
               }
               else
               {
                   ob.add(ans);
               }
           }
       }

       return ob;

    }


    public String recite(int tillday,boolean echo,boolean random,boolean seed)
    {
        List<Integer> temp = getRand(seed);

        StringBuilder s = new StringBuilder();
        if(tillday==0)
        {
            for(int i = 1; i <= tot.length; ++i) {
                s.append("Day " + i + "\n" + recite(i, echo, random, seed) + "\n");
            }
        }
        else {

            List<Integer> sample1 = temp.subList(0, tillday - 1);



            String[] arr;
            s.append("This is the " + tot[tillday - 1] + "\n");

            for (int i = tillday - 2; i >= 0; --i) {
                String add = " the " + tot[i] + "\n";
                s.append(add);
            }

            if (random) {

                s.setLength(0);
                for (int i = 0; i < sample1.size(); i++) {
                    if (i == 0) {
                        s.append("This is the " + tot[sample1.get(i)] + "\n");
                    } else {
                        s.append(" the " + tot[sample1.get(i)] + "\n");
                    }
                }
                s.append(" the " + tot[0]);

            }

            arr = s.toString().split("\n");

            if (echo) {
                s.setLength(0);
                int iterationIndex = 0;
                for (String o : arr) {

                    if (iterationIndex == 0) {
                        s.append(o + "\n");
                        o = o.replace("This is the ", " the ");
                        s.append(o + "\n");
                    } else {
                        s.append(o + "\n");
                        s.append(o + "\n");
                    }
                    iterationIndex++;


                }
            }

        }
        StringBuilder te = new StringBuilder();
            if(random || seed) {
                te.append("Seed Used - " + seedVal+"\n");
                te.append(s);
            }
            else
            {
                te = s;
            }

            return te.toString();

    }

    public static void main(String[] args) {

        Poet p = new Poet();

        boolean echo = Arrays.asList(args).contains("--echo");
        reveal_for_day = Arrays.asList(args).contains("--reveal-for-day");
        recite = Arrays.asList(args).contains("--recite");
        boolean random = Arrays.asList(args).contains("--random");
        boolean seed = Arrays.asList(args).contains("--seed");

        if(seed)
        {
           seedVal = Integer.parseInt(args[Arrays.asList(args).indexOf("--seed")+1]);
        }

        if(reveal_for_day)
        {
            reveal_for_date = Integer.parseInt(args[Arrays.asList(args).indexOf("--reveal-for-day")+1]);
        }
        if(reveal_for_day && !recite)
        {
            System.out.println(p.recite(reveal_for_date,echo,random,seed));
        }
        else if(recite && !reveal_for_day)
        {
            System.out.println(p.recite(reveal_for_date,echo,random,seed));
        }

    }
}

