import java.util.function.Predicate;

public class RhombusOfStarsFromMarto {

    private int size;

   // public RombOfStars(int size) {
   //     this.size = size;
   // }

    public String buildString() {
        return printMultipleRows(1, size, +1) +
                printMultipleRows(size - 1, 1, -1);
    }

    private String printMultipleRows(int start, int end, int step) {
        StringBuilder out = new StringBuilder();

        Predicate<Integer> loopCondition = iter -> {
            if (step > 0) {
                return iter <= end;
            }
            return iter >= end;
        };

        for (int r = start; loopCondition.test(r); r += step) {
            out.append(printLine(size - r, r))
                    .append(System.lineSeparator());
        }

        return out.toString();
    }

    private String printLine(int spaces, int stars) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < spaces; i++) {
            out.append(" ");
        }

        for (int i = 0; i < stars; i++) {
            out.append("* ");
        }

        return out.toString();
    }
}

