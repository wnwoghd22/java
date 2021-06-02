public class GeneralAccount extends Account {
	GeneralAccount() {
		super();
	}

	@Override
	public void ShowInfo() {
		System.out.println("General : ");
		super.ShowInfo();
	}
}