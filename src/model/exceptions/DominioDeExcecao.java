package model.exceptions;

//Classe RuntimeException - não obriga o programador a tratar a exceção, porém o programa pode quebrar caso ocorra a exceção.
//Classe Exception        - obriga o programador a tratar exceção. 
public class DominioDeExcecao extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DominioDeExcecao(String msg) {
		super(msg);
	}
}
