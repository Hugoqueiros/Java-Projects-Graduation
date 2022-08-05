package projeto7;

public class Caixa {
    
    private Object elem;
    
    public Caixa(){
        elem = null;
    }
    
    public void guarda(Object obj){
        elem = obj;
    }
    
    public Object consulta(){
        return elem;
    }
    
    public Object retira(){
        Object r = elem;
        elem = null;
        return r;
    }
    
    public boolean vazio(){
        return elem == null;
    }
}
