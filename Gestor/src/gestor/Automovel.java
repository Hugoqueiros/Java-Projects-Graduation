
package gestor;


public class Automovel extends Veiculo {
    private int lugares;
    private int m_litros;
   
    //contrutores
    public Automovel(){
        this("","","",0,0,0);
}
    public Automovel(String matricula,String marca,String modelo,int quilometros,int lugares,int m_litros){
        super(matricula, marca, modelo, quilometros);
        this.lugares=lugares;
        this.m_litros= m_litros;
}

    public int getLugares(int lugares) {
        return lugares;
    }

    public void setLugares(int lugares) {
        this.lugares = lugares;
    }

    public int getM_litros() {
        return m_litros;
    }

    public void setM_litros(int m_litros) {
        this.m_litros = m_litros;
    }
    
    public int comparaquilometros(Automovel v){
        if (this.quilometros == v.quilometros)
            return 0;
        else if (this.quilometros > v.quilometros)
            return 1;
        else 
            return -1;
    }
  
    @Override
    public String toString() {
        return "Automovel{" + "Lugares=" + lugares + ", Litros=" + m_litros+ "}";
    }
    
    public void print(){
        super.print();
        System.out.println("Numero de lugares: "+lugares);
        System.out.println("Litros da mala: "+m_litros);
        
    }
     
}
     