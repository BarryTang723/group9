package proxy;

public class Lenovo implements SaleComputer{

	@Override
	public String sale(double money) {
		// TODO Auto-generated method stub
		System.out.println("花了"+money+"元买了一台联想电脑");
		return "联想电脑";
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("展示电脑...");
	}
	
}
