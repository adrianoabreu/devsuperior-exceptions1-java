package model.exceptions;

//Classe RuntimeException - n�o obriga o programador a tratar a exce��o, por�m o programa pode quebrar caso ocorra a exce��o.
//Classe Exception        - obriga o programador a tratar exce��o. 
public class DominioDeExcecao extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DominioDeExcecao(String msg) {
		super(msg);
	}
}
