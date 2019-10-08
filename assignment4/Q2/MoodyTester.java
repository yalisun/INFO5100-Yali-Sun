package Q2;

abstract class Moody {
	protected abstract String getMoody();
	protected abstract void expressFeelings();

	protected void queryMood() {
		System.out.println("I feel " + getClass().getSimpleName() + " today!\n");
	}
}

class Sad extends Moody {

	@Override
	protected String getMoody() {
		return getClass().getSimpleName();
	}

	@Override
	protected void expressFeelings() {
		System.out.println("'wah' 'boo hoo' 'weep' 'sob' 'weep'");
	}

	public String toString() {
		return "Subject cries a lot";
	}
}

class Happy extends Moody {

	@Override
	protected String getMoody() {
		return getClass().getSimpleName();
	}

	@Override
	protected void expressFeelings() {
		System.out.println("hehehe...hahaha...HAHAHAHAHA!!!");
	}

	public String toString() {
		return "Subject laughs a lot\n";
	}
}

class Psychiatrist {
	public void examine(Moody moody) {
		System.out.println("How are you feeling today?");
		moody.queryMood();
	}

	public void observe(Moody moody) {
		moody.expressFeelings();
		System.out.println("Observation: " + moody.toString());
	}
}

public class MoodyTester {
	public static void main(String[] args) {
		Psychiatrist pc = new Psychiatrist();
		Moody sad = new Sad();
		Moody happy = new Happy();
		pc.examine(happy);
		pc.observe(happy);
		pc.examine(sad);
		pc.observe(sad);
	}
}
