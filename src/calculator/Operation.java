package calculator;

public enum Operation {

    ADD('+'), SUB('-'), MUL('*'), DIV('/');

    private final char symbol;

    Operation(char symbol) {
        this.symbol = symbol;
    }

    public static Operation valueOf(char symbol) {
        for (Operation i : Operation.values()) {
            if (i.symbol == symbol) {
                return i;
            }
        }
        return null;

    }

}
