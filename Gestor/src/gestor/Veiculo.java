
package gestor;


public class Veiculo {
    
    private String matricula;
    private String marca;
    private String modelo; 
    public int quilometros;
    
    public Veiculo(){
        
        matricula= "";
        marca="";
        modelo="";
        quilometros=0;    
}
     public Veiculo ( String matricula, String marca, String modelo, int quilometros){
        this.matricula= matricula;
        this.marca=marca;
        this.modelo=modelo;
        this.quilometros=quilometros;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getQuilometros() {
        return quilometros;
    }

    public void setQuilometros(int quilometros) {
        this.quilometros = quilometros;
    }
     
    @Override
    public String toString(){
        return "" + matricula + ". " + marca + " ." + modelo + " ." + quilometros+ " .";
    } 
    
       public void print(){
        System.out.println( matricula + ". " + marca + ". " + modelo + ". " + quilometros); 
    }
}

    
    

