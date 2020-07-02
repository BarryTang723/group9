package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
//动态代理lenovo,实现通过代理商买电脑
public class ProxyTest {
	public static void main(String[] args) {
		Lenovo lenovo = new Lenovo();
		SaleComputer proxy_lenovo=(SaleComputer)Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
//				System.out.println("invoke内部哈哈哈哈我在呃呃呃");
//				System.out.println(method.getName());
//				System.out.println(args[0]);
				if(method.getName().equals("sale")) {
					double money=(double)args[0];
					money=money*0.85;
					System.out.println("专车接你..");
					Object obj= method.invoke(lenovo, money);
					System.out.println("免费送货...");
					return obj+",白送一个鼠标垫";
				}else {
					Object obj= method.invoke(lenovo, args);
					return obj;
				}
				
				
				
			}
		});//调用任何代理对象的方法都会执行invoke,返回值也是invoke的返回值
		String computer = proxy_lenovo.sale(8000);
		System.out.println(computer);
		proxy_lenovo.show();
	}
}
