# Cumulative Poetry

We are building a product that will be used in poetry classes. We target a poetry of a form called as cumulative poetry. The functionality is broken down into releases and its recommended that you approach the problem incrementally.

**Business needs**

Cumulative poetry shows itself little by little. It’s much like unfolding a tale. The one taught in the class goes like -

+ Day 1
```
This is the house that Jack built.
```

+ Day 2
```
This is the malt that lay in
    the house that Jack built.
```

+ Day 3
```
This is the rat that ate
    the malt that lay in
    the house that Jack built.
```

And so on, as you see the tale is unfolded little by little every day. The whole tale is unfolded on,

+ Day 12
```
This is the horse and the hound and the horn that belonged to
    the farmer sowing his corn that kept
    the rooster that crowed in the morn that woke
    the priest all shaven and shorn that married
    the man all tattered and torn that kissed
    the maiden all forlorn that milked
    that cow with the crumpled horn that tossed
    the dog that worried
    the cat that killed
    the rat that ate
    the malth that lay in
    the house that Jack built.
```
___

**Technical needs**

Note: The given compilation done in jar executables so kindly use the jar files attached in this applicaiton to run the given test cases in the command line.

if you want to create the jar files on your own please kindly follow the below instructions:

`$jar cvfm Poet.jar MANIFEST.MF cumulative/poetry`

The above command should be excuted inside the src/main/java then the jar file will get created in the saem directory itself.
The MANIFEST.MF file should be passed to the creation the jar files (above command). this file can be found in the same directory where you are creating the jar file.

Note for jar creation you can use command line operations or you can create a target yourself in the gradle which will create the jar file in the required folder build/libs/<projectname>.jar

which you can find it in the build.gradle file :)

Flags supported
- `--reveal-for-day for_which_day` : Reveals the tale up till that day
- `--recite` : Recites the whole tale with a day wise breakage

Example usage:

`$ java -jar poetry-class.jar --reveal-for-day 1`
```
This is the house that Jack built.
```

`$ java -jar poetry-class.jar --reveal-for-day 2`
```
This is the malt that lay in
    the house that Jack built.
```

`$ java -jar poetry-class.jar --recite`
```
Day 1 -
This is the house that Jack built.

Day 2 -
This is the malt that lay in
    the house that Jack built.

... // There will be a tale for everyday
...

Day 12 -
This is the horse and the hound and the horn that belonged to
    the farmer sowing his corn that kept
    the rooster that crowed in the morn that woke
    the priest all shaven and shorn that married
    the man all tattered and torn that kissed
    the maiden all forlorn that milked
    that cow with the crumpled horn that tossed
    the dog that worried
    the cat that killed
    the rat that ate
    the malth that lay in
    the house that Jack built.

```

## Expectation from release 2

The poetry class wants each line to echo twice, if the flag is specified. Else retain the default behaviors. The purpose is that the poetry starts reading more like a song.

**Technical expecations**

1. Support the new flags as shown below

Flags supported
- `--reveal-for-day for_which_day [--echo]` : Reveals the tale up till that day, with an optional echo
- `--recite [--echo]` : Recites the whole tale with a day with an optional echo

Example usage:

`$ java -jar poetry-class.jar --reveal-for-day 1`
```
This is the house that Jack built.
```

`$ java -jar poetry-class.jar --echo --reveal-for-day 1`
```
This is the house that Jack built
    the house that Jack built.
```

`$ java -jar poetry-class.jar --echo --reveal-for-day 2`
```
This is the malth that lay in
    the malth that lay in
    the house that Jack built
    the house that Jack built.
```

`$ java -jar poetry-class.jar --echo --recite`
```
Day 1 -
This is the house that Jack built
    the house that Jack built.

Day 2 -
This is the malth that lay in
    the malth that lay in
    the house that Jack built
    the house that Jack built.

... // There will be a tale for everyday
...

Day 12 -
This is the horse and the hound and the horn that belonged to
    the horse and the hound and the horn that belonged to
    the farmer sowing his corn that kept
    the farmer sowing his corn that kept
    the rooster that crowed in the morn that woke
    the rooster that crowed in the morn that woke
    the priest all shaven and shorn that married
    the priest all shaven and shorn that married
    the man all tattered and torn that kissed
    the man all tattered and torn that kissed
    the maiden all forlorn that milked
    the maiden all forlorn that milked
    that cow with the crumpled horn that tossed
    that cow with the crumpled horn that tossed
    the dog that worried
    the dog that worried
    the cat that killed
    the cat that killed
    the rat that ate
    the rat that ate
    the malth that lay in
    the malth that lay in
    the house that Jack built.
    the house that Jack built.
```


