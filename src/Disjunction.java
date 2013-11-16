public class Disjunction extends Formula {

    private Formula left_arg, right_arg;

    public Disjunction(Formula f, Formula g) {
		left_arg = f;
		right_arg = g;
    }

    public Formula getLeftArg() {
    	return left_arg;
    }

    public Formula getRightArg() {
    	return right_arg;
    }
}
