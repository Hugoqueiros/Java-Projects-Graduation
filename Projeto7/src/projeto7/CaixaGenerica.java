package projeto7;

import java.util.ArrayList;

public class CaixaGenerica <E> {
    
    private E elem;
    
    public CaixaGenerica(){
        elem = null;
    }
    
    public void guarda(E obj){
        elem = obj;
    }
    
    public E consulta(){
        return elem;
    }
    
    public E retira(){
        E r = elem;
        elem = null;
        return r;
    }
    
    public boolean vazio(){
        return elem == null;
    }
}
