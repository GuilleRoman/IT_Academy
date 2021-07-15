package Interface;

public interface FactoryAbstracta {
	IConnection getBD(String motor);
	IConnectionREST getREST(String area);
}
