public class Person {
    public String name;
    void setName (String name){
        this.name = name;
    }
    public String endereco;
    void setEndereco (String endereco){
        this.endereco = endereco;
    }
    public long idade;

    public void setIdade(long idade) {
        this.idade = idade;
    }
    public long matricula;

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

    public String sexo;

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    String getName(){
        return name;
    }
    String getEndereco(){
        return endereco;
    }

    float getIdade(){
        return idade;
    }
    String getSexo(){
        return sexo;
    }
    float getMatricula() { return matricula; }
}