public class Biimplication extends Formula {

    private Formula left_arg, right_arg;

    public Biimplication(Formula f, Formula g) {
    	left_arg = f;
    	right_arg = g;
    }

    public Formula get_left_arg() {
    	return left_arg;
    }

    public Formula get_right_arg() {
    	return right_arg;
    }
}
