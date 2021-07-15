package Interface.copy;

public interface FactoryAbstracta {
	IConnection getBD(String motor);
	IConnectionREST getREST(String area);
}
