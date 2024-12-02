package factory;

import java.io.IOException;

public class ConceteCreatorA extends Creator {

	@Override
	public Product factoryMethode(String Typ) throws IOException {
		// TODO Auto-generated method stub
		return new ConcreteProductA();
	}

}
