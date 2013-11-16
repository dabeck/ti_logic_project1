public class Negation extends Formula {

    private Formula arg;

    public Negation(Formula f) {
    	arg = f;
    }

    public Formula get_arg() {
    	return arg;
    }
}
